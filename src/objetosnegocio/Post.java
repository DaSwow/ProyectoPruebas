package objetosnegocio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author Michael
 */
public class Post {
    
    private ObjectId id;
    private LocalDateTime fechaHora;
    private String contenido;
    private Usuario usuario;
    private List<String> tags;
    private List<Comentario> comentarios;

    public Post() {
    }

    public Post(ObjectId id) {
        this.id = id;
    }

    public Post(LocalDateTime fechaHora, String contenido, Usuario usuario, List<String> tags) {
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.usuario = usuario;
        this.tags = tags;
    }

    public Post(ObjectId id, LocalDateTime fechaHora, String contenido, Usuario usuario, List<String> tags) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.usuario = usuario;
        this.tags = tags;
    }

    public Post(LocalDateTime fechaHora, String contenido, Usuario usuario, List<String> tags, List<Comentario> comentarios) {
        this.fechaHora = fechaHora;
        this.contenido = contenido;
        this.usuario = usuario;
        this.tags = tags;
        this.comentarios = comentarios;
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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Post other = (Post) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", fechaHora=" + fechaHora + ", contenido=" + contenido + ", usuario=" + usuario + ", tags=" + tags + '}';
    }
    
}
