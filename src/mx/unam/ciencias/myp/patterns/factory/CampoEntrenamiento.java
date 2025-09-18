package mx.unam.ciencias.myp.patterns.factory;

/**
 * Clase abstracta que representa un campo de entrenamiento en la Academia Ninja.
 *
 * <p>
 * Esta clase forma parte del patrón Factory, ya que sus subclases concretas ({@code ValleDelDragon}, {@code BosqueSombrio}, {@code MontanaEspiritual}) son instanciadas por {@link CampoEntrenamientoFactory} dependiendo del nivel total de habilidad del grupo.
 * 
 * </p>
 */
public abstract class CampoEntrenamiento {

    /**
     * Obtiene el nombre del campo de entrenamiento.
     * @return el nombre del campo.
     */
    public abstract String getNombre();

    /**
     * Regresa una breve descripción del campo de entrenamiento.
     *
     * @return la descripción del campo.
     */
    public abstract String getDescripcion();
}
