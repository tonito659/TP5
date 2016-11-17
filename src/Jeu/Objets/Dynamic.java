package Jeu.Objets;

/**
 * Created by Antoine on 17/11/2016.
 */
public class Dynamic {
    static int X = 0, Y = 0, newY = 0, newX = 0;
    static char name;

    static void mouvement(int newX, int newY) {
        // On fait bouger notre objet !
        X = newX;
        Y = newY;

    }

    static void colllision_check(char choix) {
        boolean erreur = false;
        while (erreur != true) {

            erreur = false;
            switch (choix) {
                case 'e':
                    if (newX >= 0 && newX <= 9) {
                        newX = X + 1;
                    } else {
                        erreur = true;
                    }
                    break;
                case 'o':
                    if (newX >= 0 && newX <= 9) {
                        newX = X - 1;
                    } else {
                        erreur = true;
                    }
                    break;
                case 'n':
                    if (newY >= 0 && newY <= 9) {
                        newY = Y - 1;
                    } else {
                        erreur = true;
                    }
                    break;
                case 's':
                    if (newY >= 0 && newY <= 9) {
                        newY = Y + 1;
                    } else {
                        erreur = true;
                    }
                    break;
            }
        }
    }
}