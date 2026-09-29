public class Checkout {
    private final DocumentoFiscal fiscal;
    private final Pagamento pagamento;
    private final Etiqueta etiqueta;

    public Checkout(CheckoutFactory fabrica) {
        this.fiscal = fabrica.criarDocumentoFiscal();
        this.pagamento = fabrica.criarPagamento();
        this.etiqueta = fabrica.criarEtiqueta();
    }

    public void finalizar(double valor) {
        System.out.println("- Fiscal:    " + fiscal.descrever(valor));
        System.out.println("- Pagamento: " + pagamento.descrever(valor));
        System.out.println("- Envio:     " + etiqueta.descrever());
    }
}
