from qmf.console import Session
from qmf.console import ClassKey
from qpid.log import enable, DEBUG
import sys

s = Session()
br = s.addBroker()
service = s.getObjects(_class="ExampleService", _package="qmf.example.ejb")[0]

print "Service Methods"
print service.getMethods()

base = service.getBase("Nathan", "A Cool Dude").result
print "Base: ", base
print "Base.name: ", base.name
print "Base.description: ", base.description
print "Base.stuff: ", base.stuff

derived = service.getDerived("Gillian", "A Cool Dudette", 99).result
print "Derived: ", derived
print "Derived.name: ", derived.name
print "Derived.description: ", derived.description
print "Derived.stuff: ", derived.stuff
print "Derived.count: ", derived.count

many = service.findMany().result
print "Many: ", many
print "Many[0].stuff", many[0].stuff
