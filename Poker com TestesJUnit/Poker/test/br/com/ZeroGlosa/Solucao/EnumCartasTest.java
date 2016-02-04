/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ZeroGlosa.Solucao;

import br.com.ZeroGlosa.Util.CartasEnum;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alunoufg
 */
public class EnumCartasTest {
    
    public EnumCartasTest() {
    }

    @Test
    public void testGetValorCarta() {
        System.out.println("getValorCarta");
        CartasEnum instance = CartasEnum.CARD_9s;
        Integer expResult = 9;
        Integer result = instance.getValorCarta();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetFace() {
        System.out.println("getFace");
        CartasEnum instance = CartasEnum.CARD_Qh;
        String expResult = "Q";
        String result = instance.getFace();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetNipe() {
        System.out.println("getNipe");
        CartasEnum instance = CartasEnum.CARD_Ks;
        String expResult = "s";
        String result = instance.getNaipe();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetId() {
        System.out.println("7d");
        CartasEnum instance = CartasEnum.CARD_7d;
        String expResult = "7d";
        String result = instance.getId();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testIsMesmoNipe() {
        System.out.println("isMesmoNipe");
        CartasEnum outraCarta = CartasEnum.CARD_4h;
        CartasEnum instance = CartasEnum.CARD_4h;
        Boolean expResult = true;
        Boolean result = instance.isMesmoNaipe(outraCarta);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsMesmoValor() {
        System.out.println("isMesmoValor");
        CartasEnum outraCarta = CartasEnum.CARD_As;
        CartasEnum instance = CartasEnum.CARD_Ah;
        Boolean expResult = true;
        Boolean result = instance.isMesmoValor(outraCarta);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetCarta() {
        System.out.println("getCarta");
        String id = "2s";
        CartasEnum expResult = CartasEnum.CARD_2s;
        CartasEnum result = CartasEnum.getCarta(id);
        assertEquals(expResult, result);

    }
}