import java.util.Comparator;

class Comparate implements Comparator<Program> {

    public int compare(Program o1, Program o2) {
        if (o1.time.hour() == o2.time.hour() & o1.time.minutes() == o2.time.minutes()) {
            return 0;
        } else if (o1.time.hour() < o2.time.hour()) {
            return -1;
        } else if (o1.time.hour() >= o2.time.hour() & o1.time.minutes() < o2.time.minutes()) {
            return -1;
        } else {
            return 1;
        }
    }
}
