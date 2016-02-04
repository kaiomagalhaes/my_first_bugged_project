package br.com.ZeroGlosa.Util;

import br.com.ZeroGlosa.Entidades.Jogador;
import java.util.List;

/**
 * Classe PontuacaoUtil
 * <p>Classe responsavel por operações relacionadas a pontuação dos
 * jogadores.</p>
 *
 * @author Kaio Cristian
 */
public class PontuacaoUtil {

    /**
     * Métodos getPontuacao
     * <p>Responsáveis por calculos de pontuacao em cada nível.</p>
     */
    private Integer getPontuacaoDupla(Integer valorCarta) {
        return valorCarta + valorCarta + 13;
    }

    private Integer getPontuacaoDuasDuplas(Integer[] duplas) {
        return getPontuacaoDupla(14) + duplas[0] * 2 + duplas[1] * 2;
    }

    private Integer getPontuacaoTrinca(Integer valorCarta) {
        Integer[] duplas = {14, 14};
        return getPontuacaoDuasDuplas(duplas) + valorCarta * 3;
    }

    private Integer getPontuacaoStraight(Integer somatoria) {
        return getPontuacaoTrinca(14) + somatoria;
    }

    private Integer getPontuacaoFlush(Integer somatoria) {
        return getPontuacaoStraight(60) + somatoria;
    }

    private Integer getPontuacaoFullHouse(Integer[] cartas) {
        int totalSoma = cartas[0] * 3 + cartas[1] * 2;
        return getPontuacaoFlush(60) + totalSoma;
    }

    private Integer getPontuacaoQuadra(Integer valorCarta) {
        Integer[] maxFullHouse = {14, 13};
        return getPontuacaoFullHouse(maxFullHouse) + valorCarta * 4;
    }

    private Integer getPontuacaoStraightFlush(Integer somatoria) {
        return getPontuacaoQuadra(14) + somatoria;
    }

    private Integer getPontuacaoRoyalFlush(Integer somatoria) {
        return getPontuacaoStraightFlush(60) + somatoria;
    }

    /**
     * Método definirVencedor
     * <p>Método responsavel por verificar a pontuacão dos jogadores da lista
     * que lhe é passado e retornar o jogador vencedor.</p>
     */
    public Jogador definirVencedor(List<Jogador> listaJogadores) {

        int pontuacaoAtual = 0;
        int maiorPontuacao = 0;
        Jogador vencedor = null;
        Boolean flag = true;

        for (Jogador jogador : listaJogadores) {
            if (!(jogador.getListaCartas().size() < 7)) {

                if (jogador.isPossuiRoyalFlush()) {
                    pontuacaoAtual = getPontuacaoRoyalFlush(100);
                    flag = false;
                } else if (jogador.isPossuiStraightFlush()) {
                    pontuacaoAtual = getPontuacaoStraightFlush(jogador.getStraightFlush());
                    flag = false;
                } else if (jogador.isPossuiFullHouse()) {
                    pontuacaoAtual = getPontuacaoFullHouse(jogador.getFullHouse());
                    flag = false;
                } else if (jogador.isPossuiQuadra()) {
                    pontuacaoAtual = getPontuacaoQuadra(jogador.getQuadra());
                } else if (jogador.isPossuiFlush()) {
                    pontuacaoAtual = getPontuacaoFlush(jogador.getFlush());
                    flag = false;
                } else if (jogador.getPossuiStraight()) {
                    pontuacaoAtual = getPontuacaoStraight(jogador.getStraight());
                    flag = false;
                } else if (jogador.getPossuiTrinca()) {
                    pontuacaoAtual = getPontuacaoTrinca(jogador.getTrinca());
                } else if (jogador.getPossuiDuasDuplas()) {
                    pontuacaoAtual = getPontuacaoDuasDuplas(jogador.getDuasDuplas());
                } else if (jogador.getPossuiDupla()) {
                    pontuacaoAtual = getPontuacaoDupla(jogador.getDupla());
                } else if (jogador.getPossuiHighCard()) {
                    pontuacaoAtual = jogador.getHighCards().get(0);
                }

                if (pontuacaoAtual > maiorPontuacao) {
                    vencedor = jogador;
                    maiorPontuacao = pontuacaoAtual;
                } else if (pontuacaoAtual == maiorPontuacao && flag) {
                    List<Integer> highCardsJogador = jogador.getHighCards();
                    List<Integer> highCardsVencedor = vencedor.getHighCards();
                    for (int i = 1; i < highCardsJogador.size(); i++) {
                        if (highCardsJogador.get(i) > highCardsVencedor.get(i)) {
                            vencedor = jogador;
                            break;
                        }
                    }
                }

            }
        }
        return vencedor;
    }
}
