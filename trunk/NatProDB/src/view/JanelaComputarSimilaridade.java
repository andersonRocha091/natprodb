/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Control.ControllerAlterarExcluirMolécula;
import Control.ControllerAlterarExcluirUsuario;
import Control.ControllerComputeSimilarity;
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
 * @author Anderson Souza Rocha
 */
public class JanelaComputarSimilaridade extends javax.swing.JFrame {

    /**
     * Creates new form JanelaAlterarExcluirUsuario
     */
    private JTable tabela;
    private DefaultTableModel modelo = new DefaultTableModel(){
        public boolean isCellEditable(int rowIndex, int mColIndex) {  
                return false;  
            }};
       
    private ControllerComputeSimilarity controller;

    public JanelaComputarSimilaridade(ControllerComputeSimilarity controller) {
        initComponents();
        this.controller = controller;
        criarTabela();
        campoInsereMolecula.addActionListener(controller);
        //botaoExcluir.addActionListener(controller);
        //botãoAlterar.addActionListener(controller);
        botaoClear.addActionListener(controller);
        botaoSearch.addActionListener(controller);
        checkInBank.addActionListener(controller);
        rolagem.setViewportView(tabela);
    }

    

    private void criarTabela() {
        tabela = new JTable(modelo);
      //  tabela.addMouseListener(controller);
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
       // modelo.setNumRows(0);
        Object[] obj = new Object[18];
        try {
              
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
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nenhuma molécula cadastrada no banco!");
        }
     }

   

    public JTextField getCampoBusca() {
        return campoBusca;
    }
    
    public JTable getTable(){
    return tabela;
    }
    public JTextField getCampoInsereMolecula(){
    return campoInsereMolecula;
    }
    

    public JCheckBox getCheckInBank() {
        return checkInBank;
    }
     public JButton getBotaoClear() {
        return botaoClear;
    }
     
    public JButton getBotaoSearch() {
        return botaoSearch;
    }
    public int getPorcetagemSimilaridade(){
    
        String perct = jComboBox1.getSelectedItem().toString();
        int indice = Integer.parseInt(perct);
        return indice;
    }
    public void limpaTabela(){  
    int teste = modelo.getRowCount();
    if(teste>0){
        while(teste>=0){
        modelo.removeRow(0);
        teste--;
    }
    
    }
    
  
}  
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campoInsereMolecula = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        mainPanel = new javax.swing.JPanel();
        rolagem = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        checkInBank = new javax.swing.JCheckBox();
        botaoClear = new javax.swing.JButton();
        botaoSearch = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        campoBusca = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(".:: NatProDB - Alterar/Excluir Usuário::.");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        campoInsereMolecula.setFont(new java.awt.Font("Times New Roman", 0, 12));
        getContentPane().add(campoInsereMolecula, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 550, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 93, 1170, 10));

        mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Molecules", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(rolagem, javax.swing.GroupLayout.PREFERRED_SIZE, 1099, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rolagem, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 114, -1, -1));

        jLabel1.setText("Smile of target:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 21, -1, -1));

        checkInBank.setText("Search in database");
        getContentPane().add(checkInBank, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, -1));

        botaoClear.setText("Clear");
        getContentPane().add(botaoClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 20, -1, -1));

        botaoSearch.setText("Search");
        getContentPane().add(botaoSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 20, -1, -1));

        jLabel2.setText("Molecule to comparison:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 49, -1, -1));

        campoBusca.setFont(new java.awt.Font("Times New Roman", 0, 12));
        getContentPane().add(campoBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 550, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "100", "90", "80", "70", "60", "50" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, 90, -1));

        jLabel3.setText("%");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoClear;
    private javax.swing.JButton botaoSearch;
    private javax.swing.JTextField campoBusca;
    private javax.swing.JTextField campoInsereMolecula;
    private javax.swing.JCheckBox checkInBank;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane rolagem;
    // End of variables declaration//GEN-END:variables

    public Object getcampoBusca() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
