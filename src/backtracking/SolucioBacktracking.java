package backtracking;

/* TODO: Exercici 3: implementació de l'esquema de backtracking
    - Recorda que és imprescindible respondre les preguntes al fitxer Exercici2_Analisis.txt
*/

public class SolucioBacktracking {

    // TODO: Exercici 3: afegir atributs necessaris segons l'anàlisi


    public SolucioBacktracking() {
        // TODO: Exercici 3: inicialitzar atributs necessaris

        // IMPORTANT: per les primeres proves recomano utilitzar false
        Node inici = Laberint.getLaberintPresentacio(true);

    }
    public static void main(String args[]) {
        SolucioBacktracking s = new SolucioBacktracking();
        // IMPORTANT: per les primeres proves recomano utilitzar esquema una solució
        s.backMillorSolucio(0);
        System.out.println(s);
    }
    // Recomanació: canvia els noms dels índexs al teu problema:
    //  - k és alçada de l'arbre
    //  - i és amplada de l'arbre


    /* esquema recursiu que troba una solució
     * utilitzem una variable booleana (que retornem)
     * per aturar el recorregut quan haguem trobat una solució
     */
    public boolean backUnaSolucio(int k) {
        boolean trobada = false;
        int amplada = 0; // TODO: assignar l'amplada correcta de l'arbre
        // iterem sobre l'amplada de l'arbre
        for(int i = 0; i < amplada && !trobada; i++) {
            //mirem si l'element i es pot assignar a k
            if(this.acceptable(k,i)) {
                //posem l'element a la solució actual
                this.anotarASolucio(k,i);

                if(this.esSolucio(k,i)) { // és solució?
                    return true; // hem trobat una solució
                } else {
                    // TODO: if podem podar?
                    trobada = this.backUnaSolucio(k + 1); //baixem al següent nivell de l'arbre
                }
                if(!trobada)
                    // esborrem l'actual, per després posar-la a una altra
                    this.desanotarDeSolucio(k,i);
            }
        }
        return trobada;
    }

    /* Esquema recursiu que busca totes les solucions
     * no cal utilitzar una variable booleana per aturar perquè busquem totes les solucions
     * cal guardar una COPIA de la millor solució a una variable
     */
    public void backMillorSolucio(int k) {
        int amplada = 0; // TODO: assignar l'amplada correcta de l'arbre
        // iterem sobre l'amplada de l'arbre
        for(int i = 0; i < amplada; i++) {
            //mirem si l'element i es pot assignar a k
            if(this.acceptable(k, i)) {
                //posem l'element a la solució actual
                this.anotarASolucio(k, i);

                if (this.esSolucio(k,i)) { // és solució?
                    if( this.esMillor())
                        this.guardarMillorSolucio();
                } else {
                    // TODO: if podem podar?
                    this.backMillorSolucio(k + 1);//baixem al següent nivell de l'arbre
                }
                // esborrem l'element actual i fem backtracking
                this.desanotarDeSolucio(k, i);
            }
        }
    }

    private boolean acceptable(int k, int i) {
        // TODO: Exercici 3: implementar la comprovació dels criteris d'acceptabilitat
        return false;
    }

    private void anotarASolucio(int k, int i) {
        // TODO: Exercici 3: assigna l'element i a la solució a la posició k
    }

    private void desanotarDeSolucio(int k, int i) {
        // TODO: Exercici 3: elimina l'assignació de l'element i a la solució a la posició k
    }

    private boolean esSolucio(int k, int i) {
        // TODO: Exercici 3: comprova si s'ha arribat a una solució completa
        return false;
    }

    private boolean esMillor() {
        // TODO: Exercici 3: comprova si la solució actual és millor que la millor solució trobada fins ara
        return false;
    }

    private void guardarMillorSolucio() {
        // TODO: Exercici 3: guarda una copia de la solució actual com la millor solució trobada fins ara
    }

    public String toString() {
        // TODO: Exercici 3: retorna un string amb la representació de la millor solució
        return "";
    }

}
