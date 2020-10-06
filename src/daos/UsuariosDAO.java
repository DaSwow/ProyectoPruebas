package daos;
    
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import exceptions.DAOException;
import java.util.ArrayList;
import objetosnegocio.Usuario;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;
import org.bson.types.ObjectId;
/**
 *
 * @author Michael
 */
public class UsuariosDAO extends BaseDAO<Usuario> {

    @Override
    public void guardar(Usuario entidad) {
        MongoCollection<Usuario> coleccion = this.getCollection();
        coleccion.insertOne(entidad);
    }

    @Override
    public void eliminar(Usuario entidad) throws DAOException {
        Usuario usuario = this.buscarPorId(entidad.getId());
        if (usuario != null) {
            MongoCollection<Usuario> coleccion = this.getCollection();
            coleccion.deleteOne(eq("_id", entidad.getId()));
        }else{
            throw new DAOException(String.format("Usuario %s no encontrado", entidad.getId()));
        }
    }

    @Override
    public void actualizar(Usuario entidad) throws DAOException {
        MongoCollection<Usuario> coleccion = this.getCollection();
        coleccion.updateOne(
            eq("_id", entidad.getId()),
            combine(
                set("nombre", entidad.getNombre()),
                set("fechaDeNacimiento", entidad.getFechaDeNacimiento()),
                set("sexo", entidad.getSexo()),
                set("genMusicales", entidad.getGenMusicales()),
                set("genPeliculas", entidad.getGenPeliculas()),
                set("correo", entidad.getCorreo()),
                set("contraseña", entidad.getContraseña())
            )
        );
    }

    @Override
    public Usuario buscarPorId(ObjectId id) {
        MongoCollection<Usuario> coleccion = this.getCollection();
        Usuario usuario = coleccion.find(eq("_id", id)).first();
        return usuario;
    }
    
    public Usuario buscarPorId(String id) {
        return this.buscarPorId(new ObjectId(id));
    }
    
    public Usuario buscarPorCorreo(String correo){
        MongoCollection<Usuario> coleccion = this.getCollection();
        Usuario usuario = coleccion.find(eq("correo", correo)).first();
        return usuario;
    }

    @Override
    public ArrayList<Usuario> buscarTodos() {
        MongoCollection<Usuario> coleccion = this.getCollection();
        FindIterable<Usuario> usuarios = coleccion.find();
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        for (Usuario usuario: usuarios) {
            listaUsuarios.add(usuario);
        }
        return listaUsuarios;
    }

    @Override
    public MongoCollection<Usuario> getCollection() {
        MongoDatabase database = this.getMongoDatabase();
        MongoCollection<Usuario> collecionUsuarios = database.getCollection("usuarios", Usuario.class);
        return collecionUsuarios;
    }

}
