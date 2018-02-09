
public class Comic extends ItemBase
{
    int issue;
    boolean variant;

    public Comic(String title, String creator, int date, int issue, boolean variant)
    {
        super(title, creator, date);
        this.issue = issue;
        this.variant = variant;
    }



    @Override
    public String toString()
    {
        return super.toString() + "," + issue + "," + variant;
    }
}
