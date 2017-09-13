package com.blackjackclient.tiit.client;

import java.io.IOException;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestOperations;

import com.blackjackclient.tiit.game.GameRound;
import com.blackjackclient.tiit.player.Player;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Client {
	private final RestOperations rest;
	private final String url;
	private ObjectMapper mapper = new ObjectMapper();
	
	public Client(final RestTemplateBuilder builder, final ClientProperties props) {
		this.rest=builder.setReadTimeout(props.getReadTimeout())
				.setConnectTimeout(props.getConnectTimeout())
				.build();
		this.url=props.getGameServiceUrl();
	}
	
	public Player createPlayer(Player player) {
		try {
			player = mapper.readValue(rest.postForObject(url+"createPlayer", player, String.class), Player.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return player;
		
	}
	
	public Player getPlayer(String name) {
		Player player = null;
		try {
			player = mapper.readValue(rest.getForObject(url+"getPlayerByName/{name}", String.class, name), Player.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return player;
	}

	public Player addCash(Player player, String cash) {
		try {
			player = mapper.readValue(rest.postForObject(url+"addCashToPlayer", player, String.class), Player.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return player;
		
	}

	public GameRound dealHand(Player player) {
		GameRound gameRound= null;
		try {
			gameRound = mapper.readValue(rest.postForObject(url+"dealHand", player, String.class), GameRound.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return gameRound;
		
	}

	public GameRound dealPlayer(GameRound game) {
		GameRound gameRound= null;
		try {
			gameRound = mapper.readValue(rest.postForObject(url+"dealPlayer", game, String.class), GameRound.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return gameRound;
	}

	public GameRound dealDealer(GameRound game) {
		GameRound gameRound= null;
		try {
			gameRound = mapper.readValue(rest.postForObject(url+"dealDealer", game, String.class), GameRound.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return gameRound;
	}
	
	public Player dealWin(Player player) {
		try {
			player = mapper.readValue(rest.postForObject(url+"dealWin", player, String.class), Player.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return player;
	}
	public Player dealLoss(Player player) {
		try {
			player = mapper.readValue(rest.postForObject(url+"dealLoss", player, String.class), Player.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return player;
	}
}
