package jotainhauskaa.vinkkilista.dao;

import java.util.List;
import jotainhauskaa.vinkkilista.domain.KirjaVinkki;

public interface KirjaVinkkiDao {
    List<KirjaVinkki> getAll();
    void add(KirjaVinkki vinkki);
}