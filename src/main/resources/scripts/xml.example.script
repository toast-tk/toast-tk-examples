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
|  @service:xml-adapter Integrate *$xmlFlux* |
| *$xmlFlux* equal to *$expected*|