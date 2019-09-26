
package capaclases;

/**
 *
 * @author Elías San Martín
 */
public class tipodocumentos {
    private int idtipodocumento;
    private String tipodocumento;

    public tipodocumentos(int idtipodocumento, String tipodocumento) {
        this.idtipodocumento = idtipodocumento;
        this.tipodocumento = tipodocumento;
    }

    public int getIdtipodocumento() {
        return idtipodocumento;
    }

    public void setIdtipodocumento(int idtipodocumento) {
        this.idtipodocumento = idtipodocumento;
    }

    public String getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    @Override
    public String toString() {
        return "tipodocumentos{" + "idtipodocumento=" + idtipodocumento + ", tipodocumento=" + tipodocumento + '}';
    }
    
    
    
}
