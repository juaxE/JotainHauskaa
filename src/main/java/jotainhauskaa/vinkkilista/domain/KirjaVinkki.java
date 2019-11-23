package jotainhauskaa.vinkkilista.domain;

public class KirjaVinkki {
    private String kirjoittaja;
    private String otsikko;
    private String tyyppi;
    private String isbn;
    private String kuvaus;
    private String kommentti;
    private String[] tagit;
    private String[] kurssit;
    
    public KirjaVinkki(String kirjoittaja, String otsikko, String tyyppi,
                       String isbn, String kuvaus, String kommentti,
                       String[] tagit, String[] kurssit) {
        this.kirjoittaja = kirjoittaja;
        this.otsikko = otsikko;
        this.tyyppi = tyyppi;
        this.isbn = isbn;
        this.kuvaus = kuvaus;
        this.kommentti = kommentti;
        this.tagit = tagit;
        this.kurssit = kurssit;
    }

    public String getKirjoittaja() {
        return kirjoittaja;
    }

    public String getOtsikko() {
        return otsikko;
    }

    public String getTyyppi() {
        return tyyppi;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getKuvaus() {
        return kuvaus;
    }

    public String getKommentti() {
        return kommentti;
    }

    public String[] getTagit() {
        return tagit;
    }

    public String[] getKurssit() {
        return kurssit;
    }
}