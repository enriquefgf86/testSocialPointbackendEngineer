package test.SocialPoint.social.servicesImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.SocialPoint.social.dtos.GamePlayerDto;
import test.SocialPoint.social.entities.GamePlayer;
import test.SocialPoint.social.repositories.GamePlayerRepository;
import test.SocialPoint.social.services.GamePlayerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GamePlayerServiceImpl implements GamePlayerService {

  @Autowired
  GamePlayerRepository gamePlayerRepository;

  @Autowired
  GamePlayerDto gamePlayerDto;

  @Override
  public Map<String, Object> getAllgamePlayers() {
    Map<String, Object> allgamesPlayers = new HashMap<>();
    List<GamePlayer> allGP = gamePlayerRepository.findAll();

    allgamesPlayers.put("all_game_players", allGP.stream()
        .sorted((gp1, gp2) -> gp1.getId().compareTo(gp2.getId()))
        .map(gamePlayer ->gamePlayerDto.makeGamePlayerDto(gamePlayer))
        .collect(Collectors.toList()));

    return allgamesPlayers;
  }

}
