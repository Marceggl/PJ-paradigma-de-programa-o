package Model;

public abstract class Funcionario{
    protected int ID;
    protected String nome;
    protected double salario;

    public Funcionario (int ID, String nome, double Salario){
        setId(ID);
        setNome(nome);
        setSalario(Salario);
    }

    public int getID(){
        return this.ID;
    }

    protected void setId(int ID){
        this.ID = ID;
    }

    public String getNome(){
        return this.nome;
    }

    protected void setNome(String nome){
        this.nome = nome;
    }

    protected void setSalario(double salario){
        this.salario = salario;
    }

    abstract double getSalario();
}