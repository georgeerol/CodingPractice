package fundamental.datastructures.f.hashtable;

/**
 * Created by George Fouche on 1/9/20.
 */
public class HashTable {
    private static final int TABLE_SIZE = 100;
    private Record[] tableData = new Record[TABLE_SIZE];

    private void put(Object key, Object value) {
        int keyCode = key.hashCode();
        int step = 0;
        int slot = hash(keyCode, step);
        while (!isEmpty(slot)) {
            slot = hash(keyCode, ++step);
        }
        tableData[slot] = new Record(key, value);
    }

    private boolean keyExists(Object key) {
        int keyCode = key.hashCode();
        int step = 0;
        int slot = hash(keyCode, step);
        while (tableData[slot] != null && !tableData[slot].getKey().equals(key))
            slot = hash(keyCode, ++step);
        if (tableData[slot] != null) return true;
        return false;
    }

    private boolean isEmpty(int slot) {
        return tableData[slot] == null;
    }

    private int hash(int key, int step) {
        if (step == 0)
            return key % TABLE_SIZE;
        return (key % TABLE_SIZE + step * step) % TABLE_SIZE;
    }


    private Object get(Object key) {
        int keyCode = key.hashCode();
        int step = 0;
        int slot = hash(keyCode, step);
        while (tableData[slot] != null && !tableData[slot].getKey().equals(key)) {
            slot = hash(keyCode, ++step);
        }
        if (tableData[slot] != null) return tableData[slot].getData();
        return null;
    }



private class Record {
    Object key;
    Object data;

    public Record(Object key, Object data) {
        this.key = key;
        this.data = data;
    }

    public Object getKey() {
        return this.key;
    }

    public Object getData() {
        return this.data;
    }

}

    public static void main(String[] args) {
        HashTable ht = new HashTable();
        ht.put("4", 40);
        ht.put("6", 60);
        ht.put("7", 70);
        ht.put("8", 80);

        System.out.println(ht.keyExists("4"));
        System.out.println(ht.get("4"));
    }


}
