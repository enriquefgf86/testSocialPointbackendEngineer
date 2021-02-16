package test.SocialPoint.social.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.SocialPoint.social.services.*;

import java.util.Map;

@RestController
@RequestMapping
public class SocialPointController {

  @Autowired
  GameService gameService;
  @Autowired
  GamePlayerService gamePlayerService;
  @Autowired
  PlayerService playerService;
  @Autowired
  PartialScoreService partialScoreService;
  @Autowired
  ScoreService scoreService;

  //getting all players
  @RequestMapping(value="/test/spoint/all/players",method = RequestMethod.GET )
  public ResponseEntity <Map<String,Object>> getAllPlayers(){
    return new ResponseEntity<>(playerService.getAllPlayers(), HttpStatus.OK);
  }

  //getting player by id
  @RequestMapping(value="/test/spoint/a/player/{playerId}",method = RequestMethod.GET )
  public ResponseEntity <Map<String,Object>> getAllPlayerById(@PathVariable("playerId")Long playerId) throws Exception {
    return new ResponseEntity<>(playerService.getPlayerbyId(playerId), HttpStatus.OK);
  }

  //getting all scores in ascendent order min to max
  @RequestMapping(value="/test/spoint/all/players/scores",method = RequestMethod.GET )
  public ResponseEntity <Map<String,Object>> getAllPlayersScores(){
    return new ResponseEntity<>(scoreService.getAllScores(), HttpStatus.OK);
  }

  //getting top scores according to parameter passed getting the selected top positions
  @RequestMapping(value="/test/spoint/all/players/scores/ranking/top",method = RequestMethod.GET )
  public ResponseEntity <Map<String,Object>> getAllPlayersScores(@RequestParam("top") Integer top){
    return new ResponseEntity<>(scoreService.reArrangeRanking(top), HttpStatus.OK);
  }

  //getting relative rank to one position on bidirectional ways increasing and decreasing
  //passing parameters position, and positionRange
  @RequestMapping(value="/test/spoint/all/players/scores/ranking/range",method = RequestMethod.GET )
  public ResponseEntity <Map<String,Object>> getARange(@RequestParam("position")Integer position,@RequestParam("positionsRange")Integer positionsRange){
    return new ResponseEntity<>(scoreService.rangeRanking(position,positionsRange), HttpStatus.OK);
  }

  //adding partial score in game , for a specific game score passing the double representing
  //the partial score, and the Score of game that is modified
  @RequestMapping(value="/test/spoint/add/partial/{scoreId}",method = RequestMethod.POST )
  public ResponseEntity <String> AddPartialScore(@RequestParam("pScore") Double pScore,@PathVariable("scoreId") Long scoreId) throws Exception {
    return new ResponseEntity<>(partialScoreService.addPartialScore(scoreId,pScore), HttpStatus.OK);
  }

}
