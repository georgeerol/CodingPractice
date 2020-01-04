package fundamental.datastructures.stackandqueues;

/**
 * Implement Two Stacks using one Array
 * Created by George Fouche on 12/17/19.
 */
public class TwoStacks<V> {
    private int maxSize;
    private int top1, top2;
    private V[] array;


    @SuppressWarnings("unchecked")
    public TwoStacks(int maxSize) {
        this.maxSize = maxSize;
        this.top1 = -1;
        this.top2 = maxSize;
        this.array = (V[]) new Object[maxSize];
    }


    /**
     * Insert at top of 1st stack
     *
     * @param value
     */
    public void push1(V value) {
        if (top1 < top2 - 1) {
            array[++top1] = value;
        }
    }

    /**
     * Insert at top of second stack
     *
     * @param value
     */
    public void push2(V value) {
        if (top1 < top2 - 1) {
            array[--top2] = value;
        }
    }

    /**
     * Remove and return value from top of first stack
     *
     * @return
     */
    public V pop1() {
        if (top1 > -1) {
            return array[top1--];
        }
        return null;
    }

    public V pop2() {
        if (top2 < maxSize) {
            return array[top2];
        }
        return null;
    }


    public static void main(String[] args) {
        TwoStacks<Integer> ts = new TwoStacks<>(5);
        ts.push1(11);
        ts.push2(1);
        System.out.println(ts.pop1());
        System.out.println(ts.pop2());
    }
}
