package Interface;
import Perso.Classes.Magic;
import Perso.Classes.Warrior;
import Perso.Perso;

import java.awt.*;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
public class Interface {

    private ArrayList<Perso> persos = new ArrayList<>();
    private Perso currentPlayer = null;
    private Scanner scan = new Scanner(System.in);
    private char play = 'O';
    private char menuResponse;
    private Perso personnage = null;
    private Plateau plateau;
    private int id = 0;

    public void start() {
        welcome();
        while (menuResponse != 'Q') {
            menu();
            if (menuResponse == 'C') {
                clearScreen();
                createPlayer();
            } else if (menuResponse == 'M') {
                clearScreen();
                selectCombatant("modif");
            } else if (menuResponse == 'S') {
                clearScreen();
                selectCombatant("select");
            } else if (menuResponse == 'A') {
                clearScreen();
                affiche();
            } else if (menuResponse == 'D') {
                clearScreen();
                run();
            }
        }
        System.out.println("Au revoir jeune(s) menestrel(s)");
    }

    public void menu(){
        System.out.println("Quelle actions voulez vous faire ?\n\n" +
                " -(C)réer un combatant \n" +
                " -(A)fficher les combatant \n" +
                " -(S)electionner un combatant \n" +
                " -(M)odifier/Supprimer un combatant \n" +
                " -(D)émmarer une partie \n" +
                " -(Q)uitter le jeu");
        menuResponse = scan.nextLine().charAt(0);
    }

    public void createPlayer(){
        System.out.println("Construit ton armée");
        personnage = setClasse(personnage);
        personnage.setId(id);
        System.out.println("Quel nom voulez vous ?");
        personnage.setName(scan.nextLine());
        params(personnage, "vie");
        params(personnage, "force");
        persos.add(personnage);
        id++;
    }

    public void affiche() {
        if (isCombatant()) {
            for (Perso perso : persos) {
                System.out.println(perso);
            }
        } else {
            noCombatant();
        }
    }

    public void selectCombatant(String action) {
        if (isCombatant()) {
            int exitMenu = 0;
            System.out.println("Choisissez un personnage");
            for (int i = 0; i < persos.size(); i++) {
                System.out.println(persos.get(i).getId() + " - " + persos.get(i).getName());
                exitMenu++;
            }
            System.out.println(exitMenu + " - Fin du choix");
            int choice = scan.nextInt();
            if (action == "modif") {
                if (choice != exitMenu || choice < exitMenu) {
                    selectModif(choice);
                }
            } else if (action == "select") {
                currentPlayer = persos.get(choice);
            }
            scan.nextLine();
        } else {
            noCombatant();
        }
    }

    public void selectModif(int id) {
        Perso perso = persos.get(id);
        System.out.println("quelle modification voulez vous apporter");
        System.out.println(" 1 - Reset Name \n 2 - Reset Vie \n 3 - Reset Attaque \n 4 - Supprimer le personnage \n 5 - Fin de modife");
        int choice = scan.nextInt();
        scan.nextLine();
        if (choice == 1) {
            resetName(id);
        } else if (choice == 2) {
            params(perso, "vie");
        } else if (choice == 3) {
            params(perso, "force");
        } else if (choice == 4) {
            delete(id);
        }
    }

    public Perso setClasse(Perso hero) {
        char trooper;
        System.out.println("(G)uerrier / (M)agicien ?");
        trooper = scan.nextLine().charAt(0);
        if (trooper == 'G') {
            hero = new Warrior();
        } else if (trooper == 'M') {
            hero = new Magic();
        }
        return hero;
    }

    public void resetName(int id) {
        System.out.println("modifié le nom ? (pas de changement si null");
        String oldName = persos.get(id).getName();
        String newName = scan.nextLine();
        persos.get(id).setName((newName.isEmpty()) ? oldName : newName);
    }

    public void params(Perso personnage, String type) {
        boolean checked = false;
        int min = 0;
        int max = 0;
        if (type == "vie") {
            min = personnage.getMin_vie();
            max = personnage.getMax_vie();
        } else if (type == "force") {
            min = personnage.getMin_force();
            max = personnage.getMax_force();
        }
        while (checked == false) {
            System.out.println("Repartissez vos XP, Vos point de " + type + " entre " + min + " et " + max);
            int val = scan.nextInt();
            scan.nextLine();
            checked = check(val, min, max);
            if (checked && type == "vie") {
                personnage.setLife(val);
            } else if (checked && type == "force") {
                personnage.setAtk(val);
            }
        }
    }

    public void delete(int id) {
        System.out.println("Etesvous sur de vouloir supprimer ? (O)ui / (N)on");
        char response = scan.nextLine().charAt(0);
        if (response == 'O') {
            persos.remove(id);
            System.out.println("Suppression OK");
        } else {
            System.out.println("Suppression Annuler");
        }
    }

    public boolean check(int val, int min, int max) {
        return (val >= min && val <= max) ? true : false;
    }

    public boolean isCombatant() {
        return !persos.isEmpty();
    }

    public void noCombatant() {
        System.out.println(
                "\n"+
                "/=====**************************=====\\" + "\n\n" +
                "     Vous n'avez pas de combatant     " + "\n\n" +
                "\\=====**************************=====/" + "\n\n"
        );
    }

    public void welcome(){
        clearScreen();
        System.out.println(
            "\n"+
            "//=================================================================\\\\"+
            "\n\n"+
            "                       BONJOUR JEUNE PALADIN !\n" +
            "                  Souhaite tu construire une armée\n" +
            "                   afin d'occire quelques dragon\n"+
            "\n"+"\\\\=================================================================//"+
            "\n"
        );
    }

    public void run(){
        if(!isCombatant()){
            noCombatant();
            System.out.println("Vous devez choisir un combattant ...");
        }else{
            plateau = new Plateau();
            System.out.println(plateau.getPosition());
        }
    }

    public void clearScreen() {
        for(int clear = 0; clear < 1000; clear++)
        {
            System.out.println("\b") ;
        }
    }
}