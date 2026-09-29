class NFe implements DocumentoFiscal {
    public String descrever(double v) { return String.format("NF-e | ICMS 18%% = R$ %.2f", v * 0.18); }
}
class Pix implements Pagamento {
    public String descrever(double v) { return String.format("Pix | R$ %.2f", v); }
}
class EtiquetaCorreios implements Etiqueta {
    public String descrever() { return "Etiqueta Correios"; }
}
class FabricaBrasil implements CheckoutFactory {
    public DocumentoFiscal criarDocumentoFiscal() { return new NFe(); }
    public Pagamento criarPagamento() { return new Pix(); }
    public Etiqueta criarEtiqueta() { return new EtiquetaCorreios(); }
}
