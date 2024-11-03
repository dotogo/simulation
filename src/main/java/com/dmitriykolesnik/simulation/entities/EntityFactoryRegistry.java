package com.dmitriykolesnik.simulation.entities;

import com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.herbivores.Buffalo;
import com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.herbivores.Sheep;
import com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.herbivores.Zebra;
import com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.rodents.Mouse;
import com.dmitriykolesnik.simulation.entities.moving_entities.non_predators.rodents.Rabbit;
import com.dmitriykolesnik.simulation.entities.moving_entities.predators.Cat;
import com.dmitriykolesnik.simulation.entities.moving_entities.predators.Lion;
import com.dmitriykolesnik.simulation.entities.moving_entities.predators.TyrannosaurusRex;
import com.dmitriykolesnik.simulation.entities.moving_entities.predators.Wolf;
import com.dmitriykolesnik.simulation.entities.static_entities.Grain;
import com.dmitriykolesnik.simulation.entities.static_entities.Grass;
import com.dmitriykolesnik.simulation.entity_factories.EntityFactory;
import com.dmitriykolesnik.simulation.entity_factories.impl.*;

import java.util.HashMap;
import java.util.Map;

public class EntityFactoryRegistry {
    private final Map<Class<? extends Entity>, EntityFactory<? extends Entity>> factoryMap = new HashMap<>();

    public EntityFactoryRegistry() {
        factoryMap.put(Buffalo.class, new BuffaloFactory());
        factoryMap.put(Cat.class, new CatFactory());
        factoryMap.put(Grain.class, new GrainFactory());
        factoryMap.put(Grass.class, new GrassFactory());
        factoryMap.put(Lion.class, new LionFactory());
        factoryMap.put(Mouse.class, new MouseFactory());
        factoryMap.put(Rabbit.class, new RabbitFactory());
        factoryMap.put(Sheep.class, new SheepFactory());
        factoryMap.put(TyrannosaurusRex.class, new TyrannosaurusRexFactory());
        factoryMap.put(Wolf.class, new WolfFactory());
        factoryMap.put(Zebra.class, new ZebraFactory());
    }

    public Map<Class<? extends Entity>, EntityFactory<? extends Entity>> getFactoryMap() {
        return factoryMap;
    }
}
