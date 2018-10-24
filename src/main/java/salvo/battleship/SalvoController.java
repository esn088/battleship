package salvo.battleship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api")
public class SalvoController {


    @Autowired
    private GameRepository repoGame;
    @Autowired
    private PlayerRepository repository;
    @Autowired
    private GamePlayerRepository repositoryFull;

    @Autowired
    private ScoreRepository repoScore;

    @RequestMapping("/games")
    public Map<String,Object>getGame() {
        Map<String,Object> gamesDTO = new LinkedHashMap<>();
        List<Game> gps = repoGame.findAll();
        List<Player> player = repository.findAll();
        gamesDTO.put("game", repoGame.findAll().stream().map(game -> makeGameDTO(game)).collect(toList()));
        gamesDTO.put("score",player.stream().map(player1 -> estadoresultado(player1)).collect(toList()));

        return gamesDTO;

    }

    @RequestMapping("/Game_view/{id}")
    public Map<String, Object> makeGamePlayerInfoDTO (@PathVariable Long id) {
        Map<String,Object> gameViewDTO = new LinkedHashMap<>();
        GamePlayer gamePlayer = repositoryFull.findOne(id);
        Set<Ship>barcos=gamePlayer.getShips();
        Set<Salvo>tiros=gamePlayer.getSalvos();
        Set<GamePlayer>setgameplayer=gamePlayer.getGame().getGamePlayers();
        gameViewDTO.put("game", makeGameDTO (gamePlayer.getGame()));
//        gameViewDTO.put("id", makeGameDTO (gamePlayer.getId()));
        gameViewDTO.put("salvos",setgameplayer.stream().map(gamePlayer1 -> makesalvoesDTO(gamePlayer1.getSalvos())).collect(toList()));
        gameViewDTO.put("ships",barcos.stream().map(barco -> makeShipDTO(barco)).collect(toList()));


        return gameViewDTO;
    }

    private Map<String,Object>makesalvoesDTO(Set<Salvo> salvoes){
        Map<String,Object>dto=new LinkedHashMap<>();
        dto.put("salvoes",salvoes.stream().map(salvo -> makeSalvoDTO(salvo)).collect(toList()));
            return dto;
    }

    private Map<String,Object> makeGameDTO(Game game){
        Map<String,Object>dto= new LinkedHashMap<String, Object>();
        Set<GamePlayer> gps = game.getGamePlayers();
        Map<String,Object> gamesDTO = new LinkedHashMap<>();
        List<Player> player = repository.findAll();
        dto.put("id",game.getId());
        dto.put("date",game.getDate());
        dto.put("gameplayer",gps.stream().map(gamePlayer -> makeGamePlayerDTO(gamePlayer)).collect(toList()));
//        dto.put("scores",player.stream().map(player1 -> scoreResults(player1)).collect(toList()));

        return dto;
    }

    private Map<String,Object>makePlayerDTO(Player player){
        Map<String,Object>dto= new LinkedHashMap<String, Object>();
        dto.put("name",player.getName());
        dto.put("username",player.getUserName());
        return dto;
    }

    private Map<String,Object>makeGamePlayerDTO(GamePlayer gameplayer){
        Map<String,Object>dto= new LinkedHashMap<String, Object>();
        dto.put("id",gameplayer.getId());
        dto.put("Player", makePlayerDTO(gameplayer.getPlayer()));

        return dto;
    }

    private Map<String,Object>makeShipDTO(Ship barco){
        Map<String,Object>dto= new LinkedHashMap<String, Object>();
        dto.put("ship",barco.getType());
        dto.put("locations",barco.getLocations());
        return dto;
    }
    private Map<String,Object>makeSalvoDTO(Salvo tiros){
        Map<String,Object>dto= new LinkedHashMap<String, Object>();
        dto.put("player",tiros.getGameplayer().getPlayer().getName());
        dto.put("GameplayerId",tiros.getGameplayer().getId());
        dto.put("turn",tiros.getTurno());
        dto.put("locationsSalvos",tiros.getLocations());
        return dto;
    }



//    private Map<String,Object> scoreResults(Player player){
//        Map<String,Object>dto= new LinkedHashMap<String, Object>();
//        Set<Score>scores=player.getScoreSet();
//        dto.put("score",scores.stream().map(score -> estadoresultado(player)).collect(toList()));
//
//        return dto;
//    }
        private Map<String,Object> estadoresultado(Player player){
            Map<String,Object>dto= new LinkedHashMap<String, Object>();
            dto.put("idplayer",player.getId());
            dto.put("name",player.getName());
            dto.put("username",player.getUserName());
            if(player.getScoreSet().size() != 0) {
                List<Object> scoreswin = player.getScoreSet().stream().filter(b -> b.getPuntaje() == 1.0).collect(toList());
                List<Object> scorestie = player.getScoreSet().stream().filter(b -> b.getPuntaje() == 0.5).collect(toList());
                List<Object> scoreslose = player.getScoreSet().stream().filter(b -> b.getPuntaje() == 0.0).collect(toList());
                List<Double> totalList = player.getScoreSet().stream().map(score -> score.getPuntaje()).collect(toList());

                dto.put("win", scoreswin.size());
                dto.put("lost", scoreslose.size());
                dto.put("tie", scorestie.size());
                dto.put("total", totalList.stream().reduce((a, b) -> a + b).get());

            }else {
               dto.put("score","null");
           }
            return dto;
        }
    }
