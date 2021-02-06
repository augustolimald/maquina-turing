public class Transicao {
    private final int estadoOrigem, estadoDestino;
    private final char valorInicial, valorFinal, direcao;
    
    /**
     * Construtor da Classe Transicao
     * 
     * @param estadoOrigem
     * @param estadoDestino
     * @param valorInicial
     * @param valorFinal
     * @param direcao
     */
    public Transicao(int estadoOrigem, int estadoDestino, char valorInicial, char valorFinal, char direcao) {
        this.estadoOrigem = estadoOrigem;
        this.estadoDestino = estadoDestino;
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;
        this.direcao = direcao;
    }

    /**
     * Retorna o estado de origem
     * 
     * @return
     */
    public int getEstadoOrigem() {
        return estadoOrigem;
    }

    /**
     * Retorna o estado de destino
     * 
     * @return
     */
    public int getEstadoDestino() {
        return estadoDestino;
    }

    /**
     * Retorna o valor inicial
     * 
     * @return
     */
    public char getValorInicial() {
        return valorInicial;
    }

    /**
     * Retorna o valor final
     * 
     * @return
     */
    public char getValorFinal() {
        return valorFinal;
    }

    /**
     * Retorna a direção da cabeça de leitura
     * 
     * @return
     */
    public char getDirecao() {
        return direcao;
    }
    
}
