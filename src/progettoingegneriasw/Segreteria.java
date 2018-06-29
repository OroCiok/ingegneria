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
    private ArrayList <Negozio> shop_list;
    
    
    public Segreteria() {
        this.tipiArticoli = new ArrayList <TipoArticolo> ();
        this.shop_list = new ArrayList <Negozio> ();
        shop_list.add(new Negozio("Ciao", "DCT", "Via Passer", "San Briccio(VR)"));
    }

    public ArrayList<Negozio> getShop_list() {
        return shop_list;
    }

    public ArrayList<TipoArticolo> getTipiArticoli() {
        return tipiArticoli;
    }

    public void setTipiArticoli(ArrayList<TipoArticolo> tipiArticoli) {
        this.tipiArticoli = tipiArticoli;
    }
    
    public void deleteNegozio(Negozio delete_shop){
        for(int i = 0; i < this.shop_list.size(); i++ ){
            if(shop_list.get(i).equals(delete_shop)){
                shop_list.remove(i);
                break;
            }
        }
    }
    
     public void addNegozio(Negozio new_shop){
        shop_list.add(new_shop);
    }
    

}
