package test.SocialPoint.social.servicesImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.SocialPoint.social.dtos.PlayerDto;
import test.SocialPoint.social.entities.Player;
import test.SocialPoint.social.repositories.PlayerRepository;
import test.SocialPoint.social.services.PlayerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

  @Autowired
  PlayerDto playerDto;
  @Autowired
  PlayerRepository playerRepository;

  @Override
  public Map<String, Object> getAllPlayers() {
    Map<String, Object> allPlayers = new HashMap<>();
    List<Player> all = playerRepository.findAll();

    allPlayers.put("all_players", all.stream()
        .sorted((player1, player2) -> player1.getId().compareTo(player2.getId()))
        .map(player -> playerDto.makePlayerDto(player))
        .collect(Collectors.toList()));
    return allPlayers;
  }

  @Override
  public Map<String, Object> getPlayerbyId(Long playerId) throws Exception {
    Map<String, Object> aPlayer = new HashMap<>();
    Player player = playerRepository.findById(playerId).orElseThrow(() -> new Exception());
    aPlayer.put("player", playerDto.makePlayerDto(player));
    aPlayer.put("testx",playerDto.makePlayerGetAScoreDto(player));
    return aPlayer;
  }

}
