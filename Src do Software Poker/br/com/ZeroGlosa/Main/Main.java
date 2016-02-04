package br.com.ZeroGlosa.Main;

import br.com.ZeroGlosa.Entidades.Jogador;
import br.com.ZeroGlosa.Processadores.ProcessadorResultado;
import br.com.ZeroGlosa.Processadores.ProcessadorJogador;
import java.util.*;

/**
 * Classe Main
 * <p>Essa classe inicia a execução do aplicativo.</p>
 *
 * @param args, um vetor de argumentos que podem ser informados
 * @author Kaio Cristian
 */
public class Main {

    public static void main(String[] args) {

        List<Jogador> lista = new ArrayList<Jogador>();
        new Main().processarOpcaoUsuario(lista);

        ProcessadorResultado processadorResultado = new ProcessadorResultado();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(processadorResultado.getSolucao(lista));

    }

    /**
     * Método processarOpcaoUsuario
     * <p>Método responsavel pela efetivação da escolha do usuário.</p>
     */
    public void processarOpcaoUsuario(List<Jogador> lista) {
        System.out.println("Digite a linha de cartas e caso queira finalizar digite 0");
        while (true) {
            String linhaCartas = preencherLinhaCartas();
            if (linhaCartas.length() < 2) {
                break;
            } else {
                addJogador(lista, linhaCartas);
            }

        }

    }

    /**
     * Método addJogador
     * <p>Método responsavel pela adição do jogador na lista de
     * armazenamento.</p>
     */
    public Boolean addJogador(List<Jogador> listaJogadores, String cartas) {
        Jogador jogador = new Jogador();
        Boolean cartasCorretas = new ProcessadorJogador().configurarCartasJogador(jogador, cartas);

        if (cartasCorretas) {
            listaJogadores.add(jogador);
        } else {
            return false;
        }

        return true;
    }

    /**
     * Método preencherLinhaCartas
     * <p>Método responsavel que resposta pela opção 1 do menu.Responsavel por
     * fazer a leitura do conjunto de cartas de um jogador.</p>
     */
    private String preencherLinhaCartas() {

        Scanner leia = new Scanner(System.in);
        String linhaCarta = leia.nextLine();
        return linhaCarta;

    }

}
