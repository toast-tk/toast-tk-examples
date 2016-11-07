#include /Users/blackbox/git/toast-tk-sample/toast-tk-examples/src/main/resources/settings/toast_web_repository.txt

h1. Name:BLOC_2_clavier_Prevision_flux_aupgc
#scenario id:BSONObjectID("555da1450e7ea83143e68c65")
#scenario driver:connecteurSwing
|| scenario || swing ||
|[{"patterns":"@service ExecuteService *previsions.findTnrFluxPourPrevision* IN $$flux FOR *30/11/2015;06/12/2015;V;AUPGC;1*","kind":"service","mappings":[]},{"patterns":"@service ExecuteService *previsions.findTnrFluxPourPrevisionJour* IN $$jour FOR *$flux;30/11/2015;06/12/2015;V;1*","kind":"service","mappings":[]},{"patterns":"Saisir {{value:string}}","kind":"swing","mappings":[{"id":"0","val":"1","pos":0}]},{"patterns":"Click on {{component:swing}}","kind":"swing","mappings":[{"id":"55268791e5637a9400a0b9cd","val":"GestionPrevisionPanel.Rafraichir","pos":0}]},{"patterns":"Stocker dans $$previhm la valeur du flux $flux dans *gestionDesPrevisions* au $jour","kind":"swing","mappings":[]},{"patterns":"$previhm égale à *1*","kind":"swing","mappings":[]}]|