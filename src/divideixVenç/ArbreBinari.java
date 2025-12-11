package divideixVenç;

class ArbreBinari <E extends Comparable<E>> {

    private class NodeA {
        private E info;
        private NodeA esquerra;
        private NodeA dreta;

        private NodeA(E info) {
            this.info = info;
            this.esquerra = null;
            this.dreta = null;
        }
        @Override
        public String toString(){
            String res = this.info.toString()+"\n";
            if( this.esquerra != null) res += this.esquerra.toString();
            if( this.dreta != null) res += this.dreta.toString();
            return res;
        }
    }

    private NodeA arrel;

    public ArbreBinari() {
        arrel = null;
    }

    /**
     * Inserció bàsica per mantenir l’ordre segons compareTo
     */
    public void inserir(E elem) {
        arrel = inserirRec(arrel, elem);
    }

    private NodeA inserirRec(NodeA n, E elem) {
        if (n == null) return new NodeA(elem);
        if (elem.compareTo(n.info) < 0)
            n.esquerra = inserirRec(n.esquerra, elem);
        else
            n.dreta = inserirRec(n.dreta, elem);
        return n;
    }

    /**
     * TODO: Exercici 1: Retorna el valor màxim de l’arbre amb Divideix i Venç
     */
    public E trobaAreaPerAtacar() throws Exception {
        // Cal aplicar la tècnica del Divideix i Venç
        // Llança una excepció si l’arbre és buit
        // Es valorarà l’eficiència i l’ús correcte de la recursivitat

        // Si l'arrel es buida retorna l'excepció, sino retorna el mètode recursiu.
        if (arrel == null) {
            throw new Exception("L'arbre és buit");
        }
        return MaxValorRecursiuArbreBinari(arrel);
    }

    private E MaxValorRecursiuArbreBinari(NodeA node) {
        // Si el node es buit retorna null.
        if (node == null) {
            return null;
        }

        // Troba el valor màxim a l'esquerra i a la dreta
        E maximEsquerra = MaxValorRecursiuArbreBinari(node.esquerra);
        E maximDreta = MaxValorRecursiuArbreBinari(node.dreta);

        // Determina el màxim entre el node actual amb el valor màxim esquerra i dreta
        // Si esquerra o dreta té valor màxim major canvia el maximActual
        E maximActual = node.info;
        if (maximEsquerra != null && maximEsquerra.compareTo(maximActual) > 0) {
            maximActual = maximEsquerra;
        }
        if (maximDreta != null && maximDreta.compareTo(maximActual) > 0) {
            maximActual = maximDreta;
        }

        return maximActual;
    }

    @Override
    public String toString(){
        return this.arrel.toString();
    }
}