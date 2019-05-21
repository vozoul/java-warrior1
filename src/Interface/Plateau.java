package Interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Plateau {

//    private int NbVCases;
//    private int NbHCases;

    private int nbCases = 64;
    private ArrayList<Cases> position = new ArrayList<Cases>();
    private String[] typeCase = {"Ennemi", "Bonus", "Neutre"};
    private Random rand = new Random();

    public Plateau() {
        for(int i=0; i<nbCases; i++){
            String type = typeCase[rand.nextInt(typeCase.length)];
            position.add(new Cases(type, i+1));
        }
    }

    public Plateau(int nbCases) {
        nbCases = nbCases;
    }

    public int getNbCases() {
        return nbCases;
    }

    public void setNbCases(int nbCases) {
        nbCases = nbCases;
    }

    public ArrayList<Cases> getPosition() {
        return position;
    }

    public void setPosition(ArrayList<Cases> position) {
        this.position = position;
    }

    public String[] getTypeCase() {
        return typeCase;
    }

    public void setTypeCase(String[] typeCase) {
        this.typeCase = typeCase;
    }
}
