import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

public class Main {
    static Channels channels = new Channels();

    public static void main(String[] args) throws IOException {
        List<String> list = Files.readAllLines(new File("src/main/resources/schedule.txt").toPath(), Charset.defaultCharset());
        try {


            start(list);
            channels.showProgramsByTitle("Слово пастыря");
            System.out.println();

            BroadcastsTime time = new BroadcastsTime((byte) 10, (byte) 15);
            channels.showProgramsByCurrentTime(time);
            System.out.println();

            BroadcastsTime time2 = new BroadcastsTime((byte) 8, (byte) 25);
            channels.showProgramsByChannelCurrentTime("#Культура", time2);
            System.out.println();

            BroadcastsTime timeS = new BroadcastsTime((byte) 11, (byte) 15);
            BroadcastsTime timeE = new BroadcastsTime((byte) 18, (byte) 15);
            channels.showProgramsByChannelsIntervalTime("#Первый", timeS, timeE);
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void start(List<String> list) {
        String channel = "";
        byte hours;
        byte minutes;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).charAt(0) == '#') {
                channel = list.get(i);
            } else {
                String[] t = list.get(i).split(":");
                hours = Byte.parseByte(t[0]);
                minutes = Byte.parseByte(t[1]);
                BroadcastsTime time = new BroadcastsTime(hours, minutes);
                String title = list.get(++i);
                Program program = new Program(channel, time, title);
                channels.addChannels(program);
            }
        }
    }
}
