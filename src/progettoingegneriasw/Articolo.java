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
    public static int cod_articolo = 0;
    private double price;
    private Date production_date; 

    public Articolo (TipoArticolo type, Date production_date, double price){
        this.price = price;
        this.production_date = production_date;
        this.type = type;
        cod_articolo = cod_articolo+1;
    }

    public double getPrice() {
        return price;
    }

    public Date getProductionDate() {
        return production_date;
    }
    
    public double getCode() {
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
    
    public void setProductionDate(Date d) {
        this.production_date = d;
    }
    
    
}

