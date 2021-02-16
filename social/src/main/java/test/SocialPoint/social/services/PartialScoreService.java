package test.SocialPoint.social.services;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public interface PartialScoreService {

  public  Map<String,Object> getAllPartialScores();

  public String addPartialScore(Long scoreId,Double pScore) throws Exception;

}
