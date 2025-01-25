import javax.swing.JFrame;
import java.awt.Color;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
public class gameFrame extends JFrame {                  // gameFrame class that contains all gui elements and logical methods
    Random rand = new Random();                          // random 
    player playerTurn;                                   // a variable that stores a player object according to turn
    boolean winner = false;                              // a boolean variable named winner that determines if there is a winner or not
    int setLabelX = 0;                                   // x coordinate for set labels
    int setLabelY = 150;                                 // y coordinate for set labels
    int setNum = 1;                                      // assing setnum as 1 (because we are in set 1 at the beginning)
    boolean isEndOfSet = false;                          // a boolean variable that determines is it end of set or not
    JButton nextButton = new JButton("Next Set");   // a button to pass next set
    //----------------------------------------------------------------------all gui components--------------------------------------------------
    private JLabel player1Name, player1Score, player1SetWin, player1Card1, player1Card2, player1Card3, player1Card4, player1Card5;
    private JCheckBox checkp1c1,checkp1c2,checkp1c3,checkp1c4,checkp1c5;
    private JButton player1Button, player2Button;
    private JLabel player2Name,player2Score,player2SetWin,player2Card1,player2Card2,player2Card3,player2Card4,player2Card5;
    private JCheckBox checkp2c1,checkp2c2,checkp2c3,checkp2c4,checkp2c5;
    private JLabel commonCard1,commonCard2,commonCard3;
    private JLabel setLabel1,setLabel2,setLabel3,setLabel4,setLabel5;
    private JPanel mainGamePanel;
    private JPanel gameStatusPanel;
    // -----------------------------------------------------------------------------------------------create all 52+1 card----------------------
    Card c2 = new Card("Cards/2c.jpg");             Card h2 = new Card("Cards/2h.jpg");     // create a new card class and assign its path as parameter
    Card c3 = new Card("Cards/3c.jpg");             Card h3 = new Card("Cards/3h.jpg");
    Card c4 = new Card("Cards/4c.jpg");             Card h4 = new Card("Cards/4h.jpg");
    Card c5 = new Card("Cards/5c.jpg");             Card h5 = new Card("Cards/5h.jpg");
    Card c6 = new Card("Cards/6c.jpg");             Card h6 = new Card("Cards/6h.jpg");
    Card c7 = new Card("Cards/7c.jpg");             Card h7 = new Card("Cards/7h.jpg");
    Card c8 = new Card("Cards/8c.jpg");             Card h8 = new Card("Cards/8h.jpg");
    Card c9 = new Card("Cards/9c.jpg");             Card h9 = new Card("Cards/9h.jpg");
    Card c10 = new Card("Cards/10c.jpg");           Card h10 = new Card("Cards/10h.jpg");
    Card cjack = new Card("Cards/jackc.jpg");       Card hjack = new Card("Cards/jackh.jpg");
    Card cqueen = new Card("Cards/queenc.jpg");     Card hqueen = new Card("Cards/queenh.jpg");
    Card cking = new Card("Cards/kingc.jpg");       Card hking = new Card("Cards/kingh.jpg");
    Card cace = new Card("Cards/acec.jpg");         Card hace = new Card("Cards/aceh.jpg");
    
    Card s2 = new Card("Cards/2s.jpg");             Card d2 = new Card("Cards/2d.jpg");
    Card s3 = new Card("Cards/3s.jpg");             Card d3 = new Card("Cards/3d.jpg");
    Card s4 = new Card("Cards/4s.jpg");             Card d4 = new Card("Cards/4d.jpg");
    Card s5 = new Card("Cards/5s.jpg");             Card d5 = new Card("Cards/5d.jpg");
    Card s6 = new Card("Cards/6s.jpg");             Card d6 = new Card("Cards/6d.jpg");
    Card s7 = new Card("Cards/7s.jpg");             Card d7 = new Card("Cards/7d.jpg");
    Card s8 = new Card("Cards/8s.jpg");             Card d8 = new Card("Cards/8d.jpg");
    Card s9 = new Card("Cards/9s.jpg");             Card d9 = new Card("Cards/9d.jpg");
    Card s10 = new Card("Cards/10s.jpg");           Card d10 = new Card("Cards/10d.jpg");
    Card sjack = new Card("Cards/jacks.jpg");       Card djack = new Card("Cards/jackd.jpg");
    Card squeen = new Card("Cards/queens.jpg");     Card dqueen = new Card("Cards/queend.jpg");
    Card sking = new Card("Cards/kings.jpg");       Card dking = new Card("Cards/kingd.jpg");
    Card sace = new Card("Cards/aces.jpg");         Card dace = new Card("Cards/aced.jpg");
    Card backred = new Card("Cards/back-red.png");                                              // card back
    // --------------------------------------------------------------------create players----------------------------------------
    player player1 = new player("Player1");                     // create a new player named player1
    player player2 = new player("Player2");                     // create a new player named player2
    // -----------------------------------------------------------------create card arraylists-----------------------------------
    private ArrayList<Card> deck = new ArrayList<Card>();            // a arraylist to store all cards 
    private ArrayList<Card> commonCards = new ArrayList<Card>();     // a arraylist to store 3 common cards
    //-------------------------------------------------------------------constructor method--------------------------------------
    public gameFrame()      
    {
        super("Card Game");                                    // title: Card Game
        setLayout(null);                                     // no layout for JFrame
        setResizable(false);                               // not resizeable
        ButtonHandler handler = new ButtonHandler();                 // create new ButtonHandler named handler
        playerTurn = player1;                                        // assign player1 object to playerTurn variable (because player1 must start first)
        createDeck();                                                // a method to add all card objects to arraylist and shuffle them
        distCards();                                                 // then distribute cards
        //-----------------------------------------------------------------panel declare-----------------------------------------
        mainGamePanel = new JPanel(null);                     // create new panel and set its layout to null
        mainGamePanel.setBackground( Color.WHITE );                  // make it white
        mainGamePanel.setBounds(0, 0, 700, 600);    // set location position and width,height
        add(mainGamePanel);                                          // add it to JFrame

        gameStatusPanel = new JPanel(null);                   // create new panel and set its layout to null
        gameStatusPanel.setBackground( Color.WHITE );                // make it white
        gameStatusPanel.setBounds(700, 0, 300, 600);// set its positions and width-height
        add(gameStatusPanel);                                        // add it to JFrame

        nextButton.setBounds(600, 235, 95, 30);     // set bounds of next set button (LINE: 22)
        mainGamePanel.add(nextButton);                               // add it to mainGamePanel JPanel

        nextButton.addActionListener(new AbstractAction("test") {    // actionListener method for next set button
            public void actionPerformed(ActionEvent e) 
            {
                resetGame();                                         // resetgame();
            }
            });
        nextButton.setVisible(false);                          // set visibility to false initially when needed it will be active
        //-------------------------------------------------------------------PLAYER1---------------------------------------------
        player1Name = new JLabel(player1.getName());                       // add player1 name to its label
        player1Score = new JLabel(player1.getName()+"'s Score: "+player1.getScore());   // put player1 score to the label
        player1SetWin = new JLabel("Set Victory: "+player1.getSetNum());                // put player1 setNum to label
        player1Button = new JButton("Change");                                     // initiliaze player1's button
        player1Button.addActionListener(handler);                                       // add action listener to that button
        player1Card1 = new JLabel(player1.getCards().get(0).getIcon());           // get icon of all player1's cards
        player1Card2 = new JLabel(player1.getCards().get(1).getIcon());
        player1Card3 = new JLabel(player1.getCards().get(2).getIcon());
        player1Card4 = new JLabel(player1.getCards().get(3).getIcon()); 
        player1Card5 = new JLabel(player1.getCards().get(4).getIcon());
        checkp1c1 = new JCheckBox();                                                    // initiliaze all player1's cards checkboxes
        checkp1c2 = new JCheckBox();
        checkp1c3 = new JCheckBox();
        checkp1c4 = new JCheckBox();
        checkp1c5 = new JCheckBox();

        checkp1c1.setBounds(130,130,20,20);                            // set bounds of all player1's componenets
        checkp1c2.setBounds(230,130,20,20);
        checkp1c3.setBounds(330,130,20,20);
        checkp1c4.setBounds(430,130,20,20);
        checkp1c5.setBounds(530,130,20,20);
        player1Name.setBounds(0, 50, 150, 15);
        player1Score.setBounds(0, 50, 150, 50);
        player1SetWin.setBounds(150, 50, 100, 50);
        player1Button.setBounds(0, 100, 95, 30);
        player1Card1.setBounds(100, 20, 78, 108);
        player1Card2.setBounds(200, 20, 78, 108);
        player1Card3.setBounds(300, 20, 78, 108);
        player1Card4.setBounds(400, 20, 78, 108);
        player1Card5.setBounds(500, 20, 78, 108);

        setLabel1 = new JLabel();                                                       // initiliaze labels that prints player scores at the end of every set
        setLabel2 = new JLabel();   
        setLabel3 = new JLabel();
        setLabel4 = new JLabel();
        setLabel5 = new JLabel();

        gameStatusPanel.add(player1Name);                                               // add all player1 componenets to their corrosponding panel
        gameStatusPanel.add(player1Score);
        gameStatusPanel.add(player1SetWin);
        gameStatusPanel.add(player1Button);
        mainGamePanel.add(player1Card1);
        mainGamePanel.add(player1Card2);
        mainGamePanel.add(player1Card3);
        mainGamePanel.add(player1Card4);
        mainGamePanel.add(player1Card5);
        mainGamePanel.add(checkp1c1);
        mainGamePanel.add(checkp1c2);
        mainGamePanel.add(checkp1c3);
        mainGamePanel.add(checkp1c4);
        mainGamePanel.add(checkp1c5);
        //------------------------------------------------------------------------PLAYER2----------(MAKE THE SAME THINGS AS PLAYER1 FOR PLAYER2)--NOT COMMENTING-----
        player2Name = new JLabel(player2.getName());
        player2Score = new JLabel(player2.getName()+"'s Score: "+player2.getScore());
        player2SetWin = new JLabel("Set Victory: "+player2.getSetNum());
        player2Button = new JButton("Change");
        player2Button.addActionListener(handler);
        player2Card1 = new JLabel(player2.getCards().get(0).getIcon());
        player2Card2 = new JLabel(player2.getCards().get(1).getIcon());
        player2Card3 = new JLabel(player2.getCards().get(2).getIcon());
        player2Card4 = new JLabel(player2.getCards().get(3).getIcon()); 
        player2Card5 = new JLabel(player2.getCards().get(4).getIcon());
        checkp2c1 = new JCheckBox();
        checkp2c2 = new JCheckBox();
        checkp2c3 = new JCheckBox();
        checkp2c4 = new JCheckBox();
        checkp2c5 = new JCheckBox();

        checkp2c1.setBounds(130,490,20,20);
        checkp2c2.setBounds(230,490,20,20);
        checkp2c3.setBounds(330,490,20,20);
        checkp2c4.setBounds(430,490,20,20);
        checkp2c5.setBounds(530,490,20,20);
        player2Name.setBounds(0, 400, 150, 15);
        player2Score.setBounds(0, 400, 150, 50);
        player2SetWin.setBounds(150, 400, 100, 50);
        player2Button.setBounds(0, 450, 95, 30);
        player2Card1.setBounds(100, 375, 78, 108);
        player2Card2.setBounds(200, 375, 78, 108);
        player2Card3.setBounds(300, 375, 78, 108);
        player2Card4.setBounds(400, 375, 78, 108);
        player2Card5.setBounds(500, 375, 78, 108);

        gameStatusPanel.add(player2Name);
        gameStatusPanel.add(player2Score);
        gameStatusPanel.add(player2SetWin);
        gameStatusPanel.add(player2Button);
        mainGamePanel.add(player2Card1);
        mainGamePanel.add(player2Card2);
        mainGamePanel.add(player2Card3);
        mainGamePanel.add(player2Card4);
        mainGamePanel.add(player2Card5);
        mainGamePanel.add(checkp2c1);
        mainGamePanel.add(checkp2c2);
        mainGamePanel.add(checkp2c3);
        mainGamePanel.add(checkp2c4);
        mainGamePanel.add(checkp2c5);
        //------------------------------------------------------------------COMMON CARDS----------------------------------------------
        commonCard1 = new JLabel(commonCards.get(0).getIcon());                   // get icon of all common cards
        commonCard2 = new JLabel(commonCards.get(1).getIcon());
        commonCard3 = new JLabel(commonCards.get(2).getIcon());

        commonCard1.setBounds(200, 200, 78, 108);                      // set their bounds
        commonCard2.setBounds(300, 200, 78, 108);
        commonCard3.setBounds(400, 200, 78, 108);

        mainGamePanel.add(commonCard1);                                                 // add them
        mainGamePanel.add(commonCard2);
        mainGamePanel.add(commonCard3);

        startPoint();                                                                   // start of the game logic
    }
    
    public void createDeck()
    {                                                    // add all cards to deck arraylist
        deck.add(c2);     deck.add(h2);       deck.add(s2);       deck.add(d2);
        deck.add(c3);     deck.add(h3);       deck.add(s3);       deck.add(d3);
        deck.add(c4);     deck.add(h4);       deck.add(s4);       deck.add(d4);
        deck.add(c5);     deck.add(h5);       deck.add(s5);       deck.add(d5);
        deck.add(c6);     deck.add(h6);       deck.add(s6);       deck.add(d6);
        deck.add(c7);     deck.add(h7);       deck.add(s7);       deck.add(d7);
        deck.add(c8);     deck.add(h8);       deck.add(s8);       deck.add(d8);
        deck.add(c9);     deck.add(h9);       deck.add(s9);       deck.add(d9);
        deck.add(c10);    deck.add(h10);      deck.add(s10);      deck.add(d10);
        deck.add(cjack);  deck.add(hjack);    deck.add(sjack);    deck.add(djack);
        deck.add(cqueen); deck.add(hqueen);   deck.add(squeen);   deck.add(dqueen);
        deck.add(cking);  deck.add(hking);    deck.add(sking);    deck.add(dking);
        deck.add(cace);   deck.add(hace);     deck.add(sace);     deck.add(dace);
        for (int i = 0; i<deck.size(); i++)              // for all cards
        {
            int idx = rand.nextInt(0,52);   // choose a number between 0 and 51
            Card temp = deck.get(idx);                   // take card at the chosen index and store it 
            deck.set(idx, deck.get(i));                  // take the first card from arraylist and put it to chosen index
            deck.set(i, temp);                           // put card at the temp to the first index of arraylist
        }
        int count = 0;
        for(int i = 0; i < 52; i++)                      // a method to print all cards and card count just to debuging 
        {
            System.out.println(deck.get(i));
            count+=1;
        }
        System.out.println(count);
    }
    public void distCards()                              // this method distribute cards to both players and to the middle of the table(3 common cards)
    {
        for (int i = 0; i<5; i++)                        // for 5 times
        {
            player1.addCard(deck.get(i));                // take first card and give it to player 1
            deck.remove(i);                              // remove first card from deck
            player2.addCard(deck.get(i));                // take next card and give it to player 2
            deck.remove(i);                              // remove that card from deck
        }
        for (int j = 0; j<3; j++)                        // for 3 times
        {
            commonCards.add(deck.get(j));                // add card at given index to commonCards arraylist
            deck.remove(j);                              // remove that card from deck
        }
    }
    public void startPoint()                             // logical start
    {   
        commonCard1.setIcon(backred.getIcon());          // flip back commoncards
        commonCard2.setIcon(backred.getIcon());
        commonCard3.setIcon(backred.getIcon());
        player2Card1.setIcon(backred.getIcon());         // flip back player2's card at the start of the game
        player2Card2.setIcon(backred.getIcon());
        player2Card3.setIcon(backred.getIcon());
        player2Card4.setIcon(backred.getIcon());
        player2Card5.setIcon(backred.getIcon());

                                                    // THIS PART IS ONLY FOR TESTING PURPOSE FOR CALCULATE SCORE (TO SHOW THAT STRAIGHT AND SUIT COUNT WORKS)
        deck.add(player1.getCards().get(0));
        deck.add(player1.getCards().get(1));
        deck.add(player1.getCards().get(2));
        deck.add(player1.getCards().get(3));
        deck.add(player1.getCards().get(4));
        player1.resetHand();
        player1.addCard(c2);
        player1.addCard(h3);
        player1.addCard(s4);
        player1.addCard(d5);
        player1.addCard(c6);
        

        turnCardChange();                                // call turnCardChange and set card images for current player turn 
        calculateScore(playerTurn);                      // calculate score for current player turn
    }
    public void turnChange()                             // turnChange method
    {
        if (playerTurn.equals(player1))                  // if it is player1's turn
        {
            playerTurn = player2;                        // make it player2's turn
        } else {                                         // if it is not
            playerTurn = player1;                        // make it player1's turn
        }
    }
    public void turnCardChange()                         // a method to change status of various things according to player turn
    {                                                    // a couple of arrays to store all necessary elements to make thing faster and easier
        JLabel[] player1CardLabels = {player1Card1, player1Card2, player1Card3, player1Card4, player1Card5};
        JLabel[] player2CardLabels = {player2Card1, player2Card2, player2Card3, player2Card4, player2Card5};
        JCheckBox[] player1Check = {checkp1c1, checkp1c2, checkp1c3, checkp1c4, checkp1c5};
        JCheckBox[] player2Check = {checkp2c1, checkp2c2, checkp2c3, checkp2c4, checkp2c5};
        if (playerTurn.equals(player1))                  // if it is player1's turn
        {
            for (int i = 0;i < player1CardLabels.length;i++)    // for 5 times
            {
                player1CardLabels[i].setIcon(playerTurn.getCards().get(i).getIcon());   // open all of player1's card
                player1Button.setEnabled(true);        // enable player1's "change" button
                player2Button.setEnabled(false);       // disable playe2's "change" button
                player1Check[i].setEnabled(true);      // enable all of player1's checkboxes
                player2Check[i].setEnabled(false);     // disable all of player2's checkboxes
            }
        } else {                                         // if it is player2's turn
            for (int i = 0;i < player2CardLabels.length;i++)    // for 5 times
            {
                player2CardLabels[i].setIcon(playerTurn.getCards().get(i).getIcon());   // open all of player2's card
                player2Button.setEnabled(true);        // enable player2's "change" button
                player1Button.setEnabled(false);       // disable player1's "change" button
                player2Check[i].setEnabled(true);      // enable all of player2's checkboxes
                player1Check[i].setEnabled(false);     // disable all of player1's checkboxes
            }
        }
    }
    public void changeCard()                                    // this method changes selected cards from players hands
    {
        JCheckBox[] player1Check = {checkp1c1, checkp1c2, checkp1c3, checkp1c4, checkp1c5};
        JCheckBox[] player2Check = {checkp2c1, checkp2c2, checkp2c3, checkp2c4, checkp2c5};
        JLabel[] player1CardLabels = {player1Card1, player1Card2, player1Card3, player1Card4, player1Card5};
        JLabel[] player2CardLabels = {player2Card1, player2Card2, player2Card3, player2Card4, player2Card5};
        if (playerTurn.equals(player1))                         // if it is player1's turn 
        {
            for (int i = 0;i<player1Check.length;i++)           // for 5 times
            {
                if(player1Check[i].isSelected())                // checks all checkboxes if it is selected or not 
                {
                    deck.add(rand.nextInt(deck.size()), playerTurn.getCards().get(i));      // add players cards to deck
                    int cardIdx = rand.nextInt(deck.size());    // choose a random integer between 0 and 51
                    playerTurn.setCard(i, deck.get(cardIdx));   // take card from deck which is index is cardIdx and add it to player hand
                    deck.remove(cardIdx);                       // remove that card from deck
                    player1CardLabels[i].setIcon(playerTurn.getCards().get(i).getIcon());   // get new icon of changed card and show it
                    player1Check[i].setSelected(false);       //make that checkbox unselected
                }
            }
        }
        else if (playerTurn.equals(player2)) {                  // if it is player2's turn
            for (int i = 0; i<player2Check.length;i++)          // for 5 times (for all componenets)
            {
                if(player2Check[i].isSelected())                // checks all checkboxes if it is selected or not 
                {
                    deck.add(rand.nextInt(deck.size()), playerTurn.getCards().get(i));      // add players cards to deck
                    int cardIdx = rand.nextInt(deck.size());    // choose a random integer between 0 and 51
                    playerTurn.setCard(i, deck.get(cardIdx));   // take card from deck which is index is cardIdx and add it to player hand
                    deck.remove(cardIdx);                       // remove that card from deck
                    player2CardLabels[i].setIcon(playerTurn.getCards().get(i).getIcon());   // get new icon of changed card and show it
                    player2Check[i].setSelected(false);       //make that checkbox unselected
                }
            }
        }
    }
    private int getCardValue(String card) {     // this method return cards real value (14 for ace - 13 for king - 12 for queen - 11 for jack)
        switch (card) {
            case "a": return 14;
            case "k": return 13;
            case "q": return 12;
            case "j": return 11;
            default: return Integer.parseInt(card);
        }
    }
    public void calculateScore(player player)                   // this methods calculate score for given player object
    {
        System.out.println("-------------------------------------------------");
        int score = 0;                                          // score is 0 initially
        int straightCount = 0;                                  // we will use this for counting how many straight cards are there
        int lastStraight = 0;                                   // and we will use this to determine what is the last straight card and also this will help to determine what is the first straight card
        HashMap<String, Integer> suitMap = new HashMap<>();     // create a hashmap for suit counting
        HashMap<Integer, Integer> valueMap = new HashMap<>();   // create a hashmap again but now for value counting
        ArrayList<Card> tempList = new ArrayList<Card>();       // a arraylist to add 5+3 cards
        ArrayList<Integer> sortedValues = new ArrayList<>();    // a arraylist for sorted values
        ArrayList<Integer> removedCards = new ArrayList<>();    // a arraylist to put removed cards from templist and check for future stuff
        tempList.addAll(player.getCards());                     // take all cards of player and put them to the templist
        if (isEndOfSet)                                         // if isEndOfSet flag is true then we must add commoncards to templist for calculate our final score
        {
            tempList.add(commonCards.get(0));             // add common cards
            tempList.add(commonCards.get(1));
            tempList.add(commonCards.get(2));
        }
        for (int i = 0; i < tempList.size();i++)                // and add all cards stored in templist to sortedvalues arraylist too
        {
            sortedValues.add(getCardValue(tempList.get(i).getNumber()));
        }
        Collections.sort(sortedValues);                         // then sort this arraylist
        for(int i = 0; i<tempList.size(); i++)
        {
            suitMap.put(tempList.get(i).getSuit(), suitMap.getOrDefault(tempList.get(i).getSuit(), 0) + 1);     // start counting suit numbers
        }
        System.out.println("templist: "+tempList);              // i just print stuff for debugging nothing important
        System.out.println("size: "+tempList.size());
        for(int j = tempList.size()-1;j>=0;j--)                 // start from the end of templist
        {
            if(suitMap.get(tempList.get(j).getSuit()) >= 5)     // if that cards suit is more than or equal to 5 in suitMap than we must add it to scoring (which means we need to calculate score for this case)
            {
                score += getCardValue(tempList.get(j).getNumber());     // add that cards value to score
                tempList.remove(j);                                     // and remove that card from templist (because i want to calculate remaining cards score and i don't want these cards to mix things up)
            }
        }
        score*=6;                                               // finally multiply this score with 6
        for(int i = 0;i<sortedValues.size()-1;i++)              // now start looking for straight we are going to use sortedvalues
        {
            if (sortedValues.get(i)+1 == sortedValues.get(i+1)) // if first indexes value+1 is equal to next indexes value this means first index and the one that comes after it creates a straighty case
            {
                straightCount++;                                // so we are increasing straight count by 1                  
                System.out.println("count: "+straightCount);
                if(straightCount >= 4)                          // and if we are in a place where our count is 4 or more (which means we have a minimum 5 card that straight)
                {
                    lastStraight = sortedValues.get(i+1);       // we determine our last straight (one after from current index)
                }
            } else if (sortedValues.get(i) != sortedValues.get(i+1))    // if current 2 cards not set a straighty we must break the cycle
            {
                straightCount = 0;                              // reset count
            }
        }
        System.out.println("LAST"+lastStraight);
        System.out.println("FIRST"+(lastStraight-straightCount));
        if (straightCount >= 4)                                 // now if we have a straight case after the loop ends
        {
            for(int k = tempList.size()-1;k>=0;k--)             // take cards from the end of the templist
            {
                if(getCardValue(tempList.get(k).getNumber()) <= lastStraight && getCardValue(tempList.get(k).getNumber()) >= lastStraight-straightCount &&!removedCards.contains(getCardValue(tempList.get(k).getNumber())))    // if templist cards value == to valuelist value
                {
                    removedCards.add(getCardValue(tempList.get(k).getNumber()));    // add that card to removed cards arraylist
                    System.out.println("removed"+removedCards);
                    tempList.remove(k);                                             // and remove it from templist
                }
            }
            for (int k = 0; k<removedCards.size();k++)                              // now for all removedcards
            {
                score += removedCards.get(k);                                       // add their values to score
            }
            score *=5;                                                              // and finally multiply score by 5
            System.out.println("straight sum: "+score);
        }
        System.out.println("templist: "+tempList);
        System.out.println("size: "+tempList.size());
        System.out.println("sorted list: "+sortedValues);
        System.out.println("size: "+tempList.size());
        for(int i = 0; i<tempList.size(); i++)
        {
            valueMap.put(getCardValue(tempList.get(i).getNumber()), valueMap.getOrDefault(getCardValue(tempList.get(i).getNumber()), 0) + 1);
        }
        for (Integer i : valueMap.keySet()) 
        {
            int value = i;
            System.out.println("sum of leftovers: "+value*valueMap.get(i)*valueMap.get(i));
            score += (value*valueMap.get(i))*valueMap.get(i);
        }
        System.out.println(" toplam: "+score);
        player.setScore(score);                                                     // set players final score
        if (player.equals(player1))                                                 // if it is player1's turn
        {
            player1Score.setText(player.getName()+"'s Score: "+player.getScore());  // update its score label text
        } else {
            player2Score.setText(player.getName()+"'s Score: "+player.getScore());  // if not update player2's score label text
        }
        System.out.println(player.getScore());
        for (String i : suitMap.keySet()) {
            System.out.println("suit: " + i + " number: " + suitMap.get(i));
        }
        for (Integer i : valueMap.keySet()) {
            System.out.println("value: " + i + " number: " + valueMap.get(i));
        }
    }
    public void checkWinner()                           // this method determines is there a winner or not
    {
        System.out.println("winner check");
        JLabel[] setLabels = {setLabel1,setLabel2,setLabel3, setLabel4, setLabel5};
        player prevPlayer;                              // create a prevplayer variable to use it later
        if (playerTurn.equals(player1))                 // if it is player1's turn
        {
            prevPlayer = player2;                       // prev is player2
        } else {
            prevPlayer = player1;                       // else prev is player1
        }
        if (prevPlayer.getScore() != 0)                 // if prevplayers score is NOT 0 (=means other player played and has a score now it is turn of last player before end of the set)
        {
            isEndOfSet = true;                          // set isEndOfSet is true 
            calculateScore(player1);                    // calculate both players score (5+3 card)
            calculateScore(player2);
            isEndOfSet = false;                         // set it back to false
            setLabels[setNum-1].setText("Set"+setNum+": Player1: "+player1.getScore()+" | Player2: "+player2.getScore());   //  create set label
            setLabels[setNum-1].setBounds(setLabelX, setLabelY, 300, 30);   // set bounds of label
            gameStatusPanel.add(setLabels[setNum-1]);   // add label to panel
            gameStatusPanel.revalidate();               // update gui
            gameStatusPanel.repaint();                  
            setLabelY+=50;                              // increase y coordinate for labels
            setNum++;                                   // increase setNum by 1
            if (player1.getScore() > player2.getScore())                        // if player1's score greater than player2's score
            {
                System.out.println("winner: "+player1.getName());               
                player1.setSetNum(player1.getSetNum()+1);                       // increase player1's winned set number by 1
                player1SetWin.setText("Set Victory: "+player1.getSetNum());     // update setNum label
                System.out.println(player1.getSetNum());
            } else {
                System.out.println("winner: "+player2.getName());
                player2.setSetNum(player2.getSetNum()+1);                       // increase player2's winned set number by 1
                player2SetWin.setText("Set Victory: "+player2.getSetNum());     // update setNum label
                System.out.println(player2.getSetNum());
            }
            if (player1.getSetNum() == 3 || player2.getSetNum() == 3)   // if either of players win 3 sets it measn game over
            {
                winner = true;                                          // set winner flag true
                nextButton.setText("Play Again");                  // make "progress" button label Play Again
                endSet();                                               // call endSet()
            } else {
                nextButton.setText("Next Set");                    // else make "progress" button label Next Set
                endSet();                                                        
                isEndOfSet = true;
            }
        }
    }
    public void endSet() {                                              // this method makes set up for the end of the set
        JLabel[] commonCardLabels = {commonCard1, commonCard2, commonCard3};
        JCheckBox[] player1Check = {checkp1c1, checkp1c2, checkp1c3, checkp1c4, checkp1c5};
        JCheckBox[] player2Check = {checkp2c1, checkp2c2, checkp2c3, checkp2c4, checkp2c5};
        for (int i = 0; i < commonCardLabels.length; i++) {             // for all commonCards
            commonCardLabels[i].setIcon(commonCards.get(i).getIcon());  // open all common cards
        }
        for (int i = 0; i < player1Check.length; i++) {                 // disable all of players checkboxes
            player1Check[i].setEnabled(false);
            player2Check[i].setEnabled(false);
        }
        player1Button.setEnabled(false);                              // disable player1's change button
        player2Button.setEnabled(false);                              // disable player2's change button
        nextButton.setVisible(true);                              // set visible next button
        return;
    }
    public void resetGame()                                             // this method triggers with next buttons action listener (LINE: 95)
    {
        JLabel[] player1CardLabels = {player1Card1, player1Card2, player1Card3, player1Card4, player1Card5};
        JLabel[] player2CardLabels = {player2Card1, player2Card2, player2Card3, player2Card4, player2Card5};
        JLabel[] commonCardLabels = {commonCard1, commonCard2, commonCard3};
        JLabel[] setLabels = {setLabel1,setLabel2,setLabel3, setLabel4, setLabel5};
        if (winner)                                                     // if winner flag is true (must reset all game to start again)
        {
            System.out.println("gameover");
            player1.setSetNum(0);                                   // set setNums to 0 for all players
            player2.setSetNum(0); 
            player1SetWin.setText("Set Victory: "+player1.getSetNum()); // set new set victory labels
            player2SetWin.setText("Set Victory: "+player2.getSetNum());
            for (int i = 0; i<setLabels.length;i++)                     // for all set labels (the ones that show both players scores for every set)
            {
                setLabels[i].setText("");                          // set all of them to "" (RESET)
            }
            setLabelX = 0;                                              // reset setLabel x position
            setLabelY = 150;                                            // reset setLabel y position
            setNum = 1;                                                 // set setNum to 1                  
            playerTurn = player1;                                       // make it player1's turn
            winner = false;                                             // set winner flag to false
        }
        nextButton.setVisible(false);                             // set visibility of next Set/play again button to false                        
        isEndOfSet = false;                                             // set isEndOfSet flag to false
        player1.setScore(0);                                      // reset players score
        player2.setScore(0);
        player1Score.setText(player1.getName()+"'s Score: "+player1.getScore());    // update players score labels
        player2Score.setText(player2.getName()+"'s Score: "+player2.getScore());
        for (int i = 0;i<player1CardLabels.length;i++)                  // for all players card label (for 5 times)
        {
            deck.add(rand.nextInt(deck.size()), player1.getCards().get(i));         // add player1's and player2's cards to deck
            deck.add(rand.nextInt(deck.size()), player2.getCards().get(i));
        }
        player1.resetHand();                                            // reset both players hand
        player2.resetHand();
        for (int i = 0;i<player1CardLabels.length;i++)
        {
            int cardIdx = rand.nextInt(deck.size());                    // choose a random number between 0 and 51
            player1.addCard(deck.get(cardIdx));                         // take a card from choosen index inside deck and give it to the player1's hand
            deck.remove(cardIdx);                                       // remove that card from th deck
            int cardIdx2 = rand.nextInt(deck.size());                   // choose a random number again
            player2.addCard(deck.get(cardIdx2));                        // take a card from choosen index inside deck and give it to the player2's hand
            deck.remove(cardIdx2);                                      // remove that card from the deck
            player1CardLabels[i].setIcon(backred.getIcon());            // close both players card
            player2CardLabels[i].setIcon(backred.getIcon());
        }
        for (int i = 0;i<commonCardLabels.length;i++)                   // for all common cards
        {
            deck.add(rand.nextInt(deck.size()), commonCards.get(i));    // add all commoncards to deck
            int cardIdx3 = rand.nextInt(deck.size());                   // choose a random number between 0 and 51
            commonCards.set(i, deck.get(cardIdx3));                     // change these new choosen cards from deck with the ones in the commoncards arraylist
            deck.remove(cardIdx3);                                      // remove these cards from the deck
        }
        startPoint();                                                   // go back to start point
    }
    private class ButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)                  // main game cycle (when clicked change button)
        {
            changeCard();
            calculateScore(playerTurn);
            checkWinner();
            if (isEndOfSet || winner)                                   // if there is a winner or if it is the end of the sets
            {
                return;                                                 // do not continue cycle
            }
            turnChange();
            turnCardChange();
            calculateScore(playerTurn);
        }
    }
}