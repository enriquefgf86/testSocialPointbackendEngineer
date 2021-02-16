package test.SocialPoint.social.services;

import org.springframework.stereotype.Component;
import test.SocialPoint.social.entities.PartialScore;

import java.util.List;
import java.util.Map;

@Component
public interface ScoreService {

  public Map<String,Object> getAllScores();

  public Map<String,Object> reArrangeRanking(Integer top);

  public Map<String,Object> rangeRanking(Integer position,Integer positionsRange);

  public String upDateScorePlayer(Long gameId,Long scoreId,Long playerId) throws Exception;

}
