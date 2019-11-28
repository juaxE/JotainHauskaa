package jotainhauskaa.vinkkilista.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jotainhauskaa.vinkkilista.domain.KirjaVinkki;

public class MuistiKirjaVinkkiDao 
    implements LukuvinkkiDao<KirjaVinkki, Integer> {

    //private List<KirjaVinkki> kirjavinkit;
    private HashMap<Integer, KirjaVinkki> kirjavinkit;

    public MuistiKirjaVinkkiDao() {
        //kirjavinkit = new ArrayList<KirjaVinkki>();
        this.kirjavinkit = new HashMap<>();
    }

    @Override
    public List<KirjaVinkki> getAll() {
        List<KirjaVinkki> vinkit = new ArrayList<>();
        for (KirjaVinkki v : this.kirjavinkit.values()) {
            vinkit.add(v);
        }
        return vinkit;
    }

    @Override
    public void add(KirjaVinkki vinkki) {
        int id = kirjavinkit.size() + 1;
        vinkki.setId(id);
        kirjavinkit.put(id, vinkki);        
    }
    
    @Override
    public void update(KirjaVinkki vinkki)   {
        kirjavinkit.put(vinkki.getId(), vinkki);        
    }
    
    @Override
    public KirjaVinkki getOne(Integer id) {
        return kirjavinkit.getOrDefault(id, null);

    }
}