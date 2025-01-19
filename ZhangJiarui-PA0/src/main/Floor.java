package main;

/**
* Represents a floor in a building. 
* Manages the people present on the floor and provides functionality to add individuals to the floor.
* Known Bugs: None
*
* @author Jiarui Zhang
* jiaruiz@brandeis.edu
* 01 19 2025
* COSI 21A PA0
*/

public class Floor{
    MyArray<Person> peopleAtFloor;

    public Floor(/*add some params here maybe */){
        peopleAtFloor = new MyArray<Person>();
    }

    public MyArray<Person> getPeopleAtFloor(){
        return this.peopleAtFloor;
    }

    public void enterFloor(Person person){
        peopleAtFloor.add(person);
    }

    public String toString(){
        String peopleAtFloor2String = "";

        if(peopleAtFloor.size() == 0){
            peopleAtFloor2String += "No one at this floor now";
        }else{
            for(int i = 0; i < peopleAtFloor.size()-1; i++){
                peopleAtFloor2String += peopleAtFloor.get(i).getName() + ", ";
            }
            peopleAtFloor2String += peopleAtFloor.get(peopleAtFloor.size()-1).getName();
    
        }
        return peopleAtFloor2String;
    }
}
