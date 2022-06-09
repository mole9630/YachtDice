package YachtDice;

import java.util.Scanner;

public class Play {
    public void throwDice(int playerCount, String[] playerName) {
        int surplusFrequency = 3;//剩余投掷次数

        //投掷骰子
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < playerCount; i++) //每位玩家投掷骰子
        {
            System.out.println("***** 玩家\"" + playerName[i] + "\"第1次投掷骰子,剩余次数3次,请键入任意内容并按回车投掷骰子 *****");
            in.next();
            int[] dice = new int[5]; //每次投掷5个骰子

            for (int j = 0; j < 5; j++) {
                dice[j] = (int) (Math.random() * 6 + 1);
            }
            surplusFrequency--;
            System.out.println("玩家" + playerName[i] + "投掷的骰子是:" + dice[0] + " | " + dice[1] + " | " + dice[2] + " | " + dice[3] + " | " + dice[4]);

            //保留骰子
            int[] keepDice = new int[5]; //保留的骰子
            int keepDiceCount = 0; //保留的骰子数量

            //是否保留骰子或保留哪些骰子
            System.out.println("选择您要保留的骰子,以\"-1\"为结尾结束保留");
            while (true) {
                int keepDiceNum = in.nextInt();
                if (keepDiceNum == -1) //输入-1结束保留
                {
                    break;
                } else {
                    if (keepDiceNum > 0 && keepDiceNum < 7) {
                        keepDice[keepDiceCount] = dice[keepDiceNum - 1];
                        keepDiceCount++;
                    } else {
                        System.out.println("输入不合法");
                    }
                }
            }

            //结束保留,输出结果
            System.out.println("***** 玩家" + playerName[i] + "保留的骰子是: *****");
            for (int j = 0; j < keepDiceCount; j++) {
                System.out.print(keepDice[j] + " ");
            }
            System.out.println();

            if (keepDice[4] != 0) //判断是否保留完成
            {
                System.out.println("*****" + playerName[i] + "已保留完成所有骰子 *****\n\n");
                break;
            }

            //第二次投掷
            System.out.println("\n***** 玩家\"" + playerName[i] + "\"第2次投掷骰子,剩余次数1次,请键入任意内容并按回车投掷骰子 *****");
            in.next();
            int noThrowDice = 5 - keepDiceCount; //未保留的骰子数量
            dice = new int[noThrowDice]; //每次投掷noThrowDice个骰子

            for (int j = 0; j < noThrowDice; j++) {
                dice[j] = (int) (Math.random() * 6 + 1);
            }
            surplusFrequency--;
            System.out.print("玩家" + playerName[i] + "投掷的骰子是:");
            for (int j = 0; j < noThrowDice; j++) {
                System.out.print(dice[j] + " ");
            }
            System.out.println();

            //是否保留骰子或保留哪些骰子
            System.out.println("选择您要保留的骰子,以\"-1\"为结尾结束保留");
            while (true) {
                int keepDiceNum = in.nextInt();
                if (keepDiceNum == -1) //输入-1结束保留
                {
                    break;
                } else {
                    if (keepDiceNum > 0 && keepDiceNum < 7) {
                        keepDice[keepDiceCount] = dice[keepDiceNum - 1];
                        keepDiceCount++;
                    } else {
                        System.out.println("输入不合法");
                    }
                }

                //结束保留,输出结果
                System.out.println("***** 玩家" + playerName[i] + "保留的骰子是: *****");
                for (int j = 0; j < keepDiceCount; j++) {
                    System.out.print(keepDice[j] + " ");
                }
                System.out.println();

                if (keepDice[4] != 0) //判断是否保留完成
                {
                    System.out.println("*****" + playerName[i] + "已保留完成所有骰子 *****\n\n");
                    break;
                }
            }

            //第三次投掷
            System.out.println("\n***** 玩家\"" + playerName[i] + "\"第3次投掷骰子,剩余次数0次,请键入任意内容并按回车投掷骰子 *****");
            in.next();
            noThrowDice = 5 - keepDiceCount; //未保留的骰子数量
            dice = new int[noThrowDice]; //每次投掷noThrowDice个骰子

            for (int j = 0; j < noThrowDice; j++) {
                dice[j] = (int) (Math.random() * 6 + 1);
            }
            surplusFrequency--;
            System.out.print("玩家" + playerName[i] + "投掷的骰子是:");
            for (int j = 0; j < noThrowDice; j++) {
                System.out.print(dice[j] + " ");
            }
            System.out.println();

            //强制保留剩余骰子
            System.out.println("\n***** 您最终的骰子为 *****");
            for (int j = 0; j < noThrowDice; j++) {
                keepDice[keepDiceCount] = dice[j];
                keepDiceCount++;
            }

            //结束保留,输出结果
            System.out.println("***** 玩家" + playerName[i] + "保留的骰子是: *****");
            System.out.println("玩家" + playerName[i] + "投掷的骰子是:" + keepDice[0] + " | " + keepDice[1] + " | " + keepDice[2] + " | " + keepDice[3] + " | " + keepDice[4]);
            System.out.println();

            if (keepDice[4] != 0) //判断是否保留完成
            {
                System.out.println("*****" + playerName[i] + "已保留完成所有骰子 *****\n");
                break;
            }
            System.out.println("[debug]投掷阶段已完成");
        }
    }
}