package jotainhauskaa.vinkkilista.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import jotainhauskaa.vinkkilista.dao.VinkkiRepository;
import jotainhauskaa.vinkkilista.domain.KirjaVinkki;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class TipControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private VinkkiRepository vinkit;

    @Before
    public void setUp() {
        KirjaVinkki vinkki = new KirjaVinkki();
        vinkki.setOtsikko("Testi otsikko");
        vinkit.save(vinkki);

        KirjaVinkki v2 = new KirjaVinkki();
        v2.setOtsikko("kirjan");
        v2.setKirjoittaja("kirjoittaja");
        vinkit.save(v2);
    }

    @Test
    public void sovellusPalauttaaEtusivun() throws Exception {
        MvcResult res = mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andReturn();

        String content = res.getResponse().getContentAsString();
        assertTrue(content.contains("Tervetuloa JotainHauskaa"));
    }

    @Test
    public void sovellusPalauttaaLisaysFormin() throws Exception {
        MvcResult res = mockMvc.perform(get("/lisaavinkki"))
            .andReturn();

        String content = res.getResponse().getContentAsString();
        assertTrue(content.contains("Lisää kirjavinkki"));
    }

    @Test
    public void sovellusPalauttaaPaivitysSivun() throws Exception {
        MvcResult res = mockMvc.perform(get("/paivita?id=1"))
            .andReturn();

        String content = res.getResponse().getContentAsString();
        assertTrue(content.contains("Päivitä kirjavinkki"));
    }

    @Test
    public void sovellusPalauttaaSelausSivun() throws Exception {
        MvcResult res = mockMvc.perform(get("/selaa"))
            .andReturn();

        String content = res.getResponse().getContentAsString();
        assertTrue(content.contains("Lisätyt kirjavinkit"));
    }


    
    @Test public void lisaaFormPalauttaaVirheet() throws Exception {
        MvcResult res = mockMvc.perform(
            post("/lisaavinkki")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED).characterEncoding("UTF-8"))
            .andExpect(status().isOk())
            .andReturn();

        String content = res.getResponse().getContentAsString();
        assertTrue(content.contains("Otsikko ei voi olla tyhjä"));
    }

    @Test public void lisaaFormMeneeLapi() throws Exception {
        mockMvc.perform(
            post("/lisaavinkki")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED).characterEncoding("UTF-8")
                .param("otsikko", "otsikko"))
            .andExpect(status().is3xxRedirection());
    }

    @Test public void sovellusPalauttaaHakuSivun() throws Exception {
        MvcResult res = mockMvc.perform(
            get("/hae")
                .param("haku", "Testi"))
            .andExpect(status().isOk())
            .andReturn();

        String content = res.getResponse().getContentAsString();
        assertTrue(content.contains("Hakutulokset haulla:"));
    }


}