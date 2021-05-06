# Automation Framework #

**Environment**  
***Platform***: Linux/MacOS/Windows  
***Java***: 11  
***Maven***: 3.8.1  
***Docker***: 19.03.8  

**Frameworks/Libraries**  
***Selenide***: 5.20.4 - WebDriver  
***Selenoid***: 1.10.3 - Hub  
***Selenoid-UI***: 1.10.3 - Selenoid UI  
***TestNG***: 7.4.0 - Testing Framework  
***ReportPortal***: 5.3.5 - Reporting

Stack:  
- Selenide (test automation framework)  
- Selenoid (Hub)  
- TestNG (testing framework)  
- Maven (project management tool)  
- ReportPortal (reporting tool)  

```
 ├─── .github  
 │    └─── workflows  
 │         └─── main.yml  
 ├─── build  
 │    └─── reports  
 │         └─── tests  
 ├─── config  
 │    └─── browsers.json  
 ├─── src  
 │    ├─── main  
 │    │    ├─── java  
 │    │    │    ├─── automation.builders  
 │    │    │    │    └─── **/*Builder.java  
 │    │    │    ├─── automation.entities  
 │    │    │    │    ├─── browser
 │    │    │    │    │    ├─── Browser.java
 │    │    │    │    │    ├─── ChromeBrowser.java  
 │    │    │    │    │    └─── FirefoxBrowser.java  
 │    │    │    │    └─── **/**.java  
 │    │    │    ├─── automation.enums  
 │    │    │    │    └─── **/**.java  
 │    │    │    ├─── automation.forms  
 │    │    │    │    └─── **/*Form.java  
 │    │    │    ├─── automation.pages  
 │    │    │    │    └─── **/*Page.java  
 │    │    │    └─── com.d3m0.automation.utils  
 │    │    │         ├─── BaseTest.java  
 │    │    │         ├─── LoadingPageFactory.java  
 │    │    │         ├─── MyListener.java  
 │    │    │         └─── Verify.java  
 │    │    └─── resources  
 │    │         ├─── log4j2.xml  
 │              └─── reportportal.properties    
 │    └─── test  
 │         ├─── java  
 │         │    └─── testcases
 │         │         └─── **/*Test.java  
 │         └─── resources  
 │              └─── testng.xml  
 ├─── .gitignore  
 ├─── docker-compose.yml  
 ├─── pom.xml  
 ├─── README.md  
 └─── update_browsers.sh  
```

**Installation**    
1. Clone project.  
2. Make sure you have recent [Docker](https://www.docker.com/) installed.  
3. Browsers that will be used described in _config/browsers.json_. Chrome and Firefox images included into _docker_compose.yml_. If you need to update browsers, edit _config/browsers.json_ (instructions could be found [here](https://aerokube.com/selenoid/latest/#_browsers_configuration_file), list of available images is [here](https://aerokube.com/selenoid/latest/#_browser_image_information)). Download browser images manually (`docker pull image` where `image` specified in _config/browsers.json_) or automatically using [jq](https://stedolan.github.io/jq/download/) tool. See execution command in _update_browsers.sh_.  
4. If you're running docker on Windows, be sure to update _docker-compose.yml_ (uncomment Windows-related `postgres.volumes` section and `volumes` at the end of the file) for correct ReportPortal work.  
5. Run `docker-compose up --force-recreate -d` to start Selenoid, Selenoid UI and ReportPortal.  
  
**Execution**    
1. If you want to use Selenoid as a hub, update `selenoid.hub.address` in _pom.xml_ with your actual IP address (`docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' container_name_or_id`). If you want to use built-in WebDriverManager just set parameter `selenoid.enabled` to false.  
2. Edit _source/test/resources/testng.xml_ to include or exclude your test-cases.  
3. Setup RP:  
   - navigate to ReportPortal instance (by default [http://localhost:8080](http://localhost:8080))  
   - login as administrator (superadmin/erebus)  
   - click on arrow menu icon in a top-right corner and select Administrate  
   - click Add New Project button  
   - set name of your project and all other settings  
   - click Back to Project button in top-right corner  
   - select your newly created project from dropdown in top-left corner  
   - select Profile from dropdown in top-right corner  
   - copy configuration properties to your _reportportal.properties_  
4. Run `mvn test` command to execute whole suite.  
  
**Results**    
- to check in-browser execution, navigate to your Selenoid-UI instance (e.g. [localhost:8090](http://localhost:8090))  
- to check reports, navigate to ReportPortal instance (e.g. [localhost:8080](http://localhost:8080))  
