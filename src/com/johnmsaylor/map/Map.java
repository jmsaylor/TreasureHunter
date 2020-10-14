package com.johnmsaylor.map;

import com.johnmsaylor.console.Input;
import com.johnmsaylor.console.Output;
import com.johnmsaylor.player.Player;
import com.johnmsaylor.utility.Detection;
import com.johnmsaylor.utility.Random;

import java.util.*;

public class Map {
    private Input input;
    private Output output;
    private Random random;
    private Detection detection;
    public int mapSize;
    public Deque<Player> playerQueue = new LinkedList<>();
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

    public Map(List<Player> players, Position treasurePosition, List<Position> obstacles, int mapSize) {
        for (var player : players){
            this.playerQueue.add(player);
        }
        this.treasurePosition = treasurePosition;
        this.currentPlayer = this.playerQueue.poll();
        this.obstacles = obstacles;
        this.mapSize = mapSize;
        this.mapGrid = new MapGrid(obstacles,treasurePosition, this.mapSize);
    }

    public Map(Input input, Output output, Random random, Detection detection) {
        this.input = input;
        this.output = output;
        this.random = random;
        this.detection = detection;
        this.mapSize = input.inputMapSize();
        this.currentPlayer = input.inputPlayer();
        this.obstacles = random.randomObstacles(2,mapSize);
        this.treasurePosition = random.randomTreasure(mapSize);
        this.mapGrid = new MapGrid(obstacles,treasurePosition, mapSize);
        output.showMap(this);
    }

    public void processMove(Player player, int direction, int steps){
        if (detection.collision(player, direction, steps, mapGrid.getMapGrid(), 'X')){
            System.out.println("Obstacle Collision");
//            System.exit(1);
        }
        if (detection.collision(player, direction, steps, mapGrid.getMapGrid(), 'T')) {
            System.out.println("YOU FOUND THE TREASURE!" + new String(Character.toChars(0x1F3C4)));
//            System.exit(1);
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

    public void processMoves(Player player, int[][] moves, boolean isVisualized) {
        for (int i = 0; i < moves.length; i++) {
            processMove(player, moves[i][0], moves[i][1]);
            if (isVisualized) {
                output.showMap(this);
                System.out.println("--------------------");
            }
        }
    }

    public int[] processMoves(int[] startPosition, int[][] moves, boolean isVisualized) {
        playerQueue.add(currentPlayer);
        currentPlayer = new Player("Test", new Position(startPosition[0], startPosition[1]));
        processMoves(currentPlayer, moves,isVisualized);
        int [] endPosition = {currentPlayer.position.getX(), currentPlayer.position.getY()};
        currentPlayer = playerQueue.pollLast();
        return endPosition;
    }

    public void play(){
        Scanner scanner = new Scanner(System.in);
        do {
            int[] move = input.inputMove();
            processMove(currentPlayer, move[0], move[1]);
            output.showMap(this);
//            System.out.println("Enter c to continue");
        } while (!scanner.next().matches("q"));
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

    public void setRandom(Random random) {
        this.random = random;
    }

    public void setDetection(Detection detection) {
        this.detection = detection;
    }

    public void setInput(Input input) {
        this.input = input;
    }

    public void setOutput(Output output) {
        this.output = output;
    }
}
