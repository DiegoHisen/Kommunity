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

        [HttpGet("{cpr}")]
        public ActionResult<User> GetBycpr(long cpr, string pwd)
        {
            var result = Login.findUser(cpr, pwd);
            if (result == null)
            {
                return NotFound();
            }
            return result;
        }
    }
}