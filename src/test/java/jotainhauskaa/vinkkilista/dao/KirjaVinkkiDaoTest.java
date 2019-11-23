package jotainhauskaa.vinkkilista.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jotainhauskaa.vinkkilista.domain.KirjaVinkki;

public class KirjaVinkkiDaoTest {
    private KirjaVinkki vinkki1;
    private KirjaVinkki vinkki2;

    @BeforeEach
    public void setUp() {
        vinkki1 = new KirjaVinkki("1", "1", "kirja", "1", "1", 
                                  "1", new String[]{"1", "2"}, 
                                   new String[]{"3", "4"});
        
        vinkki2 = new KirjaVinkki("2", "2", "kirja", "2", "2", 
                                  "2", new String[]{"5", "6"}, 
                                   new String[]{"7", "8"});
    }

    @Test
    public void luotuKirjaVinkinDaoPalauttaaTyhjanListan() {
        KirjaVinkkiDao dao = new MuistiKirjaVinkkiDao();

        assertEquals(dao.getAll().size(), 0);
    }

    @Test
    public void kirjaVinkinDaoTallentaaJaPalauttaaVinkin() {
        
        KirjaVinkkiDao dao = new MuistiKirjaVinkkiDao();
        dao.add(vinkki1);

        assertEquals(dao.getAll().get(0), vinkki1);
    }

    @Test
    public void kirjaVinkinDaoPalauttaaOikeanMaaranVinkkeja() {
        
        KirjaVinkkiDao dao = new MuistiKirjaVinkkiDao();
        dao.add(vinkki1);
        dao.add(vinkki2);

        assertEquals(dao.getAll().size(), 2);
    }
}