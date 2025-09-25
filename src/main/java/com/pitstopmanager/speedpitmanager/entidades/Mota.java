package com.pitstopmanager.speedpitmanager.entidades;

import com.pitstopmanager.speedpitmanager.Categoria;
import com.pitstopmanager.speedpitmanager.logica.Equipa;
import java.io.Serializable;

public class Mota extends Veiculo implements Serializable{
    private int cilindrada; // Exemplo: 600cc, 1000cc

    public Mota(Equipa equipa, String modelo, Categoria categoria, int potencia, int peso, int cilindrada) {
        super(equipa, modelo, categoria, potencia, peso);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    @Override
    public void competir() {
        System.out.println("A mota " + modelo + " de " + cilindrada + "cc na categoria " + categoria + " está a competir!");
    }
    
    // Agora o método guardarEmFicheiro() da classe abstrata Pessoa vai ser utilizado diretamente
    public void guardarMotaEmFicheiro() {
        guardarEmFicheiro(); // Chama o método da classe Pessoa para salvar os dados no arquivo
    } 
}
