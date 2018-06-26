/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoingegneriasw;

/**
 *
 * @author ionbaltaga
 */
public class Uscita {
    private int numeroBolla;
    private Data data;
    private Articolo articolo;
    private Negozio negozio;
    private String spedizioniere; 

    public Uscita(int numeroBolla, Data data, Articolo articolo, Negozio negozio, String spedizioniere) {
        this.numeroBolla = numeroBolla;
        this.data = data;
        this.articolo = articolo;
        this.negozio = negozio;
        this.spedizioniere = spedizioniere;
    }

    public int getNumeroBolla() {
        return numeroBolla;
    }

    public Data getData() {
        return data;
    }

    public Articolo getArticolo() {
        return articolo;
    }

    public Negozio getNegozio() {
        return negozio;
    }

    public String getSpedizioniere() {
        return spedizioniere;
    }
     
    
    
}
