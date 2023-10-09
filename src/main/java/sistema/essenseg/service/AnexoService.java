package sistema.essenseg.service;

import com.google.api.client.util.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sistema.essenseg.model.Anexo;
import sistema.essenseg.model.cliente.Cliente;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Service
public class AnexoService {

    public void uploadDeAnexo(List<MultipartFile> listaDeAnexos, Cliente cliente) throws IOException {

        for (MultipartFile anexo : listaDeAnexos) {

            Anexo novoAnexo = new Anexo();

            ByteArrayOutputStream os = new ByteArrayOutputStream();
            IOUtils.copy(anexo.getInputStream(), os);

            novoAnexo.setAnexoData(os.toByteArray());
            novoAnexo.setCliente(cliente);
            novoAnexo.setNome(anexo.getOriginalFilename());
            novoAnexo.setType(anexo.getContentType());
            cliente.getAnexos().add(novoAnexo);

        }
    }

}
