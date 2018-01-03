using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Helpers;
using System.Web.Mvc;

namespace Exercise4_ASP_NET.Controllers
{
    public class HomeController : Controller
    {
        // GET: Index
        public ActionResult Index()
        {
            return View();
        }

        // GET: Schedule
        public ActionResult Schedule()
        {
            return View();
        }

        // GET: New movies
        public ActionResult New_Movies()
        {
            return View();
        }

        // GET: Trailers
        public ActionResult Trailers(int? id)
        {
            ViewBag.trailerId = id;

            return View();
        }

        // GET: Reserve Tickets
        public ActionResult Reserve()
        {
            return View();
        }

        class MovieSchedule
        {
            public Boolean isCurrentWeek { get; set; }
            public String description { get; set; }
        }

        public ActionResult GetJsonMovieSchedule()
        {
            MovieSchedule schedule = new MovieSchedule { isCurrentWeek = true, description = "Movie schedule description goes here" };
            return Json(schedule, JsonRequestBehavior.AllowGet);
        }

        public ActionResult Register()
        {
            return new HttpStatusCodeResult(System.Net.HttpStatusCode.NotImplemented);
        }

        public ActionResult Comments()
        {
            return null;
        }

        


    }
}
 
 
 