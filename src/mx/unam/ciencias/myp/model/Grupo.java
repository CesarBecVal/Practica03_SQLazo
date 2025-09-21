package mx.unam.ciencias.myp.model;
import mx.unam.ciencias.myp.patterns.factory.CampoEntrenamiento;
import mx.unam.ciencias.myp.patterns.factory.CampoEntrenamientoFactory;
import java.util.List;
import mx.unam.ciencias.myp.patterns.builder.PaqueteHerramientas;

/**
 * Clase que representa un grupo dentro de la Academia Ninja.
 * <p>
 * Cada grupo está conformado por un ninja líder, una lista de aspirantes, un paquete de herramientas y un campo de entrenamiento asignado de acuerdo al nivel de habilidad total de sus integrantes.
 * 
 * </p>
 */
public class Grupo {

    private Ninja lider;
    private List<Aspirante> aspirantes;
    private PaqueteHerramientas paquete;
    private CampoEntrenamiento campo;

    /**
     * Crea un nuevo grupo con el líder, los aspirantes y el paquete de herramientas especificados. El campo de entrenamiento se asigna automáticamente usando {@link CampoEntrenamientoFactory} con base en el nivel de habilidad total.
     * @param lider el ninja líder del grupo.
     * @param aspirantes la lista de aspirantes que acompañan al líder.
     * @param paquete el paquete de herramientas asignado al grupo.
     * 
     */
    public Grupo(Ninja lider, List<Aspirante> aspirantes, PaqueteHerramientas paquete) {

        this.lider = lider;
        this.aspirantes = aspirantes;
        this.paquete = paquete;
        int nivelTotal = getNivelHabilidadTotal();
        this.campo = CampoEntrenamientoFactory.crearCampo(nivelTotal);
    }

    /**
     * Calcula el nivel total de habilidad del grupo sumando el nivel del líder y el de cada uno de los aspirantes.
     *
     * @return el nivel total de habilidad del grupo.
     */
    public int getNivelHabilidadTotal() {
        int total = lider.getNivelHabilidad();
        for (Aspirante a : aspirantes) total += a.getNivelHabilidad();
        return total;
    }

    /**
     * Muestra un resumen del grupo, incluyendo el nombre y descripción del campo de entrenamiento asignado.
     */
    public void mostrarResumen() {
        System.out.println("Campo de entrenamiento: " + campo.getNombre());
        System.out.println("Descripción: " + campo.getDescripcion());
    }

    public Ninja getLider() {
    return lider;
    }

    public List<Aspirante> getAspirantes() {
        return aspirantes;
    }

    public PaqueteHerramientas getPaquete() {
        return paquete;
    }

    public CampoEntrenamiento getCampo() {
        return campo;
    }
}
