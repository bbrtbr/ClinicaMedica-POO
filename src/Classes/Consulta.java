package Classes;

import Interface.Informacoes;

public class Consulta implements Informacoes {
    Medico medico;
    Paciente paciente;
    int id;
    Boolean realizada;
    Double valor;

    public Consulta(int id, Medico medico, Paciente paciente, Double valor) {
        this.medico = medico;
        this.paciente = paciente;
        this.id = id;
        this.realizada = false;
        this.valor = valor;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println(
                "Médico responsável: " + this.medico.getName() + "\nPaciente: " + this.paciente.getName() + "\nID: "
                        + this.getId()+"\nRealizada: "+ this.getRealizada());
    }

    public Medico getMedico() {
        return medico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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