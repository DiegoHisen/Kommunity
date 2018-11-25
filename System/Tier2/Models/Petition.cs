namespace Tier2.Models
{
    public class Petition
    {
        public int id {get; set;}
        public long creatorCPR {get; set;}
        public string content {get; set;}
        public string date {get; set;}
        public bool approved {get; set;}
        public long approvedby {get; set;}
        public int numOfVotes {get; set;}
        
    }
}