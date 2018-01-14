using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Exercise8_Lambda_LINQ.Models
{
    public class ReservationFilter
    {

        // Filter reservations via built-in Func delegate
        public static IEnumerable<Reservation> Filter(Func<Reservation, bool> lambdaFilter, IEnumerable<Reservation> reservations)
        {
            IEnumerable<Reservation> filteredReservations = reservations.Where(lambdaFilter);
            return filteredReservations;
        }

    }
}