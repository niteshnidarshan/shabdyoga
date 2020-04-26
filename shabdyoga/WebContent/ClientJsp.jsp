<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
    <%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>

    <html>
      <body>
        <form action="" method="post"><br>
        <input type="text" name="xt">
        <%
          ReCaptcha c = ReCaptchaFactory.newReCaptcha("6LfW1_oSAAAAAJZX5-CV0GyvxLUHlpL0Z0vnpE2K", "6LfW1_oSAAAAAC0woETswaALkY9XqNHJeYRF9AF4", false);
          out.print(c.createRecaptchaHtml(null, null));
        %>
        <input type="submit" value="submit" />
        </form>
      </body>
    </html>