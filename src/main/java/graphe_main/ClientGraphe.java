package graphe_main;

public class ClientGraphe {
    public static void main (String [] args) {
        int [] [] tabVoisins = {
                {1, 2, 4},
                {0, 2 },
                {0, 1, 3, 4},
                { 2, 4},
                { 0, 2, 3}
        };
        Graphe g1 = new Graphe(tabVoisins);
        System.out.println(g1);
    }
}