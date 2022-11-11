package Controller;

import java.util.Scanner;
import Model.*;
import javax.swing.*;

class usaClasses {

    public static void main(String[] args) {
        JFrame f = new JFrame();
        Scanner ler = new Scanner(System.in);  //Cria o objeto Scanner para coletar valores de entrada
        Empresa empresa = new Empresa();  //Cria o objeto empresa, usado para acessar as funções da classe Empresa
        trataValores valida = new trataValores();  //Cria o objeto valida, usado para impedir que o usuário digite valores que causem erro no sistema
        int opcao = 0, id = 1;

        System.out.println("Bem vindo ao sistema da empresa...");

        do {  //Loop que se repetirá até que a opção digitada pelo usuário seja diferente de 5 (finalizar)

            opcao = valida.opcaoMenu();  //Chamada do método que tratará o valor da opção digitada pelo usuário
            System.out.println("========");

            switch (opcao) { //Estrutura de condição que decidirá o andamento do programa de acordo com o que foi digitado pelo usuário

                case 1: //Caso o usuário tenha escolhido a oção de cadastrar
                    Funcionario funcionario = preencheDados(id); //Função para preencher informações de cadastro
                    if (funcionario != null) { //Condição criada caso o usuário tenha cancelado o cadastro
                        empresa.adicionaFuncionario(funcionario); //Funcionário é adicionado na ArrayList
                        System.out.println("\nFuncionário cadastrado com sucesso\n========");
                        id++;
                    }else{
                        System.out.println("\nCadastro interrompido\n========");
                    }
                    break;
                case 2: //Caso a opção escolhida seja a de consultar o salário do funcionário
                    int idBusca = valida.validaID();
                    System.out.println("========");
                    double salarioTotal = empresa.calculaPagamento(idBusca); //Buscará o salario do funcionario do ID digitado
                    if (salarioTotal == -1.0) { //Caso o ID digitado não exista
                        JOptionPane.showMessageDialog(f,
                        "ID Inexistente", "Erro", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        System.out.printf("\nO salário total desse funcionário é: R$%.2f\n========\n", salarioTotal);
                    }
                    break;
                case 3: //Caso a opção escolhida tenha sido a de aplicar um aumento percentual para funcionários que tem direito
                    Float aumento = valida.validaPorcentagem("aumento");
                    empresa.aumentaAdicional(aumento);
                    break; 
                case 4: //Caso a opção escolhida tenha sido a de gerar um relatório de todos os funcionários cadastrados
                    String relatorio = empresa.geraRelatorio();
                    if (relatorio == "") { //Caso não tenha nenhum funcionário cadastrado
                        JOptionPane.showMessageDialog(f,
                        "Lista de funcionários é vazia", "Erro", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        System.out.println(relatorio);
                    }
                    break;
                case 5: //Caso a opção escolhida tenha sido 5, encerrará o laço do....while e a condicional switch
                    break;
                default: //Caso a opção escolhida seja inválida
                JOptionPane.showMessageDialog(f,
                        "Opção Inválida", "Erro", JOptionPane.INFORMATION_MESSAGE);
                    break;
            }

        } while (opcao != 5);
        System.out.println("Sistema finalizado! Volte sempre :)");
    }

    public static Funcionario preencheDados(int id) { //Método para coletar dados do funcionário
        Scanner ler = new Scanner(System.in);
        trataValores valida = new trataValores(); //Cria o objeto para a classe de tratamento dos dados
        String nome;
        int cargo;
        double salario, vale_coxinha;
        float adicional;

        
        nome = valida.validaNome(); //Valida e Grava o nome do funcionario
        if(nome.compareToIgnoreCase("cancelar") == 0){
            return null;
        }
        System.out.println("========");

        salario = valida.validaSalario(); //Valida e grava o salário do funcionário
        if(salario == -1){
            return null;
        }
        System.out.println("========");

        System.out.println("Qual o cargo do funcionário que será adicionado?\n" +
                "Escolha entre: estagiario, gerente, presidente, secretaria ou cancelar");

        cargo = valida.validaCargo();  //Valida e grava o número correspodente ao cargo do funcionário

        System.out.println("========");

        if (cargo == 1) { //Caso o cargo seja estagiario
            vale_coxinha = valida.validaValeCoxinha();
            System.out.println("========"); //Valida e grava o valor do vale coxinha do estagiario
            Estagiario estagiario = new Estagiario(id, nome, salario, vale_coxinha);
            return estagiario; //Envia o objeto Estagiario para a classe main o adicionar na ArrayList
        } else if (cargo == 2) { //Caso o cargo seja Secretaria
            Secretaria secretaria = new Secretaria(id, nome, salario);
            return secretaria; //Envia o objeto Secretaria para a classe main o adicionar na ArrayList
        } else if (cargo == 3) { //Caso o cargo seja Gerente
            adicional = valida.validaPorcentagem("adicional"); //Valida e grava o valor percentual do adicional que o gerente receberá
            System.out.println("========");
            Gerente gerente = new Gerente(id, nome, salario, adicional);
            return gerente; //Envia o objeto Gerente para a classe main o adicionar na ArrayList
        } else if (cargo == 4) { //Caso o cargo seja Presidente
            Presidente presidente = new Presidente(id, nome, salario);
            return presidente; //Envia o objeto Presidente para a classe main o adicionar na ArrayList
        } else if(cargo == 5){ //Caso o usuário tenha escolhido cancelar o cadastro
            return null;
        }
        return null; //Caso ocorra algum erro durante a passagem de cargo

    }
}