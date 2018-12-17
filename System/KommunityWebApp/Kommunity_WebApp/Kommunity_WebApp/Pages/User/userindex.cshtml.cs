using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Kommunity_WebApp.Models;
using Kommunity_WebApp.Services;

namespace Kommunity_WebApp.Pages.User
{
    public class userindexModel : PageModel
    {
        public Models.User user = new Models.User();
        public List<Post> posts = new List<Post>();

        

        public void OnGet(string city, string name)
        {
            user.name = name;
             posts = Service.getPosts(city);

        }
    }
}

/*   Post p = new Post();
            Models.User u = new Models.User();
            u.name= "Napoleon";
            p.creator = u;
            p.content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent ac nulla vel nisi ornare congue. Pellentesque at metus aliquet, suscipit orci nec, imperdiet ligula. Donec lacinia dolor non elementum pharetra. Maecenas ultrices erat a volutpat lobortis. Sed commodo facilisis ipsum, in aliquet nisl convallis ullamcorper. Ut eget libero congue, facilisis dolor in, tempus lectus. Donec cursus elit a ante blandit venenatis. Aenean elementum nulla in erat egestas feugiat. Sed leo leo, lobortis quis faucibus a, maximus a neque. In lorem lorem, pretium et purus non, dictum elementum dui. Curabitur sed ante quis diam vulputate bibendum id ac ex. Mauris laoreet aliquet libero, a aliquam justo viverra quis. Nullam scelerisque tempor ex, et ultrices magna. Maecenas maximus, felis eu eleifend viverra, nulla purus viverra felis, at ultricies tellus felis id orci. Proin facilisis neque ut ligula tempor ultrices vel a nibh.";
            p.type = cpr;
            DateTime d =DateTime.Now.ToUniversalTime();
            p.date = d;

            posts.Add(p);
            Post p2 = new Post();
            Models.User u2 = new Models.User();
            u2.name = "Hitler";
            p2.creator = u2;
            p2.content = "nulla vel nisi ornare congue. Pellentesque at metus aliquet, suscipit orci nec, imperdiet ligula. Donec lacinia dolor non elementum pharetra. Maecenas ultrices erat a volutpat lobortis. Sed commodo facilisis ipsum, in aliquet nisl convallis ullamcorper. Ut eget libero congue, facilisis dolor in, tempus lectus. Donec cursus elit a ante blandit venenatis. Aenean elementum nulla in erat egestas feugiat. Sed leo leo, lobortis quis faucibus a, maximus a neque. In lorem lorem, pretium et purus non, dictum elementum dui. Curabitur sed ante quis diam vulputate bibendum id ac ex. Mauris laoreet aliquet libero, a aliquam justo viverra quis. Nullam scelerisque tempor ex, et ultrices magna. Maecenas maximus, felis eu eleifend viverra, nulla purus viverra felis, at ultricies tellus felis id orci. Proin facilisis neque ut ligula tempor ultrices vel a nibh.";
            p2.type = "Lorem ipsum";
            DateTime d2 = DateTime.Now.ToUniversalTime();
            p2.date = d2;
            posts.Add(p2); */
