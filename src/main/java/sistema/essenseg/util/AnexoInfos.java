package sistema.essenseg.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;

@AllArgsConstructor
@Getter
public class AnexoInfos{

        private HttpHeaders headers;
        private Long contentLength;
        private Resource resource;

}
