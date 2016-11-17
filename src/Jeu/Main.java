package Jeu;

import Jeu.Objets.Fantome;
import Jeu.Objets.Pacman;
import Jeu.Labyrinthe.GenerateurLabyrinthe;

import java.util.Scanner;

/**
 * Created by Antoine on 04/11/2016.
 */
public class Main {

    public static void main(String[] args) {
    // OMG pacman en Java !


        Scanner sc = new Scanner(System.in);
        int longeur = 4, largeur = 4;

        System.out.print("Bienvenue dans PacMan, la taille du labyrinthe est 9 x 9 ");

        boolean[][] maze = GenerateurLabyrinthe.generer();
        int [] debut_coor = GenerateurLabyrinthe.setDebut(longeur, largeur);
        int [] debut_fantomeR = GenerateurLabyrinthe.setDebut(longeur, largeur);
        int [] debut_fantomeB = GenerateurLabyrinthe.setDebut(longeur, largeur);

        Pacman pacman = new Pacman(debut_coor[0], debut_coor[1]);
        Fantome fantomeR = new Fantome(debut_fantomeR[0],debut_fantomeR[1],'R');
        Fantome fantomeB = new Fantome(debut_fantomeB[0],debut_fantomeB[1],'B');

        while (true){
            // Ca y est on a initialisé et on va faire la boucle sympathique

            pacman.get_info_mouv();
            fantomeB.get_rand_mouv();
            fantomeR.get_rand_mouv();

        }
    }
}
