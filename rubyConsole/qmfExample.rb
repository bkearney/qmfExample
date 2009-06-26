#!/usr/bin/ruby

require "qpid"

s = Qpid::Qmf::Session.new()
b = s.add_broker("amqp://guest:guest@localhost:5672")
service = s.objects(:class => "ExampleService", :package => "qmf.example.ejb")[0]

base = service.getBase("Nathan", "A Cool Dude").result
puts "Base: " << base.to_s
puts "Base.name: " << base.name
puts "Base.description: " << base.description
puts "Base.stuff: " << base.stuff.to_s

derived = service.getDerived("Gillian", "A Cool Dudette", 99).result
puts "Derived: " << derived.to_s
puts "Derived.name: " << derived.name
puts "Derived.description: " << derived.description
puts "Derived.stuff: " << derived.stuff.to_s
puts "Derived.count: " << derived.count.to_s

many = service.findMany().result
puts "Many: ", many
puts "Many[0].stuff", many[0].stuff
