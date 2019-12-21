# Raportti

## Ryhmä *JotainHauskaa*

* Juho Kirvesmäki
* Markus Lumme
* Otto Pirttimaa
* Petri Karhunkoski
* Juuso Karvonen

## Tiimin tausta

Tiimi muodostettiin aloitustapaamisessa, eli emme tunteneet toisiamme ennestään. Ryhmässämme kaikki sprintit sujuivat samalla kaavalla. Asiakas oli aina tyytyväinen näkemäänsä. Hän antoi meille muutamia hyviä neuvoja, esimerkiksi sen suhteen kuinka monta taskia kannattaa olla kerrallaan työn alla, jotta ne tulevat valmiiksi definition of donen tarkkuudella.

## Yhteistyö ja kommunikaatio

Jokaisen sprintin alussa (asiakastapaamisen jälkeen) suoritimme yhdessä sprintin suunnittelukokouksen,jossa teimme sprintin backlogin sekä groomasimme product backlogia. Sprinttien aikana tämä tilaisuus oli ainoa, jossa tapasimme toisemme kasvotusten. Muutoin kommunikoimme Telegramissa.

Kommunikaatio onnistui sähköisesti riittävällä tasolla. Etenkin miniprojektin loppua kohden kommunikaatio parani ja pystyimme helpommin kyselemään apua toisiltamme ongelmakohdissa ja auttamaan toisiamme. Työnjako sujui hyvin - työt jakaantuivat tasaisesti kaikkien tiiminjäsenten kesken.

## Tekniset haasteet

Sprinttien aikana kohdatut haasteet liittyivät tuotantoympäristön konfiguraatioon. Gradle + Spring + Heroku yhdistelmä aiheutti harmaita hiuksia toisella viikolla, mutta asiasta selvittiin.

Tuotantoympäristön konffauksessa olisi ideaalitilanteessa voitu käyttää parikoodausta, jolloin eteneminen olisi ollut joutuisampaa. Parikoodaamisen järjestäminen kuitenkin oli mahdotonta tiimiläisten erilaisten aikataulujen vuoksi. Toinen konffaukseen liittynyt haaste oli Cucumber -testien implementointi tuotantoputkeen - tässä emme onnistuneet haluamallamme tavalla. Ongelmat liittyvät tällä kertaa siihen, kuinka JPARepositorya voitiin käyttää cucumber -testien aikana ilman että dataa tallentuu tietokantaan. Päädyimmekin tässä kohtaa ottamaan oikotien ja käyttämään stubia.

Osalle ryhmän jäsenistä spring oli uusi teknologia, niin vei hieman aikaa päästä kärryille, mistä on kysymys kun piti kertailla dokumentaatiota koodauksen lisäksi.

## Reflektioita Scrumiin

Scrumissa on tapana pitää daily standup tai vastaava aamupalaveri tiimin kesken. Vaikka noudatimmekin scrumia projektissa, niin ehkä tässä asiassa törmäsimme ScrumButtiin, sillä jokapäiväisen aamupalaverin pitäminen telegrammissa tuntui hieman turhalta. Etenkin kun olimme keskustelleet alustavasti aikatauluista sprint planningissa asiakastapaamisten jälkeen ja tiesimme suunnilleen milloin kukin aloittaa työstekentelyn.

User storyjen taskien estimointi suoritettiin keskustelemalla ja konsensus löytyi aika nopeasti. Suhteessa kurssimateriaaliin esimerkiksi planning poker olisi tuntunut turhan formaalilta tavalta ottaen huomioon kuinka luontevasti estimointi sujui näinkin. Useimmiten estimaatit pitivät kutinsa.

Sprinteille emme muistaneet määritellä tavoitetta, kuten kurssimateriaalin perusteella yleensä tehtäisiin.

## Opitut asiat

* Scrumin noudattaminen on teoriassa helppoa, käytännössä vaikeaa.
* WIP-rajoitukset helpottavat taskien valmiiksi saamista definition of donen tasolla.
