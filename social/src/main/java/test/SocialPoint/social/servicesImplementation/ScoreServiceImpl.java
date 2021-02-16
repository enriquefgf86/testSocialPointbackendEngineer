package test.SocialPoint.social.servicesImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.SocialPoint.social.dtos.ScoreDto;
import test.SocialPoint.social.entities.Game;
import test.SocialPoint.social.entities.Player;
import test.SocialPoint.social.entities.Score;
import test.SocialPoint.social.repositories.GameRepository;
import test.SocialPoint.social.repositories.PlayerRepository;
import test.SocialPoint.social.repositories.ScoreRepository;
import test.SocialPoint.social.services.ScoreService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ScoreServiceImpl implements ScoreService {

  @Autowired
  GameRepository gameRepository;
  @Autowired
  PartialScoreServiceImpl partialScoreServiceimpl;
  @Autowired
  PlayerRepository playerRepository;
  @Autowired
  ScoreDto scoreDto;
  @Autowired
  ScoreRepository scoreRepository;

  @Override
  public Map<String, Object> getAllScores() {
    Map<String, Object> allScores = new HashMap<>();
    List<Score> allSC = scoreRepository.findAll();
    allScores.put("score_raking", allSC.stream().sorted((gp1, gp2) -> gp1.getScore().compareTo(gp2.getScore()))
        .map(score -> scoreDto.makeScoreListPerPlayerDto(score))
        .collect(Collectors.toList()));

    return allScores;
  }

  @Override
  public Map<String, Object> reArrangeRanking(Integer top) {
    Map<String, Object> allScores = new HashMap<>();
    List<Score> allSC = scoreRepository.findAll();
    if(top==null ||top==0){
      top=allSC.size();
    }
    allScores.put("score_raking", allSC.stream().sorted((gp1, gp2) -> gp2.getScore().compareTo(gp1.getScore()))
        .map(score -> scoreDto.makeScoreListPerPlayerDto(score)).limit(top).collect(Collectors.toList()));

    return allScores;
  }

  @Override
  public Map<String, Object> rangeRanking(Integer position, Integer positionsRange) {
    Map<String, Object> allScores = new HashMap<>();
    List<Score> allSC = scoreRepository.findAll().stream()
        .sorted((gp1, gp2) -> gp2.getScore().compareTo(gp1.getScore()))
        .collect(Collectors.toList());

    List<Score> aroundDecrease = new ArrayList<>();
    List<Score> aroundIncrease = new ArrayList<>();

    int counterIncreaser = 1;
    int counterDecreaser = 1;

    //////////obteniendo las posiciones crecientes de n posicion en array ////////
    for (int x = position; x < allSC.size(); x++) {
      if (counterIncreaser > positionsRange)
        break;

      aroundIncrease.add(allSC.get(x));

      counterIncreaser++;
    }
    //////////obteniendo las posiciones decrecientes de n posicion en array ////////
    for (int y = position; y < allSC.size(); y--) {

      if (y == 0)
        break;

      if (counterDecreaser > positionsRange)
        break;

      aroundDecrease.add(allSC.get(y));
      counterDecreaser++;

    }
    allScores.put("increasing_range", aroundDecrease.stream().sorted((obj2, obj1) -> obj2.getScore().compareTo(obj1.getScore())).map(score -> scoreDto.makeScoreListPerPlayerDto(score)).collect(Collectors.toList()));
    allScores.put("decreasing_range", aroundIncrease.stream().sorted((obj1, obj2) -> obj1.getScore().compareTo(obj2.getScore())).map(score -> scoreDto.makeScoreListPerPlayerDto(score)).collect(Collectors.toList()));
    return allScores;
  }

  @Override
  public String upDateScorePlayer(Long gameId, Long scoreId, Long playerId) throws Exception {
    Score score = new Score();
    Score currentScore = scoreRepository.findById(scoreId).orElseThrow(() -> new Exception());
    Game gameCurrent = gameRepository.findById(gameId).orElseThrow(() -> new Exception());
    Player currentPlayer = playerRepository.findById(playerId).orElseThrow(() -> new Exception());

    score.setGame(gameCurrent);
    score.setPlayer(currentPlayer);
    scoreRepository.save(score);

    return "Score Updated";
  }

}
