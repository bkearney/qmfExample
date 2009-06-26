package qmf.example.console ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import qmf.example.BaseClass ;
import qmf.example.DerivedClass ;
import qmf.example.ejb.ExampleService ;
import org.apache.qpid.console.MethodResult;
import org.apache.qpid.console.QMFObject;
import org.apache.qpid.console.Session;
import org.apache.qpid.console.XMLUtil;

public class TestConsole
{
    public static void main(String args[]) throws Exception
    {
        qmf.example.Console myConsole = new qmf.example.Console() ;
        Session session = new Session(myConsole);
        session.addBroker("amqp://guest:guest@/?brokerlist='tcp://localhost'");
        HashMap<String, Object> qParams = new HashMap<String, Object>();
        qParams.put("_class", "ExampleService");
        qParams.put("_package", "qmf.example.ejb");
        ArrayList<QMFObject> objs = session.getObjects(qParams);
        
        ExampleService service = (ExampleService) objs.get(0);
        BaseClass baseObject = service.getBase("Nathan", "A Cool Dude");
        System.out.println(String.format("Base: %s", baseObject));
        System.out.println(String.format("Base.name: %s", baseObject.getName()));
        System.out.println(String.format("Base.description: %s", baseObject.getDescription())) ;
        System.out.println(String.format("Base.stuff: %s", baseObject.getStuff())) ;


        DerivedClass derivedObject = service.getDerived("Gillian","A Cool Dudette", 99);        
        System.out.println(String.format("Derived: %s", derivedObject));
        System.out.println(String.format("Derived.name: %s", derivedObject.getName())) ;
        System.out.println(String.format("Derived.description: %s", derivedObject.getDescription()));
        System.out.println(String.format("Derived.stuff: %s", derivedObject.getStuff()));
        System.out.println(String.format("Derived.count: %s", derivedObject.getCount()));
        
        List<Object> many = service.findMany() ;
        System.out.println(String.format("Many: %s", many));
        System.out.println(String.format("Many.stuff: %s", ((BaseClass) many
                .get(0)).getStuff()));
        
         String[] packages = {"qmf.example", "qmf.example.ejb"} ;
         System.out.println(XMLUtil.schemaXML(session, packages)) ;
       
        Thread.sleep(1000);
        session.close();
    }
}
