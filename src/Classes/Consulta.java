package Classes;



import Interface.Informacoes;

public class Consulta implements Informacoes {
    Medico medico;
    Paciente paciente;
    
    Boolean realizada;
    Double valor;

    public Consulta(Medico medico, Paciente paciente, Double valor) {
        this.medico = medico;
        this.paciente = paciente;
       
        this.realizada = false;
        this.valor = valor;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Médico responsável: "+this.medico.getName()+"\nPaciente: "+this.paciente.getName()+"\nData: ");
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

   
    public Boolean getRealizada() {
        return realizada;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

   

    public void setRealizada(Boolean realizada) {
        this.realizada = realizada;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    
    
    
    
}