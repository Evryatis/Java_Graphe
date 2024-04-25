package graphe_main;

import javafx.util.Pair;

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

    /*
    Fonctions algorithmiques
     */


    /*
    Fonction algorithmique parcoursEnLargeur ;
    prend en paramètre le sommet de départ,renvoie le dictionnaire des prédécesseurs dans lequel :
        > chaque clef est un sommet
        > chaque valeur est un couple contenant :
    ? le sommet précédent dans le plus court chemin qui va du sommet de départ au sommet clef
    ? la distance la plus courte pour atteindre ce sommet pour atteindre le sommet cle
     */
    public TreeMap<Integer, Set<Integer>> parcoursEnLargeur(int sommet_depart){

        // On crée le dictionnaire a renvoyer
        TreeMap<Integer, Set<Integer>> dict_predec = new TreeMap<>();

        // On crée la liste des elements
        ArrayList<Integer> liste_attente = new ArrayList<Integer>();
        liste_attente.add(sommet_depart);
        while (! liste_attente.isEmpty()) {
            int nettoyage = liste_attente.remove(0);
            for (Integer sommet : this.carte_graphe.get(nettoyage))
                if (! dict_predec.containsKey(sommet)) {
                    dict_predec.put(sommet, (Set<Integer>) new Pair(nettoyage, dict_predec.get(nettoyage)));
                    liste_attente.add(sommet);
                }
        }

        return dict_predec;


    }

    public List <Integer> plusCourtChemin(int depart, int arrivee){

        TreeMap<Integer, Set<Integer>> predeccesseurs = parcoursEnLargeur(depart);

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


