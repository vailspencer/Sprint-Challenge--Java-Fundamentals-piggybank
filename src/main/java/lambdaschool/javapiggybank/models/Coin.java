package lambdaschool.javapiggybank.models;

import javax.persistence.*;

@Entity
@Table(name = "coins")
public class Coin
{
    //coinid, name, namepural, value, quantity
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long coinid;

    protected String name;
    protected String nameplural;
    protected double value;
    protected int quantity;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getNamepural()
    {
        return nameplural;
    }

    public void setNamepural(String namepural)
    {
        this.nameplural = namepural;
    }

    public double getValue()
    {
        return value;
    }

    public void setValue(double value)
    {
        this.value = value;
    }

    public int getQuantiy()
    {
        return quantity;
    }

    public void setQuantiy(int quantiy)
    {
        this.quantity = quantiy;
    }

    public Coin(
        String name,
        String namepural,
        double value,
        int quantiy)
    {
        this.name = name;
        this.nameplural = namepural;
        this.value = value;
        this.quantity = quantiy;
    }

    public Coin()
    {
    }

    public String getTotal(){
        if(quantity > 1){
            return quantity + " " + nameplural;
        }
        return quantity + " "  + name;
    }

    @Override
    public String toString()
    {
        return "Coin{" +
            "coinid=" + coinid +
            ", name='" + name + '\'' +
            ", namepural='" + nameplural + '\'' +
            ", value=" + value +
            ", quantiy=" + quantity +
            '}';
    }
}
