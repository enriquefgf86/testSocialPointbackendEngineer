package test.SocialPoint.social.dtos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.SocialPoint.social.entities.Player;
import test.SocialPoint.social.entities.Score;
import test.SocialPoint.social.repositories.PlayerRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ScoreDto {
  @Autowired
  PlayerRepository playerRepository;

  @Autowired
  PartialScoreDto  partialScoreDto;
  public Map<String,Object> makeScoreDto(Score score){
    Map<String,Object> info=new HashMap<>();
    info.put("score_import",score.getScoreFromPartials());
    info.put("score",score.getPartialScoreList().stream().map(partialScore -> partialScoreDto.partialScoreDto(partialScore)).collect(Collectors.toList()));
    return info;
  }

  public Map<String,Object> makeScoreListPerPlayerDto(Score score){
    Map<String,Object> info=new HashMap<>();
    info.put("score_import",score.getScoreFromPartials());
    info.put("player_id",score.getPlayer().getId());
    info.put("player_name",score.getPlayer().getName());
    return info;

  }


}
