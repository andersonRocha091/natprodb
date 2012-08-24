/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Control.ControllerWindowPrincipal;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Stella
 */
public class JanelaPrincipal extends JFrame {
   
    private JPanel mainPanel;
    private JLabel logo;
    private Icon image;
    private JMenu moleculas,usuario,sobre;
    private JMenuBar menuBar;
    private JMenuItem itemCadastraMolecula, itemAlterarRemoverMol, itemSair, itemCadastraUsuario,itemAleteraRemoveUsuario, itemExibirTodos,itemExibirTodas,itemSobre;
             
    public JanelaPrincipal(ControllerWindowPrincipal controller){
    
        menuBar = new JMenuBar();  //criar barra de menus
        
        moleculas = new JMenu("Molecules"); // criação do item e opções para moléculas.
        itemCadastraMolecula = new JMenuItem("New");
        itemCadastraMolecula.addActionListener(controller);
        itemAlterarRemoverMol = new JMenuItem("Change/Exclude");
        itemAlterarRemoverMol.addActionListener(controller);
        itemSair = new JMenuItem("Exit");
        itemSair.addActionListener(controller);
        itemExibirTodas = new JMenuItem("Show All");
        itemExibirTodas.addActionListener(controller);
        itemSair = new JMenuItem("Exit");
        itemSair.addActionListener(controller);
        moleculas.add(itemCadastraMolecula);
        moleculas.add(itemAlterarRemoverMol);
        moleculas.add(itemExibirTodas);
        moleculas.add(itemSair);
        menuBar.add(moleculas);
        
        usuario = new JMenu("Users"); //criação de menu e itens de usuário
        itemCadastraUsuario = new JMenuItem("New");
        itemAleteraRemoveUsuario = new JMenuItem("Change/Exclude");
        itemExibirTodos = new JMenuItem("Show All");
        itemCadastraUsuario.addActionListener(controller);
        itemAleteraRemoveUsuario.addActionListener(controller); 
        itemExibirTodos.addActionListener(controller);
        usuario.add(itemCadastraUsuario);
        usuario.add(itemAleteraRemoveUsuario);
        usuario.add(itemExibirTodos);
        menuBar.add(usuario);
        
        sobre = new JMenu("About");
        itemSobre = new JMenuItem("About");
        itemSobre.addActionListener(controller);
        sobre.add(itemSobre);
        menuBar.add(sobre);
        
            image = new ImageIcon(getClass().getResource("molecules gerent.png"));
	    logo = new JLabel(image);
            logo.setBounds(150,230, 963, 293);
            this.add(logo);
        
//        this.setContentPane(mainPanel);
            this.setJMenuBar(menuBar);
            this.setLayout (null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setTitle(".:: NatProDB - Your System of Molecules Manegement ::.");
	    this.setSize(800, 600);
	    //this.setLocationRelativeTo(null);
	    //this.setResizable(false);
	    this.setExtendedState(MAXIMIZED_BOTH);
    
    }

    public JMenuItem getItemAleteraRemoveUsuario() {
        return itemAleteraRemoveUsuario;
    }

    public JMenuItem getItemAlterarRemoverMol() {
        return itemAlterarRemoverMol;
    }

    public JMenuItem getItemCadastraMolecula() {
        return itemCadastraMolecula;
    }

    public JMenuItem getItemCadastraUsuario() {
        return itemCadastraUsuario;
    }

    public JMenuItem getItemExibirTodas() {
        return itemExibirTodas;
    }

    public JMenuItem getItemExibirTodos() {
        return itemExibirTodos;
    }

    public JMenuItem getItemSair() {
        return itemSair;
    }

    public JMenuItem getItemSobre() {
        return itemSobre;
    }
}
