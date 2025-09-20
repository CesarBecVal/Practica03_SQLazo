package mx.unam.ciencias.myp.patterns.builder;

import java.util.function.Consumer;

/**
 * Director/encargado del patrón Builder responsable de orquestar la creación
 * de {@link PaqueteHerramientas} preconfigurados o personalizados usando un
 * {@link PaqueteBuilder}.
 *
 * <p>Esta clase delega las operaciones concretas de ensamblado al builder
 * provisto en su constructor. Provee varios paquetes prefabricados
 * ({@link #crearPaqueteBasico()}, {@link #crearPaqueteAvanzado()},
 * {@link #crearPaqueteTactico()}) y un método para crear paquetes
 * personalizados mediante una {@link Consumer} que configura el builder.</p>
 *
 * <p><b>Observaciones sobre el estado del builder:</b> el comportamiento tras
 * invocar {@code build()} (por ejemplo, si el builder se resetea automáticamente
 * para permitir reutilización) depende de la implementación concreta de
 * {@code PaqueteBuilder}. En la implementación recomendada
 * {@code PaqueteHerramientasBuilder} el builder se resetea después de
 * {@code build()}, por lo que un mismo {@code EncargadoPaquetes} puede ser
 * reutilizado con el mismo builder para crear múltiples paquetes.</p>
 *
 * <p>Ejemplo de uso:
 * <pre>
 * PaqueteHerramientasBuilder builder = new PaqueteHerramientasBuilder();
 * EncargadoPaquetes encargado = new EncargadoPaquetes(builder);
 *
 * PaqueteHerramientas basico = encargado.crearPaqueteBasico();
 * PaqueteHerramientas tactico = encargado.crearPaqueteTactico();
 *
 * PaqueteHerramientas personalizado = encargado.crearPaquetePersonalizado(b ->
 *     b.agregarKunais(5).agregarBotiquines(1));
 * </pre>
 * </p>
 *
 * @author César
 */
public class EncargadoPaquetes {
    private final PaqueteBuilder builder;

    /**
     * Crea un {@code EncargadoPaquetes} que usará el {@code builder} dado
     * para construir los paquetes.
     *
     * @param builder instancia de {@link PaqueteBuilder} que realizará las
     *                operaciones concretas de construcción; no debe ser {@code null}.
     * @throws NullPointerException si {@code builder} es {@code null}.
     */
    public EncargadoPaquetes(PaqueteBuilder builder) {
        this.builder = builder;
    }

    /**
     * Crea un paquete básico con una configuración prefijada:
     * 2 kunais, 1 shuriken y 1 botiquín.
     *
     * @return el {@link PaqueteHerramientas} construido por el builder.
     */
    public PaqueteHerramientas crearPaqueteBasico() {
        builder.agregarKunais(2).agregarShurikens(1).agregarBotiquines(1);
        return builder.build();
    }

    /**
     * Crea un paquete avanzado con una configuración prefijada:
     * 2 shurikens, 3 papeles bomba, 2 bombas de humo y 2 botiquines.
     *
     * @return el {@link PaqueteHerramientas} construido por el builder.
     */
    public PaqueteHerramientas crearPaqueteAvanzado() {
        builder.agregarShurikens(2).agregarPapelesBomba(3).agregarBombasHumo(2).agregarBotiquines(2);
        return builder.build();
    }

    /**
     * Crea un paquete táctico con una configuración prefijada:
     * 3 kunais, 2 shurikens, 4 papeles bomba y 2 bombas de humo.
     *
     * @return el {@link PaqueteHerramientas} construido por el builder.
     */
    public PaqueteHerramientas crearPaqueteTactico() {
        builder.agregarKunais(3).agregarShurikens(2).agregarPapelesBomba(4).agregarBombasHumo(2);
        return builder.build();
    }

    /**
     * Crea un paquete personalizado. El cliente proporciona un {@link Consumer}
     * que recibirá el {@link PaqueteBuilder} para configurarlo (encadenar
     * llamados {@code agregarXxx(...)}) antes de llamar a {@code build()}.
     *
     * <p>Ejemplo:
     * <pre>
     * PaqueteHerramientas p = encargado.crearPaquetePersonalizado(b ->
     *     b.agregarKunais(4).agregarShurikens(6).agregarBotiquines(1));
     * </pre>
     * </p>
     *
     * @param configurador lambda que configura el builder; no debe ser {@code null}.
     * @return el {@link PaqueteHerramientas} construido por el builder.
     * @throws NullPointerException si {@code configurador} es {@code null}.
     */
    public PaqueteHerramientas crearPaquetePersonalizado(Consumer<PaqueteBuilder> configurador) {
        if (configurador == null) {
            throw new NullPointerException("El configurador no puede estar vacío.");
        }
        configurador.accept(builder);
        return builder.build();
    }
}