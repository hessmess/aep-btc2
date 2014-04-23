package javamusic;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by jhess on 22.04.14.
 */
public class MailgunTest {

    @Test
    public void shouldCreateAndSendMail() throws Exception {
        Mailgun mailgun = new Mailgun("jonas.hess@web.de", "Testmail Mailgun", "If you received this mail, everything's alright!");
        assertTrue(mailgun.sendmail());
    }

}
