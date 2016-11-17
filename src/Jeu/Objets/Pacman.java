package Jeu.Objets;

import java.util.Scanner;

/**
 * Created by Antoine on 04/11/2016.
 */
public class Pacman extends Dynamic{

    static Scanner sc = new Scanner(System.in);


    public Pacman(int X, int Y ){
        //constructeur, en entrée ont met les caleurs trouvées par le debut
        this.X = X;
        this.Y = Y;
        this.name = 'P';

    }


    public static void get_info_mouv(){
        // On fait bouger notre Pac-Man préféré !
        char choix_usr = 'c';
        System.out.print("Choisissez votre direction \n n: Nord \n s: Sud \n o: Ouest \n e: Est ");
        boolean erreur = false;
        while (choix_usr != 'n' || choix_usr != 'e' || choix_usr != 's' || choix_usr != 'o') {
            choix_usr = sc.nextLine().charAt(0);
        }
        colllision_check(choix_usr);
        mouvement(newX, newY);


    }

}
