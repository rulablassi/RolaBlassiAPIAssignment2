public class RequestBody {



    public  static String requestBody (String userName , String Password)
    {

        String request="{\n" +
                "\"grant_type\":\"password\",\n" +
                "\"username\":\""+userName+"\",\n" +
                "\"password\":\""+Password+"\",\n" +
                "\"audience\":\"https://sit.maf-dev.auth0.com/api/v2/\",\n" +
                "\"client_id\":\"l9DGyNKhON48e6BgTFAg17wWY78urJ4t\",\n" +
                "\"client_secret\":\"yl9xlvv9N35GpLYDxBp22HLFvPv4_RrtPQxFhznSV2C5xqUYWVWqXl7qwdt2gq2f\"\n" +
                "}";
        return request;
    }






    public  static String requestBodyRegister (String Email , String Password)
    {

        String request="{\n" +
                "\"password\": \""+Password+"\",\n" +
                "\"username\": \"Rula\",\n" +
                "\"user_metadata\": {\n" +
                "\"firstName\": \"Ruls\",\n" +
                "\"mobile\": \"+962797483605\",\n" +
                "\"lastName\": \"Blassi\",\n" +
                "\"dateOfBirth\": \"1992-04-3\",\n" +
                "\"title\": \"Mrs\",\n" +
                "\"share_tc\": \"Yes\"\n" +
                "\"email\": \""+Email+"\",\n" +
                "\"connection\": \"Username-Password-Authentication\",\n" +
                "\"client_id\": \"2IGVUsTpid0NZhjaMUe77k6wERpZ0pbG\"\n" +
                "}";
        return request;
    }






}
