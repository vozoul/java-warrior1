import Perso.Classes.Magic;
import Perso.Classes.Warrior;
import Perso.Perso;
import java.util.Scanner;

public class Main {

    //Variable globales
    static Scanner scan = new Scanner(System.in);
    static char play = 'O';
    static char menuResponse;
    static Perso personnage = null;
    static Perso persos[] = new Perso[10];
    static int id = 0;

    //demarage
    public static void main(String[] args) {
        System.out.println("Bonjour jeune paladin !\nSouhaite tu construire une armée\nafin d'occire quelques dragon\n");
        System.out.println("(O)ui / (N)on ?");
        play = scan.nextLine().charAt(0);
        while(play == 'O'){
            menu();
            if(menuResponse == 'C') {
                createPlayer();
            }else if(menuResponse == 'A') {
                affiche();
            }else if(menuResponse == 'Q'){
                play = 'N';
            }
        }
        System.out.println("Au revoir jeune(s) menestrel(s)");
    }

    //menu principale
    public static void menu(){
        System.out.println("Quelle actions voulez vous faire ?\n (C)réer un combatant \n (A)fficher les combatant \n (Q)uitter la partie");
        menuResponse = scan.nextLine().charAt(0);
    }

    //creation d'un Perso
    public static void createPlayer(){
        char trooper;
        System.out.println("Construit ton armée");
        System.out.println("(G)uerrier / (M)agicien ?");
        trooper = scan.nextLine().charAt(0);
        if(trooper == 'G'){
            personnage = new Warrior();
            personnage.setId(id);
            personnage.setType("Guerrier");
        }else if(trooper == 'M'){
            personnage = new Magic();
            personnage.setId(id);
            personnage.setType("Magicien");
        }
        System.out.println("Quel nom voulez vous ?");
        personnage.setName(scan.nextLine());
//        boolean checked = false;
//        while(checked == false) {
//            System.out.println("Repartissez vos XP, Vos point de vie entre " + personnage.getMin_vie() + " et " + personnage.getMax_vie());
            System.out.println("Repartissez vos XP, Vos point de vie entre " + personnage.getMin_vie() + " et " + personnage.getMax_vie());
//            value = scan.nextInt();
//            check(value);
//            personnage.setLife();
//        }
        personnage.setLife(scan.nextInt());
        System.out.println("Repartissez vos XP, Vos point d'attaque entre "+personnage.getMin_force()+" et "+personnage.getMax_force());
        personnage.setAtk(scan.nextInt());
        scan.nextLine();
        scan.nextLine();

        persos[id] = personnage;
        id++;
    }

    public static void affiche(){
        int plein = 0;
        for (int i = 0; i<persos.length; i++) {
            if(persos[i] != null) {
                System.out.println(persos[i]);
                plein++;
            }
        }
        if(plein == 0){
            System.out.println(
                    "/**************************\\"+"\n"+
                    "Vous n'avez pas de combatant"+"\n"+
                    "\\**************************/"+"\n"
            );
        }else{
            System.out.println("Voulez vous modifier un combatant ? (O)ui / (N)on");
            char subMenu = scan.nextLine().charAt(0);
            if(subMenu == 'O') {
                System.out.println("Choisissez un personnage");
                for (int i = 0; i<persos.length; i++) {
                    if(persos[i] != null) {
                        System.out.println(persos[i].getId() + " - " + persos[i].getName());
                    }
                }
                int mod = scan.nextInt();
                scan.nextLine();
            }
        }
    }

    public static void check(){}
}