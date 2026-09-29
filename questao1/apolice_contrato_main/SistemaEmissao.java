public class SistemaEmissao {

    public ComprovanteEmissao emitir(TipoApolice tipo, String segurado, DadosContratacao dados)
            throws ContratacaoRejeitadaException {

        EmissorApolice emissor;

        switch (tipo) {
            case AUTO:
                emissor = new EmissorApoliceAuto(
                        dados.getValorFipe(), dados.getIdadeCondutor(),
                        dados.getTempoHabilitacaoAnos(), dados.getCoberturaTerceiros());
                break;

            case RESIDENCIAL:
                emissor = new EmissorApoliceResidencial(
                        dados.getValorImovel(), dados.isAltoPadrao(),
                        dados.isPossuiEscrituraOuContrato());
                break;

            case VIDA:
                emissor = new EmissorApoliceVida(
                        dados.getIdadeSegurado(), dados.getCapitalSegurado(),
                        dados.isFumante(), dados.isPossuiAtestadoMedico());
                break;

            case VIAGEM:
                emissor = new EmissorApoliceViagem(
                        dados.getDiasViagem(), dados.isDestinoInternacional(),
                        dados.getCoberturaAssistenciaMedicaUsd(), dados.isPossuiPassaporte());
                break;

            default:
                throw new IllegalArgumentException("Linha de produto não registrada: " + tipo);
        }

        return emissor.processarContratacao(segurado);
    }

    
}


