**Raportti**
Vertaispalautteen lisäksi ryhmä laatii projektin kulusta pienen raportin (noin 2 sivua)

- kerrataan jokaisen sprintin aikana kohdatut ongelmat (prosessiin-, projektityöskentelyyn- ja teknisiin asioihin liittyvät)
- mikä sujui projektissa hyvin, mitä pitäisi parantaa seuraavaa kertaa varten
- mitä asioita opitte, mitä asioita olisitte halunneet oppia, mikä tuntui turhalta
- jos raportti puuttuu, vähennetään ryhmältä 2 pistettä
- raportti palautetaan lisäämällä raporttiin linkki projektin GitHubin Readme:hen
- raportista tulee ilmetä jokaisen projektiin osallistuneen nimi
- raportin deadline lauantaina 21.12. klo 23:59

Tiimi muodostettiin aloitustapaamisessa, eli emme tunteneet toisiamme ennestään. Ryhmässämme kaikki sprintit sujuivat samalla kaavalla. Asiakas oli aina tyytyväinen näkemäänsä. Hän antoi meille muutamia hyviä neuvoja, esimerkiksi sen suhteen kuinka monta taskia kannattaa olla kerrallaan työnalla, jotta ne tulevat valmiiksi defionition of donen tarkkuudella. 

Jokaisen sprintin alussa (asiakastapaamisen jälkeen) suoritimme yhdessä sprintin suunnittelukokouksen,jossa teimme sprintin backlogin sekä groomasimme product backlogia. Sprinttien aikana tämä tilaisuus oli ainoa, jossa tapasimme toisemme kasvotusten. Muutoin
kommunikoimme Telegramissa. Kommunikaatio onnistui sähköisesti riittävällä tasolla. Työnjako sujui hyvin - työt jakaantuivat tasaisesti kaikkien tiiminjäsenten kesken. 

Sprinttien aikana kohdatut haasteet liittyivät tuotantoympäristön konfiguraatioon. Gradle + Spring + Heroku yhdistelmä aiheutti harmaita hiuksia toisella viikolla, mutta asiasta selvittiin. Tuotantoympäristön konffauksessa olisi ideaalitilanteessa voitu käyttää parikoodausta, jolloin eteneminen olisi ollut joutuisampaa. Parikoodaamisen järjestäminen kuitekin oli mahdotonta tiimiläisten erilaisten aikataulujen vuoksi. Toinen konffaukseen liittynyt haaste oli Cucumber -testien implementointi tuotantoputkeen - tässä emme onnistuneet haluamallamme tavalla. Ongelmat liittyvät tällä kertaa siihen, kuinka JPARepositorya voitiin käyttää cucumber -testien aikana ilman että dataa tallentuu tietokantaan. Päädyimmekin tässä kohtaa ottamaan oikotien ja käyttämään stubia.
