package password.manager.model;

import password.manager.encrypt.EncryptionService;

import java.util.UUID;

public class PasswordEntry implements Cloneable{

    private final String uuid = UUID.randomUUID().toString();
    private String website;
    private String password;
    private String login;

    public PasswordEntry(String website, String password, String login) {
        this.website = website;
        this.password = password;
        this.login = login;
    }

    public PasswordEntry(String key, String[] encryptedSplit) {
        String[] decrypted = EncryptionService.decrypt(key, encryptedSplit);
        this.website = decrypted[0];
        this.password = decrypted[1];
        this.login = decrypted[2];
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

    public String[] toEncryptedArray(String key) {

        return EncryptionService.encrypt(key, new String[]{website, password, login});
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PasswordEntry)) {
            return false;
        }
        PasswordEntry that = (PasswordEntry)obj;
        return this.uuid.equals(that.uuid);
    }

    @Override
    protected PasswordEntry clone() {
        return new PasswordEntry(website, password, login);
    }

    public static class Builder {
        private String website;
        private String password;
        private String login;

        private Builder() {
        }

        public static Builder of() {
            return new Builder();
        }

        public Builder withWebsite(String website) {
            this.website = website;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }
        public Builder withLogin(String login) {
            this.login = login;
            return this;
        }

        public PasswordEntry build() {
            return new PasswordEntry(website, password, login);
        }





    }
}
