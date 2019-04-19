package bowlinggame;

import java.util.List;
//TODO list. for Tyler not for grade
//make a random rolling class so that you can even call that for both of the rolls. 



//if you have a strike, the next two rolls are added onto it. With this is mind, you need to check the next two rolls. 
//So, if the first frame is a strke, and the second frame is a strike, the next roll of the next frame must also be added.
//2 or more as long as the 2nd frame is not a strike.

/**
 *
 * Is the scorer class that deals with all the sweet spicy bowling calculations
 * 
 * @version 1.0
 * @author yeetboi
 * @author Tyler Grady, Bryce Soule
 */
public final class RollScorer {
    
    private int roll1;
    private int roll2;
    
    /**
     *
     */
    public RollScorer(){
        
    }
    
    /**
     *
     * @param roll1 is the first roll. A strike in this case. Yeet.
     * @param currentFrame Is the current frame (e.g. frame1)
     * @param frames is a list of all the frames in the current game. Should be ten, but supports more
     */
    public void scoreWithOneRoll(int roll1, Frame currentFrame, List<Frame> frames){
        currentFrame.setStrikeStatus(true);
        currentFrame.setScore(roll1);
        //okay, so, what's going on in this mess is we need to make sure that there is a previous frame, so the size must be above 0.
        //then, we need to check that the previous frame was either a spare or a strike.
        //okay, then, we need to add the score to the previous frame. so we call add score for the current roll and the score that was held on the previous frame.
        if(frames.indexOf(currentFrame) >= 1 && ((frames.get(frames.indexOf(currentFrame) - 1).getStrikeStatus() == true) || (frames.get(frames.indexOf(currentFrame) - 1).getSpareStatus() == true))){
            frames.get(frames.indexOf(currentFrame) - 1).addScore(roll1, frames.get(frames.indexOf(currentFrame) - 1).getScore());
        }
        //okay, so, what's going on in this mess is we need to make sure that there is a previous frame, so the size must be above 0.
        //then, we need to check that the 2nd previous frame was either a spare or a strike.
        //okay, then, we need to add the score to the previous frame. so we call add score for the current roll and the score that was held on the frame 2 frames ago.
        if(frames.indexOf(currentFrame) >= 2 && (frames.get(frames.indexOf(currentFrame) - 2).getStrikeStatus() == true) && (frames.get(frames.indexOf(currentFrame) - 1).getStrikeStatus() == true)){
            frames.get(frames.indexOf(currentFrame) - 2).addScore(roll1, frames.get(frames.indexOf(currentFrame) - 2).getScore());
        }
    
    }
    
    /**
     *
     * @param roll1 is the first roll of the frame. shouldn't be 10, but if it is we call scoreWithOneRoll
     * @param roll2 is the second roll of the frame
     * @param currentFrame Is the current frame (e.g. frame1)
     * @param frames is a list of all the frames in the current game. Should be ten, but supports more
     */
    public void scoreWithTwoRolls(int roll1, int roll2, Frame currentFrame, List<Frame> frames){
        if(roll1 == 10){
            scoreWithOneRoll(roll1, currentFrame, frames);
        }
        else{
            currentFrame.setScore(roll1 + roll2);
            if((roll1 + roll2) == 10){
                currentFrame.setSpareStatus(true);
            }
            //okay, so, what's going on in this mess is we need to make sure that there is a previous frame, so the size must be above 0.
            //then, we need to check that the previous frame was either a spare or a strike.
            //okay, then, we need to add the score to the previous frame. so we call add score for the current roll and the score that was held on the previous frame.
            if(frames.indexOf(currentFrame) >= 1 && ((frames.get(frames.indexOf(currentFrame) - 1).getSpareStatus() == true))){
                frames.get(frames.indexOf(currentFrame) - 1).addScore(roll1 , frames.get(frames.indexOf(currentFrame) - 1).getScore());
            }
            if(frames.indexOf(currentFrame) >= 1 && ((frames.get(frames.indexOf(currentFrame) - 1).getStrikeStatus() == true))){
                frames.get(frames.indexOf(currentFrame) - 1).addScore((roll1 + roll2) , frames.get(frames.indexOf(currentFrame) - 1).getScore());
            }
            if(frames.indexOf(currentFrame) >= 2 && (frames.get(frames.indexOf(currentFrame) - 2).getStrikeStatus() == true) && (frames.get(frames.indexOf(currentFrame) - 1).getStrikeStatus() == true)){
            frames.get(frames.indexOf(currentFrame) - 2).addScore(roll1, frames.get(frames.indexOf(currentFrame) - 2).getScore());
        }
        }

    }
    
    /**
     *
     * The scoreTenthFrame with only two rolls is used if the first two do not equal 10 (no strike or spare in the first two rolls)
     * 
     * @param roll1 is the first roll of the frame.
     * @param roll2 is the second roll of the frame. 
     * @param currentFrame Is the current frame (e.g. frame1)
     * @param frames is a list of all the frames in the current game. Should be ten, but supports more
     */
    public void scoreTenthFrame(int roll1, int roll2, Frame currentFrame, List<Frame> frames){
        if(frames.indexOf(currentFrame) > 1 && ((frames.get(frames.indexOf(currentFrame) - 1).getStrikeStatus() == true) || (frames.get(frames.indexOf(currentFrame) - 1).getSpareStatus() == true))){
            frames.get(frames.indexOf(currentFrame) - 1).addScore(roll1 + roll2, frames.get(frames.indexOf(currentFrame) - 1).getScore());
        }
        //okay, so, what's going on in this mess is we need to make sure that there is a previous frame, so the size must be above 0.
        //then, we need to check that the 2nd previous frame was either a spare or a strike.
        //okay, then, we need to add the score to the previous frame. so we call add score for the current roll and the score that was held on the frame 2 frames ago.
        if(frames.indexOf(currentFrame) > 2 && (frames.get(frames.indexOf(currentFrame) - 2).getStrikeStatus() == true) && (frames.get(frames.indexOf(currentFrame) - 1).getStrikeStatus() == true)){
            frames.get(frames.indexOf(currentFrame) - 2).addScore(roll1, frames.get(frames.indexOf(currentFrame) - 2).getScore());
        }
        
       currentFrame.setScore(roll1 + roll2);
        
       
    }
    
    /**
     *
     *  The scoreTenthFrame with three rolls is used if the first two equal 10 (a strike or spare in the first two rolls)
     * 
     * @param roll1 is the first roll of the frame.
     * @param roll2 is the second roll of the frame.
     * @param roll3 is the third roll of the frame.
     * @param currentFrame Is the current frame (e.g. frame1)
     * @param frames is a list of all the frames in the current game. Should be ten, but supports more
     */
    public void scoreTenthFrame(int roll1, int roll2, int roll3, Frame currentFrame, List<Frame> frames){
        if(frames.indexOf(currentFrame) > 1 && ((frames.get(frames.indexOf(currentFrame) - 1).getStrikeStatus() == true) || (frames.get(frames.indexOf(currentFrame) - 1).getSpareStatus() == true))){
            frames.get(frames.indexOf(currentFrame) - 1).addScore(roll1 + roll2, frames.get(frames.indexOf(currentFrame) - 1).getScore());
        }
        //okay, so, what's going on in this mess is we need to make sure that there is a previous frame, so the size must be above 0.
        //then, we need to check that the 2nd previous frame was either a spare or a strike.
        //okay, then, we need to add the score to the previous frame. so we call add score for the current roll and the score that was held on the frame 2 frames ago.
        if(frames.indexOf(currentFrame) > 2 && (frames.get(frames.indexOf(currentFrame) - 2).getStrikeStatus() == true) && (frames.get(frames.indexOf(currentFrame) - 1).getStrikeStatus() == true)){
            frames.get(frames.indexOf(currentFrame) - 2).addScore(roll1, frames.get(frames.indexOf(currentFrame) - 2).getScore());
        }
        if((roll1 + roll2) >= 10){
           currentFrame.setScore(roll1 + roll2 + roll3);
        }
        else{
           currentFrame.setScore(roll1 + roll2);
        }
        
    }
}
