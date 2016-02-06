package br.com.ZeroGlosa.Processadores;

import br.com.ZeroGlosa.Util.CartasEnum;
import br.com.ZeroGlosa.Entidades.Jogador;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe ProcessadorJogador
 * <p>Essa classe É resonsavel por processos relacionados ao jogador.</p>
 * @author Kaio Cristian
 */
public class ProcessadorJogador {

    /**
     * Método configurarCartasJogador
     * <p>O jogador possui uma lista de cartas do tipo Cartas Enum, sendo assim
     * esse método se faz necessário para transformar a String passada pelo
     * usuário em tal lista.Retorna um false em casos em que a mesma carta é
     * repetida na String, pois o Poker Texas Hold'em só é jogado com um
     * baralho.</p>
     */
    public Boolean configurarCartasJogador(Jogador jogador, String linhaCartas) {

        List<CartasEnum> cartasRepetidas = new ArrayList<CartasEnum>();
        for (String cartaStr : linhaCartas.split(" ")) {

            if (!cartasRepetidas.contains(CartasEnum.getCarta(cartaStr))) {
                jogador.getListaCartas().add(CartasEnum.getCarta(cartaStr));
                cartasRepetidas.add(CartasEnum.getCarta(cartaStr));
            } else {
                return false;
            }
        }
        return true;
    }
}
