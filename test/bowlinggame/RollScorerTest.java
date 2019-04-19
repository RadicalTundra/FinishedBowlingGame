package bowlinggame;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class RollScorerTest {
    
    RollScorer scorer;
    Frame frame1;
    Frame frame2;
    List<Frame> frames;
    
    @Before
    public void setup(){
        scorer = new RollScorer();
        frame1 = new Frame();
        frame2 = new Frame();
        frames = new ArrayList();
        frames.add(frame1);
        frames.add(frame2);
    }
    
    @Test
    public void properlyScoredStrikes(){  
        scorer.scoreWithOneRoll(10, frames.get(0), frames);
        scorer.scoreWithTwoRolls(1, 1, frames.get(1), frames);
        assertEquals(12, frames.get(0).getScore());
    }
    @Test
    public void properlyScoredSpares(){  
        scorer.scoreWithTwoRolls(5, 5, frames.get(0), frames);
        scorer.scoreWithTwoRolls(1, 1, frames.get(1), frames);
        assertEquals(11, frames.get(0).getScore());
    }
    @Test
    public void properScoredTenthFrameWithThirdRoll(){
        scorer.scoreTenthFrame(10, 5, 4, frames.get(0), frames);
        assertEquals(19, frames.get(0).getScore());
    }
    @Test
    public void properScoredTenthFrameWithoutThirdRoll(){
        scorer.scoreTenthFrame(4, 5, frames.get(0), frames);
        assertEquals(9, frames.get(0).getScore());
    }
}
