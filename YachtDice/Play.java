package YachtDice;

import java.util.Scanner;

public class Play {
    public void throwDice(int playerCount,String[] playerName)
    {
        //投掷骰子
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < playerCount; i++) //每位玩家投掷骰子
        {
            System.out.println("玩家"+playerName[i]+"投掷骰子");
            int[] dice = new int[5];
            for (int j = 0; j < 5; j++) {
                dice[j] = (int) (Math.random() * 6 + 1);
            }
            System.out.println("玩家"+playerName[i]+"投掷的骰子是:"+dice[0]+dice[1]+dice[2]+dice[3]+dice[4]);

            //保留骰子
            int[] keepDice = new int[5]; //保留的骰子
            int keepDiceC; //保留的骰子数量
            int keepDiceCount = 0; //保留的骰子数量

            //是否保留骰子或保留哪些骰子
            System.out.println("选择您要保留的骰子,以\"-1\"为结尾结束保留");
            while (true)
            {
                int keepDiceNum = in.nextInt();
                if (keepDiceNum == -1) //输入-1结束保留
                {
                    break;
                }
                else
                {
                    if (keepDiceNum > 0 && keepDiceNum < 7)
                    {
                        keepDice[keepDiceCount] = dice[keepDiceNum-1];
                        keepDiceCount++;
                    }
                    else
                    {
                        System.out.println("输入不合法");
                    }
                }
            }

            //结束保留,输出结果
            System.out.println("玩家"+playerName[i]+"保留的骰子是:");
            for (int j = 0;j < keepDiceCount;j++)
            {
                System.out.print(keepDice[j] + " ");
            }
        }
    }
}
