package mx.unam.ciencias.myp.patterns.builder;

/**
 * Builder concreto para construir instancias de {@link PaqueteHerramientas}.
 * <p>
 * Esta clase mantiene el estado de las cantidades que formarán parte del
 * paquete y ofrece métodos de estilo fluido para agregarlas. Al llamar a
 * {@link #build()} se obtiene el {@link PaqueteHerramientas} resultante y el
 * builder se resetea para poder reutilizarlo (comportamiento implementado).
 * </p>
 *
 * <p><b>Contrato:</b></p>
 * <ul>
 *   <li>Los métodos {@code agregarXxx(int)} acumulan la cantidad indicada al
 *       estado actual del builder.</li>
 *   <li>Si se pasa una cantidad negativa, se lanza {@link IllegalArgumentException}.</li>
 *   <li>Tras {@code build()} el builder queda reseteado (todas las cantidades a 0).</li>
 * </ul>
 *
 * Ejemplo de uso:
 * <pre>
 * PaqueteHerramientasBuilder b = new PaqueteHerramientasBuilder();
 * PaqueteHerramientas p = b.agregarKunais(3)
 *                        .agregarShurikens(5)
 *                        .agregarBotiquines(1)
 *                        .build();
 * </pre>
 *
 * @author César
 */
public class PaqueteHerramientasBuilder implements PaqueteBuilder {
  private int kunais;
  private int shurikens;
  private int papelesBomba;
  private int bombasHumo;
  private int botiquines;

  /**
   * Construye un nuevo {@code PaqueteHerramientasBuilder} y lo inicializa
   * con todas las cantidades a 0.
   */
  public PaqueteHerramientasBuilder() {
    reset();
  }

  /**
   * Resetea el estado del builder (pone todas las cantidades a 0).
   * Método privado de utilidad.
   */
  private void reset () {
    kunais = shurikens = papelesBomba = bombasHumo = botiquines = 0;
  }

  /**
   * Valida que una cantidad no sea negativa.
   *
   * @param cantidad la cantidad a validar
   * @param nombre   nombre del elemento (utilizado en el mensaje de error)
   * @throws IllegalArgumentException si {@code cantidad} es negativa.
   */
  private void validarNoNegativo(int cantidad, String nombre) {
    if (cantidad < 0) {
      throw new IllegalArgumentException("No puedes recibir una cantidad negativa de " + nombre);
    }
  }

  /**
   * Agrega la cantidad de kunais al builder (se acumula).
   *
   * @param cantidad número de kunais a agregar; debe ser >= 0.
   * @return el mismo builder para permitir encadenamiento.
   * @throws IllegalArgumentException si {@code cantidad} es negativa.
   */
  @Override 
  public PaqueteHerramientasBuilder agregarKunais(int cantidad) {
    validarNoNegativo(cantidad, "Kunais");
    this.kunais = cantidad;
    return this;
  }

  /**
   * Agrega la cantidad de shurikens al builder (se acumula).
   *
   * @param cantidad número de shurikens a agregar; debe ser >= 0.
   * @return el mismo builder para permitir encadenamiento.
   * @throws IllegalArgumentException si {@code cantidad} es negativa.
   */
  @Override 
  public PaqueteHerramientasBuilder agregarShurikens(int cantidad) {
    validarNoNegativo(cantidad, "Shurikens");
    this.shurikens += cantidad;
    return this; 
  }

  /**
   * Agrega la cantidad de papeles bomba al builder (se acumula).
   *
   * @param cantidad número de papeles bomba a agregar; debe ser >= 0.
   * @return el mismo builder para permitir encadenamiento.
   * @throws IllegalArgumentException si {@code cantidad} es negativa.
   */
  @Override 
  public PaqueteHerramientasBuilder agregarPapelesBomba(int cantidad) {
    validarNoNegativo(cantidad, "Papeles Bomba");
    this.papelesBomba = cantidad;
    return this;
  }

  /**
   * Agrega la cantidad de bombas de humo al builder (se acumula).
   *
   * @param cantidad número de bombas de humo a agregar; debe ser >= 0.
   * @return el mismo builder para permitir encadenamiento.
   * @throws IllegalArgumentException si {@code cantidad} es negativa.
   */
  @Override 
  public PaqueteHerramientasBuilder agregarBombasHumo(int cantidad) {
    validarNoNegativo(cantidad, "Bombas de Humo");
    this.bombasHumo = cantidad;
    return this;
  }

  /**
   * Agrega la cantidad de botiquines al builder (se acumula).
   *
   * @param cantidad número de botiquines a agregar; debe ser >= 0.
   * @return el mismo builder para permitir encadenamiento.
   * @throws IllegalArgumentException si {@code cantidad} es negativa.
   */
  @Override
  public PaqueteHerramientasBuilder agregarBotiquines(int cantidad) {
    validarNoNegativo(cantidad, "Botiquines");
    this.botiquines = cantidad;
    return this;
  }

  /**
   * Construye la instancia de {@link PaqueteHerramientas} con las cantidades
   * acumuladas y resetea el builder para permitir su reutilización.
   *
   * @return el {@code PaqueteHerramientas} construido.
   */
  @Override
  public PaqueteHerramientas build() {
    PaqueteHerramientas paquete = new PaqueteHerramientas(kunais, shurikens, papelesBomba, bombasHumo, botiquines);
    reset();
    return paquete;
  }
}
