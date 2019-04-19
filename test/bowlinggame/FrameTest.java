package bowlinggame;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


public class FrameTest {
    
    Frame frame;
    
    @Before
    public void setup(){
        frame = new Frame();
    }
    
    @Test
    public void canSetScore(){
        frame.setScore(10);
        assertEquals(10, frame.getScore());
    }
    
    @Test
    public void canSetAndGetStrikeStatus(){
        frame.setStrikeStatus(true);
        assertEquals(true, frame.getStrikeStatus());
    }
    
    @Test
    public void canSetAndGetSpareStatus(){
        frame.setSpareStatus(true);
        assertEquals(true, frame.getSpareStatus());
    }
    
    @Test
    public void canAddScores(){
        frame.addScore(10, 5);
        assertEquals(15, frame.getScore());
    }
    
}
