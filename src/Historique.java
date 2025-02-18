import java.util.ArrayList;
import java.util.Scanner;
public class Historique {

    static Scanner sc = new Scanner(System.in);

    public static void lireHistorique(ArrayList<String> listecoups){
        int choix1;
        int choix2;
        do{
            System.out.println("Voulez vous revoir les coups joués pendant votre partie?\nSi oui, entrez 1\nSi non, entrez 2");
            choix1= sc.nextInt();
        }
        while (choix1<1 || choix1>2);
        if (choix1==1){
            do{
                System.out.println("Comment voulez vous visionner l'historique des coups joués?\nSi vous voulez lister les coups dans l'ordre , sans tenir compte des équipes, tapez 1.\nSi vous voulez différencier ceux des blancs des noirs, tapez 2.\nSi vous voulez annulez, tapez 3");
                choix2=sc.nextInt();
            }
            while(choix2<1 || choix2>3);
            switch(choix2){
                case 1:
                    System.out.println("Liste des coups joués: ");
                    for (int i=0;i<listecoups.size();i++){
                        System.out.println(listecoups.get(i)+", ");
                    }
                    break;
                case 2:
                    System.out.println("Coups des Blancs: ");
                    for (int i=0;i<listecoups.size();i=i+2){
                        System.out.println(listecoups.get(i)+", ");
                    }
                    System.out.println("Coups des Noirs: ");
                    for (int i=1;i<listecoups.size();i=i+2){
                        System.out.println(listecoups.get(i)+", ");
                    }
                    break;
                default:
                    System.out.println("Affichage annulé.");
                    break;
            }
        }
        else {
            System.out.println("Ok, pas de récap!");
        }

    }


}
