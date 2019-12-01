package jotainhauskaa.vinkkilista.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jotainhauskaa.vinkkilista.domain.KirjaVinkki;
import jotainhauskaa.vinkkilista.domain.KirjaVinkkiForm;
import jotainhauskaa.vinkkilista.dao.MuistiKirjaVinkkiDao;
import jotainhauskaa.vinkkilista.dao.VinkkiRepository;


@Controller
public class TipController {
    private MuistiKirjaVinkkiDao muistiKirjaVinkkiDao 
            = new MuistiKirjaVinkkiDao();

    @Autowired
    private VinkkiRepository vinkit;

    @GetMapping("/lisaavinkki")
    public String lisaysSivu(KirjaVinkkiForm vinkki) {
        return "lisayssivu";
    }

    @GetMapping("/")
    public String etusivu() {
        return "etusivu";
    }

    @PostMapping("/lisaavinkki")
    public String vinkinLisays(@Valid KirjaVinkkiForm vinkki,
        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "lisayssivu";
        }

        vinkit.save(vinkki.getKirjaVinkki());
        return "redirect:/";
    }

    @GetMapping("/selaa")
    public String vinkkienSelailu(Model model) {
        model.addAttribute("vinkit", vinkit.findAll());
        return "selaussivu";
    }

    @GetMapping("/paivita")
    public String getOne(Model model, @RequestParam("id") Long id) {
        KirjaVinkki vinkki = vinkit.getOne(id);
        model.addAttribute("vinkki", vinkki);
        return "paivityssivu";
    }

    @PostMapping("paivitaVinkinTiedot")
    public String vinkinPaivitys(@Valid KirjaVinkkiForm vinkki,
    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "paivityssivu";
        }

        vinkit.save(vinkki.getKirjaVinkki());
        return "redirect:/";
    }

}