package jotainhauskaa.vinkkilista.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Inheritance(
    strategy = InheritanceType.JOINED
)
@Entity
@Table(name = "vinkki")
public class Vinkki extends AbstractPersistable<Long> {

    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty(message = "Otsikko ei voi olla tyhjä")
    @Size(min = 3, max = 255, message = "Otsikon täytyy olla vähintään 3 merkkiä pitkä")
    @Column(name = "otsikko")
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

    public Vinkki() {
        
    }

    public Vinkki(String otsikko, String tyyppi, String kommentti, 
                String kuvaus, String[] tagit, String[] kurssit) {
        this.otsikko = otsikko;
        this.tyyppi = tyyppi;
        this.kommentti = kommentti;
        this.kuvaus = kuvaus;
        this.tagit = tagit;
        this.kurssit = kurssit;        
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOtsikko() {
        return this.otsikko;
    }

    public void setOtsikko(String otsikko) {
        this.otsikko = otsikko;
    }

    public String getTyyppi() {
        return this.tyyppi;
    }

    public void setTyyppi(String tyyppi) {
        this.tyyppi = tyyppi;
    }

    public String[] getTagit() {
        return this.tagit;
    }

    public void setTagit(String[] tagit) {
        this.tagit = tagit;
    }

    public String[] getKurssit() {
        return this.kurssit;
    }

    public void setKurssit(String[] kurssit) {
        this.kurssit = kurssit;
    }

    public String getKommentti() {
        return this.kommentti;
    }

    public void setKommentti(String kommentti) {
        this.kommentti = kommentti;
    }

    public String getKuvaus() {
        return this.kuvaus;
    }

    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }
}