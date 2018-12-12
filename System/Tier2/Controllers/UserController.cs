using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;
using System.Linq;
using Tier2.Services;
using Tier2.Models;

namespace Tier2.Controllers
{
    [Route("kommunity/[controller]")]
    [ApiController]
    public class UserController : ControllerBase
    {


        public UserController()
        {

        }
        
        [HttpPost]
        public ActionResult<bool> post(Post post)
        {
            var result = Service.Post(post);
            if (result == false)
            {
                return NotFound();
            }
            return result;
        }

        [HttpDelete]
        public ActionResult<bool> deletePost(Post post)
        {
            var result = Service.DeletePost(post);
            if (result == false)
            {
                return NotFound();
            }
            return result;
        }

        [HttpPost]
        public ActionResult<bool> makePetition(Petition petition)
        {
            var result = Service.MakePetition(petition);
            if (result == false)
            {
                return NotFound();
            }
            return result;
        }

         [HttpGet] // Needs route name to distinguish
        public ActionResult< List<Post> > getPosts(string city)
        {
            var result = Service.getPosts(city);
            if (result == null)
            {
                return NotFound();
            }
            return result;
        }

         [HttpGet] // Needs route name to distinguish
        public ActionResult< List<Petition> > getApprovedPetitions(string city)
        {
            var result = Service.getApprovedPetitions(city);
            if (result == null)
            {
                return NotFound();
            }
            return result;
        }

        [HttpPost]
        public ActionResult<bool> vote(User voter, Petition petition)
        {
            var result = Service.vote(voter, petition);
            if (result == false)
            {
                return NotFound();
            }
            return result;
        }

         [HttpPost]
        public ActionResult<bool> sendMessage(User sender, User recipient, Message message)
        {
            var result = Service.sendMessage(sender, recipient, message);
            if (result == false)
            {
                return NotFound();
            }
            return result;
        }

        [HttpGet]
        public ActionResult<List<Message>> getMessages(User user)
        {
            var result = Service.getMessages(user);
            if (result == null)
            {
                return NotFound();
            }
            return result;
        }

    }
}