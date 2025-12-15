package view;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import bean.CvsJoias;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u47443281803
 */
public class ControllerCvsJoias extends AbstractTableModel{

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
        CvsJoias CvsJoias = (CvsJoias) lista.get(rowIndex);
        if (columnIndex == 0){
            return CvsJoias.getCvsIdJoias() ;
        }
        if (columnIndex == 1){
            return CvsJoias.getCvsNome();
        }
        if (columnIndex == 2){
            return CvsJoias.getCvsDescricao();
        }
        if (columnIndex == 3){
            return CvsJoias.getCvsPreco();
        }
        return "LP 4";
        
    }
        
    @Override
    public String getColumnName (int column) {
        if (column == 0) return "ID";
        if (column == 1) return "NOME";
        if (column == 2) return "DESCRIÇÃO";
        if (column == 3) return "PREÇO";
        return "";
    }
    
}
