package vendas;

import model.Ingrediente;
import model.Whisky;

import java.util.ArrayList;
import java.util.List;

public class Estoque {

    private List<Ingrediente> ingredientes = new ArrayList<>();
    private List<Whisky> whiskies = new ArrayList<>();

    public void adicionarIngrediente(Ingrediente ingrediente){
        ingredientes.add(ingrediente);
    }

    public void adicionarWhisky(Whisky whisky){
        whiskies.add(whisky);
    }

    public List<Whisky> listarWhiskies() { //chamar na main
        return whiskies;
    }

}
