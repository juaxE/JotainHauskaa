package jotainhauskaa.vinkkilista.dao;

import java.util.ArrayList;
import java.util.List;

import jotainhauskaa.vinkkilista.domain.KirjaVinkki;

public class MuistiKirjaVinkkiDao 
    implements LukuvinkkiDao<KirjaVinkki, Long> {

    private List<KirjaVinkki> kirjavinkit;

    public MuistiKirjaVinkkiDao() {        
        this.kirjavinkit = new ArrayList<>();
    }

    @Override
    public List<KirjaVinkki> getAll() {
        return this.kirjavinkit;
    }

    @Override
    public void add(KirjaVinkki vinkki) {
        kirjavinkit.add(vinkki);        
    }

    @Override
    public void remove(Long id) {
        kirjavinkit.remove(id);
    }


    public ArrayList<KirjaVinkki> find(String haku) {
        ArrayList<KirjaVinkki> loydot = new ArrayList<>();
        for (KirjaVinkki k : kirjavinkit) {
            if (k.getOtsikko().contains(haku)) {
                loydot.add(k);
            }
        }


        return loydot;
    }

    @Override
    public void removeAll() {
        this.kirjavinkit.clear();
    }
      
}