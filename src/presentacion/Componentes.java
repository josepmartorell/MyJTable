/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author jtech
 */
public class Componentes {
    
        private JTable jTable;
        private ModeloDatos modeloDatos;
        private MyJTable myJTable;
        private JScrollPane JScrollpaneTabla;

    public JTable getjTable() {
        return jTable;
    }

    public void setjTable(JTable jTable) {
        this.jTable = jTable;
    }

    public ModeloDatos getModeloDatos() {
        return modeloDatos;
    }

    public void setModeloDatos(ModeloDatos modeloDatos) {
        this.modeloDatos = modeloDatos;
    }

    public MyJTable getMyJTable() {
        return myJTable;
    }

    public void setMyJTable(MyJTable myJTable) {
        this.myJTable = myJTable;
    }

    public JScrollPane getJScrollpaneTabla() {
        return JScrollpaneTabla;
    }

    public void setJScrollpaneTabla(JScrollPane JScrollpaneTabla) {
        this.JScrollpaneTabla = JScrollpaneTabla;
    }
     
    
}
