package br.com.ZeroGlosa.Processadores;

import br.com.ZeroGlosa.Util.CartasEnum;
import br.com.ZeroGlosa.Entidades.Jogador;
import br.com.ZeroGlosa.Util.Comparators.NaipeComparator;
import br.com.ZeroGlosa.Util.PontuacaoUtil;
import br.com.ZeroGlosa.Util.Comparators.ValorCartasComparator;
import br.com.ZeroGlosa.Util.RespostaUtil;
import java.util.*;
//---

/**
 * Classe ProcessadorResultado
 * <p>Essa classe É responsavel por realizar o processamento das linhas de
 * cartas entregues pelo usuário.O único método visível dessa classe é o
 * getSolucao.
 * </p>
 *
 * @author Kaio Cristian
 */
public class ProcessadorResultado {

    /**
     * Método getSolucao
     * <p>Único método público da classe ProcessadorResultado.Recebe uma lista
     * de jogadores com as cartas préviamente inseridas e retorna uma String com
     * a solução que consiste em varias linhas onde cada linha representa as
     * cartas de um jogador e no fim da linha vai aparecer um Ranking que as
     * cartas dele representam e se ele ganhou também terá um (winner).</p>
     *
     */
    public String getSolucao(List<Jogador> listaJogadores) {

        for (int contadorJogadores = 0; contadorJogadores < listaJogadores.size(); contadorJogadores++) {
            determinarPontuacaoJogador(listaJogadores.get(contadorJogadores));
        }
        Jogador vencedor = determinarVencedor(listaJogadores);
        RespostaUtil respostaUtil = new RespostaUtil();
        String solucao = respostaUtil.montarResposta(listaJogadores, vencedor);;
        return solucao;

    }

    /**
     * Método determinarVencedor
     * <p>Método privado responsavel por determinar o vencedor dentre uma lista
     * de jogadores que lhe é passada.</p>
     */
    private Jogador determinarVencedor(List<Jogador> jogadores) {

        PontuacaoUtil pontuacaoUtil = new PontuacaoUtil();
        Jogador vencedor = pontuacaoUtil.definirVencedor(jogadores);
        return vencedor;

    }

    /**
     * Método determinarPontuacaoJogador
     * <p>Método privado responsavel por determinar o a pontuacao de um jogador
     * que lhe é passado.</p>
     */
    private void determinarPontuacaoJogador(Jogador jogador) {

        if (jogador.getListaCartas().size() == 7) {
            this.testarExistenciaRoyalFlush(jogador);
        }
    }

    /**
     * Método getHighCard
     * <p>Método privado responsavel por determinar os HighCards de um jogador
     * sem que esses façam parte de algum Ranking.</p>
     */
    private void definirHighCards(Jogador jogador, List<Integer> excessoes) {

        List<CartasEnum> cartas = jogador.getListaCartas();
        CartasEnum cartaMaior = cartas.get(0);
        Boolean jaUsado;
        List<Integer> listaHighCards = new ArrayList<Integer>();
        for (int i = 0; i < cartas.size(); i++) {
            jaUsado = false;
            CartasEnum auxiliar = cartas.get(i);

            for (int j = 0; j < excessoes.size(); j++) {
                if (auxiliar.getValorCarta() == excessoes.get(j)) {
                    jaUsado = true;
                }
            }

            if (auxiliar.getValorCarta() >= cartaMaior.getValorCarta() && !jaUsado) {
                cartaMaior = auxiliar;
                listaHighCards.add(cartaMaior.getValorCarta());
            }

        }
        Collections.sort(listaHighCards);
        Collections.reverse(listaHighCards);
        jogador.setHighCards(listaHighCards);

    }

    /**
     * Método testarExistenciaDuplas
     * <p>Método privado responsavel por testar a existencia de duplas em um
     * conjunto de cartas de um jogador.</p>
     */
    private String testarExistenciaDuplas(Jogador jogador, String trioStr) {
        String dupla = "";
        ArrayList<CartasEnum> listaCartas = jogador.getListaCartas();
        Integer trio = trioStr.equals("") ? 0 : Integer.parseInt(trioStr);
        Comparator<CartasEnum> comparatorCartas = new ValorCartasComparator();
        Collections.sort(listaCartas, comparatorCartas);

        for (int i = 1; i < listaCartas.size(); i++) {
            if (listaCartas.get(i).isMesmoValor(listaCartas.get(i - 1))
                    && listaCartas.get(i).getValorCarta() != trio) {
                dupla += listaCartas.get(i).getValorCarta() + ",";
            }
        }
        return dupla;
    }

    /**
     * Método testarExistenciaTrincas
     * <p>Método privado responsavel por testar a existencia de trincas em um
     * conjunto de cartas de um jogador.</p>
     */
    private void testarExistenciaTrincas(Jogador jogador) {
        String trio = "";
        List<Integer> excessoes = new ArrayList<Integer>();
        ArrayList<CartasEnum> listaCartas = jogador.getListaCartas();
        Comparator<CartasEnum> comparatorCartas = new ValorCartasComparator();
        Collections.sort(listaCartas, comparatorCartas);
        for (int i = 2; i < listaCartas.size(); i++) {
            if (listaCartas.get(i).isMesmoValor(listaCartas.get(i - 1))
                    && listaCartas.get(i - 1).isMesmoValor(
                    listaCartas.get(i - 2))) {
                trio = listaCartas.get(i).getValorCarta().toString();
            }
        }

        String duplas = testarExistenciaDuplas(jogador, trio);
        if (!duplas.equals("")) {

            if (!trio.equals("")) {

                String[] vetorDupla = duplas.split(",");
                Integer[] fullHouse = {Integer.valueOf(trio), Integer.valueOf(vetorDupla[0])};
                jogador.setFullHouse(fullHouse);
            } else {

                if (duplas.length() < 4) {
                    String[] vetorDupla = duplas.split(",");
                    Integer valorDupla = Integer.valueOf(vetorDupla[0]);
                    jogador.setDupla(valorDupla);

                    excessoes.add(valorDupla);
                    this.definirHighCards(jogador, excessoes);
                } else {
                    String[] stringDuplas = duplas.split(",");
                    Integer[] intDuplas = {Integer.valueOf(stringDuplas[0]), Integer.valueOf(stringDuplas[1])};
                    jogador.setDuasDuplas(intDuplas);

                    excessoes.add(Integer.valueOf(stringDuplas[0]));
                    excessoes.add(Integer.valueOf(stringDuplas[1]));
                    definirHighCards(jogador, excessoes);
                }

            }
        } else if (!trio.equals("")) {

            Integer valorTrio = Integer.valueOf(trio);
            jogador.setTrinca(valorTrio);
            excessoes.add(valorTrio);
            this.definirHighCards(jogador, excessoes);
        } else if (duplas.equals("") && trio.equals("")) {
            definirHighCards(jogador, excessoes);
        }
    }

    /**
     * Método testarExistenciaStraight
     * <p>Método privado responsavel por testar a existencia de Straight em um
     * conjunto de cartas de um jogador.</p>
     */
    private void testarExistenciaStraight(Jogador jogador) {
        List<CartasEnum> cartasSequenciais = this.getSequencia(jogador);
        Integer pontuacao = 0;
        CartasEnum cartaAtual;
        if (cartasSequenciais.size() > 4) {
            for (int i = 0; i < cartasSequenciais.size(); i++) {

                cartaAtual = cartasSequenciais.get(i);
                pontuacao += cartaAtual.getValorCarta();


            }
            jogador.setStraight(pontuacao);
        } else {
            testarExistenciaTrincas(jogador);
        }

    }

    /**
     * Método testarExistenciaFlush
     * <p>Método privado responsavel por testar a existencia de Flush em um
     * conjunto de cartas de um jogador.</p>
     */
    private void testarExistenciaFlush(Jogador jogador) {

        ArrayList<CartasEnum> listaCartas = jogador.getListaCartas();
        Comparator<CartasEnum> comparatorCartas = new NaipeComparator();
        Integer pontuacao = 0;
        Collections.sort(listaCartas, comparatorCartas);
        for (int i = 4; i < listaCartas.size(); i++) {
            if (listaCartas.get(i).isMesmoNaipe(listaCartas.get(i - 1))
                    && listaCartas.get(i - 1).isMesmoNaipe(
                    listaCartas.get(i - 2))
                    && listaCartas.get(i - 2).isMesmoNaipe(
                    listaCartas.get(i - 3))
                    && (listaCartas.get(i - 3).isMesmoNaipe(listaCartas
                    .get(i - 4)))) {

                for (int j = i - 4; j < 6; j++) {
                    pontuacao += listaCartas.get(j).getValorCarta();
                }
            }
        }
        if (pontuacao != 0) {
            jogador.setFlush(pontuacao);
        } else {
            testarExistenciaStraight(jogador);
        }

    }

    /**
     * Método testarExistenciaQuadra
     * <p>Método privado responsavel por testar a existencia de uma quadra em um
     * conjunto de cartas de um jogador.</p>
     */
    private void testarExistenciaQuadra(Jogador jogador) {
        Integer quadra = 0;
        ArrayList<CartasEnum> listaCartas = jogador.getListaCartas();
        Comparator<CartasEnum> comparatorCartas = new ValorCartasComparator();
        Collections.sort(listaCartas, comparatorCartas);
        for (int i = 3; i < listaCartas.size(); i++) {
            if (listaCartas.get(i).isMesmoValor(listaCartas.get(i - 1))
                    && listaCartas.get(i - 1).isMesmoValor(
                    listaCartas.get(i - 2))
                    && listaCartas.get(i - 2).isMesmoValor(
                    listaCartas.get(i - 3))) {
                quadra = listaCartas.get(i).getValorCarta();
            }
        }

        if (quadra != 0) {
            jogador.setQuadra(quadra);
            List<Integer> excessoes = new ArrayList<Integer>();
            excessoes.add(quadra);
            definirHighCards(jogador, excessoes);
        } else {
            testarExistenciaFlush(jogador);
        }
    }

    /**
     * Método testarExistenciaStraightFlush
     * <p>Método privado responsavel por testar a existencia de StraightFlush em
     * um conjunto de cartas de um jogador.</p>
     */
    private void testarExistenciaStraightFlush(Jogador jogador) {

        int contador = 0;
        Integer pontuacao = 0;
        List<CartasEnum> cartasSequenciais = this.getSequencia(jogador);
        if (cartasSequenciais.size() > 4) {
            CartasEnum cartaAnterior = null;
            CartasEnum cartaAtual = null;
            for (int i = 1; i < cartasSequenciais.size(); i++) {
                cartaAnterior = cartasSequenciais.get(i - 1);
                cartaAtual = cartasSequenciais.get(i);
                if (cartaAnterior.isMesmoNaipe(cartaAtual)) {
                    contador++;
                    pontuacao += cartaAnterior.getValorCarta();
                }
                cartaAnterior = cartaAtual;
            }
            if (cartaAnterior.isMesmoNaipe(cartaAtual)) {
                contador++;
                pontuacao += cartaAtual.getValorCarta();
            }

        }
        if (contador == 5) {
            jogador.setStraightFlush(pontuacao);
        } else {
            testarExistenciaQuadra(jogador);
        }
    }

    /**
     * Método testarExistenciaRoyalFlush
     * <p>Método privado responsavel por testar a existencia de um RoyalFlush em
     * um conjunto de cartas de um jogador.</p>
     */
    private void testarExistenciaRoyalFlush(Jogador jogador) {

        int pontuacao = 0;
        int contador = 0;
        List<CartasEnum> cartasSequenciais = this.getSequencia(jogador);
        Collections.reverse(cartasSequenciais);
        if (cartasSequenciais.size() > 4) {
            CartasEnum cartaAnterior = cartasSequenciais.get(0);
            CartasEnum cartaAtual = null;
            for (int i = 1; i < 5; i++) {
                cartaAtual = cartasSequenciais.get(i);
                if (cartaAnterior.isMesmoNaipe(cartaAtual)) {
                    pontuacao += cartaAnterior.getValorCarta();
                    contador++;
                }
                cartaAnterior = cartaAtual;
            }

            if (cartaAnterior.isMesmoNaipe(cartaAtual) && contador == 4) {
                pontuacao += cartaAtual.getValorCarta();
            }

        }

        if (pontuacao == 60) {
            jogador.setRoyalFlush(pontuacao);
        } else {
            testarExistenciaStraightFlush(jogador);
        }
    }

    /**
     * Método getSequencia
     * <p>Método privado responsavel por testar a existencia de sequencia no
     * conjunto dado e retornar a que encontrar.</p>
     */
    private List<CartasEnum> getSequencia(Jogador jogador) {

        List<CartasEnum> listaCartasSequenciais = new ArrayList<CartasEnum>();
        CartasEnum ultima = null;
        Set<CartasEnum> listaCartas = new TreeSet<CartasEnum>(
                jogador.getListaCartas());
        Iterator<CartasEnum> it = listaCartas.iterator();
        CartasEnum cartaAnterior = it.next();
        int contador = 0;
        while (it.hasNext()) {
            CartasEnum cartaAtual = it.next();
            int valorAtual = cartaAtual.getValorCarta();
            int valorAnterior = cartaAnterior.getValorCarta();
            if ((valorAtual - 1) == valorAnterior && (contador == 0
                    || ((valorAtual - 1) == ultima.getValorCarta()))) {
                listaCartasSequenciais.add(cartaAnterior);
                ultima = cartaAtual;
                contador++;
            }

            cartaAnterior = cartaAtual;
        }

        listaCartasSequenciais.add(ultima);
        return listaCartasSequenciais;

    }
}
