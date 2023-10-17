public class UniqueID {
    private  int id = 0;

    public UniqueID(){

    }

    public int createID(){
        return this.id++;
    }


}
