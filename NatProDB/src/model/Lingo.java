/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Anderson
 */
public class Lingo {
    
    private String lin;
    private double similaridade;
    
    public Lingo(String lin){
        this.lin = lin;        
    }
    

    public String getLin() {
        return lin;
    }

    public void setLin(String lin) {
        this.lin = lin;
    }

    public double getSimilaridade() {
        return similaridade;
    }

    public void setSimilaridade(double similaridade) {
        this.similaridade = similaridade;
    }
    
    
}
