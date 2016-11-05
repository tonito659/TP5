package Jeu.Labyrinthe;

import java.util.Random;

public class GenerateurLabyrinthe {

	//Classe interne représentant une case libre, utilisée pour la génération du labyrinthe
    private static class Cell {
        boolean north=false,
                south=false,
                east=false,
                west=false,
                visited =false;

    }
    static Random random = new Random(System.currentTimeMillis());

    /**
     * Génére un labyrinthe de 9x9 cases, contenant 16 cases libres
     */

    public static boolean[][] generer() {
     return   generer(4,4);
    }

    /**
     * Renvoie un tableau de (largeur * 2) +1 et (longueur * 2) +1 booléens
     * true represente une case libre
     * false représente un mur
     * @param largeur
     * @param longueur
     * @return
     */
    private static boolean [][] generer(int largeur, int longueur)
    {
        Cell [][] laby = new Cell[largeur][longueur];
        for(int i=0;i<laby.length;i++)
            for (int j=0;j<laby[i].length;j++)
                laby[i][j]=new Cell();

        int startX = random.nextInt(largeur);
        int startY = random.nextInt(longueur);
        creuser(startX,startY,laby);
        return toBoolean(laby);

    }
    /**
     * Fait un labyrinthe aléatoirement
     * @param x
     * @param y
     * @param laby
     */
    private static void creuser(int x, int y, Cell [][] laby)
    {
        if(x < 0 || y < 0 || x >= laby.length || y >=laby[0].length) {
            return;
        } else if(laby[x][y]==null) {
            laby[x][y] = new Cell();
        }

        if (!laby[x][y].visited)
        {

            if (!laby[x][y].west && random.nextBoolean()) {
                laby[x][y].west = true;
                creuser(x,y-1, laby);
            }
            if (!laby[x][y].east && random.nextBoolean()) {
                laby[x][y].east = true;
                creuser(x,y+1, laby);
            }
            if (!laby[x][y].north && random.nextBoolean()) {
                laby[x][y].north = true;
                creuser(x-1,y, laby);
            }
            if (!laby[x][y].south && random.nextBoolean()) {
               laby[x][y].south = true;
                creuser(x+1,y, laby);
            }
            laby[x][y].visited = true;
        }
    }

   public static boolean [][] toBoolean(Cell [][] array) {
        boolean [][] out = new boolean[(array.length*2)+1][(array[0].length*2)+1];

        for(int i=0;i<array.length;i++)
        {
            for(int j=0;j < array[i].length;j++)
            {
                int x = (i*2)+1, y = (j*2)+1;
                out[x][y] = true;
                if(array[i][j].west) out[x][y-1] = true;
                if(array[i][j].east) out[x][y+1] = true;
                if(array[i][j].south) out[x+1][y] = true;
                if(array[i][j].north) out[x-1][y] = true;
            }
        }
       return out;
    }
    public static void printLabyrinthe(boolean [][] laby) {

        StringBuilder sb = new StringBuilder();
        for(int i =0;i<laby.length;i++) {
            for(int j=0;j<laby.length;j++)
                sb.append(laby[i][j] ? " "   : "#");
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }
    public static void main(String [] args) {

        printLabyrinthe(generer());
    }
}

