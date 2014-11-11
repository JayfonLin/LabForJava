import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class PokerGame {
    static String colors[] = {"黑桃", "红心", "草花", "方块"};
    static String nums[] = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    public static void main(String[] args) {
        
        Poker[] pokers = new Poker[52];
        BufferedReader br;
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 13; j++){
                pokers[i*13+j] = new Poker(nums[j], colors[i]);
            }
        }
        int n = 2;
        do{
            System.out.println("请输入2到6之间的整数：");
            br = new BufferedReader(new InputStreamReader(System.in));
            try {
                n = Integer.parseInt(br.readLine());
                
            } catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }while  (!(n >= 2 && n <= 6));
        int nn = 52/n+1;
        Poker[][] pers = new Poker[n][nn];
        deal(pokers, n, pers);
        
        
    }
    
    static void deal(Poker[] pokers, int  n, Poker[][] pers){
        shuffle(pokers);
        for (int i = 0; i < pokers.length; i++){
            pers[i%n][i/n] = pokers[i];
        }
        System.out.println("There are "+ n +" people");
        for (int i = 0; i < n; i++){
            System.out.println("第"+(i+1)+"个人：");
            print(sort(pers[i]));
        }
        
        //print(pers);
    }
    
    static void shuffle(Poker[] pokers){
        List<Poker> list = Arrays.asList(pokers);
        Collections.shuffle(list);
    }

    static void print(Poker[][] pers){
        int len1 = pers.length;
        for (int i = 0; i < len1 && i < 4; i++){
            System.out.print(colors[i]+"：");
            int len2 = pers[i].length;
            for (int j = 0; j < len2; j++){
                if (pers[i][j] != null){
                    System.out.print(pers[i][j].getNumber()+" ");
                }
            }
            System.out.println();
        }
    }
    
    static Poker[][] sort(Poker[] pokers){
        int len = pokers.length;
        Poker[][] ps = new Poker[4][len];
        int[] counters = new int[4];
        for (int i = 0; i < len; i++){
            for (int j = 0; j < 4; j++){
                if (pokers[i] != null && pokers[i].getColor().equalsIgnoreCase(colors[j])){
                    ps[j][counters[j]++] = pokers[i];
                    break;
                }
            }
            
        }
        for (int i = 0; i < 4; i++){
            bubbleSort(ps[i]);
        }
        return ps;
    }
    
    static void bubbleSort(Poker[] pokers){
        int len = pokers.length;
        for (int i = 0; i < len ;i++){
            for (int j = i; j < len-1; j++){
                if (pokers[j] != null && pokers[j+1] != null && pokers[j].compareTo(pokers[j+1]) == 1){
                    Poker temp = pokers[j];
                    pokers[j] = pokers[j+1];
                    pokers[j+1] = temp;
                }
            }
        }
    }
}
