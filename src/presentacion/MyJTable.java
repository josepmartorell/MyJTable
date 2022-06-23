/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package presentacion;

import datos.RepositorioXML;
import encapsuladores.BaseDatos;
import encapsuladores.Contexto;
import excepciones.GestorExcepciones;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import negocio.TitularesNegocio;

/**
 *
 * @author jtech
 */
public class MyJTable extends JFrame {   
    private Contexto contexto = null;

    public MyJTable() {     
        Object[] repositorio = null;
        
        try{
            contexto = new Contexto("usuario1", obtenerIP());
            repositorio = new RepositorioXML().cargar();
            setSize(900,600);
            setTitle("MyJTable");
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Componentes componentes = new Componentes();
            componentes.setMyJTable(this);
            componentes.setRepositorio(repositorio);
            componentes.setContexto(contexto);
            ubicarComponentes(componentes);
            setVisible(true); 
        } catch (Exception exception)
            {  new GestorExcepciones().gestionarExcepcion(exception, contexto); }
        
    }

    private String obtenerIP() throws UnknownHostException {
        String[] cadenasIP = InetAddress.getLocalHost().getHostAddress().split("\\.");
        StringBuffer procesoIP = new StringBuffer(16);
        for (int i=0; i<cadenasIP.length; i++)
        {
           if (i>0)
               procesoIP.append(".");
           procesoIP.append(String.format("%03d", Integer.parseInt(cadenasIP[i])));
        }
    
        return new String(procesoIP);    
    } 
       
    private Componentes ubicarComponentes(Componentes componentes) throws Exception{
        componentes.setModeloDatos(new ModeloDatos(componentes, new TitularesNegocio().consultarNumeroFilasTodos((BaseDatos)componentes.getRepositorio()[0])));
        componentes.setjTable(new JTable(componentes.getModeloDatos()));
        componentes.setJScrollpaneTabla(new JScrollPane(componentes.getjTable()));
        componentes.getJScrollpaneTabla().setBounds(20,20,1140,500);
        add(componentes.getJScrollpaneTabla());
        
        return componentes;
    }
      

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MyJTable::new); 
    }
    
}
