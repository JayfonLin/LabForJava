package com.learning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class GuessNumberGame {
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader strin;
        
        boolean choice = true;
        
        int gameNum = 0;
        int win = 0;
        int lose = 0;
        while (choice){
            Random random = new Random();
            int n = random.nextInt(10);
            boolean success = false;
            gameNum++;
            int count = 0;
            while (count++ < 3){
                strin = new BufferedReader(new InputStreamReader(System.in));
                int un = Integer.parseInt(strin.readLine());
                if (un > n){
                    System.out.println("你猜的数字太大了");
                }else if (un < n){
                    System.out.println("你猜的数字太小了");
                }else{
                    System.out.println("恭喜你，猜对了");
                    success = true;
                    win++;
                    break;
                }
            }
            if (!success){
                System.out.println("游戏失败");
                lose++;
            }
            System.out.println("是否继续新的游戏？y or n");
            strin = new BufferedReader(new InputStreamReader(System.in));
            choice = strin.readLine().equalsIgnoreCase("y");
            if (!choice){
                break;
            }
        }
        System.out.println("你共进行了"+gameNum+"次游戏，成功"+win+"次，失败"+lose+"次");
    }
}
