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
    public class Console : AbstractConsole
    {


        protected Dictionary<ClassKey, Type> TypeMappings = new Dictionary<ClassKey, Type>() ;
        
        public Console() : base()
        {
            TypeMappings[new ClassKey("qmf.example:DerivedClass(2b176d46-d157c17b-984c18d3-00000000)")]= typeof(DerivedClass);
            TypeMappings[new ClassKey("qmf.example:BaseClass(2b176d46-099f6d07-2153ccb7-00000000)")]= typeof(BaseClass);
            TypeMappings[new ClassKey("qmf.example.ejb:ExampleService(cb89cbb5-40358e0b-00000000-ff8788f2)")]= typeof(ExampleService);

        }

        public override Type TypeMapping(ClassKey key) {
            Type returnValue = null ;
            if (!TypeMappings.TryGetValue(key, out returnValue)) {
                returnValue = typeof(QMFObject) ;
            }

            return returnValue ;
        }

    }
}
