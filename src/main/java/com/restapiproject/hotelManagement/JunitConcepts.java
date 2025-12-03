package com.restapiproject.hotelManagement;

public class JunitConcepts {

//	open source testing framework for the java programming language
//	tool for developers to create tests- units of the code
//	ensure the quality and maintainability of java codes
//	
//	light weight testing framework, we use it for unit testing
//	write automated tests that validate small pieces of codes(units) (classes)
//	
//	benefits- executions, enables to document expected behaviour, enables test driven development TDD
//	
//	junit 5 -> more modular approach, backward compatibility
//	spring boot -> spring-boot-starter-test -> bundles Junit and test utilities
//	
//	add junit 5 dependency -> org.junit.jupiter -> scope -> test: does not get the production code
//	
//	Junit test framework Architecture:
//		Modules: Platform -> discover and run tests
//				 Jupiter -> new programming model (annotations, assertions)
//				 Vintage module -> it runs the junit 3/4 test on junit 5 platform 
	
//	Concepts: test discovery, execution, lifecycle methods, assertions...
//	
//	Junit class-> write test methods, annotate them with @Test
//	AAA pattern: A -> arrange- prepare data/mocks
//				 A -> Act- invoke method under test
//				 A -> Assert- verify the outcome using assertions
//				 
//				 
//	public class Calculator{
//		
//		pulic int add(int a, int b) {
//		return a+b;
//		 }
//	}
//				 
//	@Test
//	void testAdd() {
//		Calculator calc = new Calculator();
//		int result = calc.add(12, 13);
//		assertEquals(25, result, "12+13 should be equal to 25");
//	}
//	
//	Test case: represents a specific scenario or condition to be tested
//	test cases are implemented as methods within test class, annotate with @Test
//	
//	@Annotations:
//		@Test -> marks a methods as unit test
//		@BeforeEach -> executes a method before each test method in class
//		@AfterEach -> executes a method after each test method in class 
//		@BeforeAll -> executes a method once before all test method in class
//		AfterAll -> executes a method once after all test method in class
//	
//	@Assertions:
//		are used within test methods to verify outcome
//		assetEquals(expected, actual) : Checks if two values are equal
//		assertTrue(condition) : Checks if a condition is true
//		assertNotNull(object) : Checks if object is not null
//		assertThrows(exppectedException, executable) : Verify that a specific exception is thrown
//		
//	Assumptions: 
//		skip tests under certain conditions
//		Assumptions.assumeTrue(...)
//	
//	Junit suite test:
//		run a group of test classes together as one suite
//		logical groupings, integration test sets
//		Junit5 -> 2Suite
//		
//	Junit parameterized test:
//		run same test logic with multiple inputs. Reduces duplication and edge cases
//	Junit orives @ParametrizedTest - @ValueSource @MethodSource
//	define input set, the test run once per input, assert expect outcome per input
//		
//		
//	Junit test runners: Junit includes test runners responsible for executing test cases and reporting
//	
//	early bug detection:
//		improved code quality and maintenance
	
}
