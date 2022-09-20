package application;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Program {
    public static void main(String[] args) {

        //Instanciando o format para aceitar o meu formato que foi chamado



        //Instaciando uma Data-Hora(Agora com e sem fuso horários)

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
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDate d10 = LocalDate.parse("15/09/2022", dtf);
        LocalDateTime d11 = LocalDateTime.parse("2022-09-21T22:00:00");


        System.out.println(d10.format(dtf));
        System.out.println(d11.format(dtf2));
        //Outras maneira que também funciona
        System.out.println(dtf.format(d10));
        System.out.println(d10.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));//Desta maneira instaciamos apenas nesse momento, depois é descartado

    }
}
