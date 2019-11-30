package jotainhauskaa.vinkkilista.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jotainhauskaa.vinkkilista.domain.KirjaVinkki;

public class MuistiKirjaVinkkiDao 
    implements LukuvinkkiDao<KirjaVinkki, Integer> {

    private List<KirjaVinkki> kirjavinkit;

    public MuistiKirjaVinkkiDao() {
        //kirjavinkit = new ArrayList<KirjaVinkki>();
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
    public void update(KirjaVinkki vinkki)   {
              
    }
    
    @Override
    public KirjaVinkki getOne(Integer id) {
        return null;

    }
}