public class Troco {

    public static int troco(int[] denominacoes, int valor) {
        int totalMoedas = 0;
        int iteracoes = 0;

        System.out.println("Valor: " + valor + " centavos");
        for (int den : denominacoes) {
            iteracoes++;
            int qtd = valor / den;
            if (qtd > 0) {
                totalMoedas += qtd;
                valor -= qtd * den;
                System.out.println("  " + qtd + " x " + den);
            }
            if (valor == 0) break;
        }

        System.out.println("Total de moedas: " + totalMoedas);
        System.out.println("Iteracoes: " + iteracoes);
        return totalMoedas;
    }

    public static void main(String[] args) {
        // Denominacoes do exemplo do enunciado (sem 50 e sem 5)
        int[] den1 = {100, 25, 10, 1};

        System.out.println("=== Caso 1: R$2,89 (denominacoes: 100, 25, 10, 1) ===");
        troco(den1, 289);

        // Denominacoes completas do real brasileiro
        int[] den2 = {100, 50, 25, 10, 5, 1};

        System.out.println("\n=== Caso 2: R$1,50 (denominacoes: 100, 50, 25, 10, 5, 1) ===");
        troco(den2, 150);

        System.out.println("\n=== Caso 3: R$3,41 (denominacoes: 100, 50, 25, 10, 5, 1) ===");
        troco(den2, 341);

        System.out.println("\n=== Caso 4: R$0,99 (denominacoes: 100, 50, 25, 10, 5, 1) ===");
        troco(den2, 99);
    }
}
