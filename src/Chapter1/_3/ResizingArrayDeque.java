package Chapter1._3;


public class ResizingArrayDeque<Item> {

    private Item[] arr;
    private int first;
    private int last;
    private int N;

    public ResizingArrayDeque(int n) {
        arr = (Item[]) new Object[n];
        first = last = 0;
        N = 0;
    }

    public boolean isEmpty() {return N == 0;}
    public int size() {return N;}
    public void resizeArr(int n) {
        Item[] newArr = (Item[]) new Object[n];

        for (int i = first,j = 0; j < N; j++) {
            newArr[j] = arr[i];
            i = (i + 1) % arr.length;
        }
        arr = newArr;
        first = 0;
        last = N - 1;
    }

    public void pushLeft(Item item) {
        if (item == null) return;

        if (N == arr.length) {
            resizeArr(arr.length * 2);
        }

        if (N == 0) {
           arr[first] = item;
        } else {
            int index = first - 1;
            if (index < 0) index += arr.length;
            arr[index] = item;
            first = index;
        }
        N++;
    }

    public void pushRight(Item item) {
        if (item == null) return;

        if (N == arr.length) {
            resizeArr(arr.length * 2);
        }

        if (N == 0) {
            arr[last] = item;
        } else {
            int index = (last + 1) % arr.length;
            arr[index] = item;
            last = index;
        }
        N++;
    }

    public Item popLeft() {
        if (N == 0)
            throw new NullPointerException("Empty List");

        if (N == arr.length / 4) resizeArr(arr.length / 2);

        Item res = arr[first];
        if (N == 1) {
            first = last = 0;
        } else {
            first = (first + 1) % arr.length;
        }
        N--;
        return res;
    }

    public Item popRight() {
        if (N == 0)
            throw new NullPointerException("Empty List");

        if (N == arr.length / 4) resizeArr(arr.length / 2);
        Item res = arr[last];

        if (N == 1) {
            first = last = 0;
        } else {
            int index = last - 1;
            index = index < 0 ? index + arr.length : index;
            last = index;
        }
        N--;
        return res;
    }

    public static void main(String[] args) {
        ResizingArrayDeque<String> queue = new ResizingArrayDeque<>(1);
        queue.pushLeft("1");
        queue.pushLeft("1");
        queue.pushLeft("1");
        queue.pushLeft("1");
        queue.pushLeft("1");
        queue.pushLeft("1");
        queue.pushRight("2");
        System.out.println(queue.popLeft());
        System.out.println(queue.popRight());
    }
}

