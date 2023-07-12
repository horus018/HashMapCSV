package trabalho2Package;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class LeitorArquivo {
	
	ArrayList<Ocorrencia> palavrasValidas = new ArrayList<Ocorrencia>();
	ArrayList<String> palavrasInvalidas = new ArrayList<String>();
	int palavrasUnicas;
	String[] palavrasInvalidasLista = null; 
	String[] palavras = null;
	HashMap<String, Ocorrencia> mapaContador = new HashMap<>();

	public ArrayList<Ocorrencia> lerCsv() {
		BufferedReader leitor = null;

		try {
			leitor = new BufferedReader(new InputStreamReader(new FileInputStream("palavrasInvalidas.txt"), "UTF-8"));
			while (leitor.ready()) {
				String linha = leitor.readLine();
				palavrasInvalidasLista = linha.split(";");
				
				for (String palavra : palavrasInvalidasLista) {
					palavrasInvalidas.add(palavra);
				}
			}
			leitor.close();
			
			leitor = new BufferedReader(new InputStreamReader(new FileInputStream("livro.txt"), "UTF-8"));
			while (leitor.ready()) {
				String linha = leitor.readLine();
				palavras = linha.split(" ");
				
				for (String palavra : palavras) {
					palavra = palavra.toLowerCase();
					palavra = removerCaracteresInvalidos(palavra);
					
					if (!palavra.isEmpty()) {
						palavrasValidas.add(new Ocorrencia(palavra, 0));
					}
				}
			}
			leitor.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		contabilizarPalavras();
		ArrayList<Ocorrencia> valores = new ArrayList<>(mapaContador.values());
		Collections.sort(valores, Collections.reverseOrder());
		return valores;
	}

	public String removerCaracteresInvalidos(String palavra) {
		palavra = palavra.replace("\"", "");
		palavra = palavra.replace(",", "");
		palavra = palavra.replace(".", "");
		palavra = palavra.replace(";", "");
		palavra = palavra.replace("-", "");
		
		for (String palavraInvalida : palavrasInvalidas) {
			if(palavra.equals(palavraInvalida)) {
				return "";
			}
		}
		return palavra;
	}
	
	public void contabilizarPalavras() {
	    for (Ocorrencia ocorrencia : palavrasValidas) {
	        if (mapaContador.containsKey(ocorrencia.getPalavra())) {
	            Ocorrencia ocorrenciaExistente = mapaContador.get(ocorrencia.getPalavra());
	            ocorrenciaExistente.contabilizarOcorrencia();
	        } else {
	            ocorrencia.contabilizarOcorrencia();
	            mapaContador.put(ocorrencia.getPalavra(), ocorrencia);
	            palavrasUnicas++;
	        }
	    }
	}
	
}
