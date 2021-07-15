Ce dépôt contient 3 Prototypes servant à illustrer plusieurs niveaux de reproductibilité d'une expérience.
L'expérience de base étant la suivant : 

On prend un jeu de données en entrée sous forme de fichier texte, on produit des données intermédiaires et en guise de résultat final,
un graphique (.png) sur ces données.

Etapes de l’expérience:

- On passe au programme java un fichier « inputs.txt » de 100 flottants.

- On les traites (ce qui produit un entier pour chaque flottant).

- On y ajoute aléatoirement 100 nouveaux entiers et produit un fichier « outputs_n.txt » de 200 entiers.

- Ce protocole est répété n fois par un autre programme java. (outputs_1.txt, outputs_2.txt, outputs_n.txt)

- Ces fichiers sont passés en entrée d’un programme python qui s’occupe de traiter graphiquement ces données sous formes de boites à moustaches.

REMARQUE: A noter que seul le prototype 1 réalise l'expérimentation au complet. L'importance étant accordée à la politique de production de données plus qu'à leur traitement. Dans les prototypes 2 et 3 on ne comprend pas le traitement mathématique (moyenne) et graphique (python) ainsi que la containerisation.

*Le prototype V1 s'appuie sur la consommation de données fixées dans un fichier ("inputs.txt"), illustrant l'utilisation de "Petites Données statiques" cf. Diagramme du workflow.
L'expérience du prototype V1 est automatisée grâce à la containerisation (image Docker) spécifiée dans le fichier Dockerfile. Un script sh sert à l'automatisation des manipulations.

*Le prototype V2 illustre la production de données threaded synchrone. Une file est représentée par la classe DataQueue.java qui possède des méthodes de manipulations sur la file. Un producteur de donnée DataProducer.java ajoute des données à la file (Possibilité de fixé la seed de génération).

*Le prototype V3 versionNormale_1LVL comporte un producteur RealProd.java qui lis un fichier "inputs.txt" et appelle la methode calculate() du consommateur RealConso.java qui convertit les flottant fournis par le producteur en entier et les écrits dans un fichier de sortie "outputsNormal.txt". La production et la consommation est synchrone

*Le prototype V3 versionBuffered_2LVL comporte :
- une classe Buffer.java qui représente un buffer/file.
- une classe RealProd.java représentant le Producteur de données.
- une classe RealConcurrentConso qui sers d'intermédiaire entre le producteur et le buffer (agissant comme un consommateur dans son fonctionnement) en ajoutant ce que donne le producteur dans le buffer permettant de ne pas bloquer inutilement le buffer.
- une classe RealConcurrentProd qui sers d'intermédiaire entre le buffer et le consommateur (agissant comme un producteur dans son fonctionnement) en récupérant la tête de file du buffer et en le donnant au consommateur permettant de ne pas bloquer inutilement le buffer.
- une classe RealConso.java représentant le Consommateur de données.
- une classe Arbiter qui sert à orchestrer le fonctionnement des threads.

La production de données et sa consommation se veut ici infinie et asynchrone grâce au mécanisme de bufferisation des données. Toutefois pour permettre d'observer les résultats du fonctionnement des threads, l'arbitre est programmé pour arrêter l'expérience après 2 secondes d'exécution. Un fichier texte permet de garder en mémoire la production de l'exécution.

*Le prototype V3 versionBuffered_3LVL possède un fonctionnement similaire à l'exception l'absence d'arbitre et de quelques modifications dans la classe RealConcurrentProd. Le but ici est de spécifier une taille d'échantillon en conservant le fonctionnement asynchrone des threads et les arrêter lorsque l'échantillon est complet. Un fichier texte permet de garder en mémoire l'échantillon.
