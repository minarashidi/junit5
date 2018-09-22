#### JUnit 5
JUnit is one of the most popular unit-testing frameworks in the Java ecosystem.

In this POC, I showcase some important features of unit testing with junit 5.

1. how to setup junit 5; as we know JUnit 5 is composed of several different modules,so we need to add the following modules:

 * JUnit Platform - we can run our tests with JUnit Platform
 * JUnit Jupiter

    This module includes new programming and extension models for writing tests in JUnit 5.
    New annotations in comparison to JUnit 4 are:

    * @TestFactory – denotes a method that is a test factory for dynamic tests
    * @DisplayName – defines custom display name for a test class or a test method
    * @Nested – denotes that the annotated class is a nested, non-static test class
    * @Tag – declares tags for filtering tests
    * @ExtendWith – it is used to register custom extensions
    * @BeforeEach – denotes that the annotated method will be executed before each test method (previously @Before)
    * @AfterEach – denotes that the annotated method will be executed after each test method (previously @After)
    * @BeforeAll – denotes that the annotated method will be executed before all test methods in the current class (previously @BeforeClass)
    * @AfterAll – denotes that the annotated method will be executed after all test methods in the current class (previously @AfterClass)
    * @Disable – it is used to disable a test class or method (previously @Ignore)


2. Parameterized tests
 with parameterized tests we can run the same test several times using different values
 it helps us to remove boiler plate test code and also saves time while writing test codes.

    * Annotate the test class; @RunWith(Parameterized.class)
    * Define test data; a static method annotated with @Parameters that returns test data.
    * Define variables to store the test data and read it
    * Use tests data in tests

    Here I use Parameterized test for validating email address

3. Theories
 In a parameterized test, the test data elements are statically defined, but if we want to test our functions
 for some wider range of input values and make our test more general

   * Annotate the test class; @RunWith(Theories.class)
   * a theory is annotated with @Theory, not @Test; and a theory method has parameters.
   * Define test data; @DataPoint or @DataPoints ; they should declared public and static

    In EmailAddressCreatorTest, I show how we can use it.


