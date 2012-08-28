package model;

import java.io.File;
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
     
     public void atualizaCaminho(String nomeiupac,String caminho){
        try {
            stm.executeUpdate("UPDATE molecula set Localizacao_arquivo='" + caminho + "' where Nome_iupac ='" + nomeiupac + "';");
        } catch (SQLException ex) {
            Logger.getLogger(SQLite.class.getName()).log(Level.SEVERE, null, ex);
        }
     
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
     
     public void atualizarArquivos() throws SQLException{
     
                stm.executeUpdate("UPDATE molecula set Localizacao_arquivo='" + "Molecules"+File.separator+"VE0AHA0SF.mol"+ "' where Nome_iupac ='" + "1-methyl-4-(propan-2-yl)benzene" + "';");
                stm.executeUpdate("UPDATE molecula set Localizacao_arquivo='" + "Molecules"+File.separator+"VE0BHA0SF.mol"+ "' where Nome_iupac ='" + "2-[4-(propan-2-yl)phenyl]ethan-1-ol" + "';");
                stm.executeUpdate("UPDATE molecula set Localizacao_arquivo='" + "Molecules"+File.separator+"VE0CHA0SF.mol"+ "' where Nome_iupac ='" + "2-(acetyloxy)benzoic acid" + "';");
                stm.executeUpdate("UPDATE molecula set Localizacao_arquivo='" + "Molecules"+File.separator+"VE0DHA0AF.mol"+ "' where Nome_iupac ='" + "1-[2-(6-acetyl-2,3,4-trihydroxyphenyl)-3,4,5- trihydroxyphenyl]ethan-1-one " + "';");          
                stm.executeUpdate("UPDATE molecula set Localizacao_arquivo='" + "Molecules"+File.separator+"VE0GHA0AF.mol"+ "' where Nome_iupac ='" + "(1S,10R,11S)-5-methoxy-6,12,12- trimethyltetracyclo[8.5.0.0^{1,11}.0^{3,8}]pentadeca- 3(8),4,6-triene-2,9-dione" + "';");
                stm.executeUpdate("UPDATE molecula set Localizacao_arquivo='" + "Molecules"+File.separator+"VE0HHA0AF.mol"+ "' where Nome_iupac ='" + "(11R,15S)-15-hydroxy-5-methoxy-6,12,12- trimethyltricyclo[9.4.0.0^{3,8}]pentadeca- 1,3(8),4,6-tetraen-9-one" + "';");
                stm.executeUpdate("UPDATE molecula set Localizacao_arquivo='" + "Molecules"+File.separator+"VE0IHA0AF.mol"+ "' where Nome_iupac ='" + "(11R)-6,12,12- trimethyltricyclo[9.4.0.0^{3,8}]pentadeca- 1,3(8),4,6-tetraen-5-ol" + "';");
                stm.executeUpdate("UPDATE molecula set Localizacao_arquivo='" + "Molecules"+File.separator+"VE0JHA0AF.mol"+ "' where Nome_iupac ='" + "(8R)-14-methoxy-7,7,13- trimethyltricyclo[9.4.0.0^{3,8}]pentadeca- 1(11),2,12,14-tetraene-4,10-dione" + "';");
                stm.executeUpdate("UPDATE molecula set Localizacao_arquivo='" + "Molecules"+File.separator+"VE0KHA0AF.mol"+ "' where Nome_iupac ='" + "(1R,3S,12R)-6-methoxy-7,12,13,13-tetramethyl-2- oxatetracyclo[10.4.0.0^{1,3}.0^{4,9}]hexadeca- 4(9),5,7-trien-10-one" + "';");
                stm.executeUpdate("UPDATE molecula set Localizacao_arquivo='" + "Molecules"+File.separator+"VE0LHA0AF.mol"+ "' where Nome_iupac ='" + "(11R,15S)-15-hydroxy-5-methoxy-6,12,12- trimethyltricyclo[9.4.0.0^{3,8}]pentadeca- 1,3(8),4,6-tetraen-9-one 2" + "';");
                stm.executeUpdate("UPDATE molecula set Localizacao_arquivo='" + "Molecules"+File.separator+"VE0MHA0AF.mol"+ "' where Nome_iupac ='" + "(1S,11S)-5-methoxy-6,12,12- trimethyltricyclo[9.4.0.0^{3,8}]pentadeca-3(8),4,6- trien-9-one" + "';");
                stm.executeUpdate("UPDATE molecula set Localizacao_arquivo='" + "Molecules"+File.separator+"VE0NHA0SF.mol"+ "' where Nome_iupac ='" + "(2E)-3-(4-hydroxy-3-methoxyphenyl)-N-[2-(1H- imidazol-4-yl)ethyl]prop-2-enamide " + "';");
                stm.executeUpdate("UPDATE molecula set Localizacao_arquivo='" + "Molecules"+File.separator+"VE0OHA0SF.mol"+ "' where Nome_iupac ='" + "(11S)-5-hydroxy-6,12,12- trimethyltricyclo[9.4.0.0^{3,8}]pentadeca- 1,3,5,7,14-pentaen-9-one" + "';");
                stm.executeUpdate("UPDATE molecula set Localizacao_arquivo='" + "Molecules"+File.separator+"VE0PHA0SF.mol"+ "' where Nome_iupac ='" + "(4aS,7R,8S,8aR)-8-[2-(furan-3-yl)ethyl]-4,7,8- trimethyl-1,2,4a,5,6,7,8,8a-octahydronaphthalen-2- one " + "';");
                stm.executeUpdate("UPDATE molecula set Localizacao_arquivo='" + "Molecules"+File.separator+"VE0RHA0SF.mol"+ "' where Nome_iupac ='" + "[(1R,2R,4aS,8aR)-1-[2-(furan-3-yl)ethyl]-2,5- dimethyl-7-oxo-1,2,3,4,4a,7,8,8a- octahydronaphthalen-1-yl]methyl acetate " + "';");
                stm.executeUpdate("UPDATE molecula set Localizacao_arquivo='" + "Molecules"+File.separator+"VE0SHA0SF.mol"+ "' where Nome_iupac ='" + "(1R,2R,5R,8R,9S,10S,13R,14R,17S,19R)- 1,2,5,14,18,18-hexamethyl-8-(prop-1-en-2- yl)pentacyclo[11.8.0.0^{2,10}.0^{5,9}.0^{14,19}]henicosan- 17-yl acetate" + "';");
                stm.executeUpdate("UPDATE molecula set Localizacao_arquivo='" + "Molecules"+File.separator+"VE0THA0SF.mol"+ "' where Nome_iupac ='" + "7-[(dimethylamino)methyl]-5,12-dimethoxy-2,9- dioxatetracyclo[6.6.2.0^{4,16}.0^{11,15}]hexadeca- 1(15),4(16),5,7,11,13-hexaene-3,10-dione" + "';");
                stm.executeUpdate("UPDATE molecula set Localizacao_arquivo='" + "Molecules"+File.separator+"VE0UHA0SF.mol"+ "' where Nome_iupac ='" + "(3aR,6aS,10R,10aS,10bS)-10a-hydroxy-2,10-dimethyl- 3,8-dioxo-7-(propan-2-ylidene)- 3H,3aH,4H,6aH,7H,8H,9H,10H,10aH,10bH- cyclohexa[e]azulen-5-yl acetate " + "';");
                stm.executeUpdate("UPDATE molecula set Localizacao_arquivo='" + "Molecules"+File.separator+"VE0VHA0SF.mol"+ "' where Nome_iupac ='" + "(9R)-4,5,15,16-tetramethoxy-10-methyl-10- azatetracyclo[7.7.1.0^{2,7}.0^{13,17}]heptadeca- 1(17),2,4,6,13,15-hexaen-3-ol" + "';");
                stm.executeUpdate("UPDATE molecula set Localizacao_arquivo='" + "Molecules"+File.separator+"VE0WHA0SF.mol"+ "' where Nome_iupac ='" + "(5S,12bR)-3,10-dimethoxy-5-methyl-7,8,12b,13- tetrahydro-5H-6000000-azatetraphene-2,11-diol " + "';");
                stm.executeUpdate("UPDATE molecula set Localizacao_arquivo='" + "Molecules"+File.separator+"VE0XHA0SF.mol"+ "' where Nome_iupac ='" + "(1R,9R)-3-hydroxy-4,13-dimethoxy-17- azatetracyclo[7.5.3.0^{1,10}.0^{2,7}]heptadeca- 2(7),3,5,10,13-pentaen-12-one" + "';");
                stm.executeUpdate("UPDATE molecula set Localizacao_arquivo='" + "Molecules"+File.separator+"VE0YHA0AF.mol"+ "' where Nome_iupac ='" + "(4R)-4-hydroxy-4-[(1E,3S)-3-hydroxybut-1-en-1-yl]- 3,5,5-trimethylcyclohex-2-en-1-one " + "';");
                stm.executeUpdate("UPDATE molecula set Localizacao_arquivo='" + "Molecules"+File.separator+"VE0ZHA0AF.mol"+ "' where Nome_iupac ='" + "(4aR,5S,6R,8aR)-5-[2-(furan-3-yl)ethyl]-5,6,8a- trimethyl-3,4,4a,5,6,7,8,8a-octahydronaphthalene-1- carboxylic acid " + "';");
                stm.executeUpdate("UPDATE molecula set Localizacao_arquivo='" + "Molecules"+File.separator+"VE0XGA0SF.mol"+ "' where Nome_iupac ='" + "(1R,4S,9R,10R,13R)-7-hydroxy-13-(hydroxymethyl)- 5,5,9- trimethyltetracyclo[11.2.1.0^{1,10}.0^{4,9}]hexadeca- 6,14-dien-8-one" + "';");
                stm.executeUpdate("UPDATE molecula set Localizacao_arquivo='" + "Molecules"+File.separator+"VE0YGA0AF.mol"+ "' where Nome_iupac ='" + "(2R,3S)-2-(3,4-dihydroxyphenyl)-3,4-dihydro-2H-1- benzopyran-3,5,7-triol 2" + "';");
                stm.executeUpdate("UPDATE molecula set Localizacao_arquivo='" + "Molecules"+File.separator+"VE0ZGA0SF.mol"+ "' where Nome_iupac ='" + "(1R,4S,5S,9S,10R,13S)-7-hydroxy-5-(hydroxymethyl)- 5,9,13- trimethyltetracyclo[11.2.1.0^{1,10}.0^{4,9}]hexadeca- 6,14-dien-8-one" + "';");
               
     
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
