using Exercise8_Lambda_LINQ.Models;
using System;
using System.Web.Mvc;
using System.Linq;
using System.Collections.Generic;

namespace Exercise8_Lambda_LINQ.Controllers
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

        // View filtered reservations via built-in Func delegate
        public ActionResult ViewFilteredReservations(String orderType, String lambdaFilterName)
        {
            Func<Reservation, bool> lambdaFilter = null;
            switch (lambdaFilterName)
            {
                case "HasHotelMessage":
                    lambdaFilter = ( res => (res.Message != null && res.Message.Length != 0) );
                    break;
                case "IsOnePersonReservation":
                    lambdaFilter = ( res => (res.RoomType.Equals("1 person")) );
                    break;
                case "IsTwoPeopleReservation":
                    lambdaFilter = ( res => (res.RoomType.Equals("2 people")) );
                    break;
                case "IsThreePeopleReservation":
                    lambdaFilter = ( res => (res.RoomType.Equals( "3 people")) );
                    break;
                default: break;
            }

            IEnumerable<Reservation> filteredReservations = ReservationFilter.Filter(lambdaFilter, new ReservationDAO().GetReservationsFromFile());
            switch (orderType)
            {
                case "ByRoomTypeAsc":
                    filteredReservations = filteredReservations.OrderBy(res => res.RoomType);
                    break;
                case "ByRoomTypeDesc":
                    filteredReservations = filteredReservations.OrderByDescending(res => res.RoomType);
                    break;
                case "ByFullNameAsc":
                    filteredReservations = filteredReservations.OrderBy(res => res.FullName);
                    break;
                case "ByFullNameDesc":
                    filteredReservations = filteredReservations.OrderByDescending(res => res.FullName);
                    break;
                default: break;
            }
            ViewBag.filteredReservations = filteredReservations;

            int numberOfFilteredReservations = filteredReservations.Count();
            ViewBag.numberOfFilteredReservations = numberOfFilteredReservations;

            return View();
        }
    }
}