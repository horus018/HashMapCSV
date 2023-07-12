package trabalho2Package;

import java.util.ArrayList;

public class Programa {

	public static void main(String[] args) {
		
		LeitorArquivo leitorArquivo  = new LeitorArquivo();
		long startTime = System.currentTimeMillis();
		int contador = 0;
		ArrayList<Ocorrencia> ocorrencias = leitorArquivo.lerCsv();
		
		System.out.println("Contando palavras com Hashmap");
		System.out.println("Total de palavras únicas: "+leitorArquivo.palavrasUnicas);
		System.out.println("As palavras com maior ocorrência são:");
		System.out.println("=====================================");
		
		for (Ocorrencia ocorrencia : ocorrencias) {
			if (contador == 20) {
				break;
			}
			contador++;
			System.out.println(contador+") "+ocorrencia.getPalavra() + " " + ocorrencia.getContagem());
		}
		
		long endTime = System.currentTimeMillis();
		long duration = endTime - startTime;
		double seconds = duration / 1000.0;

		System.out.println("=====================================");
		System.out.println("Tempo de processamento: " + seconds + " milissegundos");
		
	}

}
