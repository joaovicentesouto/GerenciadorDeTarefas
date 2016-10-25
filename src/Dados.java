import java.util.Date;

/*package com.mkyong;
https://www.mkyong.com/java/java-how-to-get-current-date-time-date-and-calender/
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;*/

public class Dados {
	
	private String titulo, descricao;
	private int prioridade;
	private Date criacao, termino, meta;
	
	public Dados(String titulo, String descricao, int prioridade, Date meta) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.prioridade = prioridade;
		this.meta = meta;
		criacao = new Date();
		termino = null;
	}

}
