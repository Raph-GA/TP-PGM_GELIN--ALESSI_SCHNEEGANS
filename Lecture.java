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
        Images i = new Images(20,20);
        i.affiche();
        i.Lire("lena.pgm");
        i.affiche();
        
    }

}
