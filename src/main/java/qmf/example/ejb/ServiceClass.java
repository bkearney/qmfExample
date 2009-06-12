package qmf.example.ejb;

import java.util.List;

import javax.ejb.Local;

import org.apache.qpid.agent.annotations.QMFHide;

import qmf.example.BaseClass;
import qmf.example.DerivedClass;

@Local
public interface ServiceClass
{
    public abstract BaseClass getBase(String name, String description);

    public abstract DerivedClass getDerived(String name, String description,
            int count);

    public abstract List<BaseClass> findMany();

    public abstract void doHokeyPokey();
}