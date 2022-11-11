package Model;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.*;

public class Empresa {
    JFrame f = new JFrame();
    ArrayList<Funcionario> funcionario = new ArrayList<Funcionario>();
    int cont = 0;

    public void adicionaFuncionario(Funcionario f) { //Método para adicionar um funcionário na ArrayList
        this.funcionario.add(f);
    }

    public double calculaPagamento(int id) { //Método para retornar o salário líquido do funcionário
        int indice = 0;
        boolean achei = false;

        for (Funcionario f : funcionario) { //Laço para buscar um ID no ArrayList
            if (f.getID() == id) {
                achei = true;
                indice = cont; //Guardo a posição do funcionario no ArrayList
            }
            this.cont++;
        }
        this.cont = 0; //Reseto o contador
        if (achei) { //Caso o id tenha sido encontrado
            if (funcionario.get(indice) instanceof Estagiario) { //Verificar qual a instancia do funcionario encontrado na posição "indice" 
                return ((Estagiario) funcionario.get(indice)).getSalario(); //para que o método GetSalario seja usado corretamente
            } else if (funcionario.get(indice) instanceof Secretaria) {
                return ((Secretaria) funcionario.get(indice)).getSalario();
            } else if (funcionario.get(indice) instanceof Gerente) {
                return ((Gerente) funcionario.get(indice)).getSalario();
            } else  {
                return ((Presidente) funcionario.get(indice)).getSalario();
            } 
        }else{
            return -1; //Caso o id não tenha sido encontrado
        }
    }

    public void aumentaAdicional(double percent) { //Método para aumentar o adicional percentual do funcionário
        boolean aumentei = false; //Variável utilizada para verificar se algum aumento foi concedido

        for(Funcionario func : funcionario){ //Percoorre todos os funcionários e altera somente aqueles que são instancia de Gerente ou Presidente
            if(func instanceof Gerente){
                ((Gerente)func).alteraAdicional(percent);
                aumentei = true;
            } else if (func instanceof Presidente){
                ((Presidente)func).alteraAdicional(percent);
                aumentei = true;
            }
        }
        if(aumentei){ //Aumento foi aplicado alguma vez?
            System.out.println("========\nAumento concedido com sucesso\n");
        } else{
            System.out.println("========\n");
            JOptionPane.showMessageDialog(f,
            "Não há nenhum funcionário apto na lista para aplicar um aumento", "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public String geraRelatorio() { //Método para gerar o relatório de todos os funcionários
        String str = "";
        DecimalFormat formatar = new DecimalFormat("0.00");
        for(Funcionario func : funcionario){
            str += "ID: " + func.getID() + " Nome: " + func.getNome() + " Salário: R$" + (formatar.format(func.getSalario())) + "\n";
        }
        return str;
    }
}
