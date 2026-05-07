public class NRainhas {

    private static int iteracoes;
    private static int totalSolucoes;

    // Verifica se e seguro colocar uma rainha na posicao (linha, col)
    private static boolean podeColocar(int[] rainhas, int linha, int col) {
        for (int i = 0; i < linha; i++) {
            // Mesma coluna ou mesma diagonal
            if (rainhas[i] == col || Math.abs(rainhas[i] - col) == Math.abs(i - linha)) {
                return false;
            }
        }
        return true;
    }

    // Parte A: retorna a primeira solucao encontrada
    public static boolean resolverUma(int[] rainhas, int linha, int n) {
        if (linha == n) {
            return true;
        }
        for (int col = 0; col < n; col++) {
            iteracoes++;
            if (podeColocar(rainhas, linha, col)) {
                rainhas[linha] = col;
                if (resolverUma(rainhas, linha + 1, n)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Parte B: encontra todas as solucoes
    public static void resolverTodas(int[] rainhas, int linha, int n, boolean imprimir) {
        if (linha == n) {
            totalSolucoes++;
            if (imprimir) {
                System.out.println("Solucao #" + totalSolucoes + ":");
                imprimirTabuleiro(rainhas, n);
            }
            return;
        }
        for (int col = 0; col < n; col++) {
            iteracoes++;
            if (podeColocar(rainhas, linha, col)) {
                rainhas[linha] = col;
                resolverTodas(rainhas, linha + 1, n, imprimir);
            }
        }
    }

    private static void imprimirTabuleiro(int[] rainhas, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(rainhas[i] == j ? "Q " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Parte A: uma solucao para N de 4 a 8
        System.out.println("========== PARTE A: UMA SOLUCAO ==========\n");
        for (int n = 4; n <= 8; n++) {
            System.out.println("--- N = " + n + " ---");
            iteracoes = 0;
            int[] rainhas = new int[n];
            if (resolverUma(rainhas, 0, n)) {
                imprimirTabuleiro(rainhas, n);
            } else {
                System.out.println("Sem solucao.");
            }
            System.out.println("Iteracoes: " + iteracoes);
            System.out.println();
        }

        // Parte B: todas as solucoes para N de 4 a 8
        System.out.println("========== PARTE B: TODAS AS SOLUCOES ==========\n");
        for (int n = 4; n <= 8; n++) {
            System.out.println("--- N = " + n + " ---");
            iteracoes = 0;
            totalSolucoes = 0;
            int[] rainhas = new int[n];
            // Imprime tabuleiros apenas para N <= 6 para nao poluir a saida
            boolean imprimir = n <= 6;
            resolverTodas(rainhas, 0, n, imprimir);
            System.out.println("Total de solucoes: " + totalSolucoes);
            System.out.println("Iteracoes: " + iteracoes);
            System.out.println();
        }
    }
}
