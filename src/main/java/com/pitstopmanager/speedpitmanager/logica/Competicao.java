package com.pitstopmanager.speedpitmanager.logica;

import com.pitstopmanager.speedpitmanager.interfaces.InterfaceAutomobilismo;
import com.pitstopmanager.speedpitmanager.interfaces.InterfaceMotociclismo;
import com.pitstopmanager.speedpitmanager.entidades.Circuito;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anafilipa
 */
public abstract class Competicao implements InterfaceAutomobilismo, InterfaceMotociclismo {
    protected String nome;
    protected String data;
    protected String hora;
    protected List<Equipa> equipas;
    protected Circuito circuito;

    public Competicao(String nome,  String data, String hora, Circuito circuito) {
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.equipas = new ArrayList<>();
        this.circuito = circuito;
    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public List<Equipa> getEquipas() {
        return equipas;
    }

    // Métodos relacionados à gestão das equipas
    public void adicionarEquipa(Equipa equipa) {
        equipas.add(equipa);
    }

    public void removerEquipa(Equipa equipa) {
        equipas.remove(equipa);
    }

    public void listarEquipas() {
        System.out.println("Equipas participantes na competição " + nome + ":");
        for (Equipa equipa : equipas) {
            System.out.println("- " + equipa.getNome());
        }
    }

    /**
    *Método para iniciar a competição com comportamento polimórfico
    */
    @Override
    public void iniciarCompeticao() {
        System.out.println("A competição " + nome + " está começando no circuito " + circuito.getNome());
        customIniciarCompeticao();
    }

    // Métodos personalizados para as subclasses
    protected abstract void customIniciarCompeticao();  // Cada classe de competição define seu próprio início
    @Override
    public abstract void calcularClassificacao();
    @Override
    public abstract void aplicarPenalizacoes();
}
