package manager;

import database.Database;
import database.InMemoryDb;

import java.util.*;

public class InMemoryDbManager implements DatabaseManager, DataIterator {
    private InMemoryDb database;
    private Iterator<Map.Entry<String, String>> iterator;
    private String iteratorCurrentValue;

    @Override
    public void setDatabase(Database database) {
        this.database = (InMemoryDb) database;
    }

    public void setIterator() {
        iterator = database.getInMemoryDb().entrySet().stream().iterator();
    }

    public void runIterator() {
        if (iterator.hasNext()) {
            String currentValue = iterator.next().getValue();
            this.iteratorCurrentValue = currentValue;
            System.out.println(currentValue);
        }
    }

    public boolean hasValue() {
        return iterator.hasNext();
    }

    public String getCurrentValue() {
        return  iteratorCurrentValue;
    }

    public void addNewValue(String key, String value) {
        database.getInMemoryDb().put(key, value);
    }

    public String getAnswer(String value) {
        Set<Map.Entry<String,String>> entrySet = database.getInMemoryDb().entrySet();
        String found = "No answer yet";
        for (Map.Entry<String,String> pair : entrySet) {
            if (value.equals(pair.getValue())) {
                found = pair.getKey();
            }
        }
        return found;
    }
}
