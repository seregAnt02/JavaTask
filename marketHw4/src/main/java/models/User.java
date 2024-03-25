package models;

public class User {
    private  String name;
    private  int age;
    private  String phone;

    private  String genus;
    public enum Genus {
        Male("мужской"), Female("женский");

        private String type;

        Genus(String type){
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }
    public User(String name, int age, String phone, String genus) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.genus = genus;
    }

    public String getGenus() {
        return genus;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                '}';
    }
}
