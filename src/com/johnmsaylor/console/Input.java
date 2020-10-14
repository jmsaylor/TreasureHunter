package com.johnmsaylor.console;

import com.johnmsaylor.player.Player;

import java.util.List;

public interface Input {
    List<Player> inputNewPlayerList();
    int inputMapSize();
    int[] inputMove();
    Player inputPlayer();
}
