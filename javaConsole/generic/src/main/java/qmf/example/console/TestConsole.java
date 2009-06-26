package qmf.example.console ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.qpid.console.MethodResult;
import org.apache.qpid.console.QMFObject;
import org.apache.qpid.console.Session;
import org.apache.qpid.console.XMLUtil;

public class TestConsole
{
    public static void main(String args[]) throws Exception
    {
        Session session = new Session();
        session.addBroker("amqp://guest:guest@/?brokerlist='tcp://localhost'");
        HashMap<String, Object> qParams = new HashMap<String, Object>();
        qParams.put("_class", "ExampleService");
        qParams.put("_package", "qmf.example.ejb");
        ArrayList<QMFObject> objs = session.getObjects(qParams);
        QMFObject service = objs.get(0);
        MethodResult result = service.invokeMethod("getBase", "Nathan",
                "A Cool Dude");
        QMFObject baseObject = (QMFObject) result.getReturnValue("result");
        System.out.println(String.format("Base: %s", baseObject));
        System.out.println(String.format("Base.name: %s", baseObject
                .getProperty("name")));
        System.out.println(String.format("Base.description: %s", baseObject
                .getProperty("description")));
        System.out.println(String.format("Base.stuff: %s", baseObject
                .getProperty("stuff")));
        result = service.invokeMethod("getDerived", "Gillian",
                "A Cool Dudette", 99);
        QMFObject derivedObject = (QMFObject) result.getReturnValue("result");
        System.out.println(String.format("Derived: %s", derivedObject));
        System.out.println(String.format("Derived.name: %s", derivedObject
                .getProperty("name")));
        System.out.println(String.format("Derived.description: %s",
                derivedObject.getProperty("description")));
        System.out.println(String.format("Derived.stuff: %s", derivedObject
                .getProperty("stuff")));
        System.out.println(String.format("Derived.count: %s", derivedObject
                .getProperty("count")));
        result = service.invokeMethod("findMany");
        List<Object> many = (List<Object>) result.getReturnValue("result");
        System.out.println(String.format("Many: %s", many));
        System.out.println(String.format("Many.stuff: %s", ((QMFObject) many
                .get(0)).getProperty("stuff")));
        
         String[] packages = {"qmf.example", "qmf.example.ejb"} ;
         System.out.println(XMLUtil.schemaXML(session, packages)) ;
       
        Thread.sleep(1000);
        session.close();
    }
}
