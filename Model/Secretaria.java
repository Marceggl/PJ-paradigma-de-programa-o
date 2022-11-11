package Model;


public class Secretaria extends Funcionario{
    private double previdencia;

    public Secretaria(int ID, String nome, double salario){
        super(ID, nome, salario);
        this.previdencia = 0.05;
    }

    @Override
    public double getSalario(){
        // Calcula o salário líquido
        return(salario * (1 - this.previdencia));
    }
}
