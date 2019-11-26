Feature: Käyttäjänä haluan voida nähdä kirjavinkit

  Scenario: katsotaan kirjavinkki
    Given luodaan kirjavinkki jonka kirjoittaja on "Esa"
    When kirjavinkki lisätään muistikirjaan
    Then nähdään kirjavinkki

  Scenario: katsotaan useita kirjavinkkejä
    Given luodaan kirjavinkkejä
    When kirjavinkit lisätään muistikirjaan
    Then nähdään kirjavinkit