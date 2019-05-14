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
        System.out.println("Quelle actions voulez vous faire ?\n -(C)réer un combatant \n -(A)fficher les combatant \n -(Q)uitter la partie");
        menuResponse = scan.nextLine().charAt(0);
    }

    //creation d'un Perso
    public static void createPlayer(){
        char trooper;
        System.out.println("Construit ton armée");
        System.out.println("(G)uerrier / (M)agicien ?");
        trooper = scan.nextLine().charAt(0);
        if (trooper == 'G') {
            personnage = new Warrior();
            personnage.setType("Guerrier");
        } else if (trooper == 'M') {
            personnage = new Magic();
            personnage.setType("Magicien");
        }
        personnage.setId(id);
        System.out.println("Quel nom voulez vous ?");
        personnage.setName(scan.nextLine());
        boolean checked = false;
        int value = 0;
        while(checked == false) {
            System.out.println("Repartissez vos XP, Vos point de vie entre " + personnage.getMin_vie() + " et " + personnage.getMax_vie());
            int val = scan.nextInt();
            scan.nextLine();
            checked = check(val, "vie");
            System.out.println(checked);
            value = val;
        }
        personnage.setLife(value);
        checked = false;
        value = 0;
        while(checked == false) {
            System.out.println("Repartissez vos XP, Vos point d'attaque entre " + personnage.getMin_force() + " et " + personnage.getMax_force());
            int val = scan.nextInt();
            scan.nextLine();
            checked = check(val, "atk");
            value = val;
        }
        personnage.setAtk(value);
        checked = false;
        persos[id] = personnage;
        id++;
    }

    //affiche la liste de personnage
    public static void affiche(){
        int plein = 0;
        for (int i = 0; i<persos.length; i++) {
            if(persos[i] != null) {
                System.out.println(persos[i]);
                plein++;
            }
        }
        if(plein == 0){

            System.out.println("\n"+
                    "/**************************\\"+"\n\n"+
                    "Vous n'avez pas de combatant"+"\n\n"+
                    "\\**************************/"+"\n\n"
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
                //createPlayer(mod);
            }
        }
    }

    //check si entre val max et val min
    public static boolean check(int val, String type){
        int min = 0;
        int max = 0;
        if(type == "vie"){
            min = personnage.getMin_vie();
            max = personnage.getMax_vie();
        }else if(type == "atk"){
            min = personnage.getMin_force();
            max = personnage.getMax_force();
        }
        if(val >= min || val <= max) {
            return true;
        }
        return false;
    }
}