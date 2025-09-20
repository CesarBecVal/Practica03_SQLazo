package mx.unam.ciencias.myp.patterns.builder;

public interface PaqueteBuilder {
    PaqueteBuilder agregarKunais(int cantidad);
    PaqueteBuilder agregarShurikens(int cantidad);
    PaqueteBuilder agregarPapelesBomba(int cantidad);
    PaqueteBuilder agregarBombasHumo(int cantidad);
    PaqueteBuilder agregarBotiquines(int cantidad);
    PaqueteHerramientas build();
}
