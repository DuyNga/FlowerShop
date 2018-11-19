package dao;

import object.Flower;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlowerDao {

    private Map<Integer, Flower> flowersDb = new HashMap<>();

    {
        flowersDb.put(1, new Flower(1, "THOUGHTFUL", "THOUGHTFUL.jpg", "Featuring rustic yet modern touches like succulents and fresh alstroemeria, this mixed Bouq brings youthful charm and a free-spirited attitude to any space. These flowers are sustainably grown on California coastal farms and delivered next-day, making them some of the freshest you'll find.", "This flower arrangement is filled with alstroemeria & succulents.", 30));
        flowersDb.put(2, new Flower(2, "SIERRA SUNSET", "SIERRA_SUNSET.jpg", "", "This flower arrangement contains bright pink lilies.", 42));
        flowersDb.put(3, new Flower(3, "ABOVE & BEYOND", "ABOVE_BEYOND.jpg", "", "This batch contains purple, pink & white matthiolas.", 29));
        flowersDb.put(4, new Flower(4, "CHARISMA", "CHARISMA.jpg", "", "This arrangement showcases pink rose lily flowers.", 25));
        flowersDb.put(5, new Flower(5, "YOU ROCK", "YOU_ROCK.jpg", "", "This batch contains purple, pink & white matthiolas.", 37));
        flowersDb.put(6, new Flower(6, "ETERNAL", "ETERNAL.jpg", "", "These tea roses are colored in various shades of pink.", 20));
        flowersDb.put(7, new Flower(7, "UNBREAKABLE", "UNBREAKABLE.jpg", "", "These flowers include pink-white lilies & snapdragons.", 17));
        flowersDb.put(8, new Flower(8, "COMPASSION", "COMPASSION.jpg", "", "This arrangement is made up of pink Asiatic lily flowers.", 28));
        flowersDb.put(9, new Flower(9, "CORN MAZE", "CORN MAZE.jpg", "", "", 30));
        flowersDb.put(10, new Flower(10, "EXUBERANCE", "EXUBERANCE.jpg", "", "", 44));
        flowersDb.put(11, new Flower(11, "LADYBUG", "LADYBUG.jpg", "", "", 35));
        flowersDb.put(12, new Flower(12, "BOLD", "BOLD.jpg", "", "", 15));
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