/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;
import java.util.Date;

/**
 *
 * @author amand
 */
    public class CvsUsuario{
    private int codigo;
    private String Nome;
    private String apelido;
    private String Cpf;
    private String Senha;
    private Date DataNascimento;
    private String Ativo;

        /**
         * @return the codigo
         */
        public int getCodigo() {
            return codigo;
        }

        /**
         * @param codigo the codigo to set
         */
        public void setCodigo(int codigo) {
            this.codigo = codigo;
        }

        /**
         * @return the Nome
         */
        public String getNome() {
            return Nome;
        }

        /**
         * @param Nome the Nome to set
         */
        public void setNome(String Nome) {
            this.Nome = Nome;
        }

        /**
         * @return the apelido
         */
        public String getApelido() {
            return apelido;
        }

        /**
         * @param apelido the apelido to set
         */
        public void setApelido(String apelido) {
            this.apelido = apelido;
        }

        /**
         * @return the Cpf
         */
        public String getCpf() {
            return Cpf;
        }

        /**
         * @param Cpf the Cpf to set
         */
        public void setCpf(String Cpf) {
            this.Cpf = Cpf;
        }

        /**
         * @return the Senha
         */
        public String getSenha() {
            return Senha;
        }

        /**
         * @param Senha the Senha to set
         */
        public void setSenha(String Senha) {
            this.Senha = Senha;
        }

        /**
         * @return the DataNascimento
         */
        public Date getDataNascimento() {
            return DataNascimento;
        }

        /**
         * @param DataNascimento the DataNascimento to set
         */
        public void setDataNascimento(Date DataNascimento) {
            this.DataNascimento = DataNascimento;
        }

        /**
         * @return the Ativo
         */
        public String getAtivo() {
            return Ativo;
        }

        /**
         * @param Ativo the Ativo to set
         */
        public void setAtivo(String Ativo) {
            this.Ativo = Ativo;
        }
    }

