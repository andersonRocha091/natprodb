/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

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
     public static void main(String[] args) throws SQLException {
        try {
            bank = new SQLite("molecula.db");
           
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        ControllerWindowPrincipal controle = new ControllerWindowPrincipal(bank);
        
        //Mysql test = new Mysql();
        
        
    }
    
    
}
