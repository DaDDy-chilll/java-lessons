public class UniqueID {
    private  int id = 0;

    public UniqueID(){

    }

    public int createID(){
        return this.id++;
    }
    public void setId(int id){this.id = id;}


}
