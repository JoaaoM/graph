# graph
Graph - UNAERP
Introdução
Este é um código em Java que implementa um grafo utilizando a estratégia de matriz de adjacência. Um grafo é uma estrutura de dados composta por vértices e arestas, onde os vértices representam os elementos do grafo e as arestas representam as conexões entre eles.

A matriz de adjacência é uma representação de grafo em que cada vértice é associado a uma linha e uma coluna em uma matriz, e a presença de uma aresta é indicada pelo valor na intersecção da linha e coluna correspondentes.

Funcionalidades
O código implementa as seguintes funcionalidades básicas:

addEdge: adiciona uma aresta entre dois vértices com um peso especificado.
removeEdge: remove uma aresta entre dois vértices.
isAdjacent: verifica se dois vértices são adjacentes, ou seja, se há uma aresta conectando-os.
getNeighbors: retorna uma lista dos vizinhos de um vértice, ou seja, os vértices que são conectados a ele por uma aresta.
addVertex: adiciona um novo vértice ao grafo.
removeVertex: remove um vértice do grafo.
getVertexValue: retorna o valor associado a um vértice.
setVertexValue: define o valor associado a um vértice.
getEdgeValue: retorna o valor associado a uma aresta.
setEdgeValue: define o valor associado a uma aresta.
Uso
Para utilizar o código, basta instanciar um objeto da classe Graph, especificando o número de vértices no grafo. Em seguida, as funcionalidades descritas acima podem ser utilizadas chamando os respectivos métodos.

Por exemplo, para adicionar uma aresta entre o vértice 0 e o vértice 1 com peso 2, basta chamar o método addEdge:

java
Copy code
Graph g = new Graph(3);
g.addEdge(0, 1, 2);
Para obter a lista de vizinhos do vértice 0, basta chamar o método getNeighbors:

java
Copy code
List<Integer> neighbors = g.getNeighbors(0);
Conclusão
Este código implementa um grafo utilizando a estratégia de matriz de adjacência em Java, oferecendo diversas funcionalidades básicas para manipulação de vértices e arestas. É uma implementação simples e eficiente, que pode ser útil em diversas aplicações que envolvem grafos.
