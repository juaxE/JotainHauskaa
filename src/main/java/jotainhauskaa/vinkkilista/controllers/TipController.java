package jotainhauskaa.vinkkilista.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import jotainhauskaa.vinkkilista.domain.KirjaVinkki;
import jotainhauskaa.vinkkilista.dao.MuistiKirjaVinkkiDao;

@Controller
public class TipController {
    KirjaVinkki kirjavinkki;
    MuistiKirjaVinkkiDao muistiKirjaVinkkiDao = new MuistiKirjaVinkkiDao ();

    /*
     * @RequestMapping("/")
     * 
     * @ResponseBody public String testHandler() { return "<h1>Tips</h1>"; }
     */
    @GetMapping("/lisaavinkki")
    public String lisaysSivu() {
        return "lisayssivu";
    }

    @GetMapping("/")
    public String etusivu() {
        return "etusivu";
    }

    @PostMapping("/lisaavinkki")
    public String vinkinLisays(@RequestParam String kirjoittaja, @RequestParam String otsikko, 
    @RequestParam String tyyppi, @RequestParam String isbn, @RequestParam String kuvaus, 
    @RequestParam String kommentti, @RequestParam String tagit, @RequestParam String kurssit) {
        //tällä hetkellä tageja ja kursseja on vain yhden. jatkossa tehdään tämä jollakin muulla tavalla
        String t [] = new String[1];
        t[0] = tagit;
        String k [] = new String[1];
        k[0] = kurssit;
        muistiKirjaVinkkiDao.add(new KirjaVinkki(kirjoittaja, otsikko, tyyppi, isbn, kuvaus, kommentti, t, k));
        return "redirect:/";

    }
    @GetMapping("/selaa")
    public String vinkkienSelailu(Model model) {
        model.addAttribute("vinkit", muistiKirjaVinkkiDao.getAll());
        return "selaussivu";
    }

}