package objetosnegocio;

import java.time.LocalDateTime;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author Michael
 */
public class Comentario {
    
    private ObjectId id;
    private LocalDateTime fechaHora;
    private String contenido;
    private Usuario usuario;
    private ObjectId idPost;

    public Comentario() {
    }

    public Comentario(ObjectId id) {
        this.id = id;
    }

    public Comentario(LocalDateTime fechaHora, String contenido, Usuario usuario) {
        this.id = new ObjectId();
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.usuario = usuario;
    }
    
    public Comentario(LocalDateTime fechaHora, String contenido, Usuario usuario, ObjectId idPost) {
        this.id = new ObjectId();
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.usuario = usuario;
        this.idPost = idPost;
    }

    public Comentario(ObjectId id, LocalDateTime fechaHora, String contenido, Usuario usuario, ObjectId idPost) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.usuario = usuario;
        this.idPost = idPost;
    }
    
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ObjectId getIdPost() {
        return idPost;
    }

    public void setIdPost(ObjectId idPost) {
        this.idPost = idPost;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comentario other = (Comentario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Comentario{" + "id=" + id + ", fechaHora=" + fechaHora + ", contenido=" + contenido + ", usuario=" + usuario + ", idPost=" + idPost + '}';
    }
    
}
