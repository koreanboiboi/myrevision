package workshop4;



import org.junit.Assert;
import org.junit.Test;

import workshop4.server.Cookie;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testCookie()
    {
        String randomCookie = Cookie.getRandomCookie("C:\\Users\\user\\VTTP\\revision\\workshop4\\cookiemonster\\cookie_file.txt");
        Assert.assertNull(randomCookie);
    }
    @BeforeTest
    public void BeforeTest(){

    }
    @AFterTest
    public void afterTest(){

    }
}
