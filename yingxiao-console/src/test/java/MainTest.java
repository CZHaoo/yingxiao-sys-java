import org.springframework.beans.BeanUtils;

public class MainTest {
    public static void main(String[] args) {
        Man man = new Man();
        man.setName("czh");

        Person person = new Person();
        BeanUtils.copyProperties(man,person);

        System.out.println(person);
    }
}

class Person {
   // String name;
    Family family;

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }



    @Override
    public String toString() {
        return "Person{" +

                ", family=" + family +
                '}';
    }
}


class Family {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


class Man {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
