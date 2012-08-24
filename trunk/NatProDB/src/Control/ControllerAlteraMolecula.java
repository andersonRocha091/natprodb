/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import model.Mysql;
import model.SQLite;
import view.JanelaAlterarMolecula;
import view.JanelaAlterarUsuario;
import view.JanelaVisualizarMolecula;

/**
 *
 * @author Augusto Graça
 */
public class ControllerAlteraMolecula implements ActionListener {

    private JanelaAlterarMolecula janelaAlterar = new JanelaAlterarMolecula(this);
    
    
    //private Mysql banco = new Mysql();
    private String codigo, nome, nomeiupac, familia, especie, atividade, localização, formulaMol, referencia, smile;
    private float peso, logp;
    private SQLite bank;
    private int hba, hbd;

    public ControllerAlteraMolecula(SQLite bank, String codigo, String nome, String nomeiupac, String familia, String especie, String smile, int hba, int hbd, String atividade, String localizacao, String referencia, float peso, float logp, String formulaMol) {
        this.bank = bank;
        this.codigo = codigo;
        this.nome = nome;
        this.nomeiupac = nomeiupac;
        this.familia = familia;
        this.especie = especie;
        this.smile = smile;
        this.hba = hba;
        this.hbd = hbd;
        this.atividade = atividade;
        this.localização = localizacao;
        this.referencia = referencia;
        this.peso = peso;
        this.logp = logp;
        Object o = peso; // utilizado para converter um float para string
        Object p = logp;
        Object hb_a = hba;
        Object hb_d = hbd;
        this.formulaMol = formulaMol;
        janelaAlterar.getCampocodigo().setText(codigo);
        janelaAlterar.getCampoNome().setText(nome);
        janelaAlterar.getCampoNomeIupac().setText(nomeiupac);
        janelaAlterar.getCampoFamilia().setText(familia);
        janelaAlterar.getCampoEspecie().setText(especie);
        janelaAlterar.getCampoSmile().setText(smile);
        janelaAlterar.getCampoHBA().setText(hb_a.toString());
        janelaAlterar.getCampoHBD().setText(hb_d.toString());
        janelaAlterar.getAreaAtividadeBio().setText(atividade);
        janelaAlterar.getCampoPesoMolecular().setText(o.toString());
        janelaAlterar.getCampoLogP().setText(p.toString());
        janelaAlterar.getAreaLocalização().setText(localizacao);
        janelaAlterar.getAreaReferencia().setText(referencia);
        janelaAlterar.getCampoFormulaMolecular().setText(formulaMol);
        
        /*janelaAlterar.setTextLogin(login);
        janelaAlterar.setTextPassword(password);*/
    }

    public void showWindow() {

        janelaAlterar.setVisible(true);

    }
     public String getHora() {  
      
    // cria um StringBuilder  
    StringBuilder sb = new StringBuilder();  
  
    // cria um GregorianCalendar que vai conter a hora atual  
    GregorianCalendar d = new GregorianCalendar();  
      
    // anexa do StringBuilder os dados da hora  
    sb.append( d.get( GregorianCalendar.HOUR_OF_DAY ) );  
    sb.append( ":" );  
    sb.append( d.get( GregorianCalendar.MINUTE ) );  
    sb.append( ":" );  
    sb.append( d.get( GregorianCalendar.SECOND ) );  
      
    // retorna a String do StringBuilder  
    return sb.toString();  
      
}  

    public void limparVariaveis() {

        codigo = null;
        nome = null;
        nomeiupac = null;
        familia = null;
        especie = null;
        atividade = null;
        localização = null;
        peso = -1;
        formulaMol = null;
        logp = -1;
        referencia = null;


    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == janelaAlterar.getBotaoCancelar()) {
            janelaAlterar.dispose();
        } else if (ae.getSource() == janelaAlterar.getBotaoOk()) {

            if (janelaAlterar.getCampocodigo().equals("") || janelaAlterar.getCampoNome().equals("")
                    || janelaAlterar.getCampoNomeIupac().equals("") || janelaAlterar.getCampoFormulaMolecular().equals("")
                    || janelaAlterar.getCampoFormulaMolecular().equals("")) {

                JOptionPane.showMessageDialog(null, "Fill the Fields Obligatory");
            } else {
                
                codigo = janelaAlterar.getCampocodigo().getText();
                nome = janelaAlterar.getCampoNome().getText();
                //nomeiupac = janelaAlterar.getCampoNomeIupac().getText();
                if (janelaAlterar.getComboBox().getSelectedItem() == "Natural") {
                    familia = janelaAlterar.getCampoFamilia().getText();
                    especie = janelaAlterar.getCampoEspecie().getText();
                } else {
                    familia = "";
                    especie = "";
                }
                smile = janelaAlterar.getCampoSmile().getText();
                hba = janelaAlterar.getHba();
                hbd = janelaAlterar.getHbd();
                atividade = janelaAlterar.getAreaAtividadeBio().getText();
                localização = janelaAlterar.getAreaLocalização().getText();
                String s = janelaAlterar.getCampoPesoMolecular().getText();
                peso = Float.parseFloat(s);
                formulaMol = janelaAlterar.getCampoFormulaMolecular().getText();
                String p = janelaAlterar.getCampoLogP().getText();
                logp = Float.parseFloat(p);
                referencia = janelaAlterar.getAreaReferencia().getText();
                Calendar c = Calendar.getInstance();
                int mes = c.get(Calendar.MONTH+1);
                String data = c.get(Calendar.YEAR) + "-" + mes + "-" + c.get(Calendar.DATE);
               // System.out.println(c.get(Calendar.MONTH)+1);
                String hora = getHora();
                bank.atualizarMolecula(codigo, nome, janelaAlterar.getCampoNomeIupac().getText(), familia, especie, smile, hba, hbd, atividade, localização, localização, peso, formulaMol, logp, referencia, nomeiupac,data,hora,janelaAlterar.getTipo());

                JOptionPane.showMessageDialog(null, "Molecule Changed!");
                limparVariaveis();
                janelaAlterar.dispose();

                }
               
                
            }

         else if (ae.getSource() == janelaAlterar.getComboBox()) {
            String selecao = (String) janelaAlterar.getComboBox().getSelectedItem();
            if (selecao.equals("Natural")) {
                janelaAlterar.getAreaAtividadeBio().setEnabled(true);
                janelaAlterar.getCampoEspecie().setEditable(true);
                janelaAlterar.getCampoFamilia().setEditable(true);
                janelaAlterar.getAreaLocalização().setEnabled(true);
            } else {
                janelaAlterar.getAreaAtividadeBio().setEnabled(true);
                janelaAlterar.getCampoEspecie().setEditable(false);
                janelaAlterar.getCampoFamilia().setEditable(false);
                janelaAlterar.getAreaLocalização().setEnabled(false);

            }


        } else if (ae.getSource() == janelaAlterar.getComboBox()) {

              
                
                if(janelaAlterar.getComboBox().getSelectedItem().equals("Natural")){
                janelaAlterar.getCampoEspecie().setEditable(true);
                janelaAlterar.getCampoFamilia().setEditable(true);
                
                }
                else{
                janelaAlterar.getCampoEspecie().setEditable(false);
                janelaAlterar.getCampoFamilia().setEditable(false);
                }
                
                

            
        }

    }
}
