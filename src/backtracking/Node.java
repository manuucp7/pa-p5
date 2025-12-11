package backtracking;

// Aquesta classe es pot MODIFICAR i afeir ATRIBUTS
// Aquesta classe representa una cel·la del laberint
public class Node {
    String nom;             // Nom del node (guardem la posició, simplement per observar les solucions)
    int cost;              // 0: lliure, 1: trampa, 2: enemic
    boolean sortida;       // Indica si aquest node és la sortida del laberint
    Node amunt, avall, esquerra, dreta;  // Connexions amb nodes veïns

    public Node(String nom, int cost, boolean sortida) {
        this.nom = nom;
        this.cost = cost;
        this.sortida = sortida;
        this.amunt = null;
        this.avall = null;
        this.esquerra = null;
        this.dreta = null;
    }

    @Override
    public String toString() {
        String aux = this.nom + " ";
        if( sortida ) aux = "Sortida ";
        switch (cost) {
            case 0: return aux+"Via lliure";
            case 1: return aux+"Trampa";
            case 2: return aux+"Enemic";
            default: return aux;
        }
    }
}