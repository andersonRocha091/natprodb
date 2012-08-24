/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.sql.ResultSet;
import model.Mysql;
import model.SQLite;
import view.JanelaExibirTodasMoleculas;
import view.JanelaExibirTodasMoleculas;
import view.JanelaExibirTodosUsuários;

/**
 *
 * @author Anderson Rocha
 */
public class ControllerExibiçãoMoleculas {

    private JanelaExibirTodasMoleculas exibeAll;
//    private Mysql banco = new Mysql();
    private ResultSet resu = null;
    private SQLite bank;

    public ControllerExibiçãoMoleculas(SQLite bank) {
  //      banco.abrirConexao();
        this.bank = bank;
        exibeAll = new JanelaExibirTodasMoleculas();
        resu = bank.retornarTodas(); 
        exibeAll.preencherTabela(resu);
        showWindow();
    //    banco.fecharConexao();
        
    }

    public void showWindow() {

        exibeAll.setVisible(true);
       // buscarTodos();
    }

    public void dispose() {
        exibeAll.dispose();
    }

    public void buscarTodas() {
        //banco.abrirConexao();
        resu = bank.retornarTodas();
        exibeAll.preencherTabela(resu);
        //banco.fecharConexao();
    }
}
