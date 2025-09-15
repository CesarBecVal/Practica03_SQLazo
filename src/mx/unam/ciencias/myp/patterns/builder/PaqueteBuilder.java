package mx.unam.ciencias.myp.patterns.builder;

public class PaqueteBuilder {
    PaqueteBuilder agregarKunais(int cantidad);
    PaqueteBuilder agregarShurikens(int cantidad);
    PaqueteBuilder agregarPapelesBomba(int cantidad);
    PaqueteBuilder agregarBotiquines(int cantidad);
    PaqueteHerramientas build();
}
