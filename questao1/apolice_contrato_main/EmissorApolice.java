import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Criador abstrato do Factory Method.
 *
 * O método fábrica (criarApolice) é abstrato e isolado em cada subclasse —
 * é ela quem decide qual produto concreto instanciar. O algoritmo de
 * processamento (processarContratacao) é único, final, e trabalha apenas
 * com a abstração Apolice, nunca com uma classe concreta.
 */
public abstract class EmissorApolice {

    private static final AtomicInteger CONTADOR = new AtomicInteger(0);

    /** Método fábrica: cada subclasse decide QUAL apólice concreta instanciar. */
    protected abstract Apolice criarApolice();

    /** Algoritmo de processamento, idêntico para qualquer linha de produto. */
    public final ComprovanteEmissao processarContratacao(String segurado) throws ContratacaoRejeitadaException {
        Apolice apolice = criarApolice();
        apolice.setSegurado(segurado);

        apolice.validarCobertura();

        double premio = apolice.calcularPremio();
        String numero = gerarNumeroApolice(apolice.getPrefixo());
        String resumo = apolice.gerarResumo(numero, LocalDate.now(), premio);

        return new ComprovanteEmissao(numero, premio, resumo);
    }

    private String gerarNumeroApolice(String prefixo) {
        int sequencial = CONTADOR.incrementAndGet();
        return String.format("%s%06d", prefixo, sequencial);
    }
}
