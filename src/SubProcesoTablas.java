import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubProcesoTablas {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("ESTOY LEYENDO EN HIJO");
        String linea = bufferedReader.readLine();
        while (linea != "exit") {
            if (linea != null) {
                try {
                    calcularTabla(Integer.parseInt(linea));
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
            } else {
                System.out.println("ESTOY VACIO");
                calcularTodas();
            }
        }
    }

    private static void calcularTabla(Integer numero) throws Exception {
        if (numero > 0 && numero <= 10) {
            System.out.println("\s\s\s\s\s\s/************* Tabla del " + numero + " *************/\n");
            for (int contador = 1; contador <= 10; contador++) {
                int resultado = numero * contador;
                //condicional ternario (u operador ternario enn java, cambialo si quieres por una estructura if/else)
                String lineaImpresa = (contador == 10)
                        ? "\t\t" + numero + "\s\s\s x \s\s" + contador + "\s\s\s = \s\s\s" + resultado
                        : "\t\t" + numero + "\s\s\s x \s\s\s" + contador + "\s\s\s = \s\s\s" + resultado;
                System.out.println(lineaImpresa);
            }
            System.out.println("\n\t\s\s\s\s\s\s\s\s/*******************/\n\n");
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
