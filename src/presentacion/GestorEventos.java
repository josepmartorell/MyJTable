/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import java.awt.event.ActionListener;
import encapsuladores.BaseDatos;
import encapsuladores.Sociedad;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import negocio.TitularesNegocio;

/**
 *
 * @author jtech
 */
public class GestorEventos implements ActionListener {

    private final Componentes componentes;
    private Sociedad sociedadCargada;
    private ModeloDatos modeloDatos;
    
    public GestorEventos(Componentes componentes) {
        this.componentes = componentes;
    }  
    
         // MÉTODO DE ActionListener    
    @Override
    public void actionPerformed(ActionEvent e) {       
        
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        DecimalFormat decimalFormat = new DecimalFormat("##0.000", decimalFormatSymbols);
      
        JButton jButton = (JButton) e.getSource();
        
        if (jButton == componentes.getBotonCargaSociedad())     //  BOTON Carga Votacion
         {  
            System.out.println("cargando sociedad especifica...");
            if (componentes.getSeleccionIdSociedad().getSelectedItem() != null || componentes.getSeleccionIdSociedad().getSelectedItem() == null)
             {
                Sociedad sociedad = new Sociedad();
                sociedad.setCif(componentes.getSeleccionIdSociedad().getSelectedItem().toString().substring(0, 10));
                System.out.println(sociedad.getCif());
                sociedadCargada = sociedad;
                try {
                    componentes.getModeloDatos().cargarTitulares(new TitularesNegocio().consultarSocios((BaseDatos)componentes.getRepositorio()[0], sociedadCargada));
                } catch (Exception ex) {
                    Logger.getLogger(GestorEventos.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
         } 
        else {JOptionPane.showMessageDialog(componentes.getPantallaJTable(), "Debe seleccionar y guardar previamente la sociedad");}                
    }            
    
    
    
}
