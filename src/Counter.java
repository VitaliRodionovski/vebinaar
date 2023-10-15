class Counter {
    public int count;
    public synchronized void increment() {
        count++;
    }
    public int getValue() {
        return count;
    }
}


