package tpo02.s29315tpo02.service.display;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import tpo02.s29315tpo02.model.Entry;
import tpo02.s29315tpo02.repository.EntryRepository;

import java.util.List;

@Service
@Profile("lower")
public class LowerDisplayService implements DisplayService {
    @Override
    public void display(List<Entry> entries){
        entries.forEach(entry -> {
            System.out.println(entry.getPolish().toLowerCase() + " " + entry.getGerman().toLowerCase() + " " + entry.getEnglish().toLowerCase());
        });
    }
}
