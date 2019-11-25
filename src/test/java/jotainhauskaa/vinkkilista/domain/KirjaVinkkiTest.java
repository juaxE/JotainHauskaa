package jotainhauskaa.vinkkilista.domain;



import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


public class KirjaVinkkiTest {

    
    @Test
    public void uudenKirjavinkinMuodostusJaGetterit() {
        String kirjoittaja = "Joku";
        String otsikko = "Jotain";
        String tyyppi = "Kirja";
        String isbn = "1111-1111";
        String kuvaus = "Joku kirja";
        String kommentti = "Tyhjää täynä";
        String[] tagit = new String[] {"tagi1", "tagi2", "tagi3"};
        String[] kurssit = new String[] {"kurssi1", "kurssi2"};

        KirjaVinkki vinkki = new KirjaVinkki(kirjoittaja, otsikko, 
                                             tyyppi, isbn, kuvaus, 
                                             kommentti, tagit, kurssit);
        
        assertTrue(vinkki.getKirjoittaja().equals(kirjoittaja) 
                   && vinkki.getOtsikko().equals(otsikko) 
                   && vinkki.getTyyppi().equals(tyyppi) 
                   && vinkki.getIsbn().equals(isbn) 
                   && vinkki.getKuvaus().equals(kuvaus) 
                   && vinkki.getKommentti().equals(kommentti) 
                   && vinkki.getTagit() == tagit 
                   && vinkki.getKurssit() == kurssit);
    }

    @Test
    public void kirjavinkinToString() {
        String kirjoittaja = "Joku";
        String otsikko = "Jotain";
        String tyyppi = "Kirja";
        String isbn = "1111-1111";
        String kuvaus = "Joku kirja";
        String kommentti = "Tyhjää täynä";
        String[] tagit = new String[] {"tagi1", "tagi2", "tagi3"};
        String[] kurssit = new String[] {"kurssi1", "kurssi2"};

        String oletettuTuloste = "Kirjoittaja: " + kirjoittaja + "\n"
                                  + "Otsikko: " + otsikko + "\n"
                                  + "Tyyppi: " + tyyppi + "\n"
                                  + "ISBN: " + isbn + "\n"
                                  + "Kuvaus: " + kuvaus + "\n"
                                  + "Kommentti: " + kommentti + "\n"
                                  + "Tagit: [tagi1, tagi2, tagi3]\n"
                                  + "Kurssit: [kurssi1, kurssi2]";

        KirjaVinkki vinkki = new KirjaVinkki(kirjoittaja, otsikko, 
                                             tyyppi, isbn, kuvaus, 
                                             kommentti, tagit, kurssit);

        assertEquals(vinkki.toString(), oletettuTuloste);    
    }



}
