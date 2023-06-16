import java.util.ArrayList;

public class ExemploGrafo {

    public static void main(String[] args) {
        Grafo<String> g1 = new Grafo<String>();
        g1.adicionarVertice("A");
        g1.adicionarVertice("B");
        g1.adicionarVertice("C");
        g1.adicionarVertice("D");
        g1.adicionarAresta(1.0, "A", "B");
        g1.adicionarAresta(2.0, "B", "C");
        g1.adicionarAresta(3.0, "C", "D");

        Grafo<String> g2 = new Grafo<String>();
        g2.adicionarVertice("A");
        g2.adicionarVertice("D");
        g2.adicionarVertice("E");
        g2.adicionarVertice("F");
        g2.adicionarAresta(2.0, "A", "D");
        g2.adicionarAresta(1.5, "D", "E");
        g2.adicionarAresta(1.0, "E", "F");

        ArrayList<Vertice<String>> caminhoAB = g1.caminho("A", "B");
        System.out.print("Caminho de A a B: ");
        for (Vertice<String> v : caminhoAB) {
            System.out.print(v.getDado() + " ");
        }
        System.out.println();

        Grafo<String> uniaoG1G2 = g1.uniao(g2);
        System.out.println("União de g1 e g2:");
        uniaoG1G2.buscaEmLargura();

        Grafo<String> interseccaoG1G2 = g1.interseccao(g2);
        System.out.println("Intersecção de g1 e g2:");
        interseccaoG1G2.buscaEmLargura();

        ArrayList<Vertice<String>> caminhoBFSG1 = g1.buscaEmLargura("A", "D");
        System.out.print("Caminho de A a D usando BFS: ");
        if (caminhoBFSG1 != null) {
            for (Vertice<String> v : caminhoBFSG1) {
                System.out.print(v.getDado() + " ");
            }
        } else {
            System.out.println("Caminho não encontrado.");
        }
        System.out.println();
    }
}
