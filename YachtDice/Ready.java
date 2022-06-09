package YachtDice;

import java.util.Scanner;

public class Ready {
    public int playerJoin() {
        System.out.println("************************* 快艇骰子 ************************");
        System.out.println("*               下面为您介绍快艇骰子的简易规则:               *");
        System.out.println("*            一点: 分数得显示点数为一的骰子的点数加起来。        *");
        System.out.println("*           二点: 分数得显示点数为二的骰子的点数加起来。         *");
        System.out.println("*           三点: 分数得显示点数为三的骰子的点数加起来。         *");
        System.out.println("*          四点: 分数得显示点数为四的骰子的点数加起来。          *");
        System.out.println("*           五点: 分数得显示点数为五的骰子的点数加起来。         *");
        System.out.println("*          六点: 分数得显示点数为六的骰子的点数加起来。          *");
        System.out.println("*               全选：将五个骰子点数和作为所得分数。            *");
        System.out.println("*  四骰同花: 为四个点数相同骰子的组合，将五个骰子点数和作为所得分数。 *");
        System.out.println("* 葫芦：为三个点数相同骰子和另外两个点数相同骰子的组合， 分数得25分。 *");
        System.out.println("*       小顺：骰子点数排列为1234、2345、3456者，分数得30分。     *");
        System.out.println("*         大顺：骰子点数排列为12345、23456者，分数得40分。       *");
        System.out.println("*        快艇：为五个点数相同骰子的组合， 第一次分数得50分。       *");
        System.out.println("***********************************************************\n");
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
            System.out.println("载入第" + i+1 + "名玩家名成功:" + playerName[i]);
        }
        System.out.println("***** 所有玩家均载入成功,游戏准备加入 *****\n");
    }
}