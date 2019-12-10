Feature: Käyttäjänä haluan suodattaa lukuvinkkejä

    Scenario: etsitään kirjavinkeistä
      Given luodaan kirjavinkkejä
      When kirjavinkit lisätään muistikirjaan
      And etsitään kirjavinkkiä hakutekstillä "Puna"
      Then nähdään kirjavinkki


