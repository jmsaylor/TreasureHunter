package com.johnmsaylor.map;

import com.johnmsaylor.player.Player;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Map {
    public int mapSize;
    public Queue<Player> playerQueue = new LinkedList<>();
    public Position treasurePosition;
    public Player currentPlayer;

    public Map(List<Player> players, Position treasurePosition, int size) {
        for (var player : players){
            this.playerQueue.add(player);
        }
        this.treasurePosition = treasurePosition;
        this.currentPlayer = this.playerQueue.poll();
        this.mapSize = size;
    }

    public void processMove(int direction, int steps){
        //other logic
        if (didFindTreasure(currentPlayer, direction, steps)) {
            System.out.println("YOU FOUND THE TREASURE!");
        }
        movePlayer(direction, steps);
    }

    public void movePlayer(int direction, int steps) {
        switch (direction)
        {
            case 0:
                currentPlayer.position.setX(currentPlayer.position.getX() - steps);
                break;
            case 1:
                currentPlayer.position.setY(currentPlayer.position.getY() + steps);
                break;
            case 2:
                currentPlayer.position.setX(currentPlayer.position.getX() + steps);
                break;
            case 3:
                currentPlayer.position.setX(currentPlayer.position.getX() - steps);
                break;
            default:
        }
    }

    public void processMoves(int[][] moves) {
        for (int i = 0; i < moves.length; i++) {
            processMove(moves[i][0], moves[i][1]);
        }
    }

    public List<Player> getPlayers() {
        var temp = new ArrayList<Player>();
        for (var player : playerQueue) {
            temp.add(player);
        }
        temp.add(currentPlayer);
        return temp;
    }

    private boolean didFindTreasure(Player player, int direction, int steps) {
        steps = (direction == 0 || direction == 3) ? steps * -1 : steps;

        if (direction == 0 || direction == 2 && player.position.getX() == treasurePosition.getX()) {
            return player.position.getY() < treasurePosition.getY() && treasurePosition.getY() < player.position.getY() + steps;
        } else if(direction == 1 || direction == 3 && player.position.getY() == treasurePosition.getY()) {
            return player.position.getX() < treasurePosition.getX() && treasurePosition.getX() < player.position.getX() + steps;
        } else {
            return false;
        }
        

    }
}
