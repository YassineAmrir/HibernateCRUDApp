import Model.User;
import Repository.UserDAO;
import org.hibernate.SessionFactory;
import org.junit.Test;


public class UserTest {
    private static SessionFactory sessionFactory;

   @Test
    public void addUser(){
        UserDAO userDAO=new UserDAO();
        // Create a new user object
        User newUser = new User();
        newUser.setUsername("SoukainaFekrach");
        newUser.setPassword("30/9");
        userDAO.saveUser(newUser);
        // Output the created user ID to confirm
        System.out.println("Model.User created with ID: " + newUser.getId());

}
}
