package mx.unam.ciencias.myp.patterns.factory;
import mx.unam.ciencias.myp.patterns.factory.implementations.*;

/**
 * Fábrica de objetos {@link CampoEntrenamiento}.
 * 
 * <p>
 * 
 * Esta clase aplica el patrón Factory para decidir qué tipo de campo de entrenamiento se asigna a un grupo de ninjas, en función del nivel total de habilidad de sus integrantes.
 * </p>
 */
public class CampoEntrenamientoFactory {

    /**
     * Crea una instancia de {@link CampoEntrenamiento} según el nivel de habilidad.
     *
     * @param nivelHabilidad el nivel total de habilidad del grupo.
     * 
     * @return un objeto {@link CampoEntrenamiento} conforme al nivel indicado.
     */
    public static CampoEntrenamiento crearCampo(int nivelHabilidad) {
        if (nivelHabilidad < 7) return new ValleDelDragon();
        else if (nivelHabilidad <= 11) return new BosqueSombrio();
        else return new MontanaEspiritual();
        
    }
}