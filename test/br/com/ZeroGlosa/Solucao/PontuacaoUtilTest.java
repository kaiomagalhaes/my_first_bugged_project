/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ZeroGlosa.Solucao;

import br.com.ZeroGlosa.Util.CartasEnum;
import br.com.ZeroGlosa.Util.PontuacaoUtil;
import br.com.ZeroGlosa.Entidades.Jogador;
import br.com.ZeroGlosa.Processadores.ProcessadorResultado;
import br.com.ZeroGlosa.Main.Main;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alunoufg
 */
public class PontuacaoUtilTest {

    public PontuacaoUtilTest() {
    }

    @Test
    public void testDefinirVencedor() {
        System.out.println("definirVencedor");
        List<Jogador> listaJogadores = new ArrayList<Jogador>();
        this.inserirTestesAleatorios(listaJogadores);
        PontuacaoUtil instance = new PontuacaoUtil();
        Jogador resultado = new Jogador();
        inserirResposta(resultado);
        ProcessadorResultado solucionador = new ProcessadorResultado();
        System.out.println(solucionador.getSolucao(listaJogadores));
        Jogador expResult = instance.definirVencedor(listaJogadores);
        Collections.sort(expResult.getListaCartas());
        assertEquals(expResult, resultado);

    }

    private List<String> inserirTestesAleatorios(
            List<Jogador> listaJogadores) {

        String linhaCarta = "";
        int opcao = 0;
        List<String> listaTeste = new ArrayList<String>();
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 7; j++) {
                opcao = (int) ((Math.random() * 12) + 3);
                String carta = getCarta(opcao);
                if (!listaTeste.contains(carta)) {
                    listaTeste.add(carta);
                    linhaCarta += getCarta(opcao) + " ";
                } else {
                    j--;
                }
            }
            listaTeste.clear();
            new Main().addJogador(listaJogadores, linhaCarta);
            linhaCarta = "";

        }
        linhaCarta = "Ts Js Qs Ks As Kd 2h";
        new Main().addJogador(listaJogadores, linhaCarta);

        return null;
    }

    private String getCarta(int valor) {
        String total = "";
        switch (valor) {
            case 2:
                total += "2" + getNipe();
                break;
            case 3:
                total += "3" + getNipe();
                break;
            case 4:
                total += "4" + getNipe();
                break;
            case 5:
                total += "5" + getNipe();
                break;
            case 6:
                total += "6" + getNipe();
                break;
            case 7:
                total += "7" + getNipe();
                break;
            case 8:
                total += "8" + getNipe();
                break;
            case 9:
                total += "9" + getNipe();
                break;
            case 10:
                total += "T" + getNipe();
                break;
            case 11:
                total += "J" + getNipe();
                break;
            case 12:
                total += "Q" + getNipe();
                break;
            case 13:
                total += "K" + getNipe();
                break;
            case 14:
                total += "A" + getNipe();
                break;
        }

        return total;

    }

    private String getNipe() {

        int opcao = (int) ((Math.random() * 3) + 1);

        if (opcao == 1) {
            return "s";
        }
        if (opcao == 2) {
            return "h";
        }
        if (opcao == 3) {
            return "c";
        }
        if (opcao == 4) {
            return "d";
        }

        return "";

    }

    private Jogador inserirResposta(Jogador jogador) {

        List<CartasEnum> lista = jogador.getListaCartas();

        lista.add(CartasEnum.CARD_Ts);
        lista.add(CartasEnum.CARD_Js);
        lista.add(CartasEnum.CARD_Qs);
        lista.add(CartasEnum.CARD_Ks);
        lista.add(CartasEnum.CARD_As);
        lista.add(CartasEnum.CARD_Kd);
        lista.add(CartasEnum.CARD_2h);
        Collections.sort(jogador.getListaCartas());

        return jogador;
    }
}