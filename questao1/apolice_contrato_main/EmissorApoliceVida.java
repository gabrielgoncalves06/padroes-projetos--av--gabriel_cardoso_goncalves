/** Criador concreto — instancia ApoliceVida. */
public class EmissorApoliceVida extends EmissorApolice {

    private final int idadeSegurado;
    private final double capitalSegurado;
    private final boolean fumante;
    private final boolean possuiAtestadoMedico;

    public EmissorApoliceVida(int idadeSegurado, double capitalSegurado, boolean fumante, boolean possuiAtestadoMedico) {
        this.idadeSegurado = idadeSegurado;
        this.capitalSegurado = capitalSegurado;
        this.fumante = fumante;
        this.possuiAtestadoMedico = possuiAtestadoMedico;
    }

    @Override
    protected Apolice criarApolice() {
        return new ApoliceVida(idadeSegurado, capitalSegurado, fumante, possuiAtestadoMedico);
    }
}
