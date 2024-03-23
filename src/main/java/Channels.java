import java.util.*;

public class Channels {
    private Map<String, List<Program>> channels = new HashMap<>();
    private List<Program> programs = new ArrayList<>();
    List<Program> lst = new ArrayList<>();

    public void addChannels(Program program) {
        if (channels.containsKey(program.channel)) {
            lst = channels.get(program.channel);
        }
        lst.add(program);
        programs.add(program);
        channels.put(program.channel, lst);
    }

    public void showAllPrograms() {
        lst.sort(new Comparate());
        for (Program program : programs) {
            System.out.println(program);
        }
    }

    public void showProgramsByCurrentTime(BroadcastsTime time) {
        for (Program program : programs) {
            if (program.time.compareTo(time) == 0) {
                System.out.println(program.channel + " " + program.title + " " + program.time.hour() + ":" + program.time.minutes());
            }
        }
    }

    public void showProgramsByTitle(String title) {
        for (Program program : programs) {
            if (program.title.equals(title)) {
                System.out.println(program.channel + " " + program.title + " " + program.time.hour() + ":" + program.time.minutes());
            }
        }
    }

    public void showProgramsByChannelCurrentTime(String channel, BroadcastsTime time) {
        List<Program> lst = channels.get(channel);
        for (Program program : lst) {
            if (program.time.compareTo(time) == 0) {
                System.out.println(program.channel + " " + program.title + " " + program.time.hour() + ":" + program.time.minutes());
            }
        }
    }

    public void showProgramsByChannelsIntervalTime(String channel, BroadcastsTime timeStart, BroadcastsTime timeEnd) {
        List<Program> lst = channels.get(channel);
        for (Program program : lst) {
            if (program.time.between(timeStart, timeEnd) & program.channel.equals(channel)) {
                System.out.println(program.channel + " " + program.title + " " + program.time.hour() + ":" + program.time.minutes());
            }
        }
    }
}
