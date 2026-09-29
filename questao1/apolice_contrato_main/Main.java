/** Classe de teste: emite uma apólice de cada linha e mostra um exemplo de rejeição. */
public class Main {
    public static void main(String[] args) {
        SistemaEmissao sistema = new SistemaEmissao();

        try {
            ComprovanteEmissao auto = sistema.emitir(TipoApolice.AUTO, "Gabriel Souza",
                    new DadosContratacao()
                            .comFipe(60000.0)
                            .comIdadeCondutor(22)
                            .comTempoHabilitacao(1)
                            .comCoberturaTerceiros(80000.0));
            System.out.println(auto.getResumo());

            ComprovanteEmissao residencial = sistema.emitir(TipoApolice.RESIDENCIAL, "Marina Costa",
                    new DadosContratacao()
                            .comValorImovel(450000.0)
                            .comAltoPadrao(true)
                            .comEscrituraOuContrato(true));
            System.out.println(residencial.getResumo());

            ComprovanteEmissao vida = sistema.emitir(TipoApolice.VIDA, "João Pereira",
                    new DadosContratacao()
                            .comIdadeSegurado(40)
                            .comCapitalSegurado(600000.0)
                            .comFumante(false)
                            .comAtestadoMedico(true));
            System.out.println(vida.getResumo());

            ComprovanteEmissao viagem = sistema.emitir(TipoApolice.VIAGEM, "Ana Lima",
                    new DadosContratacao()
                            .comDiasViagem(10)
                            .comDestinoInternacional(true)
                            .comCoberturaAssistenciaMedica(35000.0)
                            .comPassaporte(true));
            System.out.println(viagem.getResumo());

            // Exemplo de rejeição: cobertura contra terceiros abaixo do mínimo exigido por RF01.
            sistema.emitir(TipoApolice.AUTO, "Carlos Nunes",
                    new DadosContratacao()
                            .comFipe(30000.0)
                            .comIdadeCondutor(30)
                            .comTempoHabilitacao(5)
                            .comCoberturaTerceiros(20000.0));

        } catch (ContratacaoRejeitadaException e) {
            System.out.println("Contratação rejeitada: " + e.getMessage());
        }
    }
}
