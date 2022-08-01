package Chapter1._2;

import Chapter1._3.Queue;
import edu.princeton.cs.algs4.In;

import java.util.Scanner;

public class Date {
    private int year;
    private int month;
    private int day;

    private int[] monthDayCounts = {31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private String[] weekDay = {"Sat", "Sun", "Mon", "Tue", "Wed", "Thr", "Fri"};
    public Date(int year, int month, int day) throws Exception{
        setYear(year);

        if ((year - 2000) % 4 == 0) monthDayCounts[1] = 29;
        else monthDayCounts[1] = 28;

        setMonth(month);
        setDay(day);
    }

    public Date(String date) throws Exception {
        String res[] = date.split("/");
        setYear(Integer.parseInt(res[0]));
        setMonth(Integer.parseInt(res[1]));
        setDay(Integer.parseInt(res[2]));
    }
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }


    public void setMonth(int month) throws Exception{
        if (1 <= month && month <= 12)
            this.month = month;
        else throw new Exception("month < 1 or month > 12");
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) throws Exception{
        if (day >= 1 && day <= monthDayCounts[month - 1])
            this.day = day;
        else throw new Exception("day is invalid");
    }

    public String dayOfTheWeek() {
        int i = year - 2000;
        int days = 0;

        for (int j = 0; j < i; j++) {
            days += i%4 == 0 ? 366 : 365;
        }

        for (int j = 2; j <= month; j++)
            days += monthDayCounts[j-1];

        days += day - 1;

        return weekDay[days % 7];
    }

    public static Date[] readDates(Scanner sc) throws Exception {
        Queue<int[]> queue = new Queue<>();
        while (!sc.hasNext("quit")) {
            String s = sc.next();
            String[] inputArr = s.split("/");
            if (inputArr.length != 3) throw new Exception("Invalid input date format");
            queue.enqueue(new int[]{Integer.parseInt(inputArr[0]), Integer.parseInt(inputArr[1]), Integer.parseInt(inputArr[2])});
        }

        Date[] dateArr = new Date[queue.size()];
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int[] dateArg = queue.dequeue();
            dateArr[i] = new Date(dateArg[0], dateArg[1], dateArg[2]);
        }
        return dateArr;
    }
    public boolean equals(Date obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        return (getYear() == obj.getYear())
                && (getDay() == obj.getDay())
                && (getMonth() == obj.getMonth());
    }

    @Override
    public String toString() {
        return getYear()+"-"+getMonth()+"-"+getDay();
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Date[] dateArr = Date.readDates(sc);
        for (Date date : dateArr) {
            System.out.println(date.toString());
        }
    }
}
