package Perso.Classes;
import Perso.Damagers.Sword;
import Perso.Perso;
import java.awt.*;
public class Warrior extends Perso {

    //Variables
    private int max_vie = 10;
    private int min_vie = 5;
    private int min_force = 5;
    private int max_force = 10;
    private String protection = "shield";

    //Constructeurs
    public Warrior(){
        super.setMin_vie(min_vie);
        super.setMax_vie(max_vie);
        super.setMin_force(min_force);
        super.setMax_force(max_force);
        super.setDmg(new Sword());
    }
    public Warrior(String name) {
        super(name);
        super.setMin_vie(min_vie);
        super.setMax_vie(max_vie);
        super.setMin_force(min_force);
        super.setMax_force(max_force);
        super.setDmg(new Sword());
    }
    public Warrior(String name, Image pict, int life, int atk) {
        super(name, pict, life, atk);
        super.setMin_vie(min_vie);
        super.setMax_vie(max_vie);
        super.setMin_force(min_force);
        super.setMax_force(max_force);
        super.setDmg(new Sword());
    }
}
