package controlador;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculadoraTest {

	private static Calculadora calc;
	
	@BeforeAll
	static void inicializarCalculadora() {
		calc = new Calculadora();
	}
	
	@Test
	void sumaTest() {
		assertEquals(8, calc.suma(1, 7), 
				"Error al sumar 1+7");
		assertEquals(-3, calc.suma(9, -12), 
				"Error al sumar 1+7");
	}
	
	@Test
	void divideTest() {
		assertEquals(2, calc.divide(8,4));
		assertEquals(4.5, calc.divide(9, 2));
		assertEquals(0, calc.divide(6, 0));
	}
	
	@Test
	void esParTest() {
		assertTrue(calc.esPar(8), 
				"El número 8 debería devolver true");
		assertFalse(calc.esPar(9), 
				"El número 9 debería devolver false");
		assertTrue(calc.esPar(0), 
				"El número 0 debería devolver true");
		assertTrue(calc.esPar(-8), 
				"El número -8 debería devolver true");
		assertFalse(calc.esPar(-9), 
				"El número -9 debería devolver false");
	}
	
	@Test
	void getEstadoIMCTest() {
		assertAll(
			()->assertEquals("Bajo peso", calc.getEstadoIMC(16f),
					"Un IMC de 16 debería devolver Bajo peso"),
			()->assertEquals("Peso normal (saludable)", 
					calc.getEstadoIMC(19.5f),
					"Un IMC de 19.5 debería devolver Peso Normal"),
			()->assertEquals("Sobrepeso", calc.getEstadoIMC(25.5f),
					"Un IMC de 25.5 debería devolver Sobrepeso"),
			()-> assertEquals("Obesidad premórbida", calc.getEstadoIMC(35f),
					"Un IMC de 35 debería devolver Obesidad premórbida"),
			()->assertEquals("Obesidad mórbida", calc.getEstadoIMC(42.5f),
					"Un IMC de 42.5 debería devolver Obesidad mórbida"),
			// casos límite
			()->assertEquals("Bajo peso", calc.getEstadoIMC(0f),
					"Un IMC de 0 debería devolver Bajo peso"),
			()->assertEquals("Peso normal (saludable)", calc.getEstadoIMC(18.5f),
					"Un IMC de 18.5 debería devolver Peso normal (saludable)"),
			()->assertEquals("Sobrepeso", calc.getEstadoIMC(24.9f),
					"Un IMC de 24.9 debería devolver Sobrepeso"),
			()->assertEquals("Obesidad premórbida", calc.getEstadoIMC(29.9f),
					"Un IMC de 29.9 debería devolver Obesidad premórbida"),
			()->assertEquals("Obesidad mórbida", calc.getEstadoIMC(40f),
					"Un IMC de 40 debería devolver Obesidad mórbida")
			);
	}
	
	@Test
	void esPrimoTest() {
		assertTrue(calc.esPrimo(7), " El número 7 debería ser primo ");
		assertFalse(calc.esPrimo(8), 
			" El número 8 es compuesto debería devolver false");
		assertFalse(calc.esPrimo(0), "el cero no es primo");
		assertTrue(calc.esPrimo(-7), " El número -7 debería ser primo ");
		assertFalse(calc.esPrimo(-8), 
			" El número -8 es compuesto debería devolver false");
		assertTrue(calc.esPrimo(1), " El número 1 debería ser primo ");
	
	}
	
	@Test
	void factorialTest() {
		assertEquals(120, calc.factorial(5),
				"El factorial de 5 de be ser 120");
		assertEquals(1, calc.factorial(1), "El factorial de 1 es 1");
		assertEquals(1, calc.factorial(0), "el factorial de 0 es 1");
		assertThrows(ArithmeticException.class, ()->calc.factorial(-4));
	}
	
	@Test
	void rotarDerechaTest() {
		int v[]= {1,2,3,4,5};
		int rotado[] = {5,1,2,3,4};
		calc.rotarDerecha(v);
		assertArrayEquals("El vector rotado debe ser {5,1,2,3,4}",
				rotado, v);
	}

}
