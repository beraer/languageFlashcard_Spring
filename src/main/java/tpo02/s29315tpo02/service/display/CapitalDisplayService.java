package tpo02.s29315tpo02.service.display;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import tpo02.s29315tpo02.model.Entry;

import java.util.List;

@Service
@Profile("capital")
public class CapitalDisplayService implements DisplayService {
    public void display(List<Entry> entries){
        entries.forEach(entry -> {
            System.out.println(entry.getPolish().toUpperCase() + " " + entry.getGerman().toUpperCase() + " " + entry.getEnglish().toUpperCase());
        });
    }
}
