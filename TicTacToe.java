// método pra verificar a vez do jogador
// metodo pra verificar as formas de vencer e quem venceu
// método pra verificar qual lugar o jogador quer jogar (junto com um if pra verificar se o lugar está ocupado ou se está fora da matriz)
// método pra vefiricar se deu velha 

import java.util.Scanner;

public class TicTacToe {
    static char[][] tabuleiro = new char[3][3];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nomeJogador1;
        char simboloJogador1 = 'X';
        String nomeJogador2;
        char simboloJogador2 = 'O';

        
        while (true) {
            boolean vezDoJogador1 = true;
            inicializarTabuleiro();

            while (true) {

                imprimirTabuleiro();

                String nomeAtual;
                char simboloAtual;

                if (vezDoJogador1) {
                    nomeAtual = nomeJogador1;
                    simboloAtual = simboloJogador1;
                } else {
                    nomeAtual = nomeJogador2;
                    simboloAtual = simboloJogador2;
                }

                System.out.println(nomeAtual + " (" + simboloAtual + "), sua vez:");
                fazerJogada(simboloAtual);

                if (verificarVitoria(simboloAtual)) {
                    imprimirTabuleiro();
                    System.out.println(nomeAtual + " venceu!");

                    System.out.print("Deseja jogar novamente? (s/n): ");
                    String resposta = scanner.next().toLowerCase();

                    if (resposta.equals("s")) {
                        break;
                    } else {
                        System.out.println("Jogo encerrado.");
                        scanner.close();
                        return;
                    }
                }

                if (vezDoJogador1) {
                    vezDoJogador1 = false;
                } else {
                    vezDoJogador1 = true;
                }

                if (tabuleiroCheio()) {
                imprimirTabuleiro();
                System.out.println("Deu velha! Ninguem venceu.");

                System.out.print("Deseja jogar novamente? (s/n): ");
                String resposta = scanner.next().toLowerCase();

                if (resposta.equals("s")) {
                    break;
                } else {
                    System.out.println("Jogo encerrado.");
                    scanner.close();
                    return;
                }
            }
            }
        }
    }

    public static void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    public static void imprimirTabuleiro() {
        
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + tabuleiro[i][0] + " | " + tabuleiro[i][1] + " | " + tabuleiro[i][2]);
        }
        System.out.println();
    }

    public static void fazerJogada(char simbolo) {
        int linha, coluna;

        while (true) {
            System.out.print("Digite a linha (1 a 3): ");
            linha = scanner.nextInt() - 1;
            System.out.print("Digite a coluna (1 a 3): ");
            coluna = scanner.nextInt() - 1;

            if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3) {
                if (tabuleiro[linha][coluna] == ' ') {
                    tabuleiro[linha][coluna] = simbolo;
                    break;
                } else {
                    System.out.println("Essa posição já está ocupada!");
                }
            } else {
                System.out.println("Linha ou coluna inválida!");
            }
        }
    }

    public static boolean verificarVitoria(char simbolo) {
        for (int i = 0; i < 3; i++) {
            if ((tabuleiro[i][0] == simbolo && tabuleiro[i][1] == simbolo && tabuleiro[i][2] == simbolo) ||
                (tabuleiro[0][i] == simbolo && tabuleiro[1][i] == simbolo && tabuleiro[2][i] == simbolo)) {
                return true;
            }
        }

        if ((tabuleiro[0][0] == simbolo && tabuleiro[1][1] == simbolo && tabuleiro[2][2] == simbolo) ||
            (tabuleiro[0][2] == simbolo && tabuleiro[1][1] == simbolo && tabuleiro[2][0] == simbolo)) {
            return true;
        }

        return false;
    }

    public static boolean tabuleiroCheio() {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (tabuleiro[i][j] == ' ') {
                return false;
            }
        }
    }
    return true;
}

}
