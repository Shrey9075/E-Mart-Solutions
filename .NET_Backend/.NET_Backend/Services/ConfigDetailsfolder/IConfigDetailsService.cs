using System.Collections.Generic;
using System.Threading.Tasks;
using Emart_final.Models;

namespace Emart_final.service.ConfigDetailsfolder
{
    public interface IConfigDetailsService
    {
        Task<ConfigDetails> AddConfigDetails(ConfigDetails configDetails);

        Task<ConfigDetails?> DeleteConfigDetails(int configDetailsId);

        Task<ConfigDetails> GetConfigDetailsById(int configDetailsId);

        Task<ConfigDetails?> UpdateConfigDetails(int configDetailsId, ConfigDetails updatedConfigDetails);
    }
}
