/**
 * Lançada quando uma contratação não atende às validações mínimas de
 * cobertura ou documentação exigidas pela linha de produto (RF01 a RF04).
 */
public class ContratacaoRejeitadaException extends Exception {
    public ContratacaoRejeitadaException(String motivo) {
        super(motivo);
    }
}
