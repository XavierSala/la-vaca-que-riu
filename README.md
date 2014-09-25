la-vaca-que-riu
===============

Un empresari d'un poble vol obrir una botiga de llet en una ciutat. Vol que el negoci tingui èxit i per això vol que la llet sigui fresca i natural. Però resulta que és una mica avar i per això en comptes de portar la llet cada dia ha decidit que portarà les vaques a la ciutat.

El problema és que no vol gastar gaire, no sigui que el negoci no funcioni bé. Per això quan ha fet comptes descobreix que només pot llogar un camió que pot portar una càrrega com a màxim (i només un sol cop)

L'objectiu serà triar les vaques que ha de portar en el camió de manera que es pugui fer el màxim de producció de llet amb un sol viatge.

Exemples
-----------

Tenim les següents vaques:

| Vaca   | Pes en Kg | Raça              | Color          | Producció de llet   |
|--------|-----------|-------------------|----------------|---------------------|
| Maria  | 360       | Holstein-Friesian | Blanca i negra | 40 litres           |
| Pepa   | 250       | Jersey            | Marró          | 35 litres           |
| Flor   | 400       | Simmental         | Blanca i marró | 43 litres           |
| Toñi   | 180       | Jersey            | Marró          | 28 litres           |
| Xita   |  50       | Guernsey          | Blanca         | 12 litres           |
| Blanca |  90       | Ayshire           | Blanca i marró | 13 litres           |

Càrrega del camió: 700 Kg

Resultat: Maria, Toñi, Xita i Blanca = 93 Litres


Altres exemples podríen ser: 

| Vaca   | Pes en Kg   | Raça              | Color          | Producció de llet    |
|----------|-----------|-------------------|----------------|----------------------|
| Pica     |   223     | Jersey            | Marró          | 34 litres            |
| Mica     |   243     | Holstein-Friesian | Blanca i negra | 28 litres            |
| Penta    |   100     | Simmental         | Blanca         | 45 litres            |
| Hexa     |   200     | Guernsey          | Blanca i marró | 31 litres            |
| Escallot |   200     | Holstein-Friesian | Negra          | 50 litres            |
| Tacada   |   155     | Jersey            | Marró clar     | 29 litres            |
| Bruna    |   300     | Jersey            | Marró          | 16 litres            |
| Neu      |   150     | Parda             | Marró clar     | 10 litres            |

Càrrega del camió: 1000 Kg

| Vaca   | Pes en Kg   | Raça              | Color          | Producció de llet    |
|--------|-------------|-------------------|----------------|----------------------|
| Guapa  |  340        | Jersey            | Marró          | 45 litres            |
| Bona   |  355        | Holstein-Friesian | Negra          | 50 litres            |
| Bonica |  223        | Jersey            | Marró clar     | 34 litres            |
| Fletxa |  243        | Simmental         | Marró i blanc  | 39 litres            |
| Patata |  130        | Guernsey          | Blanca         | 29 litres            |
| Dansa  |  240        | Guernsey          | Blanca         | 40 litres            |
| Conxi  |  260        | Simmental         | Marró          | 30 litres            |
| Perla  |  155        | Parda             | Marró clar     | 25 litres            |
| Mosca  |  302        | Holstein-Friesian | Blanca i negra | 52 litres            |
| Pepi   |  130        | Guernsey          | Marró          | 31 litres            |

Introducció
-----------------
El plantejament de l'exemple, que és molt senzill, es fa servir per mostrar com es fa per desenvolupar un programa amb orientació a objectes. La resolució del problema no és important
