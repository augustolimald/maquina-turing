public class Transicao {
    private final int estadoOrigem, estadoDestino;
    private final char valorInicial, valorFinal, direcao;
    
    public Transicao(int estadoOrigem, int estadoDestino, char valorInicial, char valorFinal, char direcao) {
        this.estadoOrigem = estadoOrigem;
        this.estadoDestino = estadoDestino;
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;
        this.direcao = direcao;
    }

    public int getEstadoOrigem() {
        return estadoOrigem;
    }

    public int getEstadoDestino() {
        return estadoDestino;
    }

    public char getValorInicial() {
        return valorInicial;
    }

    public char getValorFinal() {
        return valorFinal;
    }

    public char getDirecao() {
        return direcao;
    }
    
}
