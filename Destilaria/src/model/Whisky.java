package model;
import enums.TipoWhisky;

public class Whisky extends Produto{

   private int idade;
   private TipoWhisky tipo;
   private double teorAlcoolico;

   public Whisky(String nome, double preco, int idade, TipoWhisky tipo, double teorAlcoolico){
       super(nome, preco);
       this.idade = idade;
       this.tipo = tipo;
       this.teorAlcoolico = teorAlcoolico;
   }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getTeorAlcoolico() {
        return teorAlcoolico;
    }

    public void setTeorAlcoolico(double teorAlcoolico) {
        this.teorAlcoolico = teorAlcoolico;
    }

    public TipoWhisky getTipo() {
        return tipo;
    }

    public void setTipo(TipoWhisky tipo) {
        this.tipo = tipo;
    }

    @Override
    public String detalhes() {
        return String.format("Whisky: %s, Tipo: %s, Idade: %d anos, Teor Alcoólico: %.2f%%",
            getNome(), tipo, idade, teorAlcoolico);
    }
}


