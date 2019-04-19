package bowlinggame;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Just the driver class, you can call it Bobby Labonte.
 * 
 * @version 1.0
 * @author yeetboi
 * @author Tyler Grady, Bryce Soule
 */
public class StartGame {

    /**
     *
     * @param args not used
     */
    public static void main(String[] args){
        List<Frame> framesArray = new ArrayList();
        Frame frame1 = new Frame();
        Frame frame2 = new Frame();
        Frame frame3 = new Frame();
        Frame frame4 = new Frame();
        Frame frame5 = new Frame();
        Frame frame6 = new Frame();
        Frame frame7 = new Frame();
        Frame frame8 = new Frame();
        Frame frame9 = new Frame();
        Frame frame10 = new Frame();
        framesArray.add(frame1);
        framesArray.add(frame2);
        framesArray.add(frame3);
        framesArray.add(frame4);
        framesArray.add(frame5);
        framesArray.add(frame6);
        framesArray.add(frame7);
        framesArray.add(frame8);
        framesArray.add(frame9);
        framesArray.add(frame10);
        
        RollScorer scorer = new RollScorer();
        scorer.scoreWithTwoRolls(5,3,framesArray.get(0), framesArray);
        scorer.scoreWithTwoRolls(9,1,framesArray.get(1), framesArray);
        scorer.scoreWithOneRoll(10, framesArray.get(2), framesArray);
        scorer.scoreWithOneRoll(10,framesArray.get(3), framesArray);
        scorer.scoreWithTwoRolls(5, 2,framesArray.get(4), framesArray);
        scorer.scoreWithTwoRolls(5, 0,framesArray.get(5), framesArray);
        scorer.scoreWithTwoRolls(10, 0,framesArray.get(6), framesArray);
        scorer.scoreWithTwoRolls(10, 0,framesArray.get(7), framesArray);
        scorer.scoreWithTwoRolls(10, 0,framesArray.get(8), framesArray);
        scorer.scoreTenthFrame(10, 0, 5, framesArray.get(9), framesArray);
        //You can uncomment these to see if the scoring works :)
        //System.out.println(framesArray.get(0).getScore());
        //System.out.println(framesArray.get(1).getScore());
        //System.out.println(framesArray.get(2).getScore());
        //System.out.println(framesArray.get(3).getScore());
        //System.out.println(framesArray.get(4).getScore());
        //System.out.println(framesArray.get(5).getScore());
        //System.out.println(framesArray.get(6).getScore());
        //System.out.println(framesArray.get(7).getScore());
        //System.out.println(framesArray.get(8).getScore());
        //System.out.println(framesArray.get(9).getScore());
        System.out.println(totalScore(framesArray));
        
    }

    /**
     *
     * @param frames is a list of all the frames in the current game. Should be ten, but supports more
     * @return the total score up to the current frame
     */
    static public int totalScore(List<Frame> frames){
        int total = 0;
        //if you want the totalscore to be accurate like a real game of bowling. 
        //You'd check if the current frame and the frame before are a spare or a strike. and not count them until they've finished adding.
        for(int i = 0; i < frames.size(); i++){
            total += frames.get(i).getScore();
        }
        
        return total;
    }
}
