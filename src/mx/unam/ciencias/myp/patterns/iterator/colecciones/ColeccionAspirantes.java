package mx.unam.ciencias.myp.patterns.iterator.colecciones;
import java.util.Hashtable;
import java.util.Enumeration;
import java.util.NoSuchElementException;
import mx.unam.ciencias.myp.patterns.iterator.Coleccion;
import mx.unam.ciencias.myp.patterns.iterator.Iterator;
import mx.unam.ciencias.myp.model.Aspirante;

/**
 * Colección de aspirantes hecha con una Hashtable.
 */

public class ColeccionAspirantes implements Coleccion<Aspirante> {


    private final Hashtable<String, Aspirante> aspirantes = new Hashtable<>();
    private int secuencia = 0;


    /**
     * Agrega un aspirante a aspirantes.
     */
    public void agregar(Aspirante a) {
        if (a == null) throw new IllegalArgumentException("Aspirante nulo");
        String key = "asp-" + (secuencia++);
        aspirantes.put(key, a);
    }

    @Override
    public Iterator<Aspirante> crearIterator() {
        return new IteradorAspirante(aspirantes.elements());
    }


    /**
     * Iterador interno de la Hashtable utilizando una Enumeration.
     */
    private static class IteradorAspirante implements Iterator<Aspirante> {
        private final Enumeration<Aspirante> e;

        private IteradorAspirante(Enumeration<Aspirante> e) {
            this.e = e;
        }

        @Override
        public boolean hasNext() {
            return e.hasMoreElements();
        }

        @Override
        public Aspirante next() {
            if (!hasNext()) throw new NoSuchElementException();
            return e.nextElement();
        }
    }
}
