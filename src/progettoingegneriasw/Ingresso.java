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
public class Ingresso {

    private int codIntUnivoco;
    private Data data;
    private Articolo articolo;
    private int posizione;

    public Ingresso(int codIntUnivoco, Data data, Articolo articolo, int posizione) {
        this.codIntUnivoco = codIntUnivoco;
        this.data = data;
        this.articolo = articolo;
        this.posizione = posizione;
    }

    public int getCodIntUnivoco() {
        return codIntUnivoco;
    }

    public Data getData() {
        return data;
    }

    public Articolo getArticolo() {
        return articolo;
    }

    public int getPosizione() {
        return posizione;
    }
    

}
