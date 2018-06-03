package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.Arrays;

/**
 * this class demonstrates all the constructor related java APIs
 */
public class Constructorz {

    private String description;
    private int count;

    public Constructorz(){
        System.out.println("A default constructor");
    }

    public Constructorz(String description) {
        this.description = description;
    }

    private Constructorz(String description, int count) {
        this.description = description;
        this.count = count;
    }


    public static void main(String[] args) {
        Constructor[] constructors = Constructorz.class.getDeclaredConstructors();
        System.out.println("Constructorz class has " + constructors.length + " constructor");

        for (Constructor c: constructors) {
            System.out.println("Constructor[" + c.getName() + "] has parameter count " + c.getParameterCount());
            System.out.println("Constructor parameter types " + Arrays.toString(c.getParameterTypes()));
            Parameter[] params = c.getParameters();
            for (Parameter p : params) {
                System.out.println("Parameter [name : " + p.getName() + ", type :" + p.getType() + "]");
            }
        }

        try {
            Constructor<Constructorz> c1 = Constructorz.class.getDeclaredConstructor(new Class[]{String.class});
            c1.setAccessible(true);
            Constructorz obj1 = c1.newInstance("Instantiate a constructor dynamically");
            System.out.println("Description: " + obj1.description);

            Constructor<Constructorz> c2 = Constructorz.class.getDeclaredConstructor(new Class[]{String.class, int.class});
            c2.setAccessible(true);
            Constructorz obj2 = c2.newInstance("Instantiate a constructor dynamically", 10);
            System.out.println("Description: " + obj2.description + ", Count: " + obj2.count);

        } catch (NoSuchMethodException e) {
            System.err.println("Constructor not found");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
