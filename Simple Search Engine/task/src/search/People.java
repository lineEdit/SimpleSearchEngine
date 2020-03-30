package search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class People {
    Integer key;
    Map<Integer, String> firstName;
    Map<Integer, String> lastName;
    Map<Integer, String> email;

    enum Value {
        firstName,
        lastName,
        email
    }

    public People() {
        key = 0;
        this.firstName = new HashMap<>();
        this.lastName = new HashMap<>();
        this.email = new HashMap<>();
    }

    public void add(String[] args) {
        if (args.length == 3) {
            add(args[0], args[1], args[2]);
        }
        if (args.length == 2) {
            add(args[0], args[1]);
        }
    }

    public void add(String firstName, String lastName, String email) {
        this.firstName.put(key, firstName);
        this.lastName.put(key, lastName);
        this.email.put(key, email);
        ++key;
    }

    public void add(String firstName, String lastName) {
        this.firstName.put(key, firstName);
        this.lastName.put(key, lastName);
        this.email.put(key, "");
        ++key;
    }

    private List<Integer> findValue(Value value, String find) {
        Map<Integer, String> map = new HashMap<>();
        switch (value) {
            case firstName: map = firstName; break;
            case lastName: map = lastName; break;
            case email: map = email; break;
        }
        List<Integer> list = new ArrayList<>();
        for (var item : map.entrySet()) {
            if (item.getValue().compareToIgnoreCase(find) == 0) {
                list.add(item.getKey());
            }
        }
        return list;
    }

    public List<Integer> findValue(String find) {
        List<Integer> list = new ArrayList<>();
        list.addAll(findValue(Value.firstName, find));
        list.addAll(findValue(Value.lastName, find));
        list.addAll(findValue(Value.email, find));
        return list;
    }
}
