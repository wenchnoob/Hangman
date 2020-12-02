package com.Dictionary;

import com.Util.Input;

import java.util.Map;

public class DictionaryManager {
    private static final Dictionary dict = new Dictionary();
    private boolean closed = false;

    public Map.Entry<Object, Object> random() { return dict.getRandom(); }

    public boolean add() {
        if (closed) throw new IllegalStateException("The dictionary is closed to revisions.");
        var key = Input.get("What would you like to add to the dictionary?");
        var val = Input.get("Please provide a description for '" + key + "'");
        var confirmation = Input.get("Please confirm that you would like to add '" + key + "' with a description of '" + val
                + "'\n(Please confirm with y or yes, anything else will cancel the request)");

        if (confirmation.equals("y") || confirmation.equals("yes")) {
            dict.add(key, val);
            dict.save();
            return true;
        }

        return false;
    }

    public boolean remove() {
        if (closed) throw new IllegalStateException("The dictionary is closed to revisions.");
        var key = Input.get("What element would you like to remove?");
        dict.remove(key);
        dict.save();
        return dict.contains(key);
    }

    public boolean contains(String key) { return dict.contains(key); }

    public boolean close() {
        closed = true;
        return dict.save();
    }

    public void open() { closed = false; }
}
