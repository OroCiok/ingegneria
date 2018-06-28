/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoingegneriasw;

import java.util.Date;

/**
 *
 * @author ionbaltaga
 */
public class Ordine {

   private Negozio negozio;
   private static int order_number = 0;
   private Date order_date;
   private TipoArticolo type;
   private int quantità;
   private double total_price;
   
   
   public Ordine(Negozio negozio, Date order_date, TipoArticolo type, int quantità) {
	   this.negozio = negozio;
	   this.order_date = order_date;
	   this.type = type;
	   this.quantità = quantità;
	   order_number = order_number +1;
	   total_price = calculate_total_price();
   }


   public Negozio getNegozio() {
	   return negozio;
   }


   public void setNegozio(Negozio negozio) {
	   this.negozio = negozio;
   }


   public TipoArticolo getType() {
	   return type;
   }


   public void setType(TipoArticolo type) {
	   this.type = type;
   }


   public int getQuantità() {
	   return quantità;
   }


   public void setQuantità(int quantità) {
	   this.quantità = quantità;
   }
   
   
   public double calculate_total_price() {
	   double price = 0.0;
	   
	   return price;
   }
   
   
   
   
   
}

