package salvo.battleship;

import com.sun.org.omg.CORBA.Repository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static sun.audio.AudioPlayer.player;

@SpringBootApplication
public class BattleshipApplication {

	public static void main(String[] args) {
		SpringApplication.run(BattleshipApplication.class, args);

	}

	@Bean
	public CommandLineRunner initData(PlayerRepository repository,GameRepository repositoryGame,GamePlayerRepository repositoryFull) {
        return (args) -> {
            // save a couple of customers
            Player user1=(new Player("Jack32@gmail.com"));
            repository.save(user1);
            Player user2=(new Player("Jack33@gmail.com"));
            repository.save(user2);
            Player user3=(new Player("Jack34@gmail.com"));
            repository.save(user3);
            Player user4=(new Player("Jack35@gmail.com"));
            repository.save(user4);
            Player user5=(new Player("Jack36@gmail.com"));
            repository.save(user5);
            Player user6=(new Player("Jack37@gmail.com"));
            repository.save(user6);
            Player user7=(new Player("Jack38@gmail.com"));
            repository.save(user7);
            Player user8=(new Player("Jack39@gmail.com"));
            repository.save(user8);

            Date newDate = new Date();
            newDate = Date.from(newDate.toInstant().plusSeconds(3600));
            Date newDate2 =  Date.from(newDate.toInstant().plusSeconds(3600));
            Date newDate3 =  Date.from(newDate2.toInstant().plusSeconds(3600));
            Date newDate4 =  Date.from(newDate3.toInstant().plusSeconds(3600));
            Date newDate5=  Date.from(newDate4.toInstant().plusSeconds(3600));
            Date newDate6=  Date.from(newDate5.toInstant().plusSeconds(3600));
            Date newDate7=  Date.from(newDate6.toInstant().plusSeconds(3600));
            Date newDate8=  Date.from(newDate7.toInstant().plusSeconds(3600));

            Game game1 = new Game();
            game1.setDate(newDate);
//            game2.setDate(Date.from(Instant.parse("2018-10-10T09:00:00.072Z")));
            repositoryGame.save(game1);

            Game game2 = new Game();
            game2.setDate(newDate2);
            repositoryGame.save(game2);

            Game game3 = new Game();
            game3.setDate(newDate3);

            repositoryGame.save(game3);

            Game game4 = new Game();
            game4.setDate(newDate4);
            repositoryGame.save(game4);

            Game game5 = new Game();
            game5.setDate(newDate5);
            repositoryGame.save(game5);

            Game game6 = new Game();
            game6.setDate(newDate6);
            repositoryGame.save(game6);

            Game game7 = new Game();
            game7.setDate(newDate7);
            repositoryGame.save(game7);

            Game game8 = new Game();
            game8.setDate(newDate8);
            repositoryGame.save(game8);
//
//            Date = new Date();
//            repository.save(new Game(Date= LocalDate.parse("2011-08-03T03:15:00",  Date.from (Date.toInstant ().PlusSeconds (3600)))));
//            Date date = new Date();
            GamePlayer play1= new GamePlayer(user1,game1);
            repositoryFull.save(play1);
            GamePlayer play2= new GamePlayer(user2,game1);
            repositoryFull.save(play2);
            GamePlayer play3= new GamePlayer(user3,game3);
            repositoryFull.save(play3);
            GamePlayer play4= new GamePlayer(user4,game3);
            repositoryFull.save(play4);
            GamePlayer play5= new GamePlayer(user5,game5);
            repositoryFull.save(play5);
            GamePlayer play6= new GamePlayer(user6,game6);
            repositoryFull.save(play6);
            GamePlayer play7= new GamePlayer(user7,game7);
            repositoryFull.save(play7);
            GamePlayer play8= new GamePlayer(user8,game7);
            repositoryFull.save(play8);


        };
    }

}
