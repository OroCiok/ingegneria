/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoingegneriasw;

import java.util.ArrayList;

/**
 *
 * @author ionbaltaga
 */
public class Segreteria {
    private ArrayList <TipoArticolo> tipiArticoli;

    public Segreteria() {
        this.tipiArticoli = new ArrayList <TipoArticolo> ();
    }

    public ArrayList<TipoArticolo> getTipiArticoli() {
        return tipiArticoli;
    }

    public void setTipiArticoli(ArrayList<TipoArticolo> tipiArticoli) {
        this.tipiArticoli = tipiArticoli;
    }
    

}
