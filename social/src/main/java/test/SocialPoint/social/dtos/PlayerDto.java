package test.SocialPoint.social.dtos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.SocialPoint.social.entities.Player;
import test.SocialPoint.social.entities.Score;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class PlayerDto {

  @Autowired
  GamePlayerDto gamePlayerDto;

  @Autowired
  Score score;

  public Map<String,Object> makePlayerDto(Player player){
    Map<String,Object> info=new HashMap<>();
    info.put("player_name",player.getName());
    info.put("player_games",player.getGamePlayerSet().stream()
        .map(gamePlayer -> gamePlayerDto.makeGamePlayerDto(gamePlayer))
        .collect(Collectors.toList()));
    info.put("player_scores",player.getPlayerScores().stream().map(score1 -> score1.getScore()).collect(Collectors.toList()));
    return info;
  }

  public Map<String,Object> makePlayerGetAScoreDto(Player player){
    Map<String,Object> info=new HashMap<>();
    info.put("player_name",player.getName());
    info.put("player_score",player.getPlayerScores().stream().map(score1 -> score1.getScore()).collect(Collectors.toList()));
    return info;
  }

}
