package javamusic;

/**
 * Created by jhess on 22.04.14.
 */
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;




public class Mailgun {

    private String mail_to;
    private String mail_subject;
    private String mail_text;

    public Mailgun(String to, String subject, String text) {
        mail_to = to;
        mail_subject = subject;
        mail_text = text;

    }

    public void setText(String text){
        mail_text = text;
    }

    public boolean sendmail() throws Exception {

        //  Perform Trade

        String url = "https://api.mailgun.net/v2/sandbox47929.mailgun.org" +
                "/messages";
//			String url = "https://httpbin.org/post";

        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        String authStr = "api:key-73nji6tr7ih9-3jq0n05r3mawkb-vne4";
        String encoding = Base64.encodeBytes (authStr.getBytes());

        //add request header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setRequestProperty("Authorization", "Basic " + encoding);

        String urlParameters = "from=Heidi <Heidi@hans.com>" + "&to=" + mail_to + "&subject=" + mail_subject + "&text=" + mail_text;

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

//					int responseCode = con.getResponseCode();
//					System.out.println("\nSending 'POST' request to URL : " + url);
//					System.out.println("Post parameters : " + urlParameters);
//					System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println("Sent out Mail: " + response.toString());


        return response.toString().contains("Queued. Thank you.");

    }

}
