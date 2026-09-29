class VatInvoice implements DocumentoFiscal {
    public String descrever(double v) { return String.format("VAT invoice | VAT 19%% = EUR %.2f", v * 0.19); }
}
class SepaDirectDebit implements Pagamento {
    public String descrever(double v) { return String.format("SEPA Direct Debit | EUR %.2f", v); }
}
class EtiquetaDeutschePost implements Etiqueta {
    public String descrever() { return "Etiqueta Deutsche Post"; }
}
class FabricaAlemanha implements CheckoutFactory {
    public DocumentoFiscal criarDocumentoFiscal() { return new VatInvoice(); }
    public Pagamento criarPagamento() { return new SepaDirectDebit(); }
    public Etiqueta criarEtiqueta() { return new EtiquetaDeutschePost(); }
}
