package jotainhauskaa.vinkkilista.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import jotainhauskaa.vinkkilista.domain.KirjaVinkki;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class KirjaVinkkiDaoTest {

    @Autowired
    private VinkkiRepository vr;

    @Test
    public void vinkkiRepositoryTallentaaJaPalauttaaVinkin() { 
        KirjaVinkki vinkki1 = new KirjaVinkki("1", "Aapinen", "kirja", "1", "1", 
                                  "1", new String[]{"1", "2"}, 
                                   new String[]{"3", "4"});
        
        KirjaVinkki vinkki2 = new KirjaVinkki("1", "Raamattu", "kirja", "2", "2", 
                                  "2", new String[]{"5", "6"}, 
                                   new String[]{"7", "8"});
        
        vr.save(vinkki1);
        vr.save(vinkki2);
        assertEquals(vr.findAll().get(0), vinkki1);
    }
    @Test
    public void kirjaVinkinDaoPalauttaaOikeanMaaranVinkkeja() {
        assertEquals(vr.findAll().size(), 2);
    }
}