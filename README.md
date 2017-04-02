# GameOfLifeAPI
A api to provide game of life information




 .--.                                .--.  .-.    _  .--.    
: .--'                              : .-'  : :   :_;: .-'    
: : _  .--.  ,-.,-.,-. .--.    .--. : `;   : :   .-.: `;.--. 
: :; :' .; ; : ,. ,. :' '_.'  ' .; :: :    : :__ : :: :' '_.'
`.__.'`.__,_;:_;:_;:_;`.__.'  `.__.':_;    :___.':_;:_;`.__.'

Author:Qun Chen
_________________________________________________________________
Read Me
_________________________________________________________________

0. system requirement
java 8u121
groovy 2.4.9
grails 3.2.7
if any not installed 
1. install sdkman http://sdkman.io/install.html
2. install grails $sdk install grails 3.2.7

1. Run application

$grails run-app

2.API 
localhost:8123/patterns 
localhost:8123/patterns/{id} 
localhost:8123/patterns/{id}/generations 
localhost:8123/patterns/{id}/generation?step={step} 

3.Usage
example:
get the 3rd iteration of blinker pattern
localhost:8123/patterns/3/generation?step=3

4. Test application 
$grails test-app 
Or
$grails test-app -unit
$grails test-app -integration

test report location: /game-of-life/build/reports/tests/index.html
