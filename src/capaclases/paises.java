
package capaclases;

/**
 *
 * @author Elías San Martín
 */
public class paises {
    private int idpaises;
    private String nombre;
    
public paises(){

}

public paises(int idpaises, String nombre){
    this.idpaises=idpaises;
    this.nombre=nombre;
}

    public int getIdpaises() {
        return idpaises;
    }

    public void setIdpaises(int idpaises) {
        this.idpaises = idpaises;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "paises{" + "idpaises=" + idpaises + ", nombre=" + nombre + '}';
    }


}




