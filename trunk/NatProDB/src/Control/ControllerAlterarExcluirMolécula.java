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
import view.JanelaAlterarExcluirMolecula;
import view.JanelaAlterarExcluirUsuario;
import view.JanelaAlterarUsuario;
import view.JanelaVisualizarMolecula;

/**
 *
 * @author Anderson Rocha.
 */
public class ControllerAlterarExcluirMolécula implements ActionListener, MouseListener {

    private JanelaAlterarExcluirMolecula alteraExcluiView = new JanelaAlterarExcluirMolecula(this);
    //private Mysql banco = new Mysql();
    private ResultSet resu = null;
    private JTable tabel;
    private String codigo = "n";
    private String nome = "nn";
    private String nomeiupac = "p";
    private String familia = "f";
    private String especie = "e";
    private String smile = "s";
    private int hba, hbd;
    private String Atividade = "a";
    private String localizacao = "l";
    private float peso = 0;
    private float logp = 0;
    private String formula = "";
    private String referencia = "";
    private Integer indice = -1;
    private String pp, l, a;
    private float peso1 = 0;
    private SQLite bank;
    private DefaultTableModel model;

    public ControllerAlterarExcluirMolécula(SQLite bank) {
        this.bank = bank;
        resu = bank.retornarTodas();
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
            if (alteraExcluiView.getComboBoxFind().getSelectedItem().equals("IUPAC's Name")) {
                if (alteraExcluiView.getCheckLipinski().isSelected()) {
                    String nome = alteraExcluiView.getCampoBusca().getText();
                    //banco.abrirConexao();
                    resu = bank.regraDeLinpsky(nome);
                    alteraExcluiView.preencherTabela(resu);

                } else {
                    String nome = alteraExcluiView.getCampoBusca().getText();
                    //banco.abrirConexao();
                    resu = bank.nomePorPartesMol(nome);
                    alteraExcluiView.preencherTabela(resu);
                }

            } else {
                if (alteraExcluiView.getCheckLipinski().isSelected()) {
                    String nome = alteraExcluiView.getCampoBusca().getText();
                    //banco.abrirConexao();
                    resu = bank.regraDeLinpsky(nome);
                    alteraExcluiView.preencherTabela(resu);

                } else {
                    String nome = alteraExcluiView.getCampoBusca().getText();
                    //banco.abrirConexao();
                    resu = bank.buscaPorSmile(nome);
                    alteraExcluiView.preencherTabela(resu);
                }
            }

            //banco.fecharConexao();
        } else if (e.getSource() == alteraExcluiView.getBotaoExcluir()) {
            if (indice == -1) {
                JOptionPane.showMessageDialog(null, "Selecione uma linha!");
            } else {
                //  banco.abrirConexao();
                bank.excluirMolecula(nomeiupac);
                //banco.fecharConexao();
                model.removeRow(tabel.getSelectedRow());
                tabel.setModel(model);
                JOptionPane.showMessageDialog(null, "Molécula Removida com Sucesso!");
                indice = -1;
            }
        } else if (e.getSource() == alteraExcluiView.getAlterar()) {

            if (codigo.equals("n") || nome.equals("nn") || nomeiupac.equals("p") || familia.equals("f") || especie.equals("e") || Atividade.equals("a") || localizacao.equals("l") || formula.equals("") || referencia.equals("")) {
                JOptionPane.showMessageDialog(null, "Selecione uma Molécula!");
            } else {
                ControllerAlteraMolecula control = new ControllerAlteraMolecula(bank, codigo, nome, nomeiupac, familia, especie, smile, hba, hbd, Atividade, localizacao, referencia, peso, logp, formula);
                control.showWindow();
                codigo = "n";
                nome = "nn";
                nomeiupac = "p";
                familia = "f";
                smile = "s";
                especie = "e";
                Atividade = "a";
                localizacao = "l";
                peso = 0;
                logp = 0;
                formula = "";
                referencia = "";

            }

        }
        else if(e.getSource()==alteraExcluiView.getBotaoClear()){
               alteraExcluiView.getCampoBusca().setText("");                  
    }
        else if(e.getSource()==alteraExcluiView.getBotaoSearch()){
            
              if (alteraExcluiView.getComboBoxFind().getSelectedItem().equals("IUPAC's Name")) {
                if (alteraExcluiView.getCheckLipinski().isSelected()) {
                    String nome = alteraExcluiView.getCampoBusca().getText();
                    //banco.abrirConexao();
                    resu = bank.regraDeLinpsky(nome);
                    alteraExcluiView.preencherTabela(resu);

                } else {
                    String nome = alteraExcluiView.getCampoBusca().getText();
                    //banco.abrirConexao();
                    resu = bank.nomePorPartesMol(nome);
                    alteraExcluiView.preencherTabela(resu);
                }

            } else {
                if (alteraExcluiView.getCheckLipinski().isSelected()) {
                    String nome = alteraExcluiView.getCampoBusca().getText();
                    //banco.abrirConexao();
                    resu = bank.regraDeLinpsky(nome);
                    alteraExcluiView.preencherTabela(resu);

                } else {
                    String nome = alteraExcluiView.getCampoBusca().getText();
                    //banco.abrirConexao();
                    resu = bank.buscaPorSmile(nome);
                    alteraExcluiView.preencherTabela(resu);
                }
            }
            
        }
  }

    @Override
    public void mouseClicked(MouseEvent e) {
        ResultSet receber = null;
        System.out.println("clicou:" + nome);
        tabel = alteraExcluiView.getTable();
        indice = tabel.getSelectedRow();
        codigo = (String) tabel.getValueAt(indice, 0);
        nome = (String) tabel.getValueAt(indice, 1);
        nomeiupac = (String) tabel.getValueAt(indice, 2);
        familia = (String) tabel.getValueAt(indice, 3);
        especie = (String) tabel.getValueAt(indice, 4);
        receber = bank.nomePorPartesMol(nomeiupac);
        try {
            // receber.next();
            smile = (String) receber.getObject("Smile");
            Atividade = (String) receber.getObject("Atividade_biologica");
            localizacao = (String) receber.getObject("Localizacao");
            referencia = (String) receber.getObject("Referencia");
        } catch (SQLException ex) {
            Logger.getLogger(ControllerAlterarExcluirMolécula.class.getName()).log(Level.SEVERE, null, ex);
        }

        hba = converterObjToInt(tabel.getValueAt(indice, 6));
        hbd = converterObjToInt(tabel.getValueAt(indice, 7));
        // Atividade = (String)tabel.getValueAt(indice, 8);
        // localizacao = (String)tabel.getValueAt(indice,9);
        Object o = tabel.getValueAt(indice, 9);
        String goToString = o.toString();
        peso = Float.parseFloat(goToString);
        formula = (String) tabel.getValueAt(indice, 10);
        Object p = tabel.getValueAt(indice, 11);
        goToString = p.toString();
        logp = Float.parseFloat(goToString);
        System.out.println("Valor capturado logp:" + logp);
        // referencia = (String) tabel.getValueAt(indice, 14);
        model = (DefaultTableModel) tabel.getModel();

        System.out.println("\n" + codigo + "\n" + nome + "\n" + nomeiupac + "\n" + familia + "\n" + especie + "\n" + Atividade + "\n" + localizacao + "\n" + peso + "\n" + formula + "\n" + logp + "\n" + referencia);
        if (e.getClickCount() == 2) {
            JanelaVisualizarMolecula janelaVisual = new JanelaVisualizarMolecula();
            janelaVisual.getCampocodigo().setText(codigo);
            janelaVisual.getCampoNome().setText(nome);
            janelaVisual.getCampoNomeIupac().setText(nomeiupac);
            janelaVisual.getCampoFamilia().setText(familia);
            janelaVisual.getCampoEspecie().setText(especie);
            janelaVisual.getCampoSmile().setText(smile);
            janelaVisual.getCampoHBA().setText(Integer.toString(hba));
            janelaVisual.getCampoHBD().setText(Integer.toString(hbd));
            janelaVisual.getAreaAtividadeBio().setText(Atividade);
            janelaVisual.getCampoPesoMolecular().setText(o.toString());
            janelaVisual.getCampoLogP().setText(p.toString());
            janelaVisual.getAreaLocalização().setText(localizacao);
            janelaVisual.getAreaReferencia().setText(referencia);
            janelaVisual.getCampoFormulaMolecular().setText(formula);
            janelaVisual.setVisible(true);
            System.out.println("clicou duas vezes!!!");
        }
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

    public int converterObjToInt(Object o) {
        Object j = o;
        String wordToParse = o.toString();
        int result = Integer.parseInt(wordToParse);
        return result;
    }
}
