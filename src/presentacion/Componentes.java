/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import encapsuladores.Contexto;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
        private Object[] repositorio;
        private Contexto contexto;
        private JComboBox seleccionIdSociedad;
        private MyJTable pantallaJTable;
        private JButton botonCargaSociedad;
        private JButton botonEliminarRegistros;

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

    public Object[] getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(Object[] repositorio) {
        this.repositorio = repositorio;
    }

    public Contexto getContexto() {
        return contexto;
    }

    public void setContexto(Contexto contexto) {
        this.contexto = contexto;
    }

    public JComboBox getSeleccionIdSociedad() {
        return seleccionIdSociedad;
    }

    public void setSeleccionIdSociedad(JComboBox seleccionIdSociedad) {
        this.seleccionIdSociedad = seleccionIdSociedad;
    }

    public MyJTable getPantallaJTable() {
        return pantallaJTable;
    }

    public void setPantallaJTable(MyJTable pantallaJTable) {
        this.pantallaJTable = pantallaJTable;
    }

    public JButton getBotonCargaSociedad() {
        return botonCargaSociedad;
    }

    public void setBotonCargaSociedad(JButton botonCargaSociedad) {
        this.botonCargaSociedad = botonCargaSociedad;
    }

    public JButton getBotonEliminarRegistros() {
        return botonEliminarRegistros;
    }

    public void setBotonEliminarRegistros(JButton botonEliminarRegistros) {
        this.botonEliminarRegistros = botonEliminarRegistros;
    }
    

    
}
