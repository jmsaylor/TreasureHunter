package com.johnmsaylor.map;

import com.johnmsaylor.player.Player;
import com.johnmsaylor.utility.CollisionDetection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Map {
    public int mapSize;
    public Queue<Player> playerQueue = new LinkedList<>();
    public Position treasurePosition;
    public List<Position> obstacles;
    public Player currentPlayer;
    public MapGrid mapGrid;

    public Map(List<Player> players, Position treasurePosition, List<Position> obstacles, int size) {
        for (var player : players){
            this.playerQueue.add(player);
        }
        this.treasurePosition = treasurePosition;
        this.currentPlayer = this.playerQueue.poll();
        this.obstacles = obstacles;
        this.mapSize = size;
        this.mapGrid = new MapGrid(obstacles,treasurePosition,mapSize);
    }

    public void processMove(Player player, int direction, int steps){
        if (CollisionDetection.detect(player, direction, steps, mapGrid.getMapGrid(), 'X')){
            System.out.println("Obstacle Collision, you must restart.");
        }
        if (CollisionDetection.detect(player, direction, steps, mapGrid.getMapGrid(), 'T')) {
            System.out.println("YOU FOUND THE TREASURE!");
        }
        movePlayer(player, direction, steps);
    }

    public void movePlayer(int direction, int steps) {
        switch (direction)
        {
            case 0:
                currentPlayer.position.setY(currentPlayer.position.getY() - steps);
                break;
            case 1:
                currentPlayer.position.setX(currentPlayer.position.getX() + steps);
                break;
            case 2:
                currentPlayer.position.setY(currentPlayer.position.getY() + steps);
                break;
            case 3:
                currentPlayer.position.setX(currentPlayer.position.getX() - steps);
                break;
            default:
        }
    }

    public void movePlayer(Player player, int direction, int steps) {
        switch (direction)
        {
            case 0:
                player.position.setY(player.position.getY() - steps);
                break;
            case 1:
                player.position.setX(player.position.getX() + steps);
                break;
            case 2:
                player.position.setY(player.position.getY() + steps);
                break;
            case 3:
                player.position.setX(player.position.getX() - steps);
                break;
            default:
        }
    }

    public void processMoves(Player player, int[][] moves) {
        for (int i = 0; i < moves.length; i++) {
            processMove(player, moves[i][0], moves[i][1]);
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
        return false;
//        return collisionDetection(direction, steps, (List<Position>) treasurePosition);
//        steps = (direction == 0 || direction == 3) ? steps * -1 : steps;
//
//        if (direction == 0 || direction == 2 && player.position.getX() == treasurePosition.getX()) {
//            return player.position.getY() < treasurePosition.getY() && treasurePosition.getY() < player.position.getY() + steps;
//        } else if(direction == 1 || direction == 3 && player.position.getY() == treasurePosition.getY()) {
//            return player.position.getX() < treasurePosition.getX() && treasurePosition.getX() < player.position.getX() + steps;
//        } else {
//            return false;
//        }
    }

    public List<Position> getObstacles() {
        return obstacles;
    }
}
