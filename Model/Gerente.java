package Model;


public class Gerente extends Funcionario implements Adicional{
    private double previdencia, adicional;

    public Gerente(int ID, String nome, double salario, double adicional){
        super(ID, nome, salario);
        this.previdencia = 0.07;
        setAdicional(adicional);
      }

    public void setAdicional(double adicional){
        this.adicional = adicional;
    }

    @Override
    public void alteraAdicional(double novo_percentual){
        setAdicional(adicional*(1+novo_percentual));
      }

    @Override
    public double getSalario(){
        // Calcula o salário líquido
        return(salario * ((1 - this.previdencia) + this.adicional));
    }
}
