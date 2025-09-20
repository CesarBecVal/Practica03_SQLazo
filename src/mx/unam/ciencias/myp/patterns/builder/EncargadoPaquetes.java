package mx.unam.ciencias.myp.patterns.builder;

import java.util.function.Consumer;

public class EncargadoPaquetes {
    private final PaqueteBuilder builder;

    public EncargadoPaquetes(PaqueteBuilder builder) {
        this.builder = builder;
    }

    public PaqueteHerramientas crearPaqueteBasico() {
        builder.agregarKunais(2).agregarShurikens(1).agregarBotiquines(1);
        return builder.build();
    }

    public PaqueteHerramientas crearPaqueteAvanzado() {
        builder.agregarShurikens(2).agregarPapelesBomba(3).agregarBombasHumo(2).agregarBotiquines(2);
        return builder.build();
    }

    public PaqueteHerramientas crearPaqueteTactico() {
        builder.agregarKunais(3).agregarShurikens(2).agregarPapelesBomba(4).agregarBombasHumo(2);
        return builder.build();
    }

    public PaqueteHerramientas crearPaquetePersonalizado(Consumer<PaqueteBuilder> configurador) {
        configurador.accept(builder);
        return builder.build();
    }
}