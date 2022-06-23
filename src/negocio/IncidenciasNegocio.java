/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datos.IncidenciasDatos;
import encapsuladores.Contexto;
import java.io.IOException;

/**
 *
 * @author jtech
 */
public class IncidenciasNegocio {
    
    public void escribirFichero(int codigoError, String mensajeError, Contexto contexto) throws IOException {
       new IncidenciasDatos().escribirEnFicheroIncidencias(codigoError, mensajeError, contexto);
    }  
    
}
