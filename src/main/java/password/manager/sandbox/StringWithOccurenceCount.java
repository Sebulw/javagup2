package password.manager.sandbox;

class StringWithOccurenceCount {

    private String string;
    private Long occurrences;

    public StringWithOccurenceCount(String string, Long occurrences) {
        this.string = string;
        this.occurrences = occurrences;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Long getOccurrences() {
        return occurrences;
    }

    public void setOccurrences(Long occurrences) {
        this.occurrences = occurrences;
    }

    @Override
    public String toString() {
        return "StringWithOccurenceCount{" +
                "string='" + string + '\'' +
                ", occurrences=" + occurrences +
                '}';
    }
}
