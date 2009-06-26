package qmf.example ;

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


public class DerivedClass extends BaseClass
{

    public static ClassKey currentClassKey()
    {
        return new ClassKey("qmf.example:DerivedClass(2b176d46-d157c17b-984c18d3-00000000)") ;
    }
    

    public DerivedClass(QMFObject source) {
        super(source) ;
    }

    public DerivedClass(Session session, SchemaClass schema, boolean hasProperties, boolean hasStats , boolean isManaged) {
        super (session, schema, hasProperties, hasStats, isManaged) ;
    }

    public DerivedClass(Session session, SchemaClass schema, Decoder dec, boolean hasProperties, boolean hasStats , boolean isManaged) {
        super (session, schema, dec, hasProperties, hasStats, isManaged) ;           
    }        
    
    public DerivedClass()
    {
        super() ;

        this.setProperty("count", Util.defaultValue((short)18));
    }

    public SchemaClass getSchema() {
        if (schema == null) {
            schema = getSession().getSchema(DerivedClass.currentClassKey()) ;
        }

        return schema ;
    }

    public void setSchema(SchemaClass value) {
        schema = value ;            
    }

    public Integer getCount()
    {
        return (Integer) this.getProperty("count");
    }

    public void setCount(Integer value)
    {
            this.setProperty("count", value);
    }


}
