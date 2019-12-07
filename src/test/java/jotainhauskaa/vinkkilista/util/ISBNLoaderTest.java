package jotainhauskaa.vinkkilista.util;

import org.junit.Test;

import jotainhauskaa.vinkkilista.domain.KirjaVinkki;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class ISBNLoaderTest {
    @Test
    public void tyhjallaIsbnllaTulosNull() {
        final ISBNLoader loader = new ISBNLoader();

        KirjaVinkki vinkki = loader.getByISBN("");

        assertEquals(vinkki, null);
    }

    @Test
    public void nullIsbnTulosNull() {
        final ISBNLoader loader = new ISBNLoader();

        KirjaVinkki vinkki = loader.getByISBN(null);

        assertEquals(vinkki, null);
    }

    @Test
    public void isbnReturnsExcpectedBook() {
        final ISBNLoader loader = new ISBNLoader();

        KirjaVinkki vinkki = loader.getByISBN("9780521809269");

        assertTrue(vinkki.getOtsikko().equals("The Art of Electronics") 
                   && vinkki.getKirjoittaja().equals("Paul Horowitz"));
    }
}