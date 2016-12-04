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
	private Date[] datas = new Date[3];
	
	public Dados(String titulo, String descricao, int prioridade, Date meta) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.prioridade = prioridade;
		datas[0] = new Date(System.currentTimeMillis()); // criacao
		datas[1] = null; // termino
		datas[2] = meta; // meta
	}
	
	public void aceitarVisita(Visitor v) {
		v.visitar(titulo, descricao, prioridade, datas);
	}

}
