package Classes;

import java.sql.Date;

import Interface.Informacoes;

public class Consulta implements Informacoes {
    Medico medico;
    Paciente paciente;
    Date data;
    Boolean realizada;
    Double valor;

    public Consulta(Medico medico, Paciente paciente, Date utilDate, Double valor) {
        this.medico = medico;
        this.paciente = paciente;
        this.data = utilDate;
        this.realizada = false;
        this.valor = valor;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Médico responsável: "+this.medico.getName()+"\nPaciente: "+this.paciente.getName()+"\nData: "+this.data);
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Date getData() {
        return data;
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

    public void setData(Date data) {
        this.data = data;
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

    public void add(Consulta consulta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }
    
    
    
}