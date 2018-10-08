package salvo.battleship;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import sun.util.calendar.BaseCalendar;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;


@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private Date date = new Date();
    @OneToMany(mappedBy="game", fetch=FetchType.EAGER)
    Set<GamePlayer> GamePlayers=new LinkedHashSet<>();

    public Game() { }


    public void setDate(Date Data) {
        this.date = Data;
    }

    public Date getDate() {
        return this.date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<GamePlayer> getGamePlayers() {
        return GamePlayers;
    }

    public void setGamePlayers(Set<GamePlayer> gamePlayers) {
        GamePlayers = gamePlayers;
    }


    public List<Player> getPlayers() {
        return GamePlayers.stream().map(sub -> sub.getPlayer()).collect(toList());
    }
}
