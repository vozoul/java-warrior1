package Interface;

import Perso.Classes.Magic;
import Perso.Classes.Warrior;
import Perso.Perso;
import java.util.Scanner;

public class Interface {

    //Variable globales
    private Perso currentPlayer = null;
    private Scanner scan = new Scanner(System.in);
    private char play = 'O';
    private char menuResponse;
    private Perso personnage = null;
    private Perso persos[] = new Perso[10];
    private int id = 0;

    //Demarrage
    public void start(){
        System.out.println("Bonjour jeune paladin !\nSouhaite tu construire une armée\nafin d'occire quelques dragon\n");
        System.out.println("(O)ui / (N)on ?");
        play = scan.nextLine().charAt(0);
        while(play == 'O'){
            menu();
            if(menuResponse == 'C') {
                createPlayer();
            }else if(menuResponse == 'M') {
                selectCombatant("modif");
            }else if(menuResponse == 'S') {
                selectCombatant("select");
            }else if(menuResponse == 'A') {
                affiche();
            }else{
                play = 'N';
            }
        }
        System.out.println("Au revoir jeune(s) menestrel(s)");
    }
    //menu principale
    public void menu(){
        System.out.println("Quelle actions voulez vous faire ?\n" +
                " -(C)réer un combatant \n" +
                " -(A)fficher les combatant \n" +
                " -(S)electionner un combatant \n" +
                " -(M)odifier/Supprimer un combatant \n" +
                " -(Q)uitter la partie");
        menuResponse = scan.nextLine().charAt(0);
    }

    //creation d'un Perso
    public void createPlayer(){
        System.out.println("Construit ton armée");
        personnage = setClasse(personnage);
        personnage.setId(id);
        System.out.println("Quel nom voulez vous ?");
        personnage.setName(scan.nextLine());
        setVie(personnage);
        setForce(personnage);
        persos[id] = personnage;
        id++;
    }

    //liste et choix de personnage
    public void affiche(){
        if(isCombatant()) {
            for (int i = 0; i < persos.length; i++) {
                if (persos[i] != null) {
                    System.out.println(persos[i]);
                }
            }
        }else{
            noCombatant();
        }
    }
    public void selectCombatant(String action){
        if(isCombatant()) {
            int exitMenu = 0;
            System.out.println("Choisissez un personnage");
            for (int i = 0; i < persos.length; i++) {
                if (persos[i] != null) {
                    System.out.println(persos[i].getId() + " - " + persos[i].getName());
                    exitMenu++;
                }
            }
            System.out.println(exitMenu + " - Fin du choix");
            int choice = scan.nextInt();
            if(action == "modif") {
                if (choice != exitMenu || choice < exitMenu) {
                    selectModif(choice);
                }
            }else if (action == "select"){
                currentPlayer = persos[choice];
            }
            scan.nextLine();
        }else{
            noCombatant();
        }
    }

    //edit & modifie un perso
    public void selectModif(int id){
        Perso perso = persos[id];
        System.out.println("quelle modification voulez vous apporter");
        System.out.println(" 1 - Reset Name \n 2 - Reset Vie \n 3 - Reset Attaque \n 4 - Supprimer le personnage \n 5 - Fin de modife");
        int choice = scan.nextInt();
        scan.nextLine();
        if(choice == 1){
            resetName(id);
        }else if(choice == 2){
            setVie(perso);
        }else if(choice == 3){
            setForce(perso);
        }else if(choice == 4){
            delete(id);
        }
    }
    public Perso setClasse(Perso hero){
        char trooper;
        System.out.println("(G)uerrier / (M)agicien ?");
        trooper = scan.nextLine().charAt(0);
        if (trooper == 'G') {
            hero = new Warrior();
            hero.setType("Guerrier");
        } else if (trooper == 'M') {
            hero = new Magic();
            hero.setType("Magicien");
        }
        return hero;
    }
    public void resetName(int id){
        Perso perso = persos[id];
        String oldName = perso.getName();
        System.out.println("modifié le nom ? (pas de changement si null");
        String newName = scan.nextLine();
        if(newName.isEmpty()){
            perso.setName(oldName);
        }else{
            perso.setName(newName);
        }
    }
    public void setVie(Perso personnage){
        boolean checked = false;
        int value = 0;
        while(checked == false) {
            System.out.println("Repartissez vos XP, Vos point de vie entre " + personnage.getMin_vie() + " et " + personnage.getMax_vie());
            int val = scan.nextInt();
            scan.nextLine();
            checked = check(val, "vie");
            value = val;
            if(checked) {
                personnage.setLife(value);
            }
        }
    }
    public void setForce(Perso personnage){
        boolean checked = false;
        int value = 0;
        while(checked == false) {
            System.out.println("Repartissez vos XP, Vos point d'attaque entre " + personnage.getMin_force() + " et " + personnage.getMax_force());
            int val = scan.nextInt();
            scan.nextLine();
            checked = check(val, "atk");
            value = val;
            if(checked) {
                personnage.setAtk(value);
            }
        }
    }
    public void delete(int id){
        System.out.println("Etesvous sur de vouloir supprimer ? (O)ui / (N)on");
        char response = scan.nextLine().charAt(0);
        if(response == 'O'){
            persos[id] = null;
            System.out.println("Suppression OK");
        }else{
            System.out.println("Suppression Annuler");
        }
    }

    //check si entre val max et val min
    public boolean check(int val, String type){
        int min = 0;
        int max = 0;
        if(type == "vie"){
            min = personnage.getMin_vie();
            max = personnage.getMax_vie();
        }else if(type == "atk"){
            min = personnage.getMin_force();
            max = personnage.getMax_force();
        }
        if(val >= min && val <= max) {
            return true;
        }
        return false;
    }

    //verifie si des combatants
    public boolean isCombatant(){
        int combatant=0;
        for(int i =0; i<persos.length; i++){
            if(persos[i] != null) {
                combatant++;
            }
        }
        if(combatant>0){
            return true;
        }
        return false;
    }
    public void noCombatant(){
        System.out.println("\n"+
                "/=====**************************=====\\"+"\n\n"+
                "     Vous n'avez pas de combatant     "+"\n\n"+
                "\\=====**************************=====/"+"\n\n"
        );
    }
}