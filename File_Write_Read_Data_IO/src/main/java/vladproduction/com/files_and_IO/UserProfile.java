package vladproduction.com.files_and_IO;

import java.io.Serializable;
import java.util.Objects;

class UserProfile implements Serializable {
    private final String name;
    private final String email;
    private final String themeColor;

    public transient String something;

    public UserProfile(String name, String email, String themeColor, String something) {
        this.name = name;
        this.email = email;
        this.themeColor = themeColor;
        this.something = something;

    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        UserProfile that = (UserProfile) object;
        return Objects.equals(name, that.name) && Objects.equals(email, that.email)
                && Objects.equals(themeColor, that.themeColor) && Objects.equals(something, that.something);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, themeColor, something);
    }

    @Override
    public String toString() {
        return "User: " + name +
                "\nEmail: " + email +
                "\nTheme Color: " + themeColor +
                "\nSomething (transient): " + something;
    }
}
