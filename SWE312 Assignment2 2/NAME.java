package SWE312;

public class NAME {
    private String name;

    public NAME(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final NAME other = (NAME) obj;
        return this.name.equals(other.name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}