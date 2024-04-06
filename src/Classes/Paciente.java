package Classes;

public class Paciente extends Pessoa {
    private double saldo;

    public Paciente(String name, String cpf, String endereço, String telefone, String email, String senha, double saldo) {
        super(name, cpf, endereço, telefone, email, senha);
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public boolean verificarSaldo (double valor){
        if(this.saldo<valor){
          
            return false;
        }else{
            System.out.println("Saldo suficiente");
            return true;
        }

    }
}
