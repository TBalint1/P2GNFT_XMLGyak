package P2GNFT;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class ObjectP2GNFT {
    public static void main(String[] args) throws Exception {
        Object obj = new JSONParser().parse(new FileReader("JSONP2GNFT.json"));

        JSONObject jo = (JSONObject) obj;
        System.out.println(jo);
    }
}