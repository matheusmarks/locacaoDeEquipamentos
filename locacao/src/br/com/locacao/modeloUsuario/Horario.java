package br.com.locacao.modeloUsuario;

public class Horario {
	private String diaDaSemana;
	private String tempo;
	private int cod_horario;
	
	public int getCod_horario() {
		return cod_horario;
	}

	public void setCod_horario(int cod_horario) {
		this.cod_horario = cod_horario;
	}

	public String getDiaDaSemana() {
		return diaDaSemana;
	}
	
	public void setDiaDaSemana(String diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
	}
	

	
	
}
