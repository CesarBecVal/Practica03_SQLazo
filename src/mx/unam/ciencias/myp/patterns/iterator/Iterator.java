package mx.unam.ciencias.myp.patterns.iterator;

/**
 * Iterador genérico de la práctica.
 * 
 * @param <T> tipo de elemento a iterar.
 */
public interface Iterator<T> {

    /**
     * @return true si queda al menos un elemento por visitar.
     */

    boolean hasNext();

    /**
     * 
     * @return el siguiente elemento.
     * @throws java.util.NoSuchElementException si no hay más elementos.
     */
    T next();
}
