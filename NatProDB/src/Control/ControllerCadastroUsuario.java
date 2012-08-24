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
import view.JanelaCadastroUsuario;

/**
 *
 * @author Anderson
 */
public class ControllerCadastroUsuario implements ActionListener {

    private JanelaCadastroUsuario janelaCadastro = new JanelaCadastroUsuario(this);
     //Mysql banco = new Mysql();
    private SQLite bank;
    
    public ControllerCadastroUsuario(SQLite bank) {
        this.bank = bank;
    }

    public void showWindow() {

        janelaCadastro.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == janelaCadastro.getCancel()) {
            janelaCadastro.setVisible(false);
        } else if (ae.getSource() == janelaCadastro.getOk()) {

            if (janelaCadastro.getNome().equals("Nenhum") || janelaCadastro.getLogin().equals("Nenhum") || janelaCadastro.getPassword().equals("@")) {
            JOptionPane.showMessageDialog(null,"Algum campo não foi preenchido!");
            }
            else{
                //banco.abrirConexao();
                
                if(bank.verificaLogin(janelaCadastro.getLogin())==true){
                    //banco.fecharConexao();
                    JOptionPane.showMessageDialog(null, "Login yet exists - Try again!");
                
                }
                else{
                    bank.cadastrarUsuario(janelaCadastro.getNome(), janelaCadastro.getLogin(), janelaCadastro.getPassword());
                    JOptionPane.showMessageDialog(null, "User Inserted With Sucess!");
                    janelaCadastro.dispose();
//                    banco.fecharConexao();
                }
            
            }
        }

    }
}
