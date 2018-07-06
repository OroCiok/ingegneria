/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoingegneriasw;

import static java.lang.Math.abs;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author dicatterinamatteo
 */
public class Ordine {

    private Negozio negozio;
    private int codice_ordine = 0;
    private Map<Articolo, Integer> quantità;
    private double prezzo_totale;
    private String data;
    private boolean is_shipped;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Ordine(Negozio negozio, Map<Articolo, Integer> ordine, double price) {
        this.negozio = negozio;
        this.quantità = ordine;
        prezzo_totale = price;
        data = sdf.format(new Date());
        codice_ordine = hashCode();
        is_shipped = false;
    }

    public boolean Is_shipped() {
        return is_shipped;
    }

    public void setIs_shipped(boolean is_shipped) {
        this.is_shipped = is_shipped;
    }

    public int getOrder_number() {
        return codice_ordine;
    }

    public void setOrder_number(int order_number) {
        this.codice_ordine = order_number;
    }

    public Map<Articolo, Integer> getMapOrdine() {
        return quantità;
    }

    public void setMapOrdine(Map<Articolo, Integer> ordine) {
        this.quantità.putAll(ordine);
    }

    public double getTotal_price() {
        return prezzo_totale;
    }

    public void setTotal_price(double total_price) {
        this.prezzo_totale = total_price;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    public Negozio getNegozio() {
        return negozio;
    }

    public void setNegozio(Negozio negozio) {
        this.negozio = negozio;
    }
    
    
    @Override
     public int hashCode() {
        return this.negozio.hashCode()^data.hashCode()^quantità.hashCode()^((int)prezzo_totale);
    }
     
    @Override
    public boolean equals(Object other){
        Ordine o;
        if(other instanceof Ordine){
           o = (Ordine) other;
           return o.negozio.equals(this.negozio) && o.data == this.getData() && o.prezzo_totale == this.getTotal_price();
        }
        
        return false;
    } 
}
