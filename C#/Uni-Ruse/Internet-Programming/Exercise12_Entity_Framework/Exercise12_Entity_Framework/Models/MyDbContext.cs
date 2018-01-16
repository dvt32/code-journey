using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace Exercise12_Entity_Framework.Models
{
    public class MyDbContext : DbContext
    {
        public DbSet<Order> Orders { get; set; }
    }

}