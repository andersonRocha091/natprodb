/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JanelaCadastrarMolecula.java
 *
 * Created on 28/02/2012, 21:20:01
 */
package view;

import Control.ControllerCadastraMolecula;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author PETENGS
 */
public class JanelaCadastrarMolecula extends javax.swing.JFrame {

    /** Creates new form JanelaCadastrarMolecula */
    public JanelaCadastrarMolecula(ControllerCadastraMolecula control) {
        initComponents();
        botaoCancelar.addActionListener(control);
        botaoOk.addActionListener(control);
        botãoCarregar.addActionListener(control);
        comboBox.addActionListener(control);
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelFamilia1 = new javax.swing.JLabel();
        labelSmile1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        labelCodigo = new javax.swing.JLabel();
        campocodigo = new javax.swing.JTextField();
        labelNome = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        campoNomeIupac = new javax.swing.JTextField();
        labelNomeIupac = new javax.swing.JLabel();
        comboBox = new javax.swing.JComboBox();
        labelFamilia = new javax.swing.JLabel();
        campoFamilia = new javax.swing.JTextField();
        labelEspecie = new javax.swing.JLabel();
        campoEspecie = new javax.swing.JTextField();
        labelAtividadeBio = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaAtividadeBio = new javax.swing.JTextArea();
        labelLocalizacao = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaLocalização = new javax.swing.JTextArea();
        labelArquivo = new javax.swing.JLabel();
        campoArquivo = new javax.swing.JTextField();
        botãoCarregar = new javax.swing.JButton();
        fórmulaMolecular = new javax.swing.JLabel();
        campoFormulaMolecular = new javax.swing.JTextField();
        pesoMoelcular = new javax.swing.JLabel();
        campoPesoMolecular = new javax.swing.JTextField();
        labelLog = new javax.swing.JLabel();
        campoLogP = new javax.swing.JTextField();
        labelReferencia = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        areaReferencia = new javax.swing.JTextArea();
        botaoOk = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        labelSmile = new javax.swing.JLabel();
        campoSmile = new javax.swing.JTextField();
        labelHBA = new javax.swing.JLabel();
        campoHba = new javax.swing.JTextField();
        campoHbd = new javax.swing.JTextField();
        labelHBA1 = new javax.swing.JLabel();

        labelFamilia1.setText("Família:");

        labelSmile1.setText("Smile:");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(".:: NatProDB::. - Cadastro de Molécula");

        labelCodigo.setText("Code(*):");

        labelNome.setText(" Name(*):");

        labelNomeIupac.setText(" IUPAC Name(*):");

        comboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sintetic", "Semi-Sintetic", "Natural" }));
        comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxActionPerformed(evt);
            }
        });

        labelFamilia.setText("Family:");

        campoFamilia.setFont(campoFamilia.getFont().deriveFont((campoFamilia.getFont().getStyle() | java.awt.Font.ITALIC)));

        labelEspecie.setText("Specie:");

        campoEspecie.setFont(campoEspecie.getFont().deriveFont((campoEspecie.getFont().getStyle() | java.awt.Font.ITALIC)));

        labelAtividadeBio.setText("Activity Biologic:");

        areaAtividadeBio.setColumns(20);
        areaAtividadeBio.setRows(5);
        jScrollPane1.setViewportView(areaAtividadeBio);

        labelLocalizacao.setText("Location:");

        areaLocalização.setColumns(20);
        areaLocalização.setRows(5);
        jScrollPane2.setViewportView(areaLocalização);

        labelArquivo.setText("File:");

        botãoCarregar.setText("Load");

        fórmulaMolecular.setText("Molecular Formula(*):");

        pesoMoelcular.setText("MWT(Da)(*):");

        labelLog.setText("CLogP:");

        labelReferencia.setText("References:");

        areaReferencia.setColumns(20);
        areaReferencia.setRows(5);
        jScrollPane3.setViewportView(areaReferencia);

        botaoOk.setText("OK");

        botaoCancelar.setText("Cancel");

        labelSmile.setText("Smile(*):");

        labelHBA.setText("HBA:");

        labelHBA1.setText("HBD:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelAtividadeBio)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(labelSmile)
                                .addGap(18, 18, 18)
                                .addComponent(campoSmile, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                                .addGap(43, 43, 43)
                                .addComponent(labelHBA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoHba, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(labelHBA1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoHbd, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(labelCodigo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campocodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelNomeIupac)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoNomeIupac, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(labelNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 283, Short.MAX_VALUE)
                                .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelLocalizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(botaoOk)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(botaoCancelar))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(fórmulaMolecular)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoFormulaMolecular, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                                                .addComponent(pesoMoelcular)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoPesoMolecular, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(127, 127, 127)
                                                .addComponent(labelLog)
                                                .addGap(18, 18, 18))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(labelArquivo)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(campoArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(campoLogP)
                                            .addComponent(botãoCarregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(labelFamilia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(labelEspecie)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoEspecie, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)))
                        .addGap(82, 82, 82))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCodigo)
                    .addComponent(campocodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNomeIupac)
                    .addComponent(campoNomeIupac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNome)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFamilia)
                    .addComponent(campoFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEspecie)
                    .addComponent(campoEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSmile)
                    .addComponent(campoSmile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelHBA)
                    .addComponent(campoHba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelHBA1)
                    .addComponent(campoHbd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(labelAtividadeBio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(labelLocalizacao)))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelArquivo)
                    .addComponent(campoArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botãoCarregar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLog)
                    .addComponent(campoLogP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fórmulaMolecular)
                    .addComponent(campoFormulaMolecular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pesoMoelcular)
                    .addComponent(campoPesoMolecular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoOk)
                            .addComponent(botaoCancelar)))
                    .addComponent(labelReferencia))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxActionPerformed

    public JButton getBotaoCancelar() {
        return botaoCancelar;
    }

    public JButton getBotaoOk() {
        return botaoOk;
    }

    public String getCodigo() {
        return campocodigo.getText();
    }

    public String getNome() {
        return campoNome.getText();
    }
    public String getNomeiupac() {
        return campoNomeIupac.getText();
    }
    public String getFamilia() {
        return campoFamilia.getText();
    }

    public JTextField getCampoArquivo() {
        return campoArquivo;
    }
    public String getEspecie() {
        return campoEspecie.getText();
    }

    public JTextArea getAreaAtividadeBio() {
        return areaAtividadeBio;
    }

    public JTextArea getAreaLocalização() {
        return areaLocalização;
    }

    public JTextField getCampoEspecie() {
        return campoEspecie;
    }

    public JTextField getCampoFamilia() {
        return campoFamilia;
    }
    public String getAtividadebiologica() {
        return areaAtividadeBio.getText();
    }
    public String getLocalizacao() {
        return areaLocalização.getText();
    }
    public String getFormulaMolecular() {
        return campoFormulaMolecular.getText();
    }
    public float getPesoMolecular() {
        float peso;
        peso = Float.parseFloat(campoPesoMolecular.getText()); 
        return peso;
    }
    public float getLogp() {
        float log;
        log= Float.parseFloat(campoLogP.getText()); 
        return log;
    }
    
    public String getSmile(){
    return campoSmile.getText();
    }
    
    public int getHba(){
    int hba;
    hba = Integer.parseInt(campoHba.getText());
    return hba;
    }
    
    public int getHbd(){
    int hbd;
    hbd = Integer.parseInt(campoHbd.getText());
    return hbd;
    }
    
    public String getReferencia() {
        return areaReferencia.getText();
    }

    public JTextField getCampoHba() {
        return campoHba;
    }

    public JTextField getCampoHba1() {
        return campoHbd;
    }

    public JTextField getCampoSmile() {
        return campoSmile;
    }

    public JTextField getCampoLogP() {
        return campoLogP;
    }

    public JTextField getCampoPesoMolecular() {
        return campoPesoMolecular;
    }

    public JButton getBotãoCarregar() {
        return botãoCarregar;
    }
    public String getTipo(){
    return (String) comboBox.getSelectedItem();
    }
    
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaAtividadeBio;
    private javax.swing.JTextArea areaLocalização;
    private javax.swing.JTextArea areaReferencia;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoOk;
    private javax.swing.JButton botãoCarregar;
    private javax.swing.JTextField campoArquivo;
    private javax.swing.JTextField campoEspecie;
    private javax.swing.JTextField campoFamilia;
    private javax.swing.JTextField campoFormulaMolecular;
    private javax.swing.JTextField campoHba;
    private javax.swing.JTextField campoHbd;
    private javax.swing.JTextField campoLogP;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoNomeIupac;
    private javax.swing.JTextField campoPesoMolecular;
    private javax.swing.JTextField campoSmile;
    private javax.swing.JTextField campocodigo;
    private javax.swing.JComboBox comboBox;
    private javax.swing.JLabel fórmulaMolecular;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelArquivo;
    private javax.swing.JLabel labelAtividadeBio;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelEspecie;
    private javax.swing.JLabel labelFamilia;
    private javax.swing.JLabel labelFamilia1;
    private javax.swing.JLabel labelHBA;
    private javax.swing.JLabel labelHBA1;
    private javax.swing.JLabel labelLocalizacao;
    private javax.swing.JLabel labelLog;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelNomeIupac;
    private javax.swing.JLabel labelReferencia;
    private javax.swing.JLabel labelSmile;
    private javax.swing.JLabel labelSmile1;
    private javax.swing.JLabel pesoMoelcular;
    // End of variables declaration//GEN-END:variables
}
