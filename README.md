# Clinical Lab Totem System

* Il laboratorio analisi unico dell'azienda sanitaria è costituito da un **Hub**, che riceve tutte le consegne dei **Box** con i campioni da analizzare, e da un insieme di **Building** che ospitano i vari laboratori.

* I diversi building sono raggiungibili dall'Hub secondo specifici **percorsi** (ciascun Building si può trovare su un unico percorso)

* I Box consegnati all'Hub dai vari corrieri attraverso il **Totem** sono consegnati ai laboratori dei building mediante l'impiego di **Selfdriving Trains**, uno per ciascun percorso

![]{https://github.com/angelocroatti/clinical-lab-project-example/blob/main/imgs/hub-schema.svg}


* Ciascun treno può essere composto da un numero arbitrario di **Container**
    * Ciascun Container può ospitare un numero prefissato di Box

* Ogni container può essere di due tipi: "Standard" e "Refrigerato"
    * I container Standard possono ospitare i box che non richiedono refrigerazione, mentre quelli Refrigerati possono ospitare solo Box che richiedono esplicitamente una forma di refrigerazione

* Ogni Building può trattare in modo mutuamente esclusivo Box Standard o Box che richiedono Refrigerazione

* Il totem deve consentire al corriere di consegnare i propri Box, specificando per ciascun box consegnato: 
    * a quale percorso deve essere recapitato (a condizione che vi sia sul percorso almeno un building in grado di poter gestire quel tipo di box)
    * se si tratta di un box che richiede refrigerazione

* Deve infine essere prevista una Dashboard che si aggiorni automaticamente, mostrando lo stato di occupazione dei container dei treni e gli identificativi dei box in attesa di consegna
