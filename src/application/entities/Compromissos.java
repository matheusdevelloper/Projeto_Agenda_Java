package application.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Compromissos {

    private String titulo;
    private LocalDate data;
    private LocalTime hora;
    private String descricao;

    public Compromissos() {
    }

    public Compromissos(String titulo, LocalDate data, LocalTime hora, String descricao) {
        this.titulo = titulo;
        this.data = data;
        this.hora = hora;
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {

    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        return "Compromisso:\n" +
           "--------------------\n" +
           "Título    : " + titulo + "\n" +
           "Data      : " + data.format(dateFormatter) + "\n" +
           "Hora      : " + hora.format(timeFormatter) + "\n" +
           "Descrição : " + descricao + "\n" +
           "--------------------";
    }

    
    
    
}
