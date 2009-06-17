package qmf.example;

import java.util.ArrayList;

import org.apache.qpid.agent.annotations.QMFSeeAlso;

@QMFSeeAlso({DerivedClass.class})
public class BaseClass
{
    protected String name ;
    protected String description ;
    protected ArrayList<Object> stuff ;
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
    public ArrayList<Object> getStuff()
    {
        return stuff;
    }
    public void setStuff(ArrayList<Object> stuff)
    {
        this.stuff = stuff;
    }
}
