/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;
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
    private double porcSimilaridade, numerador, sim;
    private char[] arrayCharA, arrayCharB;
    private Lingo[] profileA, profileB;
    private boolean found = false;
    private int numLinA = 0;
    private int numLinB = 0;
    private float acumulator;
    private int subAeB=0;
    private BigDecimal num;
    private float tanimotosCoeficient, numResult;

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
        } else if (e.getSource() == viewComputeSim.getChecksim()) {
            if (viewComputeSim.getChecksim().isSelected()) {
                viewComputeSim.getCampoInsereMolecula().setEditable(true);
            } else {
                viewComputeSim.getCampoInsereMolecula().setEditable(false);
            }
        } else if (e.getSource() == viewComputeSim.getBotaoSearch()) {
            if (viewComputeSim.getChecksim().isSelected()) {
                smileToCompare = viewComputeSim.getCampoBusca().getText();
                gerarProfileLINGO('a', smileToCompare, 4); //gerar o descritor da Molécula A (a ser comparada).

                smileToCompare = viewComputeSim.getCampoInsereMolecula().getText();
                gerarProfileLINGO('b', smileToCompare, 4);//gerar o descritor da Molécula B (Alvo).

                List<Lingo> union = new Vector<Lingo>(); //Vetor conjunto união de todas as LINGOS de A e B

                /*for (int i = 0; i <= (profileA.length) - 1; i++) {
                
                if (union.isEmpty()) {
                union.add(profileA[0]);
                } else {
                if (!union.contains(profileA[i])) {
                union.add(profileA[i]);
                }
                }
                
                }*/

                if (union.isEmpty()) {
                    union.add(profileA[0]);
                }

                for (int i = 0; i <= (profileA.length) - 1; i++) { //adicionando lingos A (sem repetição)
                    // ao vetor uniao.     
                    for (int j = 0; j <= union.size() - 1; j++) {

                        if (profileA[i].getLin().equals(union.get(j).getLin())) {
                            found = true;
                        }

                    }
                    if (found != true) {
                        union.add(profileA[i]);
                    } else {
                        found = false;
                    }

                }

                found = false;

                for (int i = 0; i <= (profileB.length) - 1; i++) { //Adicionando Lingos B ao vetor uniao
                    // sem repetição.
                    for (int j = 0; j <= union.size() - 1; j++) {

                        if (profileB[i].getLin().equals(union.get(j).getLin())) {
                            found = true;
                        }

                    }
                    if (found != true) {
                        union.add(profileB[i]);
                    } else {
                        found = false;
                    }

                }
                
                for (int i = 0; i <= union.size() - 1; i++) {
                    System.out.println("\n" + union.get(i).getLin());
                }

                for (int i = 0; i < union.size(); i++) {

                    for (int j = 0; j < profileA.length; j++) {
                        if (union.get(i).getLin().equals(profileA[j].getLin())) {

                            numLinA++;
                        }
                        
                    }
                     for (int j = 0; j < profileB.length; j++) {
                        if (union.get(i).getLin().equals(profileB[j].getLin())) {

                            numLinB++;
                        }   
                    }
                     
                     subAeB=numLinA-numLinB;
                     
                     if(subAeB<0){
                         subAeB=subAeB*(-1);
                     }
                     
                   // num =((float)(1-(subAeB/(numLinA+numLinB))));
                     BigDecimal a = new BigDecimal(subAeB);  
                     BigDecimal b = new BigDecimal(numLinA+numLinB); 
                     //BigDecimal constante = new BigDecimal("1");
                     num = a.divide(b, MathContext.DECIMAL32);
                     numResult =(1 - num.floatValue());
                     
                    //num =(4/2);
                     //num = Math.round(1/3); //testando
                    acumulator+=numResult;
                    
                    
                    
                    System.out.println("Numero de Lingo:"+i+"em A:"+numLinA+"em B:"+numLinB);
                    System.out.println("numerador:"+numResult);
                     System.out.println("Acumulador:"+acumulator+"\n");
                    numLinA=0;
                    numLinB=0;
                    numResult = 0;
                }
                tanimotosCoeficient = acumulator/union.size();    
            System.out.println("\n Acumulador:"+acumulator);
            System.out.println("\n Coeficiente de Tanimoto:"+tanimotosCoeficient);
            acumulator=0;
            } else {

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
                            if (smileToCompare.length() <= smileMolecule.length()) {
                                System.out.println("" + smileMolecule);
                                CharSequence smileComparar = smileToCompare;
                                /*char[] arrayChar = smileMolecule.toCharArray(); //conversao do smile em cadeia de char;
                                Lingo[] listalingo = new Lingo[arrayChar.length - (q - 1)]; // vetor de lingos  
                                sim = 0;
                                for (int i = 0; i < arrayChar.length - (q - 1); i++) { // quebra do smile em n-(q-1) lingos
                                
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
                                
                                }*/
                                if (smileMolecule.contains(smileComparar)) {
                                    viewComputeSim.preencherTabela(resu);
                                }
                                System.out.println("\nfim de uma smile\n");
                                System.out.println(sim);
                            }
                        } while (resu.next());



                    } catch (SQLException ex) {
                        Logger.getLogger(ControllerComputeSimilarity.class.getName()).log(Level.SEVERE, null, ex);
                    }


                }//daqui

            }

        }
    }

    public void shoWindow() {
        viewComputeSim.show(true);

    }

    public void gerarProfileLINGO(char caracter, String smile, int tamanho) {
        q = tamanho;
        if (caracter == 'a') {
            arrayCharA = smile.toCharArray(); //conversao do smile em cadeia de char;
            profileA = new Lingo[arrayCharA.length - (q - 1)]; // vetor de lingos  
            sim = 0;
            for (int i = 0; i < arrayCharA.length - (q - 1); i++) { // quebra do smile em n-(q-1) lingos

                String d = new String();
                int k = 0;
                for (int j = 0; j <= q - 1; j++) {

                    char a = arrayCharA[i + k];
                    d += Character.toString(a);
                    k++;
                }


                Lingo lin = new Lingo(d);
                profileA[i] = lin;
                System.out.println("" + profileA[i].getLin());

            } // fim da criação de lingos.
            System.out.println("\n Fim do profile A");
        } else {

            arrayCharB = smile.toCharArray(); //conversao do smile em cadeia de char;
            profileB = new Lingo[arrayCharB.length - (q - 1)]; // vetor de lingos  
            sim = 0;
            for (int i = 0; i < arrayCharB.length - (q - 1); i++) { // quebra do smile em n-(q-1) lingos

                String d = new String();
                int k = 0;
                for (int j = 0; j <= q - 1; j++) {

                    char a = arrayCharB[i + k];
                    d += Character.toString(a);
                    k++;
                }


                Lingo lin = new Lingo(d);
                profileB[i] = lin;
                System.out.println("" + profileB[i].getLin());

            }
            System.out.println("\n Fim do profile B");
        }
        

    }

    public void dispose() {
        viewComputeSim.dispose();
    }
}
