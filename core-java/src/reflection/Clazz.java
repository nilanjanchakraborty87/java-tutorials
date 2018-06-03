package reflection;

import java.io.Serializable;
import java.lang.reflect.Modifier;

public class Clazz {

    private String description = "A class to explain java reflection";

    //A simple inner class declaration ofr demonstration purpose
    public class InnerClazz{  }

    public interface InnerInterface { }

    public static void main(String[] args) {

        Class<Clazz> clazz = Clazz.class;
        Class<InnerClazz> innerClazz = InnerClazz.class;
        InnerInterface i = new InnerInterface() {  };


        //returns the Clazz simple name - Clazz
        System.out.println("Clazz Simple Name --->" + clazz.getSimpleName());
        System.out.println("InnerClazz Simple Name ---> " + innerClazz.getSimpleName());
        System.out.println("InnerInterface anonymous implementation Simple Name ---> " + i.getClass().getSimpleName());

        //returns the Clazz package delcartion name - reflection.Clazz
        System.out.println("Clazz Cannonical Name --->" + clazz.getCanonicalName());
        System.out.println("InnerClazz Cannonical Name ---> " + innerClazz.getCanonicalName());
        System.out.println("InnerInterface anonymous implementation Cannonical Name ---> " + i.getClass().getCanonicalName());

        //returns the fully qualified name - reflection.Clazz. Though here it similar to the Cannonical name but
        // it differs in case of inner classes
        System.out.println("Clazz fully qualified Name --->" + clazz.getName());
        System.out.println("InnerClazz fully qualified Name ---> " + innerClazz.getName());
        System.out.println("InnerInterface anonymous implementation fully qualified Name ---> " + i.getClass().getName());

        int modifiers = clazz.getModifiers();
        System.out.println("Clazz modifiers ---> " + Modifier.toString(modifiers));
        System.out.println("Clazz is public ----> " + Modifier.isPublic(modifiers));

        try {
            //using newInstance we can create a new object of the referring class.
            //It throws InstantiationException if any of the below fact holds true for the calling class.
            //1. It's an interface
            //2. It is an abstract class
            //3. It is array
            //4. Primitive Type or Void
            //5. Has No Nullary constructor or default Constructor

            Clazz c = (Clazz)Clazz.class.newInstance();
            System.out.println(c.description);
        } catch (Exception e) {
            System.err.println("Failed to instantiate the Clazz instance. Reason : [" + e.getMessage() + "]");
        }

    }
}
