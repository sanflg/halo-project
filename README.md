# Halo-project

Web UI test automation framework using Selenium, Cucumber, and TestNG.

## Prerequisites

### 1. Install JDK 21 https://jdk.java.net/archive/

Verify the installation on console:```java -version```

### 2. Install Maven 3.9+ https://maven.apache.org/install.html

Verify the installation on console:```mvn -version```

### 3. Browser

A recent version of Google Chrome or Firefox must be installed. Selenium Manager will automatically download the matching ChromeDriver or GeckoDriver using dynamic fetching implemented in the latest versions. Just check that you are executing with the run option of an installed browser.

### 4. Repo Setup

Clone the repository and install dependencies:

```git clone https://github.com/sanflg/halo-project.git```

```mvn clean install -DskipTests```

### 5. Running tests

Run the full test suite via the TestNG XML: ```mvn test```

### 6. Parameters

| Name                          | Function                                                                     | Options                     | Default      |
|-------------------------------|------------------------------------------------------------------------------|-----------------------------|--------------|
| ```browser```                 | browser to use in the execution (currently *chrome* and *firefox* supported) | ```chrome```, ```firefox``` | ```chrome``` |
| ```dataproviderthreadcount``` | number of max threads supported for execution                                | ```1```, ```2```...         | ```2```      |
| ```maximize```                | driver maximization for current window executed in the thread                | ```true```, ```false```     | ```true```   |
| ```headless```                | used to control headless execution in order to avoid resources consumption   | ```true```, ```false```     | ```false```  |
| ```timeout```                 | default timeout used for all drivers creation in seconds                     | ```1```, ```2```...         | ```5```      |

```mvn test -Dbrowser=chrome -Ddataproviderthreadcount=2 -Dmaximize=true -Dheadless=false -Dtimeout=5 ```

### 7. Allure

1. For automatic installation of allure go to https://allurereport.org/docs/v2/install/

2. For manual installation go to https://github.com/allure-framework/allure2/releases and download ```Allure 2.36.0``` tar or zip and set the environment variable to the bin folder.

restart all cmd's to have the new index bin

After one execution of the project, run ```allure serve target/allure-results``` and a page with the test results will appear
____
## Notes, observations and improvement points

1. **ON PARAMETERS**: Right now headless is more unstable but checking that would require further debugging, same happens with no maximize since that would require another scenario validating a sandwich header menu dropdown.
2. **UGLY ERROR ON CONSOLE**: Currently the project has an error each time a deckPage is initialized bcs I didn't set the page id correctly on the DeckPage Class, this would need dynamic fetching from DOM previously. This does not break the tests but is annoying in console and logger.

____
## Tools selected

### Java
It has one of the most completes tools available currently, with a lot of solutions examples and long threads of discussions compared to any other language.
It is the language that I'm more proficient with, this helped to avoid wasting time on minor problems and jump directly to the most interesting parts of the solution.

### Testng
It has compatibility with Junit syntax, allowing us to have the most complete options over test management with a huge testing code base on web about it.

### Selenium
No competition, is the best web automation framework for java right now.

### Maven
Easier and well known syntax compared to competence like gradle.

### Log4j2
Fast and simple logging tool, works just setting a .properties file and calling the logger.

### Cucumber
Required by instructions.

### Lombok & Aeonbits-owner
Less boilerplate code with no hardcoded strings or methods.

### Allure
Very good open source reporting tool that has integration with common CI-CD tools like jenkins.
____
## Case selection
1. Search
   * Is a common case in most pages. 
   * Test the mode of search (in this case lexical).
   * It requires text input, button click, response wait and get an array of result elements.

2. Deck submitted by user
    * Requires hierarchical interactions with dropdown.
    * Dynamic building of web elements depending on results of current page state.
    * Validate the flow with a resulting property of a selected dynamically selected object by index.
