package cucumber;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import jotainhauskaa.vinkkilista.domain.KirjaVinkki;
import jotainhauskaa.vinkkilista.dao.MuistiKirjaVinkkiDao;
import jotainhauskaa.vinkkilista.dao.KirjaVinkkiDao;

public class Stepdefs {
    private KirjaVinkki k;
    private KirjaVinkkiDao d = new MuistiKirjaVinkkiDao();

    @Given("luodaan kirjavinkki jonka kirjoittaja on {string}")
    public void kirjavinkkiLuodaan (String kirjoittajanNimi) {
        k = new KirjaVinkki("Esa", "Häivähdys punaista", "Kirja", "121212", 
        "Kaunokirjallisuus", "", new String [1], new String [1]);
  
    }
    @Then("kirjan kirjoittajan nimen pitäisi olla {string}")
    public void kirjanKirjoittajanNimiOnOikein (String kirjoittajanNimi) {
        assertEquals("Esa", k.getKirjoittaja());
    }
    @When("kirjavinkki lisätään muistikirjaan")
    public void kirjavinkkiLisataanMuistikirjaan() {
        d.add(k);
    }
    @Then("kirjavinkki on lisätty muistikirjaan")
    public void kirjaVinkkiLoytyyMuistiKirjasta() {
        assertEquals(1, d.getAll().size());
    }     
}
