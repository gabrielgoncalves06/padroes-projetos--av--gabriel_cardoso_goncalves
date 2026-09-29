import java.util.List;

/** Produto concreto RF02 — Apólice Residencial. */
public class ApoliceResidencial extends Apolice {

    private final double valorImovel;
    private final boolean altoPadrao;
    private final boolean possuiEscrituraOuContrato;

    public ApoliceResidencial(double valorImovel, boolean altoPadrao, boolean possuiEscrituraOuContrato) {
        this.valorImovel = valorImovel;
        this.altoPadrao = altoPadrao;
        this.possuiEscrituraOuContrato = possuiEscrituraOuContrato;
    }

    @Override
    public double calcularPremio() {
        double premioAnual = valorImovel * 0.015;
        if (altoPadrao) {
            premioAnual *= 1.25;
        }
        return premioAnual / 12.0;
    }

    @Override
    public void validarCobertura() throws ContratacaoRejeitadaException {
        if (!possuiEscrituraOuContrato) {
            throw new ContratacaoRejeitadaException(
                    "Apólice Residencial rejeitada: escritura ou contrato de locação não apresentado.");
        }
    }

    @Override
    public List<String> listarDocumentosExigidos() {
        return List.of("Escritura ou contrato de locação", "Comprovante de residência");
    }

    @Override
    public String getPrefixo() {
        return "RES-";
    }

    @Override
    public String getNomeProduto() {
        return "Seguro Residencial";
    }
}
