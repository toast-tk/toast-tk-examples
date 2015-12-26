# Toast-tk examples

This project contains example test files for Toast-tk framework

## Starting toast-tk examples

Clone toast-tk-example repository

``` bash
git clone https://github.com/synaptix-labs/toast-tk-examples.git
cd toast-tk-examples
```

Import the project in your IDE as a maven - java 8 project.
 
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

Test actions on a web page using selenium.

``` 
h1. Description des pages

|| auto setup || web page || GoogleSearchPage ||
| name   | type  | locator | method | position |
| search | input | lst-ib  | ID     | 0        |

h1. google search scenario

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

#### Mapping action with custom sentences

Toast engine comes with a set of predefined sentences to easy web browser automation.  
These sentences are defined in the "AbstractWebActionAdapter" class from which "SimpleWebActionAdapter" currently inherits.  
The current example show how we can map custom sentences to predefined one based on the action id.  
The file toast.yml contains mappings for the different sentences defined in the "AbstractWebActionAdapter", using yaml syntax:

``` 
default-web-driver:
  - navigate: Naviguer vers $1 
  - type_in_web_component: Saisir $1 dans $2 
  - click_on_web_component: Cliquer sur $1 
  - select_in_web_component: Selectionner $1 dans $2 
  - web_component_exists: Le composant $1 existe 
  - close_browser: Fermer le navigateur
...
```

Within the "web.example.fr.script" we are currently doing the same scenario as the previous one, except that we currently call our custom sentences instead of predefined one.

```
...
Same init
...

|| scenario || web ||
|Naviguer vers *http://www.google.com*| -> processed the same as -> Open browser at *http://www.google.com*
|Type *test* in *GoogleSearchPage.search*| -> processed the same as -> Type *test* in *GoogleSearchPage.search*
``` 

#### Service

API testing

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
