package qmf.example.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.qpid.agent.annotations.QMFHide;
import org.apache.qpid.agent.annotations.QMFObject;

import qmf.example.BaseClass;
import qmf.example.DerivedClass;

@Stateless(name="ServiceBean")
@QMFObject(className="ExampleService", packageName="qmf.example.ejb")
public class ServiceClassBean implements ServiceClass
{

    public BaseClass getBase(String name, String description) {
        BaseClass bc = new BaseClass() ;
        bc.setName(name) ;
        bc.setDescription(description) ;
        return bc ;
    }

    
    public DerivedClass getDerived(String name, String description, int count) {
        DerivedClass dc = new DerivedClass() ;
        dc.setName(name) ;
        dc.setDescription(description) ;
        dc.setCount(count) ;
        return dc ;        
    }

    
    public List<BaseClass> findMany() {
        ArrayList<BaseClass> list= new ArrayList<BaseClass>() ;
        list.add(getBase("JarJar", "My Friend")) ;
        list.add(getDerived("Binks", "Not My Friend", 12)) ;
        ArrayList<Object> data = new ArrayList<Object>() ;
        data.add(11) ;
        data.add("Info") ;
        data.add(getBase("Wotto", "Also My Friend")) ;
        list.get(0).setStuff(data) ;
        return list ;
    }
    

    @QMFHide
    public void doHokeyPokey() {
        System.out.println("Turn yourself around") ;
    }
}
