/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vacunargrupo4.control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vacunargrupo4.modelos.CtroVacunacion;
import vacunargrupo4.modelos.Persona;

/**
 *
 * @author Maxi
 */
public class CtroData {
    
    private Connection con;
    public CtroData(Conexion conexion){         
        try{
            con = conexion.getConexion();
        }catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"error de conexion en CtroData");
        }
    }
       
    
    public ArrayList<CtroVacunacion> obtenerCtroVacunacions(){
        CtroVacunacion ctroVacunacion;
        ArrayList <CtroVacunacion> centros = new ArrayList(); 
        
        try{
            String sql = "SELECT * FROM ctrovacunacion";
            PreparedStatement ps = con.prepareStatement(sql);
            
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                ctroVacunacion = new CtroVacunacion();
                ctroVacunacion.setIdCentro(rs.getInt("idCtroVacunacion"));
                ctroVacunacion.setNombre(rs.getString("nombre"));               
                ctroVacunacion.setDireccion(rs.getString("direccion"));               
                ctroVacunacion.setLocalidad(rs.getString("localidad"));
               
                centros.add(ctroVacunacion);
            }
            ps.close();
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(null,"error de conexion buscando todos los centros de vacunacion registrados");
        }
        return centros;
    }
   
    public int cantidadAplicadas(String nombreCentro) throws SQLException{  //HACER HASHMAP VACUNAS APLICADAS POR CENTRO
            int n= 0;
            
            Statement stm = con.createStatement();
            
            String sql  = "SELECT COUNT(vacuna)FROM registrovacunados rv,citas c,ctrovacunacion cv WHERE rv.idCita = c.idCitas AND c.idCentro=cv.idCtroVacunacion AND cv.nombre =?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombreCentro);
            ResultSet rs=ps.executeQuery();
            
            if(rs.next()) {              
               n= rs.getInt(1);
            }
            stm.close();
            con.close();
            JOptionPane.showMessageDialog(null, n+ " dosis aplicadas en este centro");
            return n;
    }
    
    public void vacAplicadas(String nombreCentro) throws SQLException{
            HashMap<Integer,Integer> aplicadas = new HashMap();
            int vacuna=0,dni=0;
            
            Statement stm = con.createStatement();
            
            String sql  = "SELECT vacuna,dni FROM registrovacunados rv,citas c,ctrovacunacion cv,persona p WHERE rv.idCita = c.idCitas AND c.idPersona=p.idPersona AND cv.nombre=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombreCentro);
            ResultSet rs=ps.executeQuery();
            
             while(rs.next()){               
                vacuna = rs.getInt("vacuna");               
                dni = rs.getInt("dni");
                aplicadas.put(vacuna, dni);
            }
            ps.close();
            
            Set s= aplicadas.keySet();
            Iterator it = s.iterator();
            
            JOptionPane.showMessageDialog(null,"Vacunas aplicadas en este centro:\n ");
            while(it.hasNext()){
                int aux = (int) it.next();
                JOptionPane.showMessageDialog(null,"N° de Serie Vacuna : "+ aux + " DNI : " + aplicadas.get(aux));
            }           
            
            
    }
    
    public CtroVacunacion buscarCtroVacunacion(String nombre){
        CtroVacunacion ctroVacunacion=null;
        try{
            String sql = "SELECT * FROM ctrovacunacion WHERE nombre =?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                ctroVacunacion = new CtroVacunacion();
                ctroVacunacion.setIdCentro(rs.getInt("idCtroVacunacion"));
                ctroVacunacion.setNombre(rs.getString("nombre"));               
                ctroVacunacion.setDireccion(rs.getString("direccion"));
                ctroVacunacion.setLocalidad(rs.getString("localidad"));                
            }
            ps.close();
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(null,"error de conexion buscando ctroVacunacion");
        }
        return ctroVacunacion;
    }
    public CtroVacunacion buscarCtroVacunacion(int id){
        CtroVacunacion ctroVacunacion=null;
        try{
            String sql = "SELECT * FROM ctrovacunacion WHERE idCentroVacunacion=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                ctroVacunacion = new CtroVacunacion();
                ctroVacunacion.setIdCentro(rs.getInt("idCtroVacunacion"));
                ctroVacunacion.setNombre(rs.getString("nombre"));               
                ctroVacunacion.setDireccion(rs.getString("direccion"));
                ctroVacunacion.setLocalidad(rs.getString("localidad"));                
            }
            ps.close();
        }catch(SQLException ex){
           JOptionPane.showMessageDialog(null,"error de conexion buscando ctroVacunacion");
        }
        return ctroVacunacion;
    }

    
    public void registrarCtroVacunacion(CtroVacunacion ctroVacunacion){
        try{
            String sql="INSERT INTO ctrovacunacion (nombre,localidad,direccion) VALUES (?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,ctroVacunacion.getNombre());                        
            ps.setString(2,ctroVacunacion.getLocalidad());
            ps.setString(3, ctroVacunacion.getDireccion());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                ctroVacunacion.setIdCentro(rs.getInt(1));
            }
            ps.close();
        }catch (SQLException ex) {
            Logger.getLogger(CtroData.class.getName()).log(Level.SEVERE,null,ex);
        }    
    }
    
    public void borrarCtroVacunacion(String nombre){
        
        try{
            String sql="DELETE FROM ctroVacunacion WHERE nombre=?";
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nombre);
            
            ps.executeUpdate();
            ps.close();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"error de conexion al borrar ctroVacunacion");
        }
    }
    
    public void actualizarCtroVacunacion(CtroVacunacion ctroVacunacion, String nombre){
        CtroVacunacion centro = null;
        centro = buscarCtroVacunacion(nombre);
        int idCentro = centro.getIdCentro();
        
        try{
            String sql = "UPDATE `ctroVacunacion` SET `nombre`=?,`localidad`=?,`direccion`=? WHERE idCtroVacunacion="+idCentro;
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, ctroVacunacion.getNombre());
            ps.setString(3,ctroVacunacion.getDireccion());
            ps.setString(2,ctroVacunacion.getLocalidad());
            ps.setInt(4, idCentro);
            
            ps.executeUpdate();
            
            ps.close();
        }catch (SQLException ex) {
            Logger.getLogger(CtroData.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}