/** Criador concreto — instancia ApoliceResidencial. */
public class EmissorApoliceResidencial extends EmissorApolice {

    private final double valorImovel;
    private final boolean altoPadrao;
    private final boolean possuiEscrituraOuContrato;

    public EmissorApoliceResidencial(double valorImovel, boolean altoPadrao, boolean possuiEscrituraOuContrato) {
        this.valorImovel = valorImovel;
        this.altoPadrao = altoPadrao;
        this.possuiEscrituraOuContrato = possuiEscrituraOuContrato;
    }

    @Override
    protected Apolice criarApolice() {
        return new ApoliceResidencial(valorImovel, altoPadrao, possuiEscrituraOuContrato);
    }
}
