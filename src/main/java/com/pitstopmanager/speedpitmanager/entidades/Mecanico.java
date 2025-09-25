package com.pitstopmanager.speedpitmanager.entidades;

import java.io.Serializable;

/**
 *
 * @author anafilipa
 */
public class Mecanico extends Pessoa implements Serializable{
    private String especialidade; // Exemplo: "Motores", "Aerodinâmica", "Suspensão"
    
    public Mecanico(String nome, int idade, String especialidade) {
        super(nome, idade);
        this.especialidade = especialidade;
    }
    
    public void realizarManutencao(Veiculo veiculo, String descricao) {
        veiculo.realizarManutencao(descricao);
        System.out.println("Mecânico " + nome + " realizou manutenção: " + descricao + " no veículo " + veiculo.getModelo());
    }

    public void ajustarVeiculo(Veiculo veiculo, String ajuste) {
        veiculo.realizarAfinacao(ajuste);
        System.out.println("Mecânico " + nome + " fez ajuste: " + ajuste + " no veículo " + veiculo.getModelo());
    }

    @Override
    public void desempenharFuncao() {
        System.out.println("Mecânico " + nome + " está a trabalhar na área de " + especialidade + ".");
    }
    
    // Agora o método guardarEmFicheiro() da classe abstrata Pessoa vai ser utilizado diretamente
    public void guardarMecanicoEmFicheiro() {
        guardarEmFicheiro(); // Chama o método da classe Pessoa para salvar os dados no arquivo
    }
}
