package application.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;



public class Agenda {

    private ArrayList<Compromissos> compromissos = new ArrayList<>();
    LocalDate dataHoje = LocalDate.now();
    LocalTime horaHoje = LocalTime.now();
    

    public Agenda() {
    }
    
    //adiciona todos os compromissos
    public void adicionarCompromisso(Compromissos adicionarCompromisso){
        compromissos.add(adicionarCompromisso);
    }
    
    //remove todos os compromissos solicitados
    public void removerCompromisso(String removerCompromisso){
        compromissos.removeIf(compromisso -> compromisso.getTitulo().equals(removerCompromisso));
    }
 
    //Lista todos os compromissos do dia
    public void listarCompromissos(){

        for(Compromissos comp : compromissos){
            if(comp.getData().equals(dataHoje) && comp.getHora().isAfter(horaHoje)){
               System.out.print(comp.toString()+"\n");
            }
            else {
               System.out.println("Não existe compromissos!");
            }
        }
        
    }

    //Lista todos os compromissos futuros
    public void listarCompromissosFuturos(){

        for(Compromissos comp : compromissos){
           if(!comp.getData().equals(dataHoje) && !comp.getHora().equals(horaHoje)){
              System.out.print(comp.toString()+"\n");
           }
        }
        
    }
}
