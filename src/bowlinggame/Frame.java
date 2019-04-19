package bowlinggame;
/**
 * The Frame class Creates a frame object that stores important scoring information. 
 * 
 * @version 1.0
 * @author yeetboi
 * @author Tyler Grady, Bryce Soule
 */
public class Frame {
    
    //array of rolls whcih can just be ints
    //keep track of which ones are strikes, so maybe make a roll class to check that
    //then if the last one is a strike/spare, add the current roll onto the strike/spare
    //also check if two rolls ago it is a strike, as we need to add that one too
    private int score;
    private boolean isStrike;
    private boolean isSpare;
    /**
     * 
     */
    public Frame(){
        this.score = 0;
        this.isStrike = false;
        this.isSpare = false;
    }
    
    /**
     *
     * @return score of the frame. (e.g. 15)
     */
    public int getScore(){
        return score;
    }
    
    /**
     *
     * @return the strike status. True or False
     */
    public boolean getStrikeStatus(){
        return isStrike;
    }
    
    /**
     *
     * @param isStrike is either true or false if they got a strike
     */
    public void setStrikeStatus(boolean isStrike){
        this.isStrike = isStrike;
    }
    
    /**
     *
     * @param score is the score of the frame.
     */
    public void setScore(int score){
        this.score = score;
    }
    
    /**
     *
     * @param score is the score of the frame current frame
     * @param previousScore is the previous score from a strike or spare that is being added onto.
     */
    public void addScore(int score, int previousScore){
        this.score = score + previousScore;
    }
    
    /**
     *
     * @return spare status, is true or false
     */
    public boolean getSpareStatus(){
        return isSpare;
    }
    
    /**
     *
     * @param isSpare is how to tell if a frame is a spare, is true or false
     */
    public void setSpareStatus(boolean isSpare){
        this.isSpare = isSpare;
    }
}
