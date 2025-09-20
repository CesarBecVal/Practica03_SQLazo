package mx.unam.ciencias.myp.patterns.builder;

/**
 * Interfaz {@code PaqueteBuilder} que define el contrato para construir
 * instancias de {@link PaqueteHerramientas} paso a paso (patrón Builder).
 *
 * <p>Las implementaciones deben ofrecer un estilo <em>fluido</em> (métodos que
 * retornan el propio builder) para permitir encadenamiento:
 * <pre>
 * PaqueteHerramientas paquete = new PaqueteHerramientasBuilder()
 *     .agregarKunais(3)
 *     .agregarShurikens(5)
 *     .agregarBotiquines(1)
 *     .build();
 * </pre>
 *
 * <p>Contrato y recomendaciones:
 * <ul>
 *   <li>Los métodos de agregación deben aceptar únicamente cantidades >= 0.</li>
 *   <li>Si se recibe una cantidad negativa, la implementación debe lanzar
 *       {@link IllegalArgumentException}.</li>
 *   <li>Los métodos de agregación acumulan la cantidad indicada al estado actual
 *       del builder (no reemplazan a menos que la implementación lo documente).</li>
 *   <li>El método {@code build()} devuelve la instancia final de
 *       {@code PaqueteHerramientas} y puede opcionalmente resetear el builder
 *       para permitir reutilización.</li>
 * </ul>
 *
 * @author César
 */
public interface PaqueteBuilder {

    /**
     * Agrega la cantidad de kunais al paquete en construcción.
     *
     * @param cantidad número de kunais a agregar; debe ser mayor o igual a 0.
     * @return el mismo builder para permitir encadenamiento.
     * @throws IllegalArgumentException si {@code cantidad} es negativa.
     */
    PaqueteBuilder agregarKunais(int cantidad);

    /**
     * Agrega la cantidad de shurikens al paquete en construcción.
     *
     * @param cantidad número de shurikens a agregar; debe ser mayor o igual a 0.
     * @return el mismo builder para permitir encadenamiento.
     * @throws IllegalArgumentException si {@code cantidad} es negativa.
     */
    PaqueteBuilder agregarShurikens(int cantidad);

    /**
     * Agrega la cantidad de papeles bomba al paquete en construcción.
     *
     * @param cantidad número de papeles bomba a agregar; debe ser mayor o igual a 0.
     * @return el mismo builder para permitir encadenamiento.
     * @throws IllegalArgumentException si {@code cantidad} es negativa.
     */
    PaqueteBuilder agregarPapelesBomba(int cantidad);

    /**
     * Agrega la cantidad de bombas de humo al paquete en construcción.
     *
     * @param cantidad número de bombas de humo a agregar; debe ser mayor o igual a 0.
     * @return el mismo builder para permitir encadenamiento.
     * @throws IllegalArgumentException si {@code cantidad} es negativa.
     */
    PaqueteBuilder agregarBombasHumo(int cantidad);

    /**
     * Agrega la cantidad de botiquines al paquete en construcción.
     *
     * @param cantidad número de botiquines a agregar; debe ser mayor o igual a 0.
     * @return el mismo builder para permitir encadenamiento.
     * @throws IllegalArgumentException si {@code cantidad} es negativa.
     */
    PaqueteBuilder agregarBotiquines(int cantidad);
    
    /**
     * Construye y retorna la instancia final de {@link PaqueteHerramientas}
     * según las cantidades acumuladas en el builder.
     *
     * <p>El comportamiento tras la invocación (por ejemplo si el builder se
     * resetea automáticamente) depende de la implementación concreta, por lo
     * que debe estar documentado en la clase que implemente esta interfaz.
     *
     * @return la instancia construida de {@code PaqueteHerramientas}.
     */
    PaqueteHerramientas build();
}
