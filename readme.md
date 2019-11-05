# PUISSANCE 4


<h1>Description du jeu</h1>

Le jeu de plateau que je propose est un Puissance 4. <br/>

<p>Deux joueurs s'affrontent. Le but est d'aligner une suite de quatre jetons identiques. Chaque joueur dispose de 21 jetons.<br/>
Par convention, il y a 21 pions rouges et 21 pions jaunes. Le puissance 4 que j'ai codé en Java se joue dans la console. Par contrainte technique, je remplace les pions de couleur par "X" et "O".<br/>
Tour à tour, les 2 joueurs placent un jeton dans la colonne de leur choix. Le pion se place à la position la plus basse possible de la colonne choisie.<br/>
Le vainqueur est le joueur qui réalise le premier un alignement de 4 jetons, soit horizontal, soit vertical, soit en diagonale.<br/>
Si la grille est pleine et qu'il n'y pas d'alignement possible, la partie est nulle.</p>

<h1>Description de l'implémentation technique</h1>
<p>
* Méthode afficherPlateau : Pour afficher le plateau de jeu dans la console.<br/>
* Méthode afficherNom : Demande aux 2 joueurs de saisir leurs noms.<br/>
* Méthode saisieJeton : Pour que les joueurs choisissent dans quelle colonne ils veulent placer leur jeton. Vérification que le placement est possible.<br/>
* Méthode placerJeton : On affiche le plateau avec les jetons placés et on change de joueur.<br/>
* Méthode checkNull : Si le tableau est plein mais qu'il n'y a pas d'alignement, la partie est nulle. Personne ne gagne.<br/>
* Méthode victoireHorizontal : Pour contrôler s'il y a un alignement horizontal.<br/>
* Méthode victoireVertical : Pour contrôler s'il y a un alignement vertical.<br/>
* Méthode victoireDiagonalAv : Pour contrôler s'il y a un alignement en diagonal avant.<br/>
* Méthode victoireDiagonalAr : Pour contrôler s'il y a un alignement en diagonal arrière.<br/>
* Méthode rejouer : Pour choisir de rejouer ou non.<br/>
* Les méthodes sont appelées dans le Main. J'ajoute un random pour décider quel joueur commence la partie.</p>

<h1>Notice d'utilisation</h1>
<p>
* Le puissnace 4 se joue à 2.<br/>
* Il est demandé tour à tour aux 2 joueurs de saisir leurs noms.<br/>
* Un tirage au sort est effectué pour définir lequel des deux joueurs commence.<br/>
* Il est demandé tour à tour aux joueurs de saisir un chiffre entre 1 et 7 pour choisir dans quelle colonnes il veut placer son jeton.<br/>
* Si le joueur saisi autre chose qu'un entier entre 1 et 7, il lui ai demandé de rejouer.<br/>
* Le premier joueur qui aligne 4 jetons soit horizontalement, soit verticalement, soit en diagonale à gagné.<br/>
* Si aucun alignement n'est réalisé et que le plateau est plein, la partie est terminée ; c'est un match null.<br/>
* Il est proposé aux joueurx de faire une autre partie, ou pas.
</p>

<h1>Remerciements</h1>

<p>Un grand merci à Virgile qui m'a accompagné dans la réalisation de ce code que, grâce à lui, j'ai compris !</p>
