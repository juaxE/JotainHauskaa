package jotainhauskaa.vinkkilista.dao;

import java.util.List;
//import jotainhauskaa.vinkkilista.domain.KirjaVinkki;

public interface LukuvinkkiDao<T, K> {
    List<T> getAll();
    T getOne(K id);
    void add(T vinkki);
    void update(T vinkki);
}