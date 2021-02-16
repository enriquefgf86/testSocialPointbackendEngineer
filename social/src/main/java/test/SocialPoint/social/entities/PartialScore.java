package test.SocialPoint.social.entities;

import javax.persistence.*;

@Entity
@Table(name="PARTIALSCORE")
public class PartialScore {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Long id;

  @Column(name = "PARTIAL")
  private Double partial;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="SCORE_ID")
  private Score score;
  //////////////////////////////////////////////////////////////////////////////
  public PartialScore(){}
  public PartialScore(Double partial
      ,Score score
  ) {
    this.partial = partial;
    this.score = score;
    score.addPartialScore(this);
  }
  /////////////////////////////////////////////////////////////////////

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getPartial() {
    return partial;
  }

  public void setPartial(Double partial) {
    this.partial = partial;
  }

  public Score getScore() {
    return score;
  }

  public void setScore(Score score) {
    this.score = score;
  }
}
