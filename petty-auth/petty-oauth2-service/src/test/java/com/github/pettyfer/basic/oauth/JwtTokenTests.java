package com.github.pettyfer.basic.oauth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.boot.test.context.SpringBootTest;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.*;

@RunWith(JUnit4.class)
@SpringBootTest
public class JwtTokenTests {

    @Test
    public void zip() throws NoSuchAlgorithmException, IOException {
        byte[] compressed;
        String compressedStr = null;
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbImFwcGxpY2F0aW9uIl0sIm5hbWUiOiJhZG1pbiIsImV4cCI6MTUyNjcxNTE2NCwiYXV0aG9yaXRpZXMiOlt7ImF1dGhvcml0eSI6IlJPTEVfQURNSU4ifSx7ImF1dGhvcml0eSI6IlJPTEVfVVNFUiJ9LHsiYXV0aG9yaXR5IjoiQmFzZV9Sb2xlXzEifSx7ImF1dGhvcml0eSI6IkJhc2VfUm9sZV8yIn0seyJhdXRob3JpdHkiOiJCYXNlX1JvbGVfMyJ9LHsiYXV0aG9yaXR5IjoiQmFzZV9Sb2xlXzQifSx7ImF1dGhvcml0eSI6IkJhc2VfUm9sZV81In0seyJhdXRob3JpdHkiOiJCYXNlX1JvbGVfNiJ9LHsiYXV0aG9yaXR5IjoiQmFzZV9Sb2xlXzcifSx7ImF1dGhvcml0eSI6IkJhc2VfUm9sZV84In0seyJhdXRob3JpdHkiOiJCYXNlX1JvbGVfOSJ9LHsiYXV0aG9yaXR5IjoiQmFzZV9Sb2xlXzEwIn0seyJhdXRob3JpdHkiOiJCYXNlX1JvbGVfMTEifSx7ImF1dGhvcml0eSI6IkJhc2VfUm9sZV8xMiJ9LHsiYXV0aG9yaXR5IjoiQmFzZV9Sb2xlXzEzIn0seyJhdXRob3JpdHkiOiJCYXNlX1JvbGVfMTQifSx7ImF1dGhvcml0eSI6IkJhc2VfUm9sZV8xNSJ9LHsiYXV0aG9yaXR5IjoiQmFzZV9Sb2xlXzE2In0seyJhdXRob3JpdHkiOiJCYXNlX1JvbGVfMTcifV0sImp0aSI6IjA1MTlkYzI2LTQ1M2EtNDNlMi04MGJlLTc4MDk5NTBmYTZmMCIsImNsaWVudF9pZCI6ImRlbW8iLCJ1c2VybmFtZSI6ImFkbWluIn0.KLynO9x_xHSn-H0s76wip7d9CQ_szwMjyLgZgTtiNPA";
        MessageDigest md=MessageDigest.getInstance("md5");
        byte[] md5=md.digest(token.getBytes());
        BASE64Encoder encoder= new BASE64Encoder();
        //MD5 加密但是不能反向解析
        //System.out.println(encoder.encode(md5));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ZipOutputStream zipOutputStream = null;
        zipOutputStream = new ZipOutputStream(out);
        zipOutputStream.putNextEntry(new ZipEntry("0"));
        zipOutputStream.write(token.getBytes());
        zipOutputStream.closeEntry();
        compressed = out.toByteArray();
        compressedStr = encoder.encodeBuffer(compressed);
        System.out.print(compressedStr);
    }

    @Test
    public void unzip() throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] compressed = null;
        BASE64Decoder decoder= new BASE64Decoder();
        compressed = decoder.decodeBuffer("UEsDBBQACAgIAEWCskwAAAAAAAAAAAAAAAABAAAAMI2TTVODMBiEf5EOILVyVCw0kaQCIXxcHAKtBJLKDK0Qfr2gFw86k/tmn3c3s0cFG+ZX/MAhSGZgYg4GcI42lQvuQddn1IXO7VFBs7KoyqxNw9JkFTeFb/bsW4xbdvckQNszIL2x8qc+tzyjTJ0rEMYA5B9vJLVXACKJwm01YbKzsDvyPKNG6TuqzKK+yBA/iMt28TRrv/mspDCO8XKUgK9kR09hEuE4sfkpnv7VUIq9hEMn2A+/vTeg/eCh9OaCOjGzJpHNu799OtgsuU+JdIaCPihwNoali6bOog92B/t636253DzDIjPhJ/PpCSkdXqjDM3V4WCtfpcOzdXiHWKvPUasrotX7hPT+cNZjanU/Yb2clh5z6Z+uW+iNcmW1jyYiostnYAUkNJG1u+BnLBA3bORDEZDKRs/dBpMnmZNCInfdDB7KlF5rz+mLdZwyEix94IH7s00mvUuxekuvY6m4LnfdvgTqfHCmt2kfn2/2xrC9H3m/rR03fBvmEbUqeC/eyYXj18cvUEsHCNyGUPaIAQAACAQAAA==");
        ByteArrayInputStream input = new ByteArrayInputStream(compressed);
        ZipInputStream zipInputStream = new ZipInputStream(input);
        zipInputStream.getNextEntry();
        byte[] buffer = new byte[1024];
        int offset = -1;
        while ((offset = zipInputStream.read(buffer)) != -1) {
            out.write(buffer);
        }
        System.out.println(out.toString());
    }

    @Test
    public void gzip(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbImFwcGxpY2F0aW9uIl0sIm5hbWUiOiJhZG1pbiIsImV4cCI6MTUyNjcxNTE2NCwiYXV0aG9yaXRpZXMiOlt7ImF1dGhvcml0eSI6IlJPTEVfQURNSU4ifSx7ImF1dGhvcml0eSI6IlJPTEVfVVNFUiJ9LHsiYXV0aG9yaXR5IjoiQmFzZV9Sb2xlXzEifSx7ImF1dGhvcml0eSI6IkJhc2VfUm9sZV8yIn0seyJhdXRob3JpdHkiOiJCYXNlX1JvbGVfMyJ9LHsiYXV0aG9yaXR5IjoiQmFzZV9Sb2xlXzQifSx7ImF1dGhvcml0eSI6IkJhc2VfUm9sZV81In0seyJhdXRob3JpdHkiOiJCYXNlX1JvbGVfNiJ9LHsiYXV0aG9yaXR5IjoiQmFzZV9Sb2xlXzcifSx7ImF1dGhvcml0eSI6IkJhc2VfUm9sZV84In0seyJhdXRob3JpdHkiOiJCYXNlX1JvbGVfOSJ9LHsiYXV0aG9yaXR5IjoiQmFzZV9Sb2xlXzEwIn0seyJhdXRob3JpdHkiOiJCYXNlX1JvbGVfMTEifSx7ImF1dGhvcml0eSI6IkJhc2VfUm9sZV8xMiJ9LHsiYXV0aG9yaXR5IjoiQmFzZV9Sb2xlXzEzIn0seyJhdXRob3JpdHkiOiJCYXNlX1JvbGVfMTQifSx7ImF1dGhvcml0eSI6IkJhc2VfUm9sZV8xNSJ9LHsiYXV0aG9yaXR5IjoiQmFzZV9Sb2xlXzE2In0seyJhdXRob3JpdHkiOiJCYXNlX1JvbGVfMTcifV0sImp0aSI6IjA1MTlkYzI2LTQ1M2EtNDNlMi04MGJlLTc4MDk5NTBmYTZmMCIsImNsaWVudF9pZCI6ImRlbW8iLCJ1c2VybmFtZSI6ImFkbWluIn0.KLynO9x_xHSn-H0s76wip7d9CQ_szwMjyLgZgTtiNPA";
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip;
        try {
            gzip = new GZIPOutputStream(out);
            gzip.write(token.getBytes());
            gzip.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        try {
            GZIPInputStream ungzip = new GZIPInputStream(in);
            byte[] buffer = new byte[256];
            int n;
            while ((n = ungzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
            System.out.println(out.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
