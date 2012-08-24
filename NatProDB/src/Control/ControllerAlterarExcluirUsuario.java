/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Mysql;
import model.SQLite;
import view.JanelaAlterarExcluirUsuario;
import view.JanelaAlterarUsuario;

/**
 *
 * @author Anderson Rocha.
 */
public class ControllerAlterarExcluirUsuario implements ActionListener, MouseListener {

    private JanelaAlterarExcluirUsuario alteraExcluiView = new JanelaAlterarExcluirUsuario(this);
    //private Mysql banco = new Mysql();
    private ResultSet resu = null;
    private JTable tabel;
    private String nome = "n";
    private String login = "l";
    private String password = "p";
    private Integer indice = -1;
    private DefaultTableModel model;
    private SQLite bank;

    public ControllerAlterarExcluirUsuario(SQLite bank) {
        this.bank = bank;
        resu = bank.retornarTodos();
        alteraExcluiView.preencherTabela(resu);
    }

    public void showWindow() {

        alteraExcluiView.setVisible(true);

    }

    public void dispose() {
        alteraExcluiView.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == alteraExcluiView.getCampoBusca()) {

            String nome = alteraExcluiView.getCampoBusca().getText();
      //      banco.abrirConexao();
            resu = bank.nomePorPartes(nome); 
            alteraExcluiView.preencherTabela(resu);
          //  banco.fecharConexao();
        } else if (e.getSource() == alteraExcluiView.getBotaoExcluir()) {
            if (indice == -1) {
                JOptionPane.showMessageDialog(null, "Selecione uma linha!");
            } else {
                //banco.abrirConexao();
                bank.excluirUsuario(login);
                //banco.fecharConexao();
                model.removeRow(tabel.getSelectedRow());
                tabel.setModel(model);
                JOptionPane.showMessageDialog(null, "Usuário Removido com Sucesso!");
                indice = -1;
            }
        } else if (e.getSource() == alteraExcluiView.getAlterar()) {

            if (nome.equals("n") || login.equals("l") || password.equals("p")) {
                JOptionPane.showMessageDialog(null, "Selecione um Usuário!");
            } else {
               ControllerAlteraUsuario control = new ControllerAlteraUsuario(bank,nome, login, password);
               control.showWindow();
               nome = "n";
               login = "l";
               password = "p";
            }


        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {


        tabel = alteraExcluiView.getTable();
        indice = tabel.getSelectedRow();
        nome = (String) tabel.getValueAt(indice, 1);
        login = (String) tabel.getValueAt(indice, 2);
       
        try {
             ResultSet res = bank.nomePorPartes(login);
            password = (String)res.getObject("Password");
        } catch (SQLException ex) {
            Logger.getLogger(ControllerAlterarExcluirUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        model = (DefaultTableModel) tabel.getModel();


    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
