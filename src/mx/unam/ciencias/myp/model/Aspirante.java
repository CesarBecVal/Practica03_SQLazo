package mx.unam.ciencias.myp.model;

/**
 * Clase que representa a un aspirante de la Academia Ninja.
 * <p>
 */

public class Aspirante {

    private String nombre;
    private int edad;
    private String clan;
    private int nivelHabilidad;

    /**
     * Construye un nuevo aspirante con los datos especificados.
     * @param nombre el nombre del aspirante.
     * @param edad la edad del aspirante.
     * @param clan el clan de procedencia.
     * @param nivelHabilidad el nivel de habilidad.
     * @throws IllegalArgumentException si el nivel de habilidad no está en el rango 1–3.
     */
    public Aspirante(String nombre, int edad, String clan, int nivelHabilidad) {

        this.nombre = nombre;
        this.edad = edad;
        this.clan = clan;
        if (nivelHabilidad < 1 || nivelHabilidad > 3) throw new IllegalArgumentException("Nivel de habilidad del aspirante debe estar entre 1 y 3");
        this.nivelHabilidad = nivelHabilidad;

    }

    /**
     * @return el nombre del aspirante.
     */

    public String getNombre() { return nombre; }

    /**
     * @return la edad del aspirante.
     * 
     */
    public int getEdad() { return edad; }

    /**
     * @return el clan de procedencia del aspirante.
     */
    public String getClan(){ return clan; }

    /**
     * @return el nivel de habilidad del aspirante (1–3).
     * 
     */
    public int getNivelHabilidad() { return nivelHabilidad; }

    /**
     * Devuelve una representación en cadena del aspirante.
     *
     * @return una cadena con el nombre, clan y nivel de habilidad.
     */
    @Override
    public String toString() {
        return nombre + " (Clan " + clan + ", Habilidad: " + nivelHabilidad + ")";
    }

}