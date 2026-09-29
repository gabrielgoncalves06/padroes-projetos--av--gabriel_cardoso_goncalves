# Diagrama de Classes — Exercício 1 (Factory Method)

```mermaid
classDiagram
    class Apolice {
        <<abstract>>
        #segurado : String
        +calcularPremio() double*
        +validarCobertura() void*
        +listarDocumentosExigidos() List~String~*
        +getPrefixo() String*
        +getNomeProduto() String*
        +gerarResumo(numero, data, premio) String
    }

    class ApoliceAuto
    class ApoliceResidencial
    class ApoliceVida
    class ApoliceViagem

    Apolice <|-- ApoliceAuto
    Apolice <|-- ApoliceResidencial
    Apolice <|-- ApoliceVida
    Apolice <|-- ApoliceViagem

    class EmissorApolice {
        <<abstract>>
        -CONTADOR : AtomicInteger
        #criarApolice() Apolice*
        +processarContratacao(segurado) ComprovanteEmissao
    }

    class EmissorApoliceAuto {
        +criarApolice() Apolice
    }
    class EmissorApoliceResidencial {
        +criarApolice() Apolice
    }
    class EmissorApoliceVida {
        +criarApolice() Apolice
    }
    class EmissorApoliceViagem {
        +criarApolice() Apolice
    }

    EmissorApolice <|-- EmissorApoliceAuto
    EmissorApolice <|-- EmissorApoliceResidencial
    EmissorApolice <|-- EmissorApoliceVida
    EmissorApolice <|-- EmissorApoliceViagem

    EmissorApoliceAuto ..> ApoliceAuto : cria
    EmissorApoliceResidencial ..> ApoliceResidencial : cria
    EmissorApoliceVida ..> ApoliceVida : cria
    EmissorApoliceViagem ..> ApoliceViagem : cria

    EmissorApolice ..> Apolice : usa (só a abstração)

    class ContratacaoRejeitadaException {
        +ContratacaoRejeitadaException(motivo)
    }

    class ComprovanteEmissao {
        -numeroApolice : String
        -premio : double
        -resumo : String
    }

    class DadosContratacao {
        (campos de todas as linhas)
        +comFipe(v) DadosContratacao
        +comValorImovel(v) DadosContratacao
        +comIdadeSegurado(v) DadosContratacao
        +comDiasViagem(v) DadosContratacao
        (demais builders...)
    }

    class SistemaEmissao {
        -fabricas : Map~TipoApolice, Function~
        +emitir(tipo, segurado, dados) ComprovanteEmissao
        +registrarLinhaDeProduto(tipo, fabrica) void
    }

    SistemaEmissao ..> EmissorApolice : seleciona e usa
    SistemaEmissao ..> DadosContratacao : usa
    SistemaEmissao ..> TipoApolice : usa
    EmissorApolice ..> ComprovanteEmissao : retorna
    Apolice ..> ContratacaoRejeitadaException : lança

    class TipoApolice {
        <<enumeration>>
        AUTO
        RESIDENCIAL
        VIDA
        VIAGEM
    }
```

**Leitura do diagrama**

- **Hierarquia de produtos**: `Apolice` (abstrata) → `ApoliceAuto`, `ApoliceResidencial`, `ApoliceVida`, `ApoliceViagem`.
- **Hierarquia de criadores**: `EmissorApolice` (abstrata) → um `Emissor` concreto por linha de produto.
- **Relação método fábrica ↔ produto criado**: cada `Emissor` concreto sobrescreve `criarApolice()` e retorna exatamente a `Apolice` concreta correspondente; o método `processarContratacao()`, definido uma única vez na superclasse `EmissorApolice`, é `final` e manipula apenas o tipo `Apolice` (nunca uma subclasse concreta).
- **Classe cliente**: `SistemaEmissao` depende de `EmissorApolice` (abstração) e de um `Map<TipoApolice, Function<...>>` para selecionar o criador certo — sem `if`/`switch` decidindo o tipo de produto, o que também sustenta o RNF01 (nova linha de produto = nova entrada no mapa, zero alteração em classe existente).
