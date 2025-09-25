package com.pitstopmanager.speedpitmanager.entidades;

import java.io.Serializable;

/**
 *
 * @author anafilipa
 */
public class Engenheiro extends Pessoa implements Serializable{
    private String areaEspecializacao; // Exemplo: "Aerodinâmica", "Telemetria"
    
    public Engenheiro(String nome, int idade, String areaEspecializacao) {
        super(nome, idade);
        this.areaEspecializacao = areaEspecializacao;
    }

    public void analisarVeiculo(Veiculo veiculo) {
        System.out.println("Engenheiro " + nome + " está a analisar o desempenho do veículo " + veiculo.getModelo() + ".");
    }

    public void sugerirMelhoria(Veiculo veiculo, String melhoria) {
        System.out.println("Engenheiro " + nome + " sugeriu melhoria: " + melhoria + " para o veículo " + veiculo.getModelo() + ".");
    }

    @Override
    public void desempenharFuncao() {
        System.out.println("Engenheiro " + nome + " está a analisar e a otimizar os veículos.");
    }
    
    // Agora o método guardarEmFicheiro() da classe abstrata Pessoa vai ser utilizado diretamente
    public void guardarEngenheiroEmFicheiro() {
        guardarEmFicheiro(); // Chama o método da classe Pessoa para salvar os dados no arquivo
    }
}
