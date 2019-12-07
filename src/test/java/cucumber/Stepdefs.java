package cucumber;

import static org.junit.Assert.assertEquals;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import jotainhauskaa.vinkkilista.domain.KirjaVinkki;
import jotainhauskaa.vinkkilista.dao.MuistiKirjaVinkkiDao;
import java.util.ArrayList;

//import jotainhauskaa.vinkkilista.dao.KirjaVinkkiDao;



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

        kirjavinkit.add(new KirjaVinkki("Tero", "Punaista", "Kirjaa", "12",
                "Kaunokirjallisuus", "", new String[2], new String[2]));
    }

    @Given ("luodaan kirjavinkki jolla ei ole nimeä")
    public void kirjaVinkkiLuodaanNimetta() {
        kirjavinkit.add(new KirjaVinkki("", "", "", "",
                "a", "", new String[1], new String[1]));

    }

    @Then("kirjan kirjoittajan nimen pitäisi olla {string}")
    public void kirjanKirjoittajanNimiOnOikein(String kirjoittajanNimi) {
        assertEquals("Esa", k.getKirjoittaja());
    }

    @Then("nähdaan kirjavinkki")
    public void nahdaanKirjavinkki() {
        assertEquals(1, d.getAll().size());
    }

    @Then("nähdaan kirjavinkit")
    public void nahdaanKirjavinkit() {
        assertEquals(2, d.getAll().size());
    }

    @When("kirjavinkki lisätään muistikirjaan")
    public void kirjavinkkiLisataanMuistikirjaan() {
        d.add(k);
    }

    @Then("kirjavinkki on lisätty muistikirjaan")
    public void kirjaVinkkiLoytyyMuistiKirjasta() {
        assertEquals(1, d.getAll().size());
    }

    @When("kirjavinkit lisätään muistikirjaan")
    public void kirjaVinkitLisataanMuistikirjaan() {
        for (KirjaVinkki vinkki : kirjavinkit) {
            d.add(vinkki);
        }
    }

    @Then ("kirjavinkkiä ei lisätä")
    public void kirjaVinkkejaEiLisataMuistikirjaan()  {
        assertEquals(0, d.getAll().size());
    }


}
