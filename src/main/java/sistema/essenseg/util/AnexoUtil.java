package sistema.essenseg.util;

import org.springframework.stereotype.Component;
import sistema.essenseg.model.Anexo;

@Component
public class AnexoUtil {

    public static String getExtencao(Anexo anexo){
        String[] tipoString = anexo.getType().split("/");
        return tipoString[1];
    }

}
