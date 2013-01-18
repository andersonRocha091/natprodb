/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Lingo;
import model.SQLite;
import org.w3c.dom.events.MouseEvent;
import view.JanelaComputarSimilaridade;

/**
 *
 * @author Anderson
 */
public class ControllerComputeSimilarity implements ActionListener {

    private JanelaComputarSimilaridade viewComputeSim = new JanelaComputarSimilaridade(this);
    private SQLite bank;
    private ResultSet resu;
    private String smileToCompare, smileMolecule;
    private int q, porcentagemSimilaridade;
    private double porcSimilaridade, numerador,sim;

    public ControllerComputeSimilarity(SQLite bank) {
        this.bank = bank;
        resu = bank.retornarTodas();
        //viewComputeSim.preencherTabela(resu);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewComputeSim.getBotaoClear()) {
            viewComputeSim.getCampoBusca().setText("");
            viewComputeSim.getCampoBusca().setText("");
        } else if (e.getSource() == viewComputeSim.getCheckInBank()) {

            if (viewComputeSim.getCheckInBank().isSelected()) {
                viewComputeSim.getCampoInsereMolecula().setEditable(false);
            } else {
                viewComputeSim.getCampoInsereMolecula().setEditable(true);
            }
        } else if (e.getSource() == viewComputeSim.getBotaoSearch()) {
            viewComputeSim.limpaTabela();
            smileToCompare = viewComputeSim.getCampoBusca().getText(); //smile a comparar
            q = smileToCompare.length(); //tamanho da lingo
            char[] arraySmile = smileToCompare.toCharArray();
            porcentagemSimilaridade = viewComputeSim.getPorcetagemSimilaridade();
            if (smileToCompare.equals("")) {
                JOptionPane.showMessageDialog(viewComputeSim, "Insert a smile!");
            } else {
                //  String sorrir = (String)result.getObject("Smile");
                resu = bank.retornarTodas();

                try {
                    resu.next();
                    do {
                        
                        smileMolecule = (String) resu.getObject("Smile");
                        if(smileToCompare.length()<=smileMolecule.length()){
                        char[] arrayChar = smileMolecule.toCharArray(); //conversao do smile em cadeia de char;
                        Lingo[] listalingo = new Lingo[arrayChar.length - (q - 1)]; // vetor de lingos  
                         sim = 0;
                        for (int i = 0; i < arrayChar.length - (q - 1); i++) { // quebra ddo smile em n-(q-1) lingos

                            String d = new String();
                            int k = 0;
                            for (int j = 0; j <= q - 1; j++) {

                                char a = arrayChar[i + k];
                                d += Character.toString(a);
                                k++;
                            }


                            Lingo lin = new Lingo(d);
                            listalingo[i] = lin;
                            System.out.println("" + listalingo[i].getLin());

                        } // fim da criação de lingos.
                        for (int h = 0; h < listalingo.length; h++) {
                            numerador = 0;
                            arrayChar = listalingo[h].getLin().toCharArray();
                            for (int l = 0; l < q; l++) {

                                if (arrayChar[l] == arraySmile[l]) {
                                    numerador++;
                                }   
                            }
                          porcSimilaridade = (numerador/q)*100;
                          listalingo[h].setSimilaridade(porcSimilaridade);
                          System.out.println(""+porcSimilaridade);
                        }
                        for(int i=0;i<listalingo.length;i++){
                            
                            if(listalingo[i].getSimilaridade()>=sim){
                                sim = listalingo[i].getSimilaridade();
                            }
                        
                        }
                        if(sim>=porcentagemSimilaridade){
                            viewComputeSim.preencherTabela(resu);
                        }
                        System.out.println("\nfim de uma smile\n");
                        System.out.println(sim);
                       }
                    } while (resu.next());
                    
                      

                } catch (SQLException ex) {
                    Logger.getLogger(ControllerComputeSimilarity.class.getName()).log(Level.SEVERE, null, ex);
                }







            }
        }
    }

    public void shoWindow() {
        viewComputeSim.show(true);

    }

    public void dispose() {
        viewComputeSim.dispose();
    }
}
