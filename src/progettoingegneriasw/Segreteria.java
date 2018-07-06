/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoingegneriasw;

import java.util.ArrayList;

/**
 *
 * @author dicatterinamatteo
 */
public class Segreteria {

    private static ArrayList<Negozio> shop_list;

    public Segreteria() {
        this.shop_list = new ArrayList<Negozio>();
        shop_list.add(new Negozio("DCT", "SportWear", "Via Passere", "San Briccio(VR)"));
        shop_list.add(new Negozio("ION", "All Sports", "Via Tanaro", "Verona"));
    }

    public ArrayList<Negozio> getShop_list() {
        return shop_list;
    }

    public void deleteNegozio(Negozio delete_shop) {
        for (int i = 0; i < this.shop_list.size(); i++) {
            if (shop_list.get(i).equals(delete_shop)) {
                shop_list.remove(i);
                break;
            }
        }
    }

    public void addNegozio(Negozio new_shop) {
        shop_list.add(new_shop);
    }

}
