package test.SocialPoint.social;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import test.SocialPoint.social.entities.*;
import test.SocialPoint.social.repositories.*;

@SpringBootApplication
public class SocialApplication {

  public static void main(String[] args) {
    SpringApplication.run(SocialApplication.class, args);
  }

  @Bean
  public CommandLineRunner initData(PartialScoreRepository partialScoreRepository, GameRepository gameRepository,
                                    PlayerRepository playerRepository, ScoreRepository scoreRepository, GamePlayerRepository gamePlayerRepository) {

    return (args) -> {
      Player player1 = new Player("test1");
      Player player2 = new Player("test2");
      Player player3 = new Player("test3");
      Player player4 = new Player("test4");
      Player player5 = new Player("test5");

      playerRepository.save(player1);
      playerRepository.save(player2);
      playerRepository.save(player3);
      playerRepository.save(player4);
      playerRepository.save(player5);

      Game game1 = new Game(Long.valueOf(1));
      Game game2 = new Game(Long.valueOf(2));
      Game game3 = new Game(Long.valueOf(3));
      Game game4 = new Game(Long.valueOf(4));
      Game game5 = new Game(Long.valueOf(5));
      Game game6 = new Game(Long.valueOf(6));
      Game game7 = new Game(Long.valueOf(7));
      Game game8 = new Game(Long.valueOf(8));
      Game game9 = new Game(Long.valueOf(9));
      Game game10 = new Game(Long.valueOf(10));
      Game game11 = new Game(Long.valueOf(11));

      gameRepository.save(game1);
      gameRepository.save(game2);
      gameRepository.save(game3);
      gameRepository.save(game4);
      gameRepository.save(game5);
      gameRepository.save(game6);
      gameRepository.save(game7);
      gameRepository.save(game8);
      gameRepository.save(game9);
      gameRepository.save(game10);
      gameRepository.save(game11);

      GamePlayer gamePlayer1 = new GamePlayer(player1, game1);
      GamePlayer gamePlayer2 = new GamePlayer(player1, game2);
      GamePlayer gamePlayer3 = new GamePlayer(player2, game3);
      GamePlayer gamePlayer4 = new GamePlayer(player2, game4);
      GamePlayer gamePlayer5 = new GamePlayer(player2, game5);
      GamePlayer gamePlayer6 = new GamePlayer(player3, game6);
      GamePlayer gamePlayer7 = new GamePlayer(player3, game7);
      GamePlayer gamePlayer8 = new GamePlayer(player4, game8);
      GamePlayer gamePlayer9 = new GamePlayer(player4, game8);
      GamePlayer gamePlayer10 = new GamePlayer(player5, game10);
      GamePlayer gamePlayer11 = new GamePlayer(player5, game11);

      gamePlayerRepository.save(gamePlayer1);
      gamePlayerRepository.save(gamePlayer2);
      gamePlayerRepository.save(gamePlayer3);
      gamePlayerRepository.save(gamePlayer4);
      gamePlayerRepository.save(gamePlayer5);
      gamePlayerRepository.save(gamePlayer6);
      gamePlayerRepository.save(gamePlayer7);
      gamePlayerRepository.save(gamePlayer8);
      gamePlayerRepository.save(gamePlayer9);
      gamePlayerRepository.save(gamePlayer10);
      gamePlayerRepository.save(gamePlayer11);

      Score score1 = new Score(10.0, player1, game1);
      Score score2 = new Score(9.0, player1, game2);
      Score score3 = new Score(12.0, player2, game3);
      Score score4 = new Score(6.0, player2, game4);
      Score score5 = new Score(7.0, player2, game5);
      Score score6 = new Score(17.0, player3, game6);
      Score score7 = new Score(0.0, player3, game7);
      Score score8 = new Score(4.0, player4, game8);
      Score score9 = new Score(11.0, player4, game8);
      Score score10 = new Score(13.0, player5, game10);
      Score score11 = new Score(1.0, player5, game11);

      scoreRepository.save(score1);
      scoreRepository.save(score2);
      scoreRepository.save(score3);
      scoreRepository.save(score4);
      scoreRepository.save(score5);
      scoreRepository.save(score6);
      scoreRepository.save(score7);
      scoreRepository.save(score8);
      scoreRepository.save(score9);
      scoreRepository.save(score10);
      scoreRepository.save(score11);

      PartialScore partialScore1 = new PartialScore(2.0, score1);
      PartialScore partialScore2 = new PartialScore(-1.0, score1);
      PartialScore partialScore3 = new PartialScore(9.0, score1);
      PartialScore partialScore4 = new PartialScore(2.0, score2);
      PartialScore partialScore5 = new PartialScore(7.0, score2);
      PartialScore partialScore6 = new PartialScore(-5.0, score2);
      PartialScore partialScore7 = new PartialScore(5.0, score2);
      PartialScore partialScore8 = new PartialScore(3.0, score3);
      PartialScore partialScore9 = new PartialScore(3.0, score3);
      PartialScore partialScore10 = new PartialScore(3.0, score3);
      PartialScore partialScore11 = new PartialScore(3.0, score3);
      PartialScore partialScore12 = new PartialScore(0.0, score4);
      PartialScore partialScore13 = new PartialScore(3.0, score4);
      PartialScore partialScore14 = new PartialScore(-3.0, score4);
      PartialScore partialScore15 = new PartialScore(6.0, score4);
      PartialScore partialScore16 = new PartialScore(1.0, score5);
      PartialScore partialScore17 = new PartialScore(5.0, score5);
      PartialScore partialScore18 = new PartialScore(-5.0, score5);
      PartialScore partialScore19 = new PartialScore(6.0, score5);
      PartialScore partialScore20 = new PartialScore(20.0, score6);
      PartialScore partialScore21 = new PartialScore(-3.0, score6);
      PartialScore partialScore22 = new PartialScore(1.0, score7);
      PartialScore partialScore23 = new PartialScore(2.0, score7);
      PartialScore partialScore24 = new PartialScore(-3.0, score7);
      PartialScore partialScore25 = new PartialScore(5.0, score8);
      PartialScore partialScore26 = new PartialScore(-1.0, score8);
      PartialScore partialScore27 = new PartialScore(11.0, score9);
      PartialScore partialScore28 = new PartialScore(13.0, score10);
      PartialScore partialScore29 = new PartialScore(5.0, score11);
      PartialScore partialScore30 = new PartialScore(-5.0, score11);
      PartialScore partialScore31 = new PartialScore(1.0, score11);


      partialScoreRepository.save(partialScore1);
      partialScoreRepository.save(partialScore2);
      partialScoreRepository.save(partialScore3);
      partialScoreRepository.save(partialScore4);
      partialScoreRepository.save(partialScore5);
      partialScoreRepository.save(partialScore6);
      partialScoreRepository.save(partialScore7);
      partialScoreRepository.save(partialScore8);
      partialScoreRepository.save(partialScore9);
      partialScoreRepository.save(partialScore10);
      partialScoreRepository.save(partialScore11);
      partialScoreRepository.save(partialScore12);
      partialScoreRepository.save(partialScore13);
      partialScoreRepository.save(partialScore14);
      partialScoreRepository.save(partialScore15);
      partialScoreRepository.save(partialScore16);
      partialScoreRepository.save(partialScore17);
      partialScoreRepository.save(partialScore18);
      partialScoreRepository.save(partialScore19);
      partialScoreRepository.save(partialScore20);
      partialScoreRepository.save(partialScore21);
      partialScoreRepository.save(partialScore22);
      partialScoreRepository.save(partialScore23);
      partialScoreRepository.save(partialScore24);
      partialScoreRepository.save(partialScore25);
      partialScoreRepository.save(partialScore26);
      partialScoreRepository.save(partialScore27);
      partialScoreRepository.save(partialScore28);
      partialScoreRepository.save(partialScore29);
      partialScoreRepository.save(partialScore30);
      partialScoreRepository.save(partialScore31);
    };
  }

}
