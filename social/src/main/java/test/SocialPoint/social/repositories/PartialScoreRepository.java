package test.SocialPoint.social.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import test.SocialPoint.social.entities.PartialScore;

@RepositoryRestResource
public interface PartialScoreRepository extends JpaRepository<PartialScore,Long> {
}
