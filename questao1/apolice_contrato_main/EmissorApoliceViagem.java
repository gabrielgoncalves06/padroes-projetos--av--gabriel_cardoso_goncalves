/** Criador concreto — instancia ApoliceViagem. */
public class EmissorApoliceViagem extends EmissorApolice {

    private final int diasViagem;
    private final boolean destinoInternacional;
    private final double coberturaAssistenciaMedicaUsd;
    private final boolean possuiPassaporte;

    public EmissorApoliceViagem(int diasViagem, boolean destinoInternacional,
                                 double coberturaAssistenciaMedicaUsd, boolean possuiPassaporte) {
        this.diasViagem = diasViagem;
        this.destinoInternacional = destinoInternacional;
        this.coberturaAssistenciaMedicaUsd = coberturaAssistenciaMedicaUsd;
        this.possuiPassaporte = possuiPassaporte;
    }

    @Override
    protected Apolice criarApolice() {
        return new ApoliceViagem(diasViagem, destinoInternacional, coberturaAssistenciaMedicaUsd, possuiPassaporte);
    }
}
