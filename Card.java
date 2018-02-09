
public class Card extends ItemBase
{
    String condition;
    String set;
    boolean foil;

    public Card(String title, String creator, int date, String condition, boolean foil, String set)
    {
        super(title, creator, date);
        this.condition = condition;
        this.foil = foil;
        this.set = set;
    }

    public String getCondition()
    {
        return condition;
    }

    public void setCondition(String condition)
    {
        this.condition = condition;
    }

    public boolean isFoil()
    {
        return foil;
    }

    public void setFoil(boolean foil)
    {
        this.foil = foil;
    }

    public String getSet()
    {
        return set;
    }

    public void setSet(String set)
    {
        this.set = set;
    }

    @Override
    public String toString()
    {
        return super.toString() + "," + condition +"," + foil + "," + set;
    }
}
