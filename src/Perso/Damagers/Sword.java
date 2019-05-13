package Perso.Damagers;

import Perso.Damager;

public class Sword extends Damager {
    private String name = "Excalibure";
    private int power = 6;

    public Sword (){
        super.setDamName(this.name);
        super.setDamAtk(this.power);
    }
}
