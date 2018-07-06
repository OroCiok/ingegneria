/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoingegneriasw;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author ionbaltaga
 */
public class Magazzino {

    private ArrayList<Ingresso> ingressi;
    private ArrayList<Uscita> uscite;
    private ArrayList<Ordine> ordini;
    private ArrayList<Articolo> catalogoArticoliMagazzino;
    private ArrayList<TipoArticolo> tipiArticoli;

    private JComboBox<String> tipi_articoli_box,articoli_box;//qua perchè dovrà essere statica per metterci dentro i tipi di articoli
    int codice_ingresso;//contatore per i codici di ingressounivoci

    private static Magazzino INSTANCE_MAGAZZINO = null;

    private HashMap<Articolo, Integer> mappa_articolo_quantita;
    
    private HashMap<Articolo, Integer> quantità;

    public Magazzino() {
        this.ingressi = new ArrayList<Ingresso>();
        this.uscite = new ArrayList<Uscita>();
        this.ordini = new ArrayList<Ordine>();

        this.tipiArticoli = new ArrayList<TipoArticolo>();

        this.tipi_articoli_box = new JComboBox<>();
        
        this.articoli_box = new JComboBox<>();

        this.catalogoArticoliMagazzino = new ArrayList<Articolo>();
        this.codice_ingresso = 0;

        mappa_articolo_quantita = new HashMap<Articolo, Integer>();
        

    }

    public void addTipoArticolo(TipoArticolo tipoArt) {
        this.tipiArticoli.add(tipoArt);
    }

    public TipoArticolo getTipoArticolo(int indice) {
        return this.tipiArticoli.get(indice);
    }

    public void addArticoloQuantita(Articolo art, int quantita) {
        Magazzino.getInstance().getMappa_articolo_quantita().putIfAbsent(art, 0);
            for (Articolo articolo : Magazzino.getInstance().getMappa_articolo_quantita().keySet()) {
                
                if (articolo.equals(art)) {
                    int quantita_attuale = Magazzino.getInstance().getMappa_articolo_quantita().get(art);
                    Magazzino.getInstance().getMappa_articolo_quantita().put(art, quantita + quantita_attuale);
                    break;
                }
            }
    }

    public void addIngresso(HashMap<Articolo, String> art, Data d) {
        Ingresso ing = new Ingresso(art, d);
        ingressi.add(ing);
    }

    public ArrayList<Ingresso> getIngressi() {
        return ingressi;
    }

    public ArrayList<Articolo> getCatalogoArticoliMagazzino(){
        return catalogoArticoliMagazzino;
    }

    public JComboBox<String> getTipi_articoli_box() {
        return tipi_articoli_box;
    }

    public JComboBox<String> getArticoli_box() {
        return articoli_box;
    }
    

    public HashMap<Articolo, Integer> getMappa_articolo_quantita() {
        return mappa_articolo_quantita;
    }
    
    
    
    //per gli ordini:
    public HashMap<Articolo, Integer> getQuantità() {
        return quantità;
    }

    public void setQuantità(HashMap<Articolo, Integer> quantità, int num_ordine) {
        for (int i = 0; i < ordini.size(); i++) {
            if (abs(ordini.get(i).getOrder_number()) == num_ordine) {
                ordini.get(i).setMapOrdine(quantità);
            }
        }
    }
    public ArrayList<Ordine> getOrdini() {
        return ordini;
    }
    public void addOrdine(Ordine nuovo_ordine) {
        ordini.add(nuovo_ordine);
    }
    public Ordine getOrdineByID(int num_ordine) {
        for (int i = 0; i < ordini.size(); i++) {
            if (abs(ordini.get(i).getOrder_number()) == num_ordine) {
                return ordini.get(i);
            }
        }
        return null;
    }
    public void removeOrderByID(int num_ordine) {
        for (int i = 0; i < ordini.size(); i++) {
            if (abs(ordini.get(i).getOrder_number()) == num_ordine) {
                ordini.remove(ordini.get(i));
            }
        }
    }

    
    
    
    
    
    
    
    
    

    public static Magazzino getInstance() {
        if (INSTANCE_MAGAZZINO == null) {
            INSTANCE_MAGAZZINO = new Magazzino();
        }
        return INSTANCE_MAGAZZINO;
    }

    @Override
    public String toString() {
        return "Magazzino{" + "ingressi=" + ingressi + ", uscite=" + uscite + ", catalogoArticoliMagazzino=" + catalogoArticoliMagazzino + ", tipiArticoli=" + tipiArticoli + ", tipi_articoli_box=" + tipi_articoli_box + ", codice_ingresso=" + codice_ingresso + ", mappa_articolo_quantita=" + mappa_articolo_quantita + '}';
    }

}
