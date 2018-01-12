using Exercise7_Delegates_Events.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Web;
using System.Web.Mvc;
using static Exercise7_Delegates_Events.Models.ReservationFilter;

namespace Exercise7_Delegates_Events.Controllers
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

        // GET: Filter reservations
        public ActionResult FilterReservations()
        {
            return View();
        }

        // View filtered reservations - Method #1 Use custom delegate
        /*
        public ActionResult ViewFilteredReservations(String filterMethodName)
        {
            MethodInfo filterMethodInfo = typeof(ReservationFilter).GetMethod(filterMethodName, BindingFlags.Static | BindingFlags.Instance | BindingFlags.NonPublic);
            FilterDelegate filter = (FilterDelegate) Delegate.CreateDelegate(typeof(FilterDelegate), filterMethodInfo);

            ViewBag.filteredReservations = ReservationFilter.Filter(filter, new ReservationDAO().GetReservationsFromFile());

            return View();
        }
        */

        // View filtered reservations - Method #2 Use built-in Func delegate
        public ActionResult ViewFilteredReservations(String filterMethodName)
        {
            MethodInfo filterMethodInfo = typeof(ReservationFilter).GetMethod(filterMethodName, BindingFlags.Static | BindingFlags.Instance | BindingFlags.NonPublic);
            Func<Reservation, bool> filter = (Func<Reservation, bool>) Delegate.CreateDelegate(typeof(Func<Reservation, bool>), filterMethodInfo);

            ViewBag.filteredReservations = ReservationFilter.Filter(filter, new ReservationDAO().GetReservationsFromFile());

            return View();
        }
    }
}