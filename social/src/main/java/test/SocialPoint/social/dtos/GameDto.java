package test.SocialPoint.social.dtos;

import org.springframework.stereotype.Component;
import test.SocialPoint.social.entities.Game;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class GameDto {

  public Map<String, Object> makeGameDto(Game game) {
    Map<String, Object> info = new HashMap<>();
    info.put("game_id", game.getId());
    info.put("game_score", game.getListScores().stream().collect(Collectors.toList()));
    info.put("game_pScores", game.getListPartialScores().stream().collect(Collectors.toList()));
    return info;
  }

}
