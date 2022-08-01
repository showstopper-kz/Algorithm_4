package Chapter_2._1_1;

public class Date implements Comparable<Date> {
    private final int day;
    private final int month;
    private final int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Date o) {
        if (this.year > o.year) return +1;
        if (this.year < o.year) return -1;
        if (this.month > o.month) return +1;
        if (this.month < o.month) return -1;
        if (this.day > o.day) return +1;
        if (this.day < o.day) return -1;
        return 0;
    }

    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }
}
