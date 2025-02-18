import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.*;


public class DeplacementPionsSpecifiquesTest {
// Ici, on ne verifie pas si la piece peut prendre une piece ennemie ou ne peut pas se deplacer si une piece alliée se trouve à l'arrivée car cette verification se fait dans methods en tout genre.
// On verifie seulement la validité du mouvement, et si le cheminVide foncionne pour les differentes pieces

        //On crée un tableau ici pour eviter de le recreer dans chaque test different
        String[][] plateau = new String[8][8];
        ArrayList<String> BLANC = new ArrayList<>(Arrays.asList("PIONBLANC", "TOURBLANCHE", "FOUBLANC", "REINEBLANCHE", "ROIBLANC", "CAVALIERBLANC"));
        ArrayList<String> NOIR = new ArrayList<>(Arrays.asList("PIONNOIR", "TOURNOIRE", "FOUNOIR", "REINENOIRE", "ROINOIR", "CAVALIERNOR"));

       @Test
       public void testValidationDeplacementFou() {
          // cas deplacement fou diagonale droite avant
            plateau[3][1] = "FOUBLANC"; // On definit un fou blanc dans la case c1
            plateau[4][2] = "";// la case en diagonale droite est vide (d2)
            plateau[5][3] = ""; // Case destination e3 est vide

            ArrayList[] couleurs = new ArrayList[]{BLANC, NOIR};
            int[] coordDepart = {3,1};
            int[] coordArrivee = {5,3};
            boolean resultat = DeplacementsPionsSpecifiques.ValidationDeplacementFou(coordDepart, coordArrivee, couleurs, "FOUBLANC", "");
            assertTrue("Le fou blanc doit pouvoir avancer en diagonale si rien n'entrave son chemin.", resultat);

           // cas deplacement fou diagonale gauche arrière
           plateau[4][4] = "FOUBLANC"; // On definit un fou blanc dans la case d4
           plateau[3][3] = "";// la case en diagonale droite est vide (c3)
           plateau[2][2] = ""; // Case destination b2 est vide

           int[] coordDepart2 = {3,1};
           int[] coordArrivee2 = {5,3};
           boolean resultat2 = DeplacementsPionsSpecifiques.ValidationDeplacementFou(coordDepart2, coordArrivee2, couleurs, "FOUBLANC", "");
           assertTrue("Le fou blanc doit pouvoir avancer en diagonale si rien n'entrave son chemin.", resultat2);

           //cas deplacement fou noir
           // cas deplacement fou diagonale droite haut
           plateau[3][1] = "FOUNOIR"; // On definit un fou noir dans la case c1
           plateau[4][2] = "";// la case en diagonale droite est vide (d2)
           plateau[5][3] = ""; // Case destination e3 est vide

           int[] coordDepart3 = {3,1};
           int[] coordArrivee3 = {5,3};
           boolean resultat3 = DeplacementsPionsSpecifiques.ValidationDeplacementFou(coordDepart3, coordArrivee3, couleurs, "FOUBLANC", "");
           assertTrue("Le fou noir doit pouvoir avancer en diagonale droite haut si rien n'entrave son chemin.", resultat3);

           // cas mouvement non diagonal
           plateau[3][1] = "FOUNOIR"; // On definit un fou noir dans la case c1
           plateau[3][3] = ""; // Case destination c3 est vide

           int[] coordDepart4 = {3,1};
           int[] coordArrivee4 = {3,3};
           boolean resultat4 = DeplacementsPionsSpecifiques.ValidationDeplacementFou(coordDepart4, coordArrivee4, couleurs, "FOUNOIR", "");
           assertFalse("Le fou doit se deplacer en diagonale.", resultat4);
       }


    @Test
    public void testValidationDeplacementCavalier() {
           // cas où le cavalier va sur une case vide mais avec un pion sur son chemin (deplacement en haut aà droite)
        plateau[2][1] = "CAVALIERBLANC"; // On definit un cavalier blanc dans la case b1
        plateau[2][2] = "PIONBLANC";// la case devant lui n'est pas vide
        plateau[3][3] = ""; // Case destination C3 est vide

        ArrayList[] couleurs = new ArrayList[]{BLANC, NOIR};
        int[] coordDepart = {2,1};
        int[] coordArrivee = {3,3};
        boolean resultat = DeplacementsPionsSpecifiques.ValidationDeplacementCavalier(coordDepart, coordArrivee, couleurs, "CAVALIERBLANC", "");
        assertTrue("Le cavalier doit pouvoir atteidre une case vide meme si il y a une piece sur son chemin.", resultat);

        // cas où le cavalier se deplace enbas à gauche)
        plateau[4][4] = "CAVALIERBLANC"; // On definit un cavalier blanc dans la case d4
        plateau[3][2] = ""; // Case destination C2 est vide

        int[] coordDepart2 = {4,4};
        int[] coordArrivee2 = {3,2};
        boolean resultat2 = DeplacementsPionsSpecifiques.ValidationDeplacementCavalier(coordDepart2, coordArrivee2, couleurs, "CAVALIERBLANC", "");
        assertTrue("Le cavalier doit pouvoir atteindre une case en bas a gauche de lui en L.", resultat2);

        //cas deplacement impossible
        plateau[4][4] = "CAVALIERBLANC"; // On definit un cavalier blanc dans la case d4
        plateau[4][5] = ""; // Case destination d5 est vide

        int[] coordDepart3 = {4,4};
        int[] coordArrivee3 = {4,5};
        boolean resultat3 = DeplacementsPionsSpecifiques.ValidationDeplacementCavalier(coordDepart3, coordArrivee3, couleurs, "CAVALIERBLANC", "");
        assertFalse("Le cavalier blanc nepeut pas se deplacer d'une case", resultat3);


        //test cavalier noir
        plateau[2][1] = "CAVALIERNOIR"; // On definit un cavalier noir dans la case b1
        plateau[2][2] = "PIONBLANC";// la case devant lui n'est pas vide
        plateau[3][3] = ""; // Case destination C3 est vide

        int[] coordDepart4 = {2,1};
        int[] coordArrivee4 = {3,3};
        boolean resultat4 = DeplacementsPionsSpecifiques.ValidationDeplacementCavalier(coordDepart4, coordArrivee4, couleurs, "CAVALIERBLANC", "");
        assertTrue("Le cavalier doit pouvoir atteidre une case vide meme si il y a une piece sur son chemin.", resultat4);
    }

    @Test
    public void testValidationDeplacementRoi() {
        // cas où le deplacement roi blanc case vide
        plateau[2][1] = "ROIBLANC"; // On definit un roi blanc dans la case b1
        plateau[2][2] = "";// la case devant lui est vide


        ArrayList[] couleurs = new ArrayList[]{BLANC, NOIR};
        int[] coordDepart = {2,1};
        int[] coordArrivee = {2,2};
        boolean resultat = DeplacementsPionsSpecifiques.ValidationDeplacementRoi(coordDepart, coordArrivee, couleurs, "ROIBLANC", "");
        assertTrue("Le roi blanc doit pouvoir atteindre une case vide si elle est à une distance de une case en haut.", resultat);

        // cas roi noir
        plateau[2][1] = "ROINOIR"; // On definit un roi noir dans la case b1
        plateau[2][2] = "";// la case devant lui est vide


        int[] coordDepart2 = {2,1};
        int[] coordArrivee2 = {2,2};
        boolean resultat2 = DeplacementsPionsSpecifiques.ValidationDeplacementRoi(coordDepart2, coordArrivee2, couleurs, "ROINOIR", "");
        assertTrue("Le roi noir doit pouvoir atteindre une case vide si elle est à une distance de une case en haut.", resultat2);

        //cas deplacement bas
        plateau[2][3] = "ROIBLANC"; // On definit un roi blanc dans la case b3
        plateau[2][2] = "";// la case derriere lui est vide b2


        int[] coordDepart3 = {2,3};
        int[] coordArrivee3 = {2,2};
        boolean resultat3 = DeplacementsPionsSpecifiques.ValidationDeplacementRoi(coordDepart3, coordArrivee3, couleurs, "ROIBLANC", "");
        assertTrue("Le roi blanc doit pouvoir atteindre une case vide si elle est à une distance de une case en haut.", resultat3);

        // cas deplacement >1
        plateau[2][3] = "ROIBLANC"; // On definit un roi blanc dans la case b3
        plateau[2][5] = "";// la case deu cases superieure devant est vide


        int[] coordDepart4 = {2,3};
        int[] coordArrivee4 = {2,5};
        boolean resultat4 = DeplacementsPionsSpecifiques.ValidationDeplacementRoi(coordDepart4, coordArrivee4, couleurs, "ROIBLANC", "");
        assertFalse("Le roi ne se deplace que d'une case", resultat4);

        //cas deplacement droite
        plateau[2][3] = "ROIBLANC"; // On definit un roi blanc dans la case b3
        plateau[3][3] = "";// la case à sa droite est vide


        int[] coordDepart5 = {2,3};
        int[] coordArrivee5 = {3,3};
        boolean resultat5 = DeplacementsPionsSpecifiques.ValidationDeplacementRoi(coordDepart5, coordArrivee5, couleurs, "ROIBLANC", "");
        assertTrue("Le roi peut se deplacer d'une case à droite.", resultat5);

        //cas deplacement gauche
        plateau[2][3] = "ROIBLANC"; // On definit un roi blanc dans la case b3
        plateau[1][3] = "";// la case à sa gauche est vide


        int[] coordDepart6 = {2,3};
        int[] coordArrivee6 = {1,3};
        boolean resultat6 = DeplacementsPionsSpecifiques.ValidationDeplacementRoi(coordDepart6, coordArrivee6, couleurs, "ROIBLANC", "");
        assertTrue("Le roi peut se deplacer d'une case à droite.", resultat6);

        //cas diagonale
        plateau[2][3] = "ROIBLANC"; // On definit un roi blanc dans la case b3
        plateau[3][4] = "";// la case à sa diagonale haut gauche est vide


        int[] coordDepart7 = {2,3};
        int[] coordArrivee7 = {3,4};
        boolean resultat7 = DeplacementsPionsSpecifiques.ValidationDeplacementRoi(coordDepart7, coordArrivee7, couleurs, "ROIBLANC", "");
        assertTrue("Le roi peut se deplacer d'une case à droite.", resultat7);


    }


}
