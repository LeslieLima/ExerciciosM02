package tech.devinhouse.veiculos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tech.devinhouse.veiculos.model.Multa;
import tech.devinhouse.veiculos.model.TipoVeiculo;
import tech.devinhouse.veiculos.model.Veiculo;
import tech.devinhouse.veiculos.repository.MultaRepository;
import tech.devinhouse.veiculos.repository.VeiculoRepository;

import java.util.List;

@SpringBootApplication
public class VeiculosApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeiculosApplication.class, args);
	}

	@Bean
	CommandLineRunner run(VeiculoRepository veiculoRepo, MultaRepository multaRepo) {
		return args -> {
			// gravando veiculos
			Veiculo veiculo1 = new Veiculo("ABC-1234", TipoVeiculo.AUTOMOVEL,
					"Bat-Movel", 2022, "preto");
			Veiculo veiculo2 = new Veiculo("BCA-4321", TipoVeiculo.ONIBUS,
					"Enterprise", 1960, "prata");
			veiculoRepo.save(veiculo1);
			veiculoRepo.save(veiculo2);
			// gravando multas
			Multa multa1 = new Multa("Gothan City", "Farol apagado", 250F, veiculo1);
			Multa multa2 = new Multa("Gothan City", "Insulfilm", 100F, veiculo1);
			Multa multa3 = new Multa("Hiper-espaço", "Excesso velocidade", 400F, veiculo2);
			multaRepo.save(multa1);
			multaRepo.save(multa2);
			multaRepo.save(multa3);
			// Atualizando multa do segundo veiculo
			multa3.setValor(380F);
			multaRepo.save(multa3);
			// Consultando e mostrando dados no console
			System.out.println(" - - - - - - - - ");
			System.out.println();
			List<Veiculo> veiculos = veiculoRepo.findAll();
			for(Veiculo veiculo : veiculos) {
				System.out.println(veiculo);
			}
			System.out.println(" - - - - - - - - ");
		};
	}

}
