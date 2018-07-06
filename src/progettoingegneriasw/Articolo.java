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
import java.util.Date;


public class Articolo {
    private TipoArticolo type;
    public int cod_articolo;
    private double price;
    private Data production_date; 

    public Articolo (TipoArticolo type, double price, Data production_date){
        this.type = type;
        this.price = price;
        this.production_date = production_date;
        this.cod_articolo = this.hashCode();
    }

    public double getPrice() {
        return price;
    }

    public Data getProductionDate() {
        return production_date;
    }
    
    public int getCodiceArticolo() {
        return cod_articolo;
    }
    
    public TipoArticolo getTypeArticle(){
    	return type;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public void setType(TipoArticolo type) {
        this.type = type;
    }
    
    
    public void setProductionDate(Data d) {
        this.production_date = d;
    }
    @Override
    public int hashCode() {
        return (int) price ^ type.hashCode() ^ production_date.hashCode();
    }
    @Override 
    public boolean equals(Object other){ 
        Articolo articolo = null; 
        if (other instanceof Articolo) { 
            articolo = (Articolo) other; 
            return this.getTypeArticle().equals(articolo.getTypeArticle()) && this.price == articolo.price && this.production_date.equals(articolo.production_date); 
        } 
        return false; 
    }
    @Override  
    public String toString(){
       return type.toString()+this.price+this.production_date.toString();
    }
    
    
}

