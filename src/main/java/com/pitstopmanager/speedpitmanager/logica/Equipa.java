package com.pitstopmanager.speedpitmanager.logica;

import com.pitstopmanager.speedpitmanager.Categoria;
import com.pitstopmanager.speedpitmanager.entidades.Veiculo;
import com.pitstopmanager.speedpitmanager.entidades.Pessoa;
import java.util.*;

public class Equipa {
    private String nome;
    private Categoria categoria;  // Exemplo: "Fórmula 1", "MotoGP", etc.
    private List<Pessoa> membros;
    private List<Veiculo> veiculos; // Lista de veículos que pertencem à equipa
    private Map<String, Integer> resultados; // Registo de resultados: competição -> posição final
    private Map<Pessoa, Veiculo> pilotoVeiculoMap; // Associa pilotos aos seus veículos
    protected boolean emCompeticao; // Indica se a equipa está em comthis.emCompeticao = true; // Por padrão, a equipa está em competiçãopetição
    
    public Equipa(String nome, String categoria) {
        // Validação de nome e categoria
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da equipa não pode ser vazio!");
        }
        this.nome = nome;
        this.categoria = Categoria.fromString(categoria); // converte a String para enum;
        this.membros = new ArrayList<>();
        this.veiculos = new ArrayList<>();
        this.resultados = new HashMap<>();
        this.pilotoVeiculoMap = new HashMap<>();
        this.emCompeticao = true; // Por padrão, a equipa está em competição
    }
    
    public void adicionarMembro(Pessoa p) { 
        membros.add(p); 
    }
    
    public void adicionarVeiculo(Veiculo veiculo) { 
        if (veiculo.getCategoria() == this.categoria) {
            veiculos.add(veiculo);
        } else {
            System.out.println("Erro: Veículo não corresponde à categoria da equipa!");
        }
    }

    public void registarResultado(String competicao, int posicao) {
        resultados.put(competicao, posicao);
    }

    public void listarMembros() {
        System.out.println("Membros da equipa " + nome + " (" + categoria + "):");
        for (Pessoa p : membros) {
            System.out.println("- " + p.getNome());
        }
    }

    public void listarResultados() {
        System.out.println("Resultados da equipa " + nome + ":");
        for (Map.Entry<String, Integer> entry : resultados.entrySet()) {
            System.out.println("Competição: " + entry.getKey() + " | Posição final: " + entry.getValue());
        }
    }

    public String getNome() { 
        return nome; 
    }
    public Categoria getCategoria() { 
        return categoria; 
    }
    public String getCategoriaFormatada() {
        return categoria.getNomeFormatado();
    }
    public List<Pessoa> getMembros() {
        return membros;
    }
    public List<Veiculo> getVeiculos() {
        return veiculos;
    }
    
    // Método atribuirVeiculoAoPiloto
    public boolean atribuirVeiculoAoPiloto(String nomePiloto, String nomeVeiculo) {
        Pessoa pilotoEncontrado = null;
        Veiculo veiculoEncontrado = null;

        // Procurar o piloto pelo nome
        for (Pessoa p : membros) {
            if (p.getNome().equalsIgnoreCase(nomePiloto)) {
                pilotoEncontrado = p;
                break;
            }
        }

        // Procurar o veículo pelo nome
        for (Veiculo v : veiculos) {
            if (v.getModelo().equalsIgnoreCase(nomeVeiculo)) {
                veiculoEncontrado = v;
                break;
            }
        }

        // Validar se piloto e veículo existem
        if (pilotoEncontrado == null) {
            System.out.println("Erro: Piloto " + nomePiloto + " não encontrado na equipa!");
            return false;
        }

        if (veiculoEncontrado == null) {
            System.out.println("Erro: Veículo " + nomeVeiculo + " não encontrado na equipa!");
            return false;
        }

        // Atribuir o veículo ao piloto
        pilotoVeiculoMap.put(pilotoEncontrado, veiculoEncontrado);
        System.out.println("Veículo " + nomeVeiculo + " atribuído ao piloto " + nomePiloto);
        return true;
    }
}
