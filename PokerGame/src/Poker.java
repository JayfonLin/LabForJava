
public class Poker implements Comparable<Poker>{
    
    private String number;
    private String color;
    private int id;
    public Poker(String num, String color){
        this.number = num;
        this.color = color;
        setID(num);
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
        setID(number);
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    private void setID(String num){
        switch(num){
        case "A":
            id = 1;
            break;
        case "J":
            id = 11;
            break;
        case "Q":
            id = 12;
            break;
        case "K":
            id = 13;
            break;
        default:
            id = Integer.parseInt(num);
            break;
        }
    }
    public int getID(){
        return id;
    }
    @Override
    public int compareTo(Poker o) {
        Poker poker = (Poker)o;
        if (id < poker.getID()){
            return -1;
        }
        if (id > poker.getID()){
            return 1;
        }
        return 0;
    }
    
}
