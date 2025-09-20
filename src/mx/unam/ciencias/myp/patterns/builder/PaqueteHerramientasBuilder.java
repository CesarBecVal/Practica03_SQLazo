

public class PaqueteHerramientasBuilder implements PaqueteBuilder {
  private int kunais;
  private int shurikens;
  private int papelesBomba;
  private int bombasHumo;
  private int botiquines;

  public PaqueteHerramientasBuilder() {
    reset();
  }

  private void reset () {
    kunais = shurikens = papelesBomba = bombasHumo = botiquines = 0;
  }

  private void validarNoNegativo(int cantidad, String Nombre) {
    if (cantidad < 0) {
      throw new IllegalArgumentException("No puedes recibir una cantidad negativa de " + nombre);
    }
  }

  @Override 
  public void PaqueteHerramientasBuilder agregarKunais(int cantidad) {
    validarNoNegativo(cantidad, "Kunais");
    this.kuanis = cantidad;
    return this;
  }

  @Override 
  public PaqueteHerramientasBuilder agregarShurikens(int cantidad) {
    validarNoNegativo(cantidad, "Shurikens");
    this.shurikens += cantidad;
    return this; 
  }

  @Override 
  public PaqueteHerramientasBuilder agregarPapelesBomba(int cantidad) {
    validarNoNegativo(cantidad, "Papeles Bomba");
    this.papelesBomba = cantidad;
    return this;
  }

  @Override 
  public PaqueteHerramientasBuilder agregarBombasHumo(int cantidad) {
    validarNoNegativo(cantidad, "Bombas de Humo");
    this.bombasHuma = cantidad;
    return this;
  }

  @Override
  public PaqueteHerramientasBuilder agregarBotiquines(int cantidad) {
    validarNoNegativo(cantidad, "Botiquines");
    this.botiquines = cantidad;
    retun this;
  }
}
