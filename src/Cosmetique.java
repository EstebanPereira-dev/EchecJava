import java.util.Scanner;
public class Cosmetique {

    static Scanner sc = new Scanner(System.in);

    public static void skins() {

        int choix1;
        int choix2;
        int choix3;
        int choix4;
        int choix5;
        do {
            do {
                System.out.println("Voulez vous changer les visuels du plateau ou des pions?\n1/. Changer les cases blanches\n2/. Changer les cases noires\n3/. changer les pions blancs\n4/. Changer les pions noirs\n5/. Ne pas changer les visuels");
                choix1 = sc.nextInt();
            } while (choix1 < 1 || choix1 > 5);

            switch (choix1) {
                case 1:
                    do {
                        System.out.println("De quelle couleur doivent être les cases blanches?\n1/. Couleur de base\n2/. Rouges\n3/. Vertes\n4/. Jaunes\n5/. Bleues\n6/. Magenta\n7/. Cyans\n8/. Quitter les parametres visuels");
                        choix2 = sc.nextInt();
                    }
                    while (choix2 < 1 || choix2 > 8);
                    switch (choix2) {
                        case 1:
                            MéthodeEnToutGenre.CASEBLANCHE = "\u001B[47m";
                            break;
                        case 2:
                            MéthodeEnToutGenre.CASEBLANCHE = "\u001B[41;1m";

                            break;
                        case 3:
                            MéthodeEnToutGenre.CASEBLANCHE = "\u001B[42;1m";
                            break;
                        case 4:
                            MéthodeEnToutGenre.CASEBLANCHE = "\u001B[43;1m";
                            break;
                        case 5:
                            MéthodeEnToutGenre.CASEBLANCHE = "\u001B[44;1m";
                            break;
                        case 6:
                            MéthodeEnToutGenre.CASEBLANCHE = "\u001B[45;1m";
                            break;
                        case 7:
                            MéthodeEnToutGenre.CASEBLANCHE = "\u001B[46;1m";
                            break;
                        default:
                            System.out.println("Pas de changements de couleurs");
                            break;

                    }
                    MéthodeEnToutGenre.afficherPlateau();

                    break;
                case 2:

                    do {
                        System.out.println("De quelle couleur doivent être les cases noires?\n1/. Couleur de base\n2/. Rouges\n3/. Vertes\n4/. Jaunes\n5/. Bleues\n6/. Magenta\n7/. Cyans\n8/. Quitter les parametres visuels");
                        choix3 = sc.nextInt();
                    }
                    while (choix3 < 1 || choix3 > 8);
                    switch (choix3) {
                        case 1:
                            MéthodeEnToutGenre.CASENOIRE = "\u001B[47m";
                            break;
                        case 2:
                            MéthodeEnToutGenre.CASENOIRE = "\u001B[41m";

                            break;
                        case 3:
                            MéthodeEnToutGenre.CASENOIRE = "\u001B[42m";
                            break;
                        case 4:
                            MéthodeEnToutGenre.CASENOIRE = "\u001B[43m";
                            break;
                        case 5:
                            MéthodeEnToutGenre.CASENOIRE = "\u001B[44m";
                            break;
                        case 6:
                            MéthodeEnToutGenre.CASENOIRE = "\u001B[45m";
                            break;
                        case 7:
                            MéthodeEnToutGenre.CASENOIRE = "\u001B[46m";
                            break;
                        default:
                            System.out.println("Pas de changements de couleurs");
                            break;
                    }
                    MéthodeEnToutGenre.afficherPlateau();
                    break;
                case 3:
                    do{
                        System.out.println("De quelle couleur doivent être les pions blancs?\n1/. Couleur de base\n2/. Rouge\n3/. Verte\n4/. Jaune\n5/. Bleue\n6/. Magenta\n7/. Cyan\n8/. Quitter les parametres visuels");
                        choix4 = sc.nextInt();
                    }while(choix4<1 ||choix4>8);
                    switch(choix4){
                        case 1:
                            MéthodeEnToutGenre.PIONBLANC = "\u001B[37;1m";
                            MéthodeEnToutGenre.CAVALIERBLANC = "\u001B[37;1m";
                            MéthodeEnToutGenre.ROIBLANC = "\u001B[37;1m";
                            MéthodeEnToutGenre.FOUBLANC= "\u001B[37;1m";
                            MéthodeEnToutGenre.REINEBLANCHE = "\u001B[37;1m";
                            MéthodeEnToutGenre.TOURBLANCHE = "\u001B[37;1m";
                            break;
                        case 2:
                            MéthodeEnToutGenre.PIONBLANC = "\u001B[31;1m";
                            MéthodeEnToutGenre.CAVALIERBLANC = "\u001B[31;1m";
                            MéthodeEnToutGenre.ROIBLANC = "\u001B[31;1m";
                            MéthodeEnToutGenre.FOUBLANC= "\u001B[31;1m";
                            MéthodeEnToutGenre.REINEBLANCHE = "\u001B[31;1m";
                            MéthodeEnToutGenre.TOURBLANCHE ="\u001B[31;1m";
                            break;
                        case 3:
                            MéthodeEnToutGenre.PIONBLANC = "\u001B[32;1m";
                            MéthodeEnToutGenre.CAVALIERBLANC = "\u001B[32;1m";
                            MéthodeEnToutGenre.ROIBLANC = "\u001B[32;1m";
                            MéthodeEnToutGenre.FOUBLANC= "\u001B[32;1m";
                            MéthodeEnToutGenre.REINEBLANCHE = "\u001B[32;1m";
                            MéthodeEnToutGenre.TOURBLANCHE ="\u001B[32;1m";
                            break;
                        case 4:
                            MéthodeEnToutGenre.PIONBLANC = "\u001B[33;1m";
                            MéthodeEnToutGenre.CAVALIERBLANC = "\u001B[33;1m";
                            MéthodeEnToutGenre.ROIBLANC = "\u001B[33;1m";
                            MéthodeEnToutGenre.FOUBLANC= "\u001B[33;1m";
                            MéthodeEnToutGenre.REINEBLANCHE = "\u001B[33;1m";
                            MéthodeEnToutGenre.TOURBLANCHE ="\u001B[33;1m";
                            break;
                        case 5:
                            MéthodeEnToutGenre.PIONBLANC = "\u001B[34;1m";
                            MéthodeEnToutGenre.CAVALIERBLANC = "\u001B[34;1m";
                            MéthodeEnToutGenre.ROIBLANC = "\u001B[34;1m";
                            MéthodeEnToutGenre.FOUBLANC= "\u001B[34;1m";
                            MéthodeEnToutGenre.REINEBLANCHE = "\u001B[34;1m";
                            MéthodeEnToutGenre.TOURBLANCHE ="\u001B[34;1m";
                            break;
                        case 6:
                            MéthodeEnToutGenre.PIONBLANC = "\u001B[35;1m";
                            MéthodeEnToutGenre.CAVALIERBLANC = "\u001B[35;1m";
                            MéthodeEnToutGenre.ROIBLANC = "\u001B[35;1m";
                            MéthodeEnToutGenre.FOUBLANC= "\u001B[35;1m";
                            MéthodeEnToutGenre.REINEBLANCHE = "\u001B[35;1m";
                            MéthodeEnToutGenre.TOURBLANCHE ="\u001B[35;1m";
                            break;
                        case 7:
                            MéthodeEnToutGenre.PIONBLANC = "\u001B[36;1m";
                            MéthodeEnToutGenre.CAVALIERBLANC = "\u001B[36;1m";
                            MéthodeEnToutGenre.ROIBLANC = "\u001B[36;1m";
                            MéthodeEnToutGenre.FOUBLANC= "\u001B[36;1m";
                            MéthodeEnToutGenre.REINEBLANCHE = "\u001B[36;1m";
                            MéthodeEnToutGenre.TOURBLANCHE ="\u001B[36;1m";
                            break;
                        default:
                            System.out.println("Pas de changements de couleurs");
                            break;
                    }
                        MéthodeEnToutGenre.afficherPlateau();
                    break;
                case 4:
                    do{
                        System.out.println("De quelle couleur doivent être les pions noirs?\n1/. Couleur de base\n2/. Rouge\n3/. Verte\n4/. Jaune\n5/. Bleue\n6/. Magenta\n7/. Cyan\n8/. Quitter les parametres visuels");
                        choix5 = sc.nextInt();
                    }while(choix5<1 ||choix5>8);
                    switch(choix5){
                        case 1:
                            MéthodeEnToutGenre.PIONNOIR = "\u001B[30";
                            MéthodeEnToutGenre.CAVALIERNOIRE = "\u001B[30";
                            MéthodeEnToutGenre.ROINOIR = "\u001B[30";
                            MéthodeEnToutGenre.FOUNOIR = "\u001B[30";
                            MéthodeEnToutGenre.REINENOIRE = "\u001B[30";
                            MéthodeEnToutGenre.TOURNOIRE = "\u001B[30";
                            break;
                        case 2:
                            MéthodeEnToutGenre.PIONNOIR = "\u001B[31;";
                            MéthodeEnToutGenre.CAVALIERNOIRE = "\u001B[31";
                            MéthodeEnToutGenre.ROINOIR = "\u001B[31";
                            MéthodeEnToutGenre.FOUNOIR = "\u001B[31";
                            MéthodeEnToutGenre.REINENOIRE = "\u001B[31";
                            MéthodeEnToutGenre.TOURNOIRE ="\u001B[31";
                            break;
                        case 3:
                            MéthodeEnToutGenre.PIONNOIR = "\u001B[32";
                            MéthodeEnToutGenre.CAVALIERNOIRE = "\u001B[32";
                            MéthodeEnToutGenre.ROINOIR = "\u001B[32";
                            MéthodeEnToutGenre.FOUNOIR = "\u001B[32";
                            MéthodeEnToutGenre.REINENOIRE = "\u001B[32";
                            MéthodeEnToutGenre.TOURNOIRE ="\u001B[32";
                            break;
                        case 4:
                            MéthodeEnToutGenre.PIONNOIR = "\u001B[33";
                            MéthodeEnToutGenre.CAVALIERNOIRE = "\u001B[33";
                            MéthodeEnToutGenre.ROINOIR = "\u001B[33";
                            MéthodeEnToutGenre.FOUNOIR = "\u001B[33";
                            MéthodeEnToutGenre.REINENOIRE = "\u001B[33";
                            MéthodeEnToutGenre.TOURNOIRE ="\u001B[33";
                            break;
                        case 5:
                            MéthodeEnToutGenre.PIONNOIR = "\u001B[34";
                            MéthodeEnToutGenre.CAVALIERNOIRE = "\u001B[34";
                            MéthodeEnToutGenre.ROINOIR = "\u001B[34";
                            MéthodeEnToutGenre.FOUNOIR = "\u001B[34";
                            MéthodeEnToutGenre.REINENOIRE = "\u001B[34";
                            MéthodeEnToutGenre.TOURNOIRE ="\u001B[34";
                            break;
                        case 6:
                            MéthodeEnToutGenre.PIONNOIR = "\u001B[35";
                            MéthodeEnToutGenre.CAVALIERNOIRE = "\u001B[35";
                            MéthodeEnToutGenre.ROINOIR = "\u001B[35";
                            MéthodeEnToutGenre.FOUNOIR = "\u001B[35";
                            MéthodeEnToutGenre.REINENOIRE = "\u001B[35";
                            MéthodeEnToutGenre.TOURNOIRE ="\u001B[35";
                            break;
                        case 7:
                            MéthodeEnToutGenre.PIONNOIR = "\u001B[36";
                            MéthodeEnToutGenre.CAVALIERNOIRE = "\u001B[36";
                            MéthodeEnToutGenre.ROINOIR = "\u001B[36";
                            MéthodeEnToutGenre.FOUNOIR = "\u001B[36";
                            MéthodeEnToutGenre.REINENOIRE = "\u001B[36";
                            MéthodeEnToutGenre.TOURNOIRE ="\u001B[36";
                            break;
                        default:
                            System.out.println("Pas de changements de couleurs");
                            break;
                    }
                    MéthodeEnToutGenre.afficherPlateau();
                    break;
                default:
                    Interface.execution();
                    break;
            }
        } while (choix1 != 5);
    }
        }
