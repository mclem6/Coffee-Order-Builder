import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MyTest {

	@Test
	void buildOrderConstructor(){
		BuildOrder order1 = new BuildOrder();

		assertEquals("Black Coffee: $4.50", order1.orderDetails, "BuildOrder Construction tests failed");
		assertEquals(4.5, order1.order.makeCoffee(), "BuildOrder Construction tests failed");

	}

	@Test
	void addShottest(){
		BuildOrder order1 = new BuildOrder();
		order1.addShot();
		assertEquals("Black Coffee: $4.50\n + extra shot: $1.20", order1.orderDetails, "addShot() method failed");
	}

	@Test
	void addCreamtest(){
		BuildOrder order1 = new BuildOrder();
		order1.addCream();
		assertEquals("Black Coffee: $4.50\n + cream: $.50", order1.orderDetails, "addCream() method failed");

	}

	@Test
	void addSugartest(){
		BuildOrder order1 = new BuildOrder();
		order1.addSugar();
		assertEquals("Black Coffee: $4.50\n + sugar: $.50", order1.orderDetails, "addSugar() method failed");
	}


	void multipleAddTest(){
		BuildOrder order1 = new BuildOrder();
		BuildOrder order2 = new BuildOrder();


		order1.addSugar();
		order1.addCream();

		order2.addCream();
		order2.addSugar();

		assertEquals("Black Coffee: $4.50\n + sugar: $.50\n + cream: %.50", order1.orderDetails, "addSugarAndCream test1 failed");
		assertEquals("Black Coffee: $4.50\n + cream: %.50\n + sugar: $.50", order1.orderDetails, "addSugarAndCream test2 failed");

		order2.addShot();
		assertEquals("Black Coffee: $4.50\n + cream: %.50\n + sugar: $.50\n + extra shot: $1.20", order1.orderDetails, "addSugarAndCream test2 failed");



	}

	@Test
	void restartOrderTest(){
		BuildOrder order1 = new BuildOrder();
		order1.addSugar();
		order1.addCream();
		order1.restartOrder();

		assertEquals("Black Coffee: $4.50", order1.orderDetails, "restartOrder failed");

	}

	@Test
	void getTotal(){

		BuildOrder order1 = new BuildOrder();
		assertEquals(4.5, order1.getTotal(), "getTotal failed");

		order1.addSugar();
		assertEquals(5.0, order1.getTotal(), "getTotal failed");

		order1.addCream();
		assertEquals(5.5, order1.getTotal(), "getTotal failed");

		order1.addShot();
		assertEquals(6.7, order1.getTotal(), "getTotal failed");
		
		order1.restartOrder();
		assertEquals(4.5, order1.getTotal(), "getTotal failed");
		
	}






}
