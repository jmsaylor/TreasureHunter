package com.johnmsaylor;

import com.johnmsaylor.console.Console;
import com.johnmsaylor.map.Map;
import com.johnmsaylor.map.Position;
import com.johnmsaylor.player.Player;
import com.johnmsaylor.utility.CollisionDetection;
import com.johnmsaylor.utility.RandomGeneration;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        var result = Map.testSinglePlayer(new int[]{2,2}, new int[][]{{1,2},{2,2}});
//        System.out.println("x: " + result[0] + " y: " + result[1]);

        var console = new Console();
        var random = new RandomGeneration();
        var detection = new CollisionDetection();

        var map = new Map(console,console,random,detection);
        map.play();
    }
}
