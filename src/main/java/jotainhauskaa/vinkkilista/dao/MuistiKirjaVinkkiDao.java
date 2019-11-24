package jotainhauskaa.vinkkilista.dao;

import java.util.ArrayList;
import java.util.List;
import jotainhauskaa.vinkkilista.domain.KirjaVinkki;

public class MuistiKirjaVinkkiDao implements KirjaVinkkiDao {
    private List<KirjaVinkki> kirjavinkit;

    public MuistiKirjaVinkkiDao() {
        kirjavinkit = new ArrayList<KirjaVinkki>();
    }

    @Override
    public List<KirjaVinkki> getAll() {
        return kirjavinkit;
    }

    @Override
    public void add(KirjaVinkki vinkki) {
        kirjavinkit.add(vinkki);
    }
    
        
    
}