using System.IO;
using System.Net.Sockets;
using Newtonsoft.Json;
using Tier2.Models;

namespace Tier2.Services
{
    public class Connection
    {
        public const string url = "localhost";
        public const int port = 8888;

        // Defining a client socket and input/output streams
        public TcpClient client;
        public StreamReader sr;
        public StreamWriter sw;


        public Connection()
        {
            try
            {
                // Initializing the socket and input/output streams
                client = new TcpClient(url, port);
                sr = new StreamReader(client.GetStream());
                sw = new StreamWriter(client.GetStream());
            }
            catch
            {

            }

        }



    }
}