package com.pitstopmanager.speedpitmanager.entidades;

import com.pitstopmanager.speedpitmanager.Categoria;
import com.pitstopmanager.speedpitmanager.logica.Equipa;
import java.io.Serializable;

public class Carro extends Veiculo implements Serializable {

    public Carro(Equipa equipa, String modelo, String categoriaInput, int potencia, int peso) {
        super(equipa, modelo, Categoria.fromString(categoriaInput), potencia, peso);
    }

    @Override
    public void competir() {
        System.out.println("O carro " + modelo + " da categoria " + categoria + " está a competir!");
    }
    
    // Agora o método guardarEmFicheiro() da classe abstrata Veiculo vai ser utilizado diretamente
    public void guardarCarroEmFicheiro() {
        guardarEmFicheiro(); // Chama o método da classe Pessoa para salvar os dados no arquivo
    }
}
