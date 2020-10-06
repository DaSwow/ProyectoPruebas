package objetosnegocio;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;
/**
 *
 * @author Michael
 */
public class Usuario {
    
    private ObjectId id;
    private String nombre;
    private LocalDate fechaDeNacimiento;
    private String sexo;
    private List<String> genMusicales;
    private List<String> genPeliculas;
    private String correo;
    private String contraseña;
    private List<Post> posts;

    public Usuario() {
    }

    public Usuario(ObjectId id) {
        this.id = id;
    }

    public Usuario(String nombre, LocalDate fechaDeNacimiento, String sexo, List genMusicales, List genPeliculas, String correo, String contraseña) {
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.sexo = sexo;
        this.genMusicales = genMusicales;
        this.genPeliculas = genPeliculas;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public Usuario(ObjectId id, String nombre, LocalDate fechaDeNacimiento, String sexo, List genMusicales, List genPeliculas, String correo, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.sexo = sexo;
        this.genMusicales = genMusicales;
        this.genPeliculas = genPeliculas;
        this.correo = correo;
        this.contraseña = contraseña;
    }
    
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public List<String> getGenMusicales() {
        return genMusicales;
    }

    public void setGenMusicales(List<String> genMusicales) {
        this.genMusicales = genMusicales;
    }

    public List<String> getGenPeliculas() {
        return genPeliculas;
    }

    public void setGenPeliculas(List<String> genPeliculas) {
        this.genPeliculas = genPeliculas;
    }
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", fechaDeNacimiento=" + fechaDeNacimiento + ", sexo=" + sexo + ", genMusicales=" + genMusicales + ", genPeliculas=" + genPeliculas + ", correo=" + correo + '}';
    }
    
}
