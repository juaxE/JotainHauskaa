Feature: Käyttäjänä haluan voida poistaa kirjavinkkejä

  Scenario: muokataan kirjavinkin nimeä
    Given luodaan kirjavinkki jonka kirjoittaja on "Esa"
    When poistetaan ensimmäinen kirjavinkki
    Then kirjavinkkejä ei ole

  Scenario: muokataan kirjavinkin nimeä
    Given luodaan kirjavinkkejä
    When poistetaan kirjavinkit
    Then kirjavinkkejä ei ole