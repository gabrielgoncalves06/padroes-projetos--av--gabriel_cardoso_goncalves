/** Criador concreto — instancia ApoliceAuto. */
public class EmissorApoliceAuto extends EmissorApolice {

    private final double valorFipe;
    private final int idadeCondutor;
    private final int tempoHabilitacaoAnos;
    private final double coberturaTerceiros;

    public EmissorApoliceAuto(double valorFipe, int idadeCondutor, int tempoHabilitacaoAnos, double coberturaTerceiros) {
        this.valorFipe = valorFipe;
        this.idadeCondutor = idadeCondutor;
        this.tempoHabilitacaoAnos = tempoHabilitacaoAnos;
        this.coberturaTerceiros = coberturaTerceiros;
    }

    @Override
    protected Apolice criarApolice() {
        return new ApoliceAuto(valorFipe, idadeCondutor, tempoHabilitacaoAnos, coberturaTerceiros);
    }
}
