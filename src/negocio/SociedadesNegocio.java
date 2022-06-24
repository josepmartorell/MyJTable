/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datos.ConexionBaseDatos;
import datos.SociedadesDatos;
import encapsuladores.BaseDatos;
import encapsuladores.Sociedad;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author jtech
 */
public class SociedadesNegocio {
    public List<Sociedad> consultarTodasSociedades(BaseDatos baseDatos) throws Exception
     {
        Connection connection=null;       
        ConexionBaseDatos conexionBaseDatos = new ConexionBaseDatos();
        List<Sociedad> listaSociedades = null;

      try {
            connection = conexionBaseDatos.abrirConexion(baseDatos);                           
            listaSociedades = new SociedadesDatos().consultarTodas(connection);
          } catch (Exception excepcion)
              {  
                throw excepcion; 
              }   
            finally
              {
                 conexionBaseDatos.cerrarConexion(connection);         
              }   

         return listaSociedades;                                 
     }
    
}
