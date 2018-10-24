package salvo.battleship;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;


@Entity
public class GamePlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private Date creationDate = new Date();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="Player_id")
    private Player player ;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="Game_id")
    private Game game ;

    @OneToMany(mappedBy="gameplayer", fetch=FetchType.EAGER)
    Set<Ship> ships=new LinkedHashSet<>();

    @OneToMany(mappedBy="gameplayer", fetch=FetchType.EAGER)
    Set<Salvo> salvos=new LinkedHashSet<>();

    public GamePlayer() { }

    public GamePlayer(Player user,Game game) {
        this.game=game;
        this.player=user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Set<Ship> getShips() {
        return ships;
    }

    public void setShips(Set<Ship> ships) {
        this.ships = ships;
    }

    public Set<Salvo> getSalvos() {
        return salvos;
    }
    public void setSalvos(Set<Salvo> salvos) {
        this.salvos = salvos;
    }
    public void addShips(Ship ship){
        ship.setGameplayer(this);
        ships.add(ship);
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
