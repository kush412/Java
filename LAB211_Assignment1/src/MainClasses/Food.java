package MainClasses;

public class Food {
    String ID;
    String name;
    int weight;
    String type;
    String place;
    String expDate;
  
    public Food() {
    }

    public Food(String ID, String name, int weight, String type, String place, String expDate) {
        this.ID = ID;
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.place = place;
        this.expDate = expDate;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    @Override
    public String toString() {
        return "ID: " + ID + ", name: " + name + ", weight: " + weight + " gram(s), type: " + type + ", place: " + place + ", expired date: " + expDate + "\n";
    }
}