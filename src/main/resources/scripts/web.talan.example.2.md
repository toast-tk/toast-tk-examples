|| setup || web || Jobs ||
| name | type | locator | method | position | 
| jobsList | select | .sf-field-post-meta-metier .sf-input-select | CSS | 0 |
| name | input | .nom .wpcf7-validates-as-required | CSS | 0 |
| job | component:Job | .fusion-portfolio-content | CSS | 0 |

|| setup || web || Job ||
| name | type | locator | method | position | 
| title | link | .entry-title a | CSS | 0 |

|| scenario || web ||
|Open browser at *http://www.talan.fr/en/jobs3/*|
|Count *Jobs.job*|
|Select the *5*th *Jobs.job* as *$myJob*|
|Click on *$myJob.title*|