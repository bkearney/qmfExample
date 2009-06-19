/*
 * Generate class
 */

using System;
using System.Collections.Generic;
using org.apache.qpid.console;
using org.apache.qpid.transport.codec ;
//FIXME: limit to the packages we need 
using qmf.example;
using qmf.example.ejb;


namespace qmf.example
{
    public class BaseClass : QMFObject
    {

        new public static ClassKey CurrentClassKey()
        {
            return new ClassKey("qmf.example:BaseClass(2b176d46-099f6d07-2153ccb7-00000000)") ;
        }
        

        public BaseClass(QMFObject source) : base(source) {
        }

        public BaseClass(Session session, SchemaClass schema, bool hasProperties, bool hasStats , bool isManaged) :
               base (session, schema, hasProperties, hasStats, isManaged) {
        }

        public BaseClass(Session session, SchemaClass schema, Decoder dec, bool hasProperties, bool hasStats , bool isManaged) :
               base (session, schema, dec, hasProperties, hasStats, isManaged) {
        }        
        
        public BaseClass() : base()
        {
            this.SetProperty("name", Util.DefaultValue(7));
            this.SetProperty("description", Util.DefaultValue(7));
            this.SetProperty("stuff", Util.DefaultValue(21));

        }

        override public SchemaClass Schema {
            get {
                if (_Schema == null) {
                    _Schema = Session.GetSchema(BaseClass.CurrentClassKey()) ;
                }

                return _Schema ;
            }
            set{_Schema = value;}            
        }

        virtual public string Name
        {
            get
            {
                return (string) this.GetProperty("name");
            }

            set
            {
                this.SetProperty("name", value);
            }
        }

        virtual public string Description
        {
            get
            {
                return (string) this.GetProperty("description");
            }

            set
            {
                this.SetProperty("description", value);
            }
        }

        virtual public List<object> Stuff
        {
            get
            {
                return (List<object>) this.GetProperty("stuff");
            }

            set
            {
                this.SetProperty("stuff", value);
            }
        }


    }
}
