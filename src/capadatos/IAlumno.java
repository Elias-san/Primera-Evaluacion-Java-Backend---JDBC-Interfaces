/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capadatos;

import capaclases.alumnos;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author alumno
 */
public interface IAlumno {
    
    public int update(alumnos a) throws SQLException;
    public int insert(alumnos a) throws SQLException;
    public int delete(alumnos a) throws SQLException;
    public List<alumnos> select() throws SQLException;
    public void selectAlumnoSP() throws SQLException;    
}
