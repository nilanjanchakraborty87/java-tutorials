package reflection;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


/**
 * Sample of all method relation java reflection APIs
 */
public class Methodz extends SuperClazz{

    static void display(){
        System.out.println("Static display method");
    }

    @Override
    public void foo() {
        System.out.println("Child version of foo method");
    }

    private void privateLocalMethod(){
        System.out.println("A private local method");
    }

    public void publicLocalMethod(){
        System.out.println("A public local method");
    }

    public String display(String descripion){
        System.out.println("Description: " + descripion);
        return  descripion;
    }

    public int display(int x){
        System.out.println("Description: " + x);
        return x;
    }

    public static void main(String[] args) {
        Class<Methodz> clazz = Methodz.class;
        System.out.println("All declared method details:");
        System.out.println("====================================================================");
        //Returns all the methods of the class including private, protected, public and default
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println("Method [name: " + m.getName() + ", paramCount: " + m.getParameterCount() + ", static: " + (Modifier.isStatic(m.getModifiers()) ? "yes" : "no") + " ]");
        }

        try {
            Method m = clazz.getDeclaredMethod("display", new Class[]{String.class});
            Methodz obj = new Methodz();
            m.invoke(obj, "This is how a method is executed");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }finally {
        }
    }
}
