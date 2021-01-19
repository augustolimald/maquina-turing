import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ManipuladorArquivo {
    private static final String PATH = new File("").getAbsolutePath();
    
    public static MaquinaTuring ler(String endereco) throws Exception {
        try (BufferedReader arquivo = new BufferedReader(new FileReader(endereco))) {
            arquivo.readLine(); // (
            
            /**
             * Quantidade de Estados
             */
            String linha = arquivo.readLine();
            int quantidadeEstados = linha.substring(linha.indexOf("{") + 1, linha.indexOf("}")).split(", ").length;
            
            /**
             * Alfabeto de Entrada
             */
            linha = arquivo.readLine();
            List<String> alfabetoEntrada = Arrays.asList(linha.substring(linha.indexOf("{") + 1, linha.indexOf("}")).split(", "));
            
            /**
             * Alfabeto da Fita
             */
            linha = arquivo.readLine();
            List<String> alfabetoFita = Arrays.asList(linha.substring(linha.indexOf("{") + 1, linha.indexOf("}")).split(", "));
            
            /**
             * Transições
             */
            arquivo.readLine(); // {
            List<Transicao> transicoes = new ArrayList<>();
            linha = arquivo.readLine();
            while(!linha.contains("}")) {
                String[] partes = linha.split(" -> ");
                
                String[] origem = partes[0].substring(partes[0].indexOf("(") + 1, partes[0].indexOf(")")).split(", ");
                int estadoOrigem = Integer.parseInt(origem[0].substring(1));
                char valorInicial = origem[1].charAt(0);
                
                String[] destino = partes[1].substring(partes[1].indexOf("(") + 1, partes[1].indexOf(")")).split(", ");
                int estadoDestino = Integer.parseInt(destino[0].substring(1));
                char valorFinal = destino[1].charAt(0);
                char direcao = destino[2].charAt(0);
                
                transicoes.add(new Transicao(estadoOrigem, estadoDestino, valorInicial, valorFinal, direcao));
            
                linha = arquivo.readLine();
            }
            
            
            /**
             * Estado Inicial
             */
            linha = arquivo.readLine();
            int estadoInicial = Integer.parseInt(linha.substring(linha.indexOf("{") + 1, linha.indexOf("}")).substring(1));
            
            /**
             * Fita
             */
            arquivo.readLine(); // )
            linha = arquivo.readLine();
            String fita = linha;
            
            MaquinaTuring mt = new MaquinaTuring(quantidadeEstados, estadoInicial, alfabetoEntrada, alfabetoFita, transicoes, fita);
            return mt;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void escrever(String endereco, String conteudo) throws Exception {
        try (FileWriter arquivo = new FileWriter(endereco)) {
            arquivo.write(conteudo);
            arquivo.write("\n");
        } catch (Exception e) {
            throw e;
        }
    }
}
