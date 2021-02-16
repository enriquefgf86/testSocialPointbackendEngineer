package test.SocialPoint.social.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import test.SocialPoint.social.entities.Player;

@RepositoryRestResource
public interface PlayerRepository extends JpaRepository<Player,Long> {
  Player findByName(String name);
}
