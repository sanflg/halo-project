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

## Running the tests with options

Run the full test suite via the TestNG XML: ```mvn test -Dbrowser=chrome -Ddataproviderthreadcount=1```

## Parameters

| Name                          | Function                                                                     | Options                     | Default      |
|-------------------------------|------------------------------------------------------------------------------|-----------------------------|--------------|
| ```browser```                 | browser to use in the execution (currently *chrome* and *firefox* supported) | ```chrome```, ```firefox``` | ```chrome``` |
| ```dataproviderthreadcount``` | number of max threads supported for execution                                | ```1```, ```2```...         | ```2```      |
| ```maximize```                | driver maximization for current window executed in the thread                | ```true```, ```false```     | ```true```   |
| ```headless```                | used to control headless execution in order to avoid resources consumption   | ```true```, ```false```     | ```false```  |
| ```timeout```                 | default timeout used for all drivers creation in seconds                     | ```1```, ```2```...         | ```5```      |

```mvn test -Dbrowser=chrome -Ddataproviderthreadcount=1 -Dmaximize=false -Dheadless=false -Dtimeout=20```

Right now headless is more unstable but checking that would require further debugging and I don't have too much time, same happens with no maximize since that would require another scenario validating a sandwich header menu dropdown.
