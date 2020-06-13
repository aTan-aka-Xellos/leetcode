import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class RandomizedSet {

    public static void main(String[] args) {

        RandomizedSet set =  new RandomizedSet();

        set.insert(1);
        set.remove(2);
        set.insert(2);

        set.getRandom();

        set.remove(2);
        set.insert(2);

        set.getRandom();
        set.remove(2);
    }

    List<Integer> list;
    Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;

        map.put(val, list.size());
        return list.add(val);
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {

        Integer index = map.get(val);
        if (index == null) return false;

        list.set(index, list.get(list.size() - 1));
        map.put(list.get(index), index);

        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int randomIndex = ThreadLocalRandom.current().nextInt(0, list.size());
        return list.get(randomIndex);
    }

}
