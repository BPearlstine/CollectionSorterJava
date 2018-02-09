
public class ItemBase
{
    String title;
    String creator;
    String media;
    int date;

    public ItemBase()
    {
    }

    public ItemBase(String title, String creator, int date)
    {
        this.title = title;
        this.creator = creator;
        this.date = date;
    }


    @Override
    public String toString()
    {
        return title + "," + creator + "," + date;
    }


}
