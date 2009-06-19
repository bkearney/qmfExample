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
    public class DerivedClass : BaseClass
    {

        new public static ClassKey CurrentClassKey()
        {
            return new ClassKey("qmf.example:DerivedClass(2b176d46-d157c17b-984c18d3-00000000)") ;
        }
        

        public DerivedClass(QMFObject source) : base(source) {
        }

        public DerivedClass(Session session, SchemaClass schema, bool hasProperties, bool hasStats , bool isManaged) :
               base (session, schema, hasProperties, hasStats, isManaged) {
        }

        public DerivedClass(Session session, SchemaClass schema, Decoder dec, bool hasProperties, bool hasStats , bool isManaged) :
               base (session, schema, dec, hasProperties, hasStats, isManaged) {
        }        
        
        public DerivedClass() : base()
        {
            this.SetProperty("count", Util.DefaultValue(18));

        }

        override public SchemaClass Schema {
            get {
                if (_Schema == null) {
                    _Schema = Session.GetSchema(DerivedClass.CurrentClassKey()) ;
                }

                return _Schema ;
            }
            set{_Schema = value;}            
        }

        virtual public long Count
        {
            get
            {
                return (long) this.GetProperty("count");
            }

            set
            {
                this.SetProperty("count", value);
            }
        }


    }
}
