/**
 * Created by gao on 16-4-1.
 */
import com.ejb.HelloWorld;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;
public class HelloWorldClient {
    public static void main(String[] args) throws NamingException {
//		Properties props = new Properties();
//		props.setProperty("java.naming.factory.initial",
//				"org.jnp.interfaces.NamingContextFactory");
//		props.setProperty("java.naming.provider.url", "localhost:1099");
//		props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming");
//		try {
//			InitialContext ctx = new InitialContext(props);
//			HelloWorldRemote helloworld = (HelloWorldRemote) ctx
//					.lookup("HelloWorld/remote");
//			System.out.println(helloworld.sayHello("World"));
//			System.out.println(helloworld.sayHello("China"));
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
        HelloWorld helloWorld = lookupRemoteStatelessEjbBean();
        System.out.println(helloWorld);
        String s = helloWorld.sayHello("world");
        System.out.println(s);
    }
    private static HelloWorld lookupRemoteStatelessEjbBean() throws NamingException {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        final Context context = new InitialContext(jndiProperties);
        final String appName = "";
        final String moduleName = "EJBTest_war_exploded";
        final String distinctName = "";
        final String beanName = "HelloWorldEJB";
        final String viewClassName = HelloWorld.class.getName();
        final String namespace = "ejb:" + appName + "/" + moduleName
                + "/" + distinctName + "/" + beanName + "!" + viewClassName;
        System.out.println(namespace);
        return (HelloWorld) context.lookup(namespace);
        /*
           return (RemoteCounter) context.lookup("ejb:" + appName + "/" + moduleName
			+ "/" + distinctName + "/" + beanName + "!" + viewClassName + "?stateful");
        */
    }
}
