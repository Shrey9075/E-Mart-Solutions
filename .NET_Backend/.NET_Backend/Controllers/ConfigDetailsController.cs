using Emart_final.Models;
using Emart_final.service.ConfigDetailsfolder;
using Microsoft.AspNetCore.Cors;
using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace Emart_final.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    [EnableCors]
    public class ConfigDetailsController : ControllerBase
    {
        private readonly IConfigDetailsService _repository;

        public ConfigDetailsController(IConfigDetailsService repository)
        {
            _repository = repository;
        }

        [HttpGet("{id}")]
        public async Task<ActionResult<ConfigDetails>> GetConfigDetailsById(int id)
        {
            var configDetails = await _repository.GetConfigDetailsById(id);

            if (configDetails == null)
            {
                return NotFound();
            }

            return Ok(configDetails);
        }

        [HttpPost]
        public async Task<ActionResult<ConfigDetails>> PostConfigDetails(ConfigDetails configDetails)
        {
            var addedConfigDetails = await _repository.AddConfigDetails(configDetails);
            return CreatedAtAction(nameof(GetConfigDetailsById), new { id = addedConfigDetails.Config_DetailsID }, addedConfigDetails);
        }

        [HttpPut("{id}")]
        public async Task<IActionResult> PutConfigDetails(int id, ConfigDetails configDetails)
        {
            if (id != configDetails.Config_DetailsID)
            {
                return BadRequest();
            }

            var updatedConfigDetails = await _repository.UpdateConfigDetails(id, configDetails);

            if (updatedConfigDetails == null)
            {
                return NotFound();
            }

            return NoContent();
        }

        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteConfigDetails(int id)
        {
            await _repository.DeleteConfigDetails(id);
            return NoContent();
        }
    }
}
