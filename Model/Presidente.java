package Model;


public class Presidente extends Funcionario implements Adicional {
    private double previdencia, adicional_whisky, adicional_helicoptero, adicional_adicional;

    public Presidente(int ID, String nome, double salario){
        super(ID, nome, salario);
        this.previdencia = 0.15;
        setAdicionalWhisky(0.9);
        setAdicionalHelicoptero(0.7);
        setAdicionalAdicional(3.8);
      }

    public void setAdicionalWhisky(double adicionalWhisky){
        this.adicional_whisky = adicionalWhisky;
    }

    public void setAdicionalHelicoptero(double adicionalHelicoptero){      
        this.adicional_helicoptero = adicionalHelicoptero;  
    }                                                                                                                                                                                                                                                           

    public void setAdicionalAdicional(double adicionalAdcional){
        this.adicional_adicional = adicionalAdcional;
    }

    @Override
    public void alteraAdicional(double novo_percentual){
        setAdicionalWhisky(this.adicional_whisky*(1+novo_percentual));
        setAdicionalHelicoptero(this.adicional_helicoptero*(1+novo_percentual));
        setAdicionalAdicional(this.adicional_adicional*(1+novo_percentual));
    }

    @Override
    public double getSalario(){
        // Calcula o salário líquido
        return(salario *((1-this.previdencia)+this.adicional_whisky+
               this.adicional_helicoptero+this.adicional_adicional));
      }
}