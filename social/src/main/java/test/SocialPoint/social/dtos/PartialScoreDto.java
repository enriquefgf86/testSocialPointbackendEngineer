package test.SocialPoint.social.dtos;

import org.springframework.stereotype.Component;
import test.SocialPoint.social.entities.PartialScore;

import java.util.HashMap;
import java.util.Map;

@Component
public class PartialScoreDto {

  public Map<String, Object> partialScoreDto(PartialScore partialScore) {
    Map<String, Object> info = new HashMap<>();
    info.put("pscore", partialScore.getPartial());
    info.put("pscore_for_player", partialScore.getScore().getPlayer().getId());

    return info;

  }

}
