/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Anderson Rocha
 */
public class JanelaExibirTodosUsuários extends JFrame{
    
    private JPanel mainPanel;
    private JLabel titulo;
    private JScrollPane rolagem;
    private JTable tabela;
    private DefaultTableModel modelo = new DefaultTableModel();
    private ResultSet result = null;
    
    public JanelaExibirTodosUsuários(ResultSet resut){
        
        this.setTitle(".:: NatProDB - All Users ::.");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(600, 460);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
       
        result = resut;
        mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 500, 450);
        
        rolagem = new JScrollPane();
        rolagem.setBounds(0, 0, 550, 450);
        mainPanel.add(rolagem);
        modelo = new DefaultTableModel();
        criarTabela();
        preencherTabela(resut);
       
        //rolagem.setViewportView(tabela);
        this.setContentPane(mainPanel);
        rolagem.setViewportView(tabela); 
    
    
    }
    
    private void criarTabela(){
        tabela = new JTable(modelo);
        modelo.addColumn("Code");
        modelo.addColumn("Name");
        modelo.addColumn("Login");
        tabela.getColumnModel().getColumn(0).setPreferredWidth(20); 
        tabela.getColumnModel().getColumn(1).setPreferredWidth(80);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(50);
        
    }
    
    public void preencherTabela(ResultSet res){
    
    ResultSet rs = res;
    
    Object[] obj = new Object[3];
        try {
            rs.next();
            do{
            obj[0] = rs.getObject("Codigo");
            obj[1] = rs.getObject("Nome");
            obj[2] = rs.getObject("Login");
            modelo.addRow(obj);
            }while(rs.next());
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problem to acess the bank!");
        }
    
    
    }
    
}
