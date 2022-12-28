/**
 travail fait par mohamed mehdi lakhdhar le 18/05/2022 
*/
package exercice1;

import java.util.Scanner;

public class Exercice1 {

    /**
     * Cette fonction prend un tableau de Strings en paramètre et retourne un
     * nouveau tableau contenant les mêmes éléments, avec une case disponible de
     * plus.
     */
    public static String[] agrandirTab(String[] tab) {
        String[] tab2 = new String[tab.length + 1];
        return tab2;
    }

    /**
     * Cette fonction lit des mots sur la ligne de commande et les retourne dans
     * un tableau de Strings. Chaque "mot" est définit comme une ligne complète,
     * du début de la ligne entrée jusqu'au prochain \n.
     */
    public static String[] lireMots() {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        boolean test = false;
        String[] tab = new String[1000];
        String s ;
        while (!test){
            s = sc.next();
            test = s.compareToIgnoreCase("stop") == 0;
            if(!test){
                tab[i++] = s;
            }
            
        }
        return removeNull(tab);

    }

    /**
     * Cette fonction prend en paramètre un tableau de mots et retourne un
     * nouveau tableau contenant ces mots triés en ordre croissant.
     */
    public static String[] trier(String[] mots) {
         
    
        String copy ;
        for (int i = 0 ; i < mots.length-1 ; i++){
            for (int j = i + 1 ; i < mots.length ; i++){
                   if (mots[i].compareTo(mots[j]) < 0 ){
                       copy = mots[i];
                       mots[i] = mots[j];
                       mots[j] = copy;
                }
            }
        }
        return mots;
        
    }

    /**
     * Cette fonction prend en paramètre un tableau de mots trié et retourne un
     * nouveau tableau où chaque mot est unique (tous les doublons sont
     * retirés).
     */
    public static String[]  retirerDoublons(String[] mots) {
        for(int s=0;s<mots.length-1;s++){
            for(int m=s + 1;m<mots.length;m++){
                if(mots[s] != null && mots[s].equals(mots[m]))
                {
                  // array = ArrayUtils.removeElement(array, array[s]); --m;??
                  mots[m] = null; // Mark for deletion later on
                }
    } 
} 
       
        return removeNull(mots);
   
    
    }
    /**
     * retirer les champs null d'un tableau
     */
    public static void main(String[] args) {
        for (String string : retirerDoublons(trier(lireMots()))) {
            System.out.println(string);   
        }
        
    }

    private static String[] removeNull(String[] tab) {
        String[] proxyArray = null; 
        int nb_null = 0;
        for(int i=0;i<tab.length;i++){
            if(tab[i] == null){
                nb_null ++;
            }
        }
        
        proxyArray = new String[tab.length - nb_null];
       for(int i=0,k = 0;i<tab.length;i++){
            if(tab[i] == null){
                continue;
            }
            proxyArray[k++] = tab[i];
        } 
       return proxyArray;
    }
}
