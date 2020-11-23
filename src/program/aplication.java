package program;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class aplication {

    // Declaração do Scanner para escopo global.
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int X[];
        int i, j, n, eleito, atual, pos;

        System.out.print("DIGITE A QUANTIDADE DE NUMEROS A SEREM LIDOS: ");
        n = sc.nextInt();

        // Criação de um vetor com um tamanho informado pelo usuário.
        X = new int[n];

        clearScreen();

        //  Popula o vetor com valores informados pelo usuário.        
        for (i = 0; i < n; i++) {
            System.out.print("INSIRA O " + (i + 1) + "° VALOR: ");
            X[i] = sc.nextInt();
        }

        // Chama a função para mostrar a atual situação do vetor
        mostraVetor(X);
        sc.nextLine();

        // cria um loop para ordenar de forma cresente o vetor 
        for (i = 0; i < (X.length - 1); i++) {
            // elege do primeiro até o penultimo elemento do vetor para ser copiado para a variável eleito
            eleito = X[i];
            mostraVetor(X, eleito);
            System.out.print("eleito: " + eleito);
            sc.nextLine();

            /* 
                Captura de um criterio de comparação inicial com o elemento a direita do eleito            
             */
            atual = X[i + 1];
            System.out.println("Atual: " + atual);

            /* 
            Captura da posição do vetor onde o atual valor está           
             */
            pos = i + 1;
            System.out.print("Posição: " + pos);
            sc.nextLine();
            clearScreen();
            mostraVetor(X, eleito, atual);
            /* 
            Seleciona o segundo elemento a direita do "eleito" e cria
            um loop até o ultimo elemento a direita testando-os se são atuales
            ao valor de referencia capturado acima.
             */
            for (j = i + 2; j < X.length; j++) {
                clearScreen();
                mostraVetor(X, eleito, atual, X[j]);
                /*
                Caso o valor seja atual em ralação ao da variavel "atual" é substituido pelo valor encontrado
                atualizando o atual valor encontrado a direita
                 */
                System.out.println("Comparando o valor: " + atual
                        + " com o valor: " + X[j]);
                if (X[j] < atual) {
                    atual = X[j];
                    pos = j;
                    System.out.println("Valor menor encontrado");
                    System.out.println("Atualizando o valor da variavel atual...");
                    System.out.println("Menor: " + atual);
                    System.out.println("Posição: " + pos);
                    sc.nextLine();
                } else {
                    System.out.println("O valor " + atual + " é menor");
                    System.out.println("então o valor de " + atual + " é mantido na variavel \"atual\"...");
                    sc.nextLine();
                }

                clearScreen();
                mostraVetor(X, eleito, atual);
            }
            System.out.println("Agora será compara do valor eleito ao valor Atual");
            sc.nextLine();
            
            if (atual < eleito) {
                System.out.println(ANSI_GREEN + "Valor de \"eleito\" é MAIOR do que o valor de \"atual\"");
                System.out.println(ANSI_GREEN + " então as posições são trocadas...");
                X[i] = X[pos];
                X[pos] = eleito;
                sc.nextLine();
            } else {
                System.out.println(ANSI_YELLOW + "O valor de \"eleito\" é MENOR do que o valor de \"atual\"");
                System.out.println(ANSI_YELLOW + " então as posições são mantidas...");
                sc.nextLine();
            }
            System.out.println("");
            mostraVetor(X);
        }

    }

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_RESET_BACKGROUND = "\u001B[0m";

    public static void clearScreen() {
        try {
            Robot robot = new Robot();

            robot.setAutoDelay(5);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_L);

            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_L);

        } catch (Exception e) {
            System.out.println("ERROR - " + e);
        }
    }

    public static void mostraVetor(int[] vetor) {
        clearScreen();
        System.out.println("--- SITUAÇÃO DO VETOR ---");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("[" + vetor[i] + "]");
        }
        System.out.println("");

        sc.nextLine();
    }

    public static void mostraVetor(int[] vetor, int eleito) {
        clearScreen();
        System.out.println("--- SITUAÇÃO DO VETOR ---");
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == eleito) {
                System.out.print("[" + ANSI_BLUE_BACKGROUND + vetor[i] + ANSI_RESET_BACKGROUND + "]");
            } else {
                System.out.print("[" + vetor[i] + "]");
            }
        }
        System.out.println("");
        System.out.println("");
        System.out.print("[" + ANSI_BLUE_BACKGROUND + "-" + ANSI_RESET_BACKGROUND + "] --> ELEITO");

        sc.nextLine();
    }

    public static void mostraVetor(int[] vetor, int eleito, int atual) {
        clearScreen();
        System.out.println("--- SITUAÇÃO DO VETOR ---");
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == eleito) {
                System.out.print("[" + ANSI_BLUE_BACKGROUND + vetor[i] + ANSI_RESET_BACKGROUND + "]");
            } else if (atual == vetor[i]) {
                System.out.print("[" + ANSI_RED_BACKGROUND + vetor[i] + ANSI_RESET_BACKGROUND + "]");
            } else {
                System.out.print("[" + vetor[i] + "]");
            }
        }
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("[" + ANSI_BLUE_BACKGROUND + "-" + ANSI_RESET_BACKGROUND + "] --> ELEITO");
        System.out.println("[" + ANSI_RED_BACKGROUND + "-" + ANSI_RESET_BACKGROUND + "] --> ATUAL");

        sc.nextLine();
    }

    public static void mostraVetor(int[] vetor, int eleito, int atual, int comparação) {
        clearScreen();
        System.out.println("--- SITUAÇÃO DO VETOR ---");
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == eleito) {
                System.out.print("[" + ANSI_BLUE_BACKGROUND + vetor[i] + ANSI_RESET_BACKGROUND + "]");
            } else if (atual == vetor[i]) {
                System.out.print("[" + ANSI_RED_BACKGROUND + vetor[i] + ANSI_RESET_BACKGROUND + "]");
            } else if (vetor[i] == comparação) {
                System.out.print("[" + ANSI_PURPLE_BACKGROUND + vetor[i] + ANSI_RESET_BACKGROUND + "]");
            } else {
                System.out.print("[" + vetor[i] + "]");
            }
        }
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("[" + ANSI_BLUE_BACKGROUND + "-" + ANSI_RESET_BACKGROUND + "] --> ELEITO");
        System.out.println("[" + ANSI_RED_BACKGROUND + "-" + ANSI_RESET_BACKGROUND + "] --> ATUAL");
        System.out.println("[" + ANSI_PURPLE_BACKGROUND + "-" + ANSI_RESET_BACKGROUND + "] --> ELEMENTO QUE SERÁ COMPARADO AO ATUAL");

        sc.nextLine();
    }

}
