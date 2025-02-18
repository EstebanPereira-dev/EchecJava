import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MéthodeEnToutGenre {

    // Déclaration des constantes
    // Plateau
    private static final String RESET = "\u001B[0m";
    public static String CASEBLANCHE = "\u001B[47m";
    public static String CASENOIRE = "\u001B[40m";
    // Pièces Blanches
    public static String TOURNOIRE = "♖";
    public static String CAVALIERNOIRE = "♘";
    public static String FOUNOIR = "♗";
    public static String REINENOIRE = "♕";
    public static String ROINOIR = "♔";
    public static String PIONNOIR = "♙";
    // Pièces Noires
    public static String TOURBLANCHE = "♜";
    public static String CAVALIERBLANC = "♞";
    public static String FOUBLANC = "♝";
    public static String REINEBLANCHE = "♛";
    public static String ROIBLANC = "♚";
    public static String PIONBLANC = "♟";
    // Liste Couleur
    public static ArrayList<String> BLANC = new ArrayList<>(Arrays.asList(TOURBLANCHE,CAVALIERBLANC,FOUBLANC, REINEBLANCHE, ROIBLANC, PIONBLANC));
    public static ArrayList<String> NOIR = new ArrayList<>(Arrays.asList(TOURNOIRE, CAVALIERNOIRE, FOUNOIR, REINENOIRE, ROINOIR, PIONNOIR));
    public static ArrayList[] COULEUR = {BLANC, NOIR};
    static Scanner sc = new Scanner(System.in);
    public static String[][] plateau = {
            {" "+ TOURNOIRE +" "," "+ CAVALIERNOIRE +" "," "+ FOUNOIR +" "," "+ REINENOIRE +" "," "+ ROINOIR +" "," "+ FOUNOIR +" "," "+ CAVALIERNOIRE +" "," "+ TOURNOIRE +" "},
            {" " + PIONNOIR + " ", " " + PIONNOIR + " ", " " + PIONNOIR + " ", " " + PIONNOIR + " ", " " + PIONNOIR + " ", " " + PIONNOIR + " ", " " + PIONNOIR + " ", " " + PIONNOIR + " "},
            {"   ", "   ", "   ", "   ", "   ", "   ", "   ", "   "},
            {"   ", "   ", "   ", "   ", "   ", "   ", "   ", "   "},
            {"   ", "   ", "   ", "   ", "   ", "   ", "   ", "   "},
            {"   ", "   ", "   ", "   ", "   ", "   ", "   ", "   "},
            {" " + PIONBLANC + " ", " " + PIONBLANC + " ", " " + PIONBLANC + " ", " " + PIONBLANC + " ", " " + PIONBLANC + " ", " " + PIONBLANC + " ", " " + PIONBLANC + " ", " " + PIONBLANC + " "},
            {" " + TOURBLANCHE + " ", " " + CAVALIERBLANC + " ", " " + FOUBLANC + " ", " " + REINEBLANCHE + " ", " " + ROIBLANC + " ", " " + FOUBLANC + " ", " " + CAVALIERBLANC + " ", " " + TOURBLANCHE + " "}
    };

    // Méthode pour afficher le plateau
    public static void afficherPlateau() {
        System.out.println("   A  B  C  D  E  F  G  H");
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print(CASEBLANCHE + plateau[i][j] + RESET);
                } else {
                    System.out.print(CASENOIRE + plateau[i][j] + RESET);
                }
            }
            System.out.print(" " + (8 - i));
            System.out.println();
        }
        System.out.println("   A  B  C  D  E  F  G  H");
    }

    // Méthode pour récupérer les coordonnées (version de l'utilisateur)
    public static char[] RecupCoordonnees (){
        String coordsDepart ="Z9";
        String coordsArrivee ="Z9";
        // ArrayList<String> listeHistorique = new ArrayList<>();
        do {
            System.out.println("Veuillez rentrez les coordonnées de la piece que vous souhaitez déplacer [A-H][1-8] : ");
            coordsDepart = sc.next();
            coordsDepart = coordsDepart.toUpperCase();
        } while (coordsDepart.length() != 2 || (coordsDepart.charAt(0) > 'H' || coordsDepart.charAt(0) < 'A') || coordsDepart.charAt(1) > '8' || coordsDepart.charAt(1) < '0');
        do {
            System.out.println("Veuillez rentrez les coordonnées d'arrivée [A-H][1-8] : ");
            coordsArrivee = sc.next();
            coordsArrivee = coordsArrivee.toUpperCase();
        } while (coordsArrivee.length() != 2 || (coordsDepart.charAt(0) > 'H' || coordsDepart.charAt(0) < 'A') || coordsDepart.charAt(1) > '8' || coordsDepart.charAt(1) < '0');

        // listeHistorique.add(coordsArrivee);
        char lettreD = coordsDepart.charAt(0);
        char chiffreD = coordsDepart.charAt(1);
        char lettreA = coordsArrivee.charAt(0);
        char chiffreA = coordsArrivee.charAt(1);
        return new char[]{lettreD,chiffreD,lettreA,chiffreA};
    }

    // Méthode pour convertir les coordonnées
    public static int[] ConversionCoordonnees(char[] coords) {
        char colonneD = coords[0];  // Colonne départ
        char ligneD = coords[1];    // Ligne départ
        char colonneA = coords[2];  // Colonne arrivée
        char ligneA = coords[3];    // Ligne arrivée

        int yD = 8 - Character.getNumericValue(ligneD);
        int xD = colonneD - 'A';
        int yA = 8 - Character.getNumericValue(ligneA);
        int xA = colonneA - 'A';

        return new int[]{yD, xD, yA, xA};
    }

    // Méthode pour déplacer une pièce
    public static boolean deplacerPiece(int[] coordonnees, int compteur) {
        int[] caseDepart = {coordonnees[0], coordonnees[1]};
        int[] caseArrivee = {coordonnees[2], coordonnees[3]};
        boolean valide = true;
        String piece = plateau[caseDepart[0]][caseDepart[1]].trim();
        String pieceArrivee = plateau[caseArrivee[0]][caseArrivee[1]].trim();
        String couleurActuelle;
        if (compteur % 2 == 0) {
            couleurActuelle = "BLANC";
        }
        else {
            couleurActuelle = "NOIR";
        }
        int[] positionRoi = trouverCoordonneesRoi(couleurActuelle);


        if (piece.isEmpty()) {
            System.out.println("Aucune pièce à cet endroit !");
            return false;
        }

        // Validation pour le pion
        if ((piece.equals(PIONBLANC) || piece.equals(PIONNOIR)) && !DeplacementsPionsSpecifiques.ValidationDeplacementPion(caseDepart, caseArrivee, COULEUR, piece,pieceArrivee)) {
            System.out.println("Mouvement invalide pour le Pion !");
            valide = false;
        }
        // Validation pour la tour
        if ((piece.equals(TOURBLANCHE) || piece.equals(TOURNOIRE)) && !DeplacementsPionsSpecifiques.ValidationDeplacementTour(caseDepart,caseArrivee,COULEUR,piece,pieceArrivee)) {
            System.out.println("Mouvement invalide pour la Tour !");
            valide = false;
        }

        // Validation pour le fou
        if ((piece.equals(FOUBLANC) || piece.equals(FOUNOIR)) && !DeplacementsPionsSpecifiques.ValidationDeplacementFou(caseDepart, caseArrivee, COULEUR,piece,pieceArrivee)) {
            System.out.println("Mouvement invalide pour le Fou !");
            valide = false;
        }

        // Validation pour le cavalier
        if ((piece.equals(CAVALIERBLANC) || piece.equals(CAVALIERNOIRE)) && !DeplacementsPionsSpecifiques.ValidationDeplacementCavalier(caseDepart, caseArrivee,COULEUR, piece,pieceArrivee)) {
            System.out.println("Mouvement invalide pour le Cavalier !");
            valide = false;
        }

        if ((piece.equals(ROIBLANC) || piece.equals(ROINOIR)) && !DeplacementsPionsSpecifiques.ValidationDeplacementRoi(caseDepart, caseArrivee,COULEUR,piece,pieceArrivee)) {
            System.out.println("Mouvement invalide pour le Roi !");
            valide = false;
        }
        if ((piece.equals(REINEBLANCHE) || piece.equals(REINENOIRE)) && !DeplacementsPionsSpecifiques.ValidationDeplacementReine(caseDepart, caseArrivee,COULEUR,piece,pieceArrivee)) {
            System.out.println("Mouvement invalide pour la Reine !");
            valide = false;
        }
        // Empêcher la capture du roi
        if ((caseArrivee[0] == positionRoi[0] && caseArrivee[1] == positionRoi[1])) {
            System.out.println("Impossible de capturer le Roi !");
            valide = false;
        }

        if (compteur % 2 == 0 && !COULEUR[0].contains(piece)){
            valide=false;
        }
        else if (compteur % 2 != 0 && !COULEUR[1].contains(piece)){
            valide=false;
        }

        // Vérification si le mouvement met notre propre roi en échec
        //pour ça, on effectue le mouvement dans une copie de plateau pour verifier si le roi est en echec apres le mouvement, sans changer le plateau de base
        if (valide) {
            String[][] plateauTemporaire = copierPlateau(plateau);
            plateauTemporaire[caseDepart[0]][caseDepart[1]] = "   ";
            plateauTemporaire[caseArrivee[0]][caseArrivee[1]] = " " + piece + " ";
            if (Regles.estEnEchec(positionRoi, COULEUR, plateauTemporaire)) {
                System.out.println("Ce mouvement met votre roi en échec !");
                valide = false;
            }
        }

        // Déplacement de la pièce si valide
        if (valide) {
            plateau[caseDepart[0]][caseDepart[1]] = "   ";
            plateau[caseArrivee[0]][caseArrivee[1]] = (" " +piece+" ");

        }

        // Vérifier les conditions d'échec, échec et mat, ou pat après le déplacement
        if (Regles.estEnEchec(positionRoi, COULEUR, plateau)) {
            System.out.println("Votre roi est en échec !");
        }
        /*if (Regles.estEchecEtMat(couleurActuelle, plateau)) {
            System.out.println("Échec et mat ! Fin de la partie.");
            partie
        }
        if (Regles.estPat(couleurActuelle, plateau)) {
            System.out.println("Pat ! Partie nulle.");
        }*/

        return valide;
    }


    // Méthode pour démarrer la partie

    public static void miseEnRoute(String pseudo1, String pseudo2) {
        boolean partie = true;
        int compteur = 0;
        afficherPlateau();
        String couleurActuelle;
        String joueurActuel;
        while (partie) {

            if (compteur % 2 == 0) {
                 couleurActuelle = "BLANC";
                 joueurActuel = pseudo1;
            }
            else {
                couleurActuelle = "NOIR";
                joueurActuel = pseudo2;

            }
            int[] positionRoi = trouverCoordonneesRoi(couleurActuelle);

            System.out.println("Joueur [" + joueurActuel + "] (" + couleurActuelle + "), à vous de jouer.");

            // Trouver les coordonnées du roi actuel
            int[] coordRoiActuel = trouverCoordonneesRoi(couleurActuelle);

            // Vérification des conditions d'échec
            if (Regles.estEnEchec(coordRoiActuel, COULEUR, plateau)) {
                System.out.println("Le Roi " + couleurActuelle + " est en échec !");

                if (Regles.estEnEchecEtMat(coordRoiActuel, COULEUR, plateau)) {
                    System.out.println("Échec et mat ! Le joueur [" + joueurActuel + "] a perdu.");
                    partie = false;
                    break;
                }
            }
            if (Regles.estEnEchecEtMat(positionRoi ,COULEUR, plateau)) {
                System.out.println("Échec et mat ! Fin de la partie.");
                partie= false;
            }
        /*    if (Regles.estEnPat(couleurActuelle, plateau)) {
                System.out.println("Pat ! Partie nulle.");
                partie = false;
            }*/

             /* if (Regles.estEnPat(COULEUR, plateau)) {
                System.out.println("Pat ! La partie se termine par une égalité.");
                partie = false;
                break;
            }
            */
            // Récupérer et convertir les coordonnées pour déplacer une pièce
            int[] conversion = ConversionCoordonnees(RecupCoordonnees());

            // Effectuer le déplacement de la pièce
            if (deplacerPiece(conversion, compteur)) {
                afficherPlateau();
                System.out.println("Déplacement effectué !");
                compteur++;
            } else {
                afficherPlateau();
                System.out.println("Déplacement non valide, veuillez réessayer.");
            }
        }
    }
    public static int[] trouverCoordonneesRoi(String couleur) {
        boolean trouve = false;
        int[] positionRoi =new int[2];
        for (int i = 0; i < plateau.length && !trouve; i++) {
            for (int j = 0; j < plateau[i].length && !trouve; j++) {
                String piece = plateau[i][j];
                if ((couleur.equals("BLANC") && piece.equals(MéthodeEnToutGenre.ROIBLANC)) || (couleur.equals("NOIR") && piece.equals(MéthodeEnToutGenre.ROINOIR))) {
                    positionRoi[0] = i;
                    positionRoi[1] = j;
                }
            }
        }
        return positionRoi;
    }
    public static String[][] copierPlateau(String[][] plateauOriginal) {
        // Crée un nouveau plateau de même taille que l'original
        String[][] plateauCopie = new String[plateauOriginal.length][plateauOriginal[0].length];

        // Copie chaque case du plateau original dans le plateau copié
        for (int i = 0; i < plateauOriginal.length; i++) {
            for (int j = 0; j < plateauOriginal[i].length; j++) {
                plateauCopie[i][j] = plateauOriginal[i][j];
            }
        }

        return plateauCopie;
    }



}
