package password.manager.model;

public class PasswordEntry {

    private String website;
    private String password;
    private String login;

    public PasswordEntry(String website, String password, String login) {
        this.website = website;
        this.password = password;
        this.login = login;
    }

    public String getWebsite() {
        return website;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public String toString() {
        return "PasswordEntry{" +
                "website='" + website + '\'' +
                ", password='" + password + '\'' +
                ", login='" + login + '\'' +
                '}';
    }

    public String toCSVString() {
        return website + ";" + password + ";" + login;
    }

    public String[] toArray() {
        return new String[] {website, password, login};
    }
}
