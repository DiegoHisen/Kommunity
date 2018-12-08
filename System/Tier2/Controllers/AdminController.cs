using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;
using System.Linq;
using Tier2.Services;
using Tier2.Models;

namespace Tier2.Controllers
{
    [Route("kommunity/[controller]")]
    [ApiController]
    public class AdminController : ProfileController
    {


        public AdminController()
        {

        }
        
        [HttpPut]
        public ActionResult<bool> changeRole(User user, string newRole)
        {
            var result = Service.changeRole(user,newRole);
            if (result == false)
            {
                return NotFound();
            }
            return result;
        }

        [HttpPost]
        public ActionResult<bool> officialPost(OfficialPost post)
        {
            var result = Service.officialPost(post);
            if (result == false)
            {
                return NotFound();
            }
            return result;
        }

        [HttpGet]
        public ActionResult<List<Petition>> getapprovedPetitions(string city)
        {
            var result = Service.getApprovedPetitions(city);
            if (result == null)
            {
                return NotFound();
            }
            return result;
        }

        [HttpGet]
        public ActionResult<List<Petition>> getUnapprovedPetitions(string city)
        {
            var result = Service.getUnapprovedPetitions(city);
            if (result == null)
            {
                return NotFound();
            }
            return result;
        }

        [HttpPut]
        public ActionResult<bool> approvePetition(Petition petition)
        {
            var result = Service.approvePetition(petition);
            if (result == false)
            {
                return NotFound();
            }
            return result;
        }

    }
}