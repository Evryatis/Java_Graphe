package graphe_main;

import java.util.*;

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

    static Set<Integer> grapheComplet(int n){



    }

    public String toString() {
        String to_string = "" + carte_graphe;
        System.out.printf("ordre ; " + ordre_graphe() + "\n");
        for (int i = 0 ; i < carte_graphe.size(); i++) {
           return("sommet ; " + i + " " + to_string);
        }
        return "";
    }
}


