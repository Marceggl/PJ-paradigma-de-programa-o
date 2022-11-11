package Controller;

import java.util.Scanner;
import javax.swing.*;

public class trataValores {

    Scanner ler = new Scanner(System.in);
    boolean verificado = false;
    JFrame f = new JFrame();

    public int opcaoMenu() { // Método para impedir que o usuário digite letras, causando o encerramento do programa
        int opcao = 0;
        System.out.println("Escolha uma das seguintes opções:\n" +
                "Opção 1: Adicionar Funcionario\n" +
                "Opção 2: Calcular Pagamento do Funcionário\n" +
                "Opção 3: Aumentar adicional dos funcionários\n" +
                "Opção 4: Relatório de funcionários\n" +
                "Opção 5: sair");
        while (!this.verificado) { // Não irá parar de solicitar a opção enquanto não a digitar corretamente
            try {
                opcao = ler.nextInt();
                return opcao;
            } catch (Exception e) {
                ler.nextLine();
                JOptionPane.showMessageDialog(f,
                        "Você digitou uma letra, digite apenas números", "Erro", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        return 0;
    }

    public int validaID() { // Método para impedir erros ao usuário digitar letras e números muito grandes para a variável ID

        System.out.println("Digite o ID do funcionário para saber o valor do seu pagamento");

        while (!this.verificado) { // Não irá parar de solicitar o id enquanto não o digitar corretamente
            try {
                int id = ler.nextInt();
                return id;
            } catch (Exception e) {
                ler.nextLine();
                JOptionPane.showMessageDialog(f,
                        "Você digitou um caractere inválido ou um número muito grande, tente novamente", "Erro",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }

        return 0;
    }

    public double validaSalario() { // Método para impedir que o usuário digite letras no lugar de números
        double salario = 0;
        System.out.println("Qual o salário do funcionário? (digite '-1' para encerrar cadastro)");

        while (!this.verificado) { // Não irá parar de solicitar o salário enquanto não o digitar corretamente
            try {
                salario = ler.nextDouble();
                return salario;
            } catch (Exception e) {
                ler.nextLine();
                JOptionPane.showMessageDialog(f,
                        "Você digitou um caractere inválido, tente novamente", "Erro",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }

        return 0;

    }

    public double validaValeCoxinha() { // Método para impedir que o usuário digite letras no lugar de números
        double valeCoxinha = 0;
        System.out.println("Qual o valor do Vale Coxinha do Estagiário?");

        while (!this.verificado) { // Não irá parar de solicitar o Vale Coxinha enquanto não o digitar corretamente
            try {
                valeCoxinha = ler.nextDouble();
                return valeCoxinha;
            } catch (Exception e) {
                ler.nextLine();
                JOptionPane.showMessageDialog(f,
                        "Você digitou um caractere inválido, tente novamente", "Erro",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }

        return 0;

    }

    public float validaPorcentagem(String modulo) { // Método para impedir que o usuário digite letras no lugar de números e valores muito grandes
        float porcentagem = 0;
        if (modulo.equalsIgnoreCase("adicional")) { // Caso o método seja utilizado na parte de cadastro do gerente
            System.out
                    .println("Qual o adicional que o gerente receberá no seu salário? (somente valores de 0,0 a 1,0)");

            while (!this.verificado) { // Não irá parar de solicitar o percentual enquanto não o digitar corretamente
                try {
                    porcentagem = ler.nextFloat();
                    if (porcentagem >= 0 && porcentagem <= 1) {
                        return porcentagem;
                    }

                    while (!this.verificado) { // Não irá parar de solicitar o percentual enquanto não o digitar corretamente (Caso não esteja no intervalo permitido)

                        JOptionPane.showMessageDialog(f,
                                "Valor percentual inválido, digite novamente!!!", "Erro",
                                JOptionPane.INFORMATION_MESSAGE);
                        porcentagem = ler.nextFloat();

                        if (porcentagem >= 0 && porcentagem <= 1) {
                            return porcentagem;
                        }
                    }
                } catch (Exception e) {
                    ler.nextLine();
                    JOptionPane.showMessageDialog(f,
                            "Você digitou um caractere inválido ou um número muito grande, tente novamente", "Erro",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else { // Caso o método seja utiliado na opção 3 do menu
            System.out.println("Digite um aumento para funcionários que têm direito: (valores de 0,0 a 1,0) ");

            while (!this.verificado) { // Não irá parar de solicitar o percentual enquanto não o digitar corretamente
                try {
                    porcentagem = ler.nextFloat();
                    if (porcentagem >= 0 && porcentagem <= 1) {
                        return porcentagem;
                    }

                    while (!this.verificado) { // Não irá parar de solicitar o percentual enquanto não o digitar corretamente (Caso não esteja no intervalo permitido)
                        JOptionPane.showMessageDialog(f,
                                "Valor percentual inválido, digite novamente!!!", "Erro",
                                JOptionPane.INFORMATION_MESSAGE);

                        porcentagem = ler.nextFloat();

                        if (porcentagem >= 0 && porcentagem <= 1) {
                            return porcentagem;
                        }
                    }
                } catch (Exception e) {
                    ler.nextLine();
                    JOptionPane.showMessageDialog(f,
                            "Você digitou um caractere inválido ou um número muito grande, tente novamente", "Erro",
                            JOptionPane.INFORMATION_MESSAGE);

                }
            }
        }
        return 0;
    }

    public int validaCargo() { // Método utilizado na validação de cargos no cadastro do funcionario
        String cargo = ler.next();

        switch (cargo.toLowerCase()) {
            case "estagiario":
                return 1;
            case "secretaria":
                return 2;
            case "gerente":
                return 3;
            case "presidente":
                return 4;
            case "cancelar":
                return 5;
        }
        JOptionPane.showMessageDialog(f,
                "Cargo inválido! Tente novamente", "Erro",
                JOptionPane.INFORMATION_MESSAGE);
        return validaCargo();// caso o cargo não esteja nas opções, repita recursivamente o método
    }

    public String validaNome(){
        System.out.println("Digite o nome do funcionário (ou 'cancelar' para encerrar cadastro)");
        
        while(!this.verificado){ // Não irá parar de solicitar o nome enquanto não o digitar corretamente
            String nome = ler.nextLine();

            if(nome.length() >= 3){  //Caso tenha mais de 3 caracteres, retorne o nome
                return nome;
            }  
            JOptionPane.showMessageDialog(f,
            "Você digitou um nome inválido, tente novamente", "Erro",
            JOptionPane.INFORMATION_MESSAGE);
        }  
        return "";            
    }
}
