package qmf.example.ejb ;

/*
 * Generated class
 */

import java.util.* ;
import org.apache.qpid.console.* ;
import org.apache.qpid.transport.codec.Decoder;
import org.apache.qpid.transport.codec.Encoder;
//FIXME: limit to the packages we need 
import qmf.example.*;
import qmf.example.ejb.*;


public class ExampleService extends QMFObject
{

    public static ClassKey currentClassKey()
    {
        return new ClassKey("qmf.example.ejb:ExampleService(cb89cbb5-40358e0b-00000000-ff8788f2)") ;
    }
    

    public ExampleService(QMFObject source) {
        super(source) ;
    }

    public ExampleService(Session session, SchemaClass schema, boolean hasProperties, boolean hasStats , boolean isManaged) {
        super (session, schema, hasProperties, hasStats, isManaged) ;
    }

    public ExampleService(Session session, SchemaClass schema, Decoder dec, boolean hasProperties, boolean hasStats , boolean isManaged) {
        super (session, schema, dec, hasProperties, hasStats, isManaged) ;           
    }        
    
    public ExampleService()
    {
        super() ;

    }

    public SchemaClass getSchema() {
        if (schema == null) {
            schema = getSession().getSchema(ExampleService.currentClassKey()) ;
        }

        return schema ;
    }

    public void setSchema(SchemaClass value) {
        schema = value ;            
    }

    public BaseClass getBase(String arg0, String arg1)
    {
        return (BaseClass) this.invokeMethod("getBase", arg0, arg1).getReturnValue("result");
    }

    public DerivedClass getDerived(String arg0, String arg1, Integer arg2)
    {
        return (DerivedClass) this.invokeMethod("getDerived", arg0, arg1, arg2).getReturnValue("result");
    }

    public List<Object> findMany()
    {
        return (List<Object>) this.invokeMethod("findMany").getReturnValue("result");
    }


}
