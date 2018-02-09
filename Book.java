
public class Book extends ItemBase
{

    boolean edition;

    public Book(String title, String creator, int date, boolean edition)
    {
        super(title, creator, date);
        this.edition = edition;
    }


    @Override
    public String toString()
    {
        return super.toString() + "," + edition;
    }
}
