import java.util.HashMap;
import java.util.Set;

public class HashMapFun {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        //        <key, value>
        //        (title, lyrics) in this case
        trackList.put("Coding the Dojo", "We were coding down at the Dojo...");
        trackList.put("Clinking Keyboards", "Oh the keyboard melody...");
        trackList.put("Coding Call", "Can you hear that Coding Call...");
        trackList.put("Variable Wonder", "Wonderous words of Variable lore");
        
        String title = trackList.get("Coding Call");
        System.out.println("The music starts playing: " + title);

        Set<String> keys = trackList.keySet();
        for(String key : keys) {
            System.out.println(key + " : " + trackList.get(key));
        }
    }
}