package jotainhauskaa.vinkkilista.domain;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "kirjavinkki")
public class KirjaVinkki extends Vinkki {
    @Column(name = "kirjoittaja")
    private String kirjoittaja;
    @Column(name = "isbn")
    private String isbn;

    public KirjaVinkki(String kirjoittaja, String otsikko, String tyyppi,
                       String isbn, String kuvaus, String kommentti,
                       String[] tagit, String[] kurssit) {
        super(otsikko, tyyppi, kommentti, kuvaus, tagit, kurssit);        
        this.kirjoittaja = kirjoittaja;
        this.isbn = isbn;
    }

    public KirjaVinkki() {

    }

    public String getKirjoittaja() {
        return kirjoittaja;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Kirjoittaja: " + kirjoittaja + "\n"
                + "Otsikko: " + super.getOtsikko() + "\n"
                + "Tyyppi: " + super.getTyyppi() + "\n"                
                + "ISBN: " + isbn + "\n"
                + "Kuvaus: " + super.getKuvaus() + "\n"
                + "Kommentti: " + super.getKommentti() + "\n"
                + "Tagit: " + Arrays.toString(super.getTagit()) + "\n"
                + "Kurssit: " + Arrays.toString(super.getKurssit());
    }
}