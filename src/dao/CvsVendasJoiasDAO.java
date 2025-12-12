/*
<<<<<<< HEAD
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.CvsVendasjoias;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
=======
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.CvsVendasJoias;

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
 * @author amand
 */
public class CvsVendasJoiasDAO extends DAOAbstract {

    public CvsVendasJoiasDAO() {

    }

    @Override
    public void insert(Object object) {
<<<<<<< HEAD
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
=======
        CvsVendasJoias joia = (CvsVendasJoias) object;
        try {
            PreparedStatement pst = cnt.prepareStatement(
                "INSERT INTO cvs_joias (cvs_peso, cvs_nome, cvs_preco, cvs_tipo, cvs_descricao, cvs_material) " +
                "VALUES (?, ?, ?, ?, ?, ?)");
            
            // Convertendo para números decimais (mínima mudança necessária)
            pst.setDouble(1, Double.parseDouble(joia.getPeso().replace(",", ".")));
            pst.setString(2, joia.getNome());
            pst.setDouble(3, Double.parseDouble(joia.getPreco().replace(",", ".")));
            pst.setString(4, joia.getTipo());
            pst.setString(5, joia.getDescricao());
            pst.setString(6, joia.getMaterial());
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CvsVendasJoiasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex) {
            Logger.getLogger(CvsVendasJoiasDAO.class.getName()).log(Level.SEVERE, "Formato numérico inválido", ex);
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
        CvsVendasJoias joia = (CvsVendasJoias) object;
        try {
            PreparedStatement pst = cnt.prepareStatement(
                    "update cvs_joias set cvs_peso=?, cvs_nome=?, cvs_preco=?, "
                    + "cvs_tipo=?, cvs_descricao=?, cvs_material=? where cvs_id_codigo=?");

                pst.setDouble(1, Double.parseDouble(joia.getPeso().replace(",", ".")));
            pst.setString(2, joia.getNome());
            pst.setDouble(3, Double.parseDouble(joia.getPreco().replace(",", ".")));
            pst.setString(4, joia.getTipo());
            pst.setString(5, joia.getDescricao());
            pst.setString(6, joia.getMaterial());
            pst.setInt(7, joia.getCodigo());

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CvsVendasJoiasDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        Criteria criteria = session.createCriteria(CvsVendasjoias.class);
        criteria.add(Restrictions.eq("iaaIdCvsVendasjoias", codigo) );
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
        public ArrayList listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(CvsVendasjoias.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return (ArrayList) lista;
}


    public static void main(String[] args) {
        CvsVendasJoiasDAO cvsVendasjoiasDAO = new CvsVendasJoiasDAO();
        cvsVendasjoiasDAO.listAll();
    }
}
=======
        CvsVendasJoias joia = (CvsVendasJoias) object;
        try {
            PreparedStatement pst = cnt.prepareStatement("delete from cvs_joias where cvs_id_codigo=?");
            pst.setInt(1, joia.getCodigo());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CvsVendasJoiasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        PreparedStatement pst;
        try {
            pst = cnt.prepareStatement("select * from cvs_joias where cvs_id_codigo =?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next() == true) {
                CvsVendasJoias joia = new CvsVendasJoias();
                joia.setCodigo(rs.getInt("cvs_id_codigo"));
                joia.setNome(rs.getString("nome"));
                joia.setTipo(rs.getString("tipo"));
                joia.setPeso(rs.getString("peso"));
                joia.setPreco(rs.getString("preco"));
                joia.setDescricao(rs.getString("descricao"));
                return joia;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CvsVendasJoiasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Object listAll() {

        List<CvsVendasJoias> lista = new ArrayList<>();
        try {
            PreparedStatement pst = cnt.prepareStatement("select * from cvs_joias");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                CvsVendasJoias joia = new CvsVendasJoias();
                joia.setCodigo(rs.getInt("cvs_id_codigo"));
                joia.setPeso(rs.getString("cvs_peso"));
                joia.setNome(rs.getString("cvs_nome"));
                joia.setPreco(rs.getString("cvs_preco"));
                joia.setTipo(rs.getString("cvs_tipo"));
                joia.setDescricao(rs.getString("cvs_descricao"));
                joia.setMaterial(rs.getString("cvs_material"));
                lista.add(joia);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CvsVendasJoiasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public static void main(String[] args) {
        CvsVendasJoias joia = new CvsVendasJoias();
    joia.setCodigo(1); 
    joia.setNome("Anel de Diamante");
    joia.setTipo("Anel");
    joia.setPeso("10.5");
    joia.setPreco("2500.99"); 
    joia.setDescricao("Anel de ouro 18k com diamante central");
    joia.setMaterial("Ouro 18k e Diamante");
    CvsVendasJoiasDAO joiaDAO = new CvsVendasJoiasDAO();
    try {
        
        joiaDAO.insert(joia);
        System.out.println("Joia inserida com sucesso!");
        
        List<CvsVendasJoias> joias = (List<CvsVendasJoias>) joiaDAO.listAll();
        System.out.println("\nJoias cadastradas:");
        for (CvsVendasJoias j : joias) {
            System.out.println("Código: " + j.getCodigo());
            System.out.println("Nome: " + j.getNome());
            System.out.println("Tipo: " + j.getTipo());
            System.out.println("Peso: " + j.getPeso() + "g");
            System.out.println("Preço: R$ " + j.getPreco());
            System.out.println("Material: " + j.getMaterial());
            System.out.println("Descrição: " + j.getDescricao());
            System.out.println("----------------------");
        }
    } catch (Exception e) {
        System.err.println("Erro ao inserir joia:");
        e.printStackTrace();
    }
    }
}
>>>>>>> 2dfacaf3e419345d3e623761ad0a9212d7fceed1
