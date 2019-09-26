
package primerevaluacionjb;

import capaclases.alumnos;
import capadatos.Conexion;
import capadatos.AlumnosCrud;
import java.sql.Connection;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Elias San Martin
 */
public class PrimerEvaluacionJB {

    
    public static void main(String[] args) {
        //Conexion
        Connection cx = null;
        
        try {
                cx = Conexion.getConnection();
                AlumnosCrud alumnoCrud = new AlumnosCrud(cx);
                if (cx.getAutoCommit()){
                    cx.setAutoCommit(false);
                
                }
                
                //Creamos el objeto alumno
                alumnos a = new alumnos();
                a.setNombre("Pablo");
                a.setApellido("Perez");
                a.setDni(38545188);
                a.setCelular("1567548899");
                a.setEmail("pedro.gomez@yahoo.com");
                a.setIdtipodedocumento(1);
                a.setIdtiponacionalidad(1);
                
                // CRUD mediante select, insertm delete / update
                // 1) INSERT 
                    alumnoCrud.insert(a);
                    
                // 2) UPDATE
                /*    
                    
                a.setNombre("Pablo");
                a.setApellido("Perez");
                a.setDni(38545193);
                a.setCelular("1567548899");
                a.setEmail("pedro.gomez@yahoo.com");
                a.setIdtipodedocumento(1);
                a.setIdtiponacionalidad(1);
                alumnoCrud.update(a);*/
                    
                    // 3) DELETE
                /*alumnos a = new alumnos();
                a.setIdalumnos(9);
                a.setNombre("Pablo");
                a.setApellido("Perez");
                a.setDni(38545188);
                a.setCelular("1567548899");
                a.setEmail("pedro.gomez@yahoo.com");
                a.setIdtipodedocumento(1);
                a.setIdtiponacionalidad(1);
                //alumnoCrud.delete(a);*/
                
                // 4) SELECT
                List<alumnos> alumno = alumnoCrud.select();
                
                for (alumnos al : alumno) {
                    System.out.print(al);
                    System.out.println("");
                }
                
                // Select con Store Porecedure
                
                    alumnoCrud.selectAlumnoSP();
                
                //----------------------------
                cx.commit();
            } catch (SQLException e) {
        
             try {
                System.out.println("Rollback");
                e.printStackTrace(System.out);
                cx.rollback();
            } catch (SQLException e1){
                e1.printStackTrace(System.out);
            }
        
           
        }
        
    }
    
}
