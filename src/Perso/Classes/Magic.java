package Perso.Classes;
import Perso.Damagers.Spell;
import Perso.Perso;
import java.awt.*;
public class Magic extends Perso {

    //Variables
    private int max_vie = 6;
    private int min_vie = 3;
    private int min_force = 8;
    private int max_force = 15;
    private String protection = "Philtres";

    //Constructeurs
    public Magic() {
        super.setMin_vie(min_vie);
        super.setMax_vie(max_vie);
        super.setMin_force(min_force);
        super.setMax_force(max_force);
        super.setDmg(new Spell());
    }
    public Magic(String name) {
        super(name);
        super.setMin_vie(min_vie);
        super.setMax_vie(max_vie);
        super.setMin_force(min_force);
        super.setMax_force(max_force);
        super.setDmg(new Spell());
    }
    public Magic(String name, Image pict, int life, int atk) {
        super(name, pict, life, atk);
        super.setMin_vie(min_vie);
        super.setMax_vie(max_vie);
        super.setMin_force(min_force);
        super.setMax_force(max_force);
        super.setDmg(new Spell());
    }
}
