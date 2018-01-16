using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Exercise12_Entity_Framework.Models
{
    public class Product
    {
        public int Id { get; set; }
        public String Name { get; set; }
        public int NumberOfOrders { get; set; }
        public double SinglePrice { get; set; }
    }
}