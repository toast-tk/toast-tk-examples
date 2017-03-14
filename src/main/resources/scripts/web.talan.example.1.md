|| setup || web || Jobs ||
| name | type | locator | method | position | 
| jobsList | select | .sf-field-post-meta-metier .sf-input-select | CSS | 0 |
| name | input | #search_keywords | CSS | 0 |
| job | component:Job | .job_listings | CSS | 0 |

|| setup || web || Job ||
| name | type | locator | method | position | 
| title | link | .position h3 | CSS | 0 |

$name := Foo Baz

|| scenario || web ||
|Open browser at *https://carriere.talan.com/en/job-offers/*|
|Type *Foo Bar* in *Jobs.name*|
|Type *$name* in *Jobs.name*|
|Select *4* in *Jobs.jobsList*|
|Click on *Jobs.job.title*|