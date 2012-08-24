/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Mysql;
import model.SQLite;
import view.JanelaExibirTodosUsuários;

/**
 *
 * @author Anderson Rocha
 */
public class ControllerExibição {

    private JanelaExibirTodosUsuários exibeAll;
//    private Mysql banco = new Mysql();
    private ResultSet resu;
    private SQLite bank;
    
    public ControllerExibição(SQLite bank){
  //      banco.abrirConexao();
        this.bank = bank;
        resu = bank.retornarTodos();
        exibeAll = new JanelaExibirTodosUsuários(resu);
    //    banco.fecharConexao();
        
    }

    public void showWindow() {

        exibeAll.setVisible(true);
       // buscarTodos();
    }

    public void dispose() {
        exibeAll.dispose();
    }

    public void buscarTodos() {
        //banco.abrirConexao();
        
        resu = bank.retornarTodos(); 
        exibeAll.preencherTabela(resu);
        //banco.fecharConexao();
    }
}
