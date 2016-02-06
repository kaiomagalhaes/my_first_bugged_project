package br.com.ZeroGlosa.Entidades;

import br.com.ZeroGlosa.Util.CartasEnum;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe Jogador
 * <p>Classe responsavel por responder pela entidade Jogador.</p>
 * @author Kaio Cristian
 */
public class Jogador implements Serializable {

    private ArrayList<CartasEnum> listaCartas;
    //----------------------------
    private Integer straight;
    private List<Integer> highCards;
    private Integer dupla;
    private Integer[] duasDuplas;
    private Integer trinca;
    private Integer quadra;
    private Integer flush;
    private Integer[] fullHouse;
    private Integer straightFlush;
    private Integer royalFlush;
    //-----------------------------
    private Boolean possuiDupla = false;
    private Boolean possuiDuasDuplas = false;
    private Boolean possuiTrinca = false;
    private Boolean possuiQuadra = false;
    private Boolean possuiFlush = false;
    private Boolean possuiFullHouse = false;
    private Boolean possuiStraightFlush = false;
    private Boolean possuiRoyalFlush = false;
    private Boolean possuiStraight = false;
    private Boolean possuiHighCard = false;

    /**
     * Método setHightCards
     * <p>Método responsavel pela colocação da lista de HighCards na variavel
     * HighCard.Ao ser chamada automaticamente um booleano responsavel por ele é
     * setado como true não possuindo seu próprio setter. Recebe uma lista de
     * Integer que não estão presentes em cartas utilizadas em outras
     * jogadas.</p>
     */
    public void setHighCards(List<Integer> highCards) {
        this.possuiHighCard = true;
        this.highCards = highCards;
    }

    /**
     * Método setDupla
     * <p>Método responsavel pela colocação do valor de uma carta da dupla na
     * variavel dupla.Ao ser chamada automaticamente um booleano responsavel por
     * ela é setado como true não possuindo seu próprio setter. Recebe um
     * inteiro que simboliza as duas cartas.</p>
     */
    public void setDupla(Integer valorCarta) {
        this.possuiDupla = true;
        this.dupla = valorCarta;

    }

    /**
     * Método setDuasDupla
     * <p>Método responsavel pela colocação do valor de um array que possui duas
     * cartas dupla na variavel duasDupla.Ao ser chamada automaticamente um
     * booleano responsavel por ela é setado como true não possuindo seu próprio
     * setter. Recebe um array de duas casas que representam das duas duplas
     * onde em cada casa temos apenas um número.</p>
     */
    public void setDuasDuplas(Integer[] duplas) {
        this.possuiDuasDuplas = true;
        this.duasDuplas = duplas;
    }

    /**
     * Método setTrinca
     * <p>Método responsavel pela colocação do valor de uma carta da trinca na
     * variavel trinca.Ao ser chamada automaticamente um booleano responsavel
     * por ela é setado como true não possuindo seu próprio setter. Recebe um
     * inteiro que simboliza das três cartas.</p>
     */
    public void setTrinca(Integer pontuacao) {
        this.possuiTrinca = true;
        this.trinca = pontuacao;
    }

    /**
     * Método setStraight
     * <p>Método responsavel pela colocação do valor da pontuacao na variavel
     * Straight. Ao ser chamada automaticamente um booleano responsavel por ela
     * é setado como true não possuindo seu próprio setter. Recebe um inteiro
     * que simboliza a soma das cinco cartas que a formam.</p>
     */
    public void setStraight(Integer pontuacao) {
        this.possuiStraight = true;
        this.straight = pontuacao;
    }

    /**
     * Método setTrinca
     * <p>Método responsavel pela colocação do valor de uma carta da quadra na
     * variavel trinca.Ao ser chamada automaticamente um booleano responsavel
     * por ela é setado como true não possuindo seu próprio setter. Recebe um
     * inteiro que simboliza das quatro cartas.</p>
     */
    public void setQuadra(Integer pontuacao) {
        this.possuiQuadra = true;
        this.quadra = pontuacao;
    }

    /**
     * Método setFlush
     * <p>Método responsavel pela colocação do valor da pontuacao na variavel
     * flush. Ao ser chamada automaticamente um booleano responsavel por ele é
     * setado como true não possuindo seu próprio setter. Recebe um inteiro que
     * simboliza a soma das cinco cartas que o formam.</p>
     */
    public void setFlush(Integer pontuacao) {
        this.possuiFlush = true;
        this.flush = pontuacao;
    }

    /**
     * Método setFullHouse
     * <p>Método responsavel pela colocação do valor de um array que possui duas
     * cartas na variavel fullHouse.Ao ser chamada automaticamente um booleano
     * responsavel por ela é setado como true não possuindo seu próprio setter.
     * Recebe um array de duas casas que representam respectivamente um trio e
     * uma dupla.
     * </p>
     */
    public void setFullHouse(Integer[] cartas) {
        this.possuiFullHouse = true;
        this.fullHouse = cartas;
    }

    /**
     * Método setStraight
     * <p>Método responsavel pela colocação do valor da pontuacao na variavel
     * straight. Ao ser chamada automaticamente um booleano responsavel por ele
     * é setado como true não possuindo seu próprio setter. Recebe um inteiro
     * que simboliza a soma das cinco cartas que o formam.</p>
     */
    public void setStraightFlush(Integer pontuacao) {
        this.possuiStraightFlush = true;
        this.straightFlush = pontuacao;
    }

    /**
     * Método setRoyalFlush
     * <p>Método responsavel pela colocação do valor da pontuacao na variavel
     * royalFlush. Ao ser chamada automaticamente um booleano responsavel por
     * ele é setado como true não possuindo seu próprio setter. Recebe um
     * inteiro que simboliza a soma das cinco cartas que o formam.</p>
     */
    public void setRoyalFlush(Integer pontuacao) {
        this.possuiRoyalFlush = true;
        this.royalFlush = pontuacao;
    }

    public Boolean isPossuiFlush() {
        return possuiFlush;
    }

    public Boolean isPossuiQuadra() {
        return possuiQuadra;
    }

    public Boolean isPossuiFullHouse() {
        return possuiFullHouse;
    }

    public Boolean isPossuiStraightFlush() {
        return possuiStraightFlush;
    }

    public Boolean isPossuiRoyalFlush() {
        return possuiRoyalFlush;
    }

    public List<Integer> getHighCards() {
        return highCards;
    }

    public Integer getDupla() {
        return dupla;
    }

    public Integer[] getDuasDuplas() {
        return duasDuplas;
    }

    public Integer getTrinca() {
        return trinca;
    }

    public Integer getQuadra() {
        return quadra;
    }

    public Integer getFlush() {
        return flush;
    }

    public Integer[] getFullHouse() {
        return fullHouse;
    }

    public Integer getStraightFlush() {
        return straightFlush;
    }

    public Integer getRoyalFlush() {
        return royalFlush;
    }

    public Boolean getPossuiHighCard() {
        return possuiHighCard;
    }

    public Boolean getPossuiDupla() {
        return possuiDupla;
    }

    public Boolean getPossuiStraight() {
        return possuiStraight;
    }

    public Boolean getPossuiTrinca() {
        return possuiTrinca;
    }

    public Integer getStraight() {
        return straight;
    }

    public Boolean getPossuiDuasDuplas() {
        return possuiDuasDuplas;
    }

    /**
     * Método getListaCartas
     * <p>Método responsavel pelo retorno da lista de cartas do jogador.Não é
     * necessário um "set" pois ao ser chamada ela verifica se já existe ou
     * não.Só é possivel adicionar na lista não é possivel colocar uma outra em seu lugar.</p>
     */
    public ArrayList<CartasEnum> getListaCartas() {

        if (this.listaCartas == null) {
            this.listaCartas = new ArrayList<CartasEnum>();
        }

        return this.listaCartas;

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }

        return true;
    }

    /**
     * Método comparar
     * <p>Método responsavel pela comparação entre dois jogadores recebe o
     * objeto jogador a ser testado e retorna um bolleano.</p>
     */
    public boolean comparar(Jogador jogador) {
        final Jogador other = jogador;
        if (jogador == null || !Objects.equals(this.listaCartas, other.listaCartas)) {
            return false;
        }

        for (int i = 0; i < 7; i++) {
            if (!(jogador.getListaCartas().get(i).getValorCarta() == other.getListaCartas().get(i).getValorCarta())) {
                return false;

            }
        }

        return true;
    }
}
