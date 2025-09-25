package com.pitstopmanager.speedpitmanager.entidades;

import com.pitstopmanager.speedpitmanager.Categoria;
import com.pitstopmanager.speedpitmanager.logica.Equipa;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Veiculo implements Serializable{
    protected Equipa equipa;
    protected String modelo;
    protected Categoria categoria;
    protected int potencia;   // em cavalos (HP)
    protected int peso;       // em kg
    protected List<String> manutencoes;  // Histórico de manutenções
    protected List<String> afinacoes;    // Histórico de afinações
    protected boolean emManutencao; // Variável para controlar se o veículo está em manutenção

    public Veiculo(Equipa equipa, String modelo, Categoria categoriaInput, int potencia, int peso) {
        this.equipa = equipa;
        this.categoria = categoriaInput;
        
        // Validação de potência e peso
        if (potencia <= 0) {
            throw new IllegalArgumentException("Potência do veículo deve ser um valor positivo!");
        }
        if (peso <= 0) {
            throw new IllegalArgumentException("Peso do veículo deve ser um valor positivo!");
        }
        this.modelo = modelo;
        this.potencia = potencia;
        this.peso = peso;
        this.manutencoes = new ArrayList<>();
        this.afinacoes = new ArrayList<>();
        this.emManutencao = false; // Inicialmente, o veículo não está em manutenção
    }

    public void realizarManutencao(String descricao) {
        if (!emManutencao) {
            System.out.println("Veículo " + modelo + " não está em manutenção.");
            return;
        }
        manutencoes.add(descricao);
        System.out.println("Manutenção realizada no " + modelo + ": " + descricao);
        emManutencao = false; // Após realizar a manutenção, o veículo sai da manutenção
    }
    
    public void colocarEmManutencao() {
        emManutencao = true;
        System.out.println("Veículo " + modelo + " colocado em manutenção.");
    }

    public void realizarAfinacao(String descricao) {
        afinacoes.add(descricao);
        System.out.println("Afinação realizada no " + modelo + ": " + descricao);
    }

    public void listarHistoricoManutencao() {
        System.out.println("Histórico de manutenções do " + modelo + ":");
        for (String m : manutencoes) {
            System.out.println("- " + m);
        }
    }

    public void listarHistoricoAfinacoes() {
        System.out.println("Histórico de afinações do " + modelo + ":");
        for (String a : afinacoes) {
            System.out.println("- " + a);
        }
    }

    public String getModelo() { 
        return modelo; 
    }
    public Categoria getCategoria() { 
        return categoria; 
    }
    public int getPotencia() { 
        return potencia; 
    }
    public int getPeso() { 
        return peso; 
    }
    
    public boolean isEmManutencao() {
        return emManutencao;
    }

    public abstract void competir();
    
    public void guardarEmFicheiro() {
        try {
            // Aqui podemos usar "veiculos.txt" ou outro nome para o ficheiro
            FileWriter writer = new FileWriter("veiculos.txt", true);
            writer.write(this.toString() + "\n");
            writer.close();
            System.out.println("Veiculo guardado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao guardar veiculo: " + e.getMessage());
        }
    }    
}
