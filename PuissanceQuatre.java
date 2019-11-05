import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Sophie
 */

public class PuissanceQuatre {

    // Variables pour afficherNom
    static String nomJoueur;
    static String nomJ1;
    static String nomJ2;
    // Variables pour le plateau de jeu
    static int colonnes = 7;
    static int lignes = 6;
    // Variables pour afficher les jetons dans le plateau
    static int jeton;
    static int choix;
    // Le plateau de jeu est un tableau 2D
    static int[][] plateauJeu; 
    // Variables pour la partie de jeu
    static boolean partieNulle;
    static boolean tourJoueur;
    static boolean victoire;
    static boolean stop;
    // Scanner pour ppouvoir saisir des choix dans la console
    static Scanner sc = new Scanner(System.in);

    /**
     * Méthode pour afficher le plateau de jeu.
     */
    public static void afficherPlateau() {
        // Je commence par attribuer un "symbol" à afficher dans le plateau en fonction du joueur
        if (tourJoueur) {
            jeton = 1; // = O
        } else {
            jeton = 2; // = X
        }
        // Boucle pour l'affichage visuel du plateau de jeu
        for (int i = lignes - 1; i >= 0; i--) {
            System.out.print("| ");
            for (int j = 0; j < colonnes; j++) {
                if (plateauJeu[i][j] == 0) {
                    System.out.print("  ");
                } else if (plateauJeu[i][j] == 1) {
                    System.out.print("O ");
                } else if (plateauJeu[i][j] == 2) {
                    System.out.print("X ");
                }
            }
            System.out.print(" |");
            System.out.print("\n");
            System.out.println("------------------");
        }       
        System.out.println("  1 2 3 4 5 6 7 ");
        System.out.println();
    }
    /**
     * Méthode pour saisir les noms des joueurs.
     */
    public static void afficherNom() {

        System.out.println("Veuillez saisir le nom du premier joueur : ");
        nomJ1 = sc.nextLine();

        System.out.println("Veuillez saisir le nom du deuxième joueur : ");
        nomJ2 = sc.nextLine();
    }
    /**
     * Méthode pour le choix de placement des jetons dans le plateau.
     * @return le nombre saisie si l'entrée est conforme
     * @return "Saisie incorrect !" si l'entrée n'est pas conforme et demande de rejouer
     */ 
    public static int saisieJeton() {

        System.out.println(nomJoueur + " à vous de choisir un nombre entre 1 et 7 : ");
        if (tourJoueur) {
            nomJoueur = nomJ1;
        } else {
            nomJoueur = nomJ2;
        }
        // Pour vérifier que la saisie est conforme, toute saisie qui ne sera pas 1, 2, 3, 4, 5, 6, 7 sera rejetée
        try {
            choix = Integer.parseInt(sc.nextLine()) - 1;
        }catch(NumberFormatException e){
            choix = 7;
        }
            if (choix >= 0 && choix <= 6) {
                System.out.println(nomJoueur + " a joué."); // si la saisie est conforme, le nombre choisi s'affiche dans la console.
                return choix;
            } else {
                System.out.println(" ... !! Saisie incorrect !! Rejouez !! ..."); // demande de rejouer si la saisie n'est pas conforme
                return -1;
            }
        

    }
    /**
     * Méthode pour placer les jetons dans le plateau
     */
    public static void placerJeton() {
        // Défini quel jeton afficher en fonction du joueur
        if (tourJoueur) {
            jeton = 1;
            nomJoueur = nomJ1;
        } else {
            jeton = 2;
            nomJoueur = nomJ2;
        }

        int verif = saisieJeton();
        // Si le choix du  joueur est possible affiche son jeton à l'endroit définit
        if (verif != -1) {
            for (int i = 0; i < colonnes; i++) {
                if (plateauJeu[i][verif] == 0) {
                    plateauJeu[i][verif] = jeton;
                    tourJoueur = !tourJoueur;
                    break;
                } else if (plateauJeu[lignes - 1][verif] != 0) { // s'il n'y a plus de place dans la colonne, il faut réitérer le choix
                    System.out.println("\n\n ... !! Colonne pleine !! Rejouez !! ..."); // le placement du jeton n'est pas possible
                    break;
                }
            }
        }
        afficherPlateau(); // Pour afficher le plateau et on visualise le placement du jeton
    }
    /**
     * Méthode en cas de match nul
     * @return si plus personne ne peut gagner, la partie est nulle
     */
    public static boolean checkNull() {
        int verifnull = 0;
        for (int i = 0; i < colonnes; i++) {
            if (plateauJeu[lignes - 1][i] != 0) {
                verifnull++;
            }
        }
        if (verifnull == colonnes) {
            partieNulle = true;
            System.out.println(" ... !! Personne ne gagne !! Rejouez !! ...");
        }
        return partieNulle;

    }
    /**
     * Méthode pour vérifier s'il y a un alignement de 4 jetons à l'horizontal.
     */
    public static void victoireHorizontal() {

        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes - 4; j++) {
                if (plateauJeu[i][j] == plateauJeu[i][j + 1] && plateauJeu[i][j + 1] == plateauJeu[i][j + 2]
                        && plateauJeu[i][j + 2] == plateauJeu[i][j + 3] && plateauJeu[i][j] != 0) {
                    victoire = true;
                    System.out.println("... !! Victoire de " + nomJoueur + " !! Félicitations !! ..."); 
                }
            }
        }

    }
     /**
     * Méthode pour vérifier s'il y a un alignement de 4 jetons à la verticale.
     */
    public static void victoireVertical() {

        for (int i = 0; i < lignes - 3; i++) {
            for (int j = 0; j < colonnes; j++) {
                if (plateauJeu[i][j] == plateauJeu[i + 1][j] && plateauJeu[i + 1][j] == plateauJeu[i + 2][j]
                        && plateauJeu[i + 2][j] == plateauJeu[i + 3][j] && plateauJeu[i][j] != 0) {
                    victoire = true;
                    System.out.println("... !! Victoire de " + nomJoueur  + " !! Félicitations !! ...");
                }
            }
        }

    }
     /**
     * Méthode pour vérifier s'il y a un alignement de 4 jetons en diagonale du bas gauche au haut droit.
     */
    public static void victoireDiagonalAv() {

        for (int i = 0; i < lignes - 3; i++) {
            for (int j = 0; j < colonnes - 3; j++) {
                if (plateauJeu[i][j] == plateauJeu[i + 1][j + 1] && plateauJeu[i + 1][j + 1] == plateauJeu[i + 2][j + 2]
                        && plateauJeu[i + 2][j + 2] == plateauJeu[i + 3][j + 3] && plateauJeu[i][j] != 0) {
                    victoire = true;
                    System.out.println("... !! Victoire de " + nomJoueur + " !! Félicitations !! ...");
                }
            }
        }

    }
     /**
     * Méthode pour vérifier s'il y a un alignement de 4 jetons en diagonale du bas droit au haut gauche.
     */
    public static void victoireDiagonalAr() {

        for (int i = 0; i < lignes - 3; i++) {
            for (int j = colonnes - 1; j >= 3; j--) {
                if (plateauJeu[i][j] == plateauJeu[i + 1][j - 1] && plateauJeu[i + 1][j - 1] == plateauJeu[i + 2][j - 2]
                        && plateauJeu[i + 2][j - 2] == plateauJeu[i + 3][j - 3] && plateauJeu[i][j] != 0) {
                    victoire = true;

                    System.out.println("... !! Victoire de " + nomJoueur + " !! Félicitations !! ... ");
                }
            }
        }

    }
    /**
     * Méthode pour commencer une nouvelle partie ou non
     */
    public static void rejouer() {
        System.out.println("........ Voulez-vous rejouer ? ........");
        System.out.println("  Si oui, tappez 1 | Si non, tappez 2.");

        int nouvellePartie = 0;
        try {
            nouvellePartie = sc.nextInt();
        } catch (InputMismatchException ignored) {
        }
        if (nouvellePartie == 1) {
            System.out.println(" ... !! Nouvelle partie !! ... ");
        } else {
            stop = true;
        }

    }

    public static void main(String[] args) {

        
            afficherNom();
            System.out.println("Le joueur 1 est : " + nomJ1);
            System.out.println("Le joueur 2 est : " + nomJ2);
        do {
            plateauJeu = new int[lignes][colonnes];
            victoire = false;
            partieNulle = false;
            stop = false;
            // tirage au sort du joueur
            Random rd = new Random();
            tourJoueur = rd.nextBoolean();
            do {
                placerJeton();
                checkNull();
                victoireHorizontal();
                victoireVertical();
                victoireDiagonalAv();
                victoireDiagonalAr();
            } while (!victoire && !partieNulle);
            System.out.println(" ...... !! Fin de la partie !! ......");
            rejouer();
        } while (!stop);
    }

}