Feature: Käyttäjänä haluan voida muokata kirjavinkkiä

  Scenario: muokataan kirjavinkin nimeä
    Given luodaan kirjavinkki jonka kirjoittaja on "Esa"
    When muokataan nimeksi "Vesa"
    Then kirjan kirjoittajan nimen pitäisi olla "Vesa"

    