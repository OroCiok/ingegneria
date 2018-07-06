/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoingegneriasw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author ionbaltaga
 */
public class MagazzinoController implements ActionListener{

    private MagazzinoView magazzinoView;

    private IngressoView new_ingresso;
    
    private ModificaIngressoView modifica_ingresso_view;
    
    private InventarioMagazzinoView inventario_view;

    //private ArrayList<Articolo> articoli = new ArrayList<Articolo>();//arraylist temporaneo che memorizza gli articoli della view da essere inseriti nell'oggetto ingresso
    private HashMap<Articolo, String> mappa_articolo_posizione;

    private String[] utenti = {"segreteria", "magazzino", "gestioneNegozio"};
    private String[] password = {"ciao1234", "salut1234", "privet1234"};

    public MagazzinoController(MagazzinoView magazzinoView, Magazzino magazzino) {
        this.magazzinoView = magazzinoView;
        this.new_ingresso = new IngressoView();
        this.modifica_ingresso_view=new ModificaIngressoView();
        this.inventario_view=new InventarioMagazzinoView();
        this.mappa_articolo_posizione = new HashMap<Articolo, String>();
        magazzinoView.addActionListeners(this);
        magazzinoView.setVisible(true);
        magazzinoView.setResizable(false);
        magazzinoView.setBounds(275, 275, 360, 290);

        new_ingresso.addActionListeners(this);
        new_ingresso.setVisible(false);
        new_ingresso.setBounds(275, 275, 1050, 250);
        new_ingresso.setResizable(true);
        
        modifica_ingresso_view.addActionListeners(this);
        modifica_ingresso_view.setVisible(false);
        modifica_ingresso_view.setResizable(false);
        modifica_ingresso_view.setBounds(275,275,1050,500);
        
        inventario_view.addActionListeners(this);
        inventario_view.setVisible(false);
        inventario_view.setBounds(275,275,500,300);
        inventario_view.setResizable(false);
        

    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == magazzinoView.bottone_ingresso) {
            magazzinoView.setVisible(false);
            new_ingresso.setVisible(true);
            new_ingresso.posizione_box.setSelectedIndex(-1);
            Magazzino.getInstance().getArticoli_box().setSelectedIndex(-1);

        }
        if (e.getSource() == new_ingresso.back) {
            magazzinoView.setVisible(true);
            new_ingresso.setVisible(false);
        }
        if (e.getSource() == new_ingresso.aggiungi_ingresso) {
            LocalDateTime now = LocalDateTime.now();
            Data d = new Data(now.getDayOfMonth(), now.getMonthValue(), now.getYear());//data corrente dell'inserimento in magazzino
            Magazzino.getInstance().addIngresso((HashMap<Articolo, String>) mappa_articolo_posizione.clone(), d);
            Ingresso ultimoing = Magazzino.getInstance().getIngressi().get(Magazzino.getInstance().getIngressi().size() - 1);
            Object[] v = {"" + ultimoing.getCodIntUnivoco(), ultimoing.getData()};
            new_ingresso.table_model_ingressi.addRow(v);

            new_ingresso.posizione_box.setSelectedIndex(-1);
            Magazzino.getInstance().getTipi_articoli_box().setSelectedIndex(-1);
            mappa_articolo_posizione.clear();
            new_ingresso.table_model.setRowCount(0);

        }
        if (e.getSource() == magazzinoView.back) {
            magazzinoView.setVisible(false);
            LoginController login = new LoginController(new LoginView(), new Login(utenti, password),Magazzino.getInstance());
        }
   
        if (e.getSource() == new_ingresso.aggiungi_articolo) {
            int pos=Magazzino.getInstance().getArticoli_box().getSelectedIndex();
            Articolo art=Magazzino.getInstance().getCatalogoArticoliMagazzino().get(pos);
            //aggiungo articolo e posizione alla mappa
            mappa_articolo_posizione.put(art, new_ingresso.posizione_box.getSelectedItem().toString());
            
            //aggiungo alla hashmap articolo e quantità
            Magazzino.getInstance().addArticoloQuantita(art, Integer.parseInt(new_ingresso.field_quantita.getText()));
            TipoArticolo tipoart=art.getTypeArticle();
            Object[] v = {tipoart.getNome(), art.getPrice(), art.getProductionDate().toString(), new_ingresso.posizione_box.getSelectedItem().toString(), new_ingresso.field_quantita.getText()};
            new_ingresso.table_model.addRow(v);
            new_ingresso.field_quantita.setText("");
            }
        
        if (e.getSource() == magazzinoView.bottone_modifica_ingresso) {
            modifica_ingresso_view.table_model_art.setRowCount(0); 
            modifica_ingresso_view.setVisible(true);
            magazzinoView.setVisible(false);

            String nome_articolo, ingresso_date, articolo_quantity, articolo_position;
            
            for (int i = 0; i < Magazzino.getInstance().getIngressi().size(); i++) {
                for (Articolo articolo : Magazzino.getInstance().getIngressi().get(i).getArticoli().keySet()) {
                    ingresso_date = Magazzino.getInstance().getIngressi().get(i).getData();
                    nome_articolo = articolo.getTypeArticle().getNome();
                    articolo_position = Magazzino.getInstance().getIngressi().get(i).getArticoli().get(articolo);
                    articolo_quantity = "" + Magazzino.getInstance().getMappa_articolo_quantita().get(articolo);

                    Object[] riga = {Magazzino.getInstance().getIngressi().get(i).hashCode(),nome_articolo, articolo_position};
                    modifica_ingresso_view.table_model_art.addRow(riga);
                }
            }
        }
        
        if(e.getSource() == modifica_ingresso_view.back){
            modifica_ingresso_view.setVisible(false);
            magazzinoView.setVisible(true);
        }
        if(e.getSource() == magazzinoView.bottone_modifica_ingresso){
            modifica_ingresso_view.setVisible(true);
            magazzinoView.setVisible(false);
        }
        
        
        
        if(e.getSource() == magazzinoView.bottone_inventario){
            inventario_view.table_model_art.setRowCount(0);
            inventario_view.setVisible(true);
            magazzinoView.setVisible(false);
            
            for (Articolo articolo : Magazzino.getInstance().getMappa_articolo_quantita().keySet()){
                Object v[]={articolo.getTypeArticle().toString(),Magazzino.getInstance().getMappa_articolo_quantita().get(articolo)};
                inventario_view.table_model_art.addRow(v);
            }
            
            
        }
        if(e.getSource() == inventario_view.back){
            inventario_view.setVisible(false);
            magazzinoView.setVisible(true);
        }
    }

}
