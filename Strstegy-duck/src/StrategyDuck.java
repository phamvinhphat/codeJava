
interface QuackBehavior {
	public void quack() ;
}

class Quack implements QuackBehavior{
		public void quack() {
			System.out.println("Quack, Quack,....");
		}
}

class Queck implements QuackBehavior {
		public void quack() {
			System.out.println("Queck, Queck,....");
		}
}

class MuteQuack implements QuackBehavior {
	public void quack() {
		System.out.println("......");
	}
}

interface FlyBehavior {
	public void fly();
}

class FlyWithWings implements FlyBehavior {
	public void fly() {
		System.out.println("Fly, Fly, ....");
	}
}

class FlyNoWay implements FlyBehavior	{
	public void fly() {
		System.out.println("No fly");
	}
}

class FlyRocketPowered implements FlyBehavior {
	public void fly() {
		System.out.println("I'm flying with a rocket");
	}
}

abstract class  Duck {
	
	protected QuackBehavior quackBehavior;
	protected FlyBehavior 	flyBehavior;
	
	public void quack() {
		quackBehavior.quack();
	}
	
	public void fly() {
		flyBehavior.fly();
	}
	
	public void swim() {
		System.out.println("I'm swimming");
	}
	
	public void setFlyBehavior(FlyBehavior fy) {
		flyBehavior = fy;
	}
	
	public void setQuackBehavior(QuackBehavior qk) {
		quackBehavior = qk;
	}
	
	public abstract void display();	
}

class ModelDuck extends Duck {
	public ModelDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Quack();
		
	}
	
	
	
	public void display() {
		
		System.out.println("look like a Model Duck");
	}
}


class MallarDuck extends Duck {
	public MallarDuck() {
		quackBehavior = new Quack();
		flyBehavior   = new FlyWithWings();
		swim();
	}
		
	public void display() {
			System.out.println("look like a Mallar Duck");
	}
}

class RedHeadDuck extends Duck{
	public RedHeadDuck() {
		quackBehavior = new Queck();
		flyBehavior   = new FlyNoWay();
		swim();
	}
	
	public void display() {
		System.out.println("Look like a Read Head Duck");
	}	
}

class RubberDuck extends Duck {
	public RubberDuck() {
		quackBehavior = new Queck();
		flyBehavior   = new FlyNoWay();
		swim();
	}
	
	public void display() {
		System.out.println("Look like a Rubber duck");
	}
}

class WoodenDuck extends Duck {
	public WoodenDuck() {
		quackBehavior = new MuteQuack();
		flyBehavior = new FlyNoWay();
	}
	public void display() {
		System.out.println("Look like a Wooden duck");
	}
}

public class StrategyDuck {
	public static void main(String args[]) {
		Duck duck = new RubberDuck();	
		duck.quack();
		duck.fly();
		
		Duck model = new ModelDuck();
		model.quack();
		model.fly();
		model.setFlyBehavior(new FlyRocketPowered());
		model.fly();
	}
}
