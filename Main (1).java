import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
  //Lucas Pavan Aranha, RA- 21421829
  //João Lucas Timóteo Maia Ribeiro, RA- 21340681
  //Gabriel Costa Lopes, RA- 21420851//
  public static void main(String[] args) {

    List<String> pessoa = new ArrayList<>();
    
    try {
      // Abrir arquivo
      File file = new File("arquivoDados.txt");
      Scanner scanner = new Scanner(file);

      // Adicionar linhas do arquivo na List
      while (scanner.hasNextLine()) {
        pessoa.add(scanner.nextLine());
      }
      scanner.close();

      // Ordenar lista
      Collections.sort(pessoa);

      while(true){
        Scanner leitor = new Scanner(System.in);
        System.out.print("Digite o nome a ser procurado: ");
        String nome = leitor.nextLine();

        // SAIR
        if (nome.compareTo("exit") == 0){
          leitor.close();
          break;
        }
        // Busca Binaria de strings
        System.out.println(busca(pessoa, nome));
      }

      
    }
    // ERRO AO ABRIR O AQUIVO
    catch (IOException ex){
      System.out.println(ex.getMessage());
    }
  }

  // Busca recursiva
  private static String busca(List<String> array, String chave) {
                              // Lista, inicial,          final, nome a ser buscado
		return buscaBinariaRecursiva(array,       0, array.size()-1, chave);
	}

  private static String buscaBinariaRecursiva(List<String> array, int menor, int maior, String chave){
    // Indice do meio da lista
		int media = (maior + menor) / 2;

    // Conteudo do meio da lista
		String valorMeio = array.get(media);

    // Auxiliar para comparar apenas os nomes
    String[] partes = valorMeio.split(",");

		if (menor > maior) // O nome não esta na lista
			return "Aluno não encontrado";
		else if(partes[0].compareTo(chave) == 0) // Encontrou o nome
			return valorMeio;
		else if (partes[0].compareTo(chave) < 0) // O nome esta antes do meio
			return buscaBinariaRecursiva(array, media+1, maior, chave);
		else // O nome esta depois do meio
			return buscaBinariaRecursiva(array, menor, media-1, chave);
	}
}