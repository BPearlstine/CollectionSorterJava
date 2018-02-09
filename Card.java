
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

    @Override
    public String toString()
    {
        return super.toString() + "," + condition +"," + foil + "," + set;
    }
}
