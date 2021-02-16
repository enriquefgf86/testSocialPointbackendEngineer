package test.SocialPoint.social.servicesImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.SocialPoint.social.dtos.GameDto;
import test.SocialPoint.social.entities.Game;
import test.SocialPoint.social.repositories.GameRepository;
import test.SocialPoint.social.services.GameService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

  @Autowired
  GameDto gameDto;
  @Autowired
  GameRepository gameRepository;

  @Override
  public Map<String, Object> getAllgames() {
    Map<String, Object> allGames = new HashMap<>();
    List<Game> all = gameRepository.findAll();
    allGames.put("all_games", all.stream().sorted((game1, game2) -> game1.getId().compareTo(game2.getId()))
        .map(game -> gameDto.makeGameDto(game)).collect(Collectors.toList()));
    return allGames;
  }
}
