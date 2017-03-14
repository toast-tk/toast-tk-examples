#include soa.properties

# a remplir par un appel sql
$circulation_name:=code_cir
$sql_request:="""
	select id from t_circulation
	where
	name='$circulation_name'
"""
$idCirculation_1:=tota
$idCirculation_2:=tato
$idComplex:=$idCirculation:$idCirculation_1:$idCirculation_2

# input: un exel avec urls
# donnée des urls dans une base de donnée

|| scenario || service ||
| echo *$database.uri* |
| run the following sql request *$sql_request*| $idCirculation |
| echo *$idCirculation* | $idCirculation |
| echo *$idComplex* |
