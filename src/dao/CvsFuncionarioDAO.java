/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.CvsFuncionario;
import bean.CvsUsuario;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CvsFuncionarioDAO extends DAOAbstract {

    public CvsFuncionarioDAO() {

    }

    @Override
    public void insert(Object object) {
        CvsFuncionario funcionarios = (CvsFuncionario) object;
        try {
            PreparedStatement pst = cnt.prepareStatement("insert into cvs_funcionarios values(?,?,?,?,?,?,?)");
            pst.setInt(1, funcionarios.getIdFuncionario());
            pst.setString(2, funcionarios.getFuncao());
           pst.setDate(3, funcionarios.getDataNascimento() != null
                    ? new java.sql.Date(funcionarios.getDataNascimento().getTime()) : null);;
            pst.setString(4, funcionarios.getCpf());
            pst.setString(5, funcionarios.getEmail());
            pst.setString(6, funcionarios.getNome());
            pst.setString(7, funcionarios.getTelefone());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CvsFuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
        CvsFuncionario funcionarios = (CvsFuncionario) object;
        try {
            PreparedStatement pst = cnt.prepareStatement("update cvs_funcionarios set cvs_funcao=?, cvs_data_nascimento=?, cvs_cpf=?, cvs_email=?, cvs_nome=?, cvs_telefone=? where cvs_id_usuario=?");
            pst.setString(1, funcionarios.getFuncao());
                    pst.setDate(2, funcionarios.getDataNascimento() != null
                    ? new java.sql.Date(funcionarios.getDataNascimento().getTime()) : null);
            pst.setString(3, funcionarios.getCpf());
            pst.setString(4, funcionarios.getEmail());
            pst.setString(5, funcionarios.getNome());
            pst.setString(6, funcionarios.getTelefone());
            pst.setInt(7, funcionarios.getIdFuncionario());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CvsFuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        CvsFuncionario funcionarios = (CvsFuncionario) object;
        try {
            PreparedStatement pst = cnt.prepareStatement("delete from cvs_funcionarios where cvs_id_usuario=?");
            pst.setInt(1, funcionarios.getIdFuncionario());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CvsFuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        PreparedStatement pst;
        try {
            pst = cnt.prepareStatement("select * from cvs_funcionarios where cvs_id_usuario=?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                CvsFuncionario funcionarios = new CvsFuncionario();
                funcionarios.setIdFuncionario(rs.getInt("cvs_id_usuario"));
                funcionarios.setFuncao(rs.getString("cvs_funcao"));
                funcionarios.setDataNascimento(rs.getDate("cvs_data_nascimento"));
                funcionarios.setCpf(rs.getString("cvs_cpf"));
                funcionarios.setEmail(rs.getString("cvs_email"));
                funcionarios.setNome(rs.getString("cvs_nome"));
                funcionarios.setTelefone(rs.getString("cvs_telefone"));
                return funcionarios;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CvsFuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Object listAll() {
        PreparedStatement pst;
        List lista;
        try {
            pst = cnt.prepareStatement("select * from cvs_funcionarios ");
            ResultSet rs = pst.executeQuery();
            lista = new ArrayList();
            while (rs.next() == true) {
                CvsFuncionario cvsFuncionario = new CvsFuncionario();
                cvsFuncionario.setIdFuncionario(rs.getInt("cvs_id_usuario"));
                cvsFuncionario.setFuncao(rs.getString("cvs_funcao"));
                cvsFuncionario.setDataNascimento(rs.getDate("cvs_data_nascimento"));
                cvsFuncionario.setCpf(rs.getString("cvs_cpf"));
                cvsFuncionario.setEmail(rs.getString("cvs_email"));
                cvsFuncionario.setNome(rs.getString("cvs_nome"));
                cvsFuncionario.setTelefone(rs.getString("cvs_telefone"));
                lista.add(cvsFuncionario);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(CvsUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        CvsFuncionario funcionarios = new CvsFuncionario();
        funcionarios.setIdFuncionario(107);
        funcionarios.setNome("Amanda");
        funcionarios.setEmail("amanda@email.com");
        funcionarios.setCpf("123.456.789-00");
        funcionarios.setTelefone("11999999999");
        funcionarios.setDataNascimento(null);
        funcionarios.setFuncao("Gerente");

        CvsFuncionarioDAO funcionariosDao = new CvsFuncionarioDAO();
        funcionariosDao.insert(funcionarios);
        System.out.println("executou com sucesso.");
    }
}
