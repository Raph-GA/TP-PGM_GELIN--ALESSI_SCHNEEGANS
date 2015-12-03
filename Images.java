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
                chaine = tok.nextToken();
                int k = 0;
                // on va obtenir le tableau correspondant à l'image
                while (chaine != null) {
                    tab.image[l][k] = Integer.parseInt(chaine);
                    k++;
                    try{
                        chaine = tok.nextToken();
                    }catch(Exception NoSuchElementException){
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
}
