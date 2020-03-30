package search;

public class People {
    String firstName;
    String lastName;
    String email;

    public People(String[] args) {
        if(args.length == 3) {
            this.firstName = args[0];
            this.lastName = args[1];
            this.email = args[2];
        }
        if(args.length == 2) {
            this.firstName = args[0];
            this.lastName = args[1];
            this.email = "";
        }
        if(args.length == 1) {
            this.firstName = args[0];
            this.lastName = "";
            this.email = "";
        }
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] get() {
        return new String[]{getFirstName(), getLastName(), getEmail()};
    }

    public boolean contains(String find) {
        return getFirstName().contains(find)
                || getLastName().contains(find)
                || getEmail().contains(find);
    }

    @Override
    public String toString() {
        return firstName + ' '
                + lastName + ' '
                + email
                ;

    }
}
