package test.SocialPoint.social.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name="GAME")
public class Game {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Long id;

  @OneToMany(fetch =FetchType.LAZY,mappedBy = "game")
  private Set<GamePlayer> gamePlayerSet=new HashSet<>();

  @OneToMany(fetch = FetchType.LAZY,mappedBy = "game")
  private List<Score> scoreList=new ArrayList<>();
///////////////////////////////////////////////////////////////////
  public Game(){}
  public Game(Long id) {
    this.id = id;
  }
  ////////////////////////////////////////////////////////////////////////////

  public void addThisGamePlayer(GamePlayer gamePlayer){
    gamePlayerSet.add(gamePlayer);
  }
  //adicionando el game especifico

  public void addThisScore(Score score){
    scoreList.add(score);
  }
  //adicionando score al game

  public List<Double>getListScores(){
    return scoreList.stream().map(score -> score.getScoreFromPartials()).collect(Collectors.toList());
  }

  public List<List<Double>>getListPartialScores(){
    List<List<Double>> allPartialScores=new ArrayList();
    scoreList.stream().map(x-> x.getPartialScoreList().stream().map(partialScore -> partialScore.getPartial()).collect(Collectors.toList()));
    return allPartialScores;
  }
  // todos los socres parciales por score

  public Set<Player>getSetOfGamesPlayer(){
    return (Set<Player>) gamePlayerSet.stream().map(set -> set.getPlayer()).collect(Collectors.toList());
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Set<GamePlayer> getGamePlayerSet() {
    return gamePlayerSet;
  }

  public void setGamePlayerSet(Set<GamePlayer> gamePlayerSet) {
    this.gamePlayerSet = gamePlayerSet;
  }

  public List<Score> getScoreList() {
    return scoreList;
  }

  public void setScoreList(List<Score> scoreList) {
    this.scoreList = scoreList;
  }
}
