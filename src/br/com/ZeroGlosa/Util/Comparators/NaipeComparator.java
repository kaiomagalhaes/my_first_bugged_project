package br.com.ZeroGlosa.Util.Comparators;

import br.com.ZeroGlosa.Util.CartasEnum;
import java.util.Comparator;

/**
 * Classe NaipeComparator
 * <p>Classe responsavel por comparar se o nipe das cartas é igual.</p>
 *
 * @author Kaio Cristian
 */
public class NaipeComparator implements Comparator<CartasEnum> {

    @Override
    public int compare(CartasEnum carta, CartasEnum outraCarta) {
        return carta.getNaipe().compareTo(outraCarta.getNaipe());
    }
}