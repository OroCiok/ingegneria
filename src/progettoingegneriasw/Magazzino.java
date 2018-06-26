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
public class Magazzino {
    private String tipoArticolo;
    private int codUnivoco;
    private double prezzo;
    private Data dataProduzione;
    private Ingresso ingresso;
    private Uscita uscita;
    
    private static int ultimoNum=0;

    public Magazzino(String tipoArticolo, double prezzo, Data dataProduzione) {
        this.tipoArticolo = tipoArticolo;
        this.codUnivoco = generate_univoco();
        this.prezzo = prezzo;
        this.dataProduzione = dataProduzione;
    }
       
    public static int generate_univoco(){
        ultimoNum++;
        return ultimoNum; 
    }
}
