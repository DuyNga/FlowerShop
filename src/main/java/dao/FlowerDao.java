package dao;

import object.Flower;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlowerDao {

    private Map<Integer, Flower> flowersDb = new HashMap<>();

    {
        flowersDb.put(1, new Flower(1, "THOUGHTFUL", "THOUGHTFUL.jpg", "", "", 30));
        flowersDb.put(2, new Flower(2, "SIERRA SUNSET", "SIERRA_SUNSET.jpg", "", "", 42));
        flowersDb.put(3, new Flower(3, "ABOVE & BEYOND", "ABOVE_BEYOND.jpg", "", "", 29));
        flowersDb.put(4, new Flower(4, "CHARISMA", "CHARISMA.jpg", "", "", 25));
        flowersDb.put(5, new Flower(5, "CORN MAZE", "CORN MAZE.jpg", "", "", 30));
        flowersDb.put(6, new Flower(6, "EXUBERANCE", "EXUBERANCE.jpg", "", "", 44));
        flowersDb.put(7, new Flower(7, "LADYBUG", "LADYBUG.jpg", "", "", 35));
        flowersDb.put(8, new Flower(8, "YOU ROCK", "YOU_ROCK.jpg", "", "", 37));
        flowersDb.put(9, new Flower(9, "ETERNAL", "ETERNAL.jpg", "", "", 20));
        flowersDb.put(10, new Flower(10, "BOLD", "BOLD.jpg", "", "", 15));
        flowersDb.put(11, new Flower(11, "UNBREAKABLE", "UNBREAKABLE.jpg", "", "", 17));
        flowersDb.put(12, new Flower(12, "COMPASSION", "COMPASSION.jpg", "", "", 28));
    }

    public List<Flower> getFlowerByPrice(double min, double max) {
        List<Flower> result;
        if (max > 0)
            result = flowersDb.entrySet().stream()
                    .filter(p -> p.getValue().getPrice() >= min && p.getValue().getPrice() <= max)
                    .map(p -> p.getValue()).collect(Collectors.toList());
        else
            result = flowersDb.entrySet().stream()
                    .filter(p -> p.getValue().getPrice() >= min)
                    .map(p -> p.getValue()).collect(Collectors.toList());
        return result;
    }

    public List<Flower> getFlowerList() {
        return flowersDb.entrySet().stream().map(p -> p.getValue()).collect(Collectors.toList());
    }

    public Flower getFlowerById(int id) {
        return flowersDb.get(id);
    }
}