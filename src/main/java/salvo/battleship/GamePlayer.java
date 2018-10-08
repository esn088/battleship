package salvo.battleship;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


@Entity
public class GamePlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private Date creationDate = new Date();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="Player_id")
    private Player player ;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="Game_id")
    private Game game ;

    public GamePlayer() { }

    public GamePlayer(Player user,Game game) {
        this.game=game;
        this.player=user;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate ;
    }

    public void setCreationDate() {
        this.creationDate = creationDate;
    }

    public void setPlayer() {
        this.player = player;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setGame() {
        this.game = game;
    }

    public Game getGame() {
        return this.game;
    }
//    public String fullGame() {
//        return this.game+""+getPlayer();
    }
