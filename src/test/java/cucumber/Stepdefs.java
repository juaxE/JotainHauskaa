package cucumber;

import static org.junit.Assert.assertEquals;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import jotainhauskaa.vinkkilista.domain.KirjaVinkki;
import jotainhauskaa.vinkkilista.dao.MuistiKirjaVinkkiDao;
import java.util.ArrayList;


//import jotainhauskaa.vinkkilista.dao.VinkkiRepository;
import jotainhauskaa.vinkkilista.util.ISBNLoader;


public class Stepdefs {
    private KirjaVinkki k;
    private ArrayList<KirjaVinkki> kirjavinkit = new ArrayList<KirjaVinkki>();
    private MuistiKirjaVinkkiDao d = new MuistiKirjaVinkkiDao();

    @Given("luodaan kirjavinkki jonka kirjoittaja on {string}")
    public void kirjavinkkiLuodaan(String kirjoittajanNimi) {
        k = new KirjaVinkki(kirjoittajanNimi, "Punaista", "Kirjaa", "12",
                "Kaunokirjallisuus", "", new String[1], new String[1]);
    }

    @Given("luodaan kirjavinkkejä")
    public void kirjavinkitLuodaan() {
        kirjavinkit.add(new KirjaVinkki("Esa", "Punaista", "Kirjaa", "12",
                "Kaunokirjallisuus", "", new String[1], new String[1]));

        kirjavinkit.add(new KirjaVinkki("Tero", "Sinistä", "Kirjaa", "12",
                "Kaunokirjallisuus", "", new String[2], new String[2]));
    }

    @Given ("luodaan kirjavinkki jolla ei ole nimeä")
    public void kirjaVinkkiLuodaanNimetta() {
        kirjavinkit.add(new KirjaVinkki("", "", "", "",
                "a", "", new String[1], new String[1]));

    }

    @Given ("luodaan kirjavinkki ISBN-koodilla {string}")
    public void kirjaVinkkiLuontiISBN(String isbn) {
        k = new ISBNLoader().getByISBN(isbn);
        d.add(k);
    }


    @When("kirjavinkki lisätään muistikirjaan")
    public void kirjavinkkiLisataanMuistikirjaan() {
        d.add(k);
    }

    @When("kirjavinkit lisätään muistikirjaan")
    public void kirjaVinkitLisataanMuistikirjaan() {
        for (KirjaVinkki vinkki : kirjavinkit) {
            d.add(vinkki);
        }
    }

    @When("muokataan nimeksi {string}")
    public void kirjaVinkinMuokkaus(String nimi) {
        k.setKirjoittaja(nimi);
    }

    @When("poistetaan ensimmäinen kirjavinkki")
    public void poistetaanEnsimmainenKirjavinkki() {
        d.remove(Long.valueOf(0));
    }

    @When("poistetaan kirjavinkit")
    public void poistetaanKirjavinkit() {
        d.removeAll();
    }

    @When("etsitään kirjavinkkiä hakutekstillä {string}")
    public void etsitaanKirjavinkkiaHakutekstilla(String teksti) {
        ArrayList<KirjaVinkki> loydot = d.find(teksti);
        d.removeAll();
        for (KirjaVinkki vinkki : loydot) {
            d.add(vinkki);
        }
    }


    @Then("kirjan kirjoittajan nimen pitäisi olla {string}")
    public void kirjanKirjoittajanNimiOnOikein(String kirjoittajanNimi) {
        assertEquals(kirjoittajanNimi, k.getKirjoittaja());
    }

    @Then("kirjan nimen pitäisi olla {string}")
    public void kirjanNimiOnOikein(String kirjanNimi) {
        assertEquals(kirjanNimi, k.getOtsikko());
    }

    @Then("nähdään kirjavinkki")
    public void nahdaanKirjavinkki() {
        assertEquals(1, d.getAll().size());
    }

    @Then("nähdään kirjavinkit")
    public void nahdaanKirjavinkit() {
        assertEquals(2, d.getAll().size());
    }

    @Then("kirjavinkki on lisätty muistikirjaan")
    public void kirjaVinkkiLoytyyMuistiKirjasta() {
        assertEquals(1, d.getAll().size());
    }

    @Then ("kirjavinkkejä ei ole")
    public void kirjaVinkkejaEiLisataMuistikirjaan()  {
        assertEquals(0, d.getAll().size());
    }


}
