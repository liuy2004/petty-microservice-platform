package com.github.pettyfer.basic.oauth;

import com.github.pettyfer.basic.common.utils.ZipUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@RunWith(JUnit4.class)
@SpringBootTest
public class ZipTokenTests {

    @Test
    public void compress() throws IOException {
        String str = ZipUtils.gzip("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbImFwcGxpY2F0aW9uIl0sIm5hbWUiOiJhZG1pbiIsImV4cCI6MTUyNjcxNTE2NCwiYXV0aG9yaXRpZXMiOlt7ImF1dGhvcml0eSI6IlJPTEVfQURNSU4ifSx7ImF1dGhvcml0eSI6IlJPTEVfVVNFUiJ9LHsiYXV0aG9yaXR5IjoiQmFzZV9Sb2xlXzEifSx7ImF1dGhvcml0eSI6IkJhc2VfUm9sZV8yIn0seyJhdXRob3JpdHkiOiJCYXNlX1JvbGVfMyJ9LHsiYXV0aG9yaXR5IjoiQmFzZV9Sb2xlXzQifSx7ImF1dGhvcml0eSI6IkJhc2VfUm9sZV81In0seyJhdXRob3JpdHkiOiJCYXNlX1JvbGVfNiJ9LHsiYXV0aG9yaXR5IjoiQmFzZV9Sb2xlXzcifSx7ImF1dGhvcml0eSI6IkJhc2VfUm9sZV84In0seyJhdXRob3JpdHkiOiJCYXNlX1JvbGVfOSJ9LHsiYXV0aG9yaXR5IjoiQmFzZV9Sb2xlXzEwIn0seyJhdXRob3JpdHkiOiJCYXNlX1JvbGVfMTEifSx7ImF1dGhvcml0eSI6IkJhc2VfUm9sZV8xMiJ9LHsiYXV0aG9yaXR5IjoiQmFzZV9Sb2xlXzEzIn0seyJhdXRob3JpdHkiOiJCYXNlX1JvbGVfMTQifSx7ImF1dGhvcml0eSI6IkJhc2VfUm9sZV8xNSJ9LHsiYXV0aG9yaXR5IjoiQmFzZV9Sb2xlXzE2In0seyJhdXRob3JpdHkiOiJCYXNlX1JvbGVfMTcifV0sImp0aSI6IjA1MTlkYzI2LTQ1M2EtNDNlMi04MGJlLTc4MDk5NTBmYTZmMCIsImNsaWVudF9pZCI6ImRlbW8iLCJ1c2VybmFtZSI6ImFkbWluIn0.KLynO9x_xHSn-H0s76wip7d9CQ_szwMjyLgZgTtiNPA");
        System.out.println(str);
        System.out.println(ZipUtils.gunzip(str));
    }
}
