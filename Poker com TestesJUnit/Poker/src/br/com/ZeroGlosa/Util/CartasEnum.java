package br.com.ZeroGlosa.Util;

/**
 * Enum CartasEnum
 * <p>Enum representante das cartas.Representa todas as 52 cartas do
 * baralho.</p>
 *
 * @author Kaio Cristian
 */
public enum CartasEnum implements Comparable<CartasEnum> {

    CARD_2c("2", 2, "c"),
    CARD_2d("2", 2, "d"),
    CARD_2h("2", 2, "h"),
    CARD_2s("2", 2, "s"),
    CARD_3c("3", 3, "c"),
    CARD_3d("3", 3, "d"),
    CARD_3h("3", 3, "h"),
    CARD_3s("3", 3, "s"),
    CARD_4c("4", 4, "c"),
    CARD_4d("4", 4, "d"),
    CARD_4h("4", 4, "h"),
    CARD_4s("4", 4, "s"),
    CARD_5c("5", 5, "c"),
    CARD_5d("5", 5, "d"),
    CARD_5h("5", 5, "h"),
    CARD_5s("5", 5, "s"),
    CARD_6c("6", 6, "c"),
    CARD_6d("6", 6, "d"),
    CARD_6h("6", 6, "h"),
    CARD_6s("6", 6, "s"),
    CARD_7c("7", 7, "c"),
    CARD_7d("7", 7, "d"),
    CARD_7h("7", 7, "h"),
    CARD_7s("7", 7, "s"),
    CARD_8c("8", 8, "c"),
    CARD_8d("8", 8, "d"),
    CARD_8h("8", 8, "h"),
    CARD_8s("8", 8, "s"),
    CARD_9c("9", 9, "c"),
    CARD_9d("9", 9, "d"),
    CARD_9h("9", 9, "h"),
    CARD_9s("9", 9, "s"),
    CARD_Tc("T", 10, "c"),
    CARD_Td("T", 10, "d"),
    CARD_Th("T", 10, "h"),
    CARD_Ts("T", 10, "s"),
    CARD_Jc("J", 11, "c"),
    CARD_Jd("J", 11, "d"),
    CARD_Jh("J", 11, "h"),
    CARD_Js("J", 11, "s"),
    CARD_Qc("Q", 12, "c"),
    CARD_Qd("Q", 12, "d"),
    CARD_Qh("Q", 12, "h"),
    CARD_Qs("Q", 12, "s"),
    CARD_Kc("K", 13, "c"),
    CARD_Kd("K", 13, "d"),
    CARD_Kh("K", 13, "h"),
    CARD_Ks("K", 13, "s"),
    CARD_Ac("A", 14, "c"),
    CARD_Ad("A", 14, "d"),
    CARD_Ah("A", 14, "h"),
    CARD_As("A", 14, "s");
    private Integer valorCarta;
    private String face;
    private String naipe;

    CartasEnum(String face, Integer valor, String naipe) {
        this.valorCarta = valor;
        this.face = face;
        this.naipe = naipe;
    }

    public Integer getValorCarta() {
        return valorCarta;
    }

    public String getFace() {
        return face;
    }

    public String getNaipe() {
        return naipe;
    }

    /**
     * Método getId
     * <p>Método responsavel por retornar a face da carta mais o naipe.No
     * formato face+suite.Exemplo:Ts.</p>
     */
    public String getId() {
        return this.getFace().toString() + this.getNaipe();
    }

    /**
     * Método isMesmoNaipe
     * <p>Método responsavel por retornar um boleano referente á igualdade do
     * naipe de duas cartas.</p>
     */
    public Boolean isMesmoNaipe(CartasEnum outraCarta) {
        return this.getNaipe().equals(outraCarta.getNaipe());
    }

    /**
     * Método isMesmoValor
     * <p>Método responsavel por retornar um boleano referente á igualdade do
     * valor numérico de duas cartas.</p>
     */
    public Boolean isMesmoValor(CartasEnum outraCarta) {

        return this.getValorCarta().equals(outraCarta.getValorCarta());

    }

    /**
     * Método getCarta
     * <p>Método responsavel por retornar uma carta referente á String que lhe é
     * passada.Por exemplo:Se a String passada for "Ks" ele irá devolver o enum
     * que possui como face "K" e naipe "s".</p>
     */
    public static CartasEnum getCarta(String id) {
        for (CartasEnum carta : CartasEnum.values()) {
            if (id.toUpperCase().equals(carta.getId().toUpperCase())) {
                return carta;
            }
        }

        return null;

    }
}
