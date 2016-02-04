package br.com.ZeroGlosa.Util.Comparators;

import br.com.ZeroGlosa.Util.CartasEnum;
import java.util.Comparator;

/**
 * Classe ValorCartasComparator
 * <p>Classe responsavel por comparar se o valor das cartas é igual para
 * eventualmente utilizar em ordenamento de cartas.</p>
 *
 * @author Kaio Cristian
 */
public class ValorCartasComparator implements Comparator<CartasEnum> {

    @Override
    public int compare(CartasEnum carta, CartasEnum outraCarta) {
        return carta.getValorCarta().compareTo(outraCarta.getValorCarta());
    }
}