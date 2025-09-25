package com.pitstopmanager.speedpitmanager.logica;

import com.pitstopmanager.speedpitmanager.interfaces.InterfaceAutomobilismo;
import com.pitstopmanager.speedpitmanager.entidades.Circuito;
import java.util.Random;

/**
 *
 * @author anafilipa
 */
public class F1Competicao extends Competicao implements InterfaceAutomobilismo {
    
    private boolean corridaTerminada = false;
    private String eventoFinal = "";
    
    public F1Competicao(String nome, String data, String hora, Circuito circuito) {
        super(nome, data, hora, circuito);
    }

    @Override
    public void iniciarCompeticao() {
        System.out.println("A competição de Fórmula 1 " + nome + " está a começar no circuito " + circuito.getNome());
        customIniciarCompeticao();
    }

    @Override
    public void calcularClassificacao() {
        System.out.println("Calculando a classificação na competição de Fórmula 1.");
    }

    @Override
    public void aplicarPenalizacoes() {
        System.out.println("Aplicando penalizações na competição de Fórmula 1.");
    }
     
    // Método pit stops
    public void definirPitStop() {
        System.out.println("Pit stop realizado pela equipa.");
    }
    
    @Override
    protected void customIniciarCompeticao() {
        System.out.println("Preparações específicas de Fórmula 1 antes da corrida.");
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        
    public void simularCorrida() {
        Random rand = new Random();
        int voltas = 10; // Exemplo de 10 voltas
        
        System.out.println("=== Início da Corrida de Fórmula 1 ===");
        
        for (int volta = 1; volta <= voltas; volta++) {
            if(corridaTerminada){
                System.out.println("Corrida terminada prematuramente devido a: " + eventoFinal);
            break;
            }
            
            System.out.println("Volta " + volta);
            
            // Eventos aleatórios durante a corrida
            if (rand.nextInt(10) < 2) { // 20% de chance de evento aleatório
                aplicarEventoAleatorio();
            }
            
            // Atualizar a classificação após cada volta
            calcularClassificacao();
            
            // Simula o pit stop
            if (rand.nextInt(10) < 3) { // 30% chance de pit stop
                definirPitStop();
            }
            
            // Pausa para simular tempo real
            try {
                Thread.sleep(500); // Pausa de 500ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (!corridaTerminada) {
            System.out.println("Corrida finalizada normalmente!");
        }
    }

    private void aplicarEventoAleatorio() {
        Random rand = new Random();
        int evento = rand.nextInt(3); // 3 tipos de eventos aleatórios
        switch (evento) {
            case 0:
                System.out.println("Acidente grave ocorrido durante a corrida!");
                corridaTerminada = true;
                eventoFinal = "Acidente grave";
                break;
            case 1:
                System.out.println("Falha mecânica! Carro fora de pista.");
                corridaTerminada = true;
                eventoFinal = "Falha mecânica";
                break;
            case 2:
                System.out.println("Penalização aplicada por ultrapassagem ilegal.");
                break;
        }
    } 
}
