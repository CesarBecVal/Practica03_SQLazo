package mx.unam.ciencias.myp.model;


/**
 * Clase que representa a un ninja voluntario dentro de la Academia Ninja.
 * 
 * <p>
 * Los ninjas son los líderes de grupo y tienen como atributos nombre, edad, clan, rango y nivel de habilidad. El rango debe ser uno de {@code genin}, {@code chunin} o {@code jonin}, mientras que el nivel de habilidad debe estar entre 4 y 6.
 * </p>
 */
public class Ninja {

    private String nombre;
    private int edad;
    private String clan;
    private String rango;
    private int nivelHabilidad;


    /**
     * Construye un nuevo ninja.
     *
     * @param nombre el nombre del ninja.
     * @param edad la edad del ninja.
     * @param clan el clan de procedencia.
     * @param rango el rango del ninja ({@code genin}, {@code chunin}, {@code jonin}).
     * @param nivelHabilidad el nivel de habilidad del ninja (4–6).
     * @throws IllegalArgumentException si el rango no es válido o si el nivel de habilidad no está entre 4 y 6.
     */
    public Ninja(String nombre, int edad, String clan, String rango, int nivelHabilidad) {
        this.nombre = nombre;
        this.edad = edad;
        this.clan = clan;
        if (!rango.equalsIgnoreCase("genin") && !rango.equalsIgnoreCase("chunin") && !rango.equalsIgnoreCase("jonin")) throw new IllegalArgumentException("Rango inválido: " + rango);
        this.rango = rango.toLowerCase();
        if (nivelHabilidad < 4 || nivelHabilidad > 6) throw new IllegalArgumentException("Nivel de habilidad debe estar entre 4 y 6");
        this.nivelHabilidad = nivelHabilidad;
    }

    /**
     * @return el nombre del ninja.
     */
    public String getNombre(){ return nombre; }

    /**
     * @return la edad del ninja.
     */
    public int getEdad() { return edad; }

    /**
     * @return el clan del ninja.
     */

    public String getClan(){ return clan; }


    /**
     * @return el rango del ninja ({@code genin}, {@code chunin}, {@code jonin}).
     * 
     */
    public String getRango() { return rango; }

    /**
     * 
     * @return el nivel de habilidad del ninja (4–6).
     */
    public int getNivelHabilidad() { return nivelHabilidad; }


    /**
     * @return true si el ninja es de rango genin.
     */
    public boolean esGenin() { return "genin".equals(rango); }

    /**
     * @return true si el ninja es de rango chunin.
     */
    public boolean esChunin(){ return "chunin".equals(rango); }

    /**
     * @return true si el ninja es de rango jonin.
     */
    public boolean esJonin() { return "jonin".equals(rango); }


    /**
     * Devuelve una representación en cadena del ninja.
     * @return una cadena con el nombre, rango, clan y nivel de habilidad.
     */
    @Override
    public String toString() {
        return nombre + " (" + rango + ", Clan " + clan + ", Habilidad: " + nivelHabilidad + ")";
    }
}