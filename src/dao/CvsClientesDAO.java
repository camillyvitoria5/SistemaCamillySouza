package dao;

import bean.CvsClientes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CvsClientesDAO extends DAOAbstract {

    public CvsClientesDAO() {

    }
    private String removeFormatacao(String valor) {
        if (valor == null) return null;
        return valor.replaceAll("[^0-9]", "");
    }
    @Override
    public void insert(Object object) {
  CvsClientes cliente = (CvsClientes) object;
        try {
            PreparedStatement pst = cnt.prepareStatement(
                "INSERT INTO cvs_clientes (cvs_id_nome, cvs_email, cvs_cidade, cvs_rg, "
                + "cvs_data_nascimento, cvs_telefone, cvs_endereco, cvs_sexo, cvs_data_cadastro, "
                + "cvs_cpf, cvs_estdado, cvs_cep, cvs_bairro) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getEmail());
            pst.setString(3, cliente.getCidade());
            pst.setString(4, removeFormatacao(cliente.getRg()));
            pst.setDate(5, cliente.getDataNascimento() != null 
                    ? new java.sql.Date(cliente.getDataNascimento().getTime()) : null);
            pst.setString(6, removeFormatacao(cliente.getTelefone()));
            pst.setString(7, cliente.getEndereco());
            pst.setString(8, cliente.getSexo());
            pst.setDate(9, cliente.getDataCadastro() != null 
                    ? new java.sql.Date(cliente.getDataCadastro().getTime()) : null);
            pst.setString(10, removeFormatacao(cliente.getCpf()));
            pst.setString(11, cliente.getEstado());
            pst.setString(12, removeFormatacao(cliente.getCep()));
            pst.setString(13, cliente.getBairro());
           
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CvsClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
  CvsClientes cliente = (CvsClientes) object;
        try {
            PreparedStatement pst = cnt.prepareStatement(
                "UPDATE cvs_clientes SET cvs_id_nome=?, cvs_email=?, cvs_cidade=?, cvs_rg=?, "
                + "cvs_data_nascimento=?, cvs_telefone=?, cvs_endereco=?, cvs_sexo=?, cvs_data_cadastro=?, "
                + "cvs_cpf=?, cvs_estdado=?, cvs_cep=?, cvs_bairro=?"
                + "WHERE cvs_id_cliente=?");
            
            
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getEmail());
            pst.setString(3, cliente.getCidade());
            pst.setString(4, removeFormatacao(cliente.getRg()));
            pst.setDate(5, cliente.getDataNascimento() != null 
                    ? new java.sql.Date(cliente.getDataNascimento().getTime()) : null);
            pst.setString(6, removeFormatacao(cliente.getTelefone()));
            pst.setString(7, cliente.getEndereco());
            pst.setString(8, cliente.getSexo());
            pst.setDate(9, cliente.getDataCadastro() != null 
                    ? new java.sql.Date(cliente.getDataCadastro().getTime()) : null);
            pst.setString(10, removeFormatacao(cliente.getCpf()));
            pst.setString(11, cliente.getEstado());
            pst.setString(12, removeFormatacao(cliente.getCep()));
            pst.setString(13, cliente.getBairro());
           
            pst.setInt(14, cliente.getCliente());
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CvsClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        CvsClientes cliente = (CvsClientes) object;
        try {
            PreparedStatement pst = cnt.prepareStatement(
                "DELETE FROM cvs_clientes WHERE cvs_id_cliente=?");
            pst.setInt(1, cliente.getCliente());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CvsClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
          try {
            PreparedStatement pst = cnt.prepareStatement(
                "SELECT * FROM cvs_clientes WHERE cvs_id_cliente=?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                CvsClientes cliente = new CvsClientes();
                cliente.setCliente(rs.getInt("cvs_id_cliente"));
                cliente.setNome(rs.getString("cvs_id_nome"));
                cliente.setEmail(rs.getString("cvs_email"));
                cliente.setCidade(rs.getString("cvs_cidade"));
                cliente.setRg(rs.getString("cvs_rg"));
                cliente.setDataNascimento(rs.getDate("cvs_data_nascimento"));
                cliente.setTelefone(rs.getString("cvs_telefone"));
                cliente.setEndereco(rs.getString("cvs_endereco"));
                cliente.setSexo(rs.getString("cvs_sexo"));
                cliente.setDataCadastro(rs.getDate("cvs_data_cadastro"));
                cliente.setCpf(rs.getString("cvs_cpf"));
                cliente.setEstado(rs.getString("cvs_estdado"));
                cliente.setCep(rs.getString("cvs_cep"));
                cliente.setBairro(rs.getString("cvs_bairro"));
             
                
                return cliente;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CvsClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Object listAll() {
        List<CvsClientes> lista = new ArrayList<>();
        try {
            PreparedStatement pst = cnt.prepareStatement("SELECT * FROM cvs_clientes");
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                CvsClientes cliente = new CvsClientes();
                cliente.setCliente(rs.getInt("cvs_id_cliente"));
                cliente.setNome(rs.getString("cvs_id_nome"));
                cliente.setEmail(rs.getString("cvs_email"));
                cliente.setCidade(rs.getString("cvs_cidade"));
                cliente.setRg(rs.getString("cvs_rg"));
                cliente.setDataNascimento(rs.getDate("cvs_data_nascimento"));
                cliente.setTelefone(rs.getString("cvs_telefone"));
                cliente.setEndereco(rs.getString("cvs_endereco"));
                cliente.setSexo(rs.getString("cvs_sexo"));
                cliente.setDataCadastro(rs.getDate("cvs_data_cadastro"));
                cliente.setCpf(rs.getString("cvs_cpf"));
                cliente.setEstado(rs.getString("cvs_estdado"));
                cliente.setCep(rs.getString("cvs_cep"));
                cliente.setBairro(rs.getString("cvs_bairro"));
               
                
                lista.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CvsClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    
    }

    public static void main(String[] args) {
        CvsClientes cliente = new CvsClientes();
        cliente.setCliente(1);
        cliente.setNome("João da Silva");
        cliente.setEmail("joao@gmail.com");
        cliente.setCpf("12345678900");
        cliente.setRg("12345678");
        cliente.setSexo("M");
        cliente.setAtivo("S");
        cliente.setDataNascimento(new java.util.Date());
        cliente.setDataCadastro(new java.util.Date());
        cliente.setTelefone("31999999999");
        cliente.setEndereco("Rua A, 123");
        cliente.setEstado("MG");
        cliente.setCidade("Belo Horizonte");
        cliente.setBairro("Centro");
        cliente.setCep("30123-456");
    
        CvsClientesDAO clienteDao = new CvsClientesDAO();
        clienteDao.insert(cliente);
        System.out.println("executou com sucesso.");
    }
}
