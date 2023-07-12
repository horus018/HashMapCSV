package trabalho2Package;

public class Ocorrencia implements Comparable<Ocorrencia>{
	private String palavra;
	private int contagem;

	public Ocorrencia(String palavra, int contagem) {
		super();
		this.palavra = palavra;
		this.contagem = contagem;
	}

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	public int getContagem() {
		return contagem;
	}

	public void setContagem(int contagem) {
		this.contagem = contagem;
	}
	
	public void contabilizarOcorrencia() {
		this.contagem++;
	}

	@Override
	public int compareTo(Ocorrencia o) {
		return Integer.compare(this.contagem, o.getContagem());
	}

}
