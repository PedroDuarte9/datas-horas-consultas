package application;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Program {
    public static void main(String[] args) {

        //Instanciando o format para aceitar o meu formato que foi chamado
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        //Instaciando uma Data-Hora(Agora com e sem fuso horários)
        System.out.println("Padrão ISO-8601");
        LocalDate d01 = LocalDate.now();
        LocalDateTime d02 = LocalDateTime.now();
        Instant d03 = Instant.now();

        System.out.println(d01);
        System.out.println(d02);
        System.out.println(d03);


        //Texto ISO 8601 e gerar uma hora a partir dele
        LocalDate d04 = LocalDate.parse("2022-09-21");
        LocalDateTime d05 = LocalDateTime.parse("2022-09-21T21:00:00.000");
        Instant d06 = Instant.parse("2022-09-20T21:30:26Z");


        System.out.println(d04.toString());
        System.out.println(d05.toString());
        System.out.println(d06.toString());


        //Texto no formato customizado Data-hora
//        LocalDate d07 = LocalDate.parse("20/09/2023", dtf);

//        System.out.println(d07);

        //Instanciando datas a partir de dados isolados
        LocalDate d08 = LocalDate.of(2022, 8, 15);
        LocalDateTime d09 = LocalDateTime.of(2022, 6, 9,2,30);


        System.out.println(d08);
        System.out.println(d09);


        //Transformando data hora em texto
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());//Formatando Data e Hora de acordo com o fuso horário
        DateTimeFormatter dtf4 = DateTimeFormatter.ISO_DATE_TIME;



        LocalDate d10 = LocalDate.parse("15/09/2022", dtf1);
        LocalDateTime d11 = LocalDateTime.parse("2022-09-21T22:00:00");
        Instant d12 = Instant.parse("2022-09-21T08:28:00Z");
        LocalDate d13 = LocalDate.parse("2022-09-21T22:00:00", dtf4);

        System.out.println();
        System.out.println("A partir daqui será formatado pelo programador");
        System.out.println(d10.format(dtf1));
        System.out.println(d11.format(dtf2));
        //Outras maneira que também funciona
        System.out.println(dtf1.format(d10));
        System.out.println(d10.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));//Desta maneira instaciamos apenas nesse momento, depois é descartado

        System.out.println();
        System.out.println("Mostrando data hora formatada com fuso horário");
        System.out.println(dtf3.format(d12));

        System.out.println(dtf4.format(d13));//Falta um ajuste 


    }
}
