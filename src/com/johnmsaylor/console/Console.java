package com.johnmsaylor.console;

import com.johnmsaylor.map.Map;
import com.johnmsaylor.map.Position;
import com.johnmsaylor.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console implements Input, Output{
    private Scanner scanner = new Scanner(System.in);

    public void showMap(Map map) {
        char[][] mapGrid = map.mapGrid.getMapGrid();
        for (var player : map.getPlayers()) {
            mapGrid[player.position.getY()][player.position.getX()] = player.getName().charAt(0);
        }


        for (int y = 0; y < mapGrid.length; y++) {
            for (int x = 0; x < mapGrid.length; x++) {
                System.out.print(mapGrid[y][x] >= 'A' ? " " + mapGrid[y][x] + " " : " o ");
                }
            System.out.println();
            }
        }

    public int[] inputMove() {
        int[] result = new int[2];
        int direction;
        int steps;
        Scanner scanner = new Scanner(System.in);
        System.out.println("| 0 - N | 1 - E | 2 - S | 3 - W | Type direction, then number of steps");
        String input = scanner.next();
        direction = Integer.parseInt(input.substring(0,1));
        steps = Integer.parseInt(input.substring(1).strip());
        result[0] = direction;
        result[1] = steps;
        return result;
    }

    public List<Player> inputNewPlayerList() {
        int count = 1;
        List<Player> playerList = new ArrayList<>();
        do {
            System.out.println("Enter Player" + count + " name");
            playerList.add(new Player(scanner.next()));
            System.out.println("Add another player? Press y and Enter.");
            count++;
        } while(scanner.next().matches("y"));
        return playerList;
    }

    public Player inputPlayer() {
        System.out.println("Enter name");
        return new Player(scanner.next());
    }

    @Override
    public int inputMapSize() {
        System.out.println("How big would you like the map to be?");
        return scanner.nextInt();
    }

}
