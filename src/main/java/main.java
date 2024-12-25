import Model.User;
import Repository.UserDAO;

public class main {

    public static void main(String[] args){

        try {
            UserDAO userDAO =new UserDAO();
            // Create a new user object
            User newUser = new User();
            newUser.setUsername("Yassine");
            newUser.setPassword("30/9");

            //userDAO.saveUser(newUser);
            // Save the user object to the database
            boolean userfounded= userDAO.findUser(newUser);

            System.out.println(userfounded);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
