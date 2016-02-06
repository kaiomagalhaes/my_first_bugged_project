package br.com.ZeroGlosa.Util.Comparators;

import br.com.ZeroGlosa.Util.CartasEnum;
import java.util.Comparator;

/**
 * Classe CartasComparator
 * <p>Classe responsavel por comparar se o nipe das cartas é igual para
 * eventualmente utilizar em ordenamento de cartas.</p>
 * @author Kaio Cristian
 */
public class CartasComparator implements Comparator<CartasEnum> {

    @Override
    public int compare(CartasEnum carta, CartasEnum outraCarta) {
        return carta.getId().compareTo(outraCarta.getId());
    }
}
