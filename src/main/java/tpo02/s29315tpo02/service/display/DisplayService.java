package tpo02.s29315tpo02.service.display;

import org.springframework.stereotype.Service;
import tpo02.s29315tpo02.model.Entry;

import java.util.List;

public interface DisplayService {
    void display(List<Entry> entries);
}
