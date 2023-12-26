package sistema.essenseg.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@Getter
@Setter
public class DocData {

        private HttpHeaders headers;
        private Long contentLength;
        private Resource resource;

        public DocData(String nomeArquivo, Long contentLength, Resource resource) {
                this.headers = new HttpHeaders();
                headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + nomeArquivo);
                headers.setContentType(MediaType.APPLICATION_PDF);
                this.contentLength = contentLength;
                this.resource = resource;
        }
}
