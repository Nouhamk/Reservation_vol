package td4;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestGestVol {
    @Test
    public static void testNumVol(){
        // Tests de reussite
        assertThat(NumVol.set_numvol("24XC12"),equalTo("24XC12"));
        // Tests d'echec
        assertThat(exceptionOf(()-> NumVol.set_numvol("000000")),instanceOf(IllegalArgumentException.class));
    }


    //Help you to handle exception. :-)
    public static Throwable exceptionOf(Callable<?> callable) {
        try {
            callable.call();
            return null;
        } catch (Throwable t) {
            return t;
        }
    }
}
