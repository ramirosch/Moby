package package1;

public class EvaluacionTecnicaPil {

    public static void main(String[] args) {
        imprimirBienvenidaEvaluacionTecnica();

        int variable1 = 30;
        int variable2 = 5;
        boolean variable3 = variable1 > 0 && variable2 > 0;

        int resultadoOperacion1 = variable1 + variable2;
        int resultadoOperacion2 = variable1 * variable2;
       

        imprimirConsigna(1);
        if (variable3) {
            System.out.println("Resultados de las operaciones matemática: " + resultadoOperacion1 + ", " + resultadoOperacion2);
        } else {
            System.out.println("Error: La condición lógica no se cumple.");
        }

        imprimirConsigna(2);
        System.out.println("Valor inicial de la variable1: " + variable1);
        while (variable1 < 60) { 
            variable1++;
        }
        System.out.println("Valor final de la variable1: " + variable1);

        imprimirConsigna(3);
        int N = variable1 / 3;
        System.out.println(variable1);
        System.out.println(N);
        for (int i = 0; i < N; i++) {
            System.out.println("Iteración " + (i + 1));
        }
    }

    private static void imprimirBienvenidaEvaluacionTecnica() {
        System.out.println("*******************************************");
        System.out.println("Bienvenidos a la primer Evaluación Técnica.\n" + "Les deseamos muchos éxitos!");
        System.out.println("*******************************************\n");
    }

    private static void imprimirConsigna(int numeroConsigna) {
        System.out.println("**********");
        System.out.println("CONSIGNA " + numeroConsigna);
        System.out.println("**********\n");
    }
}
