import java.util.*;

public class Arvore {
    private Node raiz;
    private int totalPalavras = 0;

    private class Node {
        Palavra palavra;
        Node esquerda, direita;

        public Node(Palavra palavra) {
            this.palavra = palavra;
        }
    }

    public void insere(Palavra palavra) {
        raiz = insere(raiz, palavra);
    }

    private Node insere(Node x, Palavra palavra) {
        if (x == null) {
            totalPalavras++;
            return new Node(palavra);
        }
        int cmp = palavra.getPalavra().compareToIgnoreCase(x.palavra.getPalavra());
        if      (cmp < 0) x.esquerda  = insere(x.esquerda, palavra);
        else if (cmp > 0) x.direita = insere(x.direita, palavra);
        else              x.palavra.incrementaOcorrencias();
        return x;
    }

    public int getTotalPalavras() {
        return totalPalavras;
    }

    public Palavra busca(String palavra) {
        return busca(raiz, palavra);
    }

    private Palavra busca(Node x, String palavra) {
        if (x == null) return null;
        int cmp = palavra.compareToIgnoreCase(x.palavra.getPalavra());
        if      (cmp < 0) return busca(x.esquerda, palavra);
        else if (cmp > 0) return busca(x.direita, palavra);
        else              return x.palavra;
    }

    public void exibe() {
        exibe(raiz);
    }

    private void exibe(Node x) {
        if (x == null) return;
        exibe(x.esquerda);
        System.out.println(x.palavra.getPalavra() + ": " + x.palavra.getOcorrencias());
        exibe(x.direita);
    }
}
