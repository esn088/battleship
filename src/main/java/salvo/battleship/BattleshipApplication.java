package salvo.battleship;

import com.sun.org.omg.CORBA.Repository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Array;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static sun.audio.AudioPlayer.player;

@SpringBootApplication
public class BattleshipApplication {

	public static void main(String[] args) {
		SpringApplication.run(BattleshipApplication.class, args);

	}

	@Bean
	public CommandLineRunner initData(PlayerRepository repository,GameRepository repositoryGame,GamePlayerRepository repositoryFull,ShipRepository repositoryship,SalvoRepository salvorepo,ScoreRepository repoScore) {
        return (args) -> {
            // save a couple of customers
            Player user1=(new Player("Jack32@gmail.com","jackson"));
            repository.save(user1);
            Player user2=(new Player("francisco3@gmail.com","francisco"));
            repository.save(user2);
            Player user3=(new Player("esn088@gmail.com","esneider"));
            repository.save(user3);
            Player user4=(new Player("fabio4564@gmail.com","fabio"));
            repository.save(user4);
            Player user5=(new Player("killer0100@gmail.com","jesus"));
            repository.save(user5);
            Player user6=(new Player("asasins33@gmail.com","jhon"));
            repository.save(user6);
            Player user7=(new Player("pepito123@gmail.com","pedro"));
            repository.save(user7);
            Player user8=(new Player("juanplomo1@gmail.com","juan"));
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
            GamePlayer play5= new GamePlayer(user5,game2);
            repositoryFull.save(play5);
            GamePlayer play6= new GamePlayer(user6,game2);
            repositoryFull.save(play6);
            GamePlayer play7= new GamePlayer(user7,game4);
            repositoryFull.save(play7);
            GamePlayer play8= new GamePlayer(user8,game4);
            repositoryFull.save(play8);
            GamePlayer play9= new GamePlayer(user6,game5);
            repositoryFull.save(play9);
            GamePlayer play10= new GamePlayer(user7,game5);
            repositoryFull.save(play10);
            GamePlayer play11= new GamePlayer(user8,game6);
            repositoryFull.save(play11);
            GamePlayer play12= new GamePlayer(user7,game7);
            repositoryFull.save(play12);
            GamePlayer play13= new GamePlayer(user8,game8);
            repositoryFull.save(play13);

            List<String>location= Arrays.asList("H2","H3","H4");
            List<String>location2= Arrays.asList("E1","F1","G1");
            List<String>location3= Arrays.asList("B4","B5");
            List<String>location4= Arrays.asList("B5","C5","D5");
            List<String>location5= Arrays.asList("F1","F2");
            List<String>location6= Arrays.asList("B5","C5","D5");
            List<String>location7= Arrays.asList("C6","C7");
            List<String>location8= Arrays.asList("A2","A3","A4");
            List<String>location9= Arrays.asList("G6","H6");
            List<String>location10= Arrays.asList("B5","C5","D5");
            List<String>location11= Arrays.asList("C6","C7");
            List<String>location12= Arrays.asList("A2","A3","A4");
            List<String>location13= Arrays.asList("G6","H6");
            List<String>location14= Arrays.asList("B5","C5","D5");
            List<String>location15= Arrays.asList("C6","C7");
            List<String>location16= Arrays.asList("A2","A3","A4");
            List<String>location17= Arrays.asList("G6","H6");
            List<String>location18= Arrays.asList("B5","C5","D5");
            List<String>location19= Arrays.asList("C6","C7");
            List<String>location20= Arrays.asList("A2","A2","A4");
            List<String>location21= Arrays.asList("G6","H6");
            List<String>location22= Arrays.asList("B5","C5","D5");
            List<String>location23= Arrays.asList("C6","C7");
            List<String>location24= Arrays.asList("B5","C5","D5");
            List<String>location25= Arrays.asList("C6","C7");
            List<String>location26= Arrays.asList("A2","A3","A4");
            List<String>location27= Arrays.asList("G6","H6");

            Ship b1=new Ship("Destroyer",location,play1);
            repositoryship.save(b1);
            Ship b2=new Ship("Submarine",location2,play1);
            repositoryship.save(b2);
            Ship b3=new Ship("Patrol Boat",location3,play1);
            repositoryship.save(b3);
            Ship b4=new Ship("destroyer",location4,play1);
            repositoryship.save(b4);
            Ship b5=new Ship("Patrol Boat",location5,play1);
            repositoryship.save(b5);

            Ship b6=new Ship("destroyer",location6,play2);
            repositoryship.save(b6);
            Ship b7=new Ship("Patrol Boat",location7,play2);
            repositoryship.save(b7);
            Ship b8=new Ship("Submarine",location8,play2);
            repositoryship.save(b8);
            Ship b9=new Ship("Patrol Boat",location9,play2);
            repositoryship.save(b9);

            Ship b10=new Ship("Destroyer",location10,play3);
            repositoryship.save(b10);
            Ship b11=new Ship("Patrol Boat",location11,play3);
            repositoryship.save(b11);
            Ship b12=new Ship("Submarine",location12,play3);
            repositoryship.save(b12);
            Ship b13=new Ship("Patrol Boat",location13,play3);
            repositoryship.save(b13);

            Ship b14=new Ship("Destroyer",location14,play4);
            repositoryship.save(b14);
            Ship b15=new Ship("Patrol Boat",location15,play4);
            repositoryship.save(b15);
            Ship b16=new Ship("Submarine",location16,play4);
            repositoryship.save(b16);
            Ship b17=new Ship("Patrol Boat",location17,play4);
            repositoryship.save(b17);

            Ship b18=new Ship("Destroyer",location18,play5);
            repositoryship.save(b18);
            Ship b19=new Ship("Patrol Boat",location19,play5);
            repositoryship.save(b19);
            Ship b20=new Ship("Submarine",location20,play5);
            repositoryship.save(b20);
            Ship b21=new Ship("Patrol Boat",location21,play5);
            repositoryship.save(b21);

            Ship b22=new Ship("Destroyer",location22,play6);
            repositoryship.save(b22);
            Ship b23=new Ship("Patrol Boat",location23,play6);
            repositoryship.save(b23);
            Ship b24=new Ship("Destroyer",location24,play8);
            repositoryship.save(b24);
            Ship b25=new Ship("Patrol Boat",location25,play8);
            repositoryship.save(b25);
            Ship b26=new Ship("Submarine",location26,play8);
            repositoryship.save(b26);
            Ship b27=new Ship("Patrol Boat",location27,play8);
            repositoryship.save(b27);

            List<String>tiros1= Arrays.asList("B5","C5","F1");
            List<String>tiros2= Arrays.asList("B4","B5","B6");
            List<String>tiros3= Arrays.asList("F2","D5");
            List<String>tiros4= Arrays.asList("E1","H3","A2");
            List<String>tiros5= Arrays.asList("A2","A4","G6");
            List<String>tiros6= Arrays.asList("B5","D5","C7");
            List<String>tiros7= Arrays.asList("A3","H6");
            List<String>tiros8= Arrays.asList("C5","C6");
            List<String>tiros9= Arrays.asList("G6","H6","A4");
            List<String>tiros10= Arrays.asList("H1","H2","H3");


            Salvo s1=new Salvo(1,tiros1,play1);
            salvorepo.save(s1);
            Salvo s2=new Salvo(2,tiros2,play1);
            salvorepo.save(s2);
            Salvo s3=new Salvo(1,tiros3,play2);
            salvorepo.save(s3);
            Salvo s4=new Salvo(2,tiros4,play2);
            salvorepo.save(s4);

            Score score1=new Score(1.0,user1,game1);
            repoScore.save(score1);
            Score score2=new Score(0.0,user2,game1);
            repoScore.save(score2);
            Score score3=new Score(1.0,user1,game3);
            repoScore.save(score3);
            Score score4=new Score(0.5,user1,game4);
            repoScore.save(score4);
            Score score5=new Score(0.5,user2,game4);
            repoScore.save(score5);
            Score score6=new Score(0.0,user4,game3);
            repoScore.save(score6);
            Score score7=new Score(0.0,user7,game5);
            repoScore.save(score7);
            Score score8=new Score(0.0,user8,game6);
            repoScore.save(score8);



        };
    }

}


