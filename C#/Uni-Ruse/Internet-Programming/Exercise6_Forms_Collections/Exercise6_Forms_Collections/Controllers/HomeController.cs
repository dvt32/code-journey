using Exercise6_Forms_Collections.Models;
using System;
using System.Web.Mvc;

namespace Exercise6_Forms_Collections.Controllers
{
    public class HomeController : Controller
    {
        // GET: Home
        public ActionResult Index()
        {
            return View();
        }

        // GET: All reservations
        public ActionResult ViewReservations()
        {
            return View();
        }

        // Add new reservation
        public ActionResult AcceptReservation(Reservation reservation)
        {
            ReservationDAO reservationDAO = new ReservationDAO();
            reservationDAO.SaveReservationToFile(reservation);
            return Content("Successfully added reservation to file! <br /><br /> <a href=\"/\">Go back home...</a>");
        }
    }
}