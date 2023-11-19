package sistema.essenseg.service;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sistema.essenseg.model.Anexo;
import sistema.essenseg.repository.SeguradoRepository;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class AnexoService {

    @Autowired
    SeguradoRepository seguradoRepository;

    public void uploadDeAnexos(List<MultipartFile> listaDeAnexos, Long seguradoId) {
        for (MultipartFile anexo : listaDeAnexos) {

            var segurado = seguradoRepository.getReferenceById(seguradoId);
            System.out.println(segurado.getDadosPessoaisSegurado().getNome());

            Anexo novoAnexo = new Anexo();

            ByteArrayOutputStream os = new ByteArrayOutputStream();

            try {
                IOUtils.copy(anexo.getInputStream(), os);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            novoAnexo.setAnexoData(os.toByteArray());
            novoAnexo.setSegurado(segurado);
            novoAnexo.setNome(anexo.getOriginalFilename());
            novoAnexo.setType(anexo.getContentType());
            segurado.getAnexos().add(novoAnexo);
        }
    }

    public ResponseEntity<Resource> downloadAnexos(Long seguradoId, Long anexoIndex) {

        var segurado = seguradoRepository.getReferenceById(seguradoId);

        var anexo = segurado.getAnexos().get(anexoIndex.intValue());

        ByteArrayResource resource = new ByteArrayResource(anexo.getAnexoData());

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + anexo.getNome());
        headers.setContentType(MediaType.APPLICATION_PDF);

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(anexo.getAnexoData().length)
                .body(resource);
    }

}
