public class BroadcastsTime implements Comparable {
    private byte hour;
    private byte minute;

    BroadcastsTime(byte hour, byte minute) {
        this.hour = hour;
        this.minute = minute;
    }

    byte hour() {
        return hour;
    }

    byte minutes() {
        return minute;
    }

    boolean after(BroadcastsTime t) {
        int res = compareTo(t);
        return res > 0;
    }

    boolean before(BroadcastsTime t) {
        int res = compareTo(t);
        return res < 0;
    }

    boolean between(BroadcastsTime t1, BroadcastsTime t2) {
        boolean res1 = after(t1);
        boolean res2 = before(t2);
        if (res1 & t1.before(t2) & res2) {
            return true;
        } else return res1 & t1.before(t2) & res2;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof BroadcastsTime) {
            if (hour() == ((BroadcastsTime) o).hour() & minutes() == ((BroadcastsTime) o).minutes()) {
                return 0;
            } else if (hour() < ((BroadcastsTime) o).hour()) {
                return -1;
            } else if (hour() >= ((BroadcastsTime) o).hour() & minutes() < ((BroadcastsTime) o).minutes()) {
                return -1;
            } else {
                return 1;
            }
        }
        throw new RuntimeException();
    }

}
