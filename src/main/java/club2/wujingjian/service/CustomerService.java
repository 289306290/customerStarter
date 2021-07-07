package club2.wujingjian.service;

public class CustomerService {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String findCustomer() {
        return "The customer is " + name;
    }
}
