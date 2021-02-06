import java.util.ArrayList;
import java.util.List;

public class MaquinaTuring {
    // Quíntupla
    private final int estadoInicial;
    private final int quantidadeEstados;
    private final List<Transicao> transicoes;
    private final List<String> alfabetoEntrada, alfabetoFita;
    
    // Estado
    private char[] fita;
    private int estadoAtual, cabecaLeitura;
    
    /**
     * Construtor da Classe MaquinaTuring
     * 
     * @param quantidadeEstados
     * @param estadoInicial
     * @param alfabetoEntrada
     * @param alfabetoFita
     * @param transicoes
     * @param fita
     */
    public MaquinaTuring(int quantidadeEstados, int estadoInicial, List<String> alfabetoEntrada, List<String> alfabetoFita, List<Transicao> transicoes, String fita) {
        this.quantidadeEstados = quantidadeEstados;
        this.estadoInicial = estadoInicial;
        this.alfabetoEntrada = alfabetoEntrada;
        this.alfabetoFita = alfabetoFita;
        this.transicoes = transicoes;
        this.fita = fita.toCharArray();
    }
    
    /**
     * Pesquisa a próxima transição a ser realizada
     * 
     * @return
     */
    private Transicao pesquisarTransicao() {
        for (Transicao transicao : this.transicoes) {
            if (transicao.getEstadoOrigem() == this.estadoAtual && transicao.getValorInicial() == this.fita[cabecaLeitura]) {
                return transicao;
            }
        }
        
        return null;
    }
    
    /**
     * Converte o estado atual da fita para uma String
     * com o objetivo de escrever no arquivo de output
     * 
     * @return
     */
    private String fitaParaString() {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < fita.length; i++) {
            if (i == cabecaLeitura) {
                sb.append("{q");
                sb.append(estadoAtual);
                sb.append("}");
            }
            sb.append(fita[i]);
        }
        
        return sb.toString();
    }
    
    /**
     * Executa a máquina de turing enquanto houver transição a ser realizada
     * 
     * @return
     * @throws Exception
     */
    public List<String> executar() throws Exception {
        this.cabecaLeitura = 0;
        this.estadoAtual = estadoInicial;
        
        List<String> output = new ArrayList<>();
        
        output.add(fitaParaString());
        Transicao transicao = pesquisarTransicao();
        
        while(transicao != null) {
            this.estadoAtual = transicao.getEstadoDestino();
            this.fita[cabecaLeitura] = transicao.getValorFinal();
            this.cabecaLeitura += (transicao.getDirecao() == 'R') ? 1 : -1;
            
            if (this.cabecaLeitura == -1) {
                throw new Exception("Fita excedida para a esquerda");
            }
            
            output.add(fitaParaString());
            transicao = pesquisarTransicao();
        }
        
        return output;
    }
}
