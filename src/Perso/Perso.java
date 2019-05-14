package Perso;
import java.awt.*;
public class Perso {

    //Variables
    private int id;
    private int max_vie;
    private int min_vie;
    private int min_force;
    private int max_force;
    private String name;
    private Image pict;
    private String type;
    private int life;
    private int atk;
    private Damager dmg;
    private String protection;

    //Constructeur
    public Perso(){

    }
    public Perso(String name) {
        this.name = name;
    }
    public Perso(String name, Image pict, int life, int atk) {
        this.name = name;
        this.pict = pict;
        this.life = life;
        this.atk = atk;
    }

    //getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Image getPict() {
        return pict;
    }
    public String getType() {
        return type;
    }
    public int getLife() {
        return life;
    }
    public int getAtk() {
        return atk;
    }
    public Damager getDmg() {
        return dmg;
    }
    public String getProtection() {
        return protection;
    }
    public int getMax_vie() {
        return max_vie;
    }
    public int getMin_vie() {
        return min_vie;
    }
    public int getMin_force() {
        return min_force;
    }
    public int getMax_force() {
        return max_force;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        if(name.isEmpty()){
            name = "<Anonymous>";
        }
        this.name = name;
    }
    public void setPict(Image pict) {
        this.pict = pict;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setLife(int life) {
        this.life = life;
    }
    public void setAtk(int atk) {
        this.atk = atk;
    }
    public void setDmg(Damager dmg) {
        this.dmg = dmg;
    }
    public void setProtection(String protection) {
        this.protection = protection;
    }
    public void setMax_vie(int max_vie) {
        this.max_vie = max_vie;
    }
    public void setMin_vie(int min_vie) {
        this.min_vie = min_vie;
    }
    public void setMin_force(int min_force) {
        this.min_force = min_force;
    }
    public void setMax_force(int max_force) {
        this.max_force = max_force;
    }

    //toString
    public String toString() {
        return "Id "+this.getId()+" :   -Votre personnage : "+this.getName()+"\n"+
                "         -CLASSE : "+this.getType()+"\n"+
                "         -PDV : "+this.getLife()+"\n"+
                "         -PDA : "+this.getAtk()+"\n"+
                "         -Arme / Sort : "+this.getDmg().getDamName()+"\n"+
                "         -Dommages : "+this.getDmg().getDamAtk()+"\n";
    }
}