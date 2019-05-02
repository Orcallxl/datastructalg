package problem;

/**
 * Created by orca on 2018/12/11.
 */
public class Strudent {
    public String name;
    public String sno;

    public Strudent(){

    }
    public Strudent(String name, String sno) {
        this.name = name;
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }
}
