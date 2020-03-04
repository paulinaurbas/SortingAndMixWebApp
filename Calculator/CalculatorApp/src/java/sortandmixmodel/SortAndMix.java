/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortandmixmodel;
import annotaction.UseCase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Model class
 * @author Paulina Urbas
 * @version 5.0
 */
public class SortAndMix {
    
/**
 * Session ID 
 * @author Paulina Urbas
 * @version 5.0
 */
  private  String SessionID = "";
/**
 * Get sessionID
 * @author Paulina Urbas
 * @version 5.0
 * @return session ID
 */
    public String getSessionID() {
        return SessionID;
    }
  /**
   * Get sentence before operation
   * @author Paulina Urbas
   * @version 5.0
   * @return sentence before operation
   */
    public String getSentenceBefore() {
        return sentenceBefore;
    }

     /**
     * Set sessionID
     * @author Paulina Urbas
     * @version 5.0
     * @param SessionID sessionID 
     */
    public void setSessionID(String SessionID) {
        this.SessionID = SessionID;
    }
    /**
     * Set sentence
     * @author Paulina Urbas
     * @version 5.0
     * @param sentenceBefore sentence before operation
     */
    public void setSentenceBefore(String sentenceBefore) {
        this.sentenceBefore = sentenceBefore;
    }

    /**
     * Sentence input
     * @author Paulina Urbas
     * @version 1.0
     */
    private String sentenceBefore; 
  
    /**
     * Operation number from user
     * @author Paulina Urbas
     * @version 1.0
     * 
     */
     private int sortOrMix;
    /**
     * List with operation from user
     * @author Paulina Urbas
     * @version 5.0 
     */
    private List <String> HistoryOfOperation;
    /**
     * Add  information to list
     * @author Paulina Urbas
     * @version 5.0 
     * @param value to add to the history of operation
     */
    public void AddToHistoryOfOperation(String value)
    {
        HistoryOfOperation.add(value);
    }
    /**
     * Set list to the history of operation
     * @author Paulina Urbas
     * @version 5.0 
     * @param HistoryOfOperation history of user operation in session
     */
    public void setHistoryOfOperation( List <String> HistoryOfOperation) {
        this.HistoryOfOperation = HistoryOfOperation;
    }
    /**
     * Get information from list
     * @author Paulina Urbas
     * @version 5.0 
     * @return List
     */
    public  List <String> getHistoryOfOperation() {
        return HistoryOfOperation;
    }
 
     /**
     * Array list with split words 
     * Changed String[] to ArrayList
     * @author Paulina Urbas
     * @version 2.0
     * 
     */
     private List<String> sentenceArray = new ArrayList<String>(); //new element
      //private String[] sentenceArray;
     
     /**
     * Sentence output after operation
     * @author Paulina Urbas
     * @version 1.0
     */
    private String outSentence;
    /** Model constructor
     * @author Paulina Urbas
     * @version 1.0
     */
    public SortAndMix(){
        this.HistoryOfOperation = new ArrayList<String> ();
    }
    
    /**
     * Setter sentence 
     * @author Paulina Urbas
     * @param outSentence sentence afetr operation
     * @version 1.0
     */
    public void setOutSentence(String outSentence) {
        this.outSentence = outSentence;
    }
    /**
     * Getter Sentence 
     * @author Paulina Urbas
     * @return String
     * @version 1.0
     */
    public String getOutSentence() {
        return outSentence;
    }
    /**
     * Getter number
     * @author Paulina Urbas
     * @return int
     * @version 1.0
     */
    public int getSortOrMix() {
        return sortOrMix;
    }
    /**
     *  Setter, set number what user wants to do 
     * @author Paulina Urbas
     * @param sortOrMix the number whitch user gave
     * @version 1.0
         * @param args arguments group 
     */
    public void setSortOrMix(int sortOrMix, int...args) {
        this.sortOrMix = sortOrMix;
    }
    /**
    *  Method is checking if input number is correct. It throws my own exepction
    * @author Paulina Urbas
    * @param number the number whitch user give
    * @version 3.0
     * @throws sortandmixmodel.OneOrTwoMyException
     */
    public void CheckIfNumberIsCorrect(int number) throws OneOrTwoMyException
    {
        if(number != 1 && number != 2)
        {
            throw new OneOrTwoMyException("You can only give 1 or 2 number");
        }
    }
    
/**
 * Setter sentence
 * Added throwning exception when senetnce is null or empty
 * @author Paulina Urbas
 * @param sentence the sentence whitch user gave
 * @version 2.0
 */
    public void setSentence(String sentence) {
        if(sentence.trim().isEmpty() || sentence== null)
        {
            throw new RuntimeException("Subclasses of Valueables cannot take in an empty String or null value for the \"name\" constructor");
        }
        else
        {
        this.sentenceBefore = sentence;
    }
    }
    /**
     * Method split string by whitespace 
     * In this metod I add adding array to the list
     * @author Paulina Urbas
     * @version 2.0
     */
    public void splitString()
    {
       String [] tmp = this.sentenceBefore.split(" ");
       this.sentenceArray =  Arrays.asList(tmp);
    }
 
    /**
     * Method uses bubblesort to sort in alpahbet correct sentence
     * Changed from string array to list, add getters and settes 
     * @author Paulina Urbas
     * @version 2.0
     */
    //using annotation
    @UseCase(id = 1, author = "Paulina Urbas", importance = UseCase.Importance.RED)
     public void sortStringBubble( )
      {
           List<String> x = this.sentenceArray;
            int j;
            boolean flag = true;  // will determine when the sort is finished
            String temp;

            while ( flag )
            {
                  flag = false;
                  for ( j = 0;  j < x.size() - 1;  j++ )
                  {
                     
                         if ( x.get(j).compareToIgnoreCase(x.get(j+1)) > 0 )
                          {                      
                              // ascending sort
                                      temp = x.get(j); //new element
                                      x.set(j, x.get(j+1));     // swapping
                                      x.set(j+1, temp);
                                      flag = true;
                           }
                   }
            }
      }
    /**
     * Method to mix words in sentence 
     * @author Paulina Urbas
     * @version 2.0
     */
    public void shuffleArray()
    {
       int n = this.sentenceArray.size();
       Random r = new Random();         
        for (int i = n-1; i > 0; i--) { 
               
            // Pick a random index from 0 to i 
            int j = r.nextInt(i); 
            // Swap arr[i] with the element at random index 
            String temp = this.sentenceArray.get(i); 
            this.sentenceArray.set(i, this.sentenceArray.get(j)); 
            this.sentenceArray.set(j, temp); 
        } 
    }
    /**
     * Method to get string array 
     * @author Paulina Urbas
     * @return String[]
     * @version 1.0
     */
    public List<String> getSentenceArray() {
        return sentenceArray;
    }
/**
 * Method to set string array list
 * Changed array for list 
 * @author Paulina Urbas
 * @param sentenceArray array with words from sentence whitch user gave
 * @version 2.0
 */
    public void setSentenceArray(List<String> sentenceArray) {
        this.sentenceArray = sentenceArray;
    }
 /**
  * Method to connect array to one string
  * @author Paulina Urbas
  */
    public void convertArrayToString() {
       this.outSentence = String.join(" ", this.sentenceArray);
 }
    /**
     * Method to first split sentence, next mix and connected to new string 
     * @author Paulina Urbas
     * @version 1.0
     */
    public void mixSentence()
    {
        this.splitString(); 
        this.shuffleArray();
        this.convertArrayToString();
    }
   /**
     * Method to first split sentence, next sort and connected to new string 
     * @author Paulina Urbas
     * @version 1.0
     */
    public void sortSentence()
    {
        this.splitString();
        this.sortStringBubble();
        this.convertArrayToString();
    }
}
