package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.model.Ordenador;
import com.example.demo.model.Roles;
import com.example.demo.model.User;
import com.example.demo.model.componentes.Disco;
import com.example.demo.model.componentes.Fuente;
import com.example.demo.model.componentes.Grafica;
import com.example.demo.model.componentes.Procesador;
import com.example.demo.model.componentes.Ram;
import com.example.demo.repository.DiscoRepo;
import com.example.demo.repository.FuenteRepo;
import com.example.demo.repository.GraficaRepo;
import com.example.demo.repository.OrdenadoresRepo;
import com.example.demo.repository.ProcesadorRepo;
import com.example.demo.repository.RamRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.DiscoService;
import com.example.demo.service.FuenteService;
import com.example.demo.service.GraficaService;
import com.example.demo.service.ProcesadorService;
import com.example.demo.service.RamService;

@SpringBootApplication
public class EjemploRestServiceJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjemploRestServiceJwtApplication.class, args);
	}
	@Autowired
	private PasswordEncoder codificador;
	
	@Autowired
	private DiscoService serviceDisco;
	
	@Autowired
	private FuenteService serviceFuente;
	
	@Autowired
	private ProcesadorService serviceProcesador;
	
	@Autowired
	private RamService serviceRam;
	
	@Autowired
	private GraficaService serviceGrafica;
	
	byte[] imagen=null;
	
	@Bean
	CommandLineRunner iniUsuarios(UserRepo repoUsuario) {
		return (arg)-> {
			repoUsuario.save(new User("javi", "javi@gmail.com", "C/guadalpalo", "222444777", codificador.encode("javi"),"visa","756","8888666677774444","Francisco Javier Lira Sánchez", "03/25"));
			User usuario = repoUsuario.findByEmail("javi@gmail.com").orElse(null);
			usuario.setRol(Roles.ROLE_ADMIN);
			repoUsuario.save(usuario);
		};
	}
	
	@Bean
	CommandLineRunner iniRam(RamRepo repoRam) {
		return (arg)-> {
			repoRam.saveAll(Arrays.asList(new Ram("Kingston HyperX",imagen,"Ram tope chula",6, 41.90, "DDR4", "DIMM", 8, "1x8"),
					new Ram("Kingston HyperX",imagen,"",6, 62.90, "DDR4", "DIMM", 8, "2x8"),
					new Ram("Kingston HyperX",imagen,"",6, 100.90, "DDR4", "DIMM", 8, "4x8"),
					new Ram("Kingston FURY",imagen,"",6, 60.90,  "DDR4", "DIMM", 16, "1x16"),
					new Ram("Kingston FURY",imagen,"",6, 99.90,  "DDR4", "DIMM", 16, "2x16"),
					new Ram("Kingston FURY",imagen,"",6, 140.23,  "DDR4", "DIMM", 16, "4x16")));
		};
	}
	
	@Bean
	CommandLineRunner iniDisco(DiscoRepo repoDisco) {
		return (arg)-> {
			repoDisco.saveAll(Arrays.asList(new Disco("Seagate BarraCuda",imagen,"",6, 45.65, "HDD", 1000,"sata3"),
					new Disco("Seagate BarraCuda",imagen,"",6, 60.65, "HDD", 2000,"sata3"),
					new Disco("Kingston A400",imagen,"",6, 42.32, "SSD", 480,"sata3"),
					new Disco("Kingston A400",imagen,"",6, 80.90, "SSD", 1000,"sata3"),
					new Disco("Kingston A400",imagen,"",6, 140.60, "SSD", 2000,"sata3")));
		};
	}
	
	@Bean
	CommandLineRunner iniFuente(FuenteRepo repoFuente) {
		return (arg)-> {
			repoFuente.saveAll(Arrays.asList(new Fuente("Nfortec Sagitta",imagen,"",6, 75.90, "80 Plus Gold", 650),
					new Fuente("Nfortec Sagitta",imagen,"",6, 89.90, "80 Plus Silver",850),
					new Fuente("Nfortec Sagitta",imagen,"",6, 105.90, "80 Plus Gold", 1050),
					new Fuente("Corsair RM750",imagen,"",6, 90.90, "80 Plus Gold", 750),
					new Fuente("Corsair RM850",imagen,"",6, 120.90, "80 Plus Gold", 850),
					new Fuente("Be Quiet! Dark Power Pro 12",imagen,"",6 , 500.90, "80 Plus Titanium", 1500)));
		};
	}
	
	@Bean
	CommandLineRunner iniGrafica(GraficaRepo repoGrafica) {
		return (arg)-> {
			repoGrafica.saveAll(Arrays.asList(new Grafica("MSI VENTUS 3X OC",imagen,"",6 , 880.70, "Nvidia", "RTX 3070 Ti"),
					new Grafica("Asus Dual OC EVO",imagen,"",6 , 910.70, "Nvidia", "RTX 3070 Ti"),
					new Grafica("Sapphire PULSE",imagen,"",6 , 490.90, "AMD", "RX 6600"),
					new Grafica("PowerColor FIGHTER",imagen,"",6 , 480.90, "AMD", "RX 6600")));
		};
	}
	
	@Bean
	CommandLineRunner iniProcesador(ProcesadorRepo repoProcesador) {
		return (arg)-> {
			repoProcesador.saveAll(Arrays.asList(new Procesador("AMD Ryzen 5 5600G",imagen,"",6 , 237.60, "AMD", "Ryzen 5 5600G", "AM4"),
					new Procesador("AMD Ryzen 7 5700G",imagen,"",6 , 328.90, "AMD", "Ryzen 7 5700G", "AM4"),
					new Procesador("Intel Core i7-12700K",imagen,"",6 , 440.60, "Intel", "Core i7-12700K", "1700"),
					new Procesador("Intel Core i5-12400F",imagen,"",6 , 187.60, "Intel", "Core i5-12400F", "1700"),
					new Procesador("Intel Core i7-11700K",imagen,"",6 , 343.60, "Intel", "Core i7-11700K", "1200"),
					new Procesador("Intel Core 5-10400",imagen,"",6 , 160.80, "Intel", "Core 5-10400", "1200")));
		};
	}
	
	
	@Bean
	CommandLineRunner iniOrdenador(OrdenadoresRepo repoOedenador) {
//		String enlace1="https://i.ibb.co/GpLydf4/1.png";
//		String enlace2="https://static.carrefour.es/hd_510x_/imagenes/products/84254/02437/728/8425402437728/imagenGrande1.jpg";
//		String enlace3="https://d10mhq06fikmnr.cloudfront.net/catalog/product/h/u/hunter_rev2_main_rgb-min_4.png";
//		String enlace4="https://www.info-computer.com/65105-large_default/-pc-gaming-i5-9400-29-ghz-8gb-ddr4-ssd-480-gb-w10-home-oferta.jpg";
//		String enlace5="https://www.info-computer.com/78122-large_default/pc-gaming-amd-ryzen-9-5900x-32-gb-ddr4-2-tb-1-tb-ssd-m2-rtx-3080-ti-12-gb-ddr6x-w10-home-64.jpg";
//		
		byte[] enlace1=imagen;
		byte[] enlace2=imagen;
		byte[] enlace3=imagen;
		byte[] enlace4=imagen;
		byte[] enlace5=imagen;
		
		return (arg)-> {
			serviceDisco.buscarDisco((long) 2);
			repoOedenador.saveAll(Arrays.asList(
					new Ordenador("Huawei MateStation B515", serviceRam.buscarRam((long)1), serviceProcesador.buscarProcesador((long)22), serviceDisco.buscarDisco((long) 7), serviceGrafica.buscarGrafica((long)18), serviceFuente.buscarFuente((long)12), enlace1, "Pc con tales características preparado para usar en x sectores" , 3, 240),
					new Ordenador("MSI MAG Codex 5 11TG-814EU", serviceRam.buscarRam((long)1), serviceProcesador.buscarProcesador((long)27), serviceDisco.buscarDisco((long) 11), serviceGrafica.buscarGrafica((long)21), serviceFuente.buscarFuente((long)17), enlace3, "Pc con tales características preparado para usar en x sectores" , 3, 562),
					new Ordenador("Lenovo IdeaCentre 5 14IOB6", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)24), serviceDisco.buscarDisco((long) 8), serviceGrafica.buscarGrafica((long)19), serviceFuente.buscarFuente((long)13), enlace1,"Pc con tales características preparado para usar en x sectores" , 3, 223),
					new Ordenador("MasterBronze", serviceRam.buscarRam((long)1), serviceProcesador.buscarProcesador((long)25), serviceDisco.buscarDisco((long) 8), serviceGrafica.buscarGrafica((long)20), serviceFuente.buscarFuente((long)14), enlace3, "Pc con tales características preparado para usar en x sectores" , 3, 245),
					new Ordenador("MasterGold", serviceRam.buscarRam((long)1), serviceProcesador.buscarProcesador((long)23), serviceDisco.buscarDisco((long) 9), serviceGrafica.buscarGrafica((long)19), serviceFuente.buscarFuente((long)15), enlace4, "Pc con tales características preparado para usar en x sectores" , 3, 842),
					new Ordenador("HP Pavilion Desktop TP01-2000ns", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)25), serviceDisco.buscarDisco((long) 8), serviceGrafica.buscarGrafica((long)20), serviceFuente.buscarFuente((long)16), enlace4,"Pc con tales características preparado para usar en x sectores" , 3, 643),
					new Ordenador("Dell OptiPlex 3080", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)25), serviceDisco.buscarDisco((long) 10), serviceGrafica.buscarGrafica((long)21), serviceFuente.buscarFuente((long)13), enlace3, "Pc con tales características preparado para usar en x sectores" , 3, 546),
					new Ordenador("MasterDiamante", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)26), serviceDisco.buscarDisco((long) 11), serviceGrafica.buscarGrafica((long)21), serviceFuente.buscarFuente((long)12), enlace4, "Pc con tales características preparado para usar en x sectores" , 3, 343.90),
					new Ordenador("MasterBasic", serviceRam.buscarRam((long)1), serviceProcesador.buscarProcesador((long)25), serviceDisco.buscarDisco((long) 7), serviceGrafica.buscarGrafica((long)20), serviceFuente.buscarFuente((long)12), enlace3, "Pc con tales características preparado para usar en x sectores" , 3, 223),
					new Ordenador("Dell Vostro 3681 ", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)25), serviceDisco.buscarDisco((long) 8), serviceGrafica.buscarGrafica((long)20), serviceFuente.buscarFuente((long)14), enlace5, "Pc con tales características preparado para usar en x sectores" , 3, 210.90),
					new Ordenador("Master k32", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)22), serviceDisco.buscarDisco((long) 10), serviceGrafica.buscarGrafica((long)21), serviceFuente.buscarFuente((long)15), enlace1, "Pc con tales características preparado para usar en x sectores" , 3, 214.90),
					new Ordenador("Millenium Machine 1 Mini Soraka", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)23), serviceDisco.buscarDisco((long) 9), serviceGrafica.buscarGrafica((long)19), serviceFuente.buscarFuente((long)16), enlace4, "Pc con tales características preparado para usar en x sectores" , 3, 500),
					new Ordenador("MasterSilver Pro", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)24), serviceDisco.buscarDisco((long) 7), serviceGrafica.buscarGrafica((long)18), serviceFuente.buscarFuente((long)13), enlace3, "Pc con tales características preparado para usar en x sectores" , 3, 100),
					new Ordenador("Master mx2", serviceRam.buscarRam((long)1), serviceProcesador.buscarProcesador((long)23), serviceDisco.buscarDisco((long) 11), serviceGrafica.buscarGrafica((long)21), serviceFuente.buscarFuente((long)12), enlace1, "Pc con tales características preparado para usar en x sectores" , 3, 220),
					new Ordenador("Master mx1", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)27), serviceDisco.buscarDisco((long) 9), serviceGrafica.buscarGrafica((long)20), serviceFuente.buscarFuente((long)14), enlace2, "Pc con tales características preparado para usar en x sectores" , 3, 320),
					new Ordenador("Master xz3", serviceRam.buscarRam((long)1), serviceProcesador.buscarProcesador((long)24), serviceDisco.buscarDisco((long) 10), serviceGrafica.buscarGrafica((long)18), serviceFuente.buscarFuente((long)16), enlace5, "Pc con tales características preparado para usar en x sectores" , 3, 432.90),
					new Ordenador("HP Pavilion TP01-2001ns", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)27), serviceDisco.buscarDisco((long) 11), serviceGrafica.buscarGrafica((long)19), serviceFuente.buscarFuente((long)17), enlace2, "Pc con tales características preparado para usar en x sectores" , 3, 110),
					new Ordenador("Legion-Q Tracker3", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)23), serviceDisco.buscarDisco((long) 8), serviceGrafica.buscarGrafica((long)20), serviceFuente.buscarFuente((long)13), enlace5, "Pc con tales características preparado para usar en x sectores" , 3, 900),
					new Ordenador("MSI MAG Codex 5 11TG-814EU", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)24), serviceDisco.buscarDisco((long) 7), serviceGrafica.buscarGrafica((long)21), serviceFuente.buscarFuente((long)12), enlace2, "Pc con tales características preparado para usar en x sectores" , 3, 300),
					new Ordenador("MSI PRO DP20Z 5M-004EU", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)25), serviceDisco.buscarDisco((long) 10), serviceGrafica.buscarGrafica((long)18), serviceFuente.buscarFuente((long)12), enlace4, "Pc con tales características preparado para usar en x sectores" , 3, 200.90),
					new Ordenador("MSI MEG Infinite X 10TD-829EU", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)26), serviceDisco.buscarDisco((long) 11), serviceGrafica.buscarGrafica((long)21), serviceFuente.buscarFuente((long)15), enlace1, "Pc con tales características preparado para usar en x sectores" , 3, 1200),
					new Ordenador("MSI PRO DP20Z 5M-003EU", serviceRam.buscarRam((long)1), serviceProcesador.buscarProcesador((long)22), serviceDisco.buscarDisco((long) 8), serviceGrafica.buscarGrafica((long)19), serviceFuente.buscarFuente((long)16), enlace3, "Pc con tales características preparado para usar en x sectores" , 3, 220),
					new Ordenador("MSI MAG Infinite 11TG-1413EU", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)25), serviceDisco.buscarDisco((long) 9), serviceGrafica.buscarGrafica((long)20), serviceFuente.buscarFuente((long)12), enlace2, "Pc con tales características preparado para usar en x sectores" , 3, 240),
					new Ordenador("MSI MAG Codex X5 11TE-425EU", serviceRam.buscarRam((long)4), serviceProcesador.buscarProcesador((long)24), serviceDisco.buscarDisco((long) 11), serviceGrafica.buscarGrafica((long)21), serviceFuente.buscarFuente((long)12), enlace5, "Pc con tales características preparado para usar en x sectores" , 3, 380),
					new Ordenador("HP Essential M01-F1106ns", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)26), serviceDisco.buscarDisco((long) 7), serviceGrafica.buscarGrafica((long)20), serviceFuente.buscarFuente((long)17), enlace3, "Pc con tales características preparado para usar en x sectores" , 3, 100.90),
					new Ordenador("HP ProDesk 400 G7 CP", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)27), serviceDisco.buscarDisco((long) 10), serviceGrafica.buscarGrafica((long)21), serviceFuente.buscarFuente((long)16), enlace2,"Pc con tales características preparado para usar en x sectores" , 3, 320),
					new Ordenador("HP Z2 G5", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)27), serviceDisco.buscarDisco((long)7), serviceGrafica.buscarGrafica((long)18), serviceFuente.buscarFuente((long)15), enlace1, "Pc con tales características preparado para usar en x sectores" , 3, 300),
					new Ordenador("HP Z1 G6", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)23), serviceDisco.buscarDisco((long) 8), serviceGrafica.buscarGrafica((long)19), serviceFuente.buscarFuente((long)14), enlace4,"Pc con tales características preparado para usar en x sectores" , 3, 450),
					new Ordenador("HP 290 G4", serviceRam.buscarRam((long)4), serviceProcesador.buscarProcesador((long)24), serviceDisco.buscarDisco((long) 9), serviceGrafica.buscarGrafica((long)20), serviceFuente.buscarFuente((long)13), enlace1,"Pc con tales características preparado para usar en x sectores" , 3, 100),
					new Ordenador("HP Z2 G5", serviceRam.buscarRam((long)2), serviceProcesador.buscarProcesador((long)22), serviceDisco.buscarDisco((long) 11), serviceGrafica.buscarGrafica((long)21), serviceFuente.buscarFuente((long)14), enlace5, "Pc con tales características preparado para usar en x sectores" , 3, 240.90)));
		};
	}

}
