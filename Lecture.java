/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture;

/**
 *
 * @author pierre
 */
public class Lecture {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Images i = new Images(4,4);
        i.affiche();
        System.out.println(" ");
        
        /*i.Lire("lena.pgm");
        i.affiche();*/
        
        /*i.agrandir();
        i.affiche();*/
        
        /*i.Réduire();
        i.affiche();*/
        
        /*i.setValeur(50, 1, 1);
        i.setValeur(200, 2, 2);
        i.affiche();
        System.out.println(" ");
        
        i.seuillage();
        i.affiche();*/
    }

}
