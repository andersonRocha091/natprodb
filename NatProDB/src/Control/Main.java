/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import model.Lingo;
import model.Mysql;
import model.SQLite;
import view.*;

/**
 *
 * @author Stella
 */
public class Main {
    private static SQLite bank;
    private static  Main main;
    private static int count =0;
    private static int q;
    private static String caminhoArquivo;
    private static String  nomeiupac;
    private static String caminho;
    private static FileChannel oriChannel;
    private static FileChannel destChannel = null;
    
     public static void main(String[] args) throws SQLException, FileNotFoundException, IOException {
        try {
            bank = new SQLite("molecula.db");
           ResultSet result =  bank.nomePorPartesMol("Benzene-1,2-diol"); //inicio do algoritmo.
           String sorrir = (String)result.getObject("Smile");
           System.out.println(sorrir);
           q=7;
           char[] arrayChar = sorrir.toCharArray(); //conversao do smile em cadeia de char;
           Lingo[] listalingo = new Lingo[arrayChar.length-(q-1)]; // vetor de lingos
           
           for(int i=0;i<arrayChar.length-(q-1);i++){ // quebra ddo smile em n-(q-1) lingos
               
               String d = new String();
               int k=0;
               for(int j=0;j<=q-1;j++){
                   
                    char a = arrayChar[i+k];
                    d += Character.toString(a); 
                    k++;
               }
                  
               
               Lingo lin = new Lingo(d);
               listalingo[i] = lin;
               System.out.println(""+listalingo[i].getLin());
             // String lingos = new String(a+b+c); 
              //Lingo lingo = new Lingo(); 
             //listalingo[i] = ;  
           }
           
           
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        ControllerWindowPrincipal controle = new ControllerWindowPrincipal(bank);
        ResultSet res = bank.retornarTodas();
        bank.atualizarArquivos();
        while(res.next()){
            nomeiupac = (String)res.getObject("Nome_iupac");
            caminho = (String)res.getObject("Localizacao_arquivo");
           
        
           File dir = new File("Molecules"); 
            if(!dir.exists()) dir.mkdir();
            
            File origem = new File(caminho);
            File destino = new File("Molecules"+File.separator+origem.getName());
            
             caminhoArquivo = "Molecules"+File.separator+destino.getName();
             // bank.atualizaCaminho(nomeiupac, caminhoArquivo);
             oriChannel = new FileInputStream(origem).getChannel();
             
             destChannel = new FileOutputStream(destino).getChannel();
             destChannel.transferFrom(oriChannel, 0, oriChannel.size());
            
             
              System.out.println("\ncaminho:"+caminho);
            // oriChannel.close();
           // destChannel.close();
             count++;
         
         
        }
        
         
        //Mysql test = new Mysql();
        
        
    }
    
    
}
