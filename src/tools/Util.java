package tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author user
 */
public class Util {

    public static void habilitar(boolean valor, JComponent... componentes) {
        for (int i = 0; i < componentes.length; i++) {
            componentes[i].setEnabled(valor);

        }
    }

    public static void limpar(JComponent... componentes) {
        for (int i = 0; i < componentes.length; i++) {
            if (componentes[i] instanceof JTextField) {
                ((JTextField) componentes[i]).setText("");
            }
            if (componentes[i] instanceof JComboBox) {
                ((JComboBox) componentes[i]).setSelectedIndex(-1);
            }

        }

    }

    public static void mensagem(String cad) {
        JOptionPane.showMessageDialog(null, cad);
    }

    public static boolean perguntar(String cad) {
        int resp = JOptionPane.showConfirmDialog(null, cad, "Confirmação", JOptionPane.YES_NO_OPTION);
        return resp == JOptionPane.YES_NO_OPTION;
    }

    public static int strToInt(String cad) {
        return Integer.parseInt(cad);
    }

    public static String intToStr(int num) {
        return String.valueOf(num);
    }

    public static double strToDouble(String cad) {
        return Double.parseDouble(cad);
    }

    public static String doubleToStr(double num) {
        return String.valueOf(num);
    }

    public static Date strToDate(String cad) {
        try {
            SimpleDateFormat dataNascFormat = new SimpleDateFormat("dd/MM/yyyy");
            return dataNascFormat.parse(cad);
        } catch (ParseException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String dateToStr(Date dataNasc) {
        if (dataNasc == null) {
            return "";
        }
        SimpleDateFormat dataNascFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dataNascFormat.format(dataNasc);
    }
}
