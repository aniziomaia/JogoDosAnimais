package br.com.os.teste.game;

/**
 * Classe responsavel por iniciar o jogo
 * @author aniziomaia
 *
 */

public class Iniciar {

	public static void main(String[] args) {
		//cria a arvore com o no raiz
		ArvoreAnimal arvoreRaiz = new ArvoreAnimal(Constantes.PERGUNTA_RAIZ);
		//inicia o jogo com dois animais
		arvoreRaiz.setNoEsquerdo(new ArvoreAnimal(Constantes.ANIMAL_TUBARAO));
		arvoreRaiz.setNoDireito(new ArvoreAnimal(Constantes.ANIMAL_MACACO));
		
		//contem a logica do jogo
		Kernel kernel = new Kernel();
		//seta a o no inicial para comecar o jogo
		kernel.setArvoreAnimal(arvoreRaiz);

		//cria a tela que exibe as mensagem
		Tela tela = new Tela();
		//seta o a classe quem contem o mecanismo do jogo
		tela.setKernel(kernel);
	}
}
