package tpo02.s29315tpo02.repository;

import org.springframework.stereotype.Repository;
import tpo02.s29315tpo02.model.Entry;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EntryRepository {
    private List<Entry> entries = new ArrayList<>();

    public void addEntry(Entry entry) {
        entries.add(entry);
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public Entry getRandomEntry() {
        int r = (int) (Math.random() * entries.size());
        return entries.get(r);
    }

}
