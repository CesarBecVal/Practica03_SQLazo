package mx.unam.ciencias.myp.patterns.factory.implementations;

import mx.unam.ciencias.myp.patterns.factory.CampoEntrenamiento;

/**
 * Implementación concreta de {@link CampoEntrenamiento} que representa la "Montaña Espiritual".
 * 
 * <p>
 * Este campo de entrenamiento se asigna a los grupos cuyo nivel total de habilidad es mayor a 12. Es el escenario más difícil, hecho para guerreros avanzados que buscan perfeccionar sus técnicas.
 * </p>
 */
public class MontanaEspiritual extends CampoEntrenamiento {

    @Override
    public String getNombre() {
        return "Montaña Espiritual";
    }


    @Override
    public String getDescripcion() {
        return "Una montaña donde los guerreros más avanzados entrenan para perfeccionar sus habilidades.";
    }

}

