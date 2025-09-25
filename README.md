# SpeedPitManager

**Breve descrição**

Gestor simples de equipas e competições (F1, MotoGP, Rally) em Java.
Permite criar equipas, adicionar membros (pilotos, mecânicos, engenheiros), registar veículos (carros, motas) e gerir competições com um menu de consola.

O SpeedPitManager é um projeto académico em Java que simula a gestão de equipas e competições de automobilismo e motociclismo (F1, MotoGP e Rally). A aplicação corre em consola e permite criar equipas, adicionar membros (pilotos, mecânicos e engenheiros), registar veículos (carros e motas) e atribuí-los a pilotos, tudo isto enquanto navegas por um menu simples. Três competições de exemplo são criadas automaticamente no arranque para poderes experimentar de imediato.


**Tecnologias:**
- Java 17+
- Maven
- JUnit 5 para testes (testes em progresso)


**Funcionalidades (resumo)**
- Entidades (entidades/)
  - Pessoa (abstrata)
    - subclasses: Piloto, Mecanico, Engenheiro
  - Veiculo (abstrata)
    - subclasses: Carro, Mota
  - Circuito (nome, comprimento, terreno, nº voltas, tipo de competição)

- Lógica (logica/)
  - Equipa
    - gestão de membros e veículos
    - Atribuição veículo ↔ piloto por nome/modelo
    - registo simples de resultados
  - Competicao (abstrata) + variações
    - F1Competicao, MotoGPCompeticao, RallyCompeticao
    - Simulações com eventos aleatórios, classificação e penalizações
  - Interfaces
    - InterfaceAutomobilismo, InterfaceMotociclismo
- Suporte
  - Categoria (enum) com fromString e nome formatado
  - FicheiroUtils (serialização simples)
  - SpeedPitManager (Main & Menu)


**Fluxo da aplicação (menu)**

1. Escolher uma competição (três são criadas por defeito).  
2. Gerir: criar equipa, adicionar piloto/mecânico/engenheiro, adicionar carro/mota (com validações), atribuir veículo ao piloto, listar equipas.

**Estrutura do projeto**
```
src/
  main/
    java/
      com/pitstopmanager/speedpitmanager/
        SpeedPitManager.java            # main
        Categoria.java
        FicheiroUtils.java
        entidades/
          Pessoa.java, Piloto.java, Engenheiro.java, Mecanico.java
          Veiculo.java, Carro.java, Mota.java
          Circuito.java
        interfaces/
          InterfaceAutomobilismo.java
          InterfaceMotociclismo.java
        logica/
          Equipa.java
          Competicao.java
          F1Competicao.java
          MotoGPCompeticao.java
          RallyCompeticao.java
  test/
    java/
      # EquipaIT.java (em progresso)
```

**Ficheiros de dados**

As classes gravam linhas de texto em ficheiros na pasta de execução:
- pessoas.txt — registos de Pessoa (via guardarEmFicheiro() em Pessoa)
- pilotos.txt — registos de Piloto
- veiculos.txt — registos de Veiculo, Carro, Mota


**Notas importantes**

Nas classes de competição, os métodos customIniciarCompeticao() ainda lançam UnsupportedOperationException (a implementar).  

Validações:
- Piloto exige idade ≥ 18.
- Veiculo valida potência e peso positivos; no menu há limites por tipo.
- Equipa só aceita Veiculo com a mesma Categoria.
    
O método Equipa.atribuirVeiculoAoPiloto(...) associa piloto ↔ veículo por nome/modelo.  

Há um teste EquipaIT em progresso; quando estabilizar, podes ativar uma pipeline de build (GitHub Actions) para compilar automaticamente.


**Próximos passos**
- Implementar customIniciarCompeticao() e terminar simulações.
- Mover I/O de texto para uma camada de repositório e/ou recursos.
- Testes unitários (JUnit) para Equipa, Piloto, Veiculo e Categoria.fromString.

Requisitos: 
JDK 17+
Maven 3.9+ (ou wrappers mvnw/mvnw.cmd se adicionares ao repo)
