/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoingegneriasw;

import java.util.Objects;

/**
 *
 * @author ionbaltaga
 */
public class TipoArticolo {
    private String nome, descrizione, sport, materiale;
   

    public TipoArticolo (String nome, String descrizione, String sport, String materiale){
        this.nome=nome;
        this.descrizione=descrizione;
        this.sport=sport;
        this.materiale=materiale;
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getSport() {
        return sport;
    }

    public String getMateriale() {
        return materiale;
    }

    @Override
    public int hashCode() {
        return nome.hashCode() ^ descrizione.hashCode() ^ sport.hashCode() ^ materiale.hashCode();
    }
/*
    @Override
    public boolean equals(Object obj) {
       
    }
  */  
    @Override
    public String toString() {
        return ""+nome +" "+ descrizione+" " + sport +" "+ materiale;
    }
    
}
