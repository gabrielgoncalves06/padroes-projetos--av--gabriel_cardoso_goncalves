interface DocumentoFiscal { String descrever(double valor); }
interface Pagamento { String descrever(double valor); }
interface Etiqueta { String descrever(); }

// Abstract Factory: cada implementação cria a família completa de um país
interface CheckoutFactory {
    DocumentoFiscal criarDocumentoFiscal();
    Pagamento criarPagamento();
    Etiqueta criarEtiqueta();
}
