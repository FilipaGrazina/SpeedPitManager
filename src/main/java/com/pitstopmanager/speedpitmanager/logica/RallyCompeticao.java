package com.pitstopmanager.speedpitmanager.logica;

import com.pitstopmanager.speedpitmanager.interfaces.InterfaceAutomobilismo;
import com.pitstopmanager.speedpitmanager.entidades.Circuito;
import java.util.Random;

/**
 *
 * @author anafilipa
 */
public class RallyCompeticao extends Competicao implements InterfaceAutomobilismo {
    
    private boolean corridaTerminada = false;
    private String eventoFinal = "";
    
    public RallyCompeticao(String nome, String data, String hora, Circuito circuito) {
        super(nome, data, hora, circuito);
    }

    @Override
    public void iniciarCompeticao() {
        System.out.println("A competição de Rally " + nome + " está começando no circuito " + circuito.getNome());
        customIniciarCompeticao();
    }

    @Override
    public void calcularClassificacao() {
        System.out.println("Calculando a classificação na competição de Rally.");
    }

    @Override
    public void aplicarPenalizacoes() {
        System.out.println("Aplicando penalizações na competição de Rally.");
    }

    // Método específico para Rally, como verificar o terreno
    public void verificarTerreno() {
        System.out.println("Verificando o terreno da competição de Rally.");
    }

    @Override
    protected void customIniciarCompeticao() {
        System.out.println("Inspeção dos veículos e reconhecimento do terreno de Rally.");
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public void simularCorrida() {
        Random rand = new Random();
        int voltas = 5; // Exemplo de 5 voltas no Rally
        
        System.out.println("=== Início da Corrida de Rally ===");
        
        for (int volta = 1; volta <= voltas; volta++) {
            if (corridaTerminada) {
                System.out.println("Corrida terminada prematuramente devido a: " + eventoFinal);
                break;
            }
            
            System.out.println("Volta " + volta + " da corrida de Rally.");
            
            // Eventos aleatórios durante a corrida
            if (rand.nextInt(10) < 3) { // 30% de chance de evento aleatório
                aplicarEventoAleatorio();
            }
            
            // Atualizar a classificação após cada volta
            calcularClassificacao();
            
            // Simula a verificação do terreno
            if (rand.nextInt(10) < 4) { // 40% chance de verificar terreno
                verificarTerreno();
            }
            
            // Pausa para simular tempo real
            try {
                Thread.sleep(1000); // Pausa de 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (!corridaTerminada) {
            System.out.println("Corrida de Rally finalizada normalmente!");
        }
    }

    private void aplicarEventoAleatorio() {
        Random rand = new Random();
        int evento = rand.nextInt(2); // 2 tipos de eventos aleatórios
        switch (evento) {
            case 0:
                System.out.println("Acidente no terreno irregular!");
                corridaTerminada = true;
                eventoFinal = "Acidente em terreno";
                break;
            case 1:
                System.out.println("Penalização por atalho não autorizado.");
                break;
        }
    }   
}
