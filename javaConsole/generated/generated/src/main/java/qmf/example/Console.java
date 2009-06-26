package qmf.example ;
/*
 * Generate class
 */

import java.util.* ;
import org.apache.qpid.console.* ;
//FIXME: limit to the packages we need 
import qmf.example.*;
import qmf.example.ejb.*;


public class Console extends AbstractConsole
{
    protected HashMap<ClassKey, Class> typeMappings = new HashMap<ClassKey, Class>() ;
    
    public Console() 
    {
        super() ;
        typeMappings.put(new ClassKey("qmf.example:DerivedClass(2b176d46-d157c17b-984c18d3-00000000)"), DerivedClass.class);
        typeMappings.put(new ClassKey("qmf.example:BaseClass(2b176d46-099f6d07-2153ccb7-00000000)"), BaseClass.class);
        typeMappings.put(new ClassKey("qmf.example.ejb:ExampleService(cb89cbb5-40358e0b-00000000-ff8788f2)"), ExampleService.class);

    }

    public Class typeMapping(ClassKey key) {
        if (typeMappings.containsKey(key))
            return typeMappings.get(key) ;
        else
            return QMFObject.class ;
    }

}
