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
public class Negozio {
    private String codFiscale, nome, indirizzo, città;

    public Negozio(String codFiscale, String nome, String indirizzo, String città) {
        this.codFiscale = codFiscale;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.città = città;
    }

    public String getCodFiscale() {
        return codFiscale;
    }

    public String getNome() {
        return nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getCittà() {
        return città;
    }
    
    
}
