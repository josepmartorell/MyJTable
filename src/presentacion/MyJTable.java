/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package presentacion;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

/**
 *
 * @author jtech
 */
public class MyJTable extends JFrame {

    public MyJTable() {
        setSize(900,600);
        setTitle("MyJTable");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Componentes componentes = new Componentes();
        //componentes.setMyJTable(this);
        ubicarComponentes(componentes);
        setVisible(true); 
    }
    
    private Componentes ubicarComponentes(Componentes componentes){
        componentes.setModeloDatos(new ModeloDatos(componentes, 10));
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
