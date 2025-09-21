package mx.unam.ciencias.myp;

import java.util.InputMismatchException;
import java.util.Scanner;
import mx.unam.ciencias.myp.core.AcademiaNinja;
import mx.unam.ciencias.myp.patterns.builder.PaqueteHerramientas;
import mx.unam.ciencias.myp.patterns.builder.PaqueteHerramientasBuilder;

/**
 * Clase principal para ejecutar la simulación de la Academia Ninja.
 * Actúa como el controlador de la aplicación, manejando el menú y la interacción
 * con el usuario.
 */
public class Main {

    // Hacemos scanner y academia atributos de la clase para no pasarlos por todos los métodos
    private final Scanner scanner = new Scanner(System.in);
    private final AcademiaNinja academia = new AcademiaNinja();

    /**
     * Punto de entrada de la aplicación. Crea una instancia de Main y ejecuta el
     * programa.
     * Este enfoque evita usar métodos estáticos para la lógica de la aplicación.
     * @param args argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        new Main().run();
    }

    /**
     * Método principal que contiene el bucle de ejecución del menú.
     */
    public void run() {
        System.out.println("███╗   ██╗██╗███╗   ██╗     ██╗ █████╗ ");
        System.out.println("████╗  ██║██║████╗  ██║     ██║██╔══██╗");
        System.out.println("██╔██╗ ██║██║██╔██╗ ██║     ██║███████║");
        System.out.println("██║╚██╗██║██║██║╚██╗██║██   ██║██╔══██║");
        System.out.println("██║ ╚████║██║██║ ╚████║╚█████╔╝██║  ██║");
        System.out.println("╚═╝  ╚═══╝╚═╝╚═╝  ╚═══╝ ╚════╝ ╚═╝  ╚═╝");
        System.out.println("    BIENVENIDO A LA ACADEMIA NINJA");
        System.out.println("=".repeat(40));

        academia.cargarDatosEjemplo();
        System.out.println("Datos de ejemplo cargados:");

        System.out.println("  - " + academia.getNinjasVoluntarios() + " ninjas voluntarios.");
        System.out.println("  - " + academia.getAspirantes() + " aspirantes.");

        boolean ejecutando = true;
        while (ejecutando) {
            mostrarMenu();
            int opcion = leerOpcion();

            switch (opcion) {
                case 1 -> gestionarFormacionGrupos();
                case 2 -> gestionarMuestraResumen();
                case 3 -> {
                    ejecutando = false;
                    System.out.println("\n¡Misión cumplida! Hasta luego, ninja.");
                }
                default -> System.out.println("Opción inválida. Por favor, elige una opción del menú.");
            }
        }
        scanner.close();
    }

    /**
     * Muestra el menú principal de opciones al usuario.
     */
    private void mostrarMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Formar grupos automáticamente");
        System.out.println("2. Mostrar resumen de grupos formados");
        System.out.println("3. Salir");
    }

    /**
     * Lee y valida la entrada numérica del usuario.
     * @return la opción seleccionada, o -1 si la entrada es inválida.
     */
    private int leerOpcion() {
        System.out.print("Selecciona una opción: ");
        try {
            int opcion = scanner.nextInt();
            scanner.nextLine();
            return opcion;
        } catch (InputMismatchException e) {
            System.out.println("Error: Debes introducir un número.");
            scanner.nextLine();
            return -1;
        }
    }

    /**
     * Lógica para la opción 1: formar grupos.
     */
    private void gestionarFormacionGrupos() {
        System.out.println("\nFormando grupos, por favor espera...");
        academia.formarGrupos();
        System.out.println("¡Grupos formados con éxito!");
    }

    /**
     * Lógica para la opción 2: mostrar el resumen.
     */
    private void gestionarMuestraResumen() {
        System.out.println("\nMostrando resumen de los grupos...");
        academia.mostrarResumenGrupos();
    }

}