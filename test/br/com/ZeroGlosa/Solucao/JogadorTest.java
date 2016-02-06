/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ZeroGlosa.Solucao;

import br.com.ZeroGlosa.Util.CartasEnum;
import br.com.ZeroGlosa.Entidades.Jogador;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alunoufg
 */
public class JogadorTest {
    public JogadorTest() {
    }

    @Test
    public void testGetPossuiDupla() {
        System.out.println("getPossuiDupla");
        Jogador instance = new Jogador();
        Boolean expResult = false;
        Boolean result = instance.getPossuiDupla();
        assertEquals(expResult, result);

    }

    @Test
    public void testGetPossuiDuasDuplas() {
        System.out.println("getPossuiDuasDuplas");
        Jogador instance = new Jogador();
        Boolean expResult = false;
        Boolean result = instance.getPossuiDuasDuplas();
        assertEquals(expResult, result);

    }
    
    @Test
    public void testGetPossuiStraight() {
        System.out.println("getPossuiStraight");
        Jogador instance = new Jogador();
        Boolean expResult = false;
        Boolean result = instance.getPossuiStraight();
        assertEquals(expResult, result);

    }

    @Test
    public void testGetPossuiTripla() {
        System.out.println("getPossuiTripla");
        Jogador instance = new Jogador();
        Boolean expResult = false;
        Boolean result = instance.getPossuiTrinca();
        assertEquals(expResult, result);

    }

    @Test
    public void testGetPossuiQuadra() {
        System.out.println("getPossuiQuadra");
        Jogador instance = new Jogador();
        Boolean expResult = false;
        Boolean result = instance.isPossuiQuadra();
        assertEquals(expResult, result);

    }

    @Test
    public void testGetPossuiFlush() {
        System.out.println("getPossuiFlush");
        Jogador instance = new Jogador();
        Boolean expResult = false;
        Boolean result = instance.isPossuiFlush();
        assertEquals(expResult, result);

    }
    
    @Test
    public void testGetPossuiFullHouse() {
        System.out.println("getPossuiFullHouse");
        Jogador instance = new Jogador();
        Boolean expResult = false;
        Boolean result = instance.isPossuiFullHouse();
        assertEquals(expResult, result);

    }

    @Test
    public void testGetPossuiStraightFlush() {
        System.out.println("getPossuiStraightFlush");
        Jogador instance = new Jogador();
        Boolean expResult = false;
        Boolean result = instance.isPossuiStraightFlush();
        assertEquals(expResult, result);

    }

    @Test
    public void testGetPossuiRoyalFlush() {
        System.out.println("getPossuiRoyalFlush");
        Jogador instance = new Jogador();
        Boolean expResult = false;
        Boolean result = instance.isPossuiRoyalFlush();
        assertEquals(expResult, result);

    }

    @Test
    public void testGetHighCard() {
        System.out.println("getHighCard");
        Jogador instance = new Jogador();
        List expResult = null;
        List result = instance.getHighCards();
        assertEquals(expResult, result);

    }

    @Test
    public void testEquals() {
        System.out.println("equals");
        Jogador jogador = new Jogador();
        jogador.getListaCartas().add(CartasEnum.CARD_2c);
        jogador.getListaCartas().add(CartasEnum.CARD_As);
        Jogador instance = new Jogador();
        instance.getListaCartas().add(CartasEnum.CARD_2c);
        instance.getListaCartas().add(CartasEnum.CARD_Ks);
        
        boolean expResult = false;
        boolean result = instance.comparar(jogador);
        assertEquals(expResult, result);

    }
}