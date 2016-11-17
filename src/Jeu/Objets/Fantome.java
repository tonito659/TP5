package Jeu.Objets;

import java.util.Random;

/**
 * Created by Antoine on 17/11/2016.
 */
public class Fantome extends Dynamic {

    static Random random = new Random(System.currentTimeMillis());

    public Fantome(int X, int Y, char name) {
        //constructeur, en entrée ont met les caleurs trouvées par le debut
        this.X = X;
        this.Y = Y;
        this.name = name;

    }


    public static void get_rand_mouv() {
        // On fait bouger notre fantome préféré !
        int randomizer = random.nextInt(4);
        char choix = 'a';
        switch (randomizer) {
            case 1:
                choix = 'e';
                break;

            case 2:
                choix = 'n';
                break;

            case 3:
                choix = 's';
                break;

            case 4:
                choix = 'o';
                break;
        }
        colllision_check(choix);
        mouvement(newX, newY);
    }
}
