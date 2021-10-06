package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class AccidentMem {
    private final Map<Integer, Accident> accidents = new ConcurrentHashMap<>();

    public AccidentMem() {
        accidents.put(1, new Accident("speed limit", "over speed", "Moscow, Lenina 1"));
        accidents.put(2, new Accident("road accident", "collision of 2 cars", "Moscow, Pobedy 3"));
    }

    public List<Accident> getAccidents() {
        return new ArrayList<>(accidents.values());
    }
}
