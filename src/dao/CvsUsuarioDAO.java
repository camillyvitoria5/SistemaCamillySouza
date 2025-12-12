/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.CvsUsuario;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
=======

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
>>>>>>> 2dfacaf3e419345d3e623761ad0a9212d7fceed1

/**
 *
 * @author marcos
 */
public class CvsUsuarioDAO extends DAOAbstract {

    public CvsUsuarioDAO() {

    }

    @Override
    public void insert(Object object) {
<<<<<<< HEAD
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
=======
        CvsUsuario usuarios = (CvsUsuario) object;
        try {
//            Statement stm = cnt.createStatement();
//            stm.executeUpdate("insert into usuarios values("+usuarios.getIdusuarios()+", '"+usuarios.getNome()+"')");
            PreparedStatement pst = cnt.prepareStatement("insert into usuarios values(?,?,?,?,?,?,?)");
            pst.setInt(1, usuarios.getCodigo());
            pst.setString(2, usuarios.getNome());
            pst.setString(3, usuarios.getApelido());
            pst.setString(4, usuarios.getCpf());
            pst.setDate(5, usuarios.getDataNascimento() != null
                    ? new java.sql.Date(usuarios.getDataNascimento().getTime()) : null);
            pst.setString(6, usuarios.getSenha());//senha
            pst.setString(7, usuarios.getAtivo());//ativo
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CvsUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
>>>>>>> 2dfacaf3e419345d3e623761ad0a9212d7fceed1
    }

    @Override
    public void update(Object object) {
<<<<<<< HEAD
        session.beginTransaction();
        session.flush();
        session.clear();
        session.update(object);
        session.getTransaction().commit();
=======
        CvsUsuario usuarios = (CvsUsuario) object;
        try {
            PreparedStatement pst = cnt.prepareStatement("update usuarios set nome=?, apelido=?, cpf=?, datanascimento=?, senha=?, ativo =? where idusuarios=?");
            pst.setInt(7, usuarios.getCodigo());
            pst.setString(1, usuarios.getNome());
            pst.setString(2, usuarios.getApelido());
            pst.setString(3, usuarios.getCpf());
            pst.setDate(4, usuarios.getDataNascimento() != null
                    ? new java.sql.Date(usuarios.getDataNascimento().getTime()) : null);
            pst.setString(5, usuarios.getSenha());//senha                        
            pst.setString(6, usuarios.getAtivo());//ativo
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CvsUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
>>>>>>> 2dfacaf3e419345d3e623761ad0a9212d7fceed1
    }

    @Override
    public void delete(Object object) {
<<<<<<< HEAD
        session.beginTransaction();
        session.flush();
        session.clear();
        session.delete(object);
        session.getTransaction().commit();
    }

    @Override
    public Object list(int codigo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CvsUsuario.class);
        criteria.add(Restrictions.eq("cvs_id_usuario", codigo) );
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
        public ArrayList listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CvsUsuario.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return (ArrayList) lista;
}


    public static void main(String[] args) {
        CvsUsuarioDAO usuariosDAO = new CvsUsuarioDAO();
        usuariosDAO.listAll();
    }
}
=======
        CvsUsuario usuarios = (CvsUsuario) object;
        try {
            PreparedStatement pst = cnt.prepareStatement("delete from usuarios where idusuarios =?");
            pst.setInt(1, usuarios.getCodigo());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CvsUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        PreparedStatement pst;
        try {
            pst = cnt.prepareStatement("select * from usuarios where codigo =?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next() == true) {
                CvsUsuario usuarios = new CvsUsuario();
                usuarios.setCodigo(rs.getInt("codigo"));
                usuarios.setNome(rs.getString("nome"));
                usuarios.setApelido(rs.getString("apelido"));
                usuarios.setCpf(rs.getString("cpf"));
                usuarios.setDataNascimento(rs.getDate("dataNascimento"));
                usuarios.setSenha(rs.getString("senha"));
                usuarios.setAtivo(rs.getString("ativo"));
                return usuarios;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CvsUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
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
                CvsUsuario usuarios = new CvsUsuario();
                usuarios.setCodigo(rs.getInt("idusuarios"));
                usuarios.setNome(rs.getString("nome"));
                usuarios.setApelido(rs.getString("apelido"));
                usuarios.setCpf(rs.getString("cpf"));
                usuarios.setDataNascimento(rs.getDate("dataNascimento"));
                usuarios.setSenha(rs.getString("senha"));

                usuarios.setAtivo(rs.getString("ativo"));
                lista.add(usuarios);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(CvsUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        CvsUsuario usuarios = new CvsUsuario();
        usuarios.setCodigo(222);
        usuarios.setNome("marcos");
        usuarios.setApelido("mpv");
        usuarios.setCpf("456.546.879-87");
        usuarios.setDataNascimento(null);
        usuarios.setSenha("123");
        usuarios.setAtivo("S");
        CvsUsuarioDAO usuariosDao = new CvsUsuarioDAO();
        usuariosDao.insert(usuarios);
        System.out.println("executou com sucesso.");
    }

    public boolean fazerLogin(String apelido, String senha) {
        try {

            PreparedStatement pst = cnt.prepareStatement(
                    "SELECT * FROM usuarios WHERE apelido = ? AND senha = ? AND ativo = 'S'");
            pst.setString(1, apelido);
            pst.setString(2, senha);

            ResultSet rs = pst.executeQuery();

            return rs.next();

        } catch (SQLException ex) {
            Logger.getLogger(CvsUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
>>>>>>> 2dfacaf3e419345d3e623761ad0a9212d7fceed1
