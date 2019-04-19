package bowlinggame;
import static bowlinggame.StartGame.totalScore;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class StartGameTest {
    
    Frame frame1;
    Frame frame2;
    List<Frame> frames;
    
    @Before
    public void setup(){
        frame1 = new Frame();
        frame2 = new Frame();
        frames = new ArrayList();
        frames.add(frame1);
        frames.add(frame2);
        frame1.setScore(6);
        frame2.setScore(4);
    }
    
    @Test 
    public void canTotalScore(){
        totalScore(frames);
    }
    
    
}
