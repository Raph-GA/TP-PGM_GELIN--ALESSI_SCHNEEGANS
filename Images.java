/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture;

import java.io.*;
import java.util.StringTokenizer;

/**
 *
 * @author pierre
 */
public class Images {

    int hauteur;
    int largeur;
    int image[][];

    public Images(int h, int l) {
        this.hauteur = h;
        this.largeur = l;
        int[][] i = new int[h][l];
        this.image = i;
    }

    /*
    Permet de modifier une valeur du tableau formant l'image
    */
    public void setValeur(int v,int i, int j) {
        if (i <= this.hauteur && j <= this.largeur) {
            this.image[i][j]=v;
        }
        else{
            System.out.println("hors champ");
        }
    }

    public void affiche() {
        int i;
        int j;
        for (i = 0; i < this.hauteur; i++) {
            System.out.println(" ");
            for (j = 0; j < this.largeur; j++) {
                System.out.print(this.image[i][j] + " ");
            }
        }
    }

    public void Lire(String f) {
        String fichier = f;

        //lecture du fichier texte	
        try {

            InputStream ips = new FileInputStream(fichier);
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader br = new BufferedReader(ipsr);
            String ligne;
            ligne = br.readLine();

            //on prend en charge les quatre premières ligne du pgm
            ligne = br.readLine();
            ligne = br.readLine();
            // on lit la longueur et la largeur de l'image en ligne 3
            StringTokenizer tok = new StringTokenizer(ligne, " ");
            //on stock la longueur
            String chaine = tok.nextToken();
            int i = Integer.parseInt(chaine);
            //on stock la largeur
            chaine = tok.nextToken();
            int j = Integer.parseInt(chaine);
            //on créer une image
            Images tab = new Images(i, j);

            ligne = br.readLine();

            int l = 0;
            while (ligne != null) {
                try {
                    chaine = tok.nextToken();
                } catch (Exception NoSuchElementException) {
                    chaine = null;
                }
                int k = 0;
                // on va obtenir le tableau correspondant à l'image
                while (chaine != null) {
                    tab.image[l][k] = Integer.parseInt(chaine);
                    k++;
                    try {
                        chaine = tok.nextToken();
                    } catch (Exception NoSuchElementException) {
                        chaine = null;
                    }

                }
                ligne = br.readLine();
                l++;
            }
            //on met à jour l'image appelée
            this.hauteur = tab.hauteur;
            this.largeur = tab.largeur;
            this.image = tab.image;

            br.close();//on ferme le fichier

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    /*fonction permettant d'agrandir une image, l'image obtenue est 4 fois
     plus grande. (hauteur *2 et largeur * 2)
     */
    public void agrandir() {
        int h = this.hauteur;
        int l = this.largeur;

        Images oupoup = new Images(2 * h, 2 * l);

        for (int i = 0; i < this.hauteur; i++) {
            for (int j = 0; j < this.largeur; j++) {
                oupoup.image[2 * i + 1][2 * j] = this.image[i][j];
                oupoup.image[2 * i][2 * j + 1] = this.image[i][j];
                oupoup.image[2 * i][2 * j] = this.image[i][j];
                oupoup.image[2 * i + 1][2 * j + 1] = this.image[i][j];
            }
        }
        this.hauteur = 2 * h;
        this.largeur = 2 * l;
        this.image = oupoup.image;
    }

    /*fonction permettant de réduire une image, l'image obtenue est 4 fois
     plus petite. (hauteur/2 et largeur/2)
     */
    public void Réduire() {
        int h = this.hauteur / 2;
        int l = this.largeur / 2;

        Images oupoup = new Images(h, l);

        for (int i = 0; i < h / 2; i++) {
            for (int j = 0; j < l / 2; j++) {
                oupoup.image[i][j] = this.image[2 * i][2 * j];

            }
        }
        this.hauteur = oupoup.hauteur;
        this.largeur = oupoup.largeur;
        this.image = oupoup.image;
    }

    /*transforme une image en nuance de gris en une image de 2 couleurs noir et blanc
     *
     */
    public void seuillage() {
        for (int i = 0; i < this.hauteur; i++) {
            for (int j = 0; j < this.largeur; j++) {
                if (this.image[i][j] < 123) {
                    this.image[i][j] = 0;
                } else {
                    this.image[i][j] = 255;
                }
            }
        }
    }
}
