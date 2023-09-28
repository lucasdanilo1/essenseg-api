package sistema.essenseg.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class dataConverterService {

    public static LocalDate converterData(String dataString){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate data = LocalDate.parse(dataString, formatter);
        return data;

    }


}
