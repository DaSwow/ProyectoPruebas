package daos;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import exceptions.DAOException;
import java.util.ArrayList;
import objetosnegocio.Post;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;
import org.bson.types.ObjectId;
/**
 *
 * @author Michael
 */
public class PostsDAO extends BaseDAO<Post> {

    @Override
    public void guardar(Post entidad) {
        MongoCollection<Post> coleccion = this.getCollection();
        coleccion.insertOne(entidad);
    }
    

    @Override
    public void eliminar(Post entidad) throws DAOException {
        Post post = this.buscarPorId(entidad.getId());
        if (post != null) {
            MongoCollection<Post> coleccion = this.getCollection();
            coleccion.deleteOne(eq("_id", entidad.getId()));
        }else{
            throw new DAOException(String.format("Post %s no encontrado", entidad.getId()));
        }
    }
    
    @Override
    public void actualizar(Post entidad) throws DAOException {
        MongoCollection<Post> coleccion = this.getCollection();
        coleccion.updateOne(
            eq("_id", entidad.getId()),
            combine(
                set("contenido", entidad.getContenido()),
                set("fechaHora", entidad.getFechaHora()),
                set("tags", entidad.getTags()),
                set("comentarios", entidad.getComentarios())
            )
        );
    }

    @Override
    public Post buscarPorId(ObjectId id) {
        MongoCollection<Post> coleccion = this.getCollection();
        Post post = coleccion.find(eq("_id", id)).first();
        return post;
    }
    
    public Post buscarPorId(String id) {
        return this.buscarPorId(new ObjectId(id));
    }

    @Override
    public ArrayList<Post> buscarTodos() {
        MongoCollection<Post> coleccion = this.getCollection();
        FindIterable<Post> posts = coleccion.find();
        ArrayList<Post> listaPosts = new ArrayList<>();
        for (Post post: posts) {
            listaPosts.add(post);
        }
        return listaPosts;
    }

    @Override
    public MongoCollection<Post> getCollection() {
        MongoDatabase database = this.getMongoDatabase();
        MongoCollection<Post> collecionPosts = database.getCollection("posts", Post.class);
        return collecionPosts;
    }

}
