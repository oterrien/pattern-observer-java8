import com.ote.test.MeteoStation;
import com.ote.test.Umbrella;
import com.ote.test.WaterPump;
import org.junit.Test;

/**
 * Created by Olivier on 05/06/2016.
 */
public class Tester {

    @Test
    public void testObserver(){

        MeteoStation meteoStation = new MeteoStation();
        for (int i=0;i<10000; i++){
            meteoStation.register(new WaterPump());
        }
        meteoStation.register(new Umbrella());

        System.out.println("SUNNY");
        meteoStation.setWeather("sunny");

        System.out.println("RAINING");
        meteoStation.setWeather("raining");

        System.out.println("WINDY");
        meteoStation.setWeather("windy");

    }
}
