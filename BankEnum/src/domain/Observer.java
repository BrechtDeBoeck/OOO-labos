package domain;

import java.util.HashMap;

public interface Observer {
    void update(Rekening rekening, Event event);
}
