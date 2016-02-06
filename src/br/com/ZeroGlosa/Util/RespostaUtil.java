package br.com.ZeroGlosa.Util;

import br.com.ZeroGlosa.Entidades.Jogador;
import java.util.List;

/**
 * Classe RespostaUtil
 * <p>Classe responsavel por operações relacionadas a resposta que é o retorno
 * do método getSolucao da classe ProcessadorResultado.</p>
 *
 * @author Kaio Cristian
 */
public class RespostaUtil {

    /**
     * Método montarResposta
     * <p>Método responsavel por montar a resposta a ser apresentada para o
     * usuário, ela recebe uma lista de jogadores e o jogador vencedor e retorna
     * uma String com a resposta.</p>
     */
    public String montarResposta(List<Jogador> listaJogadores, Jogador vencedor) {
        String resposta = "";
        String winner = "";

        for (Jogador jogador : listaJogadores) {
            if (jogador.comparar(vencedor)) {
                winner = "(winner)";
            }

            resposta += remontarListaCartas(jogador);
            if (jogador.isPossuiRoyalFlush()) {
                resposta += "Royal Flush " + winner + "\n";
            } else if (jogador.isPossuiStraightFlush()) {
                resposta += "Straight Flush " + winner + "\n";
            } else if (jogador.isPossuiFullHouse()) {
                resposta += "Full House " + winner + "\n";
            } else if (jogador.isPossuiQuadra()) {
                resposta += "Quadra " + winner + "\n";
            } else if (jogador.isPossuiFlush()) {
                resposta += "Flush " + winner + "\n";
            } else if (jogador.getPossuiStraight()) {
                resposta += "Straight  " + winner + "\n";
            } else if (jogador.getPossuiTrinca()) {
                resposta += "Trinca " + winner + "\n";
            } else if (jogador.getPossuiDuasDuplas()) {
                resposta += "Duas Duplas " + winner + "\n";
            } else if (jogador.getPossuiDupla()) {
                resposta += "Dupla " + winner + "\n";
            } else if (jogador.getPossuiHighCard()) {
                resposta += "High Card " + winner + "\n";
            } else {
                resposta += "\n";
            }
            winner = "";

        }
        return resposta;
    }

    /**
     * Método remontarListaCartas
     * <p>Ao fazer o processamento da linha que é entre ao usuário a mesma é
     * transformada em Enuns.Nesse momento para dar a resposta essa classe faz o
     * processo reverso que é passar a lista de cartas do usuário em uma
     * String.</p>
     */
    private String remontarListaCartas(Jogador jogador) {

        String conjuntoCartas = "";
        List<CartasEnum> listaCartas = jogador.getListaCartas();
        for (int i = 0; i < listaCartas.size(); i++) {
            conjuntoCartas += listaCartas.get(i).getId() + " ";

        }
        return conjuntoCartas;
    }
}
