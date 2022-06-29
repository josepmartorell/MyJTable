/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import encapsuladores.Titular;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jtech
 */
public class ModeloDatos extends AbstractTableModel{
    
    private final Object datos[][];
    private final String[] columnNames = {"Código","Nombre","Cuota participación"};
    private final Componentes componentes;
    private int numeroFilas = 0;

    public ModeloDatos(Componentes componentes, int numeroFilas) {
        datos = new Object[numeroFilas][3];
        this.numeroFilas = numeroFilas;
        this.componentes = componentes;
        inicializarFilas(0, numeroFilas-1);

    }
    
    private void inicializarFilas(int filaInicial, int filaFinal) {   
      for (int i=filaInicial; i<=filaFinal; i++)
        { datos[i][0] = "";
          datos[i][1] = "";
          datos[i][2] = 0.0;
        }
    }
    
      public void cargarTitulares(List<Titular> listaCopropietarios) { 

      for (int i=0; i<listaCopropietarios.size(); i++)
      {
          Titular copropietario = listaCopropietarios.get(i);          
          datos[i][0] = copropietario.getCodigo();
          datos[i][1] = copropietario.getNombre();
          datos[i][2] = copropietario.getCuotaParticipacion();
      }

      componentes.getjTable().repaint();
    }
      
    public void limpiarFilas(List<Titular> listaCopropietarios) { 

      for (int i=0; i<listaCopropietarios.size(); i++)
      {
          Titular copropietario = listaCopropietarios.get(i);          
          datos[i][0] = null;
          datos[i][1] = null;
          datos[i][2] = null;
      }

      componentes.getjTable().repaint();
    }
    
    public void eliminarFila() {
        
        if (numeroFilas >= 1){
            numeroFilas--;
            fireTableRowsInserted(numeroFilas - 1, numeroFilas - 1);
        }
    }
      
    @Override
    public int getRowCount() {
        return numeroFilas;
    }

    @Override
    public int getColumnCount() {
        return datos[0].length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int column) {
        return datos[row][column];
    }
    
}