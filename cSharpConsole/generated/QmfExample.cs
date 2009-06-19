using System;
using System.Collections.Generic ;
using System.Xml;
using System.IO;
using org.apache.qpid.console;
using qmf.example ;
using qmf.example.ejb ;
using log4net;
using log4net.Config;

namespace qmf.example
{
	public class QMFExample
	{
		
		public QMFExample()
		{
		}
		

		public static void Main(string[] args) {
			XmlConfigurator.Configure(new FileInfo("./log.xml"));
			ILog log = LogManager.GetLogger(typeof(QMFExample)) ;			
			log.Debug("Starting") ;
            Console myConsole = new qmf.example.Console() ;
			Session session = new Session(myConsole) ;
			session.AddBroker("amqp://localhost") ;
			
			Dictionary<string, object> options = new Dictionary<string, object>() ;
			options.Add("_class", "ExampleService") ;
			options.Add("_package", "qmf.example.ejb") ;
			ExampleService service = (ExampleService) session.GetObjects(options)[0] ;

            BaseClass baseObject = service.GetBase("Nathan", "A Cool Dude") ;
			System.Console.WriteLine(String.Format( "Base: {0}", baseObject));
			System.Console.WriteLine(String.Format( "Base.name: {0}", baseObject.Name));
			System.Console.WriteLine(String.Format( "Base.description: {0}", baseObject.Description));
			System.Console.WriteLine(String.Format( "Base.stuff: {0}", baseObject.Stuff));
			
			DerivedClass derivedObject = service.GetDerived("Gillian", "A Cool Dudette", 99) ;
			System.Console.WriteLine(String.Format( "Derived: {0}", derivedObject));
			System.Console.WriteLine(String.Format( "Derived.name: {0}", derivedObject.Name));
			System.Console.WriteLine(String.Format( "Derived.description: {0}", derivedObject.Description));
			System.Console.WriteLine(String.Format( "Derived.stuff: {0}", derivedObject.Stuff));			
			System.Console.WriteLine(String.Format( "Derived.count: {0}", derivedObject.Count));		
			
			List<object> many = (List<Object>) service.FindMany() ;
			System.Console.WriteLine("Many: {0}", many) ;
			System.Console.WriteLine("Many.stuff: {0}", ((BaseClass)many[0]).Stuff) ;			
				
			string[] packages = {"qmf.example", "qmf.example.ejb"} ;
			System.Console.WriteLine(XMLUtil.SchemaXML(session, packages)) ;
			session.Close() ;
		}
	}
}
