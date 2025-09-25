package com.pitstopmanager.speedpitmanager.entidades;

import java.io.Serializable;

/**
 *
 * @author anafilipa
 */
public class Circuito implements Serializable{
    private String nome;
    private double comprimento;
    private String tipoTerreno; // Exemplo: "asfalto", "terra", "misturado"
    private int numVoltas;
    private String tipoCompeticao; // "Automobilismo" ou "Motociclismo"

    public Circuito(String nome, double comprimento, String tipoTerreno, int numVoltas, String tipoCompeticao) {
        this.nome = nome;
        this.comprimento = comprimento;
        this.tipoTerreno = tipoTerreno;
        this.numVoltas = numVoltas;
        this.tipoCompeticao = tipoCompeticao;
    }

    public double calcularDistanciaTotal() {
        double fatorTerreno = 1.0;
        if (tipoTerreno.equals("terra")) {
            fatorTerreno = 1.2;
        } else if (tipoTerreno.equals("asfalto")) {
            fatorTerreno = 0.9;
        }

        return comprimento * numVoltas * fatorTerreno;
    }

    public String getNome() {
        return nome;
    }
    
    public double getComprimento() {
        return comprimento;
    }

    public String getTipoTerreno() {
        return tipoTerreno;
    }

    public int getNumVoltas() {
        return numVoltas;
    }
    
    public String getTipoCompeticao() { 
        return tipoCompeticao; 
    }
}
