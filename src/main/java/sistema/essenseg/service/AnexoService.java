package sistema.essenseg.service;

import com.google.api.client.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sistema.essenseg.model.Anexo;
import sistema.essenseg.model.cliente.Cliente;
import sistema.essenseg.repository.ClienteRepository;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class AnexoService {

    @Autowired
    ClienteRepository clienteRepository;

    public void uploadDeAnexos(List<MultipartFile> listaDeAnexos, Cliente cliente) {
        for (MultipartFile anexo : listaDeAnexos) {

            Anexo novoAnexo = new Anexo();

            ByteArrayOutputStream os = new ByteArrayOutputStream();

            try {
                IOUtils.copy(anexo.getInputStream(), os);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            novoAnexo.setAnexoData(os.toByteArray());
            novoAnexo.setCliente(cliente);
            novoAnexo.setNome(anexo.getOriginalFilename());
            novoAnexo.setType(anexo.getContentType());
            cliente.getAnexos().add(novoAnexo);
        }
    }

    public ResponseEntity<Resource> downloadAnexos(Long clienteId, Long anexoId) {

        var cliente = clienteRepository.getReferenceById(clienteId);

        var anexo = cliente.getAnexos().get(anexoId.intValue());

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
