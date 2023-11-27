// Natan Angelotti - 32237308
// Isabella Akemi - 42209791
import java.io.*;
import java.util.*;

public class Spotify {
    public static void main(String[] args) throws IOException {
        Arvore arvore = new Arvore();
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;
        while (!sair) {
            System.out.println("1- Carregar o texto");
            System.out.println("2- Contador de palavras");
            System.out.println("3- Busca por palavra");
            System.out.println("4- Exibição do texto");
            System.out.println("5- Encerrar");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    try (BufferedReader br = new BufferedReader(new FileReader("musica.txt"))) {
                        String linha;
                        while ((linha = br.readLine()) != null) {
                            for (String palavra : linha.split("\\W+")) {
                                arvore.insere(new Palavra(palavra.toLowerCase()));
                            }
                        }
                        System.out.println("TEXTO CARREGADO");
                    } catch (IOException e) {
                        System.out.println("Ocorreu um erro ao ler o arquivo musica.txt. Por favor, verifique se o arquivo existe e está no diretório correto.");
                    }
                    break;
                case 2:
                    System.out.println("Número total de palavras no texto: " + arvore.getTotalPalavras());
                    break;
                case 3:
                    System.out.println("Digite a palavra que deseja buscar:");
                    String palavraBusca = scanner.next();
                    Palavra palavraEncontrada = arvore.busca(palavraBusca);
                    if (palavraEncontrada != null) {
                        System.out.println("A palavra '" + palavraBusca + "' foi encontrada " + palavraEncontrada.getOcorrencias() + " vez(es).");
                    } else {
                        System.out.println("A palavra '" + palavraBusca + "' não foi encontrada no texto.");
                    }
                    break;
                case 4:
                    arvore.exibe();
                    break;
                case 5:
                    sair = true;
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                System.out.println("Opção inválida. Por favor, escolha uma opção entre 1 e 5.");
            }
        }
        scanner.close();
    }
}
