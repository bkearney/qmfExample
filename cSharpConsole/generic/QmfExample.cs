using System;
using System.Collections.Generic ;
using System.Xml;
using System.IO;
using org.apache.qpid.console;
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
			Session session = new Session() ;
			session.AddBroker("amqp://localhost") ;
			
			Dictionary<string, object> options = new Dictionary<string, object>() ;
			options.Add("_class", "ExampleService") ;
			options.Add("_package", "qmf.example.ejb") ;
			QMFObject service = session.GetObjects(options)[0] ;
			
			MethodResult result = service.InvokeMethod("getBase", "Nathan", "A Cool Dude") ;
			QMFObject baseObject = (QMFObject) result.GetReturnValue("result") ;	
			
			System.Console.WriteLine(String.Format( "Base: {0}", baseObject));
			System.Console.WriteLine(String.Format( "Base.name: {0}", baseObject.GetProperty("name")));
			System.Console.WriteLine(String.Format( "Base.description: {0}", baseObject.GetProperty("description")));
			System.Console.WriteLine(String.Format( "Base.stuff: {0}", baseObject.GetProperty("stuff")));
			
			result = service.InvokeMethod("getDerived", "Gillian", "A Cool Dudette", 99) ;
			QMFObject derivedObject = (QMFObject) result.GetReturnValue("result") ;	
			
			System.Console.WriteLine(String.Format( "Derived: {0}", derivedObject));
			System.Console.WriteLine(String.Format( "Derived.name: {0}", derivedObject.GetProperty("name")));
			System.Console.WriteLine(String.Format( "Derived.description: {0}", derivedObject.GetProperty("description")));
			System.Console.WriteLine(String.Format( "Derived.stuff: {0}", derivedObject.GetProperty("stuff")));			
			System.Console.WriteLine(String.Format( "Derived.count: {0}", derivedObject.GetProperty("count")));		
			
			result = service.InvokeMethod("findMany") ;
			List<Object> many = (List<Object>) result.GetReturnValue("result") ;
			System.Console.WriteLine("Many: {0}", many) ;
			System.Console.WriteLine("Many.stuff: {0}", ((QMFObject)many[0]).GetProperty("stuff")) ;			
				
			string[] packages = {"qmf.example", "qmf.example.ejb"} ;
			System.Console.WriteLine(XMLUtil.SchemaXML(session, packages)) ;
			session.Close() ;
		}
	}
}
