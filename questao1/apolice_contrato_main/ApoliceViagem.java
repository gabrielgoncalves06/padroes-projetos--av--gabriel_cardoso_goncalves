import java.util.ArrayList;
import java.util.List;

/** Produto concreto RF04 — Apólice Viagem. */
public class ApoliceViagem extends Apolice {

    private final int diasViagem;
    private final boolean destinoInternacional;
    private final double coberturaAssistenciaMedicaUsd;
    private final boolean possuiPassaporte;

    public ApoliceViagem(int diasViagem, boolean destinoInternacional,
                          double coberturaAssistenciaMedicaUsd, boolean possuiPassaporte) {
        this.diasViagem = diasViagem;
        this.destinoInternacional = destinoInternacional;
        this.coberturaAssistenciaMedicaUsd = coberturaAssistenciaMedicaUsd;
        this.possuiPassaporte = possuiPassaporte;
    }

    @Override
    public double calcularPremio() {
        double premio = diasViagem * 15.00;
        if (destinoInternacional) {
            premio += 100.00;
        }
        return premio;
    }

    @Override
    public void validarCobertura() throws ContratacaoRejeitadaException {
        if (destinoInternacional) {
            if (coberturaAssistenciaMedicaUsd < 30_000.0 || !possuiPassaporte) {
                throw new ContratacaoRejeitadaException(
                        "Apólice Viagem rejeitada: destino internacional exige cobertura de assistência "
                                + "médica mínima de US$ 30.000,00 e apresentação de passaporte.");
            }
        }
    }

    @Override
    public List<String> listarDocumentosExigidos() {
        List<String> documentos = new ArrayList<>(List.of("Itinerário de viagem"));
        if (destinoInternacional) {
            documentos.add("Passaporte");
        }
        return documentos;
    }

    @Override
    public String getPrefixo() {
        return "VIA-";
    }

    @Override
    public String getNomeProduto() {
        return "Seguro Viagem";
    }
}
