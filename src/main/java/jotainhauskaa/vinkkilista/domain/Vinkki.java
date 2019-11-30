package jotainhauskaa.vinkkilista.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.springframework.data.jpa.domain.AbstractPersistable;


@Inheritance(
    strategy = InheritanceType.JOINED
)
@Entity
@DiscriminatorColumn(name = "vinkki", schema="xxxxx")

public class Vinkki extends AbstractPersistable<Long> {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "otsiko")
    private String otsikko;
    @Column(name = "tyyppi")
    private String tyyppi; // Lukuvinkin tyyppi
    @Column(name = "tagit")
    private String[] tagit;
    @Column(name = "kurssit")
    private String[] kurssit;
    @Column(name = "kommentti")
    private String kommentti;
    @Column(name = "kuvaus")
    private String kuvaus;


    
    public Vinkki(String otsikko, String tyyppi, String kommentti, 
                String kuvaus, String[] tagit, String[] kurssit) {
        this.otsikko = otsikko;
        this.tyyppi = tyyppi;
        this.kommentti = kommentti;
        this.kuvaus = kuvaus;
        this.tagit = tagit;
        this.kurssit = kurssit;        
    }
    public Vinkki() {

    }
    public String getOtsikko() {
        return otsikko;
    }

    public String getTyyppi() {
        return tyyppi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long idCode) {
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