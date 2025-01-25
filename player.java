import java.util.ArrayList;

public class player {                         // start of player class
    protected String name;                    // String name variable of player 
    protected ArrayList<Card> playerCards;    // a arraylist that takes Card object inside that holds players cards
    protected int score;                      // int score for player;
    protected int setNum;                     // number of sets that player win;

    public player(String name)                // player constructor that takes name string as parameter
    {
        this.name = name;                     // assign name parameter to players name variable
        this.score = 0;                       // assign score to 0
        playerCards = new ArrayList<Card>();  // initialize playerCards arraylist 
        this.setNum = 0;                      // assign the number of sets player win to 0
    }

    public String getName()                   // getter method that returns name of the player object
    {
        return name;                          // return player name
    }

    public void setName(String name)          // setter method that assigns new name to the player object
    {
        this.name = name;                     // assing new parameter to player's name
    }

    public int getScore()                     // getter method that returns score of the the player object
    {
        return score;                         // return player score
    }

    public void setScore(int point)           // setter method that assigns new score to the player object
    {
        this.score = point;                   // assing new parameter to player's score
    }

    public int getSetNum()                    // getter method that returns setNum of the player object
    {
        return setNum;                        // return setNum of player
    }

    public void setSetNum(int num)            // setter method that assign new value to the player objects
    {
        this.setNum = num;                    // assign new parameter to player's setNum
    }

    public ArrayList<Card> getCards()         // getter method that returns playerCards arraylist
    {
        return playerCards;                   // return playerCards arraylist
    }

    public void addCard(Card card)            // addCard method that adds a new Card objects to the end of playerCards arraylist
    {
        playerCards.add(card);                // adds parameter Card object to playerCards arraylist
    }

    public void setCard(int idx, Card card)   // setCard method that adds a card to given index
    {
        playerCards.set(idx, card);           // adds card to given index and removes existing one (like changes cards that stores in that index)
    }

    public void removeCard(int idx)           // removeCard method that removes Card object of given index from playerCards arraylist
    {
        playerCards.remove(idx);              // removes card from given index
    }

    public void resetHand()                   // method to remove all items from arraylist
    {
        playerCards.clear();                  // removes all items
    }
}