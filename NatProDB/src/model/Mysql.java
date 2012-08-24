/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Stella
 */
public class Mysql {

    private Connection conexao;
    private Statement stm;
    private String URL;
    private String usuario;
    private String senha;
    private String login;
    private ResultSet rs = null;
    private boolean valid;

    public Mysql() {
        URL = "jdbc:mysql://localhost:3306/moleculesgerent";
        usuario = "root";
        senha = "sstvtr08";

        /*
         * try { //carregar o driver Class.forName("com.mysql.jdbc.Driver");
         * //efetuar conexão conexao =
         * DriverManager.getConnection(URL,usuario,senha); stm =
         * conexao.createStatement();
         *
         * } catch (ClassNotFoundException ex) {
         * JOptionPane.showMessageDialog(null,"Erro no Driver" );
         * }catch(SQLException ex){ JOptionPane.showMessageDialog(null,"Erro na
         * conexão!" );
        }
         */

    }

    /* public ResultSet consultaLoginPassword() { /*
    
    try {
    rs = Mysql.stm.executeQuery("SELECT Login, Password FROM usuario");
    
    } catch (SQLException ex) {
    JOptionPane.showConfirmDialog(null, "Erro de conexão");
    }
    return rs;
    }*/
    public void abrirConexao() {

        try {
            //carregar o driver
            Class.forName("com.mysql.jdbc.Driver");
            //efetuar conexão
            conexao = DriverManager.getConnection(URL, usuario, senha);
            stm = conexao.createStatement();

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro no Driver");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na conexão!");
        }

    }

    public void fecharConexao() {

        try {
            conexao.close();
        } catch (SQLException onConClose) {
            JOptionPane.showMessageDialog(null, "Houve erro no fechamento da conexão");
            onConClose.printStackTrace();
        }
    }

    public boolean auteticação(String login, String paswd) {
        String tempLogin = login;
        String tempSenha = paswd;

        String test;
        try {
            /* conexao = DriverManager.getConnection(URL, usuario, senha);
            stm = conexao.createStatement();*/
            rs = stm.executeQuery("SELECT * FROM usuario where Login = '" + tempLogin + "' and Password ='" + tempSenha + "';");


            if (rs.next()) {
                // valid = true;
                setValid();
            } else {
                JOptionPane.showMessageDialog(null, "Login ou Senha Incorretos");
                valid = false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Login ou senha incorretos");
        }
        return valid;

    }

    public boolean verificaLogin(String login) {
        boolean result = false;

        try {
            rs = stm.executeQuery("SELECT * FROM usuario where Login = '" + login + "';");
            if (rs.next()) {
                result = true;
            } else {
                result = false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problemas ao verificar banco!");
        }


        return result;
    }

    public boolean verificaMolecula(String nome_iupac) {
        boolean result = false;

        try {
            rs = stm.executeQuery("SELECT * FROM molecula where Nome_iupac = '" + nome_iupac + "';");
            if (rs.next()) {
                result = true;
            } else {
                result = false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problemas ao verificar banco!");
        }


        return result;
    }
      
    public void atualizarUsuario(String nome, String login, String password, String oldLogin) {

        if (verificaLogin(oldLogin)) {
            try {
                stm.executeUpdate("UPDATE usuario set Nome='" + nome + "' where Login='" + login + "';");
                stm.executeUpdate("UPDATE usuario set Login='" + login + "' where Login='" + oldLogin + "';");
                stm.executeUpdate("UPDATE usuario set Password='" + password + "' where Login='" + login + "';");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível alterar usuário:" + nome);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuário Não Cadastrado!");
        }

    }

    public void cadastrarUsuario(String nome, String login, String senha) {
        try {
            stm.executeUpdate("Insert INTO usuario (Nome,Login,Password) values('" + nome + "','" + login + "','" + senha + "');");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problemas ao cadastrar usuário!");
        }

    }

    public void cadastrarMolecula(String codigo, String nome, String nomeiupac, String familia,
            String especie, String atividade, String localizacao, float pesoMolecular,
            String formulaMolecular, float logp, String referencia) {

        try {
            stm.executeUpdate("Insert into molecula(Codigo,Nome,Nome_iupac,Familia,Especie,Atividade_biologica,Localizacao,Peso_molecular,Formula_moelcular,Logp,Referencia)values('" + codigo + "','" + nome + "','" + nomeiupac+"','"+familia+"','"+especie+"','"+atividade+"','"+localizacao+"',"+pesoMolecular+",'"+formulaMolecular+"',"+logp+",'"+referencia+"');");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problemas ao cadastrar Molécula!");
        }

    }

    public ResultSet retornarTodos() {
        try {
            rs = stm.executeQuery("SELECT * from usuario;");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problemas para acessar o banco! - Contatar o administrador");
        }

        return rs;
    }

    public ResultSet retornarTodas() {
        try {
            rs = stm.executeQuery("SELECT * from molecula;");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problemas para acessar o banco! - Contatar o administrador");
        }

        return rs;
    }

    public ResultSet nomePorPartes(String buscar) {
        try {
            rs = stm.executeQuery("SELECT * from usuario WHERE Login LIKE '%" + buscar + "%';");
        } catch (SQLException ex) {
            Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;

    }
    
    public ResultSet nomePorPartesMol(String buscar) {
        try {
            rs = stm.executeQuery("SELECT * from molecula WHERE Nome_iupac LIKE '%" + buscar + "%';");
        } catch (SQLException ex) {
            Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;

    }

    public void excluirUsuario(String login) {
        try {
            stm.executeUpdate("DELETE from usuario where Login ='" + login + "';");
        } catch (SQLException ex) {
            Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void excluirMolecula(String nome_iupac) {
        try {
            stm.executeUpdate("DELETE from molecula where Nome_iupac ='" + nome_iupac + "';");
        } catch (SQLException ex) {
            Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setValid() {
        if (valid == false) {
            this.valid = true;
        } else if (valid == true) {
            this.valid = false;
        }
    }
}
