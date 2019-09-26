
package capaclases;

/**
 *
 * @author Elías San Martín
 */
public class alumnos {
    private int idalumnos;
    private String nombre;
    private String apellido;
    private int idtipodedocumento;
    private int dni;
    private String email;
    private String celular;
    private int idtiponacionalidad;
    
public alumnos(){

}

public alumnos(int idalumnos,String nombre,String apellido,
        int idtipodedocumento,int dni,String email,String celular,int idtiponacionalidad){
    this.idalumnos=idalumnos;
    this.nombre=nombre;
    this.apellido=apellido;
    this.email=email;
    this.celular=celular;
    this.idtipodedocumento=idtipodedocumento;
    this.idtiponacionalidad=idtiponacionalidad;

}
    public int getIdalumnos() {
        return idalumnos;
    }

    public void setIdalumnos(int idalumnos) {
        this.idalumnos = idalumnos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getIdtipodedocumento() {
        return idtipodedocumento;
    }

    public void setIdtipodedocumento(int idtipodedocumento) {
        this.idtipodedocumento = idtipodedocumento;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getIdtiponacionalidad() {
        return idtiponacionalidad;
    }

    public void setIdtiponacionalidad(int idtiponacionalidad) {
        this.idtiponacionalidad = idtiponacionalidad;
    }

    @Override
    public String toString() {
        return "alumnos{" + "idalumnos=" + idalumnos + ", nombre=" + nombre + ", apellido=" + apellido + ", "
                + "idtipodedocumento=" + idtipodedocumento + ", dni=" + dni + ", email=" + email + ", celular=" + celular + ", "
                + "idtiponacionalidad=" + idtiponacionalidad + '}';
    }




}
