package application;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import application.entities.Agenda;
import application.entities.Compromissos;

public class App {
    public static void main(String[] args) throws Exception {

        DateTimeFormatter fmtterData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmtterHora = DateTimeFormatter.ofPattern("HH:mm");

        Scanner sc = new Scanner(System.in);

        Agenda agenda = new Agenda();
        
        do {

            System.out.println("=======AGENDA=======");
        
            System.out.print("1-Adicionar Compromisso\n"
                            +"2-Remover   Compromisso\n"
                            +"3-Listar todos os Compromissos de hoje\n"
                            +"4-Listar todos os compromissos futuros\n"
                            +"5-Sair\n");
            int opcao = sc.nextInt();
            sc.nextLine();
    
            switch (opcao) {
    
                case 1:
                    System.out.print("Titulo da Reunião: ");
                    String titulo = sc.nextLine();
    
                    System.out.print("Data (dd/MM/yyyy): ");
                    String dataStr = sc.nextLine();
                    LocalDate data = LocalDate.parse(dataStr, fmtterData);
    
                    System.out.print("Hora (HH:mm): ");
                    String horaStr = sc.nextLine();
                    LocalTime hora = LocalTime.parse(horaStr, fmtterHora);
    
                    System.out.print("Descrição: ");
                    String descricao = sc.nextLine();
                    
                    if(!titulo.isBlank() && !dataStr.isBlank() && !horaStr.isBlank() && !descricao.isBlank()){

                        Compromissos compromisso = new Compromissos(titulo, data, hora, descricao);
                        agenda.adicionarCompromisso(compromisso);
                        System.out.println();
                        System.out.println("compromisso '"+titulo+"' foi adicionado com sucesso!");
                        
                    }else {
                        System.out.println("Um ou mais campos estão vazios ou contêm apenas espaços em branco.");
                    }
                    
                    break;

                case 2:
                    System.out.print("Título do compromisso a remover: ");
                    String removerCompromisso = sc.nextLine();
                    agenda.removerCompromisso(removerCompromisso);
                    System.out.println("compromisso foi removido com sucesso!");
                    break;
                
                case 3:
                    System.out.println("_____________________");
                    System.out.println();
                    System.out.println("Todos os Compromissos de hoje!");
                    agenda.listarCompromissos();
                    System.out.println("_____________________");
                    sc.nextLine();
                    break;

                case 4:
                    System.out.println("_____________________");
                    System.out.println();
                    System.out.println("Todos os Compromissos futuros!");
                    agenda.listarCompromissosFuturos();
                    System.out.println("_____________________");
                    sc.nextLine();
                    break;
                
                case 5:
                    System.out.println("Saindo...");
                    sc.close();
                    return;
            
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        }while(true);
        
       

    }
}
