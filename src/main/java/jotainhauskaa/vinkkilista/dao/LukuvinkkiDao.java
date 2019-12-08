package jotainhauskaa.vinkkilista.dao;

import java.util.List;
//import jotainhauskaa.vinkkilista.domain.KirjaVinkki;

public interface LukuvinkkiDao<T, K> {
    List<T> getAll();
    
    void add(T vinkki);
    
}