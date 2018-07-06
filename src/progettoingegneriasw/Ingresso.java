/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoingegneriasw;

import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author ionbaltaga
 */
public class Ingresso {
    private HashMap<Articolo,String> articoli;
    private int codIntUnivoco;
    private Data data;

    public Ingresso(HashMap<Articolo, String> articoli, Data data) {
        this.articoli = articoli;
        this.data = data;
        this.codIntUnivoco = this.hashCode();
    }

    public int getCodIntUnivoco() {
        return this.codIntUnivoco;
    }

    public String getData() {
        return data.toString();
    }

    public HashMap<Articolo,String> getArticoli() {
        return this.articoli;
    }

    public void addArticolo(Articolo art, String pos) {
        this.articoli.put(art,pos);
    }

    public void setData(Data d) {
        this.data = d;
    }

    
    @Override
    public int hashCode() {
        return articoli.hashCode() ^ data.hashCode();
    }
}
