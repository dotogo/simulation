package com.dmitriykolesnik.simulation.for_something;
/*
import com.dmitriykolesnik.simulation.Coordinates;
import com.dmitriykolesnik.simulation.entities.Entity;
import com.dmitriykolesnik.simulation.entities.moving_entities.Creature;
import com.dmitriykolesnik.simulation.entities.static_entities.Grass;
import com.dmitriykolesnik.simulation.pathfinder.BreadthFirstSearch;
import com.dmitriykolesnik.simulation.pathfinder.PathFinder;
import com.dmitriykolesnik.simulation.view.ConsoleWorldMapRenderer;
import com.dmitriykolesnik.simulation.world_map.TestWorldMapFactory;
import com.dmitriykolesnik.simulation.world_map.WorldMap;
import org.reflections.Reflections;

import java.util.*;

public class ForSomething {
    public static void main(String[] args) {

        // Разные символы и пиктограммы
        //1F300–1F5FF

        // https://symbl.cc/ru/unicode-table/
//        System.out.println("\uD83C\uDF33 \uD83C\uDF32 \uD83C\uDF3F \uD83C\uDF37 \uD83D\uDC07");
//        System.out.println("\uD83D\uDC08 - кот");
//        System.out.println("\uD83D\uDC06 - леопард");
//        System.out.println("\uD83D\uDC05 - тигр");
//        System.out.println("\uD83D\uDC0A - крокодил");
//        System.out.println("\uD83E\uDD96 - тиранозавр");
//        System.out.println("\uD83D\uDC31 - морда кота");
//        System.out.println("\uD83D\uDC3A - морда волка");
//        System.out.println("\uD83E\uDD81 - львиная морда");
//        System.out.println("\uD83D\uDC2F - морда тигра");
//        System.out.println("\uD83D\uDC3B - морда медведя");
//        System.out.println("\uD83D\uDC2D - морда мыши");
//        System.out.println("\uD83D\uDC30 - морда кролика");
//        System.out.println("\uD83D\uDC37 - морда свиньи");
//        System.out.println("\uD83E\uDD93 - морда зебры");
//        System.out.println("\uD83D\uDC00 - крыса");
//        System.out.println("\uD83D\uDC26 - птица");
//        System.out.println("\uD83D\uDC07 - заяц");
//        System.out.println("\uD83D\uDC10 - коза");
//        System.out.println("\uD83D\uDC11 - овца");
//        System.out.println("\uD83D\uDC04 - корова");
//        System.out.println("\uD83D\uDC17 - кабан");
//        System.out.println("\uD83D\uDC0E - лошадь");
//        System.out.println("\uD83D\uDC03 - буйвол");
//        System.out.println("\uD83E\uDD94 - ёж");
//        System.out.println("\uD83D\uDF59\uD83D\uDF59\uD83D\uDF59\uD83D\uDF59 - кирпич");
//        System.out.println("\uD83D\uDF59\uD83D\uDF59\uD83D\uDF59\uD83D\uDF59 - кирпич");
//        System.out.println("\uD83D\uDF59 \uD83D\uDF59 \uD83D\uDF59 \uD83D\uDF59 - кирпич");
//        System.out.println("\uD83E\uDE05");
//        System.out.println("\uD83C\uDF3E - колос риса");
//        System.out.println("\uD83C\uDF31 - саженец");
//        System.out.println("\uD83C\uDF40 - четырёхлистник");
//        System.out.println("\uD83E\uDEA8 - камень");
//        System.out.println("\uD83E\uDDF1 - кирпич");
//        System.out.println("□ - Белый квадрат");
//        System.out.println("❌ - Метка крест");


//        WorldMap worldMap = new TestWorldMapFactory().create();
//        ConsoleWorldMapRenderer consoleWorldMapRenderer = new ConsoleWorldMapRenderer();
//        consoleWorldMapRenderer.render(worldMap);
//
//        int depthOfSearch = 3;
//        //Coordinates startCoordinates = new Coordinates(4, 0);
//        Coordinates startCoordinates = new Coordinates(0, 0);
//        Class<?> targetClass = Grass.class;
//
//        PathFinder pathFinder = new BreadthFirstSearch(worldMap);
//        List<Coordinates> nearestRabbit = pathFinder.find(startCoordinates, depthOfSearch, targetClass);
//
//        int size = nearestRabbit.size();
//        Coordinates lastCoordinatesInList = nearestRabbit.get(size - 1);
//        boolean cellContainingEntity = worldMap.isCellContainingEntity(lastCoordinatesInList);
//        Entity lastEntity = null;
//
//        if (cellContainingEntity) {
//            lastEntity = worldMap.getEntity(lastCoordinatesInList);
//        }
//
//        boolean isTargetFound = false;
//
//        if (lastEntity != null) {
//            isTargetFound = targetClass.isInstance(lastEntity);
//        }
//
//        System.out.println("Depth of search: " + depthOfSearch);
//        System.out.println("Target is " + targetClass.getSimpleName());
//        System.out.println("Size of the path: " + size);
//        if (isTargetFound) {
//            System.out.println("Target was found in the cell " + lastCoordinatesInList);
//        } else {
//            System.out.println("Target was not found");
//        }
//
//        nearestRabbit.forEach(e -> System.out.print(e + "  "));

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        HashSet<Integer> integers = new HashSet<>();
        integers.add(5);
        integers.add(3);
        integers.add(2);
        integers.add(4);
        integers.add(1);

        List<Integer> list = new ArrayList<>(integers);
        Collections.shuffle(list);

        System.out.println("BEfore ");

        for (Integer temp : list) {
            System.out.print(temp + " " + "  text  ");
            System.out.println("eeee");
        }

        System.out.println(" after list");

        Reflections reflections = new Reflections("com.dmitriykolesnik.simulation");
        System.out.println(10);
        Set<Class<? extends Creature>> subclasses = reflections.getSubTypesOf(Creature.class);
        System.out.println(100);
        subclasses.forEach(subclass -> System.out.println(subclass.getSimpleName()));
        System.out.println();

        System.out.println("\uD83D\uDC3A");

    }
}

 */
