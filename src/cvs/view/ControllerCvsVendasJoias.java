package cvs.view;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import bean.CvsVendasJoias;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u47443281803
 */
public class ControllerCvsVendasJoias extends AbstractTableModel{

    List lista;
    
    public void setList(List lista){
     this. lista = lista;   
    }
    
    public Object getBean(int rowIndex){
        return lista.get(rowIndex);
    }
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CvsVendasJoias cvsVendasJoias = (CvsVendasJoias) lista.get(rowIndex);
        if (columnIndex == 0){
            return cvsVendasJoias.getCodigo();
        }
        if (columnIndex == 1){
            return cvsVendasJoias.getNome();
        }
        if (columnIndex == 2){
            return cvsVendasJoias.getDescricao();
        }
        if (columnIndex == 3){
            return cvsVendasJoias.getPreco();
        }
        return "LP 4";
        
    }
        
    @Override
    public String getColumnName (int column) {
        if (column == 0) return "Código";
        if (column == 1) return "Nome";
        if (column == 2) return "Descrição";
        if (column == 3) return "Preço";
        return "";
    }
    
}
