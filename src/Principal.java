
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        String arquivoInput = "data.txt";// args[0];
        String arquivoOutput = "output.txt";//args[1];

        try {
            MaquinaTuring mt = ManipuladorArquivo.ler(arquivoInput);
            List<String> output = mt.executar();
            ManipuladorArquivo.escrever(arquivoOutput, String.join("\n", output));
            
            System.out.println("Saída salva com sucesso no arquivo " + arquivoOutput);
        } catch (Exception err) {
            System.err.println(err.toString());
        }
    }
}
