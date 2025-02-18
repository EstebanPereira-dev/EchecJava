import java.lang.reflect.Array;
import java.util.ArrayList;
public class Regles {



        // Vérifie si le roi est en échec
        public static boolean estEnEchec(int[] positionRoi, ArrayList[] COULEUR, String[][] plateau) {
            String pieceRoi = plateau[positionRoi[0]][positionRoi[1]];
            ArrayList<String> adversaire = new ArrayList<>();
           if (COULEUR[0].contains(pieceRoi)){
               adversaire = COULEUR[1];
           }
           else{
                adversaire = COULEUR[0];
           }

           for (int i = 0; i < plateau.length; i++) {
                for (int j = 0; j < plateau[i].length; j++) {
                    if (adversaire.contains(plateau[i][j])) {
                        int[] coordDepart = {i, j};
                        if (DeplacementsPionsSpecifiques.ValidationDeplacementPion(coordDepart, positionRoi, COULEUR, plateau[i][j], pieceRoi) ||
                                DeplacementsPionsSpecifiques.ValidationDeplacementFou(coordDepart, positionRoi, COULEUR, plateau[i][j], pieceRoi) ||
                                DeplacementsPionsSpecifiques.ValidationDeplacementTour(coordDepart, positionRoi, COULEUR, plateau[i][j], pieceRoi) ||
                                DeplacementsPionsSpecifiques.ValidationDeplacementCavalier(coordDepart, positionRoi, COULEUR, plateau[i][j], pieceRoi) ||
                                DeplacementsPionsSpecifiques.ValidationDeplacementReine(coordDepart, positionRoi, COULEUR, plateau[i][j], pieceRoi) ||
                                DeplacementsPionsSpecifiques.ValidationDeplacementRoi(coordDepart, positionRoi, COULEUR, plateau[i][j], pieceRoi)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        // Vérifie si le joueur est en échec et mat
        public static boolean estEnEchecEtMat(int[] positionRoi, ArrayList[] COULEUR, String[][] plateau) {
            if (!estEnEchec(positionRoi, COULEUR, plateau)) {
                return false;
            }
            ArrayList<String> joueur =new ArrayList<>();
            if (COULEUR[0].contains(plateau[positionRoi[0]][positionRoi[1]]))
                joueur = COULEUR[0];
            else
                joueur = COULEUR[1];


            for (int i = 0; i < plateau.length; i++) {
                for (int j = 0; j < plateau[i].length; j++) {
                    if (joueur.contains(plateau[i][j])) {
                        int[] coordDepart = {i, j};
                        for (int x = 0; x < plateau.length; x++) {
                            for (int y = 0; y < plateau[x].length; y++) {
                                int[] coordArrivee = {x, y};
                                if (DeplacementsPionsSpecifiques.ValidationDeplacementPion(coordDepart, coordArrivee, COULEUR, plateau[i][j], plateau[x][y]) ||
                                        DeplacementsPionsSpecifiques.ValidationDeplacementFou(coordDepart, coordArrivee, COULEUR, plateau[i][j], plateau[x][y]) ||
                                        DeplacementsPionsSpecifiques.ValidationDeplacementTour(coordDepart, coordArrivee, COULEUR, plateau[i][j], plateau[x][y]) ||
                                        DeplacementsPionsSpecifiques.ValidationDeplacementCavalier(coordDepart, coordArrivee, COULEUR, plateau[i][j], plateau[x][y]) ||
                                        DeplacementsPionsSpecifiques.ValidationDeplacementReine(coordDepart, coordArrivee, COULEUR, plateau[i][j], plateau[x][y]) ||
                                        DeplacementsPionsSpecifiques.ValidationDeplacementRoi(coordDepart, coordArrivee, COULEUR, plateau[i][j], plateau[x][y])) {
                                    // Simule le déplacement
                                    String tmp = plateau[x][y];
                                    plateau[x][y] = plateau[i][j];
                                    plateau[i][j] = "";

                                    boolean toujoursEchec = estEnEchec(positionRoi, COULEUR, plateau);

                                    // Revertir le déplacement
                                    plateau[i][j] = plateau[x][y];
                                    plateau[x][y] = tmp;

                                    if (!toujoursEchec) {
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return true;
        }

        // Vérifie si le joueur est en pat (aucun mouvement valide possible, mais pas en échec)
     /*   public static boolean estEnPat(ArrayList[] COULEUR, String[][] plateau) {
            ArrayList<String> joueur = COULEUR[0]; // Joueur à vérifier

            for (int i = 0; i < plateau.length; i++) {
                for (int j = 0; j < plateau[i].length; j++) {
                    if (joueur.contains(plateau[i][j])) {
                        int[] coordDepart = {i, j};
                        for (int x = 0; x < plateau.length; x++) {
                            for (int y = 0; y < plateau[x].length; y++) {
                                int[] coordArrivee = {x, y};
                                if (DeplacementsPionsSpecifiques.ValidationDeplacementPion(coordDepart, coordArrivee, COULEUR, plateau[i][j], plateau[x][y]) ||
                                        DeplacementsPionsSpecifiques.ValidationDeplacementFou(coordDepart, coordArrivee, COULEUR, plateau[i][j], plateau[x][y]) ||
                                        DeplacementsPionsSpecifiques.ValidationDeplacementTour(coordDepart, coordArrivee, COULEUR, plateau[i][j], plateau[x][y]) ||
                                        DeplacementsPionsSpecifiques.ValidationDeplacementCavalier(coordDepart, coordArrivee, COULEUR, plateau[i][j], plateau[x][y]) ||
                                        DeplacementsPionsSpecifiques.ValidationDeplacementReine(coordDepart, coordArrivee, COULEUR, plateau[i][j], plateau[x][y]) ||
                                        DeplacementsPionsSpecifiques.ValidationDeplacementRoi(coordDepart, coordArrivee, COULEUR, plateau[i][j], plateau[x][y])) {
                                    // Simule le déplacement
                                    String tmp = plateau[x][y];
                                    plateau[x][y] = plateau[i][j];
                                    plateau[i][j] = "";

                                    boolean toujoursEchec = estEnEchec(new int[]{x, y}, COULEUR, plateau);

                                    // Revertir le déplacement
                                    plateau[i][j] = plateau[x][y];
                                    plateau[x][y] = tmp;

                                    if (!toujoursEchec) {
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return true;
        }*/
    }

