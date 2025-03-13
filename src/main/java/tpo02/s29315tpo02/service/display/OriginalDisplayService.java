package tpo02.s29315tpo02.service.display;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import tpo02.s29315tpo02.model.Entry;

import java.util.List;

@Service
@Profile("original")
public class OriginalDisplayService implements DisplayService {
    @Override
    public void display(List<Entry> entries) {
        entries.forEach(entry -> {
            System.out.println(entry.getEnglish() + " " + entry.getPolish() + " " + entry.getGerman());});
    }
}
