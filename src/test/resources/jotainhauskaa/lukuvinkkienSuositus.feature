Feature: Käyttäjänä haluan suodattaa lukuvinkkejä

    Scenario: etsitään kirjavinkeistä
      Given luodaan kirjavinkkejä
      When etsitään kirjavinkkiä hakutekstillä "Esa"
      Then nähdään kirjavinkki


