package salvo.battleship;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static sun.audio.AudioPlayer.player;

@SpringBootApplication
public class BattleshipApplication {

	public static void main(String[] args) {
		SpringApplication.run(BattleshipApplication.class, args);

	}

	@Bean
	public CommandLineRunner initData(PlayerRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new Player("Jack32@gmail.com"));
            repository.save(new Player("esn088@gmail.com"));
            repository.save(new Player("carlitosway@gmail.com"));
            repository.save(new Player("teplomeo@gmail.com"));
            repository.save(new Player("tupapi088@gmail.com"));
        };
    }

}
