package com.johnmsaylor;

import com.johnmsaylor.console.Console;
import com.johnmsaylor.map.Map;
import com.johnmsaylor.player.Player;
import com.johnmsaylor.utility.CollisionDetection;
import com.johnmsaylor.utility.RandomGeneration;

public class Main {

    public static void main(String[] args) {
        var console = new Console();
        var random = new RandomGeneration();
        var detection = new CollisionDetection();

        //Experiment
//        var map = new Map(console,console,random,detection); // <- Does params through user input
//        map.play();

        //Challenge
        int mapSize = 5;
        Player player = new Player("Franklin", random.randomPlayerPosition(mapSize));
        var map = new Map(player,random.randomTreasure(mapSize),random.randomObstacles(2,mapSize),mapSize);

        map.setInput(console);
        map.setOutput(console);
        map.setDetection(detection);
        map.setRandom(random);

        var result = map.processMoves(new int[]{2,2}, new int[][]{{1,2},{2,2}}, true);
        System.out.println("x: " + result[0] + " y: " + result[1]);

    }
}
