# BlackjackClient

Võimaldab ühendumist Blackjack serveriga, et mängida blackjacki.

Ühendumiseks valib suvalise vaba pordi.
connect-timeout=60000
read-timeout=20000
Client otsib teenust aadressilt: http://localhost:8080/
Serveriga suhtlemiseks kasutatakse Json vormingut.

Kasutaja saab siseneda vana kasutajaga või luua uue. Lisada oma kontole vahendeid ning mängida blackjacki. Vahendite puudumisel panuse tegemiseks palutakse kasutajala vahendeid juurde lisada.

PROBLEEMID.
Client töötab ainult siis kui ta käivitada tekstiredaktoris koodi pealt. Sattusin probleemi otsa, mille debugimiseks ei jäänud aega, mis takistas Jar faili kompileerimist.
