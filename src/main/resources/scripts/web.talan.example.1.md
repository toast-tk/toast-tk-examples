|| setup || web || Jobs ||
| name | type | locator | method | position | 
| name | input | #search_keywords | CSS | 0 |
| job | component:Job | .job_listing | CSS | 0 |

|| setup || web || Job ||
| name | type | locator | method | position | 
| title | other | .position h3 | CSS | 0 |

$search:=Developer

|| scenario || web ||
|Open browser at *https://carriere.talan.com/en/job-offers/*|
|Wait for *5* seconds|
|Type *$search* in *Jobs.name*|
|Wait for *2* seconds|
|Click on *Jobs.job.title*|