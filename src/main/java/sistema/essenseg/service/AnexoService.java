package sistema.essenseg.service;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sistema.essenseg.model.Anexo;
import sistema.essenseg.repository.SeguradoRepository;
import sistema.essenseg.util.DocData;

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

            Anexo novoAnexo = new Anexo();

            ByteArrayOutputStream os = new ByteArrayOutputStream();

            try {
                IOUtils.copy(anexo.getInputStream(), os);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            novoAnexo.setAnexoData(os.toByteArray());
            novoAnexo.setSegurado(segurado);
            novoAnexo.setNomeArquivo(anexo.getOriginalFilename());
            novoAnexo.setTipoArquivo(anexo.getContentType());
            segurado.getAnexos().add(novoAnexo);
        }
    }

    public DocData downloadAnexos(Long seguradoId, Long anexoIndex) {

        var segurado = seguradoRepository.getReferenceById(seguradoId);

        var anexo = segurado
                .getAnexos()
                .get(anexoIndex.intValue());

        ByteArrayResource resource = new ByteArrayResource(anexo.getAnexoData());

        return new DocData(anexo.getNomeArquivo(), resource.contentLength(), resource);
    }

}
