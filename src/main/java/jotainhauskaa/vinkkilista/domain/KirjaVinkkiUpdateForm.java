package jotainhauskaa.vinkkilista.domain;

public class KirjaVinkkiUpdateForm extends KirjaVinkkiForm {



    
    public KirjaVinkki getKirjaVinkki(Long id) {
        KirjaVinkki paivitetty = new KirjaVinkki(super.getKirjoittaja(), 
                                super.getOtsikko(), 
                                super.getTyyppi(), 
                                super.getIsbn(), 
                                super.getKuvaus(), 
                                super.getKommentti(), 
                                super.getTagit(), 
                                super.getKurssit()
                                );
        paivitetty.setId(id);

        return paivitetty;
    }
}
