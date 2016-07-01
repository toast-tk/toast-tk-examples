# Simple assert example
|| scenario || service ||
| *toto* = *titi* |
| *toto* = *toto* |	
| *1* and *2* | 3 |
| *1* and *2*| 2 |

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

# fail fatal assert 
|| scenario || service ||
| assert *toto* equals *toto* |
| assert *toto* equals *tata* |	
| ! assert *toto* equals *titi* |
| assert *toto* equals *toto* |	