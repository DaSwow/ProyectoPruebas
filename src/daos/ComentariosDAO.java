package daos;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import exceptions.DAOException;
import java.util.ArrayList;
import objetosnegocio.Comentario;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;
import org.bson.types.ObjectId;
/**
 *
 * @author Michael
 */
public class ComentariosDAO extends BaseDAO<Comentario> {

    @Override
    public void guardar(Comentario entidad) {
        MongoCollection<Comentario> coleccion = this.getCollection();
        coleccion.insertOne(entidad);
    }

    @Override
    public void eliminar(Comentario entidad) throws DAOException {
        Comentario comentario = this.buscarPorId(entidad.getId());
        if (comentario != null) {
            MongoCollection<Comentario> coleccion = this.getCollection();
            coleccion.deleteOne(eq("_id", entidad.getId()));
        }else{
            throw new DAOException(String.format("Comentario %s no encontrado", entidad.getId()));
        }
    }

    @Override
    public void actualizar(Comentario entidad) throws DAOException {
        MongoCollection<Comentario> coleccion = this.getCollection();
        coleccion.updateOne(
            eq("_id", entidad.getId()),
            combine(
                set("fechaHora", entidad.getFechaHora()),
                set("contenido", entidad.getContenido())
            )
        );
    }

    @Override
    public Comentario buscarPorId(ObjectId id) {
        MongoCollection<Comentario> coleccion = this.getCollection();
        Comentario comentario = coleccion.find(eq("_id", id)).first();
        return comentario;
    }
    
    public Comentario buscarPorId(String id) {
        return this.buscarPorId(new ObjectId(id));
    }

    @Override
    public ArrayList<Comentario> buscarTodos() {
        MongoCollection<Comentario> coleccion = this.getCollection();
        FindIterable<Comentario> comentarios = coleccion.find();
        ArrayList<Comentario> listaComentarios = new ArrayList<>();
        for (Comentario comentario: comentarios) {
            listaComentarios.add(comentario);
        }
        return listaComentarios;
    }

    @Override
    public MongoCollection<Comentario> getCollection() {
        MongoDatabase database = this.getMongoDatabase();
        MongoCollection<Comentario> collecionComentarios = database.getCollection("comentarios", Comentario.class);
        return collecionComentarios;
    }

}
