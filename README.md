# Halo-project

Web UI test automation framework using Selenium, Cucumber, and TestNG.

## Prerequisites

### 1. Install JDK 21 https://jdk.java.net/archive/

Verify the installation on console:```java -version```

### 2. Install Maven 3.9+ https://maven.apache.org/install.html

Verify the installation on console:```mvn -version```

### 3. Google Chrome

A recent version of Google Chrome must be installed. Selenium Manager will automatically download the matching ChromeDriver using dynamic fetching implemented in the latest versions.

## Setup

Clone the repository and install dependencies:

```git clone https://github.com/sanflg/halo-project.git```

```mvn clean install -DskipTests```

## Running tests

Run the full test suite via the TestNG XML: ```mvn test```

## Parameters

| Name                          | Function                                                                     | Options                     | Default      |
|-------------------------------|------------------------------------------------------------------------------|-----------------------------|--------------|
| ```browser```                 | browser to use in the execution (currently *chrome* and *firefox* supported) | ```chrome```, ```firefox``` | ```chrome``` |
| ```dataproviderthreadcount``` | number of max threads supported for execution                                | ```1```, ```2```...         | ```2```      |
| ```maximize```                | driver maximization for current window executed in the thread                | ```true```, ```false```     | ```true```   |
| ```headless```                | used to control headless execution in order to avoid resources consumption   | ```true```, ```false```     | ```false```  |
| ```timeout```                 | default timeout used for all drivers creation in seconds                     | ```1```, ```2```...         | ```5```      |

```mvn test -Dbrowser=chrome -Ddataproviderthreadcount=2 -Dmaximize=true -Dheadless=false -Dtimeout=5 ```

## Allure

1. For automatic installation of allure go to https://allurereport.org/docs/v2/install/

2. For manual installation go to https://github.com/allure-framework/allure2/releases and download ```Allure 2.36.0``` tar or zip and set the environment variable to the bin folder.

restart all cmd's to have the new index bin

After one execution of the project, run ```allure serve target/allure-results``` and a page with the test results will appear

## Notes, observations and improvement points

1. **ON PARAMETERS**: Right now headless is more unstable but checking that would require further debugging, same happens with no maximize since that would require another scenario validating a sandwich header menu dropdown.
2. **UGLY ERROR ON CONSOLE**: Currently the project has an error each time a deckPage is initialized bcs I didn't set the page id correctly on the DeckPage Class, this would need dynamic fetching from DOM previously. This does not break the tests but is annoying in console and logger.