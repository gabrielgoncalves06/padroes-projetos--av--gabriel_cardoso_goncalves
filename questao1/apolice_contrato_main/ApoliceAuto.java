import java.util.List;

/** Produto concreto RF01 — Apólice de Automóvel. */
public class ApoliceAuto extends Apolice {

    private final double valorFipe;
    private final int idadeCondutor;
    private final int tempoHabilitacaoAnos;
    private final double coberturaTerceiros;

    public ApoliceAuto(double valorFipe, int idadeCondutor, int tempoHabilitacaoAnos, double coberturaTerceiros) {
        this.valorFipe = valorFipe;
        this.idadeCondutor = idadeCondutor;
        this.tempoHabilitacaoAnos = tempoHabilitacaoAnos;
        this.coberturaTerceiros = coberturaTerceiros;
    }

    @Override
    public double calcularPremio() {
        double premioAnual = valorFipe * 0.08;
        if (idadeCondutor < 25) {
            premioAnual *= 1.30;
        }
        if (tempoHabilitacaoAnos < 2) {
            premioAnual *= 1.20;
        }
        return premioAnual / 12.0;
    }

    @Override
    public void validarCobertura() throws ContratacaoRejeitadaException {
        if (coberturaTerceiros < 50_000.0) {
            throw new ContratacaoRejeitadaException(
                    "Apólice Auto rejeitada: cobertura contra terceiros abaixo do mínimo de R$ 50.000,00.");
        }
    }

    @Override
    public List<String> listarDocumentosExigidos() {
        return List.of("CNH", "CRLV", "Comprovante de residência");
    }

    @Override
    public String getPrefixo() {
        return "AUTO-";
    }

    @Override
    public String getNomeProduto() {
        return "Seguro Automóvel";
    }
}
