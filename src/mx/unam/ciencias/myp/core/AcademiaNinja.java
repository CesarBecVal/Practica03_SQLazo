package mx.unam.ciencias.myp.core;

import mx.unam.ciencias.myp.model.*;
import mx.unam.ciencias.myp.patterns.builder.*;
import mx.unam.ciencias.myp.patterns.iterator.colecciones.*;
import mx.unam.ciencias.myp.patterns.iterator.*;
import mx.unam.ciencias.myp.patterns.iterator.Iterator;

import java.util.*;
import java.util.function.Consumer;

/**
 * Clase principal que representa la Academia Ninja y coordina todas las operaciones.
 * Se encarga de formar grupos, asignar paquetes de herramientas y campos de entrenamiento.
 * Incluye un menú interactivo para la asignación de paquetes.
 */
public class AcademiaNinja {
    private ColeccionNinjas ninjasVoluntarios;
    private ColeccionAspirantes aspirantes;
    private List<Grupo> gruposFormados;
    private EncargadoPaquetes encargadoPaquetes;
    private Scanner scanner;

    /**
     * Constructor de la Academia Ninja.
     * Inicializa las colecciones de ninjas y aspirantes, y crea el encargado de paquetes.
     */
    public AcademiaNinja() {
        this.ninjasVoluntarios = new ColeccionNinjas(10);
        this.aspirantes = new ColeccionAspirantes();
        this.gruposFormados = new ArrayList<>();
        this.encargadoPaquetes = new EncargadoPaquetes(new PaqueteHerramientasBuilder());
        this.scanner = new Scanner(System.in);
    }

    /**
     * Agrega un ninja voluntario a la colección.
     * @param ninja el ninja a agregar.
     */
    public void agregarNinjaVoluntario(Ninja ninja) {
        ninjasVoluntarios.agregar(ninja);
    }

    /**
     * Agrega un aspirante a la colección.
     * @param aspirante el aspirante a agregar.
     */
    public void agregarAspirante(Aspirante aspirante) {
        aspirantes.agregar(aspirante);
    }

    /**
     * Carga datos de ejemplo para la demostración.
     */
    public void cargarDatosEjemplo() {

        agregarNinjaVoluntario(new Ninja("Naruto", 17, "Osomaki", "jonin", 6));
        agregarNinjaVoluntario(new Ninja("Sasuke", 17, "Fuchiha", "jonin", 6));
        agregarNinjaVoluntario(new Ninja("Sakura", 17, "Mortalika", "chunin", 5));
        agregarNinjaVoluntario(new Ninja("Kakashi", 30, "Fuchiha", "jonin", 6));
        agregarNinjaVoluntario(new Ninja("Hinata", 17, "Naca", "chunin", 4));
        agregarNinjaVoluntario(new Ninja("Shikamaru", 17, "Akipichi", "chunin", 5));

        agregarAspirante(new Aspirante("Akira", 12, "Fuchiha", 2));
        agregarAspirante(new Aspirante("Botan", 13, "Osomaki", 1));
        agregarAspirante(new Aspirante("Chihiro", 11, "Naca", 3));
        agregarAspirante(new Aspirante("Daiki", 14, "Mortalika", 2));
        agregarAspirante(new Aspirante("Emi", 12, "Akipichi", 1));
        agregarAspirante(new Aspirante("Fumiko", 13, "Fuchiha", 3));
        agregarAspirante(new Aspirante("Goro", 12, "Osomaki", 2));
        agregarAspirante(new Aspirante("Haruka", 14, "Naca", 1));
        agregarAspirante(new Aspirante("Isamu", 13, "Mortalika", 3));
        agregarAspirante(new Aspirante("Jiro", 12, "Akipichi", 2));
        agregarAspirante(new Aspirante("Kiko", 13, "Fuchiha", 1));
        agregarAspirante(new Aspirante("Leo", 12, "Osomaki", 3));
    }

    /**
     * Forma los grupos según las reglas establecidas.
     * Asigna líderes ninjas y aspirantes según el rango del líder.
     */
    public void formarGrupos() {
        Iterator<Ninja> iteradorNinjas = ninjasVoluntarios.crearIterator();
        Iterator<Aspirante> iteradorAspirantes = aspirantes.crearIterator();
        
        while (iteradorNinjas.hasNext() && iteradorAspirantes.hasNext()) {
            Ninja lider = iteradorNinjas.next();
            List<Aspirante> aspirantesGrupo = new ArrayList<>();
            
            int maxAspirantes = 0;
            if (lider.esGenin()) {
                maxAspirantes = 1;
            } else if (lider.esChunin()) {
                maxAspirantes = 2;
            } else if (lider.esJonin()) {
                maxAspirantes = 3;
            }
            

            for (int i = 0; i < maxAspirantes && iteradorAspirantes.hasNext(); i++) {
                aspirantesGrupo.add(iteradorAspirantes.next());
            }
            

            System.out.println("\n=== ASIGNANDO PAQUETE PARA GRUPO CON LÍDER: " + lider.getNombre() + " ===");
            PaqueteHerramientas paquete = mostrarMenuPaquetes(lider, aspirantesGrupo);
            

            Grupo grupo = new Grupo(lider, aspirantesGrupo, paquete);
            gruposFormados.add(grupo);
            
            System.out.println("Grupo formado exitosamente con " + aspirantesGrupo.size() + " aspirantes");
        }
    }

    /**
     * Muestra un menú interactivo para seleccionar el tipo de paquete.
     * @param lider el ninja líder del grupo.
     * @param aspirantes los aspirantes del grupo.
     * @return el paquete de herramientas seleccionado.
     */
    private PaqueteHerramientas mostrarMenuPaquetes(Ninja lider, List<Aspirante> aspirantes) {
        int nivelTotal = calcularNivelTotal(lider, aspirantes);
        System.out.println("Nivel total de habilidad del grupo: " + nivelTotal);
        
        while (true) {
            System.out.println("\n--- OPCIONES DE PAQUETE ---");
            System.out.println("1. Paquete Básico (recomendado para los niveles menores a 8)");
            System.out.println("2. Paquete Avanzado (recomendado para niveles 8-11)");
            System.out.println("3. Paquete Táctico (recomendado para niveles mayores a 12)");
            System.out.println("4. Paquete Personalizado");
            System.out.println("5. Ver descripción de paquetes");
            System.out.print("Selecciona una opción (1-5): ");
            
            try {
                int opcion = scanner.nextInt();
                scanner.nextLine();
                
                switch (opcion) {
                    case 1:
                        return encargadoPaquetes.crearPaqueteBasico();
                    case 2:
                        return encargadoPaquetes.crearPaqueteAvanzado();
                    case 3:
                        return encargadoPaquetes.crearPaqueteTactico();
                    case 4:
                        return crearPaquetePersonalizadoInteractivo();
                    case 5:
                        mostrarDescripcionPaquetes();
                        break;
                    default:
                        System.out.println("Opción inválida. Intenta de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor ingresa un número válido.");
                scanner.nextLine();
            }
        }
    }

    /**
     * Crea un paquete personalizado mediante menú interactivo.
     * @return el paquete personalizado creado.
     */
    private PaqueteHerramientas crearPaquetePersonalizadoInteractivo() {
        System.out.println("\n--- CREANDO PAQUETE PERSONALIZADO ---");
        

        return encargadoPaquetes.crearPaquetePersonalizado(builder -> {
            System.out.println("Ingresa las cantidades para cada herramienta (0 para omitir):");
            
            try {
                System.out.print("\nKunais: ");
                int kunais = scanner.nextInt();
                if (kunais > 0) builder.agregarKunais(kunais);
                
                System.out.print("\nShurikens: ");
                int shurikens = scanner.nextInt();
                if (shurikens > 0) builder.agregarShurikens(shurikens);
                
                System.out.print("\nPapeles Bomba: ");
                int papelesBomba = scanner.nextInt();
                if (papelesBomba > 0) builder.agregarPapelesBomba(papelesBomba);
                
                System.out.print("\nBombas de Humo: ");
                int bombasHumo = scanner.nextInt();
                if (bombasHumo > 0) builder.agregarBombasHumo(bombasHumo);
                
                System.out.print("\nBotiquines: ");
                int botiquines = scanner.nextInt();
                if (botiquines > 0) builder.agregarBotiquines(botiquines);
                
                scanner.nextLine();
                
            } catch (InputMismatchException e) {
                System.out.println("Error: debes ingresar números enteros. Usando valores por defecto.");
                scanner.nextLine();

                builder.agregarKunais(1)
                    .agregarShurikens(2)
                    .agregarPapelesBomba(1)
                    .agregarBombasHumo(1)
                    .agregarBotiquines(1);
            }
        });
    }

    /**
     * Muestra la descripción de los paquetes disponibles.
     */
    private void mostrarDescripcionPaquetes() {
        System.out.println("\n--- DESCRIPCIÓN DE PAQUETES ---");
        System.out.println("1. Paquete Básico: 2 Kunai, 1 Shuriken, 1 Botiquín");
        System.out.println("2. Paquete Avanzado: 2 Shuriken, 3 Papeles Bomba, 2 Bombas de Humo, 2 Botiquines");
        System.out.println("3. Paquete Táctico: 3 Kunai, 2 Shuriken, 4 Papeles Bomba, 2 Bombas de Humo");
        System.out.println("4. Paquete Personalizado: Eliges las cantidades de cada herramienta");
        System.out.println("Pesos: Kunai(0.2kg), Shuriken(0.05kg), Papel Bomba(0.15kg), Bomba Humo(0.25kg), Botiquín(0.5kg)");
    }

    /**
     * Calcula el nivel total de habilidad del grupo.
     * @param lider el ninja líder.
     * @param aspirantes la lista de aspirantes.
     * @return el nivel total de habilidad.
     */
    private int calcularNivelTotal(Ninja lider, List<Aspirante> aspirantes) {
        int nivelTotal = lider.getNivelHabilidad();
        for (Aspirante a : aspirantes) {
            nivelTotal += a.getNivelHabilidad();
        }
        return nivelTotal;
    }

    /**
     * Muestra un resumen de todos los grupos formados.
     */
    public void mostrarResumenGrupos() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("RESUMEN FINAL DE GRUPOS FORMADOS");
        System.out.println("=".repeat(50));
        System.out.println("Total de grupos: " + gruposFormados.size());
        System.out.println();
        
        for (int i = 0; i < gruposFormados.size(); i++) {
            Grupo grupo = gruposFormados.get(i);
            System.out.println("GRUPO " + (i + 1) + ":");
            System.out.println("\nLíder: " + grupo.getLider());
            System.out.println("\nAspirantes (" + grupo.getAspirantes().size() + "):");
            for (Aspirante a : grupo.getAspirantes()) {
                System.out.println("  - " + a);
            }
            System.out.println("\nPaquete de herramientas: " + grupo.getPaquete());
            grupo.mostrarResumen();
            System.out.println("\nNivel total de habilidad: " + grupo.getNivelHabilidadTotal());
            System.out.println("-".repeat(50));
        }
        
        mostrarAspirantesSobrantes();
    }

    /**
     * Muestra los aspirantes que no pudieron ser asignados a grupos.
     */
    private void mostrarAspirantesSobrantes() {

        List<Aspirante> asignados = new ArrayList<>();
        for (Grupo grupo : gruposFormados) {
            asignados.addAll(grupo.getAspirantes());
        }
        
        List<Aspirante> sobrantes = new ArrayList<>();
        Iterator<Aspirante> iteradorTodos = aspirantes.crearIterator();
        
        while (iteradorTodos.hasNext()) {
            Aspirante aspirante = iteradorTodos.next();
            if (!asignados.contains(aspirante)) {
                sobrantes.add(aspirante);
            }
        }
        
        if (!sobrantes.isEmpty()) {
            System.out.println("ASPIRANTES SOBRANTES (" + sobrantes.size() + "):");
            for (Aspirante a : sobrantes) {
                System.out.println("  - " + a.getNombre() + " (Clan " + a.getClan() + ") - Se ofrecieron disculpas");
            }
        } else {
            System.out.println("Todos los aspirantes fueron asignados a grupos.");
        }
    }

    /**
     * Método getter para los grupos formados.
     * @return la lista de grupos formados.
     */
    public List<Grupo> getGruposFormados() {
        return gruposFormados;
    }

    /**
     * Método getter para los ninjas voluntarios.
     * @return la colección de ninjas voluntarios.
     */
    public ColeccionNinjas getNinjasVoluntarios() {
        return ninjasVoluntarios;
    }

    /**
     * Método getter para los aspirantes.
     * @return la colección de aspirantes.
     */
    public ColeccionAspirantes getAspirantes() {
        return aspirantes;
    }
}