package test.SocialPoint.social.entities;

import org.springframework.beans.factory.annotation.Autowired;
import test.SocialPoint.social.dtos.PartialScoreDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name="PLAYER")
public class Player {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Long id;

  @Column(name = "NAME")
  private String name;

  @OneToMany(fetch = FetchType.LAZY,mappedBy = "player")
  private Set<GamePlayer> gamePlayerSet=new HashSet();

  @OneToMany(fetch = FetchType.LAZY,mappedBy = "player")
  private List<Score> playerScores=new ArrayList<>();

  ////////////////////////////////////////////////////////////////////////////////////
  public Player(){}
  public Player( String name) {
    this.name = name;
  }
  ////////////////////////////////////////////////////////////////////////////////////////
  public void addThisGamePlayer(GamePlayer gamePlayer){
    gamePlayerSet.add(gamePlayer);
  }
  //adicionando el game especifico

  public void addThisScore(Score score){
    playerScores.add(score);
  }
  //adicionando score al jugador

  public List<Double>getListScores(){
    return getPlayerScores().stream().map(score -> score.getScore()).collect(Collectors.toList());
  }//obteniendo lista de scores por jugador

  public List<PartialScore>getListPartialScores(){
    List<PartialScore> allPartialScores=new ArrayList();

    return allPartialScores.stream().map(lispartials->lispartials).collect(Collectors.toList());

  }//obteniendo lista de scores por jugador

  public Set<Game>getSetOfGamesPlayer(){
    return gamePlayerSet.stream().map(set -> set.getGame()).collect(Collectors.toSet());
  }
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<GamePlayer> getGamePlayerSet() {
    return gamePlayerSet;
  }

  public void setGamePlayerSet(Set<GamePlayer> gamePlayerSet) {
    this.gamePlayerSet = gamePlayerSet;
  }

  public List<Score> getPlayerScores() {
    return playerScores;
  }

  public void setPlayerScores(List<Score> playerScores) {
    this.playerScores = playerScores;
  }
}
