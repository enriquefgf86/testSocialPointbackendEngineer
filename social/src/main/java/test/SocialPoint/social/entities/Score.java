package test.SocialPoint.social.entities;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Component
@Table(name="SCORE")
public class Score {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Long id;

  @Column(name = "SCORE")
  private Double score;

  @OneToMany(fetch=FetchType.LAZY,mappedBy = "score")
  private List<PartialScore> partialScoreList=new ArrayList<>();

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="PLAYER_ID")
  private Player player;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="GAME_ID")
  private Game game;

  ////////////////////////////////////////////////////////////////////
  public Score(){}


  public Score(Double score, Player player, Game game
//      ,List<PartialScore>partialScoreList
  ) {
    this.score = score;
    this.player = player;
    this.game = game;
//    this.partialScoreList=partialScoreList;
    player.addThisScore(this);
    game.addThisScore(this);
  }
////////////////////////////////////////////////////////////////////////

  public void addPartialScore(PartialScore partialScore){
    partialScoreList.add(partialScore);
  }
  public Long getId() {
    return id;
  }

  public Double getScoreFromPartials() {
    double[] arr = this.partialScoreList.stream().mapToDouble(i -> i.getPartial()).toArray();
    //convirtiendo el array de parciales a un array de doubles

    Double score=0.0;

    for(int index=0; index< arr.length;index++) {
      score = score + arr[index];
    }
    if(score<0.0){
      score=0.0;
    }
    return score;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getScore() {
    return score;
  }

  public void setScore(Double score) {
    this.score = score;
  }

  public List<PartialScore> getPartialScoreList() {
    return partialScoreList;
  }

  public void setPartialScoreList(List<PartialScore> partialScoreList) {
    this.partialScoreList = partialScoreList;
  }

  public Player getPlayer() {
    return player;
  }

  public void setPlayer(Player player) {
    this.player = player;
  }

  public Game getGame() {
    return game;
  }

  public void setGame(Game game) {
    this.game = game;
  }
}
