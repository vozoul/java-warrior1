package Perso.Classes;
import Perso.Equipements.Weapons.Sword;
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
        normal();
    }
    public Warrior(String name) {
        super(name);
        normal();
    }
    public Warrior(String name, Image pict, int life, int atk) {
        super(name, pict, life, atk);
        normal();
    }

    private void normal(){
        setMin_vie(min_vie);
        setMax_vie(max_vie);
        setMin_force(min_force);
        setMax_force(max_force);
        setType("Geurrier");
        setProtection(protection);
        setDmg(new Sword());
    }
}
