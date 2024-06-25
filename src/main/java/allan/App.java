package allan;

import allan.Test.testUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sessionFactory;
        Configuration config;
        Session session;
        config = new Configuration().configure("hibernate.cfg.xml");
        sessionFactory = config.buildSessionFactory();
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        testUser test = new testUser("hibernate@gmail.com", "123123", "icons8_ghost_96px.png", "hibernate", "Nu", 2005, 0, 0,0,0,0,false);
        Transaction tx = session.getTransaction();
        session.save(test);
        tx.commit();
        System.out.println( "Hello World!" );
    }
}
