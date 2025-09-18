package mx.unam.ciencias.myp.patterns.iterator.colecciones;
import mx.unam.ciencias.myp.model.Ninja;
import mx.unam.ciencias.myp.patterns.iterator.Coleccion;
import java.util.NoSuchElementException;
import mx.unam.ciencias.myp.patterns.iterator.Iterator;


/**
 * Colección de ninjas hecha con un arreglo.
 * 
 */
public class ColeccionNinjas implements Coleccion<Ninja> {
    private Ninja[] ninjas;
    private int tam;

    /**
     * Crea la colección con capacidad inicial dada.
     * @param capacidad capacidad inicial
     */

    public ColeccionNinjas(int capacidad) {
        if (capacidad <= 0) throw new IllegalArgumentException("Capacidad inválida");
        this.ninjas = new Ninja[capacidad];
        this.tam = 0;
    }

    /**
     * Agrega un ninja al final.
     */
    public void agregar(Ninja n) {

        if (n == null) throw new IllegalArgumentException("Ninja nulo");
        if (tam == ninjas.length) crecer();
        ninjas[tam++] = n;
    }

    private void crecer() {

        Ninja[] nuevo = new Ninja[ninjas.length * 2];
        System.arraycopy(ninjas, 0, nuevo, 0, ninjas.length);
        ninjas = nuevo;
    }

    @Override
    public Iterator<Ninja> crearIterator() {
        return new IteradorNinja();

    }

    /**
     * 
     * Iterador interno sobre el arreglo.
     */
    private class IteradorNinja implements Iterator<Ninja> {

        private int i = 0;

        @Override
        public boolean hasNext() {

            return i < tam;
        }

        @Override
        public Ninja next() {
            if (!hasNext()) throw new NoSuchElementException();
            return ninjas[i++];
        }
    }
}
