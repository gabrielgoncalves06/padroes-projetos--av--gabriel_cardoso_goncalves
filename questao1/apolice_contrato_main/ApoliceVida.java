import java.util.ArrayList;
import java.util.List;

/** Produto concreto RF03 — Apólice Vida. */
public class ApoliceVida extends Apolice {

    private final int idadeSegurado;
    private final double capitalSegurado;
    private final boolean fumante;
    private final boolean possuiAtestadoMedico;

    public ApoliceVida(int idadeSegurado, double capitalSegurado, boolean fumante, boolean possuiAtestadoMedico) {
        this.idadeSegurado = idadeSegurado;
        this.capitalSegurado = capitalSegurado;
        this.fumante = fumante;
        this.possuiAtestadoMedico = possuiAtestadoMedico;
    }

    @Override
    public double calcularPremio() {
        double premioMensal = (idadeSegurado * 12) + (capitalSegurado * 0.002);
        if (fumante) {
            premioMensal *= 1.50;
        }
        return premioMensal;
    }

    @Override
    public void validarCobertura() throws ContratacaoRejeitadaException {
        if (capitalSegurado > 500_000.0 && !possuiAtestadoMedico) {
            throw new ContratacaoRejeitadaException(
                    "Apólice Vida rejeitada: capital segurado acima de R$ 500.000,00 exige atestado médico.");
        }
    }

    @Override
    public List<String> listarDocumentosExigidos() {
        List<String> documentos = new ArrayList<>(List.of("Documento de identidade", "CPF"));
        if (capitalSegurado > 500_000.0) {
            documentos.add("Atestado médico");
        }
        return documentos;
    }

    @Override
    public String getPrefixo() {
        return "VID-";
    }

    @Override
    public String getNomeProduto() {
        return "Seguro Vida";
    }
}
