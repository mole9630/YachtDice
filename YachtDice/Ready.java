package YachtDice;

import java.util.Scanner;

public class Ready {
    public int playerJoin() {
        System.out.println("***** 欢迎进入快艇骰子游戏系统 *****");
        System.out.println("请输入玩家数:");
        Scanner in = new Scanner(System.in);
        int playerCount = in.nextInt();
        while (playerCount < 1)
        {
            System.out.println("游戏人数不足1人,无法开始!");
            System.out.println("请重新输入玩家数:");
            playerCount = in.nextInt();
        }

        jCount:while (playerCount == 1)
        {
            System.out.println("人数低于2人可能会带来不好的游戏体验,确定开始吗(再次输入1即确定)");
            Boolean state = true;
            if (in.nextInt() == 1)
            {
                state = false;
            }
            if (state)
            {
                System.out.println("请重新输入玩家数:");
                playerCount = in.nextInt();
            }
            else
            {
//                System.out.println("[debug]:Y");
                break jCount;
            }
        }
        System.out.println("***** 已检测到玩家数目:" + playerCount + "人,正在准备启动游戏！*****\n");
        return playerCount;
    }

    public String[] playerRename(int playerCount) {
        String[] playerName = new String[playerCount];
        for (int i=0;i<playerCount;i++)
        {
            Scanner in = new Scanner(System.in);
            System.out.println("请输入第" + (i+1) + "位玩家的昵称");
            playerName[i] = in.next();
        }
        System.out.println("***** 所有玩家的昵称键入已完成,游戏正在启动,请稍后! *****");
        return playerName;
    }

    public void playerReadyOk(String[] playerName)
    {
        System.out.println("\n*****正在载入玩家信息,请稍后 *****");
        for (int i=0;i<playerName.length;i++)
        {
            System.out.println("载入第" + i + "名玩家名成功:" + playerName[i]);
        }
        System.out.println("***** 所有玩家均载入成功,游戏准备加入 *****");
    }
}
