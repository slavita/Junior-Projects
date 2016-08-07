import javax.sound.sampled.spi.AudioFileReader;
import java.nio.charset.spi.CharsetProvider;
import java.sql.Driver;
import java.util.ServiceLoader;

public class MySQLExample_4 {
    public static void main(String[] args) {
        ServiceLoader<Driver> drivers = ServiceLoader.load(Driver.class);
        for (Driver driver : drivers) {
            System.out.println(driver);
        }

        System.out.println();

        ServiceLoader<CharsetProvider> charsetProviders
                = ServiceLoader.load(CharsetProvider.class);
        for (CharsetProvider charsetProvider : charsetProviders) {
            System.out.println(charsetProvider);
        }

        System.out.println();

        ServiceLoader<AudioFileReader> audioReaders
                = ServiceLoader.load(AudioFileReader.class);
        for (AudioFileReader reader : audioReaders) {
            System.out.println(reader);
        }


    }
}
