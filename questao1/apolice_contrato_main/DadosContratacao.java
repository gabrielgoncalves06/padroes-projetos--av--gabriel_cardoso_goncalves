/**
 * Reúne, em um único objeto (estilo builder), todos os dados que podem ser
 * necessários para contratar qualquer uma das linhas de produto. Cada linha
 * usa somente os campos que lhe dizem respeito. Isso permite que a classe
 * cliente selecione o criador certo por meio de um registro (Map) — em vez
 * de um método fábrica com uma lista de parâmetros diferente por tipo.
 */
public class DadosContratacao {

    // ---- Auto (RF01) ----
    private Double valorFipe;
    private Integer idadeCondutor;
    private Integer tempoHabilitacaoAnos;
    private Double coberturaTerceiros;

    // ---- Residencial (RF02) ----
    private Double valorImovel;
    private Boolean altoPadrao;
    private Boolean possuiEscrituraOuContrato;

    // ---- Vida (RF03) ----
    private Integer idadeSegurado;
    private Double capitalSegurado;
    private Boolean fumante;
    private Boolean possuiAtestadoMedico;

    // ---- Viagem (RF04) ----
    private Integer diasViagem;
    private Boolean destinoInternacional;
    private Double coberturaAssistenciaMedicaUsd;
    private Boolean possuiPassaporte;

    public DadosContratacao comFipe(double v) { this.valorFipe = v; return this; }
    public DadosContratacao comIdadeCondutor(int v) { this.idadeCondutor = v; return this; }
    public DadosContratacao comTempoHabilitacao(int v) { this.tempoHabilitacaoAnos = v; return this; }
    public DadosContratacao comCoberturaTerceiros(double v) { this.coberturaTerceiros = v; return this; }

    public DadosContratacao comValorImovel(double v) { this.valorImovel = v; return this; }
    public DadosContratacao comAltoPadrao(boolean v) { this.altoPadrao = v; return this; }
    public DadosContratacao comEscrituraOuContrato(boolean v) { this.possuiEscrituraOuContrato = v; return this; }

    public DadosContratacao comIdadeSegurado(int v) { this.idadeSegurado = v; return this; }
    public DadosContratacao comCapitalSegurado(double v) { this.capitalSegurado = v; return this; }
    public DadosContratacao comFumante(boolean v) { this.fumante = v; return this; }
    public DadosContratacao comAtestadoMedico(boolean v) { this.possuiAtestadoMedico = v; return this; }

    public DadosContratacao comDiasViagem(int v) { this.diasViagem = v; return this; }
    public DadosContratacao comDestinoInternacional(boolean v) { this.destinoInternacional = v; return this; }
    public DadosContratacao comCoberturaAssistenciaMedica(double v) { this.coberturaAssistenciaMedicaUsd = v; return this; }
    public DadosContratacao comPassaporte(boolean v) { this.possuiPassaporte = v; return this; }

    public double getValorFipe() { return valorFipe; }
    public int getIdadeCondutor() { return idadeCondutor; }
    public int getTempoHabilitacaoAnos() { return tempoHabilitacaoAnos; }
    public double getCoberturaTerceiros() { return coberturaTerceiros; }

    public double getValorImovel() { return valorImovel; }
    public boolean isAltoPadrao() { return altoPadrao; }
    public boolean isPossuiEscrituraOuContrato() { return possuiEscrituraOuContrato; }

    public int getIdadeSegurado() { return idadeSegurado; }
    public double getCapitalSegurado() { return capitalSegurado; }
    public boolean isFumante() { return fumante; }
    public boolean isPossuiAtestadoMedico() { return possuiAtestadoMedico; }

    public int getDiasViagem() { return diasViagem; }
    public boolean isDestinoInternacional() { return destinoInternacional; }
    public double getCoberturaAssistenciaMedicaUsd() { return coberturaAssistenciaMedicaUsd; }
    public boolean isPossuiPassaporte() { return possuiPassaporte; }
}
