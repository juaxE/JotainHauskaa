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
import jotainhauskaa.vinkkilista.dao.VinkkiRepository;


@Controller
public class TipController {
    @Autowired
    private VinkkiRepository vinkit;

    @GetMapping("/lisaavinkki")
    public String lisaysSivu(KirjaVinkki vinkki) {
        return "lisayssivu";
    }

    @GetMapping("/")
    public String etusivu() {
        return "etusivu";
    }

    @PostMapping("/lisaavinkki")
    public String vinkinLisays(@Valid KirjaVinkki vinkki,
        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "lisayssivu";
        }

        vinkit.save(vinkki);
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
    @GetMapping("/poista")
    public String poista(@RequestParam("id") Long id) {
        vinkit.deleteById(id);
        return "selaussivu";
    }
 
    @GetMapping("/hae")
    public String haunSelailu(Model model, @RequestParam(value = "haku", required = false) String haku) {
        if (haku != null) {
            model.addAttribute("vinkit", vinkit.findByOtsikkoContainingIgnoreCase(haku));
        }

        model.addAttribute("hakuehto", haku);
        return "hakusivu";
    }

    @PostMapping("paivitaVinkinTiedot")
    public String vinkinPaivitys(@Valid KirjaVinkki vinkki, 
    @RequestParam("id") Long id,
    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "paivityssivu";
        }

        vinkit.save(vinkki);
        return "redirect:/selaa";
    }
    

    
    
}