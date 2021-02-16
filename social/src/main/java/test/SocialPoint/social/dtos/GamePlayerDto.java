package test.SocialPoint.social.dtos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.SocialPoint.social.entities.GamePlayer;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class GamePlayerDto {

  @Autowired
  PartialScoreDto partialScoreDto;
  @Autowired
  ScoreDto scoreDto;

  public Map<String, Object> makeGamePlayerDto(GamePlayer gamePlayer) {
    Map<String, Object> info = new HashMap<>();
    info.put("gameP_id", gamePlayer.getId());
    info.put("gameP_score", gamePlayer.getGame().getListScores().stream().collect(Collectors.toList()));
    info.put("gameP_partial_score_list", gamePlayer.getGame().getScoreList().stream().map(score -> score.getPartialScoreList().stream().map(partialScore -> partialScore.getPartial())).collect(Collectors.toList()));
    info.put("player_in_game", gamePlayer.getPlayer().getName());
    info.put("game_id", gamePlayer.getGame().getId());
    return info;
  }
}
