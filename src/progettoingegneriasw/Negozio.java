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
    private static int cod_shop = 0;

    public Negozio(String codFiscale, String nome, String indirizzo, String città) {
        this.codFiscale = codFiscale;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.città = città;
        this.cod_shop = hashCode();
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

    @Override
    public String toString() {
        return "CodFiscale: " + codFiscale + "  Nome: " + nome + " Città: " + città + " Indirizzo: " + indirizzo + " ";
    }

    @Override
    public int hashCode() {
        return codFiscale.hashCode()^nome.hashCode()+città.hashCode()^indirizzo.hashCode();
    }
    
    @Override
    public boolean equals(Object other){
        Negozio negozio = null;
        if(other instanceof Negozio){
            negozio = (Negozio) other;
            return this.città.equals(negozio.città) && this.codFiscale.equals(negozio.codFiscale) && this.indirizzo.equals(negozio.indirizzo) && this.nome.equals(negozio.nome);
        }
        
        return false;
    }

}
