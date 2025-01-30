public class BuildOrder {

    Coffee order;
    String orderDetails = "";
    double order_total = 0;

    BuildOrder(){
        order = new BasicCoffee();
    }

    void restartOrder(){
        order = new BasicCoffee();

    }

    void printOrder(){
        System.out.println(orderDetails);
        System.out.println("Total: " + order_total);
    }

    double getTotal(){
        return order_total;
    }

      //add shot
    void addShot(){
        order = new ExtraShot(order);
        order.makeCoffee();
        order_total += 1.2;
    }


    //Add on methods 
    //add cream 
    void addCream(){
        order = new Cream(order);
        order.makeCoffee();
        order_total += .50;
    }


     //add sugar
     void addSugar(){
        order = new Sugar(order);
        order.makeCoffee();
        order_total += .5;
    }

     //add cinnamon 
     void addCinnamon(){
        order = new Cinnamon(order);
        order.makeCoffee();
        order_total += .33;
    }

      //add cinnamon 
      void addVanilla(){
        order = new Vanilla(order);
        order.makeCoffee();
        order_total += .33;
    }


    interface Coffee{
            public double makeCoffee();
    }

    class BasicCoffee implements Coffee{

        private double cost = 4.50;

        //constructor 
        BasicCoffee(){
            orderDetails = "Black Coffee: $4.50"; 
            order_total = cost;
        }
        
        @Override
        public double makeCoffee() {
            
            System.out.println("Black Coffee: $4.50");
            
            return cost;
        }	
    }

    abstract class CoffeeDecorator implements Coffee{
        protected Coffee specialCoffee;
        
        public CoffeeDecorator(Coffee specialCoffee) {
            this.specialCoffee = specialCoffee;
        }
        
        public double makeCoffee() {
            return specialCoffee.makeCoffee();
        }
    }

    class ExtraShot extends CoffeeDecorator{
        
        private double cost = 1.20;
        
        
        ExtraShot(Coffee specialCoffee){
            super(specialCoffee);
            orderDetails += "\n + extra shot: $1.20"; 
        }
        
        public double makeCoffee() {
            return specialCoffee.makeCoffee() + addShot();
        }
        
        private double addShot() {
            System.out.println(" + extra shot: $1.20");
        
            
            return cost;
        }
    }

    class Cream extends CoffeeDecorator{
        
        private double cost = .50;
        Cream(Coffee specialCoffee){
            super(specialCoffee);
        }
        
        public double makeCoffee() {
            return specialCoffee.makeCoffee() + addCream();
        }
        
        private double addCream() {
            
            System.out.println(" + cream: $.50");
            orderDetails += "\n + cream: $.50";

            return cost;
        }
    }

    class Sugar extends CoffeeDecorator{
        
        private double cost = .50;
        
        Sugar(Coffee specialCoffee){
            super(specialCoffee);
            orderDetails += "\n + sugar: $.50"; 
        }
        
        public double makeCoffee() {
            return specialCoffee.makeCoffee()+ addSugar();
        }
        
        private double addSugar() {
            
            System.out.println(" + sugar: $.50");
        
            
            return cost;
        }
    }

    class Cinnamon extends CoffeeDecorator{
	
        private double cost = .33;
        
        Cinnamon(Coffee specialCoffee){
            super(specialCoffee);
            orderDetails += "\n + cinnamon: $.33"; 
        }
        
        public double makeCoffee() {
            return specialCoffee.makeCoffee()+ addCinnamon();
        }
        
        private double addCinnamon() {
            
            System.out.println(" + cinnamon: $.33");            
            return cost;
        }
    }

    class Vanilla extends CoffeeDecorator{
	
        private double cost = .33;
        
        Vanilla(Coffee specialCoffee){
            super(specialCoffee);
            orderDetails += "\n + vanilla: $.33"; 
        }
        
        public double makeCoffee() {
            return specialCoffee.makeCoffee()+ addVanilla();
        }
        
        private double addVanilla() {
            
            System.out.println(" + vanilla: $.33");
    
            
            return cost;
        }
    }


    
}
