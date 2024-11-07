# Simulation
Simulation of a 2D world with predators, herbivores, edible plants and other static objects.

## Project Description
The simulation is an endless cycle where predators hunt for herbivores and rodents, and those, in turn, are busy searching for edible plants. Predators choose their prey according to their size: a Cat looks for Mice, a Wolf may eat a Rabbit or Sheep, a Lion attacks Sheep, Zebras and Buffaloes, and Tyrannosaurus is only interested in the largest herbivores - Zebra and Buffalo.

There are 13 types of entities in total.

- Predators: Cat, Lion, Wolf, Tyrannosaurus.
- Herbivores: Buffalo, Zebra, Sheep.
- Rodents: Rabbit, Mouse.
- Edible plants: Grass, Grain.
- Static objects: Tree, Rock.

If some type of Entities become critically low (< 30% of the initial value), they are replenished. Grass and Grain sprout in random places in quantities no greater than the initial. New animals enter from the edge of the map (appear in empty cells along the perimeter of the map). In the case of the complete disappearance of all Entities of one type in one turn, they are fully replenished to the initial value in random places on the map.

## Interaction of Creatures
Each Creature is created with different parameters, within the limits available to its species:
- Herbivores and Rodents - health, speed;
- Predators - health, speed, attack power;
- Edible plants - food value.

For example, the Wolf is created with the following values: Health - 80...100, Speed ​​(maximum number of cells for movement in one move) - 4...5, Attack - 30...70. During the hunt, it can improve its health to the maximum possible for its species - 200.

When attacking, the Predator takes health from the prey equal to its Attack. If the prey's health drops to 0, it disappears from the Map and the Predator takes its place. If the prey remains alive, the Predator takes its place in the cell next to it.

When eating Edible Plants, Health increases by the amount of their food value.

If no food is found, the Creature moves to a random cell according to its speed, and its health decreases.
When the health level reaches zero, the Creature dies and is removed from the World Map.

## Simulation Control
Control is via the Main Menu, which offers a choice of one of three World Map configurations:
- Small Map – size 15 x 15, only Wolves and Rabbits. Information about each move is output to the console: Entity ID, its coordinates and state (health level, speed, attack power for predators), whether the target was found, target coordinates and the path to it, the state of the Entity after the move.
- Basic Map – the map size and the percentage of filling the map cells (occupancy rate) are set by the user (taking into account the built-in restrictions). Wolves, Rabbits, Cats and Mice are created. Their ratio to each other cannot be set. Console logging is disabled.
- Custom Map – the map size and the number of each type of Entity (13 types) are set by the user (taking into account the built-in restrictions). Console logging is disabled.

Once running, the user can toggle pause (s / s + Enter) or abort the Simulation completely (q).

## The main technical goal of the project
Demonstration of application architecture design principles using OOP.

## Some technical details
- Java 11
- Maven 3.9.6
- Dependencies: org.reflections and org.slf4j

Reflections used .getSubTypesOf() method to get the list of class descendants.

The following design patterns are used: Factory, Singleton, Template method.

## Installation and launch
- Clone the repository:
git clone https://github.com/dotogo/simulation.git

- Open the project in IntelliJ IDEA.
- Build the project with Maven:
mvn clean install

After installation, run Main to start the Simulation.