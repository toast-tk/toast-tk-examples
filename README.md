# Toast-tk examples

This project contains example test files for Toast-tk framework

## Starting toast-tk examples

Clone toast-tk-example repository

``` bash
git clone https://github.com/synaptix-labs/toast-tk-examples.git
cd toast-tk-examples
```

Import the project in your IDE (as a maven project).
 
### Run a test set
Run `fr.synaptix.toast.examples.project.CIProjectRunner.java`. This class runs the test campaigns described in `project1.test`.

The test report will automatically be opened in your browser when the tests examples are executed.
This report is generated in the project folder, under `/target/toast-test-results/Project_report.html`.

[REPORT IMAGE]

### Run tests files individually

To run the web test, start `fr.synaptix.toast.examples.project.WebExampleRunner.java`.
The test report will automatically be opened in your browser after execution.

[REPORT IMAGE]


## The test files
### Campaign

The campaign file describes which test files must be run.
Here, the campaign's name is "TNR v1.0", and contains the files `json.example.script`,`service.example.script`, and `xml.example.script`.

``` 
|| campaign || TNR v1.0 ||
| Test json    | ../scripts/json.example.script    |
| Test service | ../scripts/service.example.script |
| Test xml     | ../scripts/xml.example.script     |
``` 

### Scripts

#### Web

Test actions on a web page.

``` 
h1. Description des pages

|| auto setup ||
| web page | GoogleSearchPage |
| name   | type  | locator | method | position |
| search | input | lst-ib  | ID     | 0        |

h1. login scenario

|| scenario || web ||
|Open browser at *http://www.google.com*|
|Type *test* in *GoogleSearchPage.search*|
``` 

1. Declare a new web page: `GoogleSearchPage`
2. Describe widgets for this web page: `search`
3. Comments will be ignored when running the test
4. Create a scenario of type web.
5. Step: open the browser at www.google.com
6. Type *test* in the widget *search* in the page *GoogleSearchPage*

#### Json

``` 
$fluxJson:="""
{
 "id": "100",
 "name" : "projet",
  "status" : "1"
}
"""

|| scenario || service ||
| @service:json-adapter Integrate *$fluxJson* |
``` 

1. Puts json data in the variable `$fluxJson`.
2. Creates a scenario (of type service).
3. First test step: process the json data.

#### Service

``` 
# Http Service Example
$jsonToPost:="""
{
	"name": "user1",
	"password": "user1_pwd" 
}
"""
$url:=https://www.google.com

|| scenario || service ||
| GET *https://www.google.com* |
| POST *$jsonToPost* to *$url* |
``` 

TODO



#### Xml

``` 
$xmlFlux:="""
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<projet id="100">
    <status>1</status>
    <name>projet</name>
</projet>
"""

$expected:="""
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<projet id="100">
    <status>20</status>
    <name>projet</name>
</projet>
"""

|| scenario || service ||
| @service:xml-adapter Integrate *$fluxXml* |
| *$xmlFlux* equal to *$expected*           |
``` 

TODO