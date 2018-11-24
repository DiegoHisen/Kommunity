using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;
using System.Linq;
using Tier2.Services;
using Tier2.Models;

namespace Tier2.Controllers
{
    [Route("kommunity/[controller]")]
    [ApiController]
    public class LoginController : ControllerBase
    {


        public LoginController()
        {

        }

        [HttpPost]
        public ActionResult<User> GetBycpr(User user)
        {
            var result = Service.findUser(user);
            if (result == null)
            {
                return NotFound();
            }
            return result;
        }
    }
}