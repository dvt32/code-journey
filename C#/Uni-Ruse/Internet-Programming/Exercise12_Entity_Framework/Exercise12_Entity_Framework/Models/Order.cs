using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Exercise12_Entity_Framework.Models
{
    public class Order
    {
        public int Id { get; set; }
        public String Date { get; set; }
        public String Client { get; set; }
        public String ModifiedBy { get; set; }
        public double TotalSum { get; set; }
        public List<Product> Products { get; set; }
    }
}