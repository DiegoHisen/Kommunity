using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;
using System.Linq;
using Tier2.Services;
using Tier2.Models;

namespace Tier2.Controllers
{
    [Route("kommunity/[controller]")]
    [ApiController]
    public class ProfileController : ControllerBase
    {


        public ProfileController()
        {

        }
        
        [HttpPut]
        public ActionResult<bool> changePassword(User user, string oldPassword, string newPassword)
        {
            var result = Service.changePassword(user,newPassword,oldPassword);
            if (result == false)
            {
                return NotFound();
            }
            return result;
        }

        [HttpPut]
        public ActionResult<bool> changeEmail(User user, string newEmail)
        {
            var result = Service.changeEmail(user,newEmail);
            if (result == false)
            {
                return NotFound();
            }
            return result;
        }

        [HttpPut]
        public ActionResult<bool> changeCity(User user, string newCity)
        {
            var result = Service.changeCity(user,newCity);
            if (result == false)
            {
                return NotFound();
            }
            return result;
        }

    }
}