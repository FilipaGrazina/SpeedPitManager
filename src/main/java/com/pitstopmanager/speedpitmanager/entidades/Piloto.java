package com.pitstopmanager.speedpitmanager.entidades;

import com.pitstopmanager.speedpitmanager.Categoria;
import java.io.FileWriter;
import java.io.Serializable;

/**
 *
 * @author anafilipa
 */
public class Piloto extends Pessoa implements Serializable{
    private Categoria categoria;
    private Veiculo veiculo; // Veículo atribuído ao piloto
    private int pontos;

    public Piloto(String nome, int idade, String categoriaStr) {
        super(nome, idade);
        
        // Validação de idade (considerando que um piloto deve ter pelo menos 18 anos, por exemplo)
        if (idade < 18) {
            throw new IllegalArgumentException("Idade do piloto deve ser maior ou igual a 18!");
        }

        this.categoria = Categoria.fromString(categoriaStr);
        this.veiculo = null; // Inicialmente sem veículo
        this.pontos = 0;
    }
    
    public Categoria getCategoria() {
        return categoria;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public int getPontos() {
        return pontos;
    }

    public void atribuirVeiculo(Veiculo veiculo) {
        if (!veiculo.getCategoria().equals(this.categoria)) {
            System.out.println("Erro: O veículo " + veiculo.getModelo() + " não é da categoria do piloto " + nome + ".");
        } else {
            this.veiculo = veiculo;
            System.out.println("Veículo " + veiculo.getModelo() + " atribuído ao piloto " + nome + ".");
        }
    }
    
    public void adicionarPontos(int pontos) {
        this.pontos += pontos;
    }
    
    @Override
    public void desempenharFuncao() {
        try {
            competir();
        } catch (SemVeiculoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void competir() throws SemVeiculoException {
        if (veiculo == null) {
            throw new SemVeiculoException(nome + " não pode competir porque não tem veículo atribuído!");
        }
        System.out.println("Piloto " + nome + " está a competir com o veículo " + veiculo.getModelo() + "!");
        veiculo.competir();
    }
    
    public void guardarEmFicheiro() {
        try {FileWriter writer = new FileWriter("pilotos.txt", true);
            writer.write(this.toString() + "\n");
            writer.close();
            System.out.println("Piloto guardado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao guardar piloto: " + e.getMessage());
        }
    }
    
    // Agora o método guardarEmFicheiro() da classe abstrata Pessoa vai ser utilizado diretamente
    public void guardarPilotoEmFicheiro() {
        guardarEmFicheiro(); // Chama o método da classe Pessoa para salvar os dados no arquivo
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Categoria: " + categoria.getNomeFormatado() + ", Pontos: " + pontos +
               ", Veículo: " + (veiculo != null ? veiculo.getModelo() : "Nenhum");
    }
}
