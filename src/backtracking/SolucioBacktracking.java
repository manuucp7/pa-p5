package backtracking;

public class SolucioBacktracking {

    private Node inici; // Node inicial del laberint
    private Node[] camiActual; // Camí que s’està explorant actualment
    private Node[] millorCami; // Millor camí trobat fins ara
    private int k; // Nivell actual en l’arbre de cerca
    private int millorLongitud; // Longitud del millor camí trobat
    private int costActual; // Cost acumulat del camí actual
    private int millorCost; // Cost del millor camí trobat

    // Constructor per inicialitzar els atributs i el laberint
    public SolucioBacktracking() {
        this.inici = Laberint.getLaberintPresentacio(false);
        int max = 1000; // Mida màxima del camí
        this.camiActual = new Node[max];
        this.millorCami = new Node[max];
        this.k = 0;
        camiActual[0] = inici;
        this.costActual = inici.cost;
        this.millorCost = Integer.MAX_VALUE;
        this.millorLongitud = 0;
    }

    // Mètode principal per trobar la millor solució
    public static void main(String[] args) {
        SolucioBacktracking s = new SolucioBacktracking();
        s.backMillorSolucio(0);
        System.out.println(s);
    }

    // Cerca la millor solució amb backtracking
    public void backMillorSolucio(int k) {
        int amplada = 4; // Nombre màxim de direccions possibles
        for (int i = 0; i < amplada; i++) {
            if (this.acceptable(k, i)) {
                this.anotarASolucio(k, i);
                if (this.esSolucio(k, i)) {
                    if (this.esMillor()) this.guardarMillorSolucio();
                } else {
                    if (costActual < millorCost) {
                        this.backMillorSolucio(k + 1);
                    }
                }
                this.desanotarDeSolucio();
            }
        }
    }

    // Comprova si un node és acceptable
    private boolean acceptable(int k, int i) {
        Node actual = camiActual[k];
        Node seguent = null;
        if (i == 0) seguent = actual.amunt;
        else if (i == 1) seguent = actual.avall;
        else if (i == 2) seguent = actual.esquerra;
        else if (i == 3) seguent = actual.dreta;
        return seguent != null && !jaVisitada(seguent);
    }

    // Marca un node com a part del camí actual
    private void anotarASolucio(int k, int i) {
        Node actual = camiActual[k];
        Node seguent = null;
        if (i == 0) seguent = actual.amunt;
        else if (i == 1) seguent = actual.avall;
        else if (i == 2) seguent = actual.esquerra;
        else if (i == 3) seguent = actual.dreta;
        this.k++;
        camiActual[this.k] = seguent;
        costActual += seguent.cost;
        seguent.visitat = true;
    }

    // Desmarca un node del camí actual
    private void desanotarDeSolucio() {
        Node eliminat = camiActual[this.k];
        costActual -= eliminat.cost;
        eliminat.visitat = false;
        this.k--;
    }

    // Comprova si s’ha arribat a una solució
    private boolean esSolucio(int k, int i) {
        Node actual = camiActual[k];
        Node seguent = null;
        if (i == 0) seguent = actual.amunt;
        else if (i == 1) seguent = actual.avall;
        else if (i == 2) seguent = actual.esquerra;
        else if (i == 3) seguent = actual.dreta;
        return seguent != null && seguent.sortida;
    }

    // Comprova si el camí actual és millor que el millor trobat
    private boolean esMillor() {
        return costActual < millorCost;
    }

    // Guarda el camí actual com el millor camí trobat
    private void guardarMillorSolucio() {
        millorCost = costActual;
        millorLongitud = k;
        for (int i = 0; i <= k; i++) {
            millorCami[i] = camiActual[i];
        }
    }

    // Comprova si un node ja ha estat visitat
    private boolean jaVisitada(Node n) {
        for (int i = 0; i <= k; i++) {
            if (camiActual[i] == n) return true;
        }
        return false;
    }

    // Retorna una representació en text del millor camí trobat
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Millor cost: ").append(millorCost).append("\n");
        sb.append("Millor camí:\n");
        for (int i = 0; i <= millorLongitud; i++) {
            Node n = millorCami[i];
            sb.append(n.nom).append(" (cost ").append(n.cost).append(")\n");
        }
        return sb.toString();
    }
}
