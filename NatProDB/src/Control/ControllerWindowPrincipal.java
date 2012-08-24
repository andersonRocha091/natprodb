/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Mysql;
import model.SQLite;
import view.JanelaExibirTodasMoleculas;
import view.JanelaPrincipal;
import view.JanelaSobre;
import view.Login;

/**
 *
 * @author Stella
 */
public class ControllerWindowPrincipal implements ActionListener {
    
    private Login janelaLogin = new Login(this);
    private JanelaPrincipal principal = new JanelaPrincipal(this);
    private String login;
    private String senha;
    private SQLite bank;
    private String password = "";
    private ResultSet result;
    private boolean validado;
    
    public ControllerWindowPrincipal(SQLite bank) {
        this.bank = bank;
        janelaLogin.showWindow();
        
    }
    
    public void showWindow() {
        principal.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == janelaLogin.getCancel()) {
            janelaLogin.setVisible(false);
            System.exit(0);
        } else if (e.getSource() == janelaLogin.getOK()) {
            String loginTemp = "nenhum";
            String PassTemp = "nenhum";
            
           // Mysql banco = new Mysql();
           // banco.abrirConexao();
            
            bank.initDB();
            login = janelaLogin.getLogin();
            senha = new String(janelaLogin.getPassword()); //ainda em caracter temporario.
            System.out.println("akeee: " + senha);
            /*for(int i=0;i<senha.length;i++){ //convertendo char[] em string;
            password += senha[i];    
            System.out.println("password:"+password);
            }*/
            
            
            validado = bank.auteticação(login, senha);
            
            if (validado == true) {
                JOptionPane.showMessageDialog(null, "Autentication Suceeded!");
                showWindow();
                janelaLogin.setVisible(false);
             //   banco.fecharConexao();
            } else {
               // System.out.println("nao vai a desgraça!");
            }
            
            
        } else if (e.getSource() == principal.getItemCadastraUsuario()) {
            ControllerCadastroUsuario controller = new ControllerCadastroUsuario(bank);
            controller.showWindow();
        }else if (e.getSource() == principal.getItemExibirTodos()){
           ControllerExibição controller = new ControllerExibição(bank);
           controller.showWindow();
        }else if(e.getSource() == principal.getItemAleteraRemoveUsuario()){
           ControllerAlterarExcluirUsuario controller = new ControllerAlterarExcluirUsuario(bank);
           controller.showWindow();
        }else if(e.getSource()==principal.getItemSobre()){
          JanelaSobre aboutView = new JanelaSobre();
          aboutView.setVisible(true);
          aboutView.setResizable(false);
        }else if(e.getSource()==principal.getItemSair()){
            System.exit(0);
        }else if(e.getSource()==principal.getItemCadastraMolecula()){
            ControllerCadastraMolecula controller = new ControllerCadastraMolecula(bank);
            controller.showWindow();
        }else if(e.getSource()==principal.getItemExibirTodas()){
            ControllerExibiçãoMoleculas controller  = new ControllerExibiçãoMoleculas(bank);
            controller.showWindow();
        } else if(e.getSource() == principal.getItemAlterarRemoverMol()){
            ControllerAlterarExcluirMolécula controller = new ControllerAlterarExcluirMolécula(bank);
            controller.showWindow();
        }
    }
}
