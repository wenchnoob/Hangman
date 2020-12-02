package com.Dictionary;

import java.io.*;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

public final class Dictionary {

    private static Properties dict = new Properties();
    private static final String filePath = new File("").getAbsolutePath().concat("\\src\\com\\Resources\\dict.dat");
    private static final File data = new File(filePath);

    private boolean closed = false;

    // Static Initializer
    static {
        try {
            if(!data.canRead()){
                data.createNewFile();
                dict.put("apple", "a red fruit");
                dict.put("set", "a mathematical construct");
                dict.put("laptop", "device used to make this.");
                dict.put("monitor", "a peripheral that displays information in a visual format");
                dict.put("class", "a way of organizing information.");
                dict.store(new FileOutputStream(data), "The Word and Description pairs for the game!");
            } else { dict.load(new FileReader(data)); }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Default constructor
    public Dictionary() { }

    // Save the elements currently in the dictionary
    public boolean save() {
        try {
            dict.store(new FileOutputStream(data), "The Word and Description pairs for the game!");
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    // Adds an element into the dictionary
    public void add(String key, String val) { dict.put(key, val); }

    // Removes an element from the dictionary
    public void remove(String key) { dict.remove(key); }

    // Determines whether a dictionary contains the specified element or not
    public boolean contains(String key) {return dict.containsKey(key);}

    // Retrieves a random member of the dictionary
    public Map.Entry<Object, Object> getRandom() {
        int randIndex = new Random().nextInt(dict.size());
        var entries = dict.entrySet().iterator();
        for (int i = 0; i < randIndex; i++) entries.next();
        return entries.next();
    }
}
