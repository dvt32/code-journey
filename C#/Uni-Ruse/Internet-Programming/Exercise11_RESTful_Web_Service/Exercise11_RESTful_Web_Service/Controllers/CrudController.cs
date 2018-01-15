using Exercise11_RESTful_Web_Service.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web;
using System.Web.Http;

namespace Exercise11_RESTful_Web_Service.Controllers
{
    public class CrudController : ApiController
    {
        static List<Order> orders = new List<Order>();

        /*
         * GET
         */
        // api/Crud
        public IEnumerable<Order> Get()
        {
            return orders;
        }

        // api/Crud/5
        public Order Get(int id)
        {
            foreach (Order order in orders)
            {
                if (order.Id == id)
                {
                    return order;
                }
            }

            return null;
        }

        /*
         * POST
         */
        // api/Crud
        public HttpResponseMessage Post([FromBody]Order order)
        {
            if (ModelState.IsValid)
            {
                orders.Add(order);
                HttpResponseMessage response = Request.CreateResponse(HttpStatusCode.Created, "Order with id " + order.Id + " successfully added!");
                response.Headers.Add("Location", HttpContext.Current.Request.Url.AbsolutePath + order.Id);
                return response;
            }

            return Request.CreateResponse(HttpStatusCode.BadRequest, "Failed to add this element!");
        }

        /*
         * PUT
         */
        // PUT: api/Crud/5
        public String Put(int id, [FromBody]Order updatedOrder)
        {
            for (int i = 0; i < orders.Count; ++i)
            {
                if (orders[i].Id == id)
                {
                    orders[i] = updatedOrder;
                    return "Order with id " + id + " successfully updated!";
                }
            }

            return "Couldn't find element with id " + id + "!";
        }

        /*
         * DELETE
         */
        // DELETE: api/Crud/5
        public String Delete(int id)
        {
            foreach (Order order in orders)
            {
                if (order.Id == id)
                {
                    orders.Remove(order);
                    return "Element with id " + id + " was successfully removed!";
                }
            }

            return "Couldn't find element with id " + id + "!";
        }
    }
}
