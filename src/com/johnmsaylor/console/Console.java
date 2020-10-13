package com.johnmsaylor.console;

import com.johnmsaylor.map.Map;

import java.util.Scanner;

public class Console {

    public static void showMap(Map map) {
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

    public static int[] inputMove() {
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

}
