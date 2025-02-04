public class Bus {
    private int BusNo;
    private boolean AC;
    private int capacity;

    public Bus(int busNo, boolean AC, int capacity) {
        BusNo = busNo;
        this.AC = AC;
        this.capacity = capacity;
    }

    public boolean isAC() {
        return AC;
    }

    public int getBusNo() {
        return BusNo;
    }

    public int getCapacity() {
        return capacity;
    }
}
