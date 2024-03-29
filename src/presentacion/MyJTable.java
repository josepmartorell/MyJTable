/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package presentacion;

import datos.RepositorioXML;
import encapsuladores.BaseDatos;
import encapsuladores.Contexto;
import encapsuladores.Sociedad;
import excepciones.GestorExcepciones;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumn;
import negocio.SociedadesNegocio;
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
            setSize(900, 540);
            setTitle("MyJTable");
            
            /*manual interface positioning*/
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Point middle = new Point((screenSize.width / 2), screenSize.height / 2);
            Point newLocation = new Point(middle.x - (getWidth() / 2), 
                                          middle.y - (getHeight() / 2));
            setLocation(newLocation);
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Componentes componentes = new Componentes();
            componentes.setMyJTable(this);
            componentes.setRepositorio(repositorio);
            componentes.setContexto(contexto);
            ubicarComponentes(componentes);
            componentes.getModeloDatos().cargarTitulares(new TitularesNegocio().consultarTodos((BaseDatos)componentes.getRepositorio()[0])); 
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
        
        setLayout(null);
        GestorEventos gestorEventos = new GestorEventos(componentes);
        
        componentes.setModeloDatos(new ModeloDatos(componentes, new TitularesNegocio().consultarNumeroFilasTodos((BaseDatos)componentes.getRepositorio()[0])));
        componentes.setjTable(new JTable(componentes.getModeloDatos()));
        componentes.setJScrollpaneTabla(new JScrollPane(componentes.getjTable()));
        componentes.getJScrollpaneTabla().setBounds(10,10,880,310);
        add(componentes.getJScrollpaneTabla());
              
        TableColumn columna[] = new TableColumn[3];
        columna[0] = componentes.getjTable().getColumnModel().getColumn(0);
        columna[0].setPreferredWidth(30);

        columna[1] = componentes.getjTable().getColumnModel().getColumn(1);
        columna[1].setPreferredWidth(350);

        columna[2] = componentes.getjTable().getColumnModel().getColumn(2);
        columna[2].setPreferredWidth(50);
        
        componentes.setBotonEliminarFila(new JButton("Eliminar fila"));
        componentes.getBotonEliminarFila().setBounds(43, 360, 807, 20);
        componentes.getBotonEliminarFila().addActionListener(gestorEventos);     // REGISTRO DE ESCUCHA DE EVENTO DE BOTON
        add(componentes.getBotonEliminarFila());
        
        componentes.setBotonLimpiarFilas(new JButton("Limpiar filas"));
        componentes.getBotonLimpiarFilas().setBounds(43, 405, 807, 20);
        componentes.getBotonLimpiarFilas().addActionListener(gestorEventos);     // REGISTRO DE ESCUCHA DE EVENTO DE BOTON
        add(componentes.getBotonLimpiarFilas());
        
        componentes.setBotonCargaSociedad(new JButton("Carga sociedad"));
        componentes.getBotonCargaSociedad().setBounds(43, 450, 150, 20);
        componentes.getBotonCargaSociedad().addActionListener(gestorEventos);     // REGISTRO DE ESCUCHA DE EVENTO DE BOTON
        add(componentes.getBotonCargaSociedad());
        
        componentes.setSeleccionIdSociedad(new JComboBox());
        componentes.getSeleccionIdSociedad().setBounds(250, 450, 600, 20);
        componentes.getSeleccionIdSociedad().setBackground(Color.white);
        add(componentes.getSeleccionIdSociedad());
        cargarComboSociedades(componentes);
        
        return componentes;
    }
    
    public void cargarComboSociedades(Componentes componentes) throws Exception {
        componentes.getSeleccionIdSociedad().removeAllItems();
        List<Sociedad> listaSociedades = new SociedadesNegocio().consultarTodasSociedades((BaseDatos)componentes.getRepositorio()[0]);
        System.out.println("cargando lista de sociedades...");
        for (int i=0; i<listaSociedades.size(); i++)
        {
            Sociedad sociedad = listaSociedades.get(i);
            componentes.getSeleccionIdSociedad().addItem(sociedad.getCif()+"  /  "+sociedad.getRazonSocial());
            System.out.println(sociedad.getCif());
        }
    }
      

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MyJTable::new); 
    }
    
}
