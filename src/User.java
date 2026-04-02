public class User implements Comparable<User> {
    String username;
    String password;

    public User(String username, String password) throws Exception{
        if(username.length() > 50){
            throw new Exception("Username is too long, try something shorter");
        }
        else if(!username.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9][A-Za-z0-9.-]*\\.[A-Za-z]{2,}$")){
           throw new Exception("Please enter a valid Email as username");
        }

        if(password.length() < 8){
           throw new Exception("Your password is too short, add more characters");
        }
        else if(password.length() > 12){
            throw new Exception("Your password is too long, try a shorter one");
        }
        else if(!password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=])[A-Za-z0-9!@#$%^&*()_+\\-=]+$")){
            throw new Exception("Please enter a valid password");

        }

        this.username = username;
        this.password = password;
    }

    @Override
    public int compareTo(User other){
        return this.username.compareTo(other.username);
    }
}
