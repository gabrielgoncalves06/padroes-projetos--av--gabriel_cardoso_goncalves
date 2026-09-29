/** Resultado do processamento de uma contratação bem-sucedida. */
public class ComprovanteEmissao {
    private final String numeroApolice;
    private final double premio;
    private final String resumo;

    public ComprovanteEmissao(String numeroApolice, double premio, String resumo) {
        this.numeroApolice = numeroApolice;
        this.premio = premio;
        this.resumo = resumo;
    }

    public String getNumeroApolice() {
        return numeroApolice;
    }

    public double getPremio() {
        return premio;
    }

    public String getResumo() {
        return resumo;
    }
}
