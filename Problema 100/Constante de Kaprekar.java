import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numeros = new ArrayList<>();

        int numCasos = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numCasos; i++) {
            int numero = Integer.parseInt(scanner.nextLine());
            numeros.add(numero);
        }

        ArrayList<Integer> output = new ArrayList<>();

        for (int i = 0; i < numeros.size(); i++) {
            int iteraciones = 0;
            int resultado = numeros.get(i);

            while (resultado != 6174 && iteraciones < 8) {
                int numeroOrdenadoAscendente = ordenAscendente(resultado);
                int numeroOrdenadoDescendente = ordenDescendente(resultado);

                resultado = numeroOrdenadoDescendente - numeroOrdenadoAscendente;
                iteraciones++;

            }

            output.add(iteraciones);
        }

        for (int i = 0; i < output.size(); i++) {
            System.out.println(output.get(i));
        }
    }

    private static int ordenAscendente(int numeroIterado) {
        int digito1 = (numeroIterado / 1000) % 10;
        int digito2 = (numeroIterado / 100) % 10;
        int digito3 = (numeroIterado / 10) % 10;
        int digito4 = numeroIterado % 10;

        int[] numeroAscendente = {digito1, digito2, digito3, digito4};
        Arrays.sort(numeroAscendente);

        int numeroAscendenteDevuelto = ((numeroAscendente[0] * 1000) + (numeroAscendente[1] * 100) + (numeroAscendente[2] * 10) + numeroAscendente[3]);
        return numeroAscendenteDevuelto;
    }

    private static int ordenDescendente(int numeroIterado) {
        int digito1 = (numeroIterado / 1000) % 10;
        int digito2 = (numeroIterado / 100) % 10;
        int digito3 = (numeroIterado / 10) % 10;
        int digito4 = numeroIterado % 10;

        int[] numeroAscendente = {digito1, digito2, digito3, digito4};
        Arrays.sort(numeroAscendente);

        int[] numeroDescendente = {numeroAscendente[3], numeroAscendente[2], numeroAscendente[1], numeroAscendente[0]};

        int numeroDescendenteDevuelto = ((numeroDescendente[0] * 1000) + (numeroDescendente[1] * 100) + (numeroDescendente[2] * 10) + numeroDescendente[3]);
        return numeroDescendenteDevuelto;
    }
}
