### Tools:
`Java, Maven, TestNG, Selenium WebDriver, Cucumber`

### To run tests:
`mvn clean test -Dbrowser=chrome`

Workflow:
1. Navigate to https://cp.pt
2. Search for the train from Lagos to Porto - Campanha. Select towards date: Today + 3 days. Select backwards date: Today + 6 days. Select 1st Class / Comfort for 3 Passengers. Save these options.
3. Observe search result and select Continue. Login page should appear.
4. Select Cancel on the login page. Main home page should appear.
5. Validate that all search options are correctly saved (From: Lagos. To: Porto - Campanha. Correct selected date. Correct class and the number of passengers)

### To run tests:
`mvn clean test -Dbrowser=chrome`
