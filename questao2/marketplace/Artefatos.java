interface DocumentoFiscal { String descrever(double valor); }
interface Pagamento { String descrever(double valor); }
interface Etiqueta { String descrever(); }


interface CheckoutFactory {
    DocumentoFiscal criarDocumentoFiscal();
    Pagamento criarPagamento();
    Etiqueta criarEtiqueta();
}
