package YachtDice;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //游戏准备阶段
        Ready rd = new Ready();
        int playerCount = rd.playerJoin(); //准备开始游戏的操作 playerCount:玩家数
        String[] playerName = rd.playerRename(playerCount); //各玩家命名 playerName:玩家名数组
        rd.playerReadyOk(playerName); //载入玩家信息,游戏准备工作完成

        //游戏开始阶段
        Play play = new Play();
        play.throwDice(playerCount, playerName); //投掷骰子

    }
}