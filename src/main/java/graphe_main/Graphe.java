package graphe_main;

import java.util.*;
import java.util.stream.*;


public class Graphe {

    TreeMap<Integer, Set<Integer>> carte_graphe;

    // Méthode ClientGraphe, crée un tableau deux dimensions, ligne indice 0 = voisins indice 0
    public Graphe(int[][] deux_dimension) {
        carte_graphe = new TreeMap<>();
        for (int i = 0; i < deux_dimension.length; i++) {
            Set<Integer> voisins = new HashSet<>();
            for (int j = 0; j < deux_dimension[i].length; j++) {
                voisins.add(deux_dimension[i][j]);
            }
            carte_graphe.put(i, voisins);
        }
    }

    public Set<Integer> ensemble_sommet(){
        Set<Integer> set_ensemble_sommet = new HashSet<>();
        for (Map.Entry<Integer, Set<Integer>> entry : carte_graphe.entrySet()) {
            set_ensemble_sommet.add(entry.getKey());
        }
        return set_ensemble_sommet;
    }

    public int ordre_graphe(){
        int taille_ordre = 0;
        for (int i = 0; i < carte_graphe.size(); i ++){
            taille_ordre += 1;
        }
        return taille_ordre;
    }

    public int degres(Set voisins){
        return voisins.size();
    }


    public int taille(TreeMap carte_graphe){
        return carte_graphe.size()/2;
    }

    public int degre_minimal(TreeMap carte_graphe){
        int degre_min = 154674;
        for (int i = 0; i < carte_graphe.size(); i ++){
            for (int j = 0; j < carte_graphe.size(); j ++){
                 Set test = (Set) carte_graphe.get(i);
                 if (test.size() < degre_min){
                     degre_min = test.size();
                 }


            }

        }
        return degre_min;
    }

    public int degre_maximal(TreeMap carte_graphe){
        int degre_max = 0;
        for (int i = 0; i < carte_graphe.size(); i ++){
            for (int j = 0; j < carte_graphe.size(); j ++){
                Set test = (Set) carte_graphe.get(i);
                if (test.size() > degre_max){
                    degre_max = test.size();
                }


            }

        }
        return degre_max;
    }



    public String toString() {

        System.out.printf("ordre ; " + ordre_graphe() + "\n");
        System.out.println("taille ; " + taille(carte_graphe));
        System.out.println("degre minimal ; " + degre_minimal(carte_graphe));
        System.out.println("degre maximal ; " + degre_maximal(carte_graphe));
        for (int i = 0 ; i < carte_graphe.size(); i++) {
            System.out.println(("sommet : " + i + " degres : " + degres(carte_graphe.get(i)) + " voisins : "+  carte_graphe.get(i)));

        }
        return "";
    }
}


