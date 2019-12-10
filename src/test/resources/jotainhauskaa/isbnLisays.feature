Feature: Käyttäjänä haluan voida lisätä kirjavinkin ISBN:n perusteella

  Scenario: lisätään kirjavinkki ISBN-koodilla
    Given luodaan kirjavinkki ISBN-koodilla "9781789539134"
    Then kirjan nimen pitäisi olla "Developing Java Applications with Spring and Spring Boot"

