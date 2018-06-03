package reflection;

public class SuperClazz {

    private void privateSuperMethod(){
        System.out.println("A private method of Super Class");
    }

    protected void bar(){
        System.out.println("Super version of bar");
    }

    public void foo(){
        System.out.println("Super Version of foo");
    }
}
