import java.math.BigDecimal;
import java.math.RoundingMode;

public class Round {
    public static double roundDoubleTo2PlacesAfterSign(double val){
        BigDecimal bd = BigDecimal.valueOf(val);
        bd = bd.setScale(2, RoundingMode.HALF_DOWN);

        return bd.doubleValue();
    }
}
