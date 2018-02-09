
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

    public int getIssue()
    {
        return issue;
    }

    public void setIssue(int issue)
    {
        this.issue = issue;
    }

    public boolean isVariant()
    {
        return variant;
    }

    public void setVariant(boolean variant)
    {
        this.variant = variant;
    }

    @Override
    public String toString()
    {
        return super.toString() + "," + issue + "," + variant;
    }
}
