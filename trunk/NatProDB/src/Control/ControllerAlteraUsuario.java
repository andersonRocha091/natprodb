/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Mysql;
import model.SQLite;
import view.JanelaAlterarUsuario;

/**
 *
 * @author Augusto Graça
 */
public class ControllerAlteraUsuario implements ActionListener {
    
    private JanelaAlterarUsuario janelaAlterar = new JanelaAlterarUsuario(this); 
    //private Mysql banco = new Mysql();
    private String nome, login, password;
    private SQLite bank;
    
    public ControllerAlteraUsuario(SQLite bank,String nome, String login, String password) {
        this.nome = nome;
        this.login = login;
        this.password = password;
        this.bank = bank;
        
        janelaAlterar.setTextNome(nome);
        janelaAlterar.setTextLogin(login);
        janelaAlterar.setTextPassword(password);
    }

    public void showWindow() {

        janelaAlterar.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == janelaAlterar.getCancel()) {
            janelaAlterar.setVisible(false);
        } else if (ae.getSource() == janelaAlterar.getOk()) {
            
            if(nome.equals("n")||login.equals("l")||password.equals("p")){
                JOptionPane.showMessageDialog(null, "Select a User!");
                janelaAlterar.dispose();
            }
            else{
                if(janelaAlterar.getNome().equals("")||janelaAlterar.getLogin().equals("")||janelaAlterar.getPassword().equals("")){
                JOptionPane.showConfirmDialog(null, "Fill the Obligatory Fields!");
                }
                else{
               // banco.abrirConexao();
                bank.atualizarUsuario(janelaAlterar.getNome(),janelaAlterar.getLogin(), janelaAlterar.getPassword(),login);
                //banco.fecharConexao();
                JOptionPane.showMessageDialog(null, "User Changed!");
                janelaAlterar.dispose();
                }
            }
            
            }
        }
}
    


    

