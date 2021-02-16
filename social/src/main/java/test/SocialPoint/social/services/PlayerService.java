package test.SocialPoint.social.services;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public interface PlayerService {

  public Map<String,Object> getAllPlayers();

  public  Map<String,Object> getPlayerbyId(Long playerId) throws Exception;
}
