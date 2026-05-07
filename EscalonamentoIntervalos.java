import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EscalonamentoIntervalos {

    private static int iteracoes;

    public static List<int[]> escalonar(int[][] intervalos) {
        iteracoes = 0;

        // Ordena pelo tempo de termino (finish time)
        Arrays.sort(intervalos, (a, b) -> Integer.compare(a[1], b[1]));

        List<int[]> selecionados = new ArrayList<>();
        int ultimoFim = Integer.MIN_VALUE;

        for (int[] intervalo : intervalos) {
            iteracoes++;
            // Seleciona o intervalo se nao conflita com o ultimo selecionado
            if (intervalo[0] >= ultimoFim) {
                selecionados.add(intervalo);
                ultimoFim = intervalo[1];
            }
        }

        return selecionados;
    }

    private static void executarCaso(String nome, int[][] intervalos) {
        System.out.println("=== " + nome + " ===");
        System.out.print("Intervalos de entrada: ");
        for (int[] i : intervalos) {
            System.out.print("(" + i[0] + "," + i[1] + ") ");
        }
        System.out.println();

        List<int[]> resultado = escalonar(intervalos);

        System.out.print("Intervalos selecionados: ");
        for (int[] i : resultado) {
            System.out.print("(" + i[0] + "," + i[1] + ") ");
        }
        System.out.println();
        System.out.println("Total selecionado: " + resultado.size());
        System.out.println("Iteracoes: " + iteracoes);
        System.out.println();
    }

    public static void main(String[] args) {
        // Caso classico do livro (Kleinberg & Tardos)
        int[][] caso1 = {
            {1, 4}, {3, 5}, {0, 6}, {5, 7}, {3, 8},
            {5, 9}, {6, 10}, {8, 11}, {8, 12}, {2, 13}, {12, 14}
        };
        executarCaso("Caso 1 (classico)", caso1);

        // Sem conflitos: todos devem ser selecionados
        int[][] caso2 = {
            {1, 2}, {3, 4}, {5, 6}, {7, 8}
        };
        executarCaso("Caso 2 (sem conflitos)", caso2);

        // Todos se sobrepoem: apenas um selecionado
        int[][] caso3 = {
            {1, 10}, {2, 9}, {3, 8}, {4, 7}
        };
        executarCaso("Caso 3 (todos sobrepostos)", caso3);

        // Caso com empate no tempo de termino
        int[][] caso4 = {
            {0, 3}, {1, 3}, {2, 5}, {4, 6}, {5, 8}
        };
        executarCaso("Caso 4 (empate no termino)", caso4);
    }
}
