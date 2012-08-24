/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Control.ControllerCadastroUsuario;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Anderson
 */
public class JanelaCadastroUsuario extends JFrame {

    private JPanel mainPanel;
    private JLabel nome, login, password, teste;
    private JTextField campoNome, campoLogin;
    private JPasswordField campoSenha;
    private JButton ok, cancel;

    public JanelaCadastroUsuario(ControllerCadastroUsuario controller) {

        this.setTitle(".:: NatProDB- Your System of Management Molecules ::.");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(400, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        mainPanel = new JPanel(null);
        mainPanel.setBounds(0, 0, 400, 300);

        Font titulo_20 = new Font("Arial", Font.BOLD, 14);

        nome = new JLabel();
        nome.setText("Name(*): ");
        nome.setFont(titulo_20);
        nome.setBounds(30, 50, 80, 15);

        login = new JLabel();
        login.setText("Login(*):");
        login.setFont(titulo_20);
        login.setBounds(30, 100, 90, 17);

        
        teste = new JLabel();
        teste.setText("test");
        login.setFont(titulo_20);
        login.setBounds(30, 100, 60, 17);
        
        password = new JLabel();
        password.setText("Password(*):");
        password.setFont(titulo_20);
        password.setBounds(30, 150, 90, 17);

        campoNome = new JTextField("Nenhum");
        campoNome.setBounds(100, 46, 270, 20);

        campoLogin = new JTextField("Nenhum");
        campoLogin.setBounds(100, 96, 150, 20);

        campoSenha = new JPasswordField();
        campoSenha.setText("@");
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
        String password;
        char[] temp = campoSenha.getPassword();
        password = new String(temp);
        return password;
    }

    public JButton getCancel() {
        return cancel;
    }

    public JButton getOk() {
        return ok;
    }
}
