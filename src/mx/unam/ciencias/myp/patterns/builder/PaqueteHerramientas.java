package mx.unam.ciencias.myp.patterns.builder;

/**
 * Representa un paquete de herramientas ninja. La clase es inmutable: sus
 * cantidades se asignan en el constructor y no pueden modificarse después.
 *
 * <p>Cada unidad tiene un peso asociado (constantes {@code PESO_*}) y el método
 * {@link #getPesoTotal()} devuelve el peso total del paquete en kilogramos.</p>
 *
 * <p>Ejemplo de uso:
 * <pre>
 * PaqueteHerramientas paquete = new PaqueteHerramientas(3, 5, 2, 1, 1);
 * System.out.println(paquete.getPesoTotal());
 * </pre>
 * </p>
 *
 * @author César
 */
public class PaqueteHerramientas {
    private final int kunais;
    private final int shurikens;
    private final int papelesBomba;
    private final int bombasHumo;
    private final int botiquines;

    public static final double PESO_KUNAI = 0.2;
    public static final double PESO_SHURIKENS = 0.05;
    public static final double PESO_PAPEL_BOMBA = 0.15;
    public static final double PESO_BOMBAS_HUMO = 0.25;
    public static final double PESO_BOTIQUINES = 0.5;

    /**
     * Construye un {@code PaqueteHerramientas} con las cantidades indicadas.
     *
     * @param kunais      cantidad de kunais (>= 0).
     * @param shurikens   cantidad de shurikens (>= 0).
     * @param papelesBomba cantidad de papeles bomba (>= 0).
     * @param bombasHumo  cantidad de bombas de humo (>= 0).
     * @param botiquines  cantidad de botiquines (>= 0).
     */
    public PaqueteHerramientas(int kunais, int shurikens, int papelesBomba, int bombasHumo, int botiquines) {
        this.kunais = kunais;
        this.shurikens = shurikens;
        this.papelesBomba = papelesBomba;
        this.bombasHumo = bombasHumo;
        this.botiquines = botiquines; 
    }

    /**
     * Calcula y devuelve el peso total del paquete en kilogramos.
     *
     * <p>El cálculo se realiza multiplicando cada cantidad por su peso por
     * unidad (constantes {@code PESO_*}) y sumando los resultados.</p>
     *
     * @return peso total del paquete en kilogramos.
     */
    public double getPesoTotal() {
        return kunais * PESO_KUNAI + shurikens * PESO_SHURIKENS + papelesBomba * PESO_PAPEL_BOMBA + bombasHumo * PESO_BOMBAS_HUMO + botiquines * PESO_BOTIQUINES;
    }

    /**
     * Representación textual del paquete con cantidades y peso total.
     *
     * @return cadena con el resumen del paquete.
     */
    @Override
    public String toString() {
        return String.format("Paquete{kunais = %d, shurikens = %d, papelesBomba = %d, bombasHumo = %d, botiquines = %d, peso = %.2fkg}", kunais, shurikens, papelesBomba, bombasHumo, botiquines, getPesoTotal());

    }
}
