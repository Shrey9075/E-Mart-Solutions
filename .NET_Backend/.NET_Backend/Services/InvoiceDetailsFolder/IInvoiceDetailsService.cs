using Emart_final.Models;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace Emart_final.service.InvoiceDetailsFolder
{
    public interface IInvoiceDetailsService
    {
        Task<InvoiceDetails> AddInvoiceDetails(InvoiceDetails invoiceDetails);
        Task<InvoiceDetails?> DeleteInvoiceDetails(int invoiceDetailsId);
        Task<IEnumerable<InvoiceDetails>> GetAllInvoiceDetails();
        Task<InvoiceDetails> GetInvoiceDetailsById(int invoiceDetailsId);
        Task<InvoiceDetails?> UpdateInvoiceDetails(int invoiceDetailsId, InvoiceDetails updatedInvoiceDetails);
        Task<IEnumerable<InvoiceDetails>> GetDetails(int invoiceID);
    }
}
