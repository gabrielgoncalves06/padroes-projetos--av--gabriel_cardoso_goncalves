import java.time.LocalDate;
import java.util.List;

/**
 * Produto abstrato do Factory Method.
 * Declara o contrato comum a toda linha de apólice: cálculo de prêmio,
 * validação de cobertura, listagem de documentos e geração de resumo.
 */
public abstract class Apolice {

    protected String segurado;

    public void setSegurado(String segurado) {
        this.segurado = segurado;
    }

    public String getSegurado() {
        return segurado;
    }

    /** Calcula o prêmio da apólice segundo a regra da linha de produto. */
    public abstract double calcularPremio();

    /** Valida a cobertura/documentação mínima; lança exceção se não atendida. */
    public abstract void validarCobertura() throws ContratacaoRejeitadaException;

    /** Lista os documentos exigidos para esta linha de produto. */
    public abstract List<String> listarDocumentosExigidos();

    /** Prefixo usado na numeração da apólice (AUTO-, RES-, VID-, VIA-). */
    public abstract String getPrefixo();

    /** Nome da linha de produto, usado no resumo. */
    public abstract String getNomeProduto();

    /** Gera o resumo textual padronizado (RNF03). */
    public String gerarResumo(String numeroApolice, LocalDate dataEmissao, double premio) {
        StringBuilder sb = new StringBuilder();
        sb.append("===== RESUMO DA APÓLICE =====\n");
        sb.append("Número.........: ").append(numeroApolice).append("\n");
        sb.append("Produto........: ").append(getNomeProduto()).append("\n");
        sb.append("Segurado.......: ").append(segurado).append("\n");
        sb.append("Data de emissão: ").append(dataEmissao).append("\n");
        sb.append(String.format("Prêmio.........: R$ %.2f%n", premio));
        sb.append("Documentos.....: ").append(String.join(", ", listarDocumentosExigidos())).append("\n");
        sb.append("==============================\n");
        return sb.toString();
    }
}
