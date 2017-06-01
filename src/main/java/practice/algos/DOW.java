package practice.algos;

public class DOW {

    //Tomohiko Sakamoto's Algorithm
    public static int dow(int y, int m, int d) {
        int t[] = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};

        if (m < 3) {
            y -= m;
        }

        return (y + y/4 - y/100 + y/400 + t[m-1] + d) % 7;
    }

    public static void main(String[] args) {
        System.out.println(DOW.dow(2017, 4, 12)); //Wednesday
        System.out.println(DOW.dow(2017, 4, 9)); //sunday
    }
}
