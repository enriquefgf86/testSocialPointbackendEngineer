package test.SocialPoint.social.entities;

import javax.persistence.*;

@Entity
@Table(name="GAMEPLAYER")
public class GamePlayer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "PLAYER_ID")
  Player player;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "GAME_ID")
  Game game;

  ///////////////////////////////////////////////////////////////////////
public GamePlayer(){}
  public GamePlayer( Player player, Game game) {
    this.player = player;
    this.game = game;
    player.addThisGamePlayer(this);
    game.addThisGamePlayer(this);
  }
  ///////////////////////////////////////////////////////////////////////

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
