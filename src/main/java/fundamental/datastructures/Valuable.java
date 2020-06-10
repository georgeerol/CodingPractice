package fundamental.datastructures;

/**
 * Created by George Fouche on 12/20/19.
 */
public class Valuable {

    private  String uniqueName;
    private Integer volume;


    public Valuable(String uniqueName, Integer volume){

        this.uniqueName = uniqueName;
        this.volume = volume;

    }

    public  String getUniqueName(){
        return this.uniqueName;
    }

    public Integer getVolume(){

        return this.volume;

    }
}
