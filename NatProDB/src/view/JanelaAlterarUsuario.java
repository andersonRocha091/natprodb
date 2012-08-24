/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Control.ControllerAlteraUsuario;
import Control.ControllerAlterarExcluirUsuario;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Augusto Graça
 */
public class JanelaAlterarUsuario extends JFrame {
     private JPanel mainPanel;
    private JLabel nome, login, password, teste;
    private JTextField campoNome, campoLogin,campoSenha;
    private JButton ok, cancel;

    public JanelaAlterarUsuario (ControllerAlteraUsuario controller) {

        this.setTitle(".:: NatProDB - Your System of Management of Molecules ::.");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(400, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        mainPanel = new JPanel(null);
        mainPanel.setBounds(0, 0, 400, 300);

        Font titulo_20 = new Font("Arial", Font.BOLD, 14);

        nome = new JLabel();
        nome.setText("Name: ");
        nome.setFont(titulo_20);
        nome.setBounds(30, 50, 60, 10);

        login = new JLabel();
        login.setText("Login: ");
        login.setFont(titulo_20);
        login.setBounds(30, 100, 60, 17);

        
        teste = new JLabel();
        teste.setText("test ");
        login.setFont(titulo_20);
        login.setBounds(30, 100, 60, 17);
        
        password = new JLabel();
        password.setText("Password :");
        password.setFont(titulo_20);
        password.setBounds(30, 150, 90, 17);

        campoNome = new JTextField();
        campoNome.setBounds(90, 46, 270, 20);

        campoLogin = new JTextField();
        campoLogin.setBounds(90, 96, 150, 20);

        campoSenha = new JPasswordField();
        campoSenha.setBounds(125, 150, 150, 20);

        ok = new JButton();
        ok.setText("Ok");
        ok.setBounds(220, 220, 50, 20);
        ok.addActionListener(controller);
        
        cancel = new JButton();
        cancel.setText("Cancel");
        cancel.setBounds(275, 220, 85, 20);
        cancel.addActionListener(controller);

        mainPanel.add(nome);
        mainPanel.add(login);
        mainPanel.add(password);
        mainPanel.add(campoNome);
        mainPanel.add(campoLogin);
        mainPanel.add(campoSenha);
        mainPanel.add(ok);
        mainPanel.add(cancel);
        this.setContentPane(mainPanel);
    }

    public String getNome() {
        return campoNome.getText();
    }

    public String getLogin() {
        return campoLogin.getText();
    }

    public String getPassword() {
        return campoSenha.getText();
    }

    public JButton getCancel() {
        return cancel;
    }

    public JButton getOk() {
        return ok;
    }
    public void setTextNome(String nome){
     campoNome.setText(nome);
    }
    public void setTextLogin(String login){
     campoLogin.setText(login);
    }
    public void setTextPassword(String password){
     campoSenha.setText(password);
    }
    
}

