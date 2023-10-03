import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubProcesoTablas {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String linea = bufferedReader.readLine();
        if (linea != "") {
            try {
                calcularTabla(Integer.parseInt(linea));
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }else{
            calcularTodas();
        }
    }

    private static void calcularTabla(Integer numero) throws Exception {
        if (numero > 0 && numero <= 10) {
            for (int contador = 1; contador <= 10; contador++) {
                int resultado = numero * contador;
                System.out.println(numero + " x " + contador + " = " + resultado);
            }
        } else {
            throw new Exception("Error, has introducido un numero fuera de rango, rango permitido [1-10]");
        }
    }

    private static void calcularTodas() {
        for (int i = 1; i <= 10; i++) {
            try {
                calcularTabla(i);
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

}