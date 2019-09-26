
package capadatos;
import capaclases.alumnos;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Elias San Martin
 */
public class AlumnosCrud implements IAlumno{
    private final String SELECT="SELECT idalumnos,nombre,apellido,idtipodedocumento,"
            + "dni,email,celular,idtipodenacionalidad from alumnos ORDER BY idalumnos";
    private final String INSERT="INSERT INTO alumnos(nombre,apellido,idtipodedocumento,"
            + "dni,email,celular,idtipodenacionalidad) VALUES(?,?,?,?,?,?,?)";
    private final String UPDATE="UPDATE alumnos SET nombre=?,apellido=?,idtipodedocumento=?,"
            + "dni=?,email=?,celular=?,idtipodenacionalidad=?";
    private final String DELETE ="DELETE FROM alumnos WHERE idalumnos=?";
    private Connection alumnosConexion;
    
    public AlumnosCrud(Connection conexion){
        this.alumnosConexion=conexion;
    }
    
    
    public int insert( alumnos a) throws SQLException{
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
             stmt = this.alumnosConexion.prepareStatement(INSERT);
             int index = 1;
             stmt.setString(index++,a.getNombre());
             stmt.setString(index++, a.getApellido());
             stmt.setInt(index++, a.getIdtipodedocumento());
             stmt.setInt(index++, a.getDni());
             stmt.setString(index++, a.getEmail());
             stmt.setString(index++, a.getCelular());
             stmt.setInt(index++, a.getIdtiponacionalidad());
             
             System.out.println("Ejecutando query: " + INSERT);
             rows = stmt.executeUpdate();
             System.out.println("Registro afectados: " + rows);
             
        } finally {
            Conexion.close(stmt);
        }
        return rows;
    } // ----------------------****** INSERT

    public int update(alumnos a) throws SQLException {
        PreparedStatement stmt = null;
        int rows = 0;
        
        try{
            System.out.println("Ejecutando query: " + UPDATE);
            stmt = this.alumnosConexion.prepareStatement(UPDATE);
            int index =1;
            stmt.setString(index++,a.getNombre());
            stmt.setString(index++, a.getApellido());
            stmt.setInt(index++, a.getIdtipodedocumento());
            stmt.setInt(index++, a.getDni());
            stmt.setString(index++, a.getEmail());
            stmt.setString(index++, a.getCelular());
            stmt.setInt(index++, a.getIdtiponacionalidad());
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados: " + rows);
            
        } finally {
            Conexion.close(stmt);
        }
        
        return rows;
    }  // ------------------------------- UPDATE ----------------
public int delete(alumnos a )throws SQLException{
    PreparedStatement stmt =null;
    int rows = 0;
    
    
    try {
        System.out.println("Ejecutando query:" + DELETE);
        stmt = this.alumnosConexion.prepareStatement(DELETE);
        stmt.setInt(1,a.getIdalumnos());
        rows = stmt.executeUpdate();
        System.out.println(a.getIdalumnos());
        System.out.println("Registros eliminados;" + rows);
    }   finally {
            Conexion.close(stmt);
    }
    return rows;
} // DELETE

public List<alumnos> select() throws SQLException {
    
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    List<alumnos> alumnoLista = new ArrayList<>();
    try {
        stmt = this.alumnosConexion.prepareStatement(SELECT);
        rs = stmt.executeQuery();
        while (rs.next()){
            alumnos a = new alumnos();
            a.setIdalumnos(rs.getInt("idalumnos"));
            a.setNombre(rs.getString("nombre"));
            a.setApellido(rs.getString("apellido"));
            a.setIdtipodedocumento(rs.getInt("idtipodedocumento"));
            a.setDni(rs.getInt("dni"));
            a.setEmail(rs.getString("email"));
            a.setCelular(rs.getString("celular"));
            a.setIdtiponacionalidad(rs.getInt("idtipodenacionalidad"));
            alumnoLista.add(a);
            
        }
    } finally {
        Conexion.close(rs);
        Conexion.close(stmt);
    }
    
    return alumnoLista;
} //SELECT

public void selectAlumnoSP() throws SQLException {
    ResultSet rs=null;
    String sp = "{call selectAlumnos}";
    CallableStatement cs;
    cs = alumnosConexion.prepareCall(sp);
    cs.execute();
    rs = cs.executeQuery();
        while(rs.next()){
            alumnos a = new alumnos();
            a.setIdalumnos(rs.getInt("idalumnos"));
            a.setNombre(rs.getString("nombre"));
            a.setApellido(rs.getString("apellido"));
            a.setIdtipodedocumento(rs.getInt("idtipodedocumento"));
            a.setDni(rs.getInt("dni"));
            a.setEmail(rs.getString("email"));
            a.setCelular(rs.getString("celular"));
            a.setIdtiponacionalidad(rs.getInt("idtipodenacionalidad"));
            System.out.println(a);
        }//while

        cs.close();
} //Store Procedure
}
