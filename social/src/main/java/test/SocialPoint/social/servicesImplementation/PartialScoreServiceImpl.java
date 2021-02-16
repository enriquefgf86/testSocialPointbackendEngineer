package test.SocialPoint.social.servicesImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.SocialPoint.social.dtos.PartialScoreDto;
import test.SocialPoint.social.entities.Game;
import test.SocialPoint.social.entities.PartialScore;
import test.SocialPoint.social.entities.Player;
import test.SocialPoint.social.entities.Score;
import test.SocialPoint.social.repositories.GameRepository;
import test.SocialPoint.social.repositories.PartialScoreRepository;
import test.SocialPoint.social.repositories.PlayerRepository;
import test.SocialPoint.social.repositories.ScoreRepository;
import test.SocialPoint.social.services.PartialScoreService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PartialScoreServiceImpl implements PartialScoreService {
  @Autowired
  PartialScoreRepository partialScoreRepository;

  @Autowired
  PartialScoreDto partialScoreDto;

  @Autowired
  PlayerRepository playerRepository;

  @Autowired
  GameRepository gameRepository;

  @Autowired
  ScoreRepository scoreRepository;

  @Override
  public Map<String, Object> getAllPartialScores() {
    Map<String, Object> allPartialScores= new HashMap<>();
    List<PartialScore> allPSC = partialScoreRepository.findAll();

    allPartialScores.put("all_Prtial_scores", allPSC.stream()
        .sorted((gp1, gp2) -> gp1.getId().compareTo(gp2.getId()))
        .map(partialScore -> partialScoreDto.partialScoreDto(partialScore))
        .collect(Collectors.toList()));

    return allPartialScores;
  }

  @Override
  public String addPartialScore(Long scoreId, Double pScore) throws Exception {
    Score score=scoreRepository.findById(scoreId).orElseThrow(()->new Exception());

    PartialScore addingPartialScore=new PartialScore();

    addingPartialScore.setPartial(pScore);
    addingPartialScore.setScore(score);

    partialScoreRepository.save(addingPartialScore);


    return "Score added";
  }
}
