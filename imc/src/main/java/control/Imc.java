package control;

import model.Pessoa;

import java.util.Scanner;

public class Imc extends Pessoa {
    private double altura;
    private double peso;

    public Imc(String nome, int idade, String sexo, double peso, double altura) {
        super(nome, idade, sexo);
        this.peso = peso;
        this.altura = altura;

    }

    public void pegarDados() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        this.setNome(sc.nextLine());

        System.out.println("Digite sua idade: ");
        this.setIdade(sc.nextInt());

        sc.nextLine();

        System.out.println("Digite seu sexo (homem/mulher): ");
        this.setSexo(sc.nextLine());

        System.out.println("Digite seu peso (kg): ");
        this.setPeso(sc.nextDouble());

        System.out.println("Digite sua altura (m): ");
        this.setAltura(sc.nextDouble());
    }

    public double calculoImc(double peso, double altura) {
        double imc = peso / (altura * altura);
        return imc;
    }

    public double pesoIdeal() {
        if (getSexo().equalsIgnoreCase("homem")) {
            return (altura * 100 - 100) * 0.90;
        } else if (getSexo().equalsIgnoreCase("mulher")) {
            return (altura * 100 - 100) * 0.85;
        } else {
            throw new IllegalArgumentException("Sexo inválido. Use 'homem' ou 'mulher'.");
        }
    }

    public void exibirResultado() {
        double imc = calculoImc(peso, altura);
        double pesoIdeal = pesoIdeal();
        String resultado = interpretarImc(imc);

        System.out.println("Seu IMC é: " + imc);
        System.out.println("Classificação: " + resultado);
        System.out.println("Seu peso ideal é: " + pesoIdeal);
    }

    public String interpretarImc(double imc) {
        if (getSexo().equalsIgnoreCase("homem")) {
            return interpretarImcParaHomens(imc);
        } else if (getSexo().equalsIgnoreCase("mulher")) {
            return interpretarImcParaMulheres(imc);
        } else {
            return "Sexo inválido. Use 'homem' ou 'mulher'.";
        }
    }

    private String interpretarImcParaHomens(double imc) {
        int idade = getIdade();
        if (idade >= 2 && idade <= 5) {
            if (imc < 14) {
                return "Abaixo do peso (menino)";
            } else if (imc >= 14 && imc <= 17) {
                return "Peso normal (menino)";
            } else if (imc > 17 && imc <= 19) {
                return "Sobrepeso (menino)";
            } else {
                return "Obesidade (menino)";
            }
        } else if (idade > 5 && idade <= 10) {
            if (imc < 15) {
                return "Abaixo do peso (menino)";
            } else if (imc >= 15 && imc <= 18) {
                return "Peso normal (menino)";
            } else if (imc > 18 && imc <= 21) {
                return "Sobrepeso (menino)";
            } else {
                return "Obesidade (menino)";
            }
        } else if (idade > 10 && idade <= 20) {
            if (imc < 16) {
                return "Abaixo do peso (menino)";
            } else if (imc >= 16 && imc <= 22) {
                return "Peso normal (menino)";
            } else if (imc > 22 && imc <= 25) {
                return "Sobrepeso (menino)";
            } else {
                return "Obesidade (menino)";
            }
        } else if (idade > 20 && idade <= 65) {
            if (imc < 16) {
                return "Baixo peso muito grave";
            } else if (imc >= 16 && imc <= 16.99) {
                return "Baixo peso grave";
            } else if (imc >= 17 && imc <= 18.49) {
                return "Baixo peso";
            } else if (imc >= 18.50 && imc <= 24.99) {
                return "Peso normal";
            } else if (imc >= 25 && imc <= 29.99) {
                return "Sobrepeso";
            } else if (imc >= 30 && imc <= 34.99) {
                return "Obesidade grau I";
            } else if (imc >= 35 && imc <= 39.99) {
                return "Obesidade grau II";
            } else {
                return "Obesidade grau III (obesidade mórbida)";
            }
        }
        return "Idade fora do intervalo para homens.";
    }


    private String interpretarImcParaMulheres(double imc) {
        int idade = getIdade();
        if (idade >= 2 && idade <= 5) {
            if (imc < 13) {
                return "Abaixo do peso (menina)";
            } else if (imc >= 13 && imc <= 16) {
                return "Peso normal (menina)";
            } else if (imc > 16 && imc <= 18) {
                return "Sobrepeso (menina)";
            } else {
                return "Obesidade (menina)";
            }
        } else if (idade > 5 && idade <= 10) {
            if (imc < 14) {
                return "Abaixo do peso (menina)";
            } else if (imc >= 14 && imc <= 17) {
                return "Peso normal (menina)";
            } else if (imc > 17 && imc <= 20) {
                return "Sobrepeso (menina)";
            } else {
                return "Obesidade (menina)";
            }
        } else if (idade > 10 && idade <= 18) {
            if (imc < 15) {
                return "Abaixo do peso (menina)";
            } else if (imc >= 15 && imc <= 21) {
                return "Peso normal (menina)";
            } else if (imc > 21 && imc <= 24) {
                return "Sobrepeso (menina)";
            } else {
                return "Obesidade (menina)";
            }
        } else if (idade > 18 && idade <= 65) {
            if (imc < 16) {
                return "Baixo peso muito grave";
            } else if (imc >= 16 && imc <= 16.99) {
                return "Baixo peso grave";
            } else if (imc >= 17 && imc <= 18.49) {
                return "Baixo peso";
            } else if (imc >= 18.50 && imc <= 24.99) {
                return "Peso normal";
            } else if (imc >= 25 && imc <= 29.99) {
                return "Sobrepeso";
            } else if (imc >= 30 && imc <= 34.99) {
                return "Obesidade grau I";
            } else if (imc >= 35 && imc <= 39.99) {
                return "Obesidade grau II";
            } else {
                return "Obesidade grau III (obesidade mórbida)";
            }
        }
        return "Idade fora do intervalo para mulheres.";
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    public double getAltura() {
        return altura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }
}
