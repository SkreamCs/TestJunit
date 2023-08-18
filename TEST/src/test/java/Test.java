import org.example.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.management.ConstructorParameters;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Test {
    @org.junit.jupiter.api.Test
     void FileTest() {
        List<String> argument = Arrays.asList(
                "/Users/mustafatumgoev/Games/src/main/Main.java",
                "/Users/mustafatumgoev/Games/src/main/Utils.java",
                "/Users/mustafatumgoev/Games/src/res/savegame/temp/temp.txt");
        String expected = ("Main.java,Utils.java,temp.txt,");
        String result = "";
        try {
             result = Main.createFileOne(argument);
        } catch (IOException e) {
            e.getMessage();
        }
        Assertions.assertEquals(result, expected);
    }
    @org.junit.jupiter.api.Test
    void FolderTest() {
        String argument = "/Users/mustafatumgoev/Games";
        String expected = "Games";
        String result = Main.createFolder(argument);
        Assertions.assertEquals(result, expected);
    }
    @ParameterizedTest
    @ValueSource(strings = {"src", "res"})
    void FolderTestSource(String argument) {
        String expected = "/Users/mustafatumgoev/Games/" + argument;
        String result = Main.createFolder(expected);
        Assertions.assertEquals(argument, result);
    }

}
