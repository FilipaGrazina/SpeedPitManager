package com.pitstopmanager.speedpitmanager;

import com.pitstopmanager.speedpitmanager.entidades.Carro;
import com.pitstopmanager.speedpitmanager.logica.RallyCompeticao;
import com.pitstopmanager.speedpitmanager.logica.MotoGPCompeticao;
import com.pitstopmanager.speedpitmanager.logica.F1Competicao;
import com.pitstopmanager.speedpitmanager.logica.Competicao;
import com.pitstopmanager.speedpitmanager.logica.Equipa;
import com.pitstopmanager.speedpitmanager.entidades.Circuito;
import com.pitstopmanager.speedpitmanager.entidades.Engenheiro;
import com.pitstopmanager.speedpitmanager.entidades.Mecanico;
import com.pitstopmanager.speedpitmanager.entidades.Mota;
import com.pitstopmanager.speedpitmanager.entidades.Piloto;
import com.pitstopmanager.speedpitmanager.entidades.Veiculo;
import java.util.*;

public class SpeedPitManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Competicao> competicoes = new ArrayList<>();
        
        // Criando circuitos com tipos específicos
        Circuito circuitoMonaco = new Circuito("Circuito de Mônaco", 3000, "asfalto", 78, "Automobilismo");
        Circuito circuitoSafari = new Circuito("Rally Safari", 5000, "terra", 100, "Automobilismo");
        Circuito circuitoAragon = new Circuito("Circuito de Aragón", 4000, "asfalto", 45, "Motociclismo");
        
        // Criar competições automaticamente
        competicoes.add(new F1Competicao("Grand Prix", "2025-07-20", "14:00", circuitoMonaco));
        competicoes.add(new RallyCompeticao("Rally Championship", "2025-09-10", "09:00", circuitoSafari));
        competicoes.add(new MotoGPCompeticao("MotoGP Cup", "2025-05-05", "16:00", circuitoAragon));
        
        Competicao competicaoAtual = null;
        boolean sair = false;

        while (!sair) {
            System.out.println("\nCompetições disponíveis:");
            for (int i = 0; i < competicoes.size(); i++) {
                System.out.println((i + 1) + ". " + competicoes.get(i).getNome());
            }
            System.out.println("0. Sair");
            System.out.print("Escolha uma competição para gerir: ");
            
            int escolhaComp = scanner.nextInt() - 1;
            scanner.nextLine();

            if (escolhaComp == -1) {
                sair = true;
                continue;
            }

            if (escolhaComp < 0 || escolhaComp >= competicoes.size()) {
                System.out.println("Escolha inválida. Tente novamente.");
                continue;
            }

            competicaoAtual = competicoes.get(escolhaComp);
            
            boolean voltarMenu = false;
            while (!voltarMenu) {
                System.out.println("\nMenu de Gestão da Competição: " + competicaoAtual.getNome());
                System.out.println("1. Criar Equipa");
                System.out.println("2. Adicionar Piloto a uma Equipa");
                System.out.println("3. Adicionar Veículo a uma Equipa");
                System.out.println("4. Atribuir Veiculo ao Piloto");
                System.out.println("5. Adicionar Mecanico a uma Equipa");
                System.out.println("6. Adicionar Engenheiro a uma Equipa");
                System.out.println("7. Listar Equipas na Competição");
                System.out.println("8. Ir para Competicoes");
                System.out.print("Escolha uma opção: ");
                
                int opcao = scanner.nextInt();
                scanner.nextLine();
                
                switch (opcao) {
                    case 1:
                        System.out.print("Nome da equipa: ");
                        String nomeEquipa = scanner.nextLine();
                        System.out.print("Categoria da equipa: ");
                        String categoriaEquipa = scanner.nextLine();
                        Equipa novaEquipa = new Equipa(nomeEquipa, categoriaEquipa);
                        competicaoAtual.adicionarEquipa(novaEquipa);
                        System.out.println("Equipa " + nomeEquipa + " criada!");
                        break;
                        
                    case 2:
                        if (competicaoAtual.getEquipas().isEmpty()) {
                            System.out.println("Nenhuma equipa disponível. Crie uma equipa primeiro!");
                            break;
                        }
                        System.out.print("Nome do piloto: ");
                        String nomePiloto = scanner.nextLine();
                        System.out.print("Idade do piloto: ");
                        int idadePiloto = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Categoria: ");
                        String categoria = scanner.nextLine();
                        Piloto piloto = new Piloto(nomePiloto, idadePiloto, categoria);
                        // Guardar os dados no ficheiro
                        piloto.guardarPilotoEmFicheiro();
                        competicaoAtual.getEquipas().get(0).adicionarMembro(piloto);
                        System.out.println("Piloto " + nomePiloto + " adicionado à equipa!");
                        break;
                        
                    case 3:
                        if (competicaoAtual.getEquipas().isEmpty()) {
                            System.out.println("Nenhuma equipa disponível. Crie uma equipa primeiro!");
                            break;
                        }

                        // Se tipoVeiculo já foi declarado anteriormente, apenas atribuímos o valor
                        System.out.println("1. Carro\n2. Mota");
                        System.out.print("Escolha o tipo de veículo: ");
                        int tipoVeiculo = scanner.nextInt();  // Aqui você reutiliza a variável já definida
                        scanner.nextLine(); // Limpar o buffer de entrada

                        // O restante do código permanece igual
                        System.out.print("Modelo do veículo: ");
                        String modelo = scanner.nextLine();

                        System.out.print("Categoria do veículo: ");
                        String categoriaVeiculo = scanner.nextLine();

                        System.out.print("Potência do veículo (50 a 1000 cv): ");
                        int potenciaVeiculo = scanner.nextInt();

                        System.out.print("Peso do veículo (100 a 1500 kg): ");
                        int pesoVeiculo = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer de entrada

                        // Verificação das margens plausíveis, com base no tipo de veículo escolhido
                        boolean dadosValidos = true;

                        if (tipoVeiculo == 1) {  // Carro
                            if (potenciaVeiculo < 100 || potenciaVeiculo > 1000) {
                                System.out.println("Erro: A potência do carro deve estar entre 100 e 1000 cv.");
                                dadosValidos = false;
                            }
                            if (pesoVeiculo < 500 || pesoVeiculo > 1500) {
                                System.out.println("Erro: O peso do carro deve estar entre 500 e 1500 kg.");
                                dadosValidos = false;
                            }
                        } else if (tipoVeiculo == 2) {  // Mota
                            if (potenciaVeiculo < 50 || potenciaVeiculo > 300) {
                                System.out.println("Erro: A potência da mota deve estar entre 50 e 300 cv.");
                                dadosValidos = false;
                            }
                            if (pesoVeiculo < 100 || pesoVeiculo > 300) {
                                System.out.println("Erro: O peso da mota deve estar entre 100 e 300 kg.");
                                dadosValidos = false;
                            }
                        } else {
                            System.out.println("Erro: Escolha inválida para o tipo de veículo.");
                            dadosValidos = false;
                        }

                        // Se os dados forem válidos, criar o veículo e adicioná-lo à equipa
                        if (dadosValidos) {
                            Equipa equipaAtual = competicaoAtual.getEquipas().get(0);

                            Veiculo veiculo = (tipoVeiculo == 1) ? 
                                new Carro(equipaAtual, modelo, categoriaVeiculo, potenciaVeiculo, pesoVeiculo) :
                                new Mota(equipaAtual, modelo, Categoria.valueOf(categoriaVeiculo.toUpperCase()), potenciaVeiculo, pesoVeiculo, 1000);

                            // Guardar os dados no ficheiro dependendo do tipo de veículo
                            if (veiculo instanceof Carro) {
                                ((Carro) veiculo).guardarCarroEmFicheiro();  // Se for um Carro, chama guardarCarroEmFicheiro()
                            } else if (veiculo instanceof Mota) {
                                ((Mota) veiculo).guardarMotaEmFicheiro();    // Se for uma Mota, chama guardarMotaEmFicheiro()
                            }

                            // Adicionar o veículo à equipa
                            competicaoAtual.getEquipas().get(0).adicionarVeiculo(veiculo);
                            System.out.println("Veículo " + modelo + " adicionado!");
                        }
                        break;

                    case 4:
                        System.out.print("Nome do piloto: ");
                        String nomePilotoAtribuir = scanner.nextLine();
                        System.out.print("Modelo do veículo: ");
                        String modeloVeiculoAtribuir = scanner.nextLine();
                        boolean atribuido = false;
                        // Atribuição de veículo ao piloto - verificar se o piloto pertence à equipa
                        for (Equipa equipa : competicaoAtual.getEquipas()) {
                            atribuido = equipa.atribuirVeiculoAoPiloto(nomePilotoAtribuir, modeloVeiculoAtribuir);
                            if (atribuido) {
                                break;
                            }
                        }
                        System.out.println(atribuido ? "Veículo atribuído com sucesso!" : "Erro ao atribuir veículo.");
                        break;
                        
                    case 5:
                        if (competicaoAtual.getEquipas().isEmpty()) {
                            System.out.println("Nenhuma equipa disponível. Crie uma equipa primeiro!");
                            break;
                        }
                        System.out.print("Nome do mecanico: ");
                        String nomeMecanico = scanner.nextLine();
                        System.out.print("Idade do mecanico: ");
                        int idadeMecanico = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Categoria: ");
                        String especialidade = scanner.nextLine();
                        Mecanico mecanico = new Mecanico(nomeMecanico, idadeMecanico, especialidade);
                        // Guardar os dados no ficheiro
                        mecanico.guardarMecanicoEmFicheiro();
                        competicaoAtual.getEquipas().get(0).adicionarMembro(mecanico);
                        System.out.println("Mecanico " + nomeMecanico + " adicionado à equipa!");
                        break;
                        
                    case 6:
                        if (competicaoAtual.getEquipas().isEmpty()) {
                            System.out.println("Nenhuma equipa disponível. Crie uma equipa primeiro!");
                            break;
                        }
                        System.out.print("Nome do engenheiro: ");
                        String nomeEngenheiro = scanner.nextLine();
                        System.out.print("Idade do engenheiro: ");
                        int idadeEngenheiro = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Categoria: ");
                        String areaEspecializacao = scanner.nextLine();
                        Engenheiro engenheiro = new Engenheiro(nomeEngenheiro, idadeEngenheiro, areaEspecializacao);
                        // Guardar os dados no ficheiro
                        engenheiro.guardarEngenheiroEmFicheiro();
                        competicaoAtual.getEquipas().get(0).adicionarMembro(engenheiro);
                        System.out.println("Engenheiro " + nomeEngenheiro + " adicionado à equipa!");
                        break;
                        
                    case 7:
                        competicaoAtual.listarEquipas();
                        break;
                        
                    case 8:
                        voltarMenu = true;
                        sair = true;
                        break;
                    
                    default:
                        System.out.println("Opção inválida!");
                }
            }
        }
        scanner.close();
        System.out.println("Programa encerrado.");
    }
}
