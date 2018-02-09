
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

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getCreator()
    {
        return creator;
    }

    public void setCreator(String creator)
    {
        this.creator = creator;
    }


    public int getDate()
    {
        return date;
    }

    public void setDate(int date)
    {
        this.date = date;
    }

    @Override
    public String toString()
    {
        return title + "," + creator + "," + date;
    }


}
