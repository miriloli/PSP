import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class App {

    // proceso padre
    public static void main(String[] args) throws Exception {
        // TODO
        // metodo privado que imprime tus datos --> linea 48 (Ctrl + click para ir a la
        // implementacion del metodo)
        imprimirCabecera();
        imprimirMenu();
        String opcion;

        Scanner scanner = new Scanner(System.in);
        opcion = scanner.nextLine();

        while (opcion != "0") {
            //TODO caso 0 y 2 no estan implementados
            //TODO solo funciona el caso 1, asi que no pruebes otra cosa
            switch (opcion) {
                case "1":
                    try {
                        String line;
                        // TODO
                        // aqui construimos el proceso hijo, le pasmaos el comando java y el archivo
                        // .java a ejecutar
                        // si te das cuenta he eliminado el flag "-jar" que le indica otra extension
                        // creo que asi debe funcionar

                        Process hijo = new ProcessBuilder("javac", "SubProcesoTablas.java", "java", "SubProcesoTablas.java").start();

                        //funcion que me he creado para debuggear
                        imprimeProcess(hijo);

                        // leemos la entrada del padre
                        BufferedReader entradaPadre = new BufferedReader(new InputStreamReader(System.in));
                        imprimeProcess(hijo);
                        // Aqui estamos creando un Objeto para Leer la salida del hijo
                        BufferedReader entradaHijo = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
                        imprimeProcess(hijo);
                        // Aqui estamos creando un objeto que nos permite
                        // pintar en la salida del padre lo que nos llega directamente del proceso hijo
                        PrintStream salidaHijo = new PrintStream(hijo.getOutputStream());
                        imprimeProcess(hijo);

                        while (!(line = entradaPadre.readLine()).equals("fin")) {
                            imprimeProcess(hijo);
                            salidaHijo.println(line);
                            salidaHijo.flush();
                            imprimeProcess(hijo);
                            System.out.println("Mensaje enviado al proceso hijo");
                            if ( entradaHijo.readLine() != null) {
                                System.out.println("Resultado del proceso hijo:");
                                imprimeProcess(hijo);
                                System.out.println("l2 "+line);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Error durante la ejecución: " + e.getMessage());
                    }

                    break;
            }

        }
        scanner.close();
        System.out.println("Proceso finalizado");
    }

    // statico para poder usarse dento del main
    // y void por que no devuelve nada SOLO IMPRIME
    private static void imprimirCabecera() {
        System.out.println(
                "******************************************\r\n\r\n"
                        + "* PSP - Tarea Individual 1             *\r\n\r\n"
                        + "******************************************\r\n\r\n"
                        + "* Miriam Gallardo González-Amor *\r\n\r\n"
                        + "******************************************\r\n\r\n"
                        + "* DNI del alumno           *");
    }

    private static void imprimirMenu() {
        System.out.println("Menu de Opciones");
        System.out.println("\t 0: salir");
        System.out.println("\t 1: ver la tabla del numero que elija");
        System.out.println("\t 2: ver todas las tablas");
    }

    private static void imprimeProcess(Process process) {
        System.out.println();
        System.out.println("el proceso esta vivo? "+process.isAlive());
        System.out.println("el proceso completo -> "+process.toString());
        System.out.println("informacion del proceso: "+process.info());
        System.out.println();
    }
}