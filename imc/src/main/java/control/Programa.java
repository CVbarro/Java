package control;


public class Programa {
    public static void main(String[] args) {

        Imc calc = new Imc("", 0, "", 0, 0);

        calc.pegarDados();
        calc.exibirResultado();
    }
}
