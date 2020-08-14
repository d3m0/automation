# Automation Framework #

**Environment**  
***Platform***: Linux/MacOS/Windows  
***Java***: 11  
***Maven***: 3.6.3  
***Docker***: 19.03.8  

**Frameworks/Libraries**  
***Selenide***: 5.13.0 - WebDriver  
***Selenoid***: 1.10.0 - Selenium Hub  
***Selenoid-UI***: 1.10.0 - Selenoid UI  
***TestNG***: 7.1.0 - Testing Framework  
***ReportPortal***: 5.1.0 - Reporting

Stack:  
- Selenide (test automation framework)  
- Selenoid (Selenium Hub)  
- TestNG (testing framework)  
- Maven (project management tool)  
- ReportPortal (reporting tool)  

```
 ├─── build  
 │    └─── reports  
 │         └─── tests  
 ├─── config  
 │    └─── browsers.json  
 ├─── src  
 │    ├─── main  
 │    │    ├─── java  
 │    │    │    ├─── builders  
 │    │    │    │    └─── **/*Builder.java  
 │    │    │    ├─── entities  
 │    │    │    │    └─── **/**.java  
 │    │    │    ├─── enums  
 │    │    │    │    └─── **/**.java  
 │    │    │    ├─── forms  
 │    │    │    │    └─── **/*Form.java  
 │    │    │    ├─── pages  
 │    │    │    │    └─── **/*Page.java  
 │    │    │    └─── utils  
 │    │    │         ├─── BaseTest.java  
 │    │    │         ├─── CapabilitiesManager.java  
 │    │    │         ├─── LoadingPageFactory.java  
 │    │    │         ├─── MyListener.java  
 │    │    │         ├─── OptionsManager.java  
 │    │    │         └─── Verify.java  
 │    │    └─── resources  
 │    │         └─── log4j2.xml  
 │    └─── test  
 │         ├─── java  
 │         │    └─── testcases
 │         │         └─── **/*Test.java  
 │         └─── resources  
 │              ├─── reportportal.properties    
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
3. Edit _config/browsers.json_ (instructions could be found [here](https://aerokube.com/selenoid/latest/#_browsers_configuration_file), list of available images is [here](https://aerokube.com/selenoid/latest/#_browser_image_information)).  
4. Download browser images manually (`docker pull image` where `image` specified in _config/browsers.json_) or automatically using [jq](https://stedolan.github.io/jq/download/) tool. See execution command in _update_browsers.sh_.  
5. If you're running docker on Windows, be sure to update _docker-compose.yml_ (uncomment Windows-related `postgres.volumes` section and `volumes` at the end of the file) for correct ReportPortal work.  
6. Run `docker-compose up --force-recreate -d` to start Selenoid, Selenoid UI and ReportPortal.  
  
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
