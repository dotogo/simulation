package com.dmitriykolesnik.simulation.action;

import com.dmitriykolesnik.simulation.entities.EntitiesCounterRepository;
import com.dmitriykolesnik.simulation.entities.Entity;
import com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.herbivores.Herbivore;
import com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.rodents.Rodent;
import com.dmitriykolesnik.simulation.entities.moving_entities.predators.Predator;
import com.dmitriykolesnik.simulation.entities.static_entities.EdiblePlant;
import com.dmitriykolesnik.simulation.entities.static_entities.NonEdibleEntity;
import com.dmitriykolesnik.simulation.world_map.WorldMap;
import org.reflections.Reflections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountEntitiesAction implements Actions  {
    private final WorldMap worldMap;

    public CountEntitiesAction(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    @Override
    public void perform() {
        List<Entity> allEntities = worldMap.getAllEntities();
        Reflections reflections = new Reflections("com.dmitriykolesnik.simulation");

        Set<Class<? extends Entity>> allSubclasses = Stream.of(
                reflections.getSubTypesOf(Predator.class),
                reflections.getSubTypesOf(Rodent.class),
                reflections.getSubTypesOf(Herbivore.class),
                reflections.getSubTypesOf(EdiblePlant.class),
                reflections.getSubTypesOf(NonEdibleEntity.class)
        ).flatMap(Set::stream).collect(Collectors.toSet());

        Map<Class<? extends Entity>, Integer> entitiesCounter = new HashMap<>();

        for (Entity entity : allEntities) {
            for (Class<? extends Entity> clazz : allSubclasses) {
                if (clazz.isAssignableFrom(entity.getClass())) {
                    entitiesCounter.merge(clazz, 1, (a, b) -> entitiesCounter.get(clazz) + 1);
                }
            }
        }
        EntitiesCounterRepository.getInstance().setCurrentNumberOfEntitiesOfEachClass(entitiesCounter);
    }
}
