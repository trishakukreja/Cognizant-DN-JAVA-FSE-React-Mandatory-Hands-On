//can be directly added inside the existing MyServiceTest.java class created in Exercise 1
@Test
    public void testVerifyInteraction() {
        // Step 1: Create a mock object
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        // Step 2: Call the method that triggers the interaction
        service.fetchData();

        // Step 3: Verify the interaction happened exactly once
        verify(mockApi).getData();
    }
