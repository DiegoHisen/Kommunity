using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Kommunity_WebApp.Models;
using Kommunity_WebApp.Services;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;

namespace Kommunity_WebApp.Pages.News
{
    public class foodModel : PageModel
    {
        public List<Post> posts = new List<Post>();
        public List<Post> food = new List<Post>();

        public void OnGet()
        {
            posts = Service.getPosts("");
            foreach (var item in posts)
            {
                if (item.type == "food")
                {
                    food.Add(item);
                }
            }

        }
    }
}