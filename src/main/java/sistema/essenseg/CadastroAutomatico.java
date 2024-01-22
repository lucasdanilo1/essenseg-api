package sistema.essenseg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import sistema.essenseg.dto.administradora.DadosAdministradoraDTO;
import sistema.essenseg.dto.operadora.DadosOperadoraDTO;
import sistema.essenseg.dto.plano.DadosPlanoDTO;
import sistema.essenseg.dto.relacionamento.DadosRelacionamentoDTO;
import sistema.essenseg.service.*;

@Component
public class CadastroAutomatico implements ApplicationRunner {


	@Autowired
	OperadoraService opService;
	@Autowired
	AdministradoraService admService;
	@Autowired
	PlanoService planoService;
	@Autowired
	RelacionamentoService relacionamentoService;


	@Override
	public void run(ApplicationArguments args) {
		try{

			this.opService.cadastrar(new DadosOperadoraDTO("Ideal Saúde")); //ID 1
			this.opService.cadastrar(new DadosOperadoraDTO("Univida")); //ID 2
			this.opService.cadastrar(new DadosOperadoraDTO("Hapivida")); //ID 3
			this.opService.cadastrar(new DadosOperadoraDTO("Blue")); //ID 4
			this.opService.cadastrar(new DadosOperadoraDTO("Ceam Brasil")); //ID 5

			this.admService.cadastrar(new DadosAdministradoraDTO("EasyPlan")); //ID 1
			this.admService.cadastrar(new DadosAdministradoraDTO("Qualicorp")); //ID 2
			this.admService.cadastrar(new DadosAdministradoraDTO("Corpe")); //ID 3
			this.admService.cadastrar(new DadosAdministradoraDTO("Alter")); //ID 4
			this.admService.cadastrar(new DadosAdministradoraDTO("CTESK")); //ID 5
			this.admService.cadastrar(new DadosAdministradoraDTO("Afflix")); //ID 6
			this.admService.cadastrar(new DadosAdministradoraDTO("Bitlife")); //ID 7
			this.admService.cadastrar(new DadosAdministradoraDTO("Capital Beneficios")); //ID 8

			relacionamentoService.relacionar(new DadosRelacionamentoDTO(1L, 1L));
			relacionamentoService.relacionar(new DadosRelacionamentoDTO(1L, 3L));
			relacionamentoService.relacionar(new DadosRelacionamentoDTO(1L, 4L));

			relacionamentoService.relacionar(new DadosRelacionamentoDTO(2L, 7L));
			relacionamentoService.relacionar(new DadosRelacionamentoDTO(2L, 8L));

			relacionamentoService.relacionar(new DadosRelacionamentoDTO(3L, 3L));
			relacionamentoService.relacionar(new DadosRelacionamentoDTO(3L, 4L));
			relacionamentoService.relacionar(new DadosRelacionamentoDTO(3L, 6L));

			relacionamentoService.relacionar(new DadosRelacionamentoDTO(4L, 2L));

			relacionamentoService.relacionar(new DadosRelacionamentoDTO(5L, 1L));
			relacionamentoService.relacionar(new DadosRelacionamentoDTO(5L, 2L));
			relacionamentoService.relacionar(new DadosRelacionamentoDTO(5L, 5L));

			this.planoService.cadastrar(new DadosPlanoDTO(1L, "Ideal Cuidado 10"));
			this.planoService.cadastrar(new DadosPlanoDTO(1L, "Ideal Cuidado 20"));
            this.planoService.cadastrar(new DadosPlanoDTO(1L, "Ideal Cuidado 30"));
			this.planoService.cadastrar(new DadosPlanoDTO(2L, "Exato QC"));
			this.planoService.cadastrar(new DadosPlanoDTO(4L, "Joy QC"));
			this.planoService.cadastrar(new DadosPlanoDTO(4L, "Joy QP"));
			this.planoService.cadastrar(new DadosPlanoDTO(5L, "Bronze QC"));
			this.planoService.cadastrar(new DadosPlanoDTO(5L, "Bronze QP"));
            this.planoService.cadastrar(new DadosPlanoDTO(5L, "Bronze Plus QP"));

		}catch (Exception e){
			System.out.println(e.getMessage());
		}

	}
}
