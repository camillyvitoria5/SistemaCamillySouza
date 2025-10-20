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
    public class CvsFuncionario{
    private int idfuncionario;
    private String Nome;
    private String Email;
    private String Cpf;
    private String Telefone;
    private Date DataNascimento;
    private String Funcao;

        /**
         * @return the Usuario
         */
        public int getIdFuncionario() {
            return idfuncionario;
        }

        /**
         * @param idfuncionario the Usuario to set
         */
        public void setIdFuncionario(int idfuncionario) {
            this.idfuncionario = idfuncionario;
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
         * @return the Email
         */
        public String getEmail() {
            return Email;
        }

        /**
         * @param Email the Email to set
         */
        public void setEmail(String Email) {
            this.Email = Email;
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
         * @return the Telefone
         */
        public String getTelefone() {
            return Telefone;
        }

        /**
         * @param Telefone the Telefone to set
         */
        public void setTelefone(String Telefone) {
            this.Telefone = Telefone;
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
         * @return the Funcao
         */
        public String getFuncao() {
            return Funcao;
        }

        /**
         * @param Funcao the Funcao to set
         */
        public void setFuncao(String Funcao) {
            this.Funcao = Funcao;
        }

    public void setCodigo(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    }

