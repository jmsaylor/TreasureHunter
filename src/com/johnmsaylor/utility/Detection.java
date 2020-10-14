package com.johnmsaylor.utility;

import com.johnmsaylor.player.Player;

public interface Detection {
    boolean collision(Player player, int direction, int steps, char[][] grid, char objectMarker);
}
