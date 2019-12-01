package jotainhauskaa.vinkkilista.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class KirjaVinkkiForm {
    @NotEmpty(message = "Otsikko ei voi olla tyhjä")
    @Size(min = 3, max = 255,
        message = "Otsikon pitää olla vähintään 3 merkkiä pitkä")
    private String otsikko;
    private String tyyppi;
    private String[] tagit;
    private String[] kurssit;
    private String kommentti;
    private String kuvaus;
    private String kirjoittaja;
    private String isbn;

    public String getOtsikko() {
        return otsikko;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getKirjoittaja() {
        return kirjoittaja;
    }

    public void setKirjoittaja(String kirjoittaja) {
        this.kirjoittaja = kirjoittaja;
    }

    public String getKuvaus() {
        return kuvaus;
    }

    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    public String getKommentti() {
        return kommentti;
    }

    public void setKommentti(String kommentti) {
        this.kommentti = kommentti;
    }

    public String[] getKurssit() {
        return kurssit;
    }

    public void setKurssit(String[] kurssit) {
        this.kurssit = kurssit;
    }

    public String[] getTagit() {
        return tagit;
    }

    public void setTagit(String[] tagit) {
        this.tagit = tagit;
    }

    public String getTyyppi() {
        return tyyppi;
    }

    public void setTyyppi(String tyyppi) {
        this.tyyppi = tyyppi;
    }

    public void setOtsikko(String otsikko) {
        this.otsikko = otsikko;
    }

    public KirjaVinkki getKirjaVinkki() {
        return new KirjaVinkki(kirjoittaja, otsikko, tyyppi, isbn, kuvaus, kommentti, tagit, kurssit);
    }
}