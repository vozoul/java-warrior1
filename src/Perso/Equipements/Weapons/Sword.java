package Perso.Equipements.Weapons;

import Perso.Equipement;

public class Sword extends Equipement {
    private String name = "Excalibure";
    private int power = 6;

    public Sword (){
        super.setDamName(this.name);
        super.setDamAtk(this.power);
    }
}
