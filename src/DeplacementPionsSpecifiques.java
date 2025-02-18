import java.util.ArrayList;

class DeplacementsPionsSpecifiques {
    public static boolean ValidationDeplacementPion(int[] coordDepart, int[] coordArrivee, ArrayList[] COULEUR, String piece, String pieceArrivee) {
        int dy = (coordDepart[0] - coordArrivee[0]);
        int dx = (coordArrivee[1] - coordDepart[1]);
        boolean valide=false;


        if ( dx == 0 &&dy == 2 && COULEUR[0].contains(piece) && coordDepart[0]==6 ){
            if (piece.equals(MéthodeEnToutGenre.PIONBLANC) && MéthodeEnToutGenre.plateau[coordArrivee[0]][coordArrivee[1]].trim().isEmpty())
                valide = cheminVide(coordDepart, coordArrivee, MéthodeEnToutGenre.plateau);
                else{
                    valide = false;
                }
        }
        else{
                valide=false;

        }
        if (dx == 0 && dy == -2 && COULEUR[1].contains(piece) && coordDepart[0]==1 ){
            if (piece.equals(MéthodeEnToutGenre.PIONNOIR) && MéthodeEnToutGenre.plateau[coordArrivee[0]][coordArrivee[1]].trim().isEmpty()) {
                valide = cheminVide(coordDepart, coordArrivee, MéthodeEnToutGenre.plateau);
            }
            else{
                valide=false;
            }
        }
        else if (dx == 0 && dy == 1) {
            if (piece.equals(MéthodeEnToutGenre.PIONBLANC) && MéthodeEnToutGenre.plateau[coordArrivee[0]][coordArrivee[1]].trim().isEmpty()) {
                valide = true ;
            }
            else{
                valide=false;
            }

        } else if (dx == 0 && dy == -1) {
            if (piece.equals(MéthodeEnToutGenre.PIONNOIR) && MéthodeEnToutGenre.plateau[coordArrivee[0]][coordArrivee[1]].trim().isEmpty()) {
                valide = true ;
            }
            else {
                valide= false;
            }

        }
        if ((Math.abs(dx) == 1 && dy == 1 && piece.equals(MéthodeEnToutGenre.PIONBLANC) && !MéthodeEnToutGenre.plateau[coordArrivee[0]][coordArrivee[1]].trim().isEmpty() && COULEUR[1].contains(pieceArrivee)) ||
                (Math.abs(dx) == 1 && dy == -1 && piece.equals(MéthodeEnToutGenre.PIONNOIR) && !MéthodeEnToutGenre.plateau[coordArrivee[0]][coordArrivee[1]].trim().isEmpty() && COULEUR[0].contains(pieceArrivee))) {
            valide = true;
        }
        return valide; // Si aucune condition validé, mouvement invalide
    }
    // Deplacement du fou via la valeur absolue
    public static boolean ValidationDeplacementFou(int[] coordDepart, int[] coordArrivee, ArrayList[] COULEUR, String piece,String pieceArrivee) {
        int dx = Math.abs(coordArrivee[0] - coordDepart[0]);
        int dy = Math.abs(coordArrivee[1] - coordDepart[1]);
        boolean valide;

        if (dx != dy) {
            valide = false;
        }
        else {
            if(VerificationCouleur(piece,pieceArrivee,coordArrivee,COULEUR)){
                valide = cheminVide(coordDepart, coordArrivee, MéthodeEnToutGenre.plateau);
            }
            else{
                valide = false;
            }
        }


        return valide;
    }
    public static boolean ValidationDeplacementReine(int[] coordDepart, int[] coordArrivee, ArrayList[] COULEUR, String piece,String pieceArrivee){
        boolean valide;
        int dy = Math.abs(coordArrivee[0] - coordDepart[0]);
        int dx = Math.abs(coordArrivee[1] - coordDepart[1]);

        if (dx == dy || (dx==0 ^ dy==0)) {
            if(VerificationCouleur(piece,pieceArrivee,coordArrivee,COULEUR)){
                valide = cheminVide(coordDepart, coordArrivee, MéthodeEnToutGenre.plateau);
            }
            else{
                valide = false;
            }
        }
        else{
            valide = false;        }
        return valide;
    }

    // Validation du déplacement de la tour
    public static boolean ValidationDeplacementTour(int[] coordDepart, int[] coordArrivee, ArrayList[] COULEUR, String piece, String pieceArrivee) {
        int dx = Math.abs(coordArrivee[0] - coordDepart[0]);
        int dy = Math.abs(coordArrivee[1] - coordDepart[1]);
        boolean valide;

        if ((dx == 0 && dy != 0) || (dx !=0 && dy==0)) {
            if(VerificationCouleur(piece,pieceArrivee,coordArrivee,COULEUR)){
                valide = cheminVide(coordDepart, coordArrivee, MéthodeEnToutGenre.plateau);
            }
            else{
                valide = false;
            }
        } else {
            valide = false;  // La tour ne peut pas se déplacer en diagonale

        }

        return valide;


        // A FAIRE : Vérification du chemin libre (pas de pièce entre la position de départ et la position d'arrivée)
    }
    public static boolean ValidationDeplacementCavalier(int [] coordDepart, int[] coordArrivee, ArrayList[] COULEUR, String piece, String pieceArrivee){
        boolean valide= false;
        int dx = Math.abs(coordArrivee[0] - coordDepart[0]);
        int dy = Math.abs(coordArrivee[1] - coordDepart[1]);
        if ((dx == 2 && dy == 1) || (dx == 1 && dy == 2)){
            valide = (VerificationCouleur(piece,pieceArrivee,coordArrivee,COULEUR));
        }
        return valide;
        // Au lieu de verifier tt les cas possibles (avec [0]<0 pour se deplacer a gauche et [1]<0 pour se deplacer vers le bas,
        // on travaillle avec les valeur absolues car on cherche juste à imposer le mouvemet en L
    }
    public static boolean ValidationDeplacementRoi(int[] coordDepart, int[] coordArrivee, ArrayList[] COULEUR, String piece, String pieceArrivee){
        int dx = Math.abs(coordArrivee[0] - coordDepart[0]);
        int dy = Math.abs(coordArrivee[1] - coordDepart[1]);
        boolean valide;
        if ((dx==1 && dy ==1)||(dx==1 && dy==0) || (dx==0 && dy ==1)){
            valide = (VerificationCouleur(piece,pieceArrivee,coordArrivee,COULEUR));        }
        else {
            valide= false;
        }
        return valide;
    }
    public static boolean VerificationCouleur(String piece,String pieceArrivee, int[]CoordArrivee,ArrayList[] couleur){
        boolean valide;
        if (couleur[0].contains(piece)){
            if(couleur[0].contains(pieceArrivee)){
                valide=false;
            }
            else{
                valide=true;
            }

            }
        else {
            if (couleur[1].contains(pieceArrivee)){
                valide=false;
            }
            else {
                valide=true;
            }
        }
        return valide;

    }
    public static boolean cheminVide(int[] coordDepart, int[] coordArrivee, String[][] plateau) {
        int dx = Integer.signum(coordArrivee[0] - coordDepart[0]); // on obtient 1 ou -1 donc on a la direction de la piece
        int dy = Integer.signum(coordArrivee[1] - coordDepart[1]);; // de meme

        int x = coordDepart[0] + dx;
        int y = coordDepart[1] + dy;

        // Parcours des cases jusqu'à arriver à la case d'arrivée (sans l'inclure)
        while (x != coordArrivee[0] || y != coordArrivee[1] ) {  //on parcourt toutes les cases du trajet jusqu'a coord arrivée
            if (!plateau[x][y].trim().isEmpty()) {          // si la case n'est pas videon return false
                return false;
            }
            x += dx;            //on passe aux cases suivantes
            y += dy;
        }
        return true; // n'arrive que si on a pas renvoyé le false au préalable
    }
}
