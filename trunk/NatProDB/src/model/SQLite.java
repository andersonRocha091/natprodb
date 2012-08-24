package model;

import java.lang.String;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SQLite {

    private Connection conn;
    private Statement stm;
    private ResultSet rs = null;
    private boolean valid;
   
   
    public SQLite(String arquivo) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        this.conn = DriverManager.getConnection("jdbc:sqlite:" + arquivo);
        this.stm = this.conn.createStatement();
    }

    public void initDB() {
        try {
            
            this.stm.executeUpdate("DROP TABLE IF EXISTS pessoa");
            this.stm.executeUpdate("CREATE TABLE IF NOT EXISTS usuario("
                    + "Codigo INTEGER Primary key NOT NULL,"
                    + "Nome varchar(120) NOT NULL,"
                    + "Login varchar(30) NOT NULL,"
                    + "Password varchar(20)NOT NULL"
                    + ");");
      //stm.executeUpdate("DROP TABLE molecula");
            
            this.stm.executeUpdate("CREATE TABLE IF NOT EXISTS molecula("
                    + "Codigo varchar(15) Primary key NOT NULL,"
                    + "Nome varchar(90) NOT NULL,"
                    + "Nome_iupac varchar(30) NOT NULL,"
                    + "Familia varchar(30),"
                    + "Especie varchar(40),"
                    + "Smile varchar(200),"
                    + "HBA integer,"
                    + "HBD integer,"
                    + "Atividade_biologica varchar(600),"
                    + "Localizacao varchar(300),"
                    + "Localizacao_arquivo varchar(70),"
                    + "Peso_molecular float NOT NULL,"
                    + "Formula_molecular varchar(20)NOT NULL,"
                    + "Logp float NOT NULL,"
                    + "Referencia varchar(1000),"
                    + "Data DATE, "
                    +"Datamod DATE,"
                    +"Hora TIME,"
                    +"Tipo Varchar(13) NOT NULL"
                    +");");
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
            JOptionPane.showMessageDialog(null, "Problem to verify the bank!");
        }


        return result;
    }
     public void cadastrarMolecula(String codigo, String nome, String nomeiupac, String familia,
            String especie,String smile,int hba,int hbd, String atividade, String localizacao,String localizacao_arq, float pesoMolecular,
            String formulaMolecular, float logp, String referencia,String data,String hora, String tipo) {
       
        System.out.println("\n codigo:"+codigo+"\nnome:"+nome+"\niupac:"+nomeiupac+"\nfamilia:"+familia+"\nespecie:"+especie+"\nsmile:"+smile+"\nHba:"+hba+"\nHbd:"+hbd+"\natividade:"+atividade+"\nlocalização:"+localizacao+"\npeso:"+pesoMolecular+"\nformula:"+formulaMolecular+"\nLOGP:"+logp+"\nreferencia:"+referencia+"\nData: "+data+"\nHora:"+hora);
         
        try {
            stm.executeUpdate("INSERT INTO molecula(Codigo,Nome,Nome_iupac,Familia,Especie,Smile,HBA,HBD,Atividade_biologica,Localizacao,Localizacao_arquivo,Peso_molecular,Formula_molecular,Logp,Referencia,Data,Datamod,Hora,Tipo) VALUES('" + codigo + "','" +nome+ "','"+nomeiupac+"','"+familia+"','"+especie+"','"+smile+"',"+hba+","+hbd+",'"+atividade+"','"+localizacao+"','"+localizacao_arq+"',"+pesoMolecular+",'"+formulaMolecular+"',"+logp+",'"+referencia+"','"+data+"','"+data+"','"+hora+"','"+tipo+"');");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problem to Insert the Molecule!");
           // System.out.println(ex.getNextException());
        }

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
            JOptionPane.showMessageDialog(null, "Problem to verify the bank!");
        }
        
        return result;
    }
     
     public void atualizarMolecula(String codigo, String nome, String nomeiupac, String familia,
            String especie,String smile,int hba,int hbd,String atividade, String localizacao,String localizacao_arq, float pesoMolecular,
            String formulaMolecular, float logp, String referencia, String oldNomeIupac,String data,String hora, String tipo) {

        if (verificaMolecula(oldNomeIupac)) {
            
            try {
                stm.executeUpdate("UPDATE molecula set Codigo='" + codigo + "' where Nome_iupac ='" + oldNomeIupac + "';");
                stm.executeUpdate("UPDATE molecula set Nome='" + nome + "' where Nome_iupac='" + oldNomeIupac + "';");
                stm.executeUpdate("UPDATE molecula set Nome_iupac='" + nomeiupac + "' where Nome_iupac='" + oldNomeIupac+"';");
                stm.executeUpdate("UPDATE molecula set Familia='" + familia + "' where Nome_iupac='" + nomeiupac+"';");
                stm.executeUpdate("UPDATE molecula set Especie='" + especie + "' where Nome_iupac='" + nomeiupac+"';");
                stm.executeUpdate("UPDATE molecula set Smile='" + smile + "' where Nome_iupac='" + nomeiupac+"';");
                stm.executeUpdate("UPDATE molecula set HBA='" + hba + "' where Nome_iupac='" + nomeiupac+"';");
                stm.executeUpdate("UPDATE molecula set HBD='" + hbd + "' where Nome_iupac='" + nomeiupac+"';");
                stm.executeUpdate("UPDATE molecula set Atividade_biologica='" + atividade + "' where Nome_iupac='" + nomeiupac+"';");
                stm.executeUpdate("UPDATE molecula set Localizacao='" + localizacao + "' where Nome_iupac='" + nomeiupac+"';");
                stm.executeUpdate("UPDATE molecula set Peso_molecular='" + pesoMolecular + "' where Nome_iupac='" + nomeiupac+"';");
                stm.executeUpdate("UPDATE molecula set Formula_molecular='" + formulaMolecular + "' where Nome_iupac='" + nomeiupac+"';");
                stm.executeUpdate("UPDATE molecula set Logp='" +logp+ "' where Nome_iupac='" + nomeiupac+"';");
                stm.executeUpdate("UPDATE molecula set Referencia='" +referencia+ "' where Nome_iupac='" + nomeiupac+"';");
                stm.executeUpdate("UPDATE molecula set Datamod='" +data+ "' where Nome_iupac='" + nomeiupac+"';");
                stm.executeUpdate("UPDATE molecula set Hora='" +hora+ "' where Nome_iupac='" + nomeiupac+"';");
                 stm.executeUpdate("UPDATE molecula set Tipo='" +tipo+ "' where Nome_iupac='" + nomeiupac+"';");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível alterar a Molécula:" + nome);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Molecule Not Inserted!");
        }

    }
     
     public void excluirMolecula(String nome_iupac) {
        try {
            stm.executeUpdate("DELETE from molecula where Nome_iupac ='" + nome_iupac + "';");
        } catch (SQLException ex) {
            Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     
     
     public ResultSet retornarTodas() {
        try {
            rs = stm.executeQuery("SELECT * FROM molecula;");
            System.out.println("entrei");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problem to acess the bank! - Contact the manager");
        }

        return rs;
    }

   public void cadastrarUsuario(String nome, String login, String senha) {
        try {
            stm.executeUpdate("Insert INTO usuario (Nome,Login,Password) values('" + nome + "','" + login + "','" + senha + "');");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problem to Insert the User!");
        }

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
            JOptionPane.showMessageDialog(null, "User Not Inserted!");
        }

    }
   
   public ResultSet retornarTodos() {
        try {
           rs = this.stm.executeQuery("SELECT * FROM usuario;");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problem to access the bank! - Contact the manager");
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
    public ResultSet regraDeLinpsky(String buscar){
    try {
            rs = stm.executeQuery("SELECT * from molecula WHERE Nome_iupac LIKE '%" + buscar + "%'AND HBD <=5 AND HBA<=10 AND Logp<=5 AND Peso_molecular<=500;");
        } catch (SQLException ex) {
            Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
     public ResultSet buscaPorSmile(String buscar) {
        try {
            rs = stm.executeQuery("SELECT * from molecula WHERE Smile LIKE '%" + buscar + "%';");
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
            JOptionPane.showMessageDialog(null, "Login or password incorrect");
        }
        return valid;

    }
    
    public void setValid() {
        if (valid == false) {
            this.valid = true;
        } else if (valid == true) {
            this.valid = false;
        }
    }

    public void removePessoa(String nome) {
        try {
            this.stm = this.conn.createStatement();
            this.stm.executeUpdate("DELETE FROM pessoas WHERE nome = \"" + nome + "\"");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Vector getAll() {
        Vector lista = new Vector();
        ResultSet rs;
        try {
            rs = this.stm.executeQuery("SELECT * FROM pessoas ORDER BY idade");

            while (rs.next()) {
       //         lista.add(new Pessoa(rs.getString("nome"), rs.getInt("idade")));
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
