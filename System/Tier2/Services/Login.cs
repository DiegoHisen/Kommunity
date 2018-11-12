using Tier2.Models;
using Newtonsoft.Json;

namespace Tier2.Services
{
    public static class Login
    {


        public static User findUser(User user)
        {
            // Initialize a new socket connection to communicate with the database server 
            Connection con = new Connection();

            // Convert the object to Json string and send it
            string json = JsonConvert.SerializeObject(user);
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
                User u = JsonConvert.DeserializeObject<User>(result);
                return u;

            }
            catch
            {
                return null;


            }



        }







    }


}
