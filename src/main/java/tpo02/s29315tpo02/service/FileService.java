package tpo02.s29315tpo02.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tpo02.s29315tpo02.config.FlashcardsProperties;
import tpo02.s29315tpo02.model.Entry;
import tpo02.s29315tpo02.repository.EntryRepository;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Service
public class FileService {
    private final EntryRepository entryRepository;
    private final FlashcardsProperties properties;

    @Autowired
    public FileService(EntryRepository entryRepository, FlashcardsProperties properties) {
        this.entryRepository = entryRepository;
        this.properties = properties;
    }

    @PostConstruct
    public void loadEntriesFromFile(){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/" + properties.getFilename()),
                StandardCharsets.UTF_8))) {
            String line;
            while((line = br.readLine()) != null){
                String[] words = line.split(",");
                Entry entry = new Entry(words[0], words[1], words[2]);
                entryRepository.addEntry(entry);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
