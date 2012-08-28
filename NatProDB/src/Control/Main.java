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
    private static String caminhoArquivo;
    private static String  nomeiupac;
    private static String caminho;
    private static FileChannel oriChannel;
    private static FileChannel destChannel = null;
    
     public static void main(String[] args) throws SQLException, FileNotFoundException, IOException {
        try {
            bank = new SQLite("molecula.db");
           
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
