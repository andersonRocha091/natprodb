/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Control.ControllerWindowPrincipal;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Stella
 */
public class Login extends JFrame {

    private JPanel mainPanel;
    private JLabel login;
    private JLabel senha;
    private JButton ok;
    private JButton cancel;
    private JPasswordField campoSenha;
    private JTextField campoLogin;

    public Login(ControllerWindowPrincipal controller) {
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle(".:: NatProDB - Autentication::.");


        login = new JLabel("Login: ");
        login.setBounds(20, 50, 200, 20);


        campoLogin = new JTextField();
        campoLogin.setBounds(80, 50, 150, 23);

        senha = new JLabel("Password:");
        senha.setBounds(20, 75, 200, 20);

        campoSenha = new JPasswordField();
        campoSenha.setBounds(80, 75, 150, 23);

        ok = new JButton();
        ok.setBounds(80,110, 60, 20);
        ok.addActionListener(controller);
        ok.setText("OK");
        //falta add ouvinte

        cancel = new JButton();
        cancel.setBounds(145,110,80, 20);
        cancel.addActionListener(controller);
        cancel.setText("Cancel");
        //falta add ouvinte

        mainPanel = new JPanel(null);
        mainPanel.setBounds(0, 0, 250, 400);

        mainPanel.add(login);
        mainPanel.add(senha);
        mainPanel.add(campoLogin);
        mainPanel.add(campoSenha);
        mainPanel.add(ok);
        mainPanel.add(cancel);


        this.setContentPane(mainPanel);
        this.setSize(250, 200);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

   /* public static void main(String[] args) {
        Login nova = new Login(ControllerWindowPrincipal);
        nova.showWindow();

    }*/

    public void showWindow() {

        this.setVisible(true);
    }

    public JButton getOK() {
        return ok;
    }
    public JButton getCancel(){
    return cancel;
}

    public String getLogin() {
        String temp = campoLogin.getText();
        return temp;

    }

    public char[] getPassword() {
        char[] temp = campoSenha.getPassword();
        return temp;

    }
}
