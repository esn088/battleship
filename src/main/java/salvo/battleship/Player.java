package salvo.battleship;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;


@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String userName;
    private String name;
    private double scorein=0.0;
    @OneToMany(mappedBy="player", fetch=FetchType.EAGER)
    Set<GamePlayer> GamePlayers=new LinkedHashSet<>();
    @OneToMany(mappedBy="player", fetch=FetchType.EAGER)
    Set<Score> scoreSet=new LinkedHashSet<>();

    public Player() { }

    public Player(String user ,String name) {
        this.userName = user;
        this.name=name;
    }

    public double getScorein() {
        return scorein;
    }

    public void setScorein(double scorein) {
        this.scorein = scorein;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName() {
        this.userName = userName;
    }
    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Score> getScoreSet() {
        return scoreSet;
    }

    @JsonIgnore
    public void setScoreSet(Set<Score> scoreSet) {
        this.scoreSet = scoreSet;
    }

    @JsonIgnore

    public Set<GamePlayer> getGamePlayers() {
        return GamePlayers;
    }

    public void setGamePlayers(Set<GamePlayer> gamePlayers) {
        GamePlayers = gamePlayers;
    }
    @JsonIgnore
    public List<Game> getGames() {
        return GamePlayers.stream().map(sub -> sub.getGame()).collect(toList());
    }
}
