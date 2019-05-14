import Interface.Interface;
import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
//        JFrame appli = new JFrame();
//        appli.setTitle("Donjon & Dragon");
//        appli.setSize(800,600);
//        appli.setLocationRelativeTo(null);
//        appli.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        appli.setVisible(true);
//        JPanel jeu = new JPanel();
//        jeu.setBackground(Color.ORANGE);
//        appli.setContentPane(jeu);
        new Interface().start();
    }
}