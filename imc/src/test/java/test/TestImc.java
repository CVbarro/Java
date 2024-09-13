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
        imc = new Imc("", 0, "", 0, 0);
    }

    @After
    public void tearDown() {
        imc = null;
    }


    @Test
    public void testCalculoImc() {
        // Calculando IMC para um peso de 66 kg e altura de 1.83 m
        Assert.assertEquals(66 / (1.83 * 1.83), imc.calculoImc(66.0, 1.83), 0.01);
    }


    @Test
    public void testPesoIdealHomem() {
        imc.setSexo("homem");
        imc.setAltura(1.83);

        Assert.assertEquals((1.83 * 100 - 100) * 0.90, imc.pesoIdeal(), 0.1);
    }


    @Test
    public void testPesoIdealMulher() {
        imc.setSexo("mulher");
        imc.setAltura(1.70);

        Assert.assertEquals((1.70 * 100 - 100) * 0.85, imc.pesoIdeal(), 0.1);
    }


    @Test
    public void testInterpretarImcHomem() {
        // Faixa etária 2-5 anos
        imc.setSexo("homem");
        imc.setIdade(3);
        Assert.assertEquals("Peso normal (menino)", imc.interpretarImc(15.0));
        Assert.assertEquals("Sobrepeso (menino)", imc.interpretarImc(18.0));
        Assert.assertEquals("Obesidade (menino)", imc.interpretarImc(20.0));

        // Faixa etária 6-10 anos
        imc.setIdade(8);
        Assert.assertEquals("Peso normal (menino)", imc.interpretarImc(17.0));
        Assert.assertEquals("Sobrepeso (menino)", imc.interpretarImc(20.0));
        Assert.assertEquals("Obesidade (menino)", imc.interpretarImc(23.0));

        // Faixa etária 11-20 anos
        imc.setIdade(15);
        Assert.assertEquals("Peso normal (menino)", imc.interpretarImc(22.0));
        Assert.assertEquals("Sobrepeso (menino)", imc.interpretarImc(25.0));
        Assert.assertEquals("Obesidade (menino)", imc.interpretarImc(27.0));

        // Faixa etária 21-65 anos
        imc.setIdade(30);
        Assert.assertEquals("Peso normal", imc.interpretarImc(22.0));
        Assert.assertEquals("Sobrepeso", imc.interpretarImc(27.0));
        Assert.assertEquals("Obesidade grau I", imc.interpretarImc(32.0));
        Assert.assertEquals("Obesidade grau II", imc.interpretarImc(37.0));
        Assert.assertEquals("Obesidade grau III (obesidade mórbida)", imc.interpretarImc(40.0));
    }


    @Test
    public void testInterpretarImcMulher() {
        // Faixa etária 2-5 anos
        imc.setSexo("mulher");
        imc.setIdade(3);
        Assert.assertEquals("Peso normal (menina)", imc.interpretarImc(14.0));
        Assert.assertEquals("Sobrepeso (menina)", imc.interpretarImc(17.0));
        Assert.assertEquals("Obesidade (menina)", imc.interpretarImc(19.0));

        // Faixa etária 6-10 anos
        imc.setIdade(8);
        Assert.assertEquals("Peso normal (menina)", imc.interpretarImc(17.0));
        Assert.assertEquals("Sobrepeso (menina)", imc.interpretarImc(20.0));
        Assert.assertEquals("Obesidade (menina)", imc.interpretarImc(23.0));

        // Faixa etária 11-18 anos
        imc.setIdade(15);
        Assert.assertEquals("Peso normal (menina)", imc.interpretarImc(21.0));
        Assert.assertEquals("Sobrepeso (menina)", imc.interpretarImc(24.0));
        Assert.assertEquals("Obesidade (menina)", imc.interpretarImc(27.0));

        // Faixa etária 19-65 anos
        imc.setIdade(30);
        Assert.assertEquals("Peso normal", imc.interpretarImc(22.0));
        Assert.assertEquals("Sobrepeso", imc.interpretarImc(27.0));
        Assert.assertEquals("Obesidade grau I", imc.interpretarImc(32.0));
        Assert.assertEquals("Obesidade grau II", imc.interpretarImc(37.0));
        Assert.assertEquals("Obesidade grau III (obesidade mórbida)", imc.interpretarImc(40.0));
    }
}

