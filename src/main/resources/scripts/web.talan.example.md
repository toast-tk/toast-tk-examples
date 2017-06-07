|| setup || web || Jobs ||
| name | type | locator | method | position | 
| name | input | #search_keywords | CSS | 0 |
| job | component:Job | .job_listing | CSS | 0 |

|| setup || web || Job ||
| name | type | locator | method | position | 
| title | link | .position h3 | CSS | 0 |

|| scenario || web ||
|Open browser at *https://carriere.talan.com/en/job-offers/*|
|Upload my word document *MyDoc*|
|With *Jobs.job* as *$myJobs*|
|Count *$myJobs*|
|Select the *4*th *$myJobs* as *$myJob*|
|Wait for *2* seconds|
|Click on *$myJob.title*|
|Wait for *2* seconds|
|Click on *$myJob.title*|