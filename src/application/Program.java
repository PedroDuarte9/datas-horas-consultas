package application;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;



public class Program {

    public static void main(String[] args)  {

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
        LocalDateTime d09 = LocalDateTime.of(2022, 6, 9, 2, 30);


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

//        System.out.println(dtf4.format(d13));//Falta um ajuste
        System.out.println();

        //Convertendo data-hora global para local
        //- Data-hora global, timezone(sistema local) -> Data-hora local
        System.out.println("- Data-hora global, passando o timezone(sistema local) -> Data-hora local");
        LocalDate d24 = LocalDate.parse("2022-05-09");
        LocalDateTime d25 = LocalDateTime.parse("2022-09-21T22:25:00");
        Instant d26 = Instant.parse("2022-09-21T08:28:00Z");


        LocalDateTime r1 = LocalDateTime.ofInstant(d26, ZoneId.systemDefault());
        LocalDateTime r2 = LocalDateTime.ofInstant(d26, ZoneId.of("Portugal"));


        System.out.println(r1);
        System.out.println();
        System.out.println(r2);
        System.out.println();
        System.out.println("Obtendo dados de uma data-hora local");
        System.out.println(" - Data-hora local -> dia, mês, ano, horário");
        System.out.println("Pegando só o dia: " + d24.getDayOfMonth());
        System.out.println();
        System.out.println("Pegando o mês: " + d24.getMonthValue());
        System.out.println();
        System.out.println("Pegando somente o ano: " + d24.getYear());
        System.out.println();
        System.out.println("Pegando a hora do LocalDateTime: " + d25.getHour());
        System.out.println();
        System.out.println("Pegando o minuto do LocalDateTime: " + d25.getMinute());
        System.out.println();

        //Calculos com data-hora
        // - Data-hora +/- tempo -> Data-hora
        System.out.println("Calculos com data-hora");
        LocalDate d14 = LocalDate.parse("2022-09-15");
        LocalDateTime d15 = LocalDateTime.parse("2022-09-21T22:00:00");
        Instant d16 = Instant.parse("2022-09-21T08:28:00Z");

        LocalDate pastWeekLocalDate = d14.minusDays(5);
        LocalDate nextWeekLocalDate = d14.plusDays(6);

        System.out.println("Past Week " + pastWeekLocalDate);
        System.out.println("Next Week " + nextWeekLocalDate);

        LocalDateTime pastWeekLocalDateTime = d15.minusDays(5);
        LocalDateTime nextMinutesLocalDateTime = d15.plusMinutes(25);

        System.out.println("Past Week Date Time " + pastWeekLocalDateTime);
        System.out.println("Next Minute Date Time " + nextMinutesLocalDateTime);

        Instant pastWeekInstant = d16.minus(7, ChronoUnit.DAYS);
        Instant nextWeekInstant = d16.plus(7, ChronoUnit.DAYS);

        System.out.println("Instant " + pastWeekInstant);
        System.out.println("Instant " + nextWeekInstant);
        System.out.println();

        //// - Data-hora 1, Data-hora 2 -> Duração
        System.out.println("- Data-hora 1, Data-hora 2 -> Duração");
        Duration t1 = Duration.between(pastWeekLocalDateTime, d15);
        Duration t2 = Duration.between(pastWeekLocalDate.atStartOfDay(), d14.atStartOfDay()); //Convertendo para LocalDateTime o LocalDate
        Duration t3 = Duration.between(pastWeekInstant, d16);

        System.out.println(" t1 dias = " + t1.toDays());
        System.out.println();
        System.out.println(" t2 dias = " + t2.toDays());
        System.out.println();
        System.out.println(" t3 dias = " + t3.toDays());
        System.out.println();


        //Tipos Date e Calendar, que é o modelo antigo de data-hora usado pelo Java antes da versão 8, geralmente usado em sistemas legado !

    /*Date
       Representa um INSTANT
       Faz parte do pacote java.util

       - Um objeto Date internamente armazena:
        - O número de milissegundos desde a meia noite do dia 1 de janeiro de 1970 GMT (UTC)
        - GMT: Greenwich Mean Time (time zone)
        - UTC: Coordinated Universal Time (time standart)

        SimpleDateFormat
            - Define formatos para conversão entre Date e String
            - dd/MM/yyyy -> 23/07/2018
            - dd/MM/yyyy HH:mm:ss -> 27/07/2018 15:42:07

        Padrão ISO 8601 e classe Instant
            - Formato: yyyy-MM-ddTHH:mm:ssZ A letra Z no final que está indicando que é um horário UTC
            - Exemplo: "2018-06-25T15:42:07Z"
            - Date y3 = Date.from(Instant.parse("2018-06-25T15:42:07Z))
    */

        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        sdf3.setTimeZone(TimeZone.getTimeZone("GMT"));

//        System.out.println("----------------------------------");
//        Date y1 = sdf1.parse("22/08/2022");
//        System.out.println("Data: " + y1);
//
//        Date y2 = sdf2.parse("22/08/2022 15:35:17");
//        System.out.println("Data: " + y2);

        Date y3 = Date.from(Instant.parse("2018-06-25T15:42:07Z"));//Padrão UTC definido
        System.out.println(y3);
        System.out.println();

        //Data Atual
        System.out.println("Datas atual");
        Date x1 = new Date();
        System.out.println(x1);

        Date x2 = new Date(System.currentTimeMillis());
        System.out.println(x2);

        System.out.println();
        System.out.println("Datas a partir de 1969");
        Date x3 = new Date(0L);
        System.out.println(x3);

        Date x4 = new Date(1000L * 60L * 60L * 5);
        System.out.println(x4);

//        System.out.println("----------------------------------");
//        Date y4 = sdf3.parse("22/08/2022 15:00:35");
//        System.out.println("Data: " + y1);
//
//        Date y5 = sdf3.parse("22/08/2022 15:35:17");
//        System.out.println("Data: " + y2);

        Date y6 = Date.from(Instant.parse("2018-06-25T15:42:07Z"));//Padrão UTC definido
        System.out.println(y3);
        System.out.println();

        //Data Atual
        System.out.println("Datas atual");
        Date x5 = new Date();
        System.out.println(x5);

        Date x6 = new Date(System.currentTimeMillis());
        System.out.println(x6);

        System.out.println();
        System.out.println("Datas a partir de 1969");
        Date x7 = new Date(0L);
        System.out.println(x7);

        Date x8 = new Date(1000L * 60L * 60L * 5);
        System.out.println(x8);
        System.out.println();

        //Manipulando uma data com CALENDAR
        //Acrescentando dia mÊs, ano, hora, minuto, segundo.
        System.out.println("Manipulando uma data com CALENDAR\n" +
                "Acrescentando dia mês, ano, hora, minuto, segundo.");
        SimpleDateFormat sfd4 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");//Instanciei o SimpleDateFormat no formato que eu queria

        Date d = Date.from(Instant.parse("2018-06-25T15:14:36Z")); //Chamei o método e passei a data e hora no formato ISO

        System.out.println(sfd4.format(d)); //Mostrei a data e hora formatados

        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.HOUR_OF_DAY, 4);
        d = cal.getTime();

        System.out.println(sfd4.format(d));
        System.out.println();

        //Obtendo uma unidade de tempo
        System.out.println("Obtendo Unidade de Tempo");
        SimpleDateFormat sdf5 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date d1 = Date.from(Instant.parse("2022-06-18T18:55:03Z"));

        System.out.println(sdf5.format(d1));

        Calendar cale = Calendar.getInstance();
        cale.setTime(d1);
        int minute = cale.get(Calendar.MINUTE);
        int mes = 1 + cale.get(Calendar.MONTH);

        System.out.println(minute);
        System.out.println(mes);







    }


}
