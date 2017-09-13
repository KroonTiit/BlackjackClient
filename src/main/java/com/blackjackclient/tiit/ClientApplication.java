package com.blackjackclient.tiit;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.blackjackclient.tiit.client.Client;
import com.blackjackclient.tiit.game.GameRound;
import com.blackjackclient.tiit.player.Player;

@SpringBootApplication
public class ClientApplication implements CommandLineRunner{
	public static Logger logger = LoggerFactory.getLogger(ClientApplication.class);
	@Autowired
	private  Client client;
	public static void main(String[] args)  {
		SpringApplication.run(ClientApplication.class, args);
	}
	
	@Override 
	public void run(String... args) throws Exception {
		Player player = new Player();
		logger.info("Tere tulemast BlackJacki!");
		logger.info("Kas soovid jätkata olemas oleva kasutajaga(1), soovid luua uue kasutaja(2)?");
		Scanner userInput = new Scanner(System.in);
		String input = userInput.nextLine();
		 if (!input.isEmpty()) {
			 if (input.equals("1")) {
				 input = null;
				 logger.info("Sisesta nimi: ");
				 input = userInput.nextLine();
				 if (!input.isEmpty()) {
					player = client.getPlayer(input);
					if (player == null) {
						logger.info("Sellist kasutajat ei ole! Sisestage uue kasutaja nimi:");
						input = userInput.nextLine();
						player.setName(input);
						logger.info("Sisestage alustamiseks raha summa:");
						input = userInput.nextLine();
						if (!input.isEmpty()) {
							player.setCash(Integer.parseInt(input));
							client.createPlayer(player);
						}
					}
					logger.info("Kas soovite raha juurde lisada? hetke saldo: "+player.getCash()+"  jah(1)/ei(2)");
					input = userInput.nextLine();
					if (!input.isEmpty()) {
						if(player.getCash() == 0 && input.equals("2")) {
							logger.info("Teie kontol on viiga vähe raha!");
						 } else if (input.equals("1")) {
							 logger.info("Soovite lisada(int): ");
						 	input = userInput.nextLine();
						 	if (!input.isEmpty()) {
						 		player.setCash(Integer.parseInt(input));
						 		player = client.addCash(player,input);
						 		logger.info("Hetke saldo: "+player.getCash());
						 		input = "1";
						 		while (input.equals("1")) {
						 			logger.info("Kas soovid juurde lisada? jah(1)/ei(2)");
						 			input = userInput.nextLine();
						 			if (!input.isEmpty() && !input.equals("2")) {
						 				logger.info("Soovite lisada(int): ");
						 				input = userInput.nextLine();
						 				player = client.addCash(player,input);
						 				logger.info("Hetke saldo: "+player.getCash());
								 		input = "1";
						 			}
						 		}
						 	}
						 }
					 }
				 }
			 } else if (input.equals("2")) {
				 logger.info("Sisesta nimi: ");
				 input = userInput.nextLine();
				 if (!input.isEmpty()) {
					 player.setName(input);
					 logger.info("Sisestage alustamiseks raha summa:");
					 input = userInput.nextLine();
					 if (!input.isEmpty()) {
						 player.setCash(Integer.parseInt(input));
						 client.createPlayer(player);
					 }
				 }
			 }
		 }
		 logger.info("Soovite alustada mänguga(1) või soovite väljuda(2)?");
		 input = userInput.nextLine();
		 if (!input.isEmpty() && input.equals("1")) {
			 playGame(player, userInput, client);
		 }
	}

	private static void playGame(Player player, Scanner userInput, Client client) {
		while(true) {
			logger.info("Pange panus: ");
			String input = userInput.nextLine();
			if (!input.isEmpty()) {
				if(player.getCash() - Integer.parseInt(input)<=0) {
					logger.info("Teil ei ole piisavalt raha et sellist panust teha. ");
					logger.info("Lisage juurde(int): ");
					input = userInput.nextLine();
					if (!input.isEmpty()) {
						player.setCash(Integer.parseInt(input));
				 		player = client.addCash(player,input);
				 		logger.info("Uus saldo: "+player.getCash());
					}
				} else {
					while(true) {
						player.setBet(Integer.parseInt(input));
						GameRound game = client.dealHand(player);
						while(true) {
							game.getDealersHand().printHand(false);
							game.getPlayersHand().printHand(true);
							logger.info("Lisa kaart? jah(1)/ei(2)");
							input = userInput.nextLine();
							if (!input.isEmpty() && input.equals("1")) {
								game = client.dealPlayer(game);
								if (game.getPlayersHand().getHandSum() > 21) {
									logger.info("Dealer võitis!");
									game.getDealersHand().printHand(true);
									player = client.dealLoss(player);
									break;
								}
							} else {
								game=client.dealDealer(game);
								if ((game.getDealersHand().getHandSum() >= game.getPlayersHand().getHandSum()) && game.getDealersHand().getHandSum()<=21) {
									logger.info("Dealer võitis!");
									game.getDealersHand().printHand(true);
									player = client.dealLoss(player);
									break;
								} else {
									logger.info("Sinu võit!");
									game.getDealersHand().printHand(true);
									player = client.dealWin(player);
									break;
								}
							}
						}
						break;
					}
				}
			}
			logger.info("Alustage uut mängu? Teie konto seis: "+player.getCash()+" jah(1)/ei(2)");
			input = userInput.nextLine();
			if (!input.isEmpty()&& input.equals("2")) {
				System.out.println("Täname mängimast!");
				break;
			}
		}
	}
}
				
			