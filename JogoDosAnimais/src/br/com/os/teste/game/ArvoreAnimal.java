package br.com.os.teste.game;


/**
 * classe que representa uma arvore binaria com seus
 * nos esquerdo e direito
 * 
 * @author aniziomaia
 */

public class ArvoreAnimal {
	
	private String nome;
	private ArvoreAnimal noEsquerdo;
	private ArvoreAnimal noDireito;

	public ArvoreAnimal(String nome) {
		this.nome = nome;
	}
	
	public boolean existeNo() {
		return (noDireito != null) && (noEsquerdo != null);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArvoreAnimal getNoEsquerdo() {
		return noEsquerdo;
	}

	public void setNoEsquerdo(ArvoreAnimal noEsquerdo) {
		this.noEsquerdo = noEsquerdo;
	}

	public ArvoreAnimal getNoDireito() {
		return noDireito;
	}

	public void setNoDireito(ArvoreAnimal noDireito) {
		this.noDireito = noDireito;
	}

	
}
