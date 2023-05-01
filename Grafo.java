import java.util.ArrayList;
import java.util.Stack;

public class Grafo<TIPO> {
    private ArrayList<Vertice<TIPO>> vertices;
    private ArrayList<Aresta<TIPO>> arestas;

    public Grafo(){
        this.vertices = new ArrayList<Vertice<TIPO>>();
        this.arestas = new ArrayList<Aresta<TIPO>>();
    }

    public void adicionarVertice(TIPO dado){
        Vertice<TIPO> novoVertice = new Vertice<TIPO>(dado);
        this.vertices.add(novoVertice);
    }

    public void adicionarAresta(Double peso, TIPO dadoInicio, TIPO dadoFim){
        Vertice<TIPO> inicio = this.getVertice(dadoInicio);
        Vertice<TIPO> fim = this.getVertice(dadoFim);
        Aresta<TIPO> aresta = new Aresta<TIPO>(peso, inicio, fim);
        inicio.adicionarArestaSaida(aresta);
        fim.adicionarArestaEntrada(aresta);
        this.arestas.add(aresta);
    }

    public Vertice<TIPO> getVertice(TIPO dado){
        Vertice<TIPO> vertice = null;
        for(int i=0; i < this.vertices.size(); i++){
            if (this.vertices.get(i).getDado().equals(dado)){
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }

    public void buscaEmLargura(){
        ArrayList<Vertice<TIPO>> marcados = new ArrayList<Vertice<TIPO>>();
        ArrayList<Vertice<TIPO>> fila = new ArrayList<Vertice<TIPO>>();
        Vertice<TIPO> atual = this.vertices.get(0);
        marcados.add(atual);
        System.out.println(atual.getDado());
        fila.add(atual);
        while(fila.size() > 0){
            Vertice<TIPO> visitado = fila.get(0);
            for(int i=0; i < visitado.getArestasSaida().size(); i++){
                Vertice<TIPO> proximo = visitado.getArestasSaida().get(i).getFim();
                if (!marcados.contains(proximo)){ //se o vértice ainda não foi marcado
                    marcados.add(proximo);
                    System.out.println(proximo.getDado());
                    fila.add(proximo);
                }
            }
            fila.remove(0);
        }
    }

    public ArrayList<Vertice<TIPO>> caminho(TIPO dadoA, TIPO dadoB){
        Vertice<TIPO> verticeA = this.getVertice(dadoA);
        Vertice<TIPO> verticeB = this.getVertice(dadoB);
        ArrayList<Vertice<TIPO>> visitados = new ArrayList<Vertice<TIPO>>();
        Stack<Vertice<TIPO>> pilha = new Stack<Vertice<TIPO>>();
        pilha.push(verticeA);
        visitados.add(verticeA);
        while (!pilha.isEmpty()){
            Vertice<TIPO> atual = pilha.peek();
            if (atual == verticeB){
                return new ArrayList<Vertice<TIPO>>(visitados);
            }
            boolean temAdjacenteNaoVisitado = false;
            for (Aresta<TIPO> aresta : atual.getArestasSaida()){
                Vertice<TIPO> adjacente = aresta.getFim();
                if (!visitados.contains(adjacente)){
                    visitados.add(adjacente);
                    pilha.push(adjacente);
                    temAdjacenteNaoVisitado = true;
                    break;
                }
            }
            if (!temAdjacenteNaoVisitado){
                pilha.pop();
            }
        }
        return null;
    }

    public Grafo<TIPO> uniao(Grafo<TIPO> outroGrafo) {
        Grafo<TIPO> novoGrafo = new Grafo<TIPO>();

        for (Vertice<TIPO> vertice : this.vertices) {
            novoGrafo.adicionarVertice(vertice.getDado());
        }

        for (Vertice<TIPO> vertice : outroGrafo.vertices) {
            novoGrafo.adicionarVertice(vertice.getDado());
        }

        for (Aresta<TIPO> aresta : this.arestas) {
            TIPO dadoInicio = aresta.getInicio().getDado();
            TIPO dadoFim = aresta.getFim().getDado();
            Double peso = aresta.getPeso();
            novoGrafo.adicionarAresta(peso, dadoInicio, dadoFim);
        }

        for (Aresta<TIPO> aresta : outroGrafo.arestas) {
            TIPO dadoInicio = aresta.getInicio().getDado();
            TIPO dadoFim = aresta.getFim().getDado();
            Double peso = aresta.getPeso();
            novoGrafo.adicionarAresta(peso, dadoInicio, dadoFim);
        }

        return novoGrafo;
    }

    public Grafo<TIPO> interseccao(Grafo<TIPO> outroGrafo) {
        Grafo<TIPO> novoGrafo = new Grafo<TIPO>();

        for (Vertice<TIPO> vertice : this.vertices) {
            if (outroGrafo.getVertice(vertice.getDado()) != null) {
                novoGrafo.adicionarVertice(vertice.getDado());
            }
        }

        for (Aresta<TIPO> aresta : this.arestas) {
            TIPO dadoInicio = aresta.getInicio().getDado();
            TIPO dadoFim = aresta.getFim().getDado();
            Double peso = aresta.getPeso();
            if (outroGrafo.getVertice(dadoInicio) != null && outroGrafo.getVertice(dadoFim) != null) {
                novoGrafo.adicionarAresta(peso, dadoInicio, dadoFim);
            }
        }

        return novoGrafo;
    }

}
