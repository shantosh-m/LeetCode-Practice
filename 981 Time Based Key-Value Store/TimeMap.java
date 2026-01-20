import java.util.*;

class TimeMap {

    private Map <String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new TreeMap<>());
        }
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap <Integer, String> treeMap = map.get(key);
        if(treeMap == null){
            return "";
        }
        Map.Entry <Integer, String> entry = treeMap.floorEntry(timestamp);
        return entry == null ? null : entry.getValue();
    }

    public static void main(String[] args) {
        TimeMap obj = new TimeMap();
        
        obj.set("foo", "bar", 1);
        System.out.println("null"); // Set returns void/null in output

        System.out.println(obj.get("foo", 1));                              // "bar"

        System.out.println(obj.get("foo", 3));                              // "bar" (closest <= 3 is 1)

        obj.set("foo", "bar2", 4);
        System.out.println("null");

        System.out.println(obj.get("foo", 4));                              // "bar2"

        System.out.println(obj.get("foo", 5));                              // "bar2" (closest <= 5 is 4)
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */