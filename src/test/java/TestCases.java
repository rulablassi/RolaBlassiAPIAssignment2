import Login.LoginPage;
import Login.LoginRequestBody;
import MemberDetails.MemberPage;
import SignUp.SignUpPage;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class LoginTest extends LoginRequestBody {







    Random randomNumber = new Random();
    int upperbound = 90000000;
    int int_random = randomNumber.nextInt(upperbound);
    String Email = "Test" + int_random + "@abc.ae";

    String TokenTypeValue;

    String EmailValue, FirstNameValue;

    @Test( description = "SignUP" , priority = 1)
    public void SignUP(){


        SignUpPage signUpPost = new SignUpPage();
        Response SignupPost =signUpPost.SignUpPost(Email,"Qwer1234");
        JsonPath jsonPathEvaluators = SignupPost.jsonPath();
        SignupPost.prettyPrint();
        Assert.assertEquals(SignupPost.getStatusCode(), 200);
        EmailValue = jsonPathEvaluators.get("email").toString();
        Assert.assertEquals( jsonPathEvaluators.get("email").toString(),EmailValue);
        FirstNameValue = jsonPathEvaluators.get("user_metadata.firstName").toString();
        Assert.assertEquals( jsonPathEvaluators.get("user_metadata.firstName").toString(),FirstNameValue);




    }




    @Test(description = "Login", priority = 2)
    public void Login() {

        LoginPage loginPage = new LoginPage();
        Response loginPost = loginPage.loginPost(Email, "Qwer1234");
        Assert.assertEquals(loginPost.getStatusCode(), 200);
        loginPost.prettyPrint();
        JsonPath jsonPathEvaluators = loginPost.jsonPath();
        TokenTypeValue = "Bearer " + jsonPathEvaluators.get("access_token").toString();
        Assert.assertEquals("Bearer " + jsonPathEvaluators.get("access_token").toString(), TokenTypeValue);
        System.out.print(TokenTypeValue);
    }






    @Test( description = "Member Details", priority = 3)
    public void MemberDetails(){

        MemberPage memberPage = new MemberPage();
        Response MemberGet =memberPage.MemberDetails(TokenTypeValue);
        JsonPath jsonPathEvaluators = MemberGet.jsonPath();
        MemberGet.prettyPrint();
        Assert.assertEquals(MemberGet.getStatusCode(), 200);
        Assert.assertEquals( jsonPathEvaluators.get("email_address").toString(),EmailValue);
        Assert.assertEquals( jsonPathEvaluators.get("first_name").toString(),FirstNameValue);
        String TierValue = jsonPathEvaluators.get("tier").toString();
        Assert.assertEquals( jsonPathEvaluators.get("tier").toString(),TierValue);
        String SWOnBoardingValue = jsonPathEvaluators.get("extra_data.sw_onboarding").toString();
        Assert.assertEquals( jsonPathEvaluators.get("extra_data.sw_onboarding").toString(),SWOnBoardingValue);


    }


}





