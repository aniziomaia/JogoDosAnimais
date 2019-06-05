package br.com.os.teste.game;

import javax.swing.JOptionPane;

/**
 * Classe responsavel por fazer as perguntas
 * e analizar as repostas escolhidas pelo usuario
 * 
 * @author aniziomaia
 *
 */
public class Kernel  {
	
	private Tela tela;
	private ArvoreAnimal arvoreAnimal;

	public Kernel() {}
	
	public ArvoreAnimal getArvoreAnimal() {
		return arvoreAnimal;
	}

	public void setArvoreAnimal(ArvoreAnimal arvoreAnimal) {
		this.arvoreAnimal = arvoreAnimal;
	}

	/**
	 * metodo responsavel por percorrer os nos
	 * da arvore e fazer as perguntas equanto tiver noh
	 * este metodo sera invocado quando o botao ok for precionado
	 */
	public void fazerPerguntas() {
		
		ArvoreAnimal arvoreAnimalCorrente = arvoreAnimal;
		
		while (arvoreAnimalCorrente.existeNo()) {
			//faz a primeia pergunta
			int resposta = tela.exibirTelaPergunta(Constantes.PERGUNTA_ANIMAL_VIVE_AGUA + arvoreAnimalCorrente.getNome());
			
			//recupera os animais correspondentes a resposta
			if (resposta == JOptionPane.YES_OPTION) {
				arvoreAnimalCorrente = arvoreAnimalCorrente.getNoEsquerdo();
			
			} else if (resposta == JOptionPane.NO_OPTION) {
				arvoreAnimalCorrente = arvoreAnimalCorrente.getNoDireito();
			} 
		}
		
		this.fazSegundaPergunta(arvoreAnimalCorrente);
	}

	/**
	 * faz a segunda pergunta e analisa a resposta
	 * caso tenha acertado a resposta aparece mensagem de acerto
	 * caso nao acertado o animal eh adicionado ao noh
	 * @param animal
	 */
	private void fazSegundaPergunta(ArvoreAnimal animal) {
		
		int resposta = tela.exibirTelaPergunta(Constantes.PERGUNTA_ANIMAL_E_UM + animal.getNome() + " ?");
		
		if (resposta == JOptionPane.YES_OPTION) {
			//verifica se foi o primeiro acerto da maquina
			if(Constantes.ACERTOS_MAQUINA == 0) {
				Constantes.ACERTOS_MAQUINA ++;
				String msg = new String(Constantes.PRIMEIRO_ACERTO.replace("?", ""+Constantes.ACERTOS_MAQUINA));
				msg = msg.replace("#", ""+Constantes.ACERTOS_JOGADOR);
				tela.exibirTelaMensagem(msg);
			}else {
				Constantes.ACERTOS_MAQUINA ++;
				String msg = new String(Constantes.MAIS_DE_UM_ACERTO.replace("?", ""+Constantes.ACERTOS_MAQUINA));
				msg = msg.replace("#", ""+Constantes.ACERTOS_JOGADOR);
				tela.exibirTelaMensagem(msg);
			}
			
		//caso a resposta seja nao, o jogador entra com o nome do animal que ele pensou
		} else if (resposta == JOptionPane.NO_OPTION) {
			Constantes.ACERTOS_JOGADOR ++;
			this.fazTerceiraPergunta(animal);
		}
	}

	/**
	 * faz a terceira pergunta e adiciona o novo animal na arvore
	 * @param animal
	 */
	private void fazTerceiraPergunta(ArvoreAnimal animal) {
		String novoAnimal = tela.exibirTelaNovoAnimal(Constantes.PERGUNTA_QUAL_ANIMAL, Constantes.TELA_DESISTO);
		//caso o jogador nao tenha digitado nada finaliza o jogo
		if(novoAnimal == null) {
			tela.exibirTelaMensagemErro();
			System.exit(0);
		}
		String pergunta = Constantes.PERGUNTA_APENDICE.replace("?", novoAnimal);
		pergunta = pergunta.replace("#", animal.getNome());
		
		String caracteristica = tela.exibirTelaNovoAnimal(pergunta, Constantes.TELA_COMPLETE);

		animal.setNoDireito(new ArvoreAnimal(animal.getNome()));
		animal.setNoEsquerdo(new ArvoreAnimal(novoAnimal));
		animal.setNome(caracteristica);
	}
	
	public void setTela(Tela tela) {
		this.tela = tela;
	}
}
