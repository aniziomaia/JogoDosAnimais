package br.com.os.teste.game;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * classe responsavel por exibir a tela do sistema e as telas de mensagens
 * @author aniziomaia
 *
 */
@SuppressWarnings("serial")
public class Tela extends JFrame implements ActionListener{

	private Kernel kernel;
	private JPanel topo;
	private JPanel rodape;
	private JLabel label;
	private JButton button;

	public Tela() {
		
		label = new JLabel(Constantes.PENSE_EM_UM_ANIMAL);
		button = new JButton(Constantes.BOTAO_INICIAR);
		button.addActionListener(this);

		this.topo = new JPanel();
		this.topo.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.topo.add(label);

		this.rodape = new JPanel();
		this.rodape.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.rodape.add(button);

		this.setTitle(Constantes.TITULO_TELA_INICIAL);
		this.setLayout(new BorderLayout());
		this.setLocationRelativeTo(null);
		this.setSize(300, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.add(this.rodape, BorderLayout.SOUTH);
		this.add(this.topo, BorderLayout.NORTH);
		this.setVisible(true);
	}

	/**
	 * tela de mensagem
	 * @param msg - frase da pergunta
	 * @return - retorna o valor inteiro da confirmacao selecionada pelo
	 *         usuario valor zero para sim e valor um para nao
	 * 
	 */
	public int exibirTelaMensagem(String msg) {
		return JOptionPane.showConfirmDialog(this, msg,Constantes.TITULO_TELA_PLACAR,JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE);
	}

	/**
	 * tela de pergunta
	 * @param msg - frase da pergunta
	 * @return -  retorna o valor inteiro da confirmacao selecionada pelo
	 *         usuario valor zero para sim e valor um para nao
	 * 
	 */
	public int exibirTelaPergunta(String msg) {
		return JOptionPane.showConfirmDialog(this, msg,Constantes.TITULO_TELA_CONFIRMACAO,JOptionPane.YES_NO_OPTION);
	}

	/**
	 * tela que o usuario descreve o nome de algum outro animal
	 * @param msg - descricao do campo
	 * @param titulo -  nome da tela
	 * @return - nome do animal
	 */
	public String exibirTelaNovoAnimal(String msg, String titulo) {
		return JOptionPane.showInputDialog(this, msg,titulo,JOptionPane.PLAIN_MESSAGE);
	}
	
	/**
	 * tela de erro 
	 */
	public void exibirTelaMensagemErro() {
		JOptionPane.showMessageDialog(this,Constantes.TELA_ERRO_MENSAGEM,Constantes.TELA_ERRO,JOptionPane.ERROR_MESSAGE,null);
	}

	/**
	 * teste metodo executas as acoes do botao ok da tela inicial
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		kernel.fazerPerguntas();
	}

	public Kernel getKernel() {
		return kernel;
	}

	public void setKernel(Kernel kernel) {
		this.kernel = kernel;
		kernel.setTela(this);
	}
	
	
}
