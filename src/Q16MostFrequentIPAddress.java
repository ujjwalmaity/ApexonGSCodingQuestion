import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Given an array of strings,
// return the IP address that occurs maximum number of times.
// [You might have to check for the validity of the IP address before considering it].
//
// Example:
// String [] str = {
// "10.0.0.1 bytes=32 time=50ms TTL=63",
// "10.0.0.2 bytes=32 time=50ms TTL=73",
// "10.0.0.4 bytes=32 time=50ms TTL=83",
// "10.0.0.2 bytes=32 time=50ms TTL=93",
// }
//
// Return 10.0.0.2

public class Q16MostFrequentIPAddress {

    public void call() {
        String[] str = {
                "10.0.0.1 bytes=32 time=50ms TTL=63",
                "10.0.0.2 bytes=32 time=50ms TTL=73",
                "10.0.0.4 bytes=32 time=50ms TTL=83",
                "10.0.0.2 bytes=32 time=50ms TTL=93",
        };

        Map<String, Integer> map = new HashMap<>();

        for (String log : str) {
            String ip = log.split(" ")[0];
            if (isValidIP(ip)) {
                map.put(ip, map.getOrDefault(ip, 0) + 1);
            }
        }

        int maxFrequency = Integer.MIN_VALUE;
        String mostFrequentIP = "";

        for (var entry : map.entrySet()) {
            String ip = entry.getKey();
            int frequency = entry.getValue();
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                mostFrequentIP = ip;
            }
        }

        System.out.println(mostFrequentIP);
    }

    private boolean isValidIP(String ip) {
        // IP range 0-255 without any leading zeros
        //
        // 25[0-5] -> 250-255
        // 2[0-4][0-9] -> 200-249
        // 1[0-9]{2} -> 100-199
        // [1-9]?[0-9] -> 10-99 or 0-9
        //
        // ^ -> asserts the start of a line or string
        // \\. -> .
        // $ -> asserts the end of a line or string
        // [0-9]{2} -> [0-9][0-9]
        // [^a-z] -> any character that is not a lowercase letter

        String ipPattern =
                "^(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\." + // 1st byte
                        "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\." + // 2nd byte
                        "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\." + // 3rd byte
                        "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])$"; // 4th byte
        Pattern pattern = Pattern.compile(ipPattern);
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }
}
