package com.pitstopmanager.speedpitmanager.entidades;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author anafilipa
 */
public abstract class Pessoa implements Serializable{
    
    protected String nome;
    protected int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public abstract void desempenharFuncao(); // Implementado nas subclasses

    public void guardarEmFicheiro() {
        try {FileWriter writer = new FileWriter("pessoas.txt", true);
            writer.write(this.toString() + "\n");  
            writer.close();
            System.out.println("Pessoa guardada com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao guardar pessoa: " + e.getMessage());
        }
    }
    
    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade;
    }
    
}

// Exceções personalizadas
class SemVeiculoException extends Exception {
    public SemVeiculoException(String message) {
        super(message);
    } 
}
