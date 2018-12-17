using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Kommunity_WebApp.Models;
using Kommunity_WebApp.Services;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Kommunity_WebApp.Pages.User;

namespace Kommunity_WebApp.Pages.News
{
    

    public class eventsModel : PageModel
    {
        public List<Post> posts = new List<Post>();
        public List<Post> events = new List<Post>();

        public void OnGet()
        {
            posts = Service.getPosts("");
            foreach(var item in posts)
            {
                if(item.type == "events")
                {
                    events.Add(item);
                }
            }
            
        }
    }
}