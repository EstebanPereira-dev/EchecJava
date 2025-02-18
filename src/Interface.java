import java.util.Scanner;

public class Interface {

    static Scanner sc = new Scanner(System.in);
    public static String MENU = "1/. Joueur contre Joueur \n2/. Joueur contre Ordinateur\n3/. Skins \n4/. Quitter ";

    public static void execution() {
        int choix;

        System.out.println("Bienvenue !");
        System.out.println();
       do {
           System.out.println("Veuillez séléctionner votre mode de jeu : ");
           System.out.println(MENU);
           choix= sc.nextInt();
       }
       while(choix<1 || choix >4);
       switch(choix){
           case 1:
               String pseudo1, pseudo2;
               pseudo1 = creationPseudo(1);
               pseudo2 = creationPseudo(2);
               if (pseudo1.equals(pseudo2)) {
                   System.out.println("Les pseudo sont identique, veuillez choisir deux pseudo different");
                   pseudo2 = creationPseudo(2);
               }
               System.out.println("La partie peut commencer !");
               sc.nextLine();
               MéthodeEnToutGenre.miseEnRoute(pseudo1, pseudo2);
               break;
           case 2:
               String pseudo=creationPseudo(1);
               System.out.println("Coming Soon");
               break;
           case 3:
               Cosmetique.skins();
               break;
           default:
               break;
       }
    }
    public static String creationPseudo(int numJoueur) {
        String pseudo;
        do {
            System.out.println("Entrez le nom du Joueur " + numJoueur + " [3-20] : ");
            pseudo = sc.next();
            System.out.println("["+pseudo+"]");
            return pseudo;
        }while(!(pseudo.length() < 3 || pseudo.length() > 20 ));
    }
}
