package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem {
    private final Map<Integer, Accident> accidents = new ConcurrentHashMap<>();
    private AtomicInteger count = new AtomicInteger();

    public AccidentMem() {
    }

    public List<Accident> getAccidents() {
        return new ArrayList<>(accidents.values());
    }

    public Accident getAccident(int key) {
        return accidents.get(key);
    }

    public void update(int key, Accident accident) {
        if (accident.getId() > -1) {
            accidents.remove(accident.getId());
            accidents.put(accident.getId(), accident);
        } else {
            accident.setId(count.get());
            accidents.put(count.get(), accident);
            count.getAndIncrement();
        }
    }
}
