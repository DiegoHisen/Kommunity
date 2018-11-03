using Tier2.Models;
using Newtonsoft.Json;

namespace Tier2.Services
{
    public static class Login
    {


        public static User findUser(long cpr, string pwd)
        {
            // Initialize a new socket connection to communicate with the database server 
            Connection con = new Connection();

            // Create a User object with given CPR and password to send it to the database server
            User u = new User();
            u.cpr = cpr;
            u.password = pwd;

            // Convert the object to Json string and send it
            string json = JsonConvert.SerializeObject(u);
            con.sw.WriteLine(json);
            con.sw.Flush();

            try
            {
                // Read the responce from database server
                string fromServer = con.sr.ReadLine();

                /*
                for some reason, the received json string has 2 strange characters in the beginning,
                This makes the program not able to convert it to User object,
                next code line is to remove these characters.
                 */
                string result = fromServer.Substring(2);

                // Convert the responce from Json to User object and return it
                User user = JsonConvert.DeserializeObject<User>(result);
                return user;

            }
            catch
            {
                return null;


            }



        }







    }


}
