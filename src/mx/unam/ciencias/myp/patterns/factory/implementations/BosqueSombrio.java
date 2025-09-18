package mx.unam.ciencias.myp.patterns.factory.implementations;
import mx.unam.ciencias.myp.patterns.factory.CampoEntrenamiento;

/**
 * Implementación concreta de {@link CampoEntrenamiento} que representa el "Bosque Sombrío".
 * <p>
 * Este campo de entrenamiento se asigna a los grupos cuyo nivel total de habilidad está entre 8 y 11. Es un escenario intermedio donde los aprendices enfrentan criaturas más desafiantes y desarrollan estrategias avanzadas.
 * 
 * </p>
 */

public class BosqueSombrio extends CampoEntrenamiento {

    @Override
    public String getNombre() {

        return "Bosque Sombrío";
    }

    @Override
    public String getDescripcion() {
        return "Un bosque donde los aprendices intermedios enfrentan criaturas más desafiantes y perfeccionan sus habilidades.";

    }
}

