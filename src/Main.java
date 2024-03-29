import java.util.Scanner;

import global.Variables;
import design.*;
import mechanics.*;

public class Main {

        public static void main(String[] args) throws InterruptedException {

                Scanner in = new Scanner(System.in);

                ConsoleColor Color = new ConsoleColor();
                Screen Screen = new Screen();

                Variables Global = new Variables();
                Deck Deck = new Deck();
                Hand Hand = new Hand(Deck);
                GameProgression Progression = new GameProgression();

                int currentStage = 0, userChoice = 0;

                Enemy[] Enemy = new Enemy[5];

                Enemy[0] = new Enemy("Morto-vivo", 5, 5); // Undead
                Enemy[1] = new Enemy("Espectro da Escuridão", 30, 10); // Darkwraith
                Enemy[2] = new Enemy("Cavaleiro Legionário", 60, 20); // Legion Knight
                Enemy[3] = new Enemy("Sentinela Real", 100, 30); // Royal Sentinel
                Enemy[4] = new Enemy("Alma das Cinzas", 200, 40); // Soul of Cinder

                Screen.gameStartup();
                Progression.welcomeToALonelyPlace(Color);
                Progression.gameStart(Color);
                Progression.cardsHaveAppeared(Color);

                // Loop principal do jogo
                while (currentStage < Enemy.length) {
                        // Percorre os n inimigos do jogo
                        for (int i = 0; i < Enemy.length; i++) {
                                Global.showGlobalData();

                                System.out.println(
                                                "\n<<< Você se encontra atualmente no " + (currentStage + 1)
                                                                + "° Andar >>>");
                                Thread.sleep(3000);

                                if (Enemy[i].equals(Enemy[0])) {
                                        Progression.enemyHasBeenFound(Color);
                                }

                                System.out.println("\nVocê colidiu com o <" + Enemy[i].getName()
                                                + "> e a batalha foi iniciada!");

                                System.out.println(Color.setColor("red",
                                                "\nVida do <" + Enemy[i].getName() + ">: " + Enemy[i].getHealth()));
                                System.out.println(Color.setColor("green",
                                                "Poder do <" + Enemy[i].getName() + ">: " + Enemy[i].getDamage()));

                                Thread.sleep(3000);

                                // Enquanto o inimigo n possuir vida, realiza o loop
                                while (Enemy[i].getHealth() > 0) {
                                        // Enquanto o jogador não utilizar suas 3 cartas, realiza o loop
                                        while (Global.getUsedCards() < 3) {
                                                System.out.println(
                                                                "\nVocê possui as seguintes cartas em suas mãos: \n"
                                                                                + Hand);
                                                // Validação de cartas com índices inválidos
                                                do {
                                                        System.out.print("\nEscolha a carta que deseja utilizar: ");
                                                        userChoice = in.nextInt();

                                                        if (userChoice < 0 || userChoice > Hand.currentHand() - 1) {
                                                                System.out.println(
                                                                                "\n[!] Você tentou utilizar uma carta inválida, mas algo o impediu.");
                                                        }
                                                } while (userChoice < 0 || userChoice > Hand.currentHand() - 1);

                                                System.out.println("\nVocê utilizou a carta "
                                                                + Hand.chosenCard(userChoice).getName() + "!");
                                                System.out.println("\n" + Hand.chosenCard(userChoice).getDescription());

                                                Hand.chosenCard(userChoice).useCard(userChoice, Global);
                                                Hand.useCard(userChoice, Global);

                                                Thread.sleep(1000);
                                        }

                                        Global.showGlobalData();
                                        Enemy[i].setHealth(Enemy[i].getHealth() - Global.getFinalDamage());

                                        // Se a vida do inimigo for menor ou igual a 0, finaliza o andar atual
                                        if (Enemy[i].getHealth() <= 0) {
                                                System.out.println(
                                                                "\n[!] Você utilizou todas as cartas possíveis e seus cavaleiros golpearam o inimigo.");

                                                Thread.sleep(3000);

                                                System.out.println("\n[!] O <" + Enemy[i].getName() + "> sofreu ["
                                                                + Global.getFinalDamage() + "] de dano!");

                                                Thread.sleep(3000);

                                                if (Enemy[4].getHealth() <= 0) {
                                                        Global.setScore(Global.getScore()
                                                                        + Global.getFinalDamage() * 2);
                                                        Progression.victoryAchieved(Global, Color);
                                                        Screen.gameCredits();

                                                        System.exit(0);
                                                } else {
                                                        if (currentStage == 0) {
                                                                Progression.enemyDestroyed(Hand, Deck, Color);
                                                        } else {
                                                                System.out.println(Color.setColor("red",
                                                                                "\nO espírito sombrio foi destruído!"));

                                                                Thread.sleep(3000);

                                                                System.out.println("\n[...] Carregando novo andar.");

                                                                Thread.sleep(2000);
                                                        }
                                                        currentStage++;
                                                }

                                                Hand.fillHand(Deck);
                                        } else {
                                                System.out.println(
                                                                "\n[!] Você utilizou todas as cartas possíveis e seus cavaleiros golpearam o inimigo. ");

                                                Thread.sleep(3000);

                                                System.out.println("\n[!] O <" + Enemy[i].getName() + "> sofreu [" +
                                                                Global.getFinalDamage()
                                                                + "] de dano, mas ainda possui [" + Enemy[i].getHealth()
                                                                + "] de vida!");

                                                Thread.sleep(3000);

                                                Global.setPlayerHealth(Global.getPlayerHealth() - Enemy[i].getDamage());

                                                System.out.println(Color.setColor("yellow",
                                                                "\n[!] O <" + Enemy[i].getName()
                                                                                + "> o ataca, causando ["
                                                                                + Enemy[i].getDamage()
                                                                                + "] de dano ao jogador!"));

                                                Thread.sleep(3000);

                                                if (Global.getPlayerHealth() > 0) {
                                                        System.out.println(Color.setColor("red",
                                                                        "\nVida atual: " + Global.getPlayerHealth()));
                                                } else if (Global.getPlayerHealth() <= 0) {
                                                        Progression.gameOver(Global, Color);
                                                        System.exit(0);
                                                }

                                                Hand.fillHand(Deck);
                                        }

                                        // Reinicia a quantidade de cartas usadas pelo jogador
                                        Global.setUsedCards(0);
                                }

                                Global.setScore(Global.getScore() + Global.getFinalDamage() * 2);

                                System.out.println(Color.setColor("green", "\nPontuação atual: " + Global.getScore()));

                                Thread.sleep(3000);

                                if (currentStage == 1) {
                                        Progression.newCardsHaveAppeared(Color);
                                }
                        }
                }
                // Fecha o scanner ao final do jogo.
                in.close();
        }
}