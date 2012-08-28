/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Control.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.Class;
import java.net.URLDecoder;
import java.nio.channels.FileChannel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.Mysql;
import model.SQLite;

import view.JanelaCadastrarMolecula;

/**
 *
 * @author PETENGS
 */
public class ControllerCadastraMolecula implements ActionListener {

    private JanelaCadastrarMolecula cadastro;
   // private Mysql banco = new Mysql();
    private String caminhoArquivo = "";
    private SQLite bank;
    private Class<?> Main;
    
    public ControllerCadastraMolecula(SQLite bank) {
        cadastro = new JanelaCadastrarMolecula(this);
        this.bank = bank;
    }

    public void showWindow() {
        cadastro.setVisible(true);
    }

    public void dispose() {
        cadastro.setVisible(false);
    }
    
    private String findJarParentPath(File jarFile) {  
        while (jarFile.getPath().contains(".jar"))  
            jarFile = jarFile.getParentFile();  
          
        return jarFile.getPath().substring(6);  
    }  
    
    public String getApplicationPath() {  
      String url = getClass().getResource(getClass().getSimpleName() + ".class").getPath();  
        File dir = new File(url).getParentFile();  
        String path = null;  
          
        if (dir.getPath().contains(".jar"))  
            path = findJarParentPath(dir);  
        else  
            path = dir.getPath();  
  
        try {  
            return URLDecoder.decode(path, "UTF-8");  
        }  
        catch (UnsupportedEncodingException e) {                  
            return path.replace("%20", " ");  
        }  
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
    public void copiaArquivo() {
        
        File dir = new File("Molecules"); 
        if(!dir.exists()) dir.mkdir();
        FileChannel oriChannel = null;
        File origem = new File(cadastro.getCampoArquivo().getText());
        File destino = new File("Molecules"+File.separator+origem.getName());
        
        caminhoArquivo = "Molecules"+File.separator+destino.getName();
        System.out.println(caminhoArquivo);
        if(!dir.exists()) dir.mkdir();
        
        try {
            oriChannel = new FileInputStream(origem).getChannel();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ControllerCadastraMolecula.class.getName()).log(Level.SEVERE, null, ex);
        }
        FileChannel destChannel = null;
        try {
            destChannel = new FileOutputStream(destino).getChannel();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ControllerCadastraMolecula.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            destChannel.transferFrom(oriChannel, 0, oriChannel.size());
        } catch (IOException ex) {
            Logger.getLogger(ControllerCadastraMolecula.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            oriChannel.close();
        } catch (IOException ex) {
            Logger.getLogger(ControllerCadastraMolecula.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            destChannel.close();
            //inserir evento ok
        } catch (IOException ex) {
            Logger.getLogger(ControllerCadastraMolecula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
    
        
      
    
   
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == cadastro.getBotaoCancelar()) {
            dispose();
        } else if (e.getSource() == cadastro.getBotaoOk()) {

            if (cadastro.getCampoSmile().getText().equals("") ||cadastro.getNome().equals("") || cadastro.getNomeiupac().equals("") || cadastro.getCodigo().equals("") || cadastro.getCampoPesoMolecular().getText().equals("") || cadastro.getCampoLogP().getText().equals("") || cadastro.getFormulaMolecular().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill the Fields Obligatory");

            } else {
               // banco.abrirConexao();

                if (bank.verificaMolecula(cadastro.getNomeiupac()) == true) {
                    //banco.fecharConexao();
                    JOptionPane.showMessageDialog(null, "Molecule yet Inserted!");
                } else {   
                    copiaArquivo();
                    
                    Calendar c = Calendar.getInstance();  
                   String data = c.get(Calendar.YEAR) + "-" + c.get(Calendar.MONTH+1) + "-" + c.get(Calendar.DATE);
                   System.out.println(data);
                   String hora = getHora();
                    bank.cadastrarMolecula(cadastro.getCodigo(), cadastro.getNome(), cadastro.getNomeiupac(), cadastro.getFamilia(),
                            cadastro.getEspecie(),cadastro.getSmile(),cadastro.getHba(),cadastro.getHbd(), cadastro.getAtividadebiologica(), cadastro.getLocalizacao(),caminhoArquivo,cadastro.getPesoMolecular(), cadastro.getFormulaMolecular(),
                            cadastro.getLogp(), cadastro.getReferencia(),data,hora,cadastro.getTipo());
                    JOptionPane.showMessageDialog(null, "Molecule Inserted with Sucess!");
                   
                    cadastro.dispose();
                   
                   // banco.fecharConexao();
                }
            }





        } else if (e.getSource() == cadastro.getBotãoCarregar()) {
            JFileChooser arquivo = new JFileChooser();
            arquivo.showOpenDialog(null);
            int retorno = arquivo.showOpenDialog(null);
            if (retorno == JFileChooser.APPROVE_OPTION) {
                caminhoArquivo = arquivo.getSelectedFile().getAbsolutePath();
                System.out.println("" + caminhoArquivo);
                cadastro.getCampoArquivo().setText(caminhoArquivo);
            } else {
            }
        } else if (e.getSource() == cadastro.getComboBox()) {
            String selecao = (String) cadastro.getComboBox().getSelectedItem();
            if (selecao.equals("Natural")) {
                cadastro.getAreaAtividadeBio().setEnabled(true);
                cadastro.getCampoEspecie().setEditable(true);
                cadastro.getCampoFamilia().setEditable(true);
                cadastro.getAreaLocalização().setEnabled(true);
            } else {
                cadastro.getAreaAtividadeBio().setEnabled(true);
                cadastro.getCampoEspecie().setEditable(false);
                cadastro.getCampoFamilia().setEditable(false);
                cadastro.getAreaLocalização().setEnabled(false);
            }
        }
        
    }
}
