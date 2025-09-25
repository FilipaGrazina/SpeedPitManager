package com.pitstopmanager.speedpitmanager.logica;

import com.pitstopmanager.speedpitmanager.interfaces.InterfaceMotociclismo;
import com.pitstopmanager.speedpitmanager.entidades.Circuito;
import java.util.Random;

/**
 *
 * @author anafilipa
 */
public class MotoGPCompeticao extends Competicao implements InterfaceMotociclismo {
    
    private boolean corridaTerminada = false;
    private String eventoFinal = "";
    
    public MotoGPCompeticao(String nome, String data, String hora, Circuito circuito) {
        super(nome, data, hora, circuito);
    }

    @Override
    public void iniciarCompeticao() {
        System.out.println("A competição de MotoGP " + nome + " está começando no circuito " + circuito.getNome());
        customIniciarCompeticao();
    }

    @Override
    public void calcularClassificacao() {
        System.out.println("Calculando a classificação na competição de MotoGP.");
    }

    @Override
    public void aplicarPenalizacoes() {
        System.out.println("Aplicando penalizações na competição de MotoGP.");
    }

    // Método específico para MotoGP, como ajustes nas motas
    public void ajustarMoto() {
        System.out.println("Ajustando a moto para a competição MotoGP.");
    }
    
    @Override
        protected void customIniciarCompeticao() {
            System.out.println("Verificação dos pneus e equipamentos de segurança da MotoGP.");
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
        
    public void simularCorrida() {
        Random rand = new Random();
        int voltas = 8; // Exemplo de 8 voltas no MotoGP
        
        System.out.println("=== Início da Corrida de MotoGP ===");
        
        for (int volta = 1; volta <= voltas; volta++) {
            if (corridaTerminada) {
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
            
            // Simula ajustes na moto
            if (rand.nextInt(10) < 3) { // 30% chance de ajustar moto
                ajustarMoto();
            }
            
            // Pausa para simular tempo real
            try {
                Thread.sleep(750); // Pausa de 750ms
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
        int evento = rand.nextInt(3);
        switch (evento) {
            case 0:
                System.out.println("Queda grave! Piloto fora da corrida.");
                corridaTerminada = true;
                eventoFinal = "Queda grave";
                break;
            case 1:
                System.out.println("Problema técnico! Mota encostada.");
                corridaTerminada = true;
                eventoFinal = "Problema técnico";
                break;
            case 2:
                System.out.println("Advertência por conduta antidesportiva.");
                break;
        }
    }
}
