/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.CvsFornecedor;
import bean.CvsUsuario;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcos
 */
public class CvsFornecedorDAO extends DAOAbstract {


    public CvsFornecedorDAO() {

    }

    @Override
    public void insert(Object object) {
        CvsFornecedor cvsFornecedor = (CvsFornecedor) object;
        try {
//            Statement stm = cnt.createStatement();
//            stm.executeUpdate("insert into cvsFornecedor values("+usuarios.getIdusuarios()+", '"+usuarios.getNome()+"')");
            PreparedStatement pst = cnt.prepareStatement("insert into cvsFornecedor values(?,?,?,?)");
            pst.setInt(1, cvsFornecedor.getIdFornecedor());
            pst.setString(2, cvsFornecedor.getNome());
            pst.setString(3, cvsFornecedor.getEmail());
            pst.setString(4, cvsFornecedor.getTelefone());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CvsFornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
        CvsFornecedor cvsFornecedor = (CvsFornecedor) object;
        try {
            PreparedStatement pst = cnt.prepareStatement("update cvsFornecedor set nome=?, email=?, telefone=? where idFornecedor=?");
            pst.setInt(4,cvsFornecedor.getIdFornecedor());
            pst.setString(1, cvsFornecedor.getNome());
            pst.setString(2, cvsFornecedor.getEmail());
            pst.setString(3, cvsFornecedor.getTelefone());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CvsFornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
         CvsFornecedor cvsFornecedor = (CvsFornecedor) object;
        try {
            PreparedStatement pst = cnt.prepareStatement("delete from cvsFornecedor where idFornecedor =?");
            pst.setInt(1, cvsFornecedor.getIdFornecedor());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CvsFornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        PreparedStatement pst;
        try {
            pst = cnt.prepareStatement("select * from cvsFornecedor where idFornecedor=?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next() == true) {
                CvsFornecedor cvsFornecedor = new CvsFornecedor();
                  cvsFornecedor.setIdFornecedor(rs.getInt("id fornecedor"));
                  cvsFornecedor.setNome(rs.getString("Nome"));
                  cvsFornecedor.setEmail(rs.getString("Email"));
                  cvsFornecedor.setTelefone(rs.getString("Telefone"));
                return cvsFornecedor;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(CvsFornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Object listAll() {
                PreparedStatement pst;
        List lista;
        try {
            pst = cnt.prepareStatement("select * from usuarios ");
            ResultSet rs = pst.executeQuery();
            lista = new ArrayList();
            while (rs.next() == true) {
                CvsFornecedor cvsFornecedor = new CvsFornecedor();
                  cvsFornecedor.setIdFornecedor(rs.getInt("id fornecedor"));
                  cvsFornecedor.setNome(rs.getString("Nome"));
                  cvsFornecedor.setEmail(rs.getString("Email"));
                  cvsFornecedor.setTelefone(rs.getString("Telefone"));
                lista.add( cvsFornecedor );
            } 
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(CvsUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;}

    public static void main(String[] args) {
        CvsFornecedor cvsFornecedor = new CvsFornecedor();
        cvsFornecedor.setIdFornecedor(2);
        cvsFornecedor.setNome("Samuel");
        cvsFornecedor.setEmail("samuel@gmail.com");
        cvsFornecedor.setTelefone("+556799845-1212");
        
        CvsFornecedorDAO cvsFornecedorDao = new CvsFornecedorDAO();
        cvsFornecedorDao.insert(cvsFornecedor);
        System.out.println("executou com sucesso.");
    }

}
