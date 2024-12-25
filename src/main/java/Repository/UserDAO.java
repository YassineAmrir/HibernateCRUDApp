package Repository;

import Model.User;
import Repository.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UserDAO {

    public void saveUser(User user){
        Session session= HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            Transaction transaction=session.beginTransaction();

            session.save(user);

            transaction.commit();

        }catch(Exception e){
            System.out.println(e);
        }
        finally {
            session.close();
        }

    }
    public boolean findUser (User user){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession(); // Open a new session

        try{
            Transaction transaction=session.beginTransaction();
            // Create the HQL query to find the user by username and password
            String hql = "FROM Model.User WHERE username = :username AND password = :password";
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("username", user.getUsername());
            query.setParameter("password", user.getPassword());
            // Get the result
            User userSearched = query.uniqueResult();
            // If user is found, print the username and password (you may want to avoid printing passwords)
            if (userSearched != null) {
                transaction.commit(); // Commit the transaction if found
                return true;
            } else {
                // Model.User not found
                transaction.rollback(); // Rollback the transaction if user not found
                return false;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        finally {
            session.close();
        }
        return true;
    }
}
