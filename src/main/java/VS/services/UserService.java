


package VS.services;
import VS.exceptions.*;
import VS.model.User;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.Cursor;
import org.dizitart.no2.objects.ObjectRepository;

import VS.exceptions.UncompletedFieldsException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static VS.services.FileSystemService.getPathToFile;

public class UserService {

    public static ObjectRepository<User> userRepository;


    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("Admin.db").toFile())
                .openOrCreate("admin", "admin1");

        userRepository = database.getRepository(User.class);
    }

    public static void addUser(String username,String password,String name,String email,String address,String phone) throws UsernameAlreadyExistException, NoUpperCaseException, UncompletedFieldsException, UsernameAlreadyExistException {
        try {
            AllFieldsCompleted(username,password,name,email,address,phone);
        } catch (UncompletedFieldsException e) {
            e.printStackTrace();
        }
        checkUserDoesNotAlreadyExist(username);
        UpperCaseExists(password);
        User user=new User(username, encodePassword(username, password), name, email, address, phone);
        //user.setisAdmin();
        userRepository.insert(user);

    }


    private static void checkUserDoesNotAlreadyExist(String username) throws UsernameAlreadyExistException {
        Cursor<User> cursor = userRepository.find();
        for (User user : cursor) {
//            if (Objects.equals(username, user.getUsername()))
            if (username.equals(user.getUsername()))
            {   throw new UsernameAlreadyExistException(username);

            }
        }
    }
    public static boolean checkIsAdmin(String username)  {
        Cursor<User> cursor = userRepository.find();
        for (User user : cursor) {
            if (username.equals(user.getUsername())) {
                if (user.isAdmin()) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean UpperCaseExists(String password) throws NoUpperCaseException
    {
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(password);
        boolean matchFound = matcher.find();
        if(!matchFound) throw new NoUpperCaseException("Parola trebuie sa contina cel putin o litera de tipar!");
        else
            return true;

    }
    public static void AllFieldsCompleted(String username, String password, String name, String email, String address, String phone) throws  UncompletedFieldsException {
        Pattern pattern = Pattern.compile("[\\S+]");
        Matcher matcher1 = pattern.matcher(username);
        Matcher matcher2 = pattern.matcher(password);
        Matcher matcher3 = pattern.matcher(email);
        Matcher matcher4= pattern.matcher(address);
        Matcher matcher5=pattern.matcher(phone);
        Matcher matcher6=pattern.matcher(name);
        boolean matchFound1 = matcher1.find();
        boolean matchFound2 = matcher2.find();
        boolean matchFound3 = matcher3.find();
        boolean matchFound4 = matcher4.find();
        boolean matchFound5 = matcher5.find();
        boolean matchFound6 = matcher6.find();
        if(!matchFound1 ) throw new UncompletedFieldsException("Trebuie sa completati toate campurile!");
        if(!matchFound2 ) throw new UncompletedFieldsException("Trebuie sa completati toate campurile!");
        if(!matchFound3 ) throw new UncompletedFieldsException("Trebuie sa completati toate campurile!");
        if(!matchFound4 ) throw new UncompletedFieldsException("Trebuie sa completati toate campurile!");
        if(!matchFound5 ) throw new UncompletedFieldsException("Trebuie sa completati toate campurile!");
        if(!matchFound6) throw new UncompletedFieldsException("Trebuie sa completati toate campurile!");

    }


    private static String encodePassword(String salt, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        // This is the way a password should be encoded when checking the credentials
        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", ""); //to be able to save in JSON format
    }
    public static void userExists(String username,String password) throws InvalidUsernameException, IncorrectPasswordException {
        int ok=0,ok2=0;
        for(User user :userRepository.find())
        {
            if (Objects.equals(username, user.getUsername()))
            {   ok=1;
                if(encodePassword(username,password).equals(user.getPassword())) {
                    ok2=1;
                }
            }
        }
        if(ok==0)
            throw new InvalidUsernameException("Username incorect!");
        if(ok2==0)
            throw new IncorrectPasswordException("Parola incorecta!");
    }
    public static void addAdmin(String username, String password,String name,String email,String address,String phone) throws NoUpperCaseException, UncompletedFieldsException, UsernameAlreadyExistException {
        try {
            AllFieldsCompleted(username,password,name,email,address,phone);
        } catch (UncompletedFieldsException e) {
            e.printStackTrace();
        }
        checkUserDoesNotAlreadyExist(username);
        UpperCaseExists(password);
        User u=new User(username,encodePassword(username,password),name,email,address,phone);
        u.setisAdmin();
        userRepository.insert(u);
    }

    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }


}
