using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;
using System.Linq;
using Tier2.Services;
using Tier2.Models;

namespace Tier2.Controllers
{
    [Route("kommunity/[controller]")]
    [ApiController]
    public class HomeController : ControllerBase
    {


        public HomeController()
        {

        }
        
        [HttpGet]
        public ActionResult<User> login(User user)
        {
            var result = Service.findUser(user);
            if (result == null)
            {
                return NotFound();
            }
            return result;
        }

        [HttpPost]
        public ActionResult<User> SignUp(User user)
        {
            var result = Service.signup(user);
            if (result == null)
            {
                return NotFound();
            }
            return result;
        }
    }
}