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


public class BaseClass extends QMFObject
{

    public static ClassKey currentClassKey()
    {
        return new ClassKey("qmf.example:BaseClass(2b176d46-099f6d07-2153ccb7-00000000)") ;
    }
    

    public BaseClass(QMFObject source) {
        super(source) ;
    }

    public BaseClass(Session session, SchemaClass schema, boolean hasProperties, boolean hasStats , boolean isManaged) {
        super (session, schema, hasProperties, hasStats, isManaged) ;
    }

    public BaseClass(Session session, SchemaClass schema, Decoder dec, boolean hasProperties, boolean hasStats , boolean isManaged) {
        super (session, schema, dec, hasProperties, hasStats, isManaged) ;           
    }        
    
    public BaseClass()
    {
        super() ;

        this.setProperty("name", Util.defaultValue((short)7));
        this.setProperty("description", Util.defaultValue((short)7));
        this.setProperty("stuff", Util.defaultValue((short)21));
    }

    public SchemaClass getSchema() {
        if (schema == null) {
            schema = getSession().getSchema(BaseClass.currentClassKey()) ;
        }

        return schema ;
    }

    public void setSchema(SchemaClass value) {
        schema = value ;            
    }

    public String getName()
    {
        return (String) this.getProperty("name");
    }

    public void setName(String value)
    {
            this.setProperty("name", value);
    }

    public String getDescription()
    {
        return (String) this.getProperty("description");
    }

    public void setDescription(String value)
    {
            this.setProperty("description", value);
    }

    public List<Object> getStuff()
    {
        return (List<Object>) this.getProperty("stuff");
    }

    public void setStuff(List<Object> value)
    {
            this.setProperty("stuff", value);
    }


}
