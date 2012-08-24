/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Control.ControllerAlterarExcluirMolécula;
import Control.ControllerAlterarExcluirUsuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 1
 */
public class JanelaAlterarExcluirMolecula extends javax.swing.JFrame {

    /**
     * Creates new form JanelaAlterarExcluirUsuario
     */
    private JTable tabela;
    private DefaultTableModel modelo = new DefaultTableModel(){
        public boolean isCellEditable(int rowIndex, int mColIndex) {  
                return false;  
            }};
       
    private ControllerAlterarExcluirMolécula controller;

    public JanelaAlterarExcluirMolecula(ControllerAlterarExcluirMolécula controller) {
        initComponents();
        this.controller = controller;
        criarTabela();
        campoBusca.addActionListener(controller);
        botaoExcluir.addActionListener(controller);
        botãoAlterar.addActionListener(controller);
        botaoClear.addActionListener(controller);
        botaoSearch.addActionListener(controller);
        rolagem.setViewportView(tabela);
    }

    

    private void criarTabela() {
        tabela = new JTable(modelo);
        tabela.addMouseListener(controller);
        modelo.addColumn("Code");//0
        modelo.addColumn("Name");//1
        modelo.addColumn("IUPAC Name");//2
        modelo.addColumn("Family");//3
        modelo.addColumn("specie");//4
        modelo.addColumn("Type");//5
        modelo.addColumn("HBA");//6
        modelo.addColumn("HBD");//7 
        modelo.addColumn("File");//8
        modelo.addColumn("MWT(Da)");//9
        modelo.addColumn("Molecular Formula");//10
        modelo.addColumn("CLogP");//11       
        modelo.addColumn("Data Inserted");//12
        modelo.addColumn("Data Modification");//13
        modelo.addColumn("Hour");//14
        tabela.getColumnModel().getColumn(0).setPreferredWidth(15);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(50);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(50);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(50);
        tabela.getColumnModel().getColumn(4).setPreferredWidth(50);
        tabela.getColumnModel().getColumn(5).setPreferredWidth(20);
        tabela.getColumnModel().getColumn(6).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(7).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(8).setPreferredWidth(80);
        tabela.getColumnModel().getColumn(9).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(10).setPreferredWidth(20);
        tabela.getColumnModel().getColumn(11).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(12).setPreferredWidth(20);
        tabela.getColumnModel().getColumn(13).setPreferredWidth(20);
        tabela.getColumnModel().getColumn(14).setPreferredWidth(20);
        
    }
    
     public void preencherTabela(ResultSet res) {

        ResultSet rs = res;
        modelo.setNumRows(0);
        Object[] obj = new Object[18];
        try {
            rs.next();
                       
            do {
                obj[0] = rs.getObject("Codigo");
                obj[1] = rs.getObject("Nome");
                obj[2] = rs.getObject("Nome_iupac");
                obj[3] = rs.getObject("Familia");
                obj[4] = rs.getObject("Especie");
                obj[5] = rs.getObject("Tipo");
                obj[6] = rs.getObject("HBA");
                obj[7] = rs.getObject("HBD");
                obj[8] = rs.getObject("Localizacao_arquivo");
                obj[9] = rs.getObject("Peso_molecular");
                obj[10] = rs.getObject("Formula_molecular");
                obj[11] = rs.getObject("Logp");
                obj[12] = rs.getObject("Data");
                obj[13] = rs.getObject("Datamod");
                obj[14] = rs.getObject("Hora");
                modelo.addRow(obj);
            } while (rs.next());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nenhuma molécula cadastrada no banco!");
        }
     }

    public JButton getBotaoExcluir() {
        return botaoExcluir;
    }

    public JButton getBotãoAlterar() {
        return botãoAlterar;
    }

    public JTextField getCampoBusca() {
        return campoBusca;
    }
    
    public JTable getTable(){
    return tabela;
    }
    
    public JButton getAlterar(){
    return botãoAlterar;
    } 
    public JComboBox getComboBoxFind(){
    return comboBoxSelectFind;
    }

    public JCheckBox getCheckLipinski() {
        return checkLipinski;
    }
     public JButton getBotaoClear() {
        return botaoClear;
    }
     
    public JButton getBotaoSearch() {
        return botaoSearch;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campoBusca = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        mainPanel = new javax.swing.JPanel();
        rolagem = new javax.swing.JScrollPane();
        botãoAlterar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        comboBoxSelectFind = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        checkLipinski = new javax.swing.JCheckBox();
        botaoClear = new javax.swing.JButton();
        botaoSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(".:: NatProDB - Alterar/Excluir Usuário::.");

        campoBusca.setFont(new java.awt.Font("Times New Roman", 0, 12));

        mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Molecules", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rolagem, javax.swing.GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rolagem, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                .addContainerGap())
        );

        botãoAlterar.setText("Change");

        botaoExcluir.setText("Exclude");

        comboBoxSelectFind.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "IUPAC's Name", "Smile", " " }));
        comboBoxSelectFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxSelectFindActionPerformed(evt);
            }
        });

        jLabel1.setText("Find for:");

        checkLipinski.setText("Regra de Lipinski");

        botaoClear.setText("Clear");

        botaoSearch.setText("Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxSelectFind, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkLipinski)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(campoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoSearch)))
                .addGap(36, 36, 36))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 718, Short.MAX_VALUE)
                .addComponent(botãoAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoExcluir)
                .addGap(37, 37, 37))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxSelectFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(botaoClear)
                            .addComponent(botaoSearch))
                        .addGap(27, 27, 27)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(checkLipinski)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botãoAlterar)
                    .addComponent(botaoExcluir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxSelectFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSelectFindActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxSelectFindActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoClear;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoSearch;
    private javax.swing.JButton botãoAlterar;
    private javax.swing.JTextField campoBusca;
    private javax.swing.JCheckBox checkLipinski;
    private javax.swing.JComboBox comboBoxSelectFind;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane rolagem;
    // End of variables declaration//GEN-END:variables
}
