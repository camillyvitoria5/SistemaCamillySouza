package view;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import bean.CvsVendasjoias;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u47443281803
 */
public class ControllerCvsVendasJoias extends AbstractTableModel {

    List lista;

    public void setList(List lista) {
        this.lista = lista;
    }

    public List getList() {
        return this.lista;
    }

    public void addBean(CvsVendasjoias cvsVendasjoias) {
        this.lista.add(cvsVendasjoias);
        this.fireTableDataChanged();
    }

    public void removeBean(CvsVendasjoias cvsVendasjoias) {
        this.lista.remove(cvsVendasjoias);
        this.fireTableDataChanged();
    }

    public CvsVendasjoias getBean(int rowIndex) {
        return (CvsVendasjoias) lista.get(rowIndex);
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
        CvsVendasjoias cvsVendasjoias = (CvsVendasjoias) lista.get(rowIndex);
        if (columnIndex == 1) {
            return cvsVendasjoias.getCvsJoias();
        }
        if (columnIndex == 2) {
            return cvsVendasjoias.getCvsQuant();
        }
        if (columnIndex == 3) {
            return cvsVendasjoias.getCvsValorUnidade();
        }
        if (columnIndex == 4) {
            return cvsVendasjoias.getCvsValorUnidade()*cvsVendasjoias.getCvsQuant();
        }
        return "LP 4";

    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "JOIA";
        }
        if (column == 1) {
            return "QUANT";
        }
        if (column == 2) {
            return "PREÇO";
        }
        if (column == 4) {
            return "TOTAL";
        }
        return "";
    }

}
