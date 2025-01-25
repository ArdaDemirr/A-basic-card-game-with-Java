import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Card {                                     // Card object
    protected String suit;                              // suit variable
    protected String number;                            // value(number) variable
    protected String path;                              // variable that stores the path of card images
    protected Icon icon;                                // icon variable to store images of cards

    public Card(String path)                            // Card constructor that takes path string parameter
    {
        this.path = path;                               // assing path
        this.suit = path.charAt(path.length()-5)+"";    // take fifth character from last and assign it as suit
        if (path.charAt(6) == '1')                // take sixth character from path and check if it is equal to 1 or not(if it is 1 actually it is 10)
        {
            this.number = "10";                         // if it is 1 assign 10 as number variable
        } 
        else                                            // if it is not 1
        {
            this.number = path.charAt(6)+"";      // assign sixth character directly
        }
        this.icon = new ImageIcon(getClass().getResource(path));    // take icon from path
    }

    public String getPath()                             // getter method that gets path
    {
        return path;                                    // return path
    }

    public void setPath(String path)                    // setter method that assign new path to Card
    {
        this.path = path;                               // assign new path
        this.suit = path.charAt(path.length()-5)+"";    // assign new suit
        this.number = path.charAt(6)+"";          // assign new number(value)
        this.icon = new ImageIcon(getClass().getResource(getPath()));   // take new icon
    }

    public String getSuit()                             // getter method that returns suit
    {
        return suit;                                    // return suit
    }

    public String getNumber()                           // getter method that returns number(value)
    {
        return number;                                  // return number
    }

    public Icon getIcon()                               // return icon
    {
        return icon;                                    // return icon
    }
    
    public void setIcon(Icon icon)                      // method that sets new icon
    {
        this.icon = icon;                               // assign new icon
    }

    @Override                                           // override toString method
    public String toString()                            // toString method
    {
        return getSuit()+" "+getNumber();               // return suit + number as string
    }
}