package mx.unam.ciencias.myp.patterns.iterator;

/**
 * Colección genérica que sabe crear su propio iterador.
 * 
 * @param <T> tipo de elementos almacenados.
 */

public interface Coleccion<T> {
    /**
     * Crea un iterador posicionado al inicio de la colección.
     * 
     * @return un Iterator<T> de la práctica.
     */
    Iterator<T> crearIterator();
}
