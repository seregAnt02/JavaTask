package models;

public class User {
    private  String name;
    private  int age;
    private  String phone;

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
    public User(String name, int age, String phone, Genus genus) {
        this.name = name;
        this.age = age;
        this.phone = phone;
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
