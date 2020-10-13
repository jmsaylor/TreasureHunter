package com.johnmsaylor.map;

import com.johnmsaylor.console.Console;
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

    public Map(Player player, Position treasurePosition, List<Position> obstacles, int size) {
        this.currentPlayer = player;
        this.treasurePosition = treasurePosition;
        this.obstacles = obstacles;
        this.mapSize = size;
        this.mapGrid = new MapGrid(obstacles,treasurePosition,mapSize);
    }

    public Map(Player player, Position treasurePosition, int size) {
        this.currentPlayer = player;
        this.treasurePosition = treasurePosition;
        this.mapSize = size;
        this.mapGrid = new MapGrid(treasurePosition,mapSize);
    }

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
            System.exit(1);
        }
        if (CollisionDetection.detect(player, direction, steps, mapGrid.getMapGrid(), 'T')) {
            System.out.println("YOU FOUND THE TREASURE!" + new String(Character.toChars(0x1F3C4)));
            System.exit(1);
        }
        movePlayer(player, direction, steps);
    }

    public void nextPlayer() {
        playerQueue.add(currentPlayer);
        currentPlayer = playerQueue.poll();
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

    public List<Position> getObstacles() {
        return obstacles;
    }

    public static void testSinglePlayer(int[] startingPosition, int[][] moves) {
        int xCoord = startingPosition[0];
        int yCoord = startingPosition[1];
        var map = new Map(new Player("", new Position(xCoord, yCoord)), new Position(4,4), 5);
        map.processMoves(map.currentPlayer, moves);
        Console.showMap(map);
    }
}
