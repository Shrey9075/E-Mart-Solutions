using Emart_final.Repository;
using Emart_final.service.Cartfolder;
using Emart_final.service.Categoryfolder;
using Emart_final.service.ConfigDetailsfolder;
using Emart_final.service.Configfolder;
using Emart_final.service.Customerfolder;
using Emart_final.service.InvoiceDetailsFolder;
using Emart_final.service.Invoicefolder;
using Emart_final.service.Orderfolder;
using Emart_final.service.Productfolder;
using Microsoft.EntityFrameworkCore;

namespace Emart_final
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var builder = WebApplication.CreateBuilder(args);

            // Add services to the container.

            builder.Services.AddControllers();
            builder.Services.AddTransient<ICategoryService, CategoryService>();
            builder.Services.AddTransient<ICartService, CartService>();
            builder.Services.AddTransient<ICustomerService, CustomerService>();
            builder.Services.AddTransient<IInvoiceService, InvoiceService>();
            builder.Services.AddTransient<IInvoiceDetailsService, InvoiceDetailsService>();
            builder.Services.AddTransient<IOrderService, OrderService>();
            builder.Services.AddTransient<IProductService, ProductService>();
            builder.Services.AddTransient<IConfigDetailsService, ConfigDetailsService>();
            builder.Services.AddTransient<IConfigService, ConfigService>();

            builder.Services.AddDbContext<AppDbContext>(option => option.UseMySQL(builder.Configuration.GetConnectionString("EmartDBConnection")));
            //builder.Services.AddDbContext<AppDbContext>(option => option.UseSqlServer(builder.Configuration.GetConnectionString("EmartDBConnection")));
            // Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
            builder.Services.AddEndpointsApiExplorer();
            builder.Services.AddSwaggerGen();
            builder.Services.AddCors(options =>
            {
                options.AddPolicy("MyAllowSpecificOrigins", builder =>
                {
                    builder.WithOrigins("*")
                    .AllowAnyHeader()
                    .AllowAnyMethod();
                });
            });

            var app = builder.Build();

            // Configure the HTTP request pipeline.
            if (app.Environment.IsDevelopment())
            {
                app.UseSwagger();
                app.UseSwaggerUI();
            }

            app.UseHttpsRedirection();

            app.UseAuthorization();
            app.UseCors("MyAllowSpecificOrigins");


            app.MapControllers();

            app.Run();
        }
    }
}