package jotainhauskaa.vinkkilista.domain;


public class Vinkki {
    private String otsikko;
    private String tyyppi; // Lukuvinkin tyyppi
    private String[] tagit;
    private String[] kurssit;
    private String kommentti;
    private String kuvaus;
    private Integer id;

    
    public Vinkki(String otsikko, String tyyppi, String kommentti, 
                String kuvaus, String[] tagit, String[] kurssit) {
        this.otsikko = otsikko;
        this.tyyppi = tyyppi;
        this.kommentti = kommentti;
        this.kuvaus = kuvaus;
        this.tagit = tagit;
        this.kurssit = kurssit;        
    }

    public String getOtsikko() {
        return otsikko;
    }

    public String getTyyppi() {
        return tyyppi;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer idCode) {
        this.id = idCode;
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