package allan.server.db.layers.DAL;

import allan.server.db.layers.DTO.GameMatch;
import allan.server.db.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameMatchDAL {

    public List<GameMatch> readDB() {
        List<GameMatch> result = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<GameMatch> query = session.createQuery("FROM GameMatch", GameMatch.class);
            result = query.list();
        } catch (Exception e) {
            Logger.getLogger(GameMatchDAL.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }

    public boolean add(GameMatch m) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(m);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            Logger.getLogger(GameMatchDAL.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    public boolean update(GameMatch m) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(m);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            Logger.getLogger(GameMatchDAL.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    public boolean delete(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            GameMatch gameMatch = session.get(GameMatch.class, id);
            if (gameMatch != null) {
                session.delete(gameMatch);
                transaction.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            Logger.getLogger(GameMatchDAL.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
}
