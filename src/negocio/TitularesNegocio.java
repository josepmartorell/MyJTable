/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datos.TitularesDatos;
import encapsuladores.BaseDatos;
import encapsuladores.Sociedad;
import encapsuladores.Titular;
import java.sql.Connection;
import java.util.List;
import datos.ConexionBaseDatos;

/**
 *
 * @author jtech
 */
public class TitularesNegocio {
        public List<Titular> consultarSocios(BaseDatos baseDatos, Sociedad sociedadCargada) throws Exception
     {
        Connection connection=null;       
        ConexionBaseDatos conexionBaseDatos = new ConexionBaseDatos();
        List<Titular> listaCopropietarios = null;

      try {
            connection = conexionBaseDatos.abrirConexion(baseDatos);                           
            listaCopropietarios = new TitularesDatos().consultarSocios(connection, sociedadCargada);
          } catch (Exception excepcion)
              {  
                throw excepcion; 
              }   
            finally
              {
                 conexionBaseDatos.cerrarConexion(connection);         
              }   

         return listaCopropietarios;                                 
     } 
    
    public List<Titular> consultarTodos(BaseDatos baseDatos) throws Exception
     {
        Connection connection=null;       
        ConexionBaseDatos conexionBaseDatos = new ConexionBaseDatos();
        List<Titular> listaCopropietarios = null;

      try {
            connection = conexionBaseDatos.abrirConexion(baseDatos);                           
            listaCopropietarios = new TitularesDatos().consultarTodos(connection);
          } catch (Exception excepcion)
              {  
                throw excepcion; 
              }   
            finally
              {
                 conexionBaseDatos.cerrarConexion(connection);         
              }   

         return listaCopropietarios;                                 
     }
    
        public Integer consultarNumeroFilasSocios(BaseDatos baseDatos, Sociedad sociedadCargada) throws Exception
     {
        Connection connection=null;       
        ConexionBaseDatos conexionBaseDatos = new ConexionBaseDatos();
        TitularesDatos copropietariosDatos = new TitularesDatos();        
        Integer numFilas = null;

      try {
            connection = conexionBaseDatos.abrirConexion(baseDatos);                           
            numFilas = copropietariosDatos.consultarNumeroFilasSocios(connection, sociedadCargada);
          } catch (Exception excepcion)
              {  
                throw excepcion; 
              }   
            finally
              {
                 conexionBaseDatos.cerrarConexion(connection);         
              }   

         return numFilas;                                 
     }


    public Integer consultarNumeroFilasTodos(BaseDatos baseDatos) throws Exception
     {
        Connection connection=null;       
        ConexionBaseDatos conexionBaseDatos = new ConexionBaseDatos();
        TitularesDatos copropietariosDatos = new TitularesDatos();        
        Integer numFilas = null;

      try {
            connection = conexionBaseDatos.abrirConexion(baseDatos);                           
            numFilas = copropietariosDatos.consultarNumeroFilasTodos(connection);
          } catch (Exception excepcion)
              {  
                throw excepcion; 
              }   
            finally
              {
                 conexionBaseDatos.cerrarConexion(connection);         
              }   

         return numFilas;                                 
     } 
    
}
