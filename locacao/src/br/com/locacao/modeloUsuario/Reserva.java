package br.com.locacao.modeloUsuario;



public class Reserva {
	private int Reserva;
	private int numMatricula;
	private String dataReserva;
	private String tempoInicial;
	private String tempoFinal;
	private String disciplina;
	private String turma;
	
	public int getReserva() {
		return Reserva;
	}
	public void setReserva(int reserva) {
		Reserva = reserva;
	}
	public int getNumMatricula() {
		return numMatricula;
	}
	public void setNumMatricula(int numMatricula) {
		this.numMatricula = numMatricula;
	}
	public String getDataReserva() {
		return dataReserva;
	}
	public void setDataReserva(String dataReserva) {
		this.dataReserva = dataReserva;
	}
	
	public String getTempoInicial() {
		return tempoInicial;
	}
	
	public void setTempoInicial(String tempoInicial) {
		this.tempoInicial = tempoInicial;
	}
	
	public String getTempoFinal() {
		return tempoFinal;
	}
	
	public void setTempoFinal(String tempoFinal) {
		this.tempoFinal = tempoFinal;
	}
	
	public String getDisciplina() {
		return disciplina;
	}
	
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
	public String getTurma() {
		return turma;
	}
	
	public void setTurma(String turma) {
		this.turma = turma;
	}
	
	
}
