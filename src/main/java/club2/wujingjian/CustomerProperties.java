package club2.wujingjian;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "customer")
public class CustomerProperties {
    private static final String DEFAULT_NAME = "Marker";

    private String name = DEFAULT_NAME;

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
