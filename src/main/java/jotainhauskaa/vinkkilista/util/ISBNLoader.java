package jotainhauskaa.vinkkilista.util;

import jotainhauskaa.vinkkilista.domain.KirjaVinkki;

import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.books.Books;
import com.google.api.services.books.Books.Volumes.List;
import com.google.api.services.books.model.Volume;
import com.google.api.services.books.model.Volumes;
import com.google.api.services.books.model.Volume.VolumeInfo;

import com.google.api.client.http.javanet.NetHttpTransport;

public class ISBNLoader {

    public KirjaVinkki getByISBN(String isbn) {
        if (isbn == null || isbn.equals("")) {
            return null;
        }
        
        isbn = isbn.replace("-", "");
        
        String q = "isbn:" + isbn;

        try {
            final Books books = new Books(new NetHttpTransport(), new JacksonFactory(), null);
            List volumesQuery = books.volumes().list(q);

            Volumes volumes = volumesQuery.execute();

            if (volumes.getTotalItems() == 0) {
                return null;
            }

            KirjaVinkki vinkki = convertToKirjaVinkki(volumes.getItems().get(0));

            return vinkki;
        } catch (Exception ex) {
            return null;
        }
    }

    private KirjaVinkki convertToKirjaVinkki(Volume volume) {
        VolumeInfo volumeInfo = volume.getVolumeInfo();
        
        String kirjoittaja = volumeInfo.getAuthors().get(0);
        kirjoittaja = kirjoittaja != null ? kirjoittaja : "";

        String otsikko = volumeInfo.getTitle();

        String tyyppi = "Kirja";

        String isbn = volumeInfo.getIndustryIdentifiers().get(0).getIdentifier();
        isbn = isbn != null ? isbn : "";

        String kuvaus = volumeInfo.getDescription();
        kuvaus = kuvaus != null ? kuvaus : "";
        if (kuvaus.length() > 255) {
            kuvaus = kuvaus.substring(0, 252) + "...";
        }

        String kommentti = "";

        String[] tagit = volumeInfo.getCategories() != null 
            ? volumeInfo.getCategories().toArray(new String[0]) 
            : new String[] {};

        String[] kurssit = new String[] {};
        
        KirjaVinkki vinkki = new KirjaVinkki(kirjoittaja, otsikko, 
                                            tyyppi, isbn, kuvaus, 
                                            kommentti, tagit, kurssit);
        
        return vinkki; 
    }
}