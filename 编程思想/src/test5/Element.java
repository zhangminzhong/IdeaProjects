package test5;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-6-30
 * Time: 下午4:26
 * To change this template use File | Settings | File Templates.
 */
public class Element {
    private String ident;
    public Element(String id){
        ident = id;
    }

    @Override
    public int hashCode() {
        return ident.hashCode();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Element && ident.equals(((Element)obj).ident);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public String toString() {
        return ident;    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Fnalizing" + getClass().getSimpleName() + " " + ident);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
