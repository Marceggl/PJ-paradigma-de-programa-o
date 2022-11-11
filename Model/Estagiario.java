package Model;

public class Estagiario extends Funcionario {
    private double vale_coxinha;

    
    public Estagiario(int ID, String nome, double salario, double vale_coxinha){
        super(ID, nome, salario);
        setValeCoxinha(vale_coxinha);
    }

    public void setValeCoxinha( double vale_coxinha ){
        this.vale_coxinha = vale_coxinha;
    }

    @Override
    public double getSalario(){
        // Calcula o salário líquido
        return(salario + this.vale_coxinha);
    }
}