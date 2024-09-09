package test;

import control.Imc;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestImc {
    Imc imc;

    @Before
    public void setUp() {
        // Configura um objeto Imc vazio
        imc = new Imc("", 0, "", 0, 0);
    }

    @After
    public void tearDown() {
        imc = null;
    }

    // Teste para verificar o cálculo do IMC
    @Test
    public void testImc() {
        // Calculando IMC para um peso de 66 kg e altura de 1.83 m
        Assert.assertEquals(19.71, imc.calculoImc(66.0, 1.83), 0.01);
    }

    // Teste para verificar o peso ideal de um homem com altura de 1.83
    @Test
    public void testPesoIdealHomem() {
        // Configurando o sexo como "homem" e altura de 1.83
        imc.setSexo("homem");
        imc.setAltura(1.83);
        // Verificando o peso ideal para homens (altura * 100 - 100) * 0.90
        Assert.assertEquals(74.7, imc.pesoIdeal(), 0.1);
    }

    // Teste para verificar o peso ideal de uma mulher com altura de 1.70
    @Test
    public void testPesoIdealMulher() {
        // Configurando o sexo como "mulher" e altura de 1.70
        imc.setSexo("mulher");
        imc.setAltura(1.70);
        // Verificando o peso ideal para mulheres (altura * 100 - 100) * 0.85
        Assert.assertEquals(59.5, imc.pesoIdeal(), 0.1);
    }

    // Teste para verificar a interpretação do IMC para homens
    @Test
    public void testInterpretarImcHomem() {
        // Configurando idade e sexo
        imc.setIdade(25);
        imc.setSexo("homem");
        // Testando classificação para IMC 20.0 (Peso Normal)
        Assert.assertEquals("Peso normal", imc.interpretarImc(20.0));

        // Testando classificação para IMC 30.0 (Obesidade Grau I)
        Assert.assertEquals("Obesidade grau I", imc.interpretarImc(30.0));
    }

    // Teste para verificar a interpretação do IMC para mulheres
    @Test
    public void testInterpretarImcMulher() {
        // Configurando idade e sexo
        imc.setIdade(30);
        imc.setSexo("mulher");
        // Testando classificação para IMC 18.0 (Baixo peso)
        Assert.assertEquals("Baixo peso", imc.interpretarImc(18.0));

        // Testando classificação para IMC 25.0 (Sobrepeso)
        Assert.assertEquals("Sobrepeso", imc.interpretarImc(25.0));
    }
}
