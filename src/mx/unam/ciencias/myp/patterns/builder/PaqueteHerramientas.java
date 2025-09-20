package mx.unam.ciencias.myp.patterns.builder;

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

    public PaqueteHerramientas(int kunais, int shurikens, int papelesBomba, int bombasHumo, int botiquines) {
        this.kunais = kunais;
        this.shurikens = shurikens;
        this.papelesBomba = papelesBomba;
        this.bombasHumo = bombasHumo;
        this.botiquines = botiquines; 
    }

    public double getPesoTotal() {
        return kunais * PESO_KUNAI + shurikens * PESO_SHURIKENS + papelesBomba * PESO_PAPEL_BOMBA + bombasHumo * PESO_BOMBAS_HUMO + botiquines * PESO_BOTIQUINES;
    }

    @Override
    public String toString() {
        return String.format("Paquete{kunais = %d, shurikens = %d, papelesBomba = %d, bombasHumo = %d, botiquines = %d, peso = %.2fkg}", kunais, shurikens, papelesBomba, bombasHumo, botiquines, getPesoTotal());

    }
}
