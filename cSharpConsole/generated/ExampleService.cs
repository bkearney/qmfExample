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


namespace qmf.example.ejb
{
    public class ExampleService : QMFObject
    {

        new public static ClassKey CurrentClassKey()
        {
            return new ClassKey("qmf.example.ejb:ExampleService(cb89cbb5-40358e0b-00000000-ff8788f2)") ;
        }
        

        public ExampleService(QMFObject source) : base(source) {
        }

        public ExampleService(Session session, SchemaClass schema, bool hasProperties, bool hasStats , bool isManaged) :
               base (session, schema, hasProperties, hasStats, isManaged) {
        }

        public ExampleService(Session session, SchemaClass schema, Decoder dec, bool hasProperties, bool hasStats , bool isManaged) :
               base (session, schema, dec, hasProperties, hasStats, isManaged) {
        }        
        
        public ExampleService() : base()
        {

        }

        override public SchemaClass Schema {
            get {
                if (_Schema == null) {
                    _Schema = Session.GetSchema(ExampleService.CurrentClassKey()) ;
                }

                return _Schema ;
            }
            set{_Schema = value;}            
        }

        public virtual BaseClass GetBase(string arg0, string arg1)
        {
            return (BaseClass) this.InvokeMethod("getBase", arg0, arg1).GetReturnValue("result");
        }

        public virtual DerivedClass GetDerived(string arg0, string arg1, long arg2)
        {
            return (DerivedClass) this.InvokeMethod("getDerived", arg0, arg1, arg2).GetReturnValue("result");
        }

        public virtual List<object> FindMany()
        {
            return (List<object>) this.InvokeMethod("findMany").GetReturnValue("result");
        }


    }
}
