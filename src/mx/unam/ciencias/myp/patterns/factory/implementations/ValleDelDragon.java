package mx.unam.ciencias.myp.patterns.factory.implementations;
import mx.unam.ciencias.myp.patterns.factory.CampoEntrenamiento;

/**
 * Implementación concreta de {@link CampoEntrenamiento} que representa el "Valle del Dragón".
 * <p>
 * Este campo de entrenamiento se asigna a los grupos cuyo nivel total de habilidad es menor a 7. Es el escenario inicial donde los aspirantes realizan prácticas básicas contra dragones de bajo nivel.
 * </p>
 */
public class ValleDelDragon extends CampoEntrenamiento {

    @Override
    public String getNombre() {
        return "Valle del Dragón";
    }

    @Override
    public String getDescripcion() {
        
        return "Un valle donde los aprendices más básicos aprenden a luchar contra dragones de bajo nivel.";
    }

}
