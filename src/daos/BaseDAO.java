
package daos;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import exceptions.DAOException;
import java.util.ArrayList;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;

/**
 *
 * @author Michael
 */
public abstract class BaseDAO<T> {
    
    /**
     * Cambiar nombre de la base de datos en caso de tenerlo repetido en Mongo
     */
    private static final String DATABASE_NAME = "Faceboot";
    
    /**
     * Codigo de interfaz para coneccion con base de datos de Mongo.
     * @return 
     */
    public MongoDatabase getMongoDatabase(){
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(), fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoClient mongoClient = new MongoClient("localhost", MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
        MongoDatabase database = mongoClient.getDatabase(BaseDAO.DATABASE_NAME);
        return database;
    }
    
    public abstract void guardar(T entidad);
    public abstract void eliminar(T entidad) throws DAOException;
    public abstract void actualizar(T entidad) throws DAOException;
    public abstract T buscarPorId(ObjectId id);
    public abstract ArrayList<T> buscarTodos();
    public abstract MongoCollection<T> getCollection();
    
}
