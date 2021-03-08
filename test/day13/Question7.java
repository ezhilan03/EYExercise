package EYExercise.test.day13;

public class Question7 {
	
}
interface Hungry<E> {
	void munch(E x); 
	} 
interface Carnivore<E extends Animal> extends Hungry<E> {
	
} 
interface Herbivore<E extends Plant> extends Hungry<E> {} 

abstract class Plant {} 
class Grass extends Plant {} 
abstract class Animal {} 
class Sheep extends Animal implements Herbivore<Grass> {
	public void munch(Grass x) {}
	}
class Wolf extends Animal implements Carnivore<Sheep> {
	public void munch(Sheep x) {}
	} 