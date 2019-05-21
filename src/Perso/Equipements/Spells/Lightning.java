package Perso.Equipements.Spells;

import Perso.Equipement;

public class Lightning extends Equipement {
    private String name = "Lightning";
    private  int power = 2;

    public Lightning(){
        super.setDamName(this.name);
        super.setDamAtk(this.power);
    }
}
