package VS.Exception;

public class UsernameAlreadyExistException extends Exception {

    private String username;

    public UsernameAlreadyExistException(String username) {
        super(String.format("Un cont cu acest username exista deja!", username));
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
