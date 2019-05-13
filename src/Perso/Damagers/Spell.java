package Perso.Damagers;

import Perso.Damager;

public class Spell extends Damager {
    private String name = "Shazam";
    private  int power = 8;

    public Spell (){
        super.setDamName(this.name);
        super.setDamAtk(this.power);
    }
}
